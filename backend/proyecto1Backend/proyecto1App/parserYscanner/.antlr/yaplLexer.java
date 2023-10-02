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
		LT_EQ=18, AND=19, OR=20, COLON=21, TRUE=22, DOT=23, FALSE=24, CLASS=25, 
		INHERITS=26, SELF=27, SELF_TYPE=28, ELSE=29, FI=30, IF=31, WHILE=32, NEW=33, 
		ISVOID=34, NOT=35, RETURN=36, INT=37, STRING_TYPE=38, BOOL=39, VOID=40, 
		LET=41, IN=42, ID=43, TYPE_ID=44, INTEGER=45, STRING=46, COMMENT=47, WS=48;
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
			"AND", "OR", "COLON", "TRUE", "DOT", "FALSE", "CLASS", "INHERITS", "SELF", 
			"SELF_TYPE", "ELSE", "FI", "IF", "WHILE", "NEW", "ISVOID", "NOT", "RETURN", 
			"INT", "STRING_TYPE", "BOOL", "VOID", "LET", "IN", "ID", "TYPE_ID", "INTEGER", 
			"STRING", "EscapeSequence", "COMMENT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\62\u0144\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33\3\33"+
		"\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3!\3!"+
		"\3!\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3%\3%\3%\3%\3%\3"+
		"%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3)\3"+
		")\3)\3*\3*\3*\3*\3+\3+\3+\3,\3,\7,\u0107\n,\f,\16,\u010a\13,\3-\3-\7-"+
		"\u010e\n-\f-\16-\u0111\13-\3.\6.\u0114\n.\r.\16.\u0115\3/\3/\3/\7/\u011b"+
		"\n/\f/\16/\u011e\13/\3/\3/\3\60\3\60\3\60\3\61\3\61\3\61\3\61\7\61\u0129"+
		"\n\61\f\61\16\61\u012c\13\61\3\61\3\61\3\61\3\61\3\61\7\61\u0133\n\61"+
		"\f\61\16\61\u0136\13\61\3\61\3\61\5\61\u013a\n\61\3\61\3\61\3\62\6\62"+
		"\u013f\n\62\r\62\16\62\u0140\3\62\3\62\4\u012a\u0134\2\63\3\3\5\4\7\5"+
		"\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M(O)Q*S+U,W-Y.[/]\60_\2a\61c\62\3\2\t\3\2c|\6\2\62;C\\aac|\3\2C"+
		"\\\3\2\62;\6\2\13\f\17\17$$^^\b\2^^ddhhppttvv\5\2\13\f\17\17\"\"\2\u014b"+
		"\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2"+
		"\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2"+
		"\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2"+
		"\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2"+
		"\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3"+
		"\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2a\3\2\2\2\2c\3"+
		"\2\2\2\3e\3\2\2\2\5g\3\2\2\2\7i\3\2\2\2\tk\3\2\2\2\13m\3\2\2\2\ro\3\2"+
		"\2\2\17q\3\2\2\2\21s\3\2\2\2\23v\3\2\2\2\25x\3\2\2\2\27z\3\2\2\2\31|\3"+
		"\2\2\2\33~\3\2\2\2\35\u0081\3\2\2\2\37\u0084\3\2\2\2!\u0086\3\2\2\2#\u0088"+
		"\3\2\2\2%\u008b\3\2\2\2\'\u008e\3\2\2\2)\u0091\3\2\2\2+\u0094\3\2\2\2"+
		"-\u0096\3\2\2\2/\u009b\3\2\2\2\61\u009d\3\2\2\2\63\u00a3\3\2\2\2\65\u00a9"+
		"\3\2\2\2\67\u00b2\3\2\2\29\u00b7\3\2\2\2;\u00c1\3\2\2\2=\u00c6\3\2\2\2"+
		"?\u00c9\3\2\2\2A\u00cc\3\2\2\2C\u00d2\3\2\2\2E\u00d6\3\2\2\2G\u00dd\3"+
		"\2\2\2I\u00e1\3\2\2\2K\u00e8\3\2\2\2M\u00ec\3\2\2\2O\u00f3\3\2\2\2Q\u00f8"+
		"\3\2\2\2S\u00fd\3\2\2\2U\u0101\3\2\2\2W\u0104\3\2\2\2Y\u010b\3\2\2\2["+
		"\u0113\3\2\2\2]\u0117\3\2\2\2_\u0121\3\2\2\2a\u0139\3\2\2\2c\u013e\3\2"+
		"\2\2ef\7}\2\2f\4\3\2\2\2gh\7\177\2\2h\6\3\2\2\2ij\7*\2\2j\b\3\2\2\2kl"+
		"\7+\2\2l\n\3\2\2\2mn\7=\2\2n\f\3\2\2\2op\7.\2\2p\16\3\2\2\2qr\7?\2\2r"+
		"\20\3\2\2\2st\7>\2\2tu\7/\2\2u\22\3\2\2\2vw\7-\2\2w\24\3\2\2\2xy\7/\2"+
		"\2y\26\3\2\2\2z{\7,\2\2{\30\3\2\2\2|}\7\61\2\2}\32\3\2\2\2~\177\7?\2\2"+
		"\177\u0080\7?\2\2\u0080\34\3\2\2\2\u0081\u0082\7#\2\2\u0082\u0083\7?\2"+
		"\2\u0083\36\3\2\2\2\u0084\u0085\7>\2\2\u0085 \3\2\2\2\u0086\u0087\7@\2"+
		"\2\u0087\"\3\2\2\2\u0088\u0089\7@\2\2\u0089\u008a\7?\2\2\u008a$\3\2\2"+
		"\2\u008b\u008c\7>\2\2\u008c\u008d\7?\2\2\u008d&\3\2\2\2\u008e\u008f\7"+
		"(\2\2\u008f\u0090\7(\2\2\u0090(\3\2\2\2\u0091\u0092\7~\2\2\u0092\u0093"+
		"\7~\2\2\u0093*\3\2\2\2\u0094\u0095\7<\2\2\u0095,\3\2\2\2\u0096\u0097\7"+
		"v\2\2\u0097\u0098\7t\2\2\u0098\u0099\7w\2\2\u0099\u009a\7g\2\2\u009a."+
		"\3\2\2\2\u009b\u009c\7\60\2\2\u009c\60\3\2\2\2\u009d\u009e\7h\2\2\u009e"+
		"\u009f\7c\2\2\u009f\u00a0\7n\2\2\u00a0\u00a1\7u\2\2\u00a1\u00a2\7g\2\2"+
		"\u00a2\62\3\2\2\2\u00a3\u00a4\7e\2\2\u00a4\u00a5\7n\2\2\u00a5\u00a6\7"+
		"c\2\2\u00a6\u00a7\7u\2\2\u00a7\u00a8\7u\2\2\u00a8\64\3\2\2\2\u00a9\u00aa"+
		"\7k\2\2\u00aa\u00ab\7p\2\2\u00ab\u00ac\7j\2\2\u00ac\u00ad\7g\2\2\u00ad"+
		"\u00ae\7t\2\2\u00ae\u00af\7k\2\2\u00af\u00b0\7v\2\2\u00b0\u00b1\7u\2\2"+
		"\u00b1\66\3\2\2\2\u00b2\u00b3\7u\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7"+
		"n\2\2\u00b5\u00b6\7h\2\2\u00b68\3\2\2\2\u00b7\u00b8\7U\2\2\u00b8\u00b9"+
		"\7G\2\2\u00b9\u00ba\7N\2\2\u00ba\u00bb\7H\2\2\u00bb\u00bc\7a\2\2\u00bc"+
		"\u00bd\7V\2\2\u00bd\u00be\7[\2\2\u00be\u00bf\7R\2\2\u00bf\u00c0\7G\2\2"+
		"\u00c0:\3\2\2\2\u00c1\u00c2\7g\2\2\u00c2\u00c3\7n\2\2\u00c3\u00c4\7u\2"+
		"\2\u00c4\u00c5\7g\2\2\u00c5<\3\2\2\2\u00c6\u00c7\7h\2\2\u00c7\u00c8\7"+
		"k\2\2\u00c8>\3\2\2\2\u00c9\u00ca\7k\2\2\u00ca\u00cb\7h\2\2\u00cb@\3\2"+
		"\2\2\u00cc\u00cd\7y\2\2\u00cd\u00ce\7j\2\2\u00ce\u00cf\7k\2\2\u00cf\u00d0"+
		"\7n\2\2\u00d0\u00d1\7g\2\2\u00d1B\3\2\2\2\u00d2\u00d3\7p\2\2\u00d3\u00d4"+
		"\7g\2\2\u00d4\u00d5\7y\2\2\u00d5D\3\2\2\2\u00d6\u00d7\7k\2\2\u00d7\u00d8"+
		"\7u\2\2\u00d8\u00d9\7x\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7k\2\2\u00db"+
		"\u00dc\7f\2\2\u00dcF\3\2\2\2\u00dd\u00de\7p\2\2\u00de\u00df\7q\2\2\u00df"+
		"\u00e0\7v\2\2\u00e0H\3\2\2\2\u00e1\u00e2\7t\2\2\u00e2\u00e3\7g\2\2\u00e3"+
		"\u00e4\7v\2\2\u00e4\u00e5\7w\2\2\u00e5\u00e6\7t\2\2\u00e6\u00e7\7p\2\2"+
		"\u00e7J\3\2\2\2\u00e8\u00e9\7k\2\2\u00e9\u00ea\7p\2\2\u00ea\u00eb\7v\2"+
		"\2\u00ebL\3\2\2\2\u00ec\u00ed\7u\2\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7"+
		"t\2\2\u00ef\u00f0\7k\2\2\u00f0\u00f1\7p\2\2\u00f1\u00f2\7i\2\2\u00f2N"+
		"\3\2\2\2\u00f3\u00f4\7d\2\2\u00f4\u00f5\7q\2\2\u00f5\u00f6\7q\2\2\u00f6"+
		"\u00f7\7n\2\2\u00f7P\3\2\2\2\u00f8\u00f9\7x\2\2\u00f9\u00fa\7q\2\2\u00fa"+
		"\u00fb\7k\2\2\u00fb\u00fc\7f\2\2\u00fcR\3\2\2\2\u00fd\u00fe\7n\2\2\u00fe"+
		"\u00ff\7g\2\2\u00ff\u0100\7v\2\2\u0100T\3\2\2\2\u0101\u0102\7k\2\2\u0102"+
		"\u0103\7p\2\2\u0103V\3\2\2\2\u0104\u0108\t\2\2\2\u0105\u0107\t\3\2\2\u0106"+
		"\u0105\3\2\2\2\u0107\u010a\3\2\2\2\u0108\u0106\3\2\2\2\u0108\u0109\3\2"+
		"\2\2\u0109X\3\2\2\2\u010a\u0108\3\2\2\2\u010b\u010f\t\4\2\2\u010c\u010e"+
		"\t\3\2\2\u010d\u010c\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f"+
		"\u0110\3\2\2\2\u0110Z\3\2\2\2\u0111\u010f\3\2\2\2\u0112\u0114\t\5\2\2"+
		"\u0113\u0112\3\2\2\2\u0114\u0115\3\2\2\2\u0115\u0113\3\2\2\2\u0115\u0116"+
		"\3\2\2\2\u0116\\\3\2\2\2\u0117\u011c\7$\2\2\u0118\u011b\n\6\2\2\u0119"+
		"\u011b\5_\60\2\u011a\u0118\3\2\2\2\u011a\u0119\3\2\2\2\u011b\u011e\3\2"+
		"\2\2\u011c\u011a\3\2\2\2\u011c\u011d\3\2\2\2\u011d\u011f\3\2\2\2\u011e"+
		"\u011c\3\2\2\2\u011f\u0120\7$\2\2\u0120^\3\2\2\2\u0121\u0122\7^\2\2\u0122"+
		"\u0123\t\7\2\2\u0123`\3\2\2\2\u0124\u0125\7/\2\2\u0125\u0126\7/\2\2\u0126"+
		"\u012a\3\2\2\2\u0127\u0129\13\2\2\2\u0128\u0127\3\2\2\2\u0129\u012c\3"+
		"\2\2\2\u012a\u012b\3\2\2\2\u012a\u0128\3\2\2\2\u012b\u012d\3\2\2\2\u012c"+
		"\u012a\3\2\2\2\u012d\u013a\7\f\2\2\u012e\u012f\7*\2\2\u012f\u0130\7,\2"+
		"\2\u0130\u0134\3\2\2\2\u0131\u0133\13\2\2\2\u0132\u0131\3\2\2\2\u0133"+
		"\u0136\3\2\2\2\u0134\u0135\3\2\2\2\u0134\u0132\3\2\2\2\u0135\u0137\3\2"+
		"\2\2\u0136\u0134\3\2\2\2\u0137\u0138\7,\2\2\u0138\u013a\7+\2\2\u0139\u0124"+
		"\3\2\2\2\u0139\u012e\3\2\2\2\u013a\u013b\3\2\2\2\u013b\u013c\b\61\2\2"+
		"\u013cb\3\2\2\2\u013d\u013f\t\b\2\2\u013e\u013d\3\2\2\2\u013f\u0140\3"+
		"\2\2\2\u0140\u013e\3\2\2\2\u0140\u0141\3\2\2\2\u0141\u0142\3\2\2\2\u0142"+
		"\u0143\b\62\2\2\u0143d\3\2\2\2\f\2\u0108\u010f\u0115\u011a\u011c\u012a"+
		"\u0134\u0139\u0140\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}