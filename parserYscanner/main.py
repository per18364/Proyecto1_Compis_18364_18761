from antlr4 import *
from yaplLexer import yaplLexer
from yaplParser import yaplParser
from yaplListener import yaplListener
from antlr4.tree.Trees import Trees
from antlr4.error.ErrorListener import ErrorListener
from graphviz import Digraph


def visualize_tree(tree, filename):
    graph = Digraph(comment='YAPL Syntax Tree')
    build_graph(tree, graph)
    graph.render(filename, view=True)


def build_graph(tree, graph, parent=None):
    if tree.getText():
        node = str(hash(tree))
        graph.node(node, tree.getText())
        if parent:
            graph.edge(parent, node)
        for i in range(tree.getChildCount()):
            build_graph(tree.getChild(i), graph, node)


class CustomErrorListener(ErrorListener):
    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        # Personalizar el mensaje de error para el análisis sintáctico
        print(f"\nERROR sintáctico en línea {line}, columna {column}: {msg}\n")

    def reportError(self, recognizer, e):
        # Personalizar el mensaje de error para el análisis léxico
        token = recognizer.getCurrentToken()
        line = token.line
        column = token.column
        print(
            f"\nERROR léxico en línea {line}, columna {column}: Carácter inesperado '{token.text}'\n")


class yaplListener(ParseTreeListener):
    def enterExpression(self, ctx: yaplParser.ExpressionContext):
        print("Entrando en expresión:", ctx.getText())

    def exitExpression(self, ctx: yaplParser.ExpressionContext):
        print("Saliendo de expresión:", ctx.getText())

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

    def enterClassDeclaration(self, ctx:yaplParser.ClassDeclarationContext):
        print("Entrando en ClassDeclaration")  
        class_name = ctx.TYPE_ID()[0].getText()
        self.symbol_table.declare(class_name, "class")
        self.symbol_table.enter_scope()  # Nuevo ámbito para la clase

    def exitClassDeclaration(self, ctx:yaplParser.ClassDeclarationContext):
        print("Saliendo de ClassDeclaration")
        # self.symbol_table.exit_scope()  # Salir del ámbito de la clase

    def enterMethodDeclaration(self, ctx:yaplParser.MethodDeclarationContext):
        print("Entrando en MethodDeclaration")
        method_name = ctx.ID().getText()
        method_type = ctx.getChild(0).getText()  # Esto devuelve el texto del tipo
        self.symbol_table.declare(method_name, "method: " + method_type)
        self.symbol_table.enter_scope()  # Nuevo ámbito para el método

    def exitMethodDeclaration(self, ctx:yaplParser.MethodDeclarationContext):
        print("Saliendo de MethodDeclaration")
        self.symbol_table.exit_scope()  # Salir del ámbito del método

    def enterBlock(self, ctx:yaplParser.BlockContext):
        print("Entrando en Block")
        self.symbol_table.enter_scope()  # Nuevo ámbito para el bloque

    def exitBlock(self, ctx:yaplParser.BlockContext):
        print("Saliendo de Block")
        self.symbol_table.exit_scope()  # Salir del ámbito del bloque

    def enterAttributeDeclaration(self, ctx:yaplParser.AttributeDeclarationContext):
        print("Entrando en AttributeDeclaration")
        symbol = ctx.ID().getText()
        type_ctx = ctx.getChild(0)  # Esto devuelve el primer hijo, que debe ser el contexto de 'type'
        type_text = type_ctx.getText()  # Esto devuelve el texto del tipo
        self.symbol_table.declare(symbol, type_text)


def main():
    # Lee el código fuente de YAPL desde un archivo o un string
    # input_stream = FileStream("codigo.yapl")
    with open("codigo.yapl", "r", encoding="utf-8") as file:
        input_text = file.read()
    input_stream = InputStream(input_text)

    lexer = yaplLexer(input_stream)
    stream = CommonTokenStream(lexer)
    parser = yaplParser(stream)

    # Asignar el manejador de errores personalizado al analizador léxico y sintáctico
    lexer.removeErrorListeners()
    lexer.addErrorListener(CustomErrorListener())
    parser = yaplParser(stream)
    parser.removeErrorListeners()
    parser.addErrorListener(CustomErrorListener())

    # tree = parser.expression()
    tree = parser.program()

    # Visualizar el árbol de análisis sintáctico en consola
    print('Arbol de analisis sintactico: ',
          Trees.toStringTree(tree, recog=parser), "\n")

    # Crear el árbol de análisis
    # yl = yaplListener()
    # walker = ParseTreeWalker()
    # walker.walk(yl, tree)
    
    #crear tabla de simbolos
    my_listener = MyListener()
    walker = ParseTreeWalker()
    walker.walk(my_listener, tree)
    print("\nTabla de Simbolos: \n", my_listener.symbol_table.scopes)

    visualize_tree(tree, "arbol_sintactico.pdf")


if __name__ == '__main__':
    main()
