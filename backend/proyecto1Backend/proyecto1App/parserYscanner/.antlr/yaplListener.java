// Generated from e://UVG//COMPU//2023_2ndo_semestre//COMPIS//Proyecto1_Compis_18364_18761//backend//proyecto1Backend//proyecto1App//parserYscanner//yapl.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link yaplParser}.
 */
public interface yaplListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link yaplParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(yaplParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(yaplParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(yaplParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(yaplParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#classBody}.
	 * @param ctx the parse tree
	 */
	void enterClassBody(yaplParser.ClassBodyContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#classBody}.
	 * @param ctx the parse tree
	 */
	void exitClassBody(yaplParser.ClassBodyContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#attributeDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAttributeDeclaration(yaplParser.AttributeDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#attributeDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAttributeDeclaration(yaplParser.AttributeDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#assignmentDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentDeclaration(yaplParser.AssignmentDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#assignmentDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentDeclaration(yaplParser.AssignmentDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(yaplParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(yaplParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(yaplParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(yaplParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void enterParameterList(yaplParser.ParameterListContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#parameterList}.
	 * @param ctx the parse tree
	 */
	void exitParameterList(yaplParser.ParameterListContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(yaplParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(yaplParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(yaplParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(yaplParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVariableDeclaration(yaplParser.VariableDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#variableDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVariableDeclaration(yaplParser.VariableDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#letDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterLetDeclaration(yaplParser.LetDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#letDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitLetDeclaration(yaplParser.LetDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(yaplParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#ifStatement}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(yaplParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(yaplParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#whileStatement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(yaplParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#methodCallStatement}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallStatement(yaplParser.MethodCallStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#methodCallStatement}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallStatement(yaplParser.MethodCallStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void enterExpressionStatement(yaplParser.ExpressionStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#expressionStatement}.
	 * @param ctx the parse tree
	 */
	void exitExpressionStatement(yaplParser.ExpressionStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(yaplParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#returnStatement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(yaplParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(yaplParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#expressionList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(yaplParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by {@link yaplParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(yaplParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link yaplParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(yaplParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code additionExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditionExpression(yaplParser.AdditionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code additionExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditionExpression(yaplParser.AdditionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessThanOrEqualExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessThanOrEqualExpression(yaplParser.LessThanOrEqualExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessThanOrEqualExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessThanOrEqualExpression(yaplParser.LessThanOrEqualExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpression(yaplParser.NewExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpression(yaplParser.NewExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdentifierExpression(yaplParser.IdentifierExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code identifierExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdentifierExpression(yaplParser.IdentifierExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodCallExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallExpression(yaplParser.MethodCallExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodCallExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallExpression(yaplParser.MethodCallExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignmentExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignmentExpression(yaplParser.AssignmentExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignmentExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignmentExpression(yaplParser.AssignmentExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotExpression(yaplParser.NotExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotExpression(yaplParser.NotExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code multiplicationExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicationExpression(yaplParser.MultiplicationExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code multiplicationExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicationExpression(yaplParser.MultiplicationExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notEqualExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotEqualExpression(yaplParser.NotEqualExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notEqualExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotEqualExpression(yaplParser.NotEqualExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterThanExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanExpression(yaplParser.GreaterThanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterThanExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanExpression(yaplParser.GreaterThanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code greaterThanOrEqualExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterGreaterThanOrEqualExpression(yaplParser.GreaterThanOrEqualExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code greaterThanOrEqualExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitGreaterThanOrEqualExpression(yaplParser.GreaterThanOrEqualExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteralExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteralExpression(yaplParser.StringLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteralExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteralExpression(yaplParser.StringLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpression(yaplParser.OrExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpression(yaplParser.OrExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterUnaryMinusExpression(yaplParser.UnaryMinusExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code unaryMinusExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitUnaryMinusExpression(yaplParser.UnaryMinusExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpression(yaplParser.AndExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpression(yaplParser.AndExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueLiteralExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTrueLiteralExpression(yaplParser.TrueLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueLiteralExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTrueLiteralExpression(yaplParser.TrueLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subtractionExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubtractionExpression(yaplParser.SubtractionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subtractionExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubtractionExpression(yaplParser.SubtractionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code integerLiteralExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntegerLiteralExpression(yaplParser.IntegerLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code integerLiteralExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntegerLiteralExpression(yaplParser.IntegerLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code voidLiteralExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVoidLiteralExpression(yaplParser.VoidLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code voidLiteralExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVoidLiteralExpression(yaplParser.VoidLiteralExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpression(yaplParser.EqualityExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code equalityExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpression(yaplParser.EqualityExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code lessThanExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterLessThanExpression(yaplParser.LessThanExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code lessThanExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitLessThanExpression(yaplParser.LessThanExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code divisionExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterDivisionExpression(yaplParser.DivisionExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code divisionExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitDivisionExpression(yaplParser.DivisionExpressionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code falseLiteralExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFalseLiteralExpression(yaplParser.FalseLiteralExpressionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseLiteralExpression}
	 * labeled alternative in {@link yaplParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFalseLiteralExpression(yaplParser.FalseLiteralExpressionContext ctx);
}