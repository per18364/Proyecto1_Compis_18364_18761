from rest_framework import serializers, viewsets, status
from rest_framework.views import APIView
from rest_framework.response import Response
from .models import Code
from .parserYscanner.yaplLexer import yaplLexer
from .parserYscanner.yaplParser import yaplParser
from .parserYscanner.yaplListener import yaplListener
from antlr4 import *
from antlr4 import InputStream, CommonTokenStream
from antlr4.error.ErrorListener import ErrorListener
from graphviz import Digraph


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
        if isinstance(recognizer, yaplLexer):
            err = msg.split("'")[1]
            self.errors.append(
                f"ERROR léxico en línea {line}, columna {column}: Carácter inesperado -> '{err}'")
        else:
            if offendingSymbol.text not in self.table.scopes[-1]:
                self.errors.append(
                    f"ERROR semántico en línea {line}, columna {column}: {offendingSymbol.text} no ha sido declarado")
            else:
                self.errors.append(
                    f"ERROR sintáctico en línea {line}, columna {column}: {msg}")


class SymbolTable:
    def __init__(self):
        self.scopes = [{}]

    def enter_scope(self):
        self.scopes.append({})

    def exit_scope(self):
        if len(self.scopes) > 1:
            self.scopes.pop()
        else:
            print("Warning: Trying to exit the global scope!")

    def declare(self, symbol, type, line=None, column=None):
        if symbol in self.scopes[-1]:
            print(
                f"Simbolo {symbol} ya fue declarado en la linea {line}, columna {column}")
        self.scopes[-1][symbol] = {'tipo': type,
                                   'linea': line, 'columna': column}
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


class MyListener(yaplListener):
    def __init__(self, error_listener):
        self.symbol_table = SymbolTable()
        self.error_listener = error_listener
        self.inside_block = False
        self.block_depth = 0

    def declareSymbol(self, ctx, symbol, symbol_type):
        """Maneja símbolos, ya sea para declarar o verificar su uso."""
        line = ctx.start.line
        column = ctx.start.column

        # Si symbol_type no es None, estamos declarando el símbolo
        print(symbol_type, symbol)
        if symbol_type:
            if self.symbol_table.is_declared(symbol, current_scope_only=False):
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
                    f"ERROR semántico en línea {line}:{column}. Uso de {symbol} que no ha sido declarado.")

    def accessSymbol(self, ctx, symbol):
        """Maneja el acceso a símbolos, ya sea para uso o para asignación."""
        line = ctx.start.line
        column = ctx.start.column
        if not self.symbol_table.is_declared(symbol):
            self.error_listener.errors.append(
                f"ERROR semántico en línea {line}:{column}. Uso de {symbol} que no ha sido declarado.")

    def enterClassDeclaration(self, ctx: yaplParser.ClassDeclarationContext):
        print("\nEntrando en ClassDeclaration")
        class_name = ctx.TYPE_ID()[0].getText()
        self.declareSymbol(ctx, class_name, "class")
        self.symbol_table.enter_scope()  # Nuevo ámbito para la clase

    def exitClassDeclaration(self, ctx: yaplParser.ClassDeclarationContext):
        print("Saliendo de ClassDeclaration")
        # self.symbol_table.exit_scope()  # Salir del ámbito de la clase

    def enterMethodDeclaration(self, ctx: yaplParser.MethodDeclarationContext):
        print("Entrando en MethodDeclaration")
        method_name = ctx.ID().getText()
        # Esto devuelve el texto del tipo
        method_type = ctx.getChild(0).getText()
        self.declareSymbol(ctx, method_name, "method: " + method_type)
        self.symbol_table.enter_scope()  # Nuevo ámbito para el método

    def exitMethodDeclaration(self, ctx: yaplParser.MethodDeclarationContext):
        print("Saliendo de MethodDeclaration")
        self.symbol_table.exit_scope()  # Salir del ámbito del método

    def enterBlock(self, ctx: yaplParser.BlockContext):
        print("Entrando en Block")
        self.inside_block = True
        self.block_depth += 1
        self.symbol_table.enter_scope()  # Nuevo ámbito para el bloque

    def exitBlock(self, ctx: yaplParser.BlockContext):
        print("Saliendo de Block")
        self.inside_block = False
        self.block_depth -= 1
        # self.symbol_table.exit_scope()  # Salir del ámbito del bloque

    def enterVariableDeclaration(self, ctx: yaplParser.VariableDeclarationContext):
        # if self.block_depth > 0:  # Solo si estamos dentro de un bloque
        print("Declaración de variable dentro de un bloque")
        symbol = ctx.ID().getText()
        type_ctx = ctx.getChild(0)
        type_text = type_ctx.getText()  # Esto devuelve el texto del tipo
        self.declareSymbol(ctx, symbol, type_text)
        self.symbol_table.enter_scope()  # Nuevo ámbito para la variable

    def exitVariableDeclaration(self, ctx: yaplParser.VariableDeclarationContext):
        if self.block_depth > 0:  # Solo si estamos dentro de un bloque
            print("Saliendo de VariableDeclaration")
            # self.symbol_table.exit_scope()

    def enterAttributeDeclaration(self, ctx: yaplParser.AttributeDeclarationContext):
        print("Entrando en AttributeDeclaration")
        symbol = ctx.ID().getText()
        # Esto devuelve el primer hijo, que debe ser el contexto de 'type'
        type_ctx = ctx.getChild(0)
        type_text = type_ctx.getText()  # Esto devuelve el texto del tipo
        self.declareSymbol(ctx, symbol, type_text)
        self.symbol_table.enter_scope()  # Nuevo ámbito para el atributo


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
            visualize_tree(
                tree, "../../interfaz-proyecto1-compis/src/assets/arbol_sintactico")
            if errorListener.errors:
                # visualize_tree(
                #     tree, "../../interfaz-proyecto1-compis/src/assets/arbol_sintactico")
                return Response({'errors': errorListener.errors}, status=status.HTTP_400_BAD_REQUEST)
            else:
                tree_str = tree.toStringTree(recog=parser)
                # tree = parse_tree(tree_str)
                return Response({'tree': tree_str, 'symbol_table': my_listener.symbol_table.scopes}, status=status.HTTP_200_OK)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

# Create your views here.
