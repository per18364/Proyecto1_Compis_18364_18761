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
		NOT=34, RETURN=35, INT=36, STRING_TYPE=37, BOOL=38, ID=39, TYPE_ID=40, 
		INTEGER=41, STRING=42, COMMENT=43, WS=44;
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
			"STRING_TYPE", "BOOL", "ID", "TYPE_ID", "INTEGER", "STRING", "EscapeSequence", 
			"COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "';'", "','", "'='", "'<-'", "'+'", 
			"'-'", "'*'", "'/'", "'=='", "'!='", "'<'", "'>'", "'>='", "'<='", "'&&'", 
			"'||'", "'true'", "'.'", "'false'", "'class'", "'inherits'", "'self'", 
			"'SELF_TYPE'", "'else'", "'fi'", "'if'", "'while'", "'new'", "'isvoid'", 
			"'not'", "'return'", "'int'", "'string'", "'bool'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LBRACE", "RBRACE", "LPAREN", "RPAREN", "SEMI", "COMMA", "EQUALS", 
			"ASSIGN", "PLUS", "MINUS", "MULT", "DIV", "EQ", "NEQ", "LT", "GT", "GT_EQ", 
			"LT_EQ", "AND", "OR", "TRUE", "DOT", "FALSE", "CLASS", "INHERITS", "SELF", 
			"SELF_TYPE", "ELSE", "FI", "IF", "WHILE", "NEW", "ISVOID", "NOT", "RETURN", 
			"INT", "STRING_TYPE", "BOOL", "ID", "TYPE_ID", "INTEGER", "STRING", "COMMENT", 
			"WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2.\u012e\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3"+
		"\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3"+
		"\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3"+
		"\30\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#"+
		"\3#\3#\3#\3$\3$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3"+
		"\'\3\'\3\'\3\'\3(\3(\7(\u00f1\n(\f(\16(\u00f4\13(\3)\3)\7)\u00f8\n)\f"+
		")\16)\u00fb\13)\3*\6*\u00fe\n*\r*\16*\u00ff\3+\3+\3+\7+\u0105\n+\f+\16"+
		"+\u0108\13+\3+\3+\3,\3,\3,\3-\3-\3-\3-\7-\u0113\n-\f-\16-\u0116\13-\3"+
		"-\3-\3-\3-\3-\7-\u011d\n-\f-\16-\u0120\13-\3-\3-\5-\u0124\n-\3-\3-\3."+
		"\6.\u0129\n.\r.\16.\u012a\3.\3.\4\u0114\u011e\2/\3\3\5\4\7\5\t\6\13\7"+
		"\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25"+
		")\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O"+
		")Q*S+U,W\2Y-[.\3\2\t\3\2c|\6\2\62;C\\aac|\3\2C\\\3\2\62;\6\2\13\f\17\17"+
		"$$^^\b\2^^ddhhppttvv\5\2\13\f\17\17\"\"\2\u0135\2\3\3\2\2\2\2\5\3\2\2"+
		"\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21"+
		"\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2"+
		"\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3"+
		"\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3"+
		"\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3"+
		"\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2"+
		"\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2Y\3\2\2\2\2"+
		"[\3\2\2\2\3]\3\2\2\2\5_\3\2\2\2\7a\3\2\2\2\tc\3\2\2\2\13e\3\2\2\2\rg\3"+
		"\2\2\2\17i\3\2\2\2\21k\3\2\2\2\23n\3\2\2\2\25p\3\2\2\2\27r\3\2\2\2\31"+
		"t\3\2\2\2\33v\3\2\2\2\35y\3\2\2\2\37|\3\2\2\2!~\3\2\2\2#\u0080\3\2\2\2"+
		"%\u0083\3\2\2\2\'\u0086\3\2\2\2)\u0089\3\2\2\2+\u008c\3\2\2\2-\u0091\3"+
		"\2\2\2/\u0093\3\2\2\2\61\u0099\3\2\2\2\63\u009f\3\2\2\2\65\u00a8\3\2\2"+
		"\2\67\u00ad\3\2\2\29\u00b7\3\2\2\2;\u00bc\3\2\2\2=\u00bf\3\2\2\2?\u00c2"+
		"\3\2\2\2A\u00c8\3\2\2\2C\u00cc\3\2\2\2E\u00d3\3\2\2\2G\u00d7\3\2\2\2I"+
		"\u00de\3\2\2\2K\u00e2\3\2\2\2M\u00e9\3\2\2\2O\u00ee\3\2\2\2Q\u00f5\3\2"+
		"\2\2S\u00fd\3\2\2\2U\u0101\3\2\2\2W\u010b\3\2\2\2Y\u0123\3\2\2\2[\u0128"+
		"\3\2\2\2]^\7}\2\2^\4\3\2\2\2_`\7\177\2\2`\6\3\2\2\2ab\7*\2\2b\b\3\2\2"+
		"\2cd\7+\2\2d\n\3\2\2\2ef\7=\2\2f\f\3\2\2\2gh\7.\2\2h\16\3\2\2\2ij\7?\2"+
		"\2j\20\3\2\2\2kl\7>\2\2lm\7/\2\2m\22\3\2\2\2no\7-\2\2o\24\3\2\2\2pq\7"+
		"/\2\2q\26\3\2\2\2rs\7,\2\2s\30\3\2\2\2tu\7\61\2\2u\32\3\2\2\2vw\7?\2\2"+
		"wx\7?\2\2x\34\3\2\2\2yz\7#\2\2z{\7?\2\2{\36\3\2\2\2|}\7>\2\2} \3\2\2\2"+
		"~\177\7@\2\2\177\"\3\2\2\2\u0080\u0081\7@\2\2\u0081\u0082\7?\2\2\u0082"+
		"$\3\2\2\2\u0083\u0084\7>\2\2\u0084\u0085\7?\2\2\u0085&\3\2\2\2\u0086\u0087"+
		"\7(\2\2\u0087\u0088\7(\2\2\u0088(\3\2\2\2\u0089\u008a\7~\2\2\u008a\u008b"+
		"\7~\2\2\u008b*\3\2\2\2\u008c\u008d\7v\2\2\u008d\u008e\7t\2\2\u008e\u008f"+
		"\7w\2\2\u008f\u0090\7g\2\2\u0090,\3\2\2\2\u0091\u0092\7\60\2\2\u0092."+
		"\3\2\2\2\u0093\u0094\7h\2\2\u0094\u0095\7c\2\2\u0095\u0096\7n\2\2\u0096"+
		"\u0097\7u\2\2\u0097\u0098\7g\2\2\u0098\60\3\2\2\2\u0099\u009a\7e\2\2\u009a"+
		"\u009b\7n\2\2\u009b\u009c\7c\2\2\u009c\u009d\7u\2\2\u009d\u009e\7u\2\2"+
		"\u009e\62\3\2\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7p\2\2\u00a1\u00a2\7"+
		"j\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7t\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6"+
		"\7v\2\2\u00a6\u00a7\7u\2\2\u00a7\64\3\2\2\2\u00a8\u00a9\7u\2\2\u00a9\u00aa"+
		"\7g\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7h\2\2\u00ac\66\3\2\2\2\u00ad\u00ae"+
		"\7U\2\2\u00ae\u00af\7G\2\2\u00af\u00b0\7N\2\2\u00b0\u00b1\7H\2\2\u00b1"+
		"\u00b2\7a\2\2\u00b2\u00b3\7V\2\2\u00b3\u00b4\7[\2\2\u00b4\u00b5\7R\2\2"+
		"\u00b5\u00b6\7G\2\2\u00b68\3\2\2\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7n\2"+
		"\2\u00b9\u00ba\7u\2\2\u00ba\u00bb\7g\2\2\u00bb:\3\2\2\2\u00bc\u00bd\7"+
		"h\2\2\u00bd\u00be\7k\2\2\u00be<\3\2\2\2\u00bf\u00c0\7k\2\2\u00c0\u00c1"+
		"\7h\2\2\u00c1>\3\2\2\2\u00c2\u00c3\7y\2\2\u00c3\u00c4\7j\2\2\u00c4\u00c5"+
		"\7k\2\2\u00c5\u00c6\7n\2\2\u00c6\u00c7\7g\2\2\u00c7@\3\2\2\2\u00c8\u00c9"+
		"\7p\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7y\2\2\u00cbB\3\2\2\2\u00cc\u00cd"+
		"\7k\2\2\u00cd\u00ce\7u\2\2\u00ce\u00cf\7x\2\2\u00cf\u00d0\7q\2\2\u00d0"+
		"\u00d1\7k\2\2\u00d1\u00d2\7f\2\2\u00d2D\3\2\2\2\u00d3\u00d4\7p\2\2\u00d4"+
		"\u00d5\7q\2\2\u00d5\u00d6\7v\2\2\u00d6F\3\2\2\2\u00d7\u00d8\7t\2\2\u00d8"+
		"\u00d9\7g\2\2\u00d9\u00da\7v\2\2\u00da\u00db\7w\2\2\u00db\u00dc\7t\2\2"+
		"\u00dc\u00dd\7p\2\2\u00ddH\3\2\2\2\u00de\u00df\7k\2\2\u00df\u00e0\7p\2"+
		"\2\u00e0\u00e1\7v\2\2\u00e1J\3\2\2\2\u00e2\u00e3\7u\2\2\u00e3\u00e4\7"+
		"v\2\2\u00e4\u00e5\7t\2\2\u00e5\u00e6\7k\2\2\u00e6\u00e7\7p\2\2\u00e7\u00e8"+
		"\7i\2\2\u00e8L\3\2\2\2\u00e9\u00ea\7d\2\2\u00ea\u00eb\7q\2\2\u00eb\u00ec"+
		"\7q\2\2\u00ec\u00ed\7n\2\2\u00edN\3\2\2\2\u00ee\u00f2\t\2\2\2\u00ef\u00f1"+
		"\t\3\2\2\u00f0\u00ef\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2"+
		"\u00f3\3\2\2\2\u00f3P\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f9\t\4\2\2"+
		"\u00f6\u00f8\t\3\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00f7"+
		"\3\2\2\2\u00f9\u00fa\3\2\2\2\u00faR\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc"+
		"\u00fe\t\5\2\2\u00fd\u00fc\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u00fd\3\2"+
		"\2\2\u00ff\u0100\3\2\2\2\u0100T\3\2\2\2\u0101\u0106\7$\2\2\u0102\u0105"+
		"\n\6\2\2\u0103\u0105\5W,\2\u0104\u0102\3\2\2\2\u0104\u0103\3\2\2\2\u0105"+
		"\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0109\3\2"+
		"\2\2\u0108\u0106\3\2\2\2\u0109\u010a\7$\2\2\u010aV\3\2\2\2\u010b\u010c"+
		"\7^\2\2\u010c\u010d\t\7\2\2\u010dX\3\2\2\2\u010e\u010f\7/\2\2\u010f\u0110"+
		"\7/\2\2\u0110\u0114\3\2\2\2\u0111\u0113\13\2\2\2\u0112\u0111\3\2\2\2\u0113"+
		"\u0116\3\2\2\2\u0114\u0115\3\2\2\2\u0114\u0112\3\2\2\2\u0115\u0117\3\2"+
		"\2\2\u0116\u0114\3\2\2\2\u0117\u0124\7\f\2\2\u0118\u0119\7*\2\2\u0119"+
		"\u011a\7,\2\2\u011a\u011e\3\2\2\2\u011b\u011d\13\2\2\2\u011c\u011b\3\2"+
		"\2\2\u011d\u0120\3\2\2\2\u011e\u011f\3\2\2\2\u011e\u011c\3\2\2\2\u011f"+
		"\u0121\3\2\2\2\u0120\u011e\3\2\2\2\u0121\u0122\7,\2\2\u0122\u0124\7+\2"+
		"\2\u0123\u010e\3\2\2\2\u0123\u0118\3\2\2\2\u0124\u0125\3\2\2\2\u0125\u0126"+
		"\b-\2\2\u0126Z\3\2\2\2\u0127\u0129\t\b\2\2\u0128\u0127\3\2\2\2\u0129\u012a"+
		"\3\2\2\2\u012a\u0128\3\2\2\2\u012a\u012b\3\2\2\2\u012b\u012c\3\2\2\2\u012c"+
		"\u012d\b.\2\2\u012d\\\3\2\2\2\f\2\u00f2\u00f9\u00ff\u0104\u0106\u0114"+
		"\u011e\u0123\u012a\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}