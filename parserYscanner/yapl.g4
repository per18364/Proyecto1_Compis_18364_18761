grammar yapl;

// Tokens
LBRACE: '{';
RBRACE: '}';
LPAREN: '(';
RPAREN: ')';
SEMI: ';';
COMMA: ',';
EQUALS: '=';
PLUS: '+';
MINUS: '-';
MULT: '*';
DIV: '/';
EQ: '==';
LT: '<';

// Program
program: classDeclaration* EOF;

// Class Declaration
classDeclaration:
	CLASS TYPE_ID (INHERITS TYPE_ID)? LBRACE classBody RBRACE;

// Class Body
classBody: (attributeDeclaration | methodDeclaration)*;

// Attribute Declaration
attributeDeclaration: type ID SEMI;

// Types
type: INT | STRING_TYPE | TYPE_ID;

// Method Declaration
methodDeclaration: type ID LPAREN parameterList? RPAREN block;

// Parameter List
parameterList: parameter (COMMA parameter)*;
parameter: type ID;

// Block
block: LBRACE statement* RBRACE;

// Statement
statement:
	assignmentStatement
	| variableDeclaration
	| ifStatement
	| whileStatement
	| methodCallStatement
	| returnStatement
	| block;

// Assignment Statement
assignmentStatement: ID EQUALS expression SEMI;

// Variable Declaration
variableDeclaration: type ID (EQUALS expression)? SEMI;

// If Statement
ifStatement:
	IF LPAREN expression RPAREN statement (ELSE statement)? FI;

// While Statement
whileStatement: WHILE LPAREN expression RPAREN statement;

// Method Call Statement
methodCallStatement: ID LPAREN expressionList? RPAREN SEMI;

// Return Statement
returnStatement: RETURN expression? SEMI;

// Expression List
expressionList: expression (COMMA expression)*;

// Expressions
expression:
	expression PLUS expression							# additionExpression
	| expression MINUS expression						# subtractionExpression
	| expression MULT expression						# multiplicationExpression
	| expression DIV expression							# divisionExpression
	| expression EQ expression							# equalityExpression
	| expression LT expression							# lessThanExpression
	| expression DOT ID LPAREN expressionList? RPAREN	# methodCallExpression
	| NOT expression									# notExpression
	| MINUS expression									# unaryMinusExpression
	| ID LPAREN expressionList? RPAREN					# methodCallExpression
	| ID												# identifierExpression
	| INTEGER											# integerLiteralExpression
	| STRING											# stringLiteralExpression
	| TRUE												# trueLiteralExpression
	| FALSE												# falseLiteralExpression
	| LPAREN expression RPAREN							# parenthesizedExpression;

// Reserved Words
TRUE: 'true';
DOT: '.';
FALSE: 'false';
CLASS: 'class';
INHERITS: 'inherits';
SELF: 'self';
SELF_TYPE: 'SELF_TYPE';
ELSE: 'else';
FI: 'fi';
IF: 'if';
WHILE: 'while';
NEW: 'new';
ISVOID: 'isvoid';
NOT: 'not';
RETURN: 'return';
INT: 'int';
STRING_TYPE: 'string';

// Lexical Specifications
ID: [a-z][a-zA-Z0-9_]*;
TYPE_ID: [A-Z][a-zA-Z0-9_]*;
INTEGER: [0-9]+;
STRING: '"' ( ~["\n\r\t\\] | EscapeSequence)* '"';
fragment EscapeSequence:
	'\\' ('\\' | 'b' | 't' | 'n' | 'r' | 'f');
COMMENT: ('--' .*? '\n' | '(*' .*? '*)') -> skip;
WS: [ \t\r\n]+ -> skip;
