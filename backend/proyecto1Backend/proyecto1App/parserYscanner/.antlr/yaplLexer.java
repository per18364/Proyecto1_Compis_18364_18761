// Generated from e:\\UVG\\COMPU\\2023_2ndo_semestre\\COMPIS\\Proyecto1_Compis_18364_18761\\backend\\proyecto1Backend\\proyecto1App\\parserYscanner\\yapl.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class yaplLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		LBRACE=1, RBRACE=2, LPAREN=3, RPAREN=4, SEMI=5, COMMA=6, EQUALS=7, ASSIGN=8, 
		PLUS=9, MINUS=10, MULT=11, DIV=12, EQ=13, NEQ=14, LT=15, GT=16, GT_EQ=17, 
		LT_EQ=18, AND=19, OR=20, TRUE=21, DOT=22, FALSE=23, CLASS=24, INHERITS=25, 
		SELF=26, SELF_TYPE=27, ELSE=28, FI=29, IF=30, WHILE=31, NEW=32, ISVOID=33, 
		NOT=34, RETURN=35, INT=36, STRING_TYPE=37, BOOL=38, VOID=39, ID=40, TYPE_ID=41, 
		INTEGER=42, STRING=43, COMMENT=44, WS=45;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LBRACE", "RBRACE", "LPAREN", "RPAREN", "SEMI", "COMMA", "EQUALS", "ASSIGN", 
			"PLUS", "MINUS", "MULT", "DIV", "EQ", "NEQ", "LT", "GT", "GT_EQ", "LT_EQ", 
			"AND", "OR", "TRUE", "DOT", "FALSE", "CLASS", "INHERITS", "SELF", "SELF_TYPE", 
			"ELSE", "FI", "IF", "WHILE", "NEW", "ISVOID", "NOT", "RETURN", "INT", 
			"STRING_TYPE", "BOOL", "VOID", "ID", "TYPE_ID", "INTEGER", "STRING", 
			"EscapeSequence", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "';'", "','", "'='", "'<-'", "'+'", 
			"'-'", "'*'", "'/'", "'=='", "'!='", "'<'", "'>'", "'>='", "'<='", "'&&'", 
			"'||'", "'true'", "'.'", "'false'", "'class'", "'inherits'", "'self'", 
			"'SELF_TYPE'", "'else'", "'fi'", "'if'", "'while'", "'new'", "'isvoid'", 
			"'not'", "'return'", "'int'", "'string'", "'bool'", "'void'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LBRACE", "RBRACE", "LPAREN", "RPAREN", "SEMI", "COMMA", "EQUALS", 
			"ASSIGN", "PLUS", "MINUS", "MULT", "DIV", "EQ", "NEQ", "LT", "GT", "GT_EQ", 
			"LT_EQ", "AND", "OR", "TRUE", "DOT", "FALSE", "CLASS", "INHERITS", "SELF", 
			"SELF_TYPE", "ELSE", "FI", "IF", "WHILE", "NEW", "ISVOID", "NOT", "RETURN", 
			"INT", "STRING_TYPE", "BOOL", "VOID", "ID", "TYPE_ID", "INTEGER", "STRING", 
			"COMMENT", "WS"
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


	public yaplLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "yapl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2/\u0135\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7"+
		"\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16"+
		"\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24"+
		"\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36"+
		"\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\""+
		"\3\"\3#\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3"+
		"&\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\7)\u00f8\n)\f)\16)\u00fb\13"+
		")\3*\3*\7*\u00ff\n*\f*\16*\u0102\13*\3+\6+\u0105\n+\r+\16+\u0106\3,\3"+
		",\3,\7,\u010c\n,\f,\16,\u010f\13,\3,\3,\3-\3-\3-\3.\3.\3.\3.\7.\u011a"+
		"\n.\f.\16.\u011d\13.\3.\3.\3.\3.\3.\7.\u0124\n.\f.\16.\u0127\13.\3.\3"+
		".\5.\u012b\n.\3.\3.\3/\6/\u0130\n/\r/\16/\u0131\3/\3/\4\u011b\u0125\2"+
		"\60\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37= ?!A\"C#E$G%I&K\'M(O)Q*S+U,W-Y\2[.]/\3\2\t\3\2c|\6\2\62;C\\aac|\3"+
		"\2C\\\3\2\62;\6\2\13\f\17\17$$^^\b\2^^ddhhppttvv\5\2\13\f\17\17\"\"\2"+
		"\u013c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3"+
		"\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\3_\3\2\2\2\5a\3\2\2"+
		"\2\7c\3\2\2\2\te\3\2\2\2\13g\3\2\2\2\ri\3\2\2\2\17k\3\2\2\2\21m\3\2\2"+
		"\2\23p\3\2\2\2\25r\3\2\2\2\27t\3\2\2\2\31v\3\2\2\2\33x\3\2\2\2\35{\3\2"+
		"\2\2\37~\3\2\2\2!\u0080\3\2\2\2#\u0082\3\2\2\2%\u0085\3\2\2\2\'\u0088"+
		"\3\2\2\2)\u008b\3\2\2\2+\u008e\3\2\2\2-\u0093\3\2\2\2/\u0095\3\2\2\2\61"+
		"\u009b\3\2\2\2\63\u00a1\3\2\2\2\65\u00aa\3\2\2\2\67\u00af\3\2\2\29\u00b9"+
		"\3\2\2\2;\u00be\3\2\2\2=\u00c1\3\2\2\2?\u00c4\3\2\2\2A\u00ca\3\2\2\2C"+
		"\u00ce\3\2\2\2E\u00d5\3\2\2\2G\u00d9\3\2\2\2I\u00e0\3\2\2\2K\u00e4\3\2"+
		"\2\2M\u00eb\3\2\2\2O\u00f0\3\2\2\2Q\u00f5\3\2\2\2S\u00fc\3\2\2\2U\u0104"+
		"\3\2\2\2W\u0108\3\2\2\2Y\u0112\3\2\2\2[\u012a\3\2\2\2]\u012f\3\2\2\2_"+
		"`\7}\2\2`\4\3\2\2\2ab\7\177\2\2b\6\3\2\2\2cd\7*\2\2d\b\3\2\2\2ef\7+\2"+
		"\2f\n\3\2\2\2gh\7=\2\2h\f\3\2\2\2ij\7.\2\2j\16\3\2\2\2kl\7?\2\2l\20\3"+
		"\2\2\2mn\7>\2\2no\7/\2\2o\22\3\2\2\2pq\7-\2\2q\24\3\2\2\2rs\7/\2\2s\26"+
		"\3\2\2\2tu\7,\2\2u\30\3\2\2\2vw\7\61\2\2w\32\3\2\2\2xy\7?\2\2yz\7?\2\2"+
		"z\34\3\2\2\2{|\7#\2\2|}\7?\2\2}\36\3\2\2\2~\177\7>\2\2\177 \3\2\2\2\u0080"+
		"\u0081\7@\2\2\u0081\"\3\2\2\2\u0082\u0083\7@\2\2\u0083\u0084\7?\2\2\u0084"+
		"$\3\2\2\2\u0085\u0086\7>\2\2\u0086\u0087\7?\2\2\u0087&\3\2\2\2\u0088\u0089"+
		"\7(\2\2\u0089\u008a\7(\2\2\u008a(\3\2\2\2\u008b\u008c\7~\2\2\u008c\u008d"+
		"\7~\2\2\u008d*\3\2\2\2\u008e\u008f\7v\2\2\u008f\u0090\7t\2\2\u0090\u0091"+
		"\7w\2\2\u0091\u0092\7g\2\2\u0092,\3\2\2\2\u0093\u0094\7\60\2\2\u0094."+
		"\3\2\2\2\u0095\u0096\7h\2\2\u0096\u0097\7c\2\2\u0097\u0098\7n\2\2\u0098"+
		"\u0099\7u\2\2\u0099\u009a\7g\2\2\u009a\60\3\2\2\2\u009b\u009c\7e\2\2\u009c"+
		"\u009d\7n\2\2\u009d\u009e\7c\2\2\u009e\u009f\7u\2\2\u009f\u00a0\7u\2\2"+
		"\u00a0\62\3\2\2\2\u00a1\u00a2\7k\2\2\u00a2\u00a3\7p\2\2\u00a3\u00a4\7"+
		"j\2\2\u00a4\u00a5\7g\2\2\u00a5\u00a6\7t\2\2\u00a6\u00a7\7k\2\2\u00a7\u00a8"+
		"\7v\2\2\u00a8\u00a9\7u\2\2\u00a9\64\3\2\2\2\u00aa\u00ab\7u\2\2\u00ab\u00ac"+
		"\7g\2\2\u00ac\u00ad\7n\2\2\u00ad\u00ae\7h\2\2\u00ae\66\3\2\2\2\u00af\u00b0"+
		"\7U\2\2\u00b0\u00b1\7G\2\2\u00b1\u00b2\7N\2\2\u00b2\u00b3\7H\2\2\u00b3"+
		"\u00b4\7a\2\2\u00b4\u00b5\7V\2\2\u00b5\u00b6\7[\2\2\u00b6\u00b7\7R\2\2"+
		"\u00b7\u00b8\7G\2\2\u00b88\3\2\2\2\u00b9\u00ba\7g\2\2\u00ba\u00bb\7n\2"+
		"\2\u00bb\u00bc\7u\2\2\u00bc\u00bd\7g\2\2\u00bd:\3\2\2\2\u00be\u00bf\7"+
		"h\2\2\u00bf\u00c0\7k\2\2\u00c0<\3\2\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3"+
		"\7h\2\2\u00c3>\3\2\2\2\u00c4\u00c5\7y\2\2\u00c5\u00c6\7j\2\2\u00c6\u00c7"+
		"\7k\2\2\u00c7\u00c8\7n\2\2\u00c8\u00c9\7g\2\2\u00c9@\3\2\2\2\u00ca\u00cb"+
		"\7p\2\2\u00cb\u00cc\7g\2\2\u00cc\u00cd\7y\2\2\u00cdB\3\2\2\2\u00ce\u00cf"+
		"\7k\2\2\u00cf\u00d0\7u\2\2\u00d0\u00d1\7x\2\2\u00d1\u00d2\7q\2\2\u00d2"+
		"\u00d3\7k\2\2\u00d3\u00d4\7f\2\2\u00d4D\3\2\2\2\u00d5\u00d6\7p\2\2\u00d6"+
		"\u00d7\7q\2\2\u00d7\u00d8\7v\2\2\u00d8F\3\2\2\2\u00d9\u00da\7t\2\2\u00da"+
		"\u00db\7g\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7w\2\2\u00dd\u00de\7t\2\2"+
		"\u00de\u00df\7p\2\2\u00dfH\3\2\2\2\u00e0\u00e1\7k\2\2\u00e1\u00e2\7p\2"+
		"\2\u00e2\u00e3\7v\2\2\u00e3J\3\2\2\2\u00e4\u00e5\7u\2\2\u00e5\u00e6\7"+
		"v\2\2\u00e6\u00e7\7t\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9\7p\2\2\u00e9\u00ea"+
		"\7i\2\2\u00eaL\3\2\2\2\u00eb\u00ec\7d\2\2\u00ec\u00ed\7q\2\2\u00ed\u00ee"+
		"\7q\2\2\u00ee\u00ef\7n\2\2\u00efN\3\2\2\2\u00f0\u00f1\7x\2\2\u00f1\u00f2"+
		"\7q\2\2\u00f2\u00f3\7k\2\2\u00f3\u00f4\7f\2\2\u00f4P\3\2\2\2\u00f5\u00f9"+
		"\t\2\2\2\u00f6\u00f8\t\3\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9"+
		"\u00f7\3\2\2\2\u00f9\u00fa\3\2\2\2\u00faR\3\2\2\2\u00fb\u00f9\3\2\2\2"+
		"\u00fc\u0100\t\4\2\2\u00fd\u00ff\t\3\2\2\u00fe\u00fd\3\2\2\2\u00ff\u0102"+
		"\3\2\2\2\u0100\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101T\3\2\2\2\u0102"+
		"\u0100\3\2\2\2\u0103\u0105\t\5\2\2\u0104\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107V\3\2\2\2\u0108\u010d"+
		"\7$\2\2\u0109\u010c\n\6\2\2\u010a\u010c\5Y-\2\u010b\u0109\3\2\2\2\u010b"+
		"\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e\3\2"+
		"\2\2\u010e\u0110\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0111\7$\2\2\u0111"+
		"X\3\2\2\2\u0112\u0113\7^\2\2\u0113\u0114\t\7\2\2\u0114Z\3\2\2\2\u0115"+
		"\u0116\7/\2\2\u0116\u0117\7/\2\2\u0117\u011b\3\2\2\2\u0118\u011a\13\2"+
		"\2\2\u0119\u0118\3\2\2\2\u011a\u011d\3\2\2\2\u011b\u011c\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011c\u011e\3\2\2\2\u011d\u011b\3\2\2\2\u011e\u012b\7\f"+
		"\2\2\u011f\u0120\7*\2\2\u0120\u0121\7,\2\2\u0121\u0125\3\2\2\2\u0122\u0124"+
		"\13\2\2\2\u0123\u0122\3\2\2\2\u0124\u0127\3\2\2\2\u0125\u0126\3\2\2\2"+
		"\u0125\u0123\3\2\2\2\u0126\u0128\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u0129"+
		"\7,\2\2\u0129\u012b\7+\2\2\u012a\u0115\3\2\2\2\u012a\u011f\3\2\2\2\u012b"+
		"\u012c\3\2\2\2\u012c\u012d\b.\2\2\u012d\\\3\2\2\2\u012e\u0130\t\b\2\2"+
		"\u012f\u012e\3\2\2\2\u0130\u0131\3\2\2\2\u0131\u012f\3\2\2\2\u0131\u0132"+
		"\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\b/\2\2\u0134^\3\2\2\2\f\2\u00f9"+
		"\u0100\u0106\u010b\u010d\u011b\u0125\u012a\u0131\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}