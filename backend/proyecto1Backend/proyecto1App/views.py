from rest_framework import serializers, viewsets, status
from rest_framework.views import APIView
from rest_framework.response import Response
from .models import Code
from .parserYscanner.yaplLexer import yaplLexer
from .parserYscanner.yaplParser import yaplParser
from .parserYscanner.yaplListener import yaplListener
from .parserYscanner.yaplVisitor import yaplVisitor
from antlr4 import *
from antlr4 import InputStream, CommonTokenStream
from antlr4.error.ErrorListener import ErrorListener
from graphviz import Digraph
import re


def visualize_tree(tree, filename):
    graph = Digraph(comment='YAPL Syntax Tree')
    build_graph(tree, graph)
    graph.render(filename, view=False)


def build_graph(tree, graph, parent=None):
    if tree.getText():
        node = str(hash(tree))
        graph.node(node, tree.getText())
        if parent:
            graph.edge(parent, node)
        for i in range(tree.getChildCount()):
            build_graph(tree.getChild(i), graph, node)


class CustomErrorListener(ErrorListener):
    def __init__(self):
        self.errors = []
        self.table = SymbolTable()

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        # Personalizar el mensaje de error para el análisis sintáctico
        # print(msg)
        # print(offendingSymbol.text)
        print(msg)
        if "extraneous input" in msg:
            print(
                f"Error en la línea {line}, {offendingSymbol.text}; Entrada no esperada.")
        elif "no viable alternative at input" in msg:
            print(
                f"Error en la línea {line}, {offendingSymbol.text}; Entrada no reconocida.")
        elif "missing ';' at" in msg:
            print(f"Error en la línea {line}, Falta ';' en la entrada.")
        elif "mismatched input" in msg:
            print(
                f"Error en la línea {line}, Entrada {offendingSymbol.text} no coincide con lo esperado.")
            # self.errors.append(
            #     f"ERROR sintáctico en línea {line}, columna {column}: Entrada {offendingSymbol.text} no coincide con lo esperado.")
        else:
            print(
                f"Error de sintaxis en la línea {line}, posición {column}: {msg}")
        if isinstance(recognizer, yaplLexer):
            err = msg.split("'")[1]
            self.errors.append(
                f"ERROR léxico en línea {line}, columna {column}: Carácter inesperado -> '{err}'")
        # else:
        #     if offendingSymbol.text not in self.table.scopes[-1]:
        #         # self.errors.append(
        #         #     f"ERROR semántico en línea {line}, columna {column}: {offendingSymbol.text} no ha sido declarado")
        #         print(
        #             f"ERROR semántico en línea {line}, columna {column}: {offendingSymbol.text} no ha sido declarado")
        #     else:
        #         # self.errors.append(
        #         #     f"ERROR sintáctico en línea {line}, columna {column}: {msg}")
        #         print(
        #             f"ERROR sintáctico en línea {line}, columna {column}: {msg}")


class SymbolTable:
    def __init__(self):
        self.scopes = [{}]

    def enter_scope(self):
        self.scopes.append({})

    def exit_scope(self):
        if len(self.scopes) > 1 and self.scopes[-1] == {}:
            self.scopes.pop()
        else:
            print("Warning: Trying to exit the global scope!")

    def declare(self, symbol, type, line=None, column=None):
        # print(self.scopes)
        if symbol in self.scopes[-1]:
            print(
                f"Simbolo {symbol} ya fue declarado en la linea {line}, columna {column}")
        self.scopes[-1][symbol] = {'tipo': type,
                                   'linea': line, 'columna': column}
        # if type == "int":
        #     self.scopes[-1][symbol]['size'] = 4
        # elif type == "string":
        #     self.scopes[-1][symbol]['size'] = 8
        # elif type == "bool":
        #     self.scopes[-1][symbol]['size'] = 1

        return None

    def lookup(self, symbol):
        for scope in reversed(self.scopes):
            if symbol in scope:
                return scope[symbol]
        return None

    def is_declared(self, symbol, current_scope_only=False):
        if current_scope_only:
            return symbol in self.scopes[-1]
        return any(symbol in scope for scope in self.scopes)


