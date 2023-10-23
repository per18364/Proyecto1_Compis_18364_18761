// Generated from e://UVG//COMPU//2023_2ndo_semestre//COMPIS//Proyecto1_Compis_18364_18761//backend//proyecto1Backend//proyecto1App//parserYscanner//yapl.g4 by ANTLR 4.13.1
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class yaplParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LBRACE=1, RBRACE=2, LPAREN=3, RPAREN=4, SEMI=5, COMMA=6, EQUALS=7, ASSIGN=8, 
		PLUS=9, MINUS=10, MULT=11, DIV=12, EQ=13, NEQ=14, LT=15, GT=16, GT_EQ=17, 
		LT_EQ=18, AND=19, OR=20, COLON=21, TRUE=22, DOT=23, FALSE=24, CLASS=25, 
		INHERITS=26, SELF=27, SELF_TYPE=28, ELSE=29, FI=30, IF=31, WHILE=32, NEW=33, 
		ISVOID=34, NOT=35, RETURN=36, INT=37, STRING_TYPE=38, BOOL=39, VOID=40, 
		LET=41, IN=42, ID=43, TYPE_ID=44, INTEGER=45, STRING=46, COMMENT=47, WS=48;
	public static final int
		RULE_program = 0, RULE_classDeclaration = 1, RULE_classBody = 2, RULE_attributeDeclaration = 3, 
		RULE_assignmentDeclaration = 4, RULE_type = 5, RULE_methodDeclaration = 6, 
		RULE_parameterList = 7, RULE_parameter = 8, RULE_statement = 9, RULE_variableDeclaration = 10, 
		RULE_letDeclaration = 11, RULE_ifStatement = 12, RULE_whileStatement = 13, 
		RULE_methodCallStatement = 14, RULE_expressionStatement = 15, RULE_returnStatement = 16, 
		RULE_expressionList = 17, RULE_block = 18, RULE_expression = 19;
	private static String[] makeRuleNames() {
		return new String[] {
			"program", "classDeclaration", "classBody", "attributeDeclaration", "assignmentDeclaration", 
			"type", "methodDeclaration", "parameterList", "parameter", "statement", 
			"variableDeclaration", "letDeclaration", "ifStatement", "whileStatement", 
			"methodCallStatement", "expressionStatement", "returnStatement", "expressionList", 
			"block", "expression"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "';'", "','", "'='", "'<-'", "'+'", 
			"'-'", "'*'", "'/'", "'=='", "'!='", "'<'", "'>'", "'>='", "'<='", "'&&'", 
			"'||'", "':'", "'true'", "'.'", "'false'", "'class'", "'inherits'", "'self'", 
			"'SELF_TYPE'", "'else'", "'fi'", "'if'", "'while'", "'new'", "'isvoid'", 
			"'not'", "'return'", "'int'", "'string'", "'bool'", "'void'", "'let'", 
			"'in'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LBRACE", "RBRACE", "LPAREN", "RPAREN", "SEMI", "COMMA", "EQUALS", 
			"ASSIGN", "PLUS", "MINUS", "MULT", "DIV", "EQ", "NEQ", "LT", "GT", "GT_EQ", 
			"LT_EQ", "AND", "OR", "COLON", "TRUE", "DOT", "FALSE", "CLASS", "INHERITS", 
			"SELF", "SELF_TYPE", "ELSE", "FI", "IF", "WHILE", "NEW", "ISVOID", "NOT", 
			"RETURN", "INT", "STRING_TYPE", "BOOL", "VOID", "LET", "IN", "ID", "TYPE_ID", 
			"INTEGER", "STRING", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "yapl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public yaplParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgramContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(yaplParser.EOF, 0); }
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(43);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CLASS) {
				{
				{
				setState(40);
				classDeclaration();
				}
				}
				setState(45);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(46);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclarationContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(yaplParser.CLASS, 0); }
		public List<TerminalNode> TYPE_ID() { return getTokens(yaplParser.TYPE_ID); }
		public TerminalNode TYPE_ID(int i) {
			return getToken(yaplParser.TYPE_ID, i);
		}
		public TerminalNode LBRACE() { return getToken(yaplParser.LBRACE, 0); }
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TerminalNode RBRACE() { return getToken(yaplParser.RBRACE, 0); }
		public TerminalNode INHERITS() { return getToken(yaplParser.INHERITS, 0); }
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(CLASS);
			setState(49);
			match(TYPE_ID);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==INHERITS) {
				{
				setState(50);
				match(INHERITS);
				setState(51);
				match(TYPE_ID);
				}
			}

			setState(54);
			match(LBRACE);
			setState(55);
			classBody();
			setState(56);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyContext extends ParserRuleContext {
		public List<AttributeDeclarationContext> attributeDeclaration() {
			return getRuleContexts(AttributeDeclarationContext.class);
		}
		public AttributeDeclarationContext attributeDeclaration(int i) {
			return getRuleContext(AttributeDeclarationContext.class,i);
		}
		public List<MethodDeclarationContext> methodDeclaration() {
			return getRuleContexts(MethodDeclarationContext.class);
		}
		public MethodDeclarationContext methodDeclaration(int i) {
			return getRuleContext(MethodDeclarationContext.class,i);
		}
		public List<AssignmentDeclarationContext> assignmentDeclaration() {
			return getRuleContexts(AssignmentDeclarationContext.class);
		}
		public AssignmentDeclarationContext assignmentDeclaration(int i) {
			return getRuleContext(AssignmentDeclarationContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_classBody);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 136320538117122L) != 0)) {
				{
				setState(62);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(58);
					attributeDeclaration();
					}
					break;
				case 2:
					{
					setState(59);
					methodDeclaration();
					}
					break;
				case 3:
					{
					setState(60);
					assignmentDeclaration();
					}
					break;
				case 4:
					{
					setState(61);
					statement();
					}
					break;
				}
				}
				setState(66);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AttributeDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public TerminalNode SEMI() { return getToken(yaplParser.SEMI, 0); }
		public AttributeDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_attributeDeclaration; }
	}

	public final AttributeDeclarationContext attributeDeclaration() throws RecognitionException {
		AttributeDeclarationContext _localctx = new AttributeDeclarationContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_attributeDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			type();
			setState(68);
			match(ID);
			setState(69);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentDeclarationContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(yaplParser.ASSIGN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(yaplParser.SEMI, 0); }
		public AssignmentDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentDeclaration; }
	}

	public final AssignmentDeclarationContext assignmentDeclaration() throws RecognitionException {
		AssignmentDeclarationContext _localctx = new AssignmentDeclarationContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_assignmentDeclaration);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			match(ID);
			setState(72);
			match(ASSIGN);
			setState(73);
			expression(0);
			setState(74);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(yaplParser.INT, 0); }
		public TerminalNode STRING_TYPE() { return getToken(yaplParser.STRING_TYPE, 0); }
		public TerminalNode TYPE_ID() { return getToken(yaplParser.TYPE_ID, 0); }
		public TerminalNode BOOL() { return getToken(yaplParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(yaplParser.VOID, 0); }
		public TerminalNode SELF_TYPE() { return getToken(yaplParser.SELF_TYPE, 0); }
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 19654038781952L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(yaplParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(yaplParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public ParameterListContext parameterList() {
			return getRuleContext(ParameterListContext.class,0);
		}
		public MethodDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodDeclaration; }
	}

	public final MethodDeclarationContext methodDeclaration() throws RecognitionException {
		MethodDeclarationContext _localctx = new MethodDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_methodDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			type();
			setState(79);
			match(ID);
			setState(80);
			match(LPAREN);
			setState(82);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 19654038781952L) != 0)) {
				{
				setState(81);
				parameterList();
				}
			}

			setState(84);
			match(RPAREN);
			setState(85);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterListContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(yaplParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(yaplParser.COMMA, i);
		}
		public ParameterListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterList; }
	}

	public final ParameterListContext parameterList() throws RecognitionException {
		ParameterListContext _localctx = new ParameterListContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_parameterList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(87);
			parameter();
			setState(92);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(88);
				match(COMMA);
				setState(89);
				parameter();
				}
				}
				setState(94);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(95);
			type();
			setState(96);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public LetDeclarationContext letDeclaration() {
			return getRuleContext(LetDeclarationContext.class,0);
		}
		public IfStatementContext ifStatement() {
			return getRuleContext(IfStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public MethodCallStatementContext methodCallStatement() {
			return getRuleContext(MethodCallStatementContext.class,0);
		}
		public ExpressionStatementContext expressionStatement() {
			return getRuleContext(ExpressionStatementContext.class,0);
		}
		public ReturnStatementContext returnStatement() {
			return getRuleContext(ReturnStatementContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_statement);
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(98);
				variableDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(99);
				letDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				ifStatement();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(101);
				whileStatement();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(102);
				methodCallStatement();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(103);
				expressionStatement();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(104);
				returnStatement();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(105);
				block();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public TerminalNode ASSIGN() { return getToken(yaplParser.ASSIGN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			type();
			setState(109);
			match(ID);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(110);
				match(ASSIGN);
				setState(111);
				statement();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LetDeclarationContext extends ParserRuleContext {
		public TerminalNode LET() { return getToken(yaplParser.LET, 0); }
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> ID() { return getTokens(yaplParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(yaplParser.ID, i);
		}
		public TerminalNode IN() { return getToken(yaplParser.IN, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode SEMI() { return getToken(yaplParser.SEMI, 0); }
		public List<TerminalNode> ASSIGN() { return getTokens(yaplParser.ASSIGN); }
		public TerminalNode ASSIGN(int i) {
			return getToken(yaplParser.ASSIGN, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(yaplParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(yaplParser.COMMA, i);
		}
		public LetDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_letDeclaration; }
	}

	public final LetDeclarationContext letDeclaration() throws RecognitionException {
		LetDeclarationContext _localctx = new LetDeclarationContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_letDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(114);
			match(LET);
			setState(115);
			type();
			setState(116);
			match(ID);
			setState(119);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ASSIGN) {
				{
				setState(117);
				match(ASSIGN);
				setState(118);
				expression(0);
				}
			}

			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(121);
				match(COMMA);
				setState(122);
				type();
				setState(123);
				match(ID);
				setState(126);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==ASSIGN) {
					{
					setState(124);
					match(ASSIGN);
					setState(125);
					expression(0);
					}
				}

				}
				}
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(133);
			match(IN);
			setState(134);
			expression(0);
			setState(135);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfStatementContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(yaplParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(yaplParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(yaplParser.RPAREN, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode FI() { return getToken(yaplParser.FI, 0); }
		public TerminalNode ELSE() { return getToken(yaplParser.ELSE, 0); }
		public IfStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifStatement; }
	}

	public final IfStatementContext ifStatement() throws RecognitionException {
		IfStatementContext _localctx = new IfStatementContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_ifStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			match(IF);
			setState(138);
			match(LPAREN);
			setState(139);
			expression(0);
			setState(140);
			match(RPAREN);
			setState(141);
			statement();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ELSE) {
				{
				setState(142);
				match(ELSE);
				setState(143);
				statement();
				}
			}

			setState(146);
			match(FI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(yaplParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(yaplParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(yaplParser.RPAREN, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_whileStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(148);
			match(WHILE);
			setState(149);
			match(LPAREN);
			setState(150);
			expression(0);
			setState(151);
			match(RPAREN);
			setState(152);
			statement();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MethodCallStatementContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(yaplParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(yaplParser.RPAREN, 0); }
		public TerminalNode SEMI() { return getToken(yaplParser.SEMI, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public MethodCallStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_methodCallStatement; }
	}

	public final MethodCallStatementContext methodCallStatement() throws RecognitionException {
		MethodCallStatementContext _localctx = new MethodCallStatementContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_methodCallStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(154);
			match(ID);
			setState(155);
			match(LPAREN);
			setState(157);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 115491825779712L) != 0)) {
				{
				setState(156);
				expressionList();
				}
			}

			setState(159);
			match(RPAREN);
			setState(160);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionStatementContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(yaplParser.SEMI, 0); }
		public ExpressionStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionStatement; }
	}

	public final ExpressionStatementContext expressionStatement() throws RecognitionException {
		ExpressionStatementContext _localctx = new ExpressionStatementContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_expressionStatement);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(162);
			expression(0);
			setState(163);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReturnStatementContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(yaplParser.RETURN, 0); }
		public TerminalNode SEMI() { return getToken(yaplParser.SEMI, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_returnStatement; }
	}

	public final ReturnStatementContext returnStatement() throws RecognitionException {
		ReturnStatementContext _localctx = new ReturnStatementContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_returnStatement);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(RETURN);
			setState(167);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 115491825779712L) != 0)) {
				{
				setState(166);
				expression(0);
				}
			}

			setState(169);
			match(SEMI);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionListContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(yaplParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(yaplParser.COMMA, i);
		}
		public ExpressionListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expressionList; }
	}

	public final ExpressionListContext expressionList() throws RecognitionException {
		ExpressionListContext _localctx = new ExpressionListContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_expressionList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(171);
			expression(0);
			setState(176);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(172);
				match(COMMA);
				setState(173);
				expression(0);
				}
				}
				setState(178);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LBRACE() { return getToken(yaplParser.LBRACE, 0); }
		public TerminalNode RBRACE() { return getToken(yaplParser.RBRACE, 0); }
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(179);
			match(LBRACE);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 136320538117122L) != 0)) {
				{
				{
				setState(180);
				statement();
				}
				}
				setState(185);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(186);
			match(RBRACE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	@SuppressWarnings("CheckReturnValue")
	public static class ClassMethodCallExpressionContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode DOT() { return getToken(yaplParser.DOT, 0); }
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public TerminalNode LPAREN() { return getToken(yaplParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(yaplParser.RPAREN, 0); }
		public ExpressionListContext expressionList() {
			return getRuleContext(ExpressionListContext.class,0);
		}
		public ClassMethodCallExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AdditionExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode PLUS() { return getToken(yaplParser.PLUS, 0); }
		public AdditionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessThanOrEqualExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LT_EQ() { return getToken(yaplParser.LT_EQ, 0); }
		public LessThanOrEqualExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NewExpressionContext extends ExpressionContext {
		public TerminalNode NEW() { return getToken(yaplParser.NEW, 0); }
		public TerminalNode TYPE_ID() { return getToken(yaplParser.TYPE_ID, 0); }
		public NewExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierExpressionContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(yaplParser.ID, 0); }
		public IdentifierExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode ASSIGN() { return getToken(yaplParser.ASSIGN, 0); }
		public AssignmentExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotExpressionContext extends ExpressionContext {
		public TerminalNode NOT() { return getToken(yaplParser.NOT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SelfLiteralExpressionContext extends ExpressionContext {
		public TerminalNode SELF() { return getToken(yaplParser.SELF, 0); }
		public SelfLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicationExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MULT() { return getToken(yaplParser.MULT, 0); }
		public MultiplicationExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class NotEqualExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode NEQ() { return getToken(yaplParser.NEQ, 0); }
		public NotEqualExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterThanExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GT() { return getToken(yaplParser.GT, 0); }
		public GreaterThanExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class GreaterThanOrEqualExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode GT_EQ() { return getToken(yaplParser.GT_EQ, 0); }
		public GreaterThanOrEqualExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralExpressionContext extends ExpressionContext {
		public TerminalNode STRING() { return getToken(yaplParser.STRING, 0); }
		public StringLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class OrExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode OR() { return getToken(yaplParser.OR, 0); }
		public OrExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class UnaryMinusExpressionContext extends ExpressionContext {
		public TerminalNode MINUS() { return getToken(yaplParser.MINUS, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UnaryMinusExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class AndExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode AND() { return getToken(yaplParser.AND, 0); }
		public AndExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class TrueLiteralExpressionContext extends ExpressionContext {
		public TerminalNode TRUE() { return getToken(yaplParser.TRUE, 0); }
		public TrueLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class SubtractionExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode MINUS() { return getToken(yaplParser.MINUS, 0); }
		public SubtractionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class IntegerLiteralExpressionContext extends ExpressionContext {
		public TerminalNode INTEGER() { return getToken(yaplParser.INTEGER, 0); }
		public IntegerLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class VoidLiteralExpressionContext extends ExpressionContext {
		public TerminalNode VOID() { return getToken(yaplParser.VOID, 0); }
		public VoidLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class EqualityExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode EQ() { return getToken(yaplParser.EQ, 0); }
		public EqualityExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class LessThanExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode LT() { return getToken(yaplParser.LT, 0); }
		public LessThanExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class DivisionExpressionContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode DIV() { return getToken(yaplParser.DIV, 0); }
		public DivisionExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}
	@SuppressWarnings("CheckReturnValue")
	public static class FalseLiteralExpressionContext extends ExpressionContext {
		public TerminalNode FALSE() { return getToken(yaplParser.FALSE, 0); }
		public FalseLiteralExpressionContext(ExpressionContext ctx) { copyFrom(ctx); }
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NEW:
				{
				_localctx = new NewExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(189);
				match(NEW);
				setState(190);
				match(TYPE_ID);
				}
				break;
			case NOT:
				{
				_localctx = new NotExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(191);
				match(NOT);
				setState(192);
				expression(10);
				}
				break;
			case MINUS:
				{
				_localctx = new UnaryMinusExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(MINUS);
				setState(194);
				expression(9);
				}
				break;
			case ID:
				{
				_localctx = new IdentifierExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(ID);
				}
				break;
			case SELF:
				{
				_localctx = new SelfLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				match(SELF);
				}
				break;
			case INTEGER:
				{
				_localctx = new IntegerLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(INTEGER);
				}
				break;
			case STRING:
				{
				_localctx = new StringLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				match(STRING);
				}
				break;
			case TRUE:
				{
				_localctx = new TrueLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(199);
				match(TRUE);
				}
				break;
			case FALSE:
				{
				_localctx = new FalseLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(200);
				match(FALSE);
				}
				break;
			case VOID:
				{
				_localctx = new VoidLiteralExpressionContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(201);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(253);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(251);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new MultiplicationExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(204);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(205);
						match(MULT);
						setState(206);
						expression(25);
						}
						break;
					case 2:
						{
						_localctx = new DivisionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(207);
						if (!(precpred(_ctx, 23))) throw new FailedPredicateException(this, "precpred(_ctx, 23)");
						setState(208);
						match(DIV);
						setState(209);
						expression(24);
						}
						break;
					case 3:
						{
						_localctx = new AdditionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(210);
						if (!(precpred(_ctx, 22))) throw new FailedPredicateException(this, "precpred(_ctx, 22)");
						setState(211);
						match(PLUS);
						setState(212);
						expression(23);
						}
						break;
					case 4:
						{
						_localctx = new SubtractionExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(213);
						if (!(precpred(_ctx, 21))) throw new FailedPredicateException(this, "precpred(_ctx, 21)");
						setState(214);
						match(MINUS);
						setState(215);
						expression(22);
						}
						break;
					case 5:
						{
						_localctx = new EqualityExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(216);
						if (!(precpred(_ctx, 20))) throw new FailedPredicateException(this, "precpred(_ctx, 20)");
						setState(217);
						match(EQ);
						setState(218);
						expression(21);
						}
						break;
					case 6:
						{
						_localctx = new LessThanExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(219);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(220);
						match(LT);
						setState(221);
						expression(20);
						}
						break;
					case 7:
						{
						_localctx = new GreaterThanExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(222);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(223);
						match(GT);
						setState(224);
						expression(19);
						}
						break;
					case 8:
						{
						_localctx = new LessThanOrEqualExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(225);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(226);
						match(LT_EQ);
						setState(227);
						expression(18);
						}
						break;
					case 9:
						{
						_localctx = new GreaterThanOrEqualExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(228);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(229);
						match(GT_EQ);
						setState(230);
						expression(17);
						}
						break;
					case 10:
						{
						_localctx = new NotEqualExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(231);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(232);
						match(NEQ);
						setState(233);
						expression(16);
						}
						break;
					case 11:
						{
						_localctx = new AndExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(234);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(235);
						match(AND);
						setState(236);
						expression(15);
						}
						break;
					case 12:
						{
						_localctx = new OrExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(237);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(238);
						match(OR);
						setState(239);
						expression(14);
						}
						break;
					case 13:
						{
						_localctx = new AssignmentExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(240);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(241);
						match(ASSIGN);
						setState(242);
						expression(9);
						}
						break;
					case 14:
						{
						_localctx = new ClassMethodCallExpressionContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(243);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(244);
						match(DOT);
						setState(245);
						match(ID);
						setState(246);
						match(LPAREN);
						setState(248);
						_errHandler.sync(this);
						_la = _input.LA(1);
						if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 115491825779712L) != 0)) {
							{
							setState(247);
							expressionList();
							}
						}

						setState(250);
						match(RPAREN);
						}
						break;
					}
					} 
				}
				setState(255);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 19:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 24);
		case 1:
			return precpred(_ctx, 23);
		case 2:
			return precpred(_ctx, 22);
		case 3:
			return precpred(_ctx, 21);
		case 4:
			return precpred(_ctx, 20);
		case 5:
			return precpred(_ctx, 19);
		case 6:
			return precpred(_ctx, 18);
		case 7:
			return precpred(_ctx, 17);
		case 8:
			return precpred(_ctx, 16);
		case 9:
			return precpred(_ctx, 15);
		case 10:
			return precpred(_ctx, 14);
		case 11:
			return precpred(_ctx, 13);
		case 12:
			return precpred(_ctx, 8);
		case 13:
			return precpred(_ctx, 12);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u00010\u0101\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"+
		"\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"+
		"\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"+
		"\u0002\u0013\u0007\u0013\u0001\u0000\u0005\u0000*\b\u0000\n\u0000\f\u0000"+
		"-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0003\u00015\b\u0001\u0001\u0001\u0001\u0001\u0001\u0001"+
		"\u0001\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0005\u0002"+
		"?\b\u0002\n\u0002\f\u0002B\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003"+
		"\u0001\u0003\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"+
		"\u0003\u0006S\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0007"+
		"\u0001\u0007\u0001\u0007\u0005\u0007[\b\u0007\n\u0007\f\u0007^\t\u0007"+
		"\u0001\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0001\t\u0001\t\u0001"+
		"\t\u0001\t\u0001\t\u0003\tk\b\t\u0001\n\u0001\n\u0001\n\u0001\n\u0003"+
		"\nq\b\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0003"+
		"\u000bx\b\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001"+
		"\u000b\u0003\u000b\u007f\b\u000b\u0005\u000b\u0081\b\u000b\n\u000b\f\u000b"+
		"\u0084\t\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\f"+
		"\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0003\f\u0091\b\f\u0001"+
		"\f\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"+
		"\u0001\u000e\u0001\u000e\u0003\u000e\u009e\b\u000e\u0001\u000e\u0001\u000e"+
		"\u0001\u000e\u0001\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010"+
		"\u0003\u0010\u00a8\b\u0010\u0001\u0010\u0001\u0010\u0001\u0011\u0001\u0011"+
		"\u0001\u0011\u0005\u0011\u00af\b\u0011\n\u0011\f\u0011\u00b2\t\u0011\u0001"+
		"\u0012\u0001\u0012\u0005\u0012\u00b6\b\u0012\n\u0012\f\u0012\u00b9\t\u0012"+
		"\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0003\u0013\u00cb\b\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013"+
		"\u0001\u0013\u0001\u0013\u0003\u0013\u00f9\b\u0013\u0001\u0013\u0005\u0013"+
		"\u00fc\b\u0013\n\u0013\f\u0013\u00ff\t\u0013\u0001\u0013\u0000\u0001&"+
		"\u0014\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018"+
		"\u001a\u001c\u001e \"$&\u0000\u0001\u0003\u0000\u001c\u001c%(,,\u011c"+
		"\u0000+\u0001\u0000\u0000\u0000\u00020\u0001\u0000\u0000\u0000\u0004@"+
		"\u0001\u0000\u0000\u0000\u0006C\u0001\u0000\u0000\u0000\bG\u0001\u0000"+
		"\u0000\u0000\nL\u0001\u0000\u0000\u0000\fN\u0001\u0000\u0000\u0000\u000e"+
		"W\u0001\u0000\u0000\u0000\u0010_\u0001\u0000\u0000\u0000\u0012j\u0001"+
		"\u0000\u0000\u0000\u0014l\u0001\u0000\u0000\u0000\u0016r\u0001\u0000\u0000"+
		"\u0000\u0018\u0089\u0001\u0000\u0000\u0000\u001a\u0094\u0001\u0000\u0000"+
		"\u0000\u001c\u009a\u0001\u0000\u0000\u0000\u001e\u00a2\u0001\u0000\u0000"+
		"\u0000 \u00a5\u0001\u0000\u0000\u0000\"\u00ab\u0001\u0000\u0000\u0000"+
		"$\u00b3\u0001\u0000\u0000\u0000&\u00ca\u0001\u0000\u0000\u0000(*\u0003"+
		"\u0002\u0001\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000"+
		"+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000"+
		"\u0000-+\u0001\u0000\u0000\u0000./\u0005\u0000\u0000\u0001/\u0001\u0001"+
		"\u0000\u0000\u000001\u0005\u0019\u0000\u000014\u0005,\u0000\u000023\u0005"+
		"\u001a\u0000\u000035\u0005,\u0000\u000042\u0001\u0000\u0000\u000045\u0001"+
		"\u0000\u0000\u000056\u0001\u0000\u0000\u000067\u0005\u0001\u0000\u0000"+
		"78\u0003\u0004\u0002\u000089\u0005\u0002\u0000\u00009\u0003\u0001\u0000"+
		"\u0000\u0000:?\u0003\u0006\u0003\u0000;?\u0003\f\u0006\u0000<?\u0003\b"+
		"\u0004\u0000=?\u0003\u0012\t\u0000>:\u0001\u0000\u0000\u0000>;\u0001\u0000"+
		"\u0000\u0000><\u0001\u0000\u0000\u0000>=\u0001\u0000\u0000\u0000?B\u0001"+
		"\u0000\u0000\u0000@>\u0001\u0000\u0000\u0000@A\u0001\u0000\u0000\u0000"+
		"A\u0005\u0001\u0000\u0000\u0000B@\u0001\u0000\u0000\u0000CD\u0003\n\u0005"+
		"\u0000DE\u0005+\u0000\u0000EF\u0005\u0005\u0000\u0000F\u0007\u0001\u0000"+
		"\u0000\u0000GH\u0005+\u0000\u0000HI\u0005\b\u0000\u0000IJ\u0003&\u0013"+
		"\u0000JK\u0005\u0005\u0000\u0000K\t\u0001\u0000\u0000\u0000LM\u0007\u0000"+
		"\u0000\u0000M\u000b\u0001\u0000\u0000\u0000NO\u0003\n\u0005\u0000OP\u0005"+
		"+\u0000\u0000PR\u0005\u0003\u0000\u0000QS\u0003\u000e\u0007\u0000RQ\u0001"+
		"\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000ST\u0001\u0000\u0000\u0000"+
		"TU\u0005\u0004\u0000\u0000UV\u0003$\u0012\u0000V\r\u0001\u0000\u0000\u0000"+
		"W\\\u0003\u0010\b\u0000XY\u0005\u0006\u0000\u0000Y[\u0003\u0010\b\u0000"+
		"ZX\u0001\u0000\u0000\u0000[^\u0001\u0000\u0000\u0000\\Z\u0001\u0000\u0000"+
		"\u0000\\]\u0001\u0000\u0000\u0000]\u000f\u0001\u0000\u0000\u0000^\\\u0001"+
		"\u0000\u0000\u0000_`\u0003\n\u0005\u0000`a\u0005+\u0000\u0000a\u0011\u0001"+
		"\u0000\u0000\u0000bk\u0003\u0014\n\u0000ck\u0003\u0016\u000b\u0000dk\u0003"+
		"\u0018\f\u0000ek\u0003\u001a\r\u0000fk\u0003\u001c\u000e\u0000gk\u0003"+
		"\u001e\u000f\u0000hk\u0003 \u0010\u0000ik\u0003$\u0012\u0000jb\u0001\u0000"+
		"\u0000\u0000jc\u0001\u0000\u0000\u0000jd\u0001\u0000\u0000\u0000je\u0001"+
		"\u0000\u0000\u0000jf\u0001\u0000\u0000\u0000jg\u0001\u0000\u0000\u0000"+
		"jh\u0001\u0000\u0000\u0000ji\u0001\u0000\u0000\u0000k\u0013\u0001\u0000"+
		"\u0000\u0000lm\u0003\n\u0005\u0000mp\u0005+\u0000\u0000no\u0005\b\u0000"+
		"\u0000oq\u0003\u0012\t\u0000pn\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000"+
		"\u0000q\u0015\u0001\u0000\u0000\u0000rs\u0005)\u0000\u0000st\u0003\n\u0005"+
		"\u0000tw\u0005+\u0000\u0000uv\u0005\b\u0000\u0000vx\u0003&\u0013\u0000"+
		"wu\u0001\u0000\u0000\u0000wx\u0001\u0000\u0000\u0000x\u0082\u0001\u0000"+
		"\u0000\u0000yz\u0005\u0006\u0000\u0000z{\u0003\n\u0005\u0000{~\u0005+"+
		"\u0000\u0000|}\u0005\b\u0000\u0000}\u007f\u0003&\u0013\u0000~|\u0001\u0000"+
		"\u0000\u0000~\u007f\u0001\u0000\u0000\u0000\u007f\u0081\u0001\u0000\u0000"+
		"\u0000\u0080y\u0001\u0000\u0000\u0000\u0081\u0084\u0001\u0000\u0000\u0000"+
		"\u0082\u0080\u0001\u0000\u0000\u0000\u0082\u0083\u0001\u0000\u0000\u0000"+
		"\u0083\u0085\u0001\u0000\u0000\u0000\u0084\u0082\u0001\u0000\u0000\u0000"+
		"\u0085\u0086\u0005*\u0000\u0000\u0086\u0087\u0003&\u0013\u0000\u0087\u0088"+
		"\u0005\u0005\u0000\u0000\u0088\u0017\u0001\u0000\u0000\u0000\u0089\u008a"+
		"\u0005\u001f\u0000\u0000\u008a\u008b\u0005\u0003\u0000\u0000\u008b\u008c"+
		"\u0003&\u0013\u0000\u008c\u008d\u0005\u0004\u0000\u0000\u008d\u0090\u0003"+
		"\u0012\t\u0000\u008e\u008f\u0005\u001d\u0000\u0000\u008f\u0091\u0003\u0012"+
		"\t\u0000\u0090\u008e\u0001\u0000\u0000\u0000\u0090\u0091\u0001\u0000\u0000"+
		"\u0000\u0091\u0092\u0001\u0000\u0000\u0000\u0092\u0093\u0005\u001e\u0000"+
		"\u0000\u0093\u0019\u0001\u0000\u0000\u0000\u0094\u0095\u0005 \u0000\u0000"+
		"\u0095\u0096\u0005\u0003\u0000\u0000\u0096\u0097\u0003&\u0013\u0000\u0097"+
		"\u0098\u0005\u0004\u0000\u0000\u0098\u0099\u0003\u0012\t\u0000\u0099\u001b"+
		"\u0001\u0000\u0000\u0000\u009a\u009b\u0005+\u0000\u0000\u009b\u009d\u0005"+
		"\u0003\u0000\u0000\u009c\u009e\u0003\"\u0011\u0000\u009d\u009c\u0001\u0000"+
		"\u0000\u0000\u009d\u009e\u0001\u0000\u0000\u0000\u009e\u009f\u0001\u0000"+
		"\u0000\u0000\u009f\u00a0\u0005\u0004\u0000\u0000\u00a0\u00a1\u0005\u0005"+
		"\u0000\u0000\u00a1\u001d\u0001\u0000\u0000\u0000\u00a2\u00a3\u0003&\u0013"+
		"\u0000\u00a3\u00a4\u0005\u0005\u0000\u0000\u00a4\u001f\u0001\u0000\u0000"+
		"\u0000\u00a5\u00a7\u0005$\u0000\u0000\u00a6\u00a8\u0003&\u0013\u0000\u00a7"+
		"\u00a6\u0001\u0000\u0000\u0000\u00a7\u00a8\u0001\u0000\u0000\u0000\u00a8"+
		"\u00a9\u0001\u0000\u0000\u0000\u00a9\u00aa\u0005\u0005\u0000\u0000\u00aa"+
		"!\u0001\u0000\u0000\u0000\u00ab\u00b0\u0003&\u0013\u0000\u00ac\u00ad\u0005"+
		"\u0006\u0000\u0000\u00ad\u00af\u0003&\u0013\u0000\u00ae\u00ac\u0001\u0000"+
		"\u0000\u0000\u00af\u00b2\u0001\u0000\u0000\u0000\u00b0\u00ae\u0001\u0000"+
		"\u0000\u0000\u00b0\u00b1\u0001\u0000\u0000\u0000\u00b1#\u0001\u0000\u0000"+
		"\u0000\u00b2\u00b0\u0001\u0000\u0000\u0000\u00b3\u00b7\u0005\u0001\u0000"+
		"\u0000\u00b4\u00b6\u0003\u0012\t\u0000\u00b5\u00b4\u0001\u0000\u0000\u0000"+
		"\u00b6\u00b9\u0001\u0000\u0000\u0000\u00b7\u00b5\u0001\u0000\u0000\u0000"+
		"\u00b7\u00b8\u0001\u0000\u0000\u0000\u00b8\u00ba\u0001\u0000\u0000\u0000"+
		"\u00b9\u00b7\u0001\u0000\u0000\u0000\u00ba\u00bb\u0005\u0002\u0000\u0000"+
		"\u00bb%\u0001\u0000\u0000\u0000\u00bc\u00bd\u0006\u0013\uffff\uffff\u0000"+
		"\u00bd\u00be\u0005!\u0000\u0000\u00be\u00cb\u0005,\u0000\u0000\u00bf\u00c0"+
		"\u0005#\u0000\u0000\u00c0\u00cb\u0003&\u0013\n\u00c1\u00c2\u0005\n\u0000"+
		"\u0000\u00c2\u00cb\u0003&\u0013\t\u00c3\u00cb\u0005+\u0000\u0000\u00c4"+
		"\u00cb\u0005\u001b\u0000\u0000\u00c5\u00cb\u0005-\u0000\u0000\u00c6\u00cb"+
		"\u0005.\u0000\u0000\u00c7\u00cb\u0005\u0016\u0000\u0000\u00c8\u00cb\u0005"+
		"\u0018\u0000\u0000\u00c9\u00cb\u0005(\u0000\u0000\u00ca\u00bc\u0001\u0000"+
		"\u0000\u0000\u00ca\u00bf\u0001\u0000\u0000\u0000\u00ca\u00c1\u0001\u0000"+
		"\u0000\u0000\u00ca\u00c3\u0001\u0000\u0000\u0000\u00ca\u00c4\u0001\u0000"+
		"\u0000\u0000\u00ca\u00c5\u0001\u0000\u0000\u0000\u00ca\u00c6\u0001\u0000"+
		"\u0000\u0000\u00ca\u00c7\u0001\u0000\u0000\u0000\u00ca\u00c8\u0001\u0000"+
		"\u0000\u0000\u00ca\u00c9\u0001\u0000\u0000\u0000\u00cb\u00fd\u0001\u0000"+
		"\u0000\u0000\u00cc\u00cd\n\u0018\u0000\u0000\u00cd\u00ce\u0005\u000b\u0000"+
		"\u0000\u00ce\u00fc\u0003&\u0013\u0019\u00cf\u00d0\n\u0017\u0000\u0000"+
		"\u00d0\u00d1\u0005\f\u0000\u0000\u00d1\u00fc\u0003&\u0013\u0018\u00d2"+
		"\u00d3\n\u0016\u0000\u0000\u00d3\u00d4\u0005\t\u0000\u0000\u00d4\u00fc"+
		"\u0003&\u0013\u0017\u00d5\u00d6\n\u0015\u0000\u0000\u00d6\u00d7\u0005"+
		"\n\u0000\u0000\u00d7\u00fc\u0003&\u0013\u0016\u00d8\u00d9\n\u0014\u0000"+
		"\u0000\u00d9\u00da\u0005\r\u0000\u0000\u00da\u00fc\u0003&\u0013\u0015"+
		"\u00db\u00dc\n\u0013\u0000\u0000\u00dc\u00dd\u0005\u000f\u0000\u0000\u00dd"+
		"\u00fc\u0003&\u0013\u0014\u00de\u00df\n\u0012\u0000\u0000\u00df\u00e0"+
		"\u0005\u0010\u0000\u0000\u00e0\u00fc\u0003&\u0013\u0013\u00e1\u00e2\n"+
		"\u0011\u0000\u0000\u00e2\u00e3\u0005\u0012\u0000\u0000\u00e3\u00fc\u0003"+
		"&\u0013\u0012\u00e4\u00e5\n\u0010\u0000\u0000\u00e5\u00e6\u0005\u0011"+
		"\u0000\u0000\u00e6\u00fc\u0003&\u0013\u0011\u00e7\u00e8\n\u000f\u0000"+
		"\u0000\u00e8\u00e9\u0005\u000e\u0000\u0000\u00e9\u00fc\u0003&\u0013\u0010"+
		"\u00ea\u00eb\n\u000e\u0000\u0000\u00eb\u00ec\u0005\u0013\u0000\u0000\u00ec"+
		"\u00fc\u0003&\u0013\u000f\u00ed\u00ee\n\r\u0000\u0000\u00ee\u00ef\u0005"+
		"\u0014\u0000\u0000\u00ef\u00fc\u0003&\u0013\u000e\u00f0\u00f1\n\b\u0000"+
		"\u0000\u00f1\u00f2\u0005\b\u0000\u0000\u00f2\u00fc\u0003&\u0013\t\u00f3"+
		"\u00f4\n\f\u0000\u0000\u00f4\u00f5\u0005\u0017\u0000\u0000\u00f5\u00f6"+
		"\u0005+\u0000\u0000\u00f6\u00f8\u0005\u0003\u0000\u0000\u00f7\u00f9\u0003"+
		"\"\u0011\u0000\u00f8\u00f7\u0001\u0000\u0000\u0000\u00f8\u00f9\u0001\u0000"+
		"\u0000\u0000\u00f9\u00fa\u0001\u0000\u0000\u0000\u00fa\u00fc\u0005\u0004"+
		"\u0000\u0000\u00fb\u00cc\u0001\u0000\u0000\u0000\u00fb\u00cf\u0001\u0000"+
		"\u0000\u0000\u00fb\u00d2\u0001\u0000\u0000\u0000\u00fb\u00d5\u0001\u0000"+
		"\u0000\u0000\u00fb\u00d8\u0001\u0000\u0000\u0000\u00fb\u00db\u0001\u0000"+
		"\u0000\u0000\u00fb\u00de\u0001\u0000\u0000\u0000\u00fb\u00e1\u0001\u0000"+
		"\u0000\u0000\u00fb\u00e4\u0001\u0000\u0000\u0000\u00fb\u00e7\u0001\u0000"+
		"\u0000\u0000\u00fb\u00ea\u0001\u0000\u0000\u0000\u00fb\u00ed\u0001\u0000"+
		"\u0000\u0000\u00fb\u00f0\u0001\u0000\u0000\u0000\u00fb\u00f3\u0001\u0000"+
		"\u0000\u0000\u00fc\u00ff\u0001\u0000\u0000\u0000\u00fd\u00fb\u0001\u0000"+
		"\u0000\u0000\u00fd\u00fe\u0001\u0000\u0000\u0000\u00fe\'\u0001\u0000\u0000"+
		"\u0000\u00ff\u00fd\u0001\u0000\u0000\u0000\u0014+4>@R\\jpw~\u0082\u0090"+
		"\u009d\u00a7\u00b0\u00b7\u00ca\u00f8\u00fb\u00fd";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}