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

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        # Personalizar el mensaje de error para el análisis sintáctico
        self.errors.append(
            f"\nERROR sintáctico en línea {line}, columna {column}: {msg}\n")

    def reportError(self, recognizer, e):
        # Personalizar el mensaje de error para el análisis léxico
        token = recognizer.getCurrentToken()
        line = token.line
        column = token.column
        self.errors.append(
            f"\nERROR léxico en línea {line}, columna {column}: Carácter inesperado '{token.text}'\n")


class SymbolTable:
    def __init__(self):
        self.scopes = [{}]

    def enter_scope(self):
        self.scopes.append({})

    def exit_scope(self):
        self.scopes.pop()

    def declare(self, symbol, type):
        self.scopes[-1][symbol] = type

    def lookup(self, symbol):
        for scope in reversed(self.scopes):
            if symbol in scope:
                return scope[symbol]
        return None


class MyListener(yaplListener):
    def __init__(self):
        self.symbol_table = SymbolTable()

    def enterClassDeclaration(self, ctx: yaplParser.ClassDeclarationContext):
        print("Entrando en ClassDeclaration")
        class_name = ctx.TYPE_ID()[0].getText()
        self.symbol_table.declare(class_name, "class")
        self.symbol_table.enter_scope()  # Nuevo ámbito para la clase

    def exitClassDeclaration(self, ctx: yaplParser.ClassDeclarationContext):
        print("Saliendo de ClassDeclaration")
        # self.symbol_table.exit_scope()  # Salir del ámbito de la clase

    def enterMethodDeclaration(self, ctx: yaplParser.MethodDeclarationContext):
        print("Entrando en MethodDeclaration")
        method_name = ctx.ID().getText()
        # Esto devuelve el texto del tipo
        method_type = ctx.getChild(0).getText()
        self.symbol_table.declare(method_name, "method: " + method_type)
        self.symbol_table.enter_scope()  # Nuevo ámbito para el método

    def exitMethodDeclaration(self, ctx: yaplParser.MethodDeclarationContext):
        print("Saliendo de MethodDeclaration")
        self.symbol_table.exit_scope()  # Salir del ámbito del método

    def enterBlock(self, ctx: yaplParser.BlockContext):
        print("Entrando en Block")
        self.symbol_table.enter_scope()  # Nuevo ámbito para el bloque

    def exitBlock(self, ctx: yaplParser.BlockContext):
        print("Saliendo de Block")
        self.symbol_table.exit_scope()  # Salir del ámbito del bloque

    def enterAttributeDeclaration(self, ctx: yaplParser.AttributeDeclarationContext):
        print("Entrando en AttributeDeclaration")
        symbol = ctx.ID().getText()
        # Esto devuelve el primer hijo, que debe ser el contexto de 'type'
        type_ctx = ctx.getChild(0)
        type_text = type_ctx.getText()  # Esto devuelve el texto del tipo
        self.symbol_table.declare(symbol, type_text)


# def parse_tree(tree_str):
#     tokens = tree_str.split()
#     stack = []
#     current_node = {}

#     for token in tokens:
#         if token == '(':
#             new_node = {}
#             stack.append(current_node)
#             current_node = new_node
#         elif token == ')':
#             last_node = stack.pop()
#             if not last_node:
#                 return current_node  # Raíz del árbol
#             parent_key = list(last_node.keys())[-1]
#             if isinstance(last_node[parent_key], dict):
#                 if "children" not in last_node[parent_key]:
#                     last_node[parent_key]['children'] = []
#                 last_node[parent_key]['children'].append(current_node)
#             current_node = last_node
#         else:
#             if token not in current_node:
#                 current_node[token] = {}

#     return current_node


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
            my_listener = MyListener()
            walker = ParseTreeWalker()
            walker.walk(my_listener, tree)

            if errorListener.errors:
                visualize_tree(
                    tree, "../../interfaz-proyecto1-compis/src/assets/arbol_sintactico")
                return Response({'errors': errorListener.errors}, status=status.HTTP_400_BAD_REQUEST)
            else:
                tree_str = tree.toStringTree(recog=parser)
                # tree = parse_tree(tree_str)
                visualize_tree(
                    tree, "../../interfaz-proyecto1-compis/src/assets/arbol_sintactico")
                return Response({'tree': tree_str, 'symbol_table': my_listener.symbol_table.scopes}, status=status.HTTP_200_OK)
        else:
            return Response(serializer.errors, status=status.HTTP_400_BAD_REQUEST)

# Create your views here.