# ARREGLAR ERRORES SINTÁCTICOS, LO DE NEW, VER LO DE LAS LLAMADAS DE METODOS HEREDADOS Y CON PUNTOS
class MyListener(yaplListener):
    def __init__(self, error_listener):
        self.symbol_table = SymbolTable()
        self.error_listener = error_listener
        self.inside_block = False
        self.block_depth = 0
        self.class_name = ''
        self.block_bracket_count = 0
        self.method_type = ''
        self.method_params = {}

    def declareSymbol(self, ctx, symbol, symbol_type):
        """Maneja símbolos, ya sea para declarar o verificar su uso."""
        line = ctx.start.line
        column = ctx.start.column

        # Si symbol_type no es None, estamos declarando el símbolo
        print(symbol_type, symbol)
        if symbol_type:
            # print(self.method_params)
            if self.symbol_table.is_declared(symbol, current_scope_only=False):
                for key, value in self.method_params.items():
                    # print(key, value)
                    if symbol in value['parametros']:
                        print("ya ha sido declarado pero como parametro")
                        print(f"Declarando {symbol} como {symbol_type}")
                        self.symbol_table.declare(
                            symbol, symbol_type, line, column)
                        self.error_listener.errors = []
                        break
                    else:
                        self.error_listener.errors.append(
                            f"ERROR semántico en línea {line}: {column}. {symbol} ya ha sido declarado como <{symbol_type}>.")
            else:
                print(f"Declarando {symbol} como {symbol_type}")
                self.symbol_table.declare(
                    symbol, symbol_type, line, column)
                # print(self.symbol_table.scopes)
        # Si symbol_type es None, estamos usando el símbolo y necesitamos verificar que ha sido declarado
        else:
            print(f"Verificando que {symbol} ha sido declarado")
            if not self.symbol_table.is_declared(symbol, current_scope_only=True):
                self.error_listener.errors.append(
                    f"ERROR semántico en línea {line}:{column} -> Uso de {symbol} que no ha sido declarado.")

    def accessSymbol(self, ctx, symbol):
        """Maneja el acceso a símbolos, ya sea para uso o para asignación."""
        line = ctx.start.line
        column = ctx.start.column
        if not self.symbol_table.is_declared(symbol):
            self.error_listener.errors.append(
                f"ERROR semántico en línea {line}:{column} -> Uso de {symbol} que no ha sido declarado.")
        else:
            self.symbol_table.lookup(symbol)['usado'] = True

    def enterProgram(self, ctx: yaplParser.ProgramContext):
        print("\nEntrando en Program")
        # self.symbol_table.enter_scope()

    def exitProgram(self, ctx: yaplParser.ProgramContext):
        print("Saliendo de Program\n")
        is_main_class = False
        is_main_method = False
        for scope in self.symbol_table.scopes:
            for key, value in scope.items():
                if key == "Main":
                    # print("Main encontrado")
                    is_main_class = True
                elif key == "main":
                    # print("main encontrado")
                    is_main_method = True
        if not is_main_class:
            self.error_listener.errors.append(
                "ERROR semántico -> No se ha encontrado la clase Main.")
        if not is_main_method:
            self.error_listener.errors.append(
                "ERROR semántico -> No se ha encontrado el método main.")

        # self.symbol_table.exit_scope()
        # print(self.symbol_table.scopes)

    def enterClassDeclaration(self, ctx: yaplParser.ClassDeclarationContext):
        print("Entrando en ClassDeclaration")
        self.symbol_table.enter_scope()  # Nuevo ámbito para la clase
        class_name = ctx.TYPE_ID()[0].getText()
        self.class_name = class_name
        self.declareSymbol(ctx, class_name, "class")
        if len(ctx.TYPE_ID()) > 1:
            inherits = ctx.TYPE_ID()[1].getText()
            print(inherits)
            if class_name == "Main" and (inherits != "IO" and inherits != "Object" and inherits != "String"):
                self.error_listener.errors.append(
                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> La clase principal Main no puede heredar de otra clase que no sea IO u Object.")
            elif class_name == "IO":
                self.error_listener.errors.append(
                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> Una clase no puede llamarse IO.")

            if inherits == "IO":
                print("hereda de IO")
                self.declareSymbol(ctx, "out_string", "method: self")
                self.method_params["out_string"] = {
                    'tipo': "self", 'parametros': {"x": "string"}}
                self.declareSymbol(ctx, "out_int", "method: self")
                self.method_params["out_int"] = {
                    'tipo': "self", 'parametros': {"x": "int"}}
                self.declareSymbol(ctx, "in_string", "method: string")
                self.declareSymbol(ctx, "in_int", "method: int")
            elif inherits == "Object":
                print("hereda de Object")
                self.declareSymbol(ctx, "abort", "method: Object")
                self.declareSymbol(ctx, "type_name", "method: string")
                self.declareSymbol(ctx, "copy", "method: self")
            elif inherits == "String":
                print("hereda de String")
                self.declareSymbol(ctx, "length", "method: int")
                self.declareSymbol(ctx, "concat", "method: string")
                self.method_params["concat"] = {
                    'tipo': "string", 'parametros': {"s": "string"}}
                self.declareSymbol(ctx, "substr", "method: string")
                self.method_params["substr"] = {
                    'tipo': "string", 'parametros': {"i": "int", "l": "int"}
                }
            elif self.symbol_table.is_declared(inherits):
                print(f"{inherits} es una clase")
            else:
                print(f"{inherits} no es una clase")
                self.error_listener.errors.append(
                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> {inherits} no es una clase declarada.")

    def exitClassDeclaration(self, ctx: yaplParser.ClassDeclarationContext):
        print("Saliendo de ClassDeclaration")
        class_name = ctx.TYPE_ID()[0].getText()
        print(ctx.RBRACE())
        # if ctx.RBRACE().getText() == "}":
        #     print("LLAVE DE CIERRE class")
        #     self.class_bracket_count -= 1
        #     print(self.class_bracket_count)
        # if self.class_bracket_count != 0:
        #     print("FALTA UNA LLAVE DE CIERRE")
        # self.error_listener.errors.append(
        #     f"ERROR sintáctico en línea {ctx.start.line}:{ctx.start.column} -> Falta llave de cierre de la clase {class_name}.")
        self.symbol_table.exit_scope()  # Salir del ámbito de la clase
        # self.symbol_table.enter_scope()
        # print(self.symbol_table.scopes)

    def enterMethodDeclaration(self, ctx: yaplParser.MethodDeclarationContext):
        print("Entrando en MethodDeclaration")
        self.symbol_table.enter_scope()  # Nuevo ámbito para el método
        method_name = ctx.ID().getText()
        # Esto devuelve el texto del tipo
        method_type = ctx.getChild(0).getText()
        self.declareSymbol(ctx, method_name, "method: " +
                           method_type)
        self.method_type = method_type
        params = ctx.parameterList()
        self.method_params[method_name] = {
            'tipo': method_type, 'parametros': {}}
        if params:
            print(ctx.parameterList().getText())
            for param in params.parameter():
                param_name = param.ID().getText()
                param_type = param.getChild(0).getText()
                print(param_name, param_type, "32")
                self.method_params[method_name]['parametros'][param_name] = param_type
                self.declareSymbol(ctx, param_name, param_type)
                print(self.method_params)

    def exitMethodDeclaration(self, ctx: yaplParser.MethodDeclarationContext):
        print("Saliendo de MethodDeclaration")
        self.method_type = ''
        # self.symbol_table.exit_scope()  # Salir del ámbito del método
        # print(self.symbol_table.scopes)

    def enterMethodCallStatement(self, ctx: yaplParser.MethodCallStatementContext):
        print("Entrando en MethodCallStatement")
        method_name = ctx.ID().getText()
        print(method_name)
        params = ctx.expressionList()
        # print(params.getText())
        # print(self.method_params)
        if self.symbol_table.is_declared(method_name):
            print("metodo declarado")
            if self.symbol_table.lookup(method_name)['tipo'].startswith("method:"):
                print("es un metodo")
                if self.symbol_table.lookup(method_name)['tipo'] == "method: self":
                    print("es un metodo de la clase")
                    if method_name == "out_int" and method_name in self.method_params:
                        for param in params.expression():
                            param_name = param.getText()
                            print("name", param_name)
                            if self.symbol_table.is_declared(param_name):
                                param_type = self.symbol_table.lookup(param_name)[
                                    'tipo']
                                if param_type == "int":
                                    print("parametro correcto")
                                else:
                                    self.error_listener.errors.append(
                                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El método <{method_name}> requiere parámetros de tipo <int>.")
                            else:
                                if param_name.isnumeric():
                                    print("parametro correcto")
                                else:
                                    self.error_listener.errors.append(
                                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El método <{method_name}> requiere parámetros de tipo <int>.")
                    elif method_name == "out_string" and method_name in self.method_params:
                        for param in params.expression():
                            param_name = param.getText()
                            print("name", param_name)
                            if self.symbol_table.is_declared(param_name):
                                param_type = self.symbol_table.lookup(param_name)[
                                    'tipo']
                                if param_type == "string":
                                    print("parametro correcto")
                                else:
                                    self.error_listener.errors.append(
                                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El método <{method_name}> requiere parámetros de tipo <string>.")
                            else:
                                if param_name.startswith('"') and param_name.endswith('"'):
                                    print("parametro correcto")
                                else:
                                    self.error_listener.errors.append(
                                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El método <{method_name}> requiere parámetros de tipo <string>.")
                else:
                    print("es un metodo heredado")
                    if method_name in self.method_params:
                        if self.method_params[method_name]['parametros'] == {}:
                            print("no necesita parametros")
                            if params:
                                self.error_listener.errors.append(
                                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El método <{method_name}> no requiere parámetros.")
                        elif params:
                            # print(ctx.expressionList().getText())
                            for param in params.expression():
                                if param.getText().isnumeric():
                                    print("parametro numerico")
                                    for key, value in self.method_params[method_name]['parametros'].items():
                                        print(key, value)
                                        if value == "int":
                                            print("parametro correcto")
                                            for scope in self.symbol_table.scopes:
                                                print(scope)
                                                if method_name in scope:
                                                    if key in scope:
                                                        scope[key]['valor'] = param.getText(
                                                        )
                                                        scope[key]['usado'] = True
                                        else:
                                            self.error_listener.errors.append(
                                                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método <{method_name}> es <{value}> y se le está pasando un parametro <{param.getText()}> tipo <int>.")
                                elif param.getText().startswith('"') and param.getText().endswith('"'):
                                    print("parametro string")
                                    for key, value in self.method_params[method_name]['parametros'].items():
                                        if value == "string":
                                            print("parametro correcto")
                                        else:
                                            self.error_listener.errors.append(
                                                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método <{method_name}> es <{value}> y se le está pasando un parametro <{param.getText()}> tipo <string>.")
                                elif param.getText() == "true" or param.getText() == "false":
                                    print("parametro bool")
                                    for key, value in self.method_params[method_name]['parametros'].items():
                                        if value == "bool":
                                            print("parametro correcto")
                                        else:
                                            self.error_listener.errors.append(
                                                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método <{method_name}> es <{value}> y se le está pasando un parametro <{param.getText()}> tipo <bool>.")
                                elif param.ID():
                                    param_name = param.ID().getText()
                                    print("name", param_name)
                                    param_type = self.symbol_table.lookup(param_name)[
                                        'tipo']
                                    print("type", param_type)
                                    print(self.method_params)
                                    for key, value in self.method_params[method_name]['parametros'].items():
                                        if param_name == key or param_type == self.method_params[method_name]['parametros'][key]:
                                            print("parametro correcto")
                                            for scope in self.symbol_table.scopes:
                                                print(scope)
                                                if method_name in scope:
                                                    if key in scope:
                                                        scope[key]['valor'] = param_name
                                        else:
                                            self.error_listener.errors.append(
                                                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método <{method_name}> es <{value}> y se le está pasando un parametro <{param_name}> tipo <{param_type}>.")
                                    if param_name and self.method_params[method_name]['parametros'] == {}:
                                        print(
                                            "hay parametros y no necesita parametros")
                                        self.error_listener.errors.append(
                                            f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El método <{method_name}> no requiere parámetros.")

                        elif not params and self.method_params[method_name]['parametros'] == {}:
                            print("no hay parametros y no necesita parametros")
                        else:
                            self.error_listener.errors.append(
                                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El método <{method_name}> requiere parámetros de tipo <{self.method_params[method_name]['tipo']}>.")
            else:
                self.error_listener.errors.append(
                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> {method_name} no es un método.")
        else:
            self.error_listener.errors.append(
                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> {method_name} no ha sido declarado.")
        # self.symbol_table.enter_scope()

    def exitMethodCallStatement(self, ctx: yaplParser.MethodCallStatementContext):
        print("Saliendo de MethodCallStatement")
        # self.symbol_table.exit_scope()

    def enterClassMethodCallExpression(self, ctx: yaplParser.ClassMethodCallExpressionContext):
        print("Entrando en ClassMethodCallExpression")
        expr = ctx.expression().getText()
        symbol = ctx.ID().getText()
        print(expr, symbol)
        if self.symbol_table.is_declared(expr, current_scope_only=True):
            expr_type = self.symbol_table.lookup(expr)['tipo']
            print(expr_type)
            if self.symbol_table.is_declared(expr_type):
                if self.symbol_table.lookup(expr_type)['tipo'] == "class":
                    if self.symbol_table.is_declared(symbol):
                        print("metodo declarado")
            elif expr_type == "string":
                if symbol == "length":
                    print("length")
                elif symbol == "concat":
                    print("concat")
                    print(ctx.expressionList().getText())
                    if ctx.expressionList():
                        for param in ctx.expressionList().expression():
                            param_name = param.getText()
                            print("name", param_name)
                            if self.symbol_table.is_declared(param_name):
                                param_type = self.symbol_table.lookup(param_name)[
                                    'tipo']
                                if param_type == "string":
                                    print("parametro correcto")
                                else:
                                    self.error_listener.errors.append(
                                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El método <{symbol}> requiere parámetros de tipo <string>.")
                            else:
                                if param_name.startswith('"') and param_name.endswith('"'):
                                    print("parametro correcto")
                                else:
                                    self.error_listener.errors.append(
                                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El método <{symbol}> requiere parámetros de tipo <string>.")
                elif symbol == "substr":
                    print("substr")
                    print(ctx.expressionList().getText())
                    if ctx.expressionList():
                        for param in ctx.expressionList().expression():
                            param_name = param.getText()
                            print("name", param_name)
                            if self.symbol_table.is_declared(param_name):
                                param_type = self.symbol_table.lookup(param_name)[
                                    'tipo']
                                if param_type == "int":
                                    print("parametro correcto")
                                else:
                                    self.error_listener.errors.append(
                                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El método <{symbol}> requiere parámetros de tipo <int>.")
                            else:
                                if param_name.isnumeric():
                                    print("parametro correcto")
                                else:
                                    self.error_listener.errors.append(
                                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El método <{symbol}> requiere parámetros de tipo <int>.")
                else:
                    self.error_listener.errors.append(
                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> {symbol} no es un método de la clase {expr_type}.")

            else:
                self.error_listener.errors.append(
                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> {expr_type} no es una clase que ha sido declarada.")

    def exitClassMethodCallExpression(self, ctx: yaplParser.ClassMethodCallExpressionContext):
        print("Saliendo de ClassMethodCallExpression")

    def enterBlock(self, ctx: yaplParser.BlockContext):
        print("Entrando en Block")
        # self.symbol_table.enter_scope()  # Nuevo ámbito para el bloque
        # print(self.symbol_table.scopes)
        self.inside_block = True
        self.block_depth += 1
        print(ctx.getText())
        if ctx.LBRACE().getText() != "{":
            print("FALTA UNA LLAVE DE APERTURA")
            self.error_listener.errors.append(
                f"ERROR sintáctico en línea {ctx.start.line}:{ctx.start.column} -> Falta llave de apertura del bloque.")

    def exitBlock(self, ctx: yaplParser.BlockContext):
        print("Saliendo de Block")
        self.inside_block = False
        self.block_depth -= 1
        if ctx.RBRACE().getText() != "}":
            print("FALTA UNA LLAVE DE CIERRE")
            self.error_listener.errors.append(
                f"ERROR sintáctico en línea {ctx.start.line}:{ctx.start.column} -> Falta llave de cierre del bloque.")
        # self.symbol_table.exit_scope()  # Salir del ámbito del bloque
        # print(self.symbol_table.scopes)

    def enterVariableDeclaration(self, ctx: yaplParser.VariableDeclarationContext):
        if self.block_depth > 0:  # Solo si estamos dentro de un bloque
            print("Declaración de variable dentro de un bloque")
            # self.symbol_table.enter_scope()  # Nuevo ámbito para la variable
            print(self.block_depth)
            symbol = ctx.ID().getText()
            # print(symbol)
            type_ctx = ctx.getChild(0)
            type_text = type_ctx.getText()  # Esto devuelve el texto del tipo
            self.declareSymbol(ctx, symbol, type_text)
            if ctx.statement():
                print('asigna diuna', ctx.statement().getText())
                expression = ctx.statement().getText()[:-1]
                for scope in self.symbol_table.scopes:
                    # print(scope)
                    if symbol in scope:
                        scope[symbol]['valor'] = expression
                        scope[symbol]['usado'] = True
        else:
            type_ctx = ctx.type_().getText()
            name = ctx.ID().getText()
            if ctx.statement():
                expression = ctx.statement().getText()
                if expression.isnumeric() and type_ctx != "int":
                    self.error_listener.errors.append(
                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> {name} es de tipo {type_ctx} pero se le está asignando un valor de tipo int.")
                elif (expression[0] == '"' and expression[-1] == '"') and type_ctx != "string":
                    self.error_listener.errors.append(
                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> {name} es de tipo {type_ctx} pero se le está asignando un valor de tipo string.")
                elif (expression == "true" or expression == "false") and type_ctx != "bool":
                    self.error_listener.errors.append(
                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> {name} es de tipo {type_ctx} pero se le está asignando un valor de tipo bool.")
                else:
                    self.declareSymbol(ctx, name, type_ctx)

    def exitVariableDeclaration(self, ctx: yaplParser.VariableDeclarationContext):
        if self.block_depth > 0:  # Solo si estamos dentro de un bloque
            print("Saliendo de  VariableDeclaration")
            # self.symbol_table.exit_scope()

    def enterAttributeDeclaration(self, ctx: yaplParser.AttributeDeclarationContext):
        print("Entrando en AttributeDeclaration")
        symbol = ctx.ID().getText()
        # Esto devuelve el primer hijo, que debe ser el contexto de 'type'
        type_ctx = ctx.getChild(0)
        type_text = type_ctx.getText()  # Esto devuelve el texto del tipo
        self.declareSymbol(ctx, symbol, type_text)
        print("sexo", ctx.SEMI().getText())
        if ctx.SEMI().getText() != ";":
            print("FALTA UN PUNTO Y COMA")

    def exitAttributeDeclaration(self, ctx: yaplParser.AttributeDeclarationContext):
        print("Saliendo de AttributeDeclaration")

    def enterAssignmentDeclaration(self, ctx: yaplParser.AssignmentDeclarationContext):
        print("Entrando en AssignmentDeclaration")
        # self.symbol_table.enter_scope()  # Nuevo ámbito para la asignación
        symbol = ctx.ID().getText()
        self.accessSymbol(ctx, symbol)

    def exitAssignmentDeclaration(self, ctx: yaplParser.AssignmentDeclarationContext):
        print("Saliendo de AssignmentDeclaration")
        # self.symbol_table.exit_scope()

    def enterIfStatement(self, ctx: yaplParser.IfStatementContext):
        print("Entrando en IfStatement")
        expression = ctx.expression().getText()
        print(expression)
        operators = ["==", "!=", "<", ">", "<=", ">="]
        for operator in operators:
            if operator in expression:
                variables = re.split(operator, expression)
                print("variables", variables, operator)
                if operator == "==" or operator == "!=":
                    if self.symbol_table.is_declared(variables[0]):
                        if self.symbol_table.is_declared(variables[1]):
                            if self.symbol_table.lookup(variables[0])['tipo'] == self.symbol_table.lookup(variables[1])['tipo']:
                                print("variables son del mismo tipo")
                            else:
                                self.error_listener.errors.append(
                                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede comparar entre tipos de datos diferentes. {variables[0]} es de tipo <{self.symbol_table.lookup(variables[0])['tipo']}> y {variables[1]} es de tipo <{self.symbol_table.lookup(variables[1])['tipo']}>")
                        elif variables[1].isnumeric():
                            print(variables[1], "es un numero")
                            if self.symbol_table.lookup(variables[0])['tipo'] == "int":
                                print("variables son del mismo tipo")
                            else:
                                self.error_listener.errors.append(
                                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede comparar entre tipos de datos diferentes. {variables[0]} es de tipo <{self.symbol_table.lookup(variables[0])['tipo']}> y {variables[1]} es de tipo <int>")
                        elif variables[1].startswith('"') and variables[1].endswith('"'):
                            print(variables[1], "es un string")
                            if self.symbol_table.lookup(variables[0])['tipo'] == "string":
                                print("variables son del mismo tipo")
                            else:
                                self.error_listener.errors.append(
                                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede comparar entre tipos de datos diferentes. {variables[0]} es de tipo <{self.symbol_table.lookup(variables[0])['tipo']}> y {variables[1]} es de tipo <string>")
                        elif variables[1] == "true" or variables[1] == "false":
                            print(variables[1], "es un booleano")
                            if self.symbol_table.lookup(variables[0])['tipo'] == "bool":
                                print("variables son del mismo tipo")
                            else:
                                self.error_listener.errors.append(
                                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede comparar entre tipos de datos diferentes. {variables[0]} es de tipo <{self.symbol_table.lookup(variables[0])['tipo']}> y {variables[1]} es de tipo <bool>")
                        else:
                            self.error_listener.errors.append(
                                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> Uso de {variables[1]} que no ha sido declarado.")
                elif operator == ">=" or operator == "<=" or operator == ">" or operator == "<":
                    if self.symbol_table.is_declared(variables[0]) and self.symbol_table.is_declared(variables[1]):
                        if self.symbol_table.lookup(variables[0])['tipo'] == self.symbol_table.lookup(variables[1])['tipo']:
                            print("variables son del mismo tipo")
                        elif variables[1].isnumeric():
                            print(variables[1], "es un numero")
                            if self.symbol_table.lookup(variables[0])['tipo'] == "int":
                                print("variables son del mismo tipo")
                            else:
                                self.error_listener.errors.append(
                                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede comparar entre tipos de datos diferentes. {variables[0]} es de tipo <{self.symbol_table.lookup(variables[0])['tipo']}> y {variables[1]} es de tipo <int>")
                        else:
                            self.error_listener.errors.append(
                                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede comparar entre tipos de datos diferentes. {variables[0]} es de tipo <{self.symbol_table.lookup(variables[0])['tipo']}> y {variables[1]} es de tipo <int>")
        # block
        # self.symbol_table.enter_scope()  # Nuevo ámbito para el bloque

    def exitIfStatement(self, ctx: yaplParser.IfStatementContext):
        print("Saliendo de IfStatement")
        # self.symbol_table.exit_scope()  # Salir del ámbito del bloque

    def enterWhileStatement(self, ctx: yaplParser.WhileStatementContext):
        print("Entrando en WhileStatement")
        expression = ctx.expression().getText()
        print(expression)
        operators = ["==", "!=", "<", ">", "<=", ">="]
        for operator in operators:
            if operator in expression:
                variables = re.split(operator, expression)
                print("variables", variables, operator)
                if operator == "==" or operator == "!=":
                    if self.symbol_table.is_declared(variables[0]):
                        if self.symbol_table.is_declared(variables[1]):
                            if self.symbol_table.lookup(variables[0])['tipo'] == self.symbol_table.lookup(variables[1])['tipo']:
                                print("variables son del mismo tipo")
                            else:
                                self.error_listener.errors.append(
                                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede comparar entre tipos de datos diferentes. {variables[0]} es de tipo <{self.symbol_table.lookup(variables[0])['tipo']}> y {variables[1]} es de tipo <{self.symbol_table.lookup(variables[1])['tipo']}>")
                        elif variables[1].isnumeric():
                            print(variables[1], "es un numero")
                            if self.symbol_table.lookup(variables[0])['tipo'] == "int":
                                print("variables son del mismo tipo")
                            else:
                                self.error_listener.errors.append(
                                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede comparar entre tipos de datos diferentes. {variables[0]} es de tipo <{self.symbol_table.lookup(variables[0])['tipo']}> y {variables[1]} es de tipo <int>")
                        elif variables[1].startswith('"') and variables[1].endswith('"'):
                            print(variables[1], "es un string")
                            if self.symbol_table.lookup(variables[0])['tipo'] == "string":
                                print("variables son del mismo tipo")
                            else:
                                self.error_listener.errors.append(
                                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede comparar entre tipos de datos diferentes. {variables[0]} es de tipo <{self.symbol_table.lookup(variables[0])['tipo']}> y {variables[1]} es de tipo <string>")
                        elif variables[1] == "true" or variables[1] == "false":
                            print(variables[1], "es un booleano")
                            if self.symbol_table.lookup(variables[0])['tipo'] == "bool":
                                print("variables son del mismo tipo")
                            else:
                                self.error_listener.errors.append(
                                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede comparar entre tipos de datos diferentes. {variables[0]} es de tipo <{self.symbol_table.lookup(variables[0])['tipo']}> y {variables[1]} es de tipo <bool>")
                        else:
                            self.error_listener.errors.append(
                                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> Uso de {variables[1]} que no ha sido declarado.")
                elif operator == ">=" or operator == "<=" or operator == ">" or operator == "<":
                    if self.symbol_table.is_declared(variables[0]) and self.symbol_table.is_declared(variables[1]):
                        if self.symbol_table.lookup(variables[0])['tipo'] == self.symbol_table.lookup(variables[1])['tipo']:
                            print("variables son del mismo tipo")
                        elif variables[1].isnumeric():
                            print(variables[1], "es un numero")
                            if self.symbol_table.lookup(variables[0])['tipo'] == "int":
                                print("variables son del mismo tipo")
                            else:
                                self.error_listener.errors.append(
                                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede comparar entre tipos de datos diferentes. {variables[0]} es de tipo <{self.symbol_table.lookup(variables[0])['tipo']}> y {variables[1]} es de tipo <int>")
                        else:
                            self.error_listener.errors.append(
                                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede comparar entre tipos de datos diferentes. {variables[0]} es de tipo <{self.symbol_table.lookup(variables[0])['tipo']}> y {variables[1]} es de tipo <int>")
        # self.symbol_table.enter_scope()  # Nuevo ámbito para el bloque

    def exitWhileStatement(self, ctx: yaplParser.WhileStatementContext):
        print("Saliendo de WhileStatement")

    def enterReturnStatement(self, ctx: yaplParser.ReturnStatementContext):
        print("Entrando en ReturnStatement")
        print(self.method_type)
        print(self.class_name)
        if ctx.expression():
            expression = ctx.expression().getText()
            print(expression)
            # declaracion local en el metodo
            if self.symbol_table.is_declared(expression, current_scope_only=True):
                print("variable declarada")
                if self.method_type == "int":
                    if expression.isnumeric():
                        print("es un numero")
                    else:
                        if self.symbol_table.is_declared(expression):
                            if self.symbol_table.lookup(expression)['tipo'] != "int":
                                self.error_listener.errors.append(
                                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método es <{self.method_type}> y la expresión es de tipo <{self.symbol_table.lookup(expression)['tipo']}>.")
                elif self.method_type == "string":
                    if expression.startswith('"') and expression.endswith('"'):
                        print("es un string")
                    else:
                        if self.symbol_table.is_declared(expression):
                            if self.symbol_table.lookup(expression)['tipo'] != "string":
                                self.error_listener.errors.append(
                                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método es <{self.method_type}> y la expresión es de tipo <{self.symbol_table.lookup(expression)['tipo']}>.")
                elif self.method_type == "bool":
                    if expression == "true" or expression == "false":
                        print("es un booleano")
                    else:
                        if self.symbol_table.is_declared(expression):
                            if self.symbol_table.lookup(expression)['tipo'] != "bool":
                                self.error_listener.errors.append(
                                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método es <{self.method_type}> y la expresión es de tipo <{self.symbol_table.lookup(expression)['tipo']}>.")
                elif self.method_type == "void":
                    if self.symbol_table.is_declared(expression):
                        if self.symbol_table.lookup(expression)['tipo'] != "void":
                            self.error_listener.errors.append(
                                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método es <{self.method_type}> y la expresión es de tipo <{self.symbol_table.lookup(expression)['tipo']}>.")
            # declaracion global en la clase
            elif self.symbol_table.is_declared(expression):
                for scope in self.symbol_table.scopes:
                    if expression in scope and self.class_name not in scope:
                        self.error_listener.errors.append(
                            f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> Uso de <{expression}> que no ha sido declarado dentro del metodo.")
                        break
                    else:
                        print("variable declarada global")
                        if self.method_type == "int":
                            if expression.isnumeric():
                                print("es un numero")
                            else:
                                if self.symbol_table.is_declared(expression):
                                    if self.symbol_table.lookup(expression)['tipo'] != "int":
                                        self.error_listener.errors.append(
                                            f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método es <{self.method_type}> y la expresión es de tipo <{self.symbol_table.lookup(expression)['tipo']}>.")
                        elif self.method_type == "string":
                            if expression.startswith('"') and expression.endswith('"'):
                                print("es un string")
                            else:
                                if self.symbol_table.is_declared(expression):
                                    if self.symbol_table.lookup(expression)['tipo'] != "string":
                                        self.error_listener.errors.append(
                                            f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método es <{self.method_type}> y la expresión es de tipo <{self.symbol_table.lookup(expression)['tipo']}>.")
                        elif self.method_type == "bool":
                            if expression == "true" or expression == "false":
                                print("es un booleano")
                            else:
                                if self.symbol_table.is_declared(expression):
                                    if self.symbol_table.lookup(expression)['tipo'] != "bool":
                                        self.error_listener.errors.append(
                                            f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método es <{self.method_type}> y la expresión es de tipo <{self.symbol_table.lookup(expression)['tipo']}>.")
                        elif self.method_type == "void":
                            if self.symbol_table.is_declared(expression):
                                if self.symbol_table.lookup(expression)['tipo'] != "void":
                                    self.error_listener.errors.append(
                                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método es <{self.method_type}> y la expresión es de tipo <{self.symbol_table.lookup(expression)['tipo']}>.")
                    break
            elif expression.isnumeric():
                if self.method_type != "int":
                    self.error_listener.errors.append(
                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método es <{self.method_type}> y la expresión es de tipo <int>.")
            elif expression.startswith('"') and expression.endswith('"'):
                if self.method_type != "string":
                    self.error_listener.errors.append(
                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método es <{self.method_type}> y la expresión es de tipo <string>.")
            elif expression == "true" or expression == "false":
                if self.method_type != "bool":
                    self.error_listener.errors.append(
                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método es <{self.method_type}> y la expresión es de tipo <bool>.")
            else:  # ACA HAY QUE VER LO DE LA RECURSIVIDAD
                self.error_listener.errors.append(
                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> Uso de <{expression}> que no ha sido declarado dentro del metodo.")
        else:
            if self.method_type != "void":
                self.error_listener.errors.append(
                    f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> El tipo de retorno del método es <{self.method_type}> y la expresión es de tipo <void>.")
        # self.symbol_table.enter_scope()

    def exitReturnStatement(self, ctx: yaplParser.ReturnStatementContext):
        print("Saliendo de ReturnStatement")
        # self.method_type = ''
        # self.symbol_table.exit_scope()

    def enterExpressionStatement(self, ctx: yaplParser.ExpressionStatementContext):
        print("Entrando en ExpressionStatement")
        expression = ctx.expression()
        print("exp2", expression.getText())
        # check if expression.getText() has either +, -, *, /
        if re.search(r'[\+\-\*\/]', expression.getText()):
            variables = re.split(r'[\+\-\*\/]', expression.getText())
            print("variables", variables)
            if variables[0][-1] == "<":
                # self.enterAssignmentDeclaration(ctx)
                print("es una asignacion")
                self.accessSymbol(ctx, variables[0][:-1])
                for scope in self.symbol_table.scopes:
                    print("sks", scope)
                    if variables[0][:-1] in scope:
                        if variables[1] == variables[0][:-1] or 'out' in variables[1] or 'in' in variables[1]:
                            scope[variables[0][:-1]]['usado'] = True
                            break
                        scope[variables[0][:-1]]['valor'] = variables[1]
                        scope[variables[0][:-1]]['usado'] = True
            else:
                for variable in variables:
                    # check if variable is a number
                    if variable.isnumeric() or variable.isdecimal():
                        print(f"variable {variable} is a number")
                    elif (variable.startswith('"') and variable.endswith('"')):
                        # if both variables are strings then it's ok only if it's a +
                        self.error_listener.errors.append(
                            f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede operar entre tipos de datos diferentes. {variables[0]} es de tipo <int> y {variables[1]} es de tipo <string>.")
                    elif variable == "true" or variable == "false":
                        # if both variables are booleans then it's ok only if it's a ==
                        self.error_listener.errors.append(
                            f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede operar entre tipos de datos diferentes. {variables[0]} es de tipo <int> y {variables[1]} es de tipo <bool>.")
                    elif self.symbol_table.is_declared(variable):
                        print(
                            f"variable {variable} is declared as {self.symbol_table.lookup(variable)['tipo']}")
                        # check if both variables are the same type
                        if self.symbol_table.lookup(variable)['tipo'] != self.symbol_table.lookup(variables[0])['tipo']:
                            self.error_listener.errors.append(
                                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede operar entre tipos de datos diferentes. {variable} es de tipo <{self.symbol_table.lookup(variable)['tipo']}> y {variables[0]} es de tipo <{self.symbol_table.lookup(variables[0])['tipo']}>")
                    else:
                        self.error_listener.errors.append(
                            f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> Uso de {variable} que no ha sido declarado en esa instancia.")
        elif re.search(r'[\=\>\<\!]', expression.getText()):
            variables = re.split(r'[\=\>\<\!]', expression.getText())
            print("variables", variables)
            for variable in variables:
                if variable == "true" or variable == "false":
                    print("valor booleano")
                elif self.symbol_table.is_declared(variable):
                    if self.symbol_table.is_declared(variable, current_scope_only=True):
                        print(
                            f"variable {variable} is declared as {self.symbol_table.lookup(variable)['tipo']}")
                    # check if both variables are the same type
                    else:
                        self.error_listener.errors.append(
                            f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> Uso de {variable} que no ha sido declarado en esa instancia.")
                else:
                    self.error_listener.errors.append(
                        f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> Uso de {variable} que no ha sido declarado en esa instancia.")
        # check if ctx.getText() is a variable that has been declared
        elif re.search('.', expression.getText()):
            pass
        elif not self.symbol_table.is_declared(expression.getText()):
            self.error_listener.errors.append(
                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> Uso de {expression.getText()} que no ha sido declarado.")
        # self.symbol_table.enter_scope()

    def exitExpressionStatement(self, ctx: yaplParser.ExpressionStatementContext):
        print("Saliendo de ExpressionStatement")
        # self.symbol_table.exit_scope()

    def enterNewExpression(self, ctx: yaplParser.NewExpressionContext):
        print("Entrando en NewExpression")
        # self.symbol_table.enter_scope()  # Nuevo ámbito para la asignación
        exp = ctx.TYPE_ID().getText()
        print(exp)
        if not self.symbol_table.is_declared(exp):
            self.error_listener.errors.append(
                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> Uso de {exp} que no ha sido declarado.")

    def exitNewExpression(self, ctx: yaplParser.NewExpressionContext):
        print("Saliendo de NewExpression")

    def enterLetDeclaration(self, ctx: yaplParser.LetDeclarationContext):
        print("Entrando en LetDeclaration")
        for idx, type in enumerate(ctx.type_()):
            # print(type.getText(), ctx.ID()[idx].getText())
            self.declareSymbol(ctx, ctx.ID()[idx].getText(), type.getText())

        for exp in ctx.expression():
            if re.search(r'[\+\-\*\/]', exp.getText()):
                print(exp.getText())
                variables = re.split(r'[\+\-\*\/]', exp.getText())
                print("variables", variables)
                for variable in variables:
                    if self.symbol_table.is_declared(variable, current_scope_only=True):
                        print(
                            f"variable {variable} is declared as {self.symbol_table.lookup(variable)['tipo']}")
                        # check if both variables are the same type
                        if self.symbol_table.lookup(variable)['tipo'] != self.symbol_table.lookup(variables[0])['tipo']:
                            self.error_listener.errors.append(
                                f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> No se puede operar entre tipos de datos diferentes. {variable} es de tipo <{self.symbol_table.lookup(variable)['tipo']}> y {variables[0]} es de tipo <{self.symbol_table.lookup(variables[0])['tipo']}>")
                    else:
                        self.error_listener.errors.append(
                            f"ERROR semántico en línea {ctx.start.line}:{ctx.start.column} -> Uso de {variable} que no ha sido declarado en esa instancia.")

    def exitLetDeclaration(self, ctx: yaplParser.LetDeclarationContext):
        print("Saliendo de LetDeclaration")


# ARREGLAR PARA QUE SALGA BIEN MI C3D**. LLAMADAS DE FUNCIONES Y LA TABLA DE CUADRUPLOS
# class MyVisitor(yaplVisitor):
#     def __init__(self, listener):
#         self.code = {}  # Lista para almacenar las instrucciones de código intermedio
#         self.temp_count = 0  # Contador para variables temporales
#         self.arg_count = 0  # Contador para argumentos
#         self.label_count = 0  # Contador para etiquetas
#         self.class_name = ""
#         self.method_name = ""
#         self.cuadruplos = []
#         self.mem_sizes = {}
#         self.current_mem_size = 0
#         self.call = False
#         self.depth = 0
#         self.listener = listener
#         self.action = ""
#         self.temps = {}
#         self.args = {}
#         self.is_new = False
#         self.data = {}

#     def reset_current_mem_size(self):
#         self.current_mem_size = 0

#     def update_mem_for_variable(self, var_size):
#         self.current_mem_size += var_size
#         if self.method_name:
#             key = f"{self.class_name}.{self.method_name}"
#             self.mem_sizes[key] += self.current_mem_size
#             # print(self.code[self.class_name])
#             # print(self.mem_sizes, key, self.mem_sizes[key])
#             self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"][0] = f"BeginFuc_{self.mem_sizes[key]}"
#         else:
#             self.mem_sizes[self.class_name] += self.current_mem_size
#             self.code[self.class_name][0] = f"BeginFuc_{self.mem_sizes[self.class_name]}"
#         self.reset_current_mem_size()

#     def commit_class_mem(self):
#         self.mem_sizes[self.class_name] = self.current_mem_size
#         self.reset_current_mem_size()

#     def commit_method_mem(self):
#         print(self.current_mem_size)
#         key = f"{self.class_name}.{self.method_name}"
#         self.mem_sizes[key] = self.current_mem_size
#         # self.class_mem_sizes[self.class_name] += self.current_mem_size
#         self.reset_current_mem_size()

#     def new_temp(self):
#         # Función para generar un nuevo nombre de variable temporal
#         name_temp = f"$t{self.temp_count}"
#         self.temp_count += 1
#         return name_temp

#     def new_arg(self):
#         # Función para generar un nuevo nombre de variable temporal
#         name_arg = f"$a{self.arg_count}"
#         self.temp_count += 1
#         return name_arg

#     def new_label(self):
#         # Función para generar un nuevo nombre de etiqueta
#         self.label_count += 1
#         return f"L{self.label_count}"

#     def add_to_cuadruplos(self, data):
#         if self.method_name:
#             # Agrega un espacio al inicio de la tupla
#             modified_data = ('  ',) + data
#             self.cuadruplos.append(modified_data)
#         else:
#             self.cuadruplos.append(data)

#     def lookup_temp(self, var_name):
#         for temp in self.temps:
#             if self.temps[temp] == var_name:
#                 return temp
#         return None

#     def visitClassDeclaration(self, ctx: yaplParser.ClassDeclarationContext):
#         # print("visitClassDeclaration")
#         self.class_name = ctx.TYPE_ID()[0].getText()
#         self.method_name = ""
#         # print(self.class_name)
#         self.code[self.class_name] = []
#         self.code[self.class_name].append("BeginFuc_")
#         self.commit_class_mem()
#         self.visitChildren(ctx)
#         self.code[self.class_name].append("EndFunc_")

#     def visitAttributeDeclaration(self, ctx: yaplParser.AttributeDeclarationContext):
#         print("visitAttributeDeclaration")
#         var_name = ctx.ID().getText()
#         print(var_name)

#         if ctx.ID():
#             expression_result = ctx.type_().getText()
#             self.code[self.class_name].append(
#                 f"{var_name} = {expression_result}")
#             # self.cuadruplos.append(
#             #     ('ASSIGN', expression_result, '-', var_name))

#             for scope in self.listener.symbol_table.scopes:
#                 if var_name in scope:
#                     if 'usado' in scope[var_name] and scope[var_name]['usado'] == True:
#                         temp = self.lookup_temp(var_name) or self.new_temp()
#                         self.add_to_cuadruplos(('lw', temp, var_name))
#                         self.temps[var_name] = temp
#         var_size = self.get_size_of_type(ctx.type_().getText())
#         self.update_mem_for_variable(var_size)

#     def visitAssignmentDeclaration(self, ctx: yaplParser.AssignmentDeclarationContext):
#         print("visitAssignmentDeclaration")
#         var_name = ctx.ID().getText()
#         expression_result = ctx.expression().getText()
#         children = self.visit(ctx.expression())
#         print(children)

#         if children:
#             self.code[self.class_name].append(
#                 f"{var_name} = {children}")

#             self.add_to_cuadruplos(
#                 ('ASSIGN6', children, '-', var_name))
#         else:
#             if not self.is_new:
#                 temp = self.lookup_temp(var_name) or self.new_temp()
#                 self.code[self.class_name].append(
#                     f"{var_name} = {expression_result}")
#                 self.add_to_cuadruplos(('li', temp, expression_result))
#                 self.add_to_cuadruplos(('sw', temp, var_name))

#     def visitMethodDeclaration(self, ctx: yaplParser.MethodDeclarationContext):
#         print("visitMethodDeclaration")
#         if self.method_name != "":
#             self.method_name = ""
#         self.method_name = ctx.ID().getText()
#         # print(self.method_name)
#         self.code[self.class_name].append(
#             {f"{self.class_name}.{self.method_name}:": []})
#         self.cuadruplos.append((f"{self.method_name}:", ""))
#         self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"].append(
#             "BeginFuc_")
#         self.commit_method_mem()
#         self.visitChildren(ctx)
#         if self.method_name != "main":
#             self.add_to_cuadruplos(('jr', "$ra"))
#         else:
#             self.add_to_cuadruplos(('li', '$v0', '10'))
#             self.add_to_cuadruplos(("syscall", ""))
#         self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"].append(
#             "EndFunc_")
#         self.method_name = ""

#     def visitParameterList(self, ctx: yaplParser.ParameterListContext):
#         print("visitParameterList")
#         self.visitChildren(ctx)

#     def visitParameter(self, ctx: yaplParser.ParameterContext):
#         print("visitParameter")
#         print(ctx.getText())
#         var_name = ctx.ID().getText()
#         print(var_name)
#         expression_result = ctx.type_().getText()

#         temp = self.lookup_temp(var_name) or self.new_temp()

#         if self.method_name:
#             target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#         else:
#             target_code = self.code[self.class_name]

#         target_code.append(
#             f"{var_name} = {expression_result}")
#         self.add_to_cuadruplos(
#             ('lw', temp, var_name))
#         self.temps[var_name] = temp
#         var_size = self.get_size_of_type(ctx.type_().getText())
#         self.update_mem_for_variable(var_size)

#     def visitMethodCallStatement(self, ctx: yaplParser.MethodCallStatementContext):
#         print("visitMethodCallStatement")
#         print(ctx.getText())
#         method_name = ctx.ID().getText()
#         if self.method_name:
#             target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#         else:
#             target_code = self.code[self.class_name]

#         if ctx.expressionList():
#             for expression in ctx.expressionList().expression():
#                 temp = self.lookup_temp(expression) or self.new_temp()
#                 # self.add_to_cuadruplos(
#                 #     ('PARAM', expression.getText(), '', temp))
#                 target_code.append(
#                     f"{temp} = {expression.getText()}")
#                 target_code.append(
#                     f"PUSHPARAM {temp}")
#                 # self.add_to_cuadruplos(
#                 #     ('PUSHPARAM', temp))
#                 # for cuad in self.cuadruplos:
#                 #     if expression.getText() in cuad:
#                 #         self.cuadruplos.pop()
#                 arg = self.new_arg()
#                 self.args[arg] = expression.getText()
#                 self.add_to_cuadruplos(
#                     ('lw', arg, expression.getText()))
#         if method_name == 'out_int':
#             self.add_to_cuadruplos(('',))
#             self.add_to_cuadruplos(('lw', '$a0', expression.getText()))
#             self.add_to_cuadruplos(('li', '$v0', '1'))
#             self.add_to_cuadruplos(('syscall',))
#         else:
#             self.add_to_cuadruplos(('jal', method_name))

#         if self.call:
#             self.call = False
#             return f"LCall {method_name}()"
#         else:
#             target_code.append(
#                 f"LCall {method_name}()")

#     def visitLetDeclaration(self, ctx: yaplParser.LetDeclarationContext):
#         print("visitLetDeclaration")
#         # print(ctx.getText())
#         for idx, type in enumerate(ctx.type_()):
#             # print(type.getText(), ctx.ID()[idx].getText())
#             self.code[self.class_name].append(
#                 f"{ctx.ID()[idx].getText()} = {type.getText()}")

#             for scope in self.listener.symbol_table.scopes:
#                 if ctx.ID()[idx].getText() in scope:
#                     if 'usado' in scope[ctx.ID()[idx].getText()] and scope[ctx.ID()[idx].getText()]['usado'] == True:
#                         temp = self.lookup_temp(
#                             ctx.ID()[idx].getText()) or self.new_temp()
#                         self.add_to_cuadruplos(
#                             ('lw', temp, ctx.ID()[idx].getText()))
#             # if ctx.expression():
#             #     self.add_to_cuadruplos(
#             #         ('sw', ctx.expression()[idx].getText(), '-', temp))
#             var_size = self.get_size_of_type(type.getText())
#             self.update_mem_for_variable(var_size)
#         self.visitChildren(ctx)

#     def visitAdditionExpression(self, ctx: yaplParser.AdditionExpressionContext):
#         print("visitAdditionExpression")
#         print(ctx.getText())
#         self.action = "operation"
#         left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
#         right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
#         self.action = ""
#         # print(left, right)
#         for scope in self.listener.symbol_table.scopes:
#             if ctx.expression(0).getText() in scope:
#                 if ('usado' in scope[ctx.expression(0).getText()] and scope[ctx.expression(0).getText()]['usado'] == True):
#                     temp = self.lookup_temp(ctx.expression(
#                         0).getText()) or self.new_temp()

#                     self.add_to_cuadruplos(('add', temp, left, right))

#                     if self.method_name:
#                         target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#                     else:
#                         target_code = self.code[self.class_name]

#                     target_code.append(f"{temp} = {left} + {right}")
#                     return temp
#             elif ctx.expression(1).getText() in scope:
#                 if ('usado' in scope[ctx.expression(1).getText()] and scope[ctx.expression(1).getText()]['usado'] == True):
#                     temp = self.lookup_temp(ctx.expression(
#                         1).getText()) or self.new_temp()

#                     self.add_to_cuadruplos(('add', temp, left, right))

#                     if self.method_name:
#                         target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#                     else:
#                         target_code = self.code[self.class_name]

#                     target_code.append(f"{temp} = {left} + {right}")
#                     return temp

#     def visitSubtractionExpression(self, ctx: yaplParser.SubtractionExpressionContext):
#         print("visitSubtractionExpression")
#         print(ctx.getText())
#         self.action = "operation"
#         left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
#         right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
#         self.action = ""
#         # print(left, right)
#         for scope in self.listener.symbol_table.scopes:
#             if ctx.expression(0).getText() in scope:
#                 if ('usado' in scope[ctx.expression(0).getText()] and scope[ctx.expression(0).getText()]['usado'] == True):
#                     temp = self.lookup_temp(ctx.expression(
#                         0).getText()) or self.new_temp()

#                     self.add_to_cuadruplos(('sub', temp, left, right))

#                     if self.method_name:
#                         target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#                     else:
#                         target_code = self.code[self.class_name]

#                     target_code.append(f"{temp} = {left} + {right}")
#                     return temp
#             elif ctx.expression(1).getText() in scope:
#                 if ('usado' in scope[ctx.expression(1).getText()] and scope[ctx.expression(1).getText()]['usado'] == True):
#                     temp = self.lookup_temp(ctx.expression(
#                         1).getText()) or self.new_temp()

#                     self.add_to_cuadruplos(('sub', temp, left, right))

#                     if self.method_name:
#                         target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#                     else:
#                         target_code = self.code[self.class_name]

#                     target_code.append(f"{temp} = {left} + {right}")
#                     return temp

#     def visitMultiplicationExpression(self, ctx: yaplParser.MultiplicationExpressionContext):
#         print("visitMultiplicationExpression")
#         print(ctx.getText())
#         self.action = "operation"
#         left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
#         right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
#         self.action = ""
#         print(left, right)
#         for scope in self.listener.symbol_table.scopes:
#             if ctx.expression(0).getText() in scope:
#                 if ('usado' in scope[ctx.expression(0).getText()] and scope[ctx.expression(0).getText()]['usado'] == True):
#                     temp = self.lookup_temp(ctx.expression(
#                         0).getText()) or self.new_temp()

#                     self.add_to_cuadruplos(('mul', temp, left, right))

#                     if self.method_name:
#                         target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#                     else:
#                         target_code = self.code[self.class_name]

#                     target_code.append(f"{temp} = {left} * {right}")
#                     print('temp', temp)
#                     return temp
#             elif ctx.expression(1).getText() in scope:
#                 if ('usado' in scope[ctx.expression(1).getText()] and scope[ctx.expression(1).getText()]['usado'] == True):
#                     temp = self.lookup_temp(ctx.expression(
#                         1).getText()) or self.new_temp()

#                     self.add_to_cuadruplos(('mul', temp, left, right))

#                     if self.method_name:
#                         target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#                     else:
#                         target_code = self.code[self.class_name]

#                     target_code.append(f"{temp} = {left} * {right}")
#                     print('temp', temp)
#                     return temp

#     def visitDivisionExpression(self, ctx: yaplParser.DivisionExpressionContext):
#         print("visitDivisionExpression")
#         print(ctx.getText())
#         self.action = "operation"
#         left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
#         right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
#         self.action = ""
#         # print(left, right)
#         for scope in self.listener.symbol_table.scopes:
#             if ctx.expression(0).getText() in scope:
#                 if ('usado' in scope[ctx.expression(0).getText()] and scope[ctx.expression(0).getText()]['usado'] == True):
#                     temp = self.lookup_temp(ctx.expression(
#                         0).getText()) or self.new_temp()

#                     self.add_to_cuadruplos(('div', temp, left, right))

#                     if self.method_name:
#                         target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#                     else:
#                         target_code = self.code[self.class_name]

#                     target_code.append(f"{temp} = {left} + {right}")
#                     return temp
#             elif ctx.expression(1).getText() in scope:
#                 if ('usado' in scope[ctx.expression(1).getText()] and scope[ctx.expression(1).getText()]['usado'] == True):
#                     temp = self.lookup_temp(ctx.expression(
#                         1).getText()) or self.new_temp()

#                     self.add_to_cuadruplos(('div', temp, left, right))

#                     if self.method_name:
#                         target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#                     else:
#                         target_code = self.code[self.class_name]

#                     target_code.append(f"{temp} = {left} + {right}")
#                     return temp

#     def visitNewExpression(self, ctx: yaplParser.NewExpressionContext):
#         print("visitNewExpression")
#         self.is_new = True
#         # self.add_to_cuadruplos(('new', ctx.TYPE_ID().getText(), '-', '-'))

#     def visitIfStatement(self, ctx: yaplParser.IfStatementContext):
#         print("visitIfStatement")
#         print(ctx.getText())
#         # temp = self.new_temp()
#         end_label = self.new_label()
#         else_block_label = self.new_label()
#         condition_temp = self.visit(
#             ctx.expression()) or ctx.expression().getText()

#         if self.method_name:
#             target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#         else:
#             target_code = self.code[self.class_name]

#         # target_code.append(f"{temp} = {condition_temp}")
#         target_code.append(
#             f"if_false {condition_temp} goto {else_block_label}")
#         # self.add_to_cuadruplos(
#         #     ('<-', ctx.expression().getText(), '-', condition_temp))
#         self.add_to_cuadruplos(
#             ('blez', condition_temp, else_block_label))
#         self.visit(ctx.statement(0))
#         target_code.append(f"goto {end_label}")
#         target_code.append(f"{else_block_label}:")
#         self.add_to_cuadruplos((f"{else_block_label}:", ""))
#         if ctx.statement(1):  # En caso de que exista un bloque else
#             self.visit(ctx.statement(1))
#         target_code.append(f"{end_label}")
#         self.add_to_cuadruplos((f"{end_label}:", ""))

#     def visitExpressionStatement(self, ctx: yaplParser.ExpressionStatementContext):
#         print("visitExpressionStatement")
#         print(ctx.expression().getText())
#         self.visit(ctx.expression())

#     def visitGreaterThanExpression(self, ctx: yaplParser.GreaterThanExpressionContext):
#         print("visitGreaterThanExpression")
#         print(ctx.getText())
#         left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
#         right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
#         temp = self.new_temp()

#         self.add_to_cuadruplos(('>', left, right, '-'))

#         if self.method_name:
#             target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#         else:
#             target_code = self.code[self.class_name]

#         target_code.append(f"{temp} = {left} > {right}")
#         return temp

#     def visitLessThanExpression(self, ctx: yaplParser.LessThanExpressionContext):
#         print("visitLessThanExpression")
#         print(ctx.getText())
#         left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
#         right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
#         temp = self.new_temp()

#         self.add_to_cuadruplos(('slt', temp, left, right))

#         if self.method_name:
#             target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#         else:
#             target_code = self.code[self.class_name]

#         target_code.append(f"{temp} = {left} < {right}")
#         return temp

#     def visitEqualityExpression(self, ctx: yaplParser.EqualityExpressionContext):
#         print("visitEqualityExpression")
#         print(ctx.getText())
#         left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
#         right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
#         temp = self.new_temp()

#         self.add_to_cuadruplos(('==', left, right, '-'))

#         if self.method_name:
#             target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#         else:
#             target_code = self.code[self.class_name]

#         target_code.append(f"{temp} = {left} == {right}")
#         return temp

#     def visitNotEqualExpression(self, ctx: yaplParser.NotEqualExpressionContext):
#         print("visitNotEqualExpression")
#         print(ctx.getText())
#         left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
#         right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
#         temp = self.new_temp()

#         self.add_to_cuadruplos(('!=', left, right, '-'))

#         if self.method_name:
#             target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#         else:
#             target_code = self.code[self.class_name]

#         target_code.append(f"{temp} = {left} != {right}")
#         return temp

#     def visitAssignmentExpression(self, ctx: yaplParser.AssignmentExpressionContext):
#         print("visitAssignmentExpression")
#         print(ctx.getText())
#         self.action = "assignment"
#         left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
#         right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
#         temp = self.new_temp()
#         print(left, right)
#         cargar = True

#         # self.add_to_cuadruplos(('=', left, '-', right))
#         for scope in self.listener.symbol_table.scopes:
#             if left in scope:
#                 if ('usado' in scope[left] and scope[left]['usado'] == True):
#                     cargar = False

#         if cargar:
#             if right.isnumeric():
#                 self.add_to_cuadruplos(('lsi', temp, right))
#                 self.add_to_cuadruplos(('sw', temp, left))
#             else:
#                 if right == "$v0":
#                     self.cuadruplos.pop(-2)
#                 # else:
#                 self.add_to_cuadruplos(('sw', right, left))

#         if self.method_name:
#             target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#         else:
#             target_code = self.code[self.class_name]

#         target_code.append(f"{left} = {right}")

#     def visitVariableDeclaration(self, ctx: yaplParser.VariableDeclarationContext):
#         print("visitVariableDeclaration")
#         print(ctx.getText())
#         var_name = ctx.ID().getText()
#         print(var_name)
#         expression_result = ctx.type_().getText()

#         temp = self.lookup_temp(var_name) or self.new_temp()

#         if self.method_name:
#             target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#         else:
#             target_code = self.code[self.class_name]

#         if ctx.statement():
#             target_code.append(
#                 f"{var_name} = {expression_result}")
#             self.add_to_cuadruplos(
#                 ('lw', temp, var_name))
#             if re.search(r'[\+\-\*\/]', ctx.statement().getText()) or re.search(r'[(]', ctx.statement().getText()):
#                 self.call = True
#                 res = self.visit(ctx.statement())
#             else:
#                 res = ctx.statement().getText()
#             target_code.append(
#                 f"{var_name} = {res}")
#             self.add_to_cuadruplos(
#                 ('li', var_name, res))
#         else:
#             target_code.append(
#                 f"{var_name} = {expression_result}")
#             for scope in self.listener.symbol_table.scopes:
#                 if var_name in scope:
#                     if 'usado' in scope[var_name] and scope[var_name]['usado'] == True:
#                         # temp = self.new_temp()
#                         self.add_to_cuadruplos(
#                             ('lw', temp, var_name))
#                         self.temps[var_name] = temp
#         var_size = self.get_size_of_type(ctx.type_().getText())
#         self.update_mem_for_variable(var_size)

#     def visitReturnStatement(self, ctx: yaplParser.ReturnStatementContext):
#         print("visitReturnStatement")
#         # print(ctx.getText())
#         if self.method_name:
#             if ctx.expression():
#                 expression = ctx.expression().getText()
#                 # print(self.class_name, self.method_name)
#                 # print(self.code[self.class_name])
#                 # print(expression)
#                 self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"].append(
#                     f"return {expression}")
#                 self.add_to_cuadruplos(('li', '$v0', expression))
#             else:
#                 self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"].append(
#                     f"return")
#                 self.add_to_cuadruplos(('return', '-', '-', '-'))
#         else:
#             if ctx.expression():
#                 expression = ctx.expression().getText()
#                 print(expression)
#                 self.code[self.class_name].append(f"return {expression}")
#                 self.add_to_cuadruplos(('li', '$v0', expression))
#             else:
#                 self.code[self.class_name].append(
#                     f"return {ctx.VOID().getText()}")
#                 self.add_to_cuadruplos(('return', '-', '-', '-'))

#     def visitWhileStatement(self, ctx: yaplParser.WhileStatementContext):
#         print("visitWhileStatement")
#         print(ctx.getText())
#         end_label = self.new_label()
#         while_label = self.new_label()
#         # temp = self.new_temp()

#         if self.method_name:
#             target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#         else:
#             target_code = self.code[self.class_name]

#         target_code.append(f"{while_label}:")
#         condition_temp = self.visit(
#             ctx.expression()) or ctx.expression().getText()
#         # target_code.append(f"{condition_temp} = {ctx.expression().getText()}")
#         target_code.append(f"if_false {condition_temp} goto {end_label}")
#         self.add_to_cuadruplos(
#             ('<-', ctx.expression().getText(), '-', condition_temp))
#         self.add_to_cuadruplos(('if_false', condition_temp, '-', end_label))
#         self.visit(ctx.statement())
#         target_code.append(f"goto {while_label}")
#         target_code.append(f"{end_label}")

#     def visitClassMethodCallExpression(self, ctx: yaplParser.ClassMethodCallExpressionContext):
#         print("visitClassMethodCallExpression")
#         print(ctx.getText())
#         method_name = ctx.ID().getText()
#         class_name = ctx.expression().getText()
#         if self.method_name:
#             target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
#         else:
#             target_code = self.code[self.class_name]

#         if ctx.expressionList():
#             for expression in ctx.expressionList().expression():
#                 temp = self.lookup_temp(expression) or self.new_temp()
#                 self.add_to_cuadruplos(
#                     ('PARAM', expression.getText(), '-', temp))
#                 target_code.append(
#                     f"{temp} = {expression.getText()}")
#                 target_code.append(
#                     f"PUSHPARAM {temp}")
#                 self.add_to_cuadruplos(
#                     ('PUSHPARAM', temp, '-', '-'))
#             # self.add_to_cuadruplos(('CALL', method_name, '-', '-'))

#         # temp = self.new_temp()
#         temp = "$v0"
#         target_code.append(
#             f"{temp} = LCALL {class_name}.{method_name}()")
#         self.add_to_cuadruplos(('jal', method_name))

#         return temp

#     def visitIdentifierExpression(self, ctx: yaplParser.IdentifierExpressionContext):
#         print("visitIdentifierExpression")
#         print(ctx.getText())
#         print("op", self.action)
#         si_se_usa = False
#         if ctx.getText() in self.temps:
#             if self.action == "assignment":
#                 return ctx.getText()
#             temp = self.temps[ctx.getText()]
#         else:
#             temp = self.new_temp()
#             self.temps[ctx.getText()] = temp

#         for scope in self.listener.symbol_table.scopes:
#             if ctx.getText() in scope:
#                 if ('usado' in scope[ctx.getText()] and scope[ctx.getText()]['usado'] == True):
#                     si_se_usa = True
#         if self.action == "operation" and si_se_usa:
#             self.add_to_cuadruplos(('lw', temp, ctx.ID().getText()))

#         return temp

#     def get_size_of_type(self, type_str):
#         """Devuelve el tamaño en bytes del tipo de datos proporcionado. Esto es solo un ejemplo y debe ser ajustado según el lenguaje y la plataforma."""
#         type_sizes = {
#             "int": 4,
#             "string": 8,
#             "bool": 1,
#         }
#         return type_sizes.get(type_str, 0)

class MyVisitor(yaplVisitor):
    def __init__(self, my_listener):
        self.code = {}  # Lista para almacenar las instrucciones de código intermedio
        self.temp_count = 0  # Contador para variables temporales
        self.arg_count = 0
        self.label_count = 0  # Contador para etiquetas
        self.promt_count = 0
        self.class_name = ""
        self.method_name = ""
        self.cuadruplos = []
        self.mips = []
        self.mem_sizes = {}
        self.current_mem_size = 0
        self.call = False
        self.listener = my_listener
        self.temps = {}
        self.temps_in_use = []
        self.args = {}
        self.action = ""
        self.params = []
        self.prompts = {}

    def reset_current_mem_size(self):
        self.current_mem_size = 0

    def update_mem_for_variable(self, var_size):
        self.current_mem_size += var_size
        if self.method_name:
            key = f"{self.class_name}.{self.method_name}"
            self.mem_sizes[key] += self.current_mem_size
            # print(self.code[self.class_name])
            # print(self.mem_sizes, key, self.mem_sizes[key])
            self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"][0] = f"BeginFuc_{self.mem_sizes[key]}"
        else:
            self.mem_sizes[self.class_name] += self.current_mem_size
            self.code[self.class_name][0] = f"BeginFuc_{self.mem_sizes[self.class_name]}"
        self.reset_current_mem_size()

    def commit_class_mem(self):
        self.mem_sizes[self.class_name] = self.current_mem_size
        self.reset_current_mem_size()

    def commit_method_mem(self):
        print(self.current_mem_size)
        key = f"{self.class_name}.{self.method_name}"
        self.mem_sizes[key] = self.current_mem_size
        # self.class_mem_sizes[self.class_name] += self.current_mem_size
        self.reset_current_mem_size()

    def new_temp(self):
        # Función para generar un nuevo nombre de variable temporal
        # name_temp = f"$t{self.temp_count}"
        # self.temp_count += 1
        # return name_temp
        for i in range(10):  # Suponiendo que tienes 10 temporales ($t0 a $t9)
            temp_name = f"$t{i}"
            if temp_name not in self.temps_in_use:
                self.temps_in_use.append(temp_name)
                return temp_name

    def new_arg(self):
        name_arg = f"$a{self.arg_count}"
        self.arg_count += 1
        return name_arg

    def new_promt(self):
        name_promt = f"promt{self.promt_count}"
        self.promt_count += 1
        return name_promt

    def lookup_temp(self, var_name):
        # Función para buscar el nombre de una variable temporal
        if var_name in self.temps:
            return self.temps[var_name]
        return None

    def lookup_arg(self, var_name):
        if var_name in self.args:
            return self.args[var_name]
        return None

    def free_temp(self, temp):
        # Función para liberar una variable temporal
        if temp in self.temps_in_use:
            self.temps_in_use.remove(temp)

    def new_label(self):
        # Función para generar un nuevo nombre de etiqueta
        self.label_count += 1
        return f"L{self.label_count}"

    def add_to_mips(self, data):
        if self.method_name:
            # Agrega un espacio al inicio de la tupla
            if data[0] == self.method_name + ':':
                # print("data", data)
                self.mips.append(data)
            else:
                modified_data = ('  ',) + data
                self.mips.append(modified_data)
        else:
            self.mips.append(data)

    def visitClassDeclaration(self, ctx: yaplParser.ClassDeclarationContext):
        # print("visitClassDeclaration")
        self.class_name = ctx.TYPE_ID()[0].getText()
        self.method_name = ""
        # print(self.class_name)
        self.code[self.class_name] = []
        self.code[self.class_name].append("BeginFuc_")
        self.commit_class_mem()
        self.visitChildren(ctx)
        self.code[self.class_name].append("EndFunc_")

    def visitAttributeDeclaration(self, ctx: yaplParser.AttributeDeclarationContext):
        print("visitAttributeDeclaration")
        var_name = ctx.ID().getText()
        print(var_name)
        if ctx.ID():
            expression_result = ctx.type_().getText()
            self.code[self.class_name].append(
                f"{var_name} = {expression_result}")

            self.cuadruplos.append(
                ('ASSIGN', expression_result, '-', var_name))
            self.add_to_mips(
                ('ASSIGN', expression_result, '-', var_name))
        var_size = self.get_size_of_type(ctx.type_().getText())
        self.update_mem_for_variable(var_size)

    def visitAssignmentDeclaration(self, ctx: yaplParser.AssignmentDeclarationContext):
        print("visitAssignmentDeclaration")
        var_name = ctx.ID().getText()
        expression_result = ctx.expression().getText()
        children = self.visit(ctx.expression())
        print(children)

        if children:
            self.code[self.class_name].append(
                f"{var_name} = {children}")

            self.cuadruplos.append(
                ('ASSIGN', children, '-', var_name))
            self.add_to_mips(
                ('ASSIGN', children, '-', var_name))
        else:
            self.code[self.class_name].append(
                f"{var_name} = {expression_result}")
            self.cuadruplos.append(('<-', expression_result, '-', var_name))
            self.add_to_mips(('<-', expression_result, '-', var_name))

    def visitMethodDeclaration(self, ctx: yaplParser.MethodDeclarationContext):
        # print("visitMethodDeclaration")
        if self.method_name != "":
            self.method_name = ""
        self.method_name = ctx.ID().getText()
        # print(self.method_name)
        self.code[self.class_name].append(
            {f"{self.class_name}.{self.method_name}:": []})
        self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"].append(
            "BeginFuc_")
        self.add_to_mips((f"{self.method_name}:",))
        self.commit_method_mem()
        self.visitChildren(ctx)
        if self.method_name != "main":
            self.add_to_mips(('jr', "$ra"))
        else:
            self.add_to_mips(('li', '$v0', '10'))
            self.add_to_mips(("syscall", ""))
        self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"].append(
            "EndFunc_")
        self.method_name = ""

    def visitParameterList(self, ctx: yaplParser.ParameterListContext):
        print("visitParameterList")
        self.visitChildren(ctx)

    def visitParameter(self, ctx: yaplParser.ParameterContext):
        print("visitParameter")
        print(ctx.getText())
        self.params.append(ctx.ID().getText())
        # var_name = ctx.ID().getText()
        # print(var_name)
        # expression_result = ctx.type_().getText()

        # temp = self.lookup_temp(var_name) or self.new_temp()

        # if self.method_name:
        #     target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        # else:
        #     target_code = self.code[self.class_name]

        # target_code.append(
        #     f"{var_name} = {expression_result}")
        # self.add_to_cuadruplos(
        #     ('lw', temp, var_name))
        # self.temps[var_name] = temp
        # var_size = self.get_size_of_type(ctx.type_().getText())
        # self.update_mem_for_variable(var_size)

    def visitMethodCallStatement(self, ctx: yaplParser.MethodCallStatementContext):
        print("visitMethodCallStatement")
        print(ctx.getText())
        method_name = ctx.ID().getText()
        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        if ctx.expressionList():
            for expression in ctx.expressionList().expression():
                print(expression.getText())
                temp = self.lookup_temp(
                    expression.getText()) or self.new_temp()
                arg = self.lookup_arg(expression.getText()) or self.new_arg()
                self.args[expression.getText()] = arg
                self.cuadruplos.append(
                    ('PARAM', expression.getText(), '-', temp))
                # self.add_to_mips(
                #     ('PARAM', expression.getText(), '-', temp))
                target_code.append(
                    f"{temp} = {expression.getText()}")
                target_code.append(
                    f"PUSHPARAM {temp}")
                self.cuadruplos.append(
                    ('PUSHPARAM', temp, '-', '-'))
                if not expression.getText().startswith('"') and not expression.getText().endswith('"'):
                    self.add_to_mips(
                        ('move', arg, temp))
            self.cuadruplos.append(('CALL', method_name, '-', '-'))
            if method_name == 'out_int':
                exp = ''
                self.add_to_mips(('',))
                for scope in self.listener.symbol_table.scopes:
                    for el in scope:
                        # print('el', el)
                        # print('exp', exp)
                        if 'valor' in scope[el] and scope[el]['valor'] == expression.getText():
                            exp = el
                            self.add_to_mips(('lw', '$a0', exp))
                            break
                        else:
                            exp = expression.getText()
                            # if exp.isnumeric():
                            #     self.add_to_mips(('li', '$a0', exp))
                            # break
                self.add_to_mips(('li', '$v0', '1'))
                self.add_to_mips(('syscall',))
            elif method_name == 'out_string':
                prompt = self.new_promt()
                self.prompts[prompt] = expression.getText()
                self.add_to_mips(('',))
                self.add_to_mips(('li', '$v0', '4'))
                self.add_to_mips(('la', arg, prompt))
                self.add_to_mips(('syscall',))
            elif method_name == 'in_int':
                self.add_to_mips(('',))
                self.add_to_mips(('li', '$v0', '5'))
                self.add_to_mips(('syscall',))
            else:
                self.add_to_mips(('jal', method_name))
            # self.add_to_mips(('CALL', method_name, '-', '-'))

        if self.call:
            self.call = False
            return f"LCall {method_name}()"
        else:
            target_code.append(
                f"LCall {method_name}()")

    def visitLetDeclaration(self, ctx: yaplParser.LetDeclarationContext):
        # print("visitLetDeclaration")
        # print(ctx.getText())
        for idx, type in enumerate(ctx.type_()):
            # print(type.getText(), ctx.ID()[idx].getText())
            self.code[self.class_name].append(
                f"{ctx.ID()[idx].getText()} = {type.getText()}")
            var_size = self.get_size_of_type(type.getText())
            self.update_mem_for_variable(var_size)
        self.visitChildren(ctx)

    def visitAdditionExpression(self, ctx: yaplParser.AdditionExpressionContext):
        print("visitAdditionExpression")
        print(ctx.getText())
        self.action = "operation"
        left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
        right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
        self.action = ""
        temp = self.new_temp()

        self.cuadruplos.append(('+', left, right, temp))
        self.add_to_mips(('add', temp, left, right))

        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        target_code.append(f"{temp} = {left} * {right}")
        return temp

    def visitSubtractionExpression(self, ctx: yaplParser.SubtractionExpressionContext):
        print("visitSubtractionExpression")
        print(ctx.getText())
        self.action = "operation"
        left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
        right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
        self.action = ""
        temp = self.new_temp()

        self.cuadruplos.append(('-', left, right, temp))
        self.add_to_mips(('sub', temp, left, right))

        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        target_code.append(f"{temp} = {left} * {right}")
        return temp

    def visitMultiplicationExpression(self, ctx: yaplParser.MultiplicationExpressionContext):
        print("visitMultiplicationExpression")
        print(ctx.getText())
        self.action = "operation"
        left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
        right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
        self.action = ""
        temp = self.new_temp()

        self.cuadruplos.append(('*', left, right, temp))
        self.add_to_mips(('mul', temp, left, right))

        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        target_code.append(f"{temp} = {left} * {right}")
        return temp

    def visitDivisionExpression(self, ctx: yaplParser.DivisionExpressionContext):
        print("visitDivisionExpression")
        print(ctx.getText())
        self.action = "operation"
        left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
        right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
        self.action = ""
        temp = self.new_temp()

        self.cuadruplos.append(('/', left, right, temp))
        self.add_to_mips(('div', temp, left, right))

        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        target_code.append(f"{temp} = {left} * {right}")
        return temp

    def visitNewExpression(self, ctx: yaplParser.NewExpressionContext):
        print("visitNewExpression")
        self.cuadruplos.append(('new', ctx.TYPE_ID().getText(), '-', '-'))
        # self.add_to_mips(('new', ctx.TYPE_ID().getText(), '-', '-'))

    def visitIfStatement(self, ctx: yaplParser.IfStatementContext):
        print("visitIfStatement")
        print(ctx.getText())
        # temp = self.new_temp()
        end_label = self.new_label()
        else_block_label = self.new_label()
        condition_temp = self.visit(
            ctx.expression()) or ctx.expression().getText()

        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        # target_code.append(f"{temp} = {condition_temp}")
        target_code.append(
            f"if_false {condition_temp} goto {else_block_label}")
        self.cuadruplos.append(
            ('<-', ctx.expression().getText(), '-', condition_temp))
        # self.add_to_mips(
        #     ('<-', ctx.expression().getText(), '-', condition_temp))
        self.cuadruplos.append(
            ('if_false', condition_temp, '-', else_block_label))
        self.add_to_mips(
            ('blez', condition_temp, else_block_label))
        self.visit(ctx.statement(0))
        target_code.append(f"goto {end_label}")
        target_code.append(f"{else_block_label}:")
        self.add_to_mips((f"{else_block_label}:",))
        if ctx.statement(1):  # En caso de que exista un bloque else
            self.visit(ctx.statement(1))
        target_code.append(f"{end_label}")
        self.add_to_mips((f"{end_label}:",))
        self.free_temp(condition_temp)

    def visitExpressionStatement(self, ctx: yaplParser.ExpressionStatementContext):
        print("visitExpressionStatement")
        print(ctx.expression().getText())
        self.visit(ctx.expression())

    def visitGreaterThanExpression(self, ctx: yaplParser.GreaterThanExpressionContext):
        print("visitGreaterThanExpression")
        print(ctx.getText())
        left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
        right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
        temp = self.new_temp()

        self.cuadruplos.append(('>', left, right, '-'))
        self.add_to_mips(('>', left, right, '-'))

        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        target_code.append(f"{temp} = {left} > {right}")
        return temp

    def visitLessThanExpression(self, ctx: yaplParser.LessThanExpressionContext):
        print("visitLessThanExpression")
        print(ctx.getText())
        self.action = 'compare'
        left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
        right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
        temp = self.new_temp()
        self.action = ''

        self.cuadruplos.append(('<', left, right, '-'))
        self.add_to_mips(('slt', temp, left, right))

        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        target_code.append(f"{temp} = {left} < {right}")
        return temp

    def visitEqualityExpression(self, ctx: yaplParser.EqualityExpressionContext):
        print("visitEqualityExpression")
        print(ctx.getText())
        left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
        right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
        temp = self.new_temp()

        self.cuadruplos.append(('==', left, right, '-'))
        self.add_to_mips(('==', left, right, '-'))

        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        target_code.append(f"{temp} = {left} == {right}")
        return temp

    def visitNotEqualExpression(self, ctx: yaplParser.NotEqualExpressionContext):
        print("visitNotEqualExpression")
        print(ctx.getText())
        left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
        right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
        temp = self.new_temp()

        self.cuadruplos.append(('!=', left, right, '-'))
        self.add_to_mips(('!=', left, right, '-'))

        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        target_code.append(f"{temp} = {left} != {right}")
        return temp

    def visitAssignmentExpression(self, ctx: yaplParser.AssignmentExpressionContext):
        print("visitAssignmentExpression")
        print(ctx.getText())
        self.action = "assignment"
        left = self.visit(ctx.expression(0)) or ctx.expression(0).getText()
        right = self.visit(ctx.expression(1)) or ctx.expression(1).getText()
        print(left, right)

        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        target_code.append(f"{left} = {right}")
        self.cuadruplos.append(('<-', right, '-', left))

        for scope in self.listener.symbol_table.scopes:
            if left in scope:
                temp = self.lookup_temp(left) or self.new_temp()
                self.temps[left] = temp
                if 'usado' in scope[left] and scope[left]['usado'] == True and 'valor' not in scope[left]:
                    # if left in self.temps:
                    #     temp = self.temps[left]
                    #     self.add_to_mips(('lw', temp, left))
                    self.add_to_mips(('sw', '$v0', left))
                    self.add_to_mips(('lw', temp, left))
                    break
                # else:
                #     self.add_to_mips(('li', temp, left))
                #     self.add_to_mips(('sw', temp, right))

    def visitVariableDeclaration(self, ctx: yaplParser.VariableDeclarationContext):
        print("visitVariableDeclaration")
        print(ctx.getText())
        self.action = 'assignment'
        var_name = ctx.ID().getText()
        print(var_name)
        expression_result = ctx.type_().getText()
        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        if ctx.statement():
            temp = self.lookup_temp(var_name) or self.new_temp()
            target_code.append(
                f"{var_name} = {expression_result}")
            self.cuadruplos.append(
                ('ASSIGN', expression_result, '-', var_name))
            self.add_to_mips(
                            ('lw', temp, var_name))
            self.temps[var_name] = temp
            if re.search(r'[\+\-\*\/]', ctx.statement().getText()) or re.search(r'[(]', ctx.statement().getText()):
                self.call = True
                res = self.visit(ctx.statement())
            else:
                res = ctx.statement().getText()
            target_code.append(
                f"{var_name} = {res}")
            self.cuadruplos.append(
                ('<-', var_name, '-', res))
            for scope in self.listener.symbol_table.scopes:
                if var_name in scope:
                    if 'usado' in scope[var_name] and scope[var_name]['usado'] == True:
                        break
                    else:
                        temp2 = self.lookup_temp(res) or self.new_temp()
                        self.temps[var_name] = temp

                        self.add_to_mips(
                            ('li', temp2, res))
                        self.add_to_mips(
                            ('sw', temp2, var_name))
        else:
            target_code.append(
                f"{var_name} = {expression_result}")
            self.cuadruplos.append(
                ('ASSIGN', expression_result, '-', var_name))

            for scope in self.listener.symbol_table.scopes:
                if var_name in scope:
                    if 'usado' in scope[var_name] and scope[var_name]['usado'] == True:
                        break
                    else:
                        temp = self.lookup_temp(var_name) or self.new_temp()
                        self.temps[var_name] = temp
                        self.add_to_mips(
                            ('lw', temp, var_name))
        var_size = self.get_size_of_type(ctx.type_().getText())
        self.update_mem_for_variable(var_size)

    def visitReturnStatement(self, ctx: yaplParser.ReturnStatementContext):
        print("visitReturnStatement")
        # print(ctx.getText())
        if self.method_name:
            if ctx.expression():
                expression = ctx.expression().getText()
                # print(self.class_name, self.method_name)
                # print(self.code[self.class_name])
                # print(expression)
                self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"].append(
                    f"return {expression}")
                self.cuadruplos.append(('return', '-', '-',  expression))
                self.add_to_mips(('return', '-', '-',  expression))
            else:
                self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"].append(
                    f"return")
                self.cuadruplos.append(('return', '-', '-', '-'))
                self.add_to_mips(('return', '-', '-', '-'))
        else:
            if ctx.expression():
                expression = ctx.expression().getText()
                print(expression)
                self.code[self.class_name].append(f"return {expression}")
                self.cuadruplos.append(('return', '-', '-', expression))
                self.add_to_mips(('return', '-', '-', expression))
            else:
                self.code[self.class_name].append(
                    f"return {ctx.VOID().getText()}")
                self.cuadruplos.append(('return', '-', '-', '-'))
                self.add_to_mips(('return', '-', '-', '-'))

    def visitWhileStatement(self, ctx: yaplParser.WhileStatementContext):
        print("visitWhileStatement")
        print(ctx.getText())
        end_label = self.new_label()
        while_label = self.new_label()
        # temp = self.new_temp()

        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        target_code.append(f"{while_label}:")
        condition_temp = self.visit(
            ctx.expression()) or ctx.expression().getText()
        # target_code.append(f"{condition_temp} = {ctx.expression().getText()}")
        target_code.append(f"if_false {condition_temp} goto {end_label}")
        self.cuadruplos.append(
            ('<-', ctx.expression().getText(), '-', condition_temp))
        self.add_to_mips(
            ('<-', ctx.expression().getText(), '-', condition_temp))
        self.cuadruplos.append(('if_false', condition_temp, '-', end_label))
        self.add_to_mips(('if_false', condition_temp, '-', end_label))
        self.visit(ctx.statement())
        target_code.append(f"goto {while_label}")
        target_code.append(f"{end_label}")

    def visitClassMethodCallExpression(self, ctx: yaplParser.ClassMethodCallExpressionContext):
        print("visitClassMethodCallExpression")
        print(ctx.getText())
        method_name = ctx.ID().getText()
        class_name = ctx.expression().getText()
        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        if ctx.expressionList():
            for expression in ctx.expressionList().expression():
                temp = self.lookup_temp(
                    expression.getText()) or self.new_temp()
                arg = self.lookup_arg(expression.getText()) or self.new_arg()
                self.cuadruplos.append(
                    ('PARAM', expression.getText(), '-', temp))
                # self.add_to_mips(
                #     ('PARAM', expression.getText(), '-', temp))
                target_code.append(
                    f"{temp} = {expression.getText()}")
                target_code.append(
                    f"PUSHPARAM {temp}")
                self.cuadruplos.append(
                    ('PUSHPARAM', temp, '-', '-'))
                # self.add_to_mips(
                #     ('PUSHPARAM', temp, '-', '-'))
            self.cuadruplos.append(('CALL', method_name, '-', '-'))
            # self.add_to_mips(('CALL', method_name, '-', '-'))

        temp = self.new_temp()
        target_code.append(
            f"{temp} = LCALL {class_name}.{method_name}()")
        self.cuadruplos.append(('CALL', method_name, '-', '-'))
        if method_name == 'out_int':
            self.add_to_mips(('',))
            self.add_to_mips(('li', '$a0', expression.getText()))
            self.add_to_mips(('li', '$v0', '1'))
            self.add_to_mips(('syscall',))
        elif method_name == 'length':
            # prompt = self.new_promt()
            # self.prompts[prompt] = expression.getText()
            # self.add_to_mips(('',))
            # self.add_to_mips(('li', '$v0', '4'))
            # self.add_to_mips(('la', arg, prompt))
            self.add_to_mips(('syscall',))
        elif method_name == 'concat':
            # Supongamos que tenemos dos registros temporales para las cadenas
            # Buscar el registro para 'palabra'
            str1_reg = self.lookup_temp('palabra')
            str2_reg = self.new_temp()  # Registrar para el nuevo valor de la cadena

            # Código MIPS para concatenar cadenas
            self.add_to_mips(('concat', str1_reg, str2_reg, '-'))
        else:
            self.add_to_mips(('CALL', method_name, '-', '-'))

        return temp

    def visitIdentifierExpression(self, ctx: yaplParser.IdentifierExpressionContext):
        print("visitIdentifierExpression")
        print(ctx.getText())
        print("op", self.action)
        si_se_usa = False
        # temp = self.lookup_temp(ctx.getText())
        if ctx.getText() in self.temps:
            # print('tiene temp')
            if self.action == "assignment":
                return ctx.getText()
            elif self.action == "operation" or self.action == "compare":
                return self.temps[ctx.getText()]
        # ver de reescribir los parametros con lo de los args cuando se definan los args
        elif ctx.getText() in self.params:
            for scope in self.listener.symbol_table.scopes:
                if ctx.getText() in scope:
                    print(self.args)
                    if scope[ctx.getText()]['valor'] in self.args:
                        return self.args[scope[ctx.getText()]['valor']]

        #     temp = self.temps[ctx.getText()]
        # else:
        #     temp = self.new_temp()
        #     self.temps[ctx.getText()] = temp

        # for scope in self.listener.symbol_table.scopes:
        #     if ctx.getText() in scope:
        #         if ('usado' in scope[ctx.getText()] and scope[ctx.getText()]['usado'] == True):
        #             si_se_usa = True
        # if self.action == "operation" and si_se_usa:
        #     self.add_to_mips(('lw', temp, ctx.ID().getText()))

        # return temp

    def visitMethodCallExpression(self, ctx: yaplParser.MethodCallExpressionContext):
        print("visitMethodCallExpression")
        print(ctx.getText())
        method_name = ctx.expression().getText()
        print(method_name)
        exp = ''
        if self.method_name:
            target_code = self.code[self.class_name][-1][f"{self.class_name}.{self.method_name}:"]
        else:
            target_code = self.code[self.class_name]

        if ctx.expressionList():
            for expression in ctx.expressionList().expression():
                print(expression.getText())
                temp = self.lookup_temp(
                    expression.getText()) or self.new_temp()
                arg = self.lookup_arg(expression.getText()) or self.new_arg()
                self.args[expression.getText()] = arg
                self.cuadruplos.append(
                    ('PARAM', expression.getText(), '-', temp))
                # self.add_to_mips(
                #     ('PARAM', expression.getText(), '-', temp))
                target_code.append(
                    f"{temp} = {expression.getText()}")
                target_code.append(
                    f"PUSHPARAM {temp}")
                self.cuadruplos.append(
                    ('PUSHPARAM', temp, '-', '-'))
                self.add_to_mips(
                    ('move', arg, temp))
            self.cuadruplos.append(('CALL', method_name, '-', '-'))
        # if method_name == 'out_int':
        #     self.add_to_mips(('',))
        #     self.add_to_mips(('lw', '$a0', exp))
        #     self.add_to_mips(('li', '$v0', '1'))
        #     self.add_to_mips(('syscall',))
        # elif method_name == 'out_string':
        #     self.add_to_mips(('',))
        #     self.add_to_mips(('li', '$v0', '4'))
        #     self.add_to_mips(('syscall',))
        if method_name == 'in_int':
            self.add_to_mips(('',))
            self.add_to_mips(('li', '$v0', '5'))
            self.add_to_mips(('syscall',))
            # self.add_to_mips(('sw', '$v0', exp))
            # self.add_to_mips(('lw', '$v0', exp))
        else:
            self.add_to_mips(('jal', method_name))
            # self.add_to_mips(('CALL', method_name, '-', '-'))

        if self.call:
            self.call = False
            return f"LCall {method_name}()"
        else:
            target_code.append(
                f"LCall {method_name}()")

    def get_size_of_type(self, type_str):
        """Devuelve el tamaño en bytes del tipo de datos proporcionado. Esto es solo un ejemplo y debe ser ajustado según el lenguaje y la plataforma."""
        type_sizes = {
            "int": 4,
            "string": 8,
            "bool": 1,
        }
        return type_sizes.get(type_str, 0)


def write_mips_code(listener, visitor, mem_sizes):
    f = open("./proyecto1App/parserYscanner/codigo.asm", "w")
    f.write('.data\n')
    for v in listener.symbol_table.scopes:
        for k2, v2 in v.items():
            if 'usado' in v2 and v2['usado'] == True:
                if v2['tipo'] == 'int':
                    if 'valor' in v2 and v2['valor'] != k2:
                        f.write(f"{k2}: .word {v2['valor']}\n")
                    else:
                        f.write(f"{k2}: .word 0\n")
                # elif v2['tipo'] == 'string':
                #     f.write(f"{k2}: .asciiz {v2['valor']}\n")
                elif v2['tipo'] == 'bool':
                    f.write(f"{k2}: .byte 0\n")
    if visitor.prompts:
        for k, v in visitor.prompts.items():
            f.write(f"{k}: .asciiz {v}\n")
    f.write('\n.text\n')
    f.write('.globl main\n\n')
    for cuadruplo in visitor.mips:
        # Convertir el cuadruplo a una lista y eliminar los elementos vacíos
        line_elements = [element for element in cuadruplo]
        # print(line_elements, len(line_elements))

        # Manejar etiquetas especiales como 'main:' o nombres de funciones
        if len(line_elements) == 2 and line_elements[0].endswith(':'):
            f.write(f"{line_elements[0]}\n")
        else:
            # Reconstruir la línea según el número de operadores
            if len(line_elements) == 3:  # instrucciones con un operador
                if (line_elements[0] == '  '):
                    f.write(
                        f"{line_elements[0]} {line_elements[1]} {line_elements[2]}\n")
                else:
                    f.write(
                        f"{line_elements[0]} {line_elements[1]}, {line_elements[2]}\n")
            elif len(line_elements) == 4:  # instrucciones con dos operadores
                if (line_elements[0] == '  '):
                    f.write(
                        f"{line_elements[0]} {line_elements[1]} {line_elements[2]}, {line_elements[3]}\n")
                else:
                    f.write(
                        f"{line_elements[0]} {line_elements[1]}, {line_elements[2]}, {line_elements[3]}\n")
            elif len(line_elements) == 5:  # instrucciones con tres operadores
                if (line_elements[0] == '  '):
                    f.write(
                        f"{line_elements[0]} {line_elements[1]} {line_elements[2]}, {line_elements[3]}, {line_elements[4]}\n")
                else:
                    f.write(
                        f"{line_elements[0]} {line_elements[1]}, {line_elements[2]}, {line_elements[3]}, {line_elements[4]}\n")
            else:
                # Para casos no cubiertos, se escribe la línea tal cual
                formatted_line = ' '.join(line_elements)
                f.write(f"{formatted_line}\n")


class AnalyzeCodeSerializer(serializers.ModelSerializer):
    class Meta:
        model = Code
        fields = ['code']


class AnalyzeCodeViewSet(viewsets.ViewSet):

    def create(self, request):
        serializer = AnalyzeCodeSerializer(data=request.data)
        if serializer.is_valid():
            input_stream = InputStream(serializer.data['code'])
            lexer = yaplLexer(input_stream)
            stream = CommonTokenStream(lexer)
            parser = yaplParser(stream)

            # Asignar el manejador de errores personalizado al analizador léxico y sintáctico
            errorListener = CustomErrorListener()
            lexer.removeErrorListeners()
            lexer.addErrorListener(errorListener)
            parser = yaplParser(stream)
            parser.removeErrorListeners()
            parser.addErrorListener(errorListener)

            tree = parser.program()
            my_listener = MyListener(errorListener)
            walker = ParseTreeWalker()
            walker.walk(my_listener, tree)

            myVisitor = MyVisitor(my_listener)
            result = myVisitor.visit(tree)

            # visualize_tree(
            #     tree, "../../interfaz-proyecto1-compis/src/assets/arbol_sintactico")
            if errorListener.errors:
                # visualize_tree(
                #     tree, "../../interfaz-proyecto1-compis/src/assets/arbol_sintactico")
                return Response({'errors': errorListener.errors, 'symbol_table': my_listener.symbol_table.scopes}, status=status.HTTP_400_BAD_REQUEST)
            else:
                # tree_str = tree.toStringTree(recog=parser)
                # tree = parse_tree(tree_str)
                write_mips_code(my_listener, myVisitor, myVisitor.mem_sizes)
                return Response({'message': 'CODIGO ANALIZADO CORRECTAMENTE!', 'symbol_table': my_listener.symbol_table.scopes, 'Codigo3Direcciones': myVisitor.code, 'Cuadruplos': myVisitor.cuadruplos, 'sizes': myVisitor.mem_sizes, 'temps': myVisitor.temps, 'mips': myVisitor.mips, 'args': myVisitor.args}, status=status.HTTP_200_OK)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

# Create your views here.
