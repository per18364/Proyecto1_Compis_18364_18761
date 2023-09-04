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
		LBRACE=1, RBRACE=2, LPAREN=3, RPAREN=4, SEMI=5, COMMA=6, EQUALS=7, PLUS=8, 
		MINUS=9, MULT=10, DIV=11, EQ=12, LT=13, GT=14, TRUE=15, DOT=16, FALSE=17, 
		CLASS=18, INHERITS=19, SELF=20, SELF_TYPE=21, ELSE=22, FI=23, IF=24, WHILE=25, 
		NEW=26, ISVOID=27, NOT=28, RETURN=29, INT=30, STRING_TYPE=31, ID=32, TYPE_ID=33, 
		INTEGER=34, STRING=35, COMMENT=36, WS=37;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LBRACE", "RBRACE", "LPAREN", "RPAREN", "SEMI", "COMMA", "EQUALS", "PLUS", 
			"MINUS", "MULT", "DIV", "EQ", "LT", "GT", "TRUE", "DOT", "FALSE", "CLASS", 
			"INHERITS", "SELF", "SELF_TYPE", "ELSE", "FI", "IF", "WHILE", "NEW", 
			"ISVOID", "NOT", "RETURN", "INT", "STRING_TYPE", "ID", "TYPE_ID", "INTEGER", 
			"STRING", "EscapeSequence", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "';'", "','", "'='", "'+'", "'-'", 
			"'*'", "'/'", "'=='", "'<'", "'>'", "'true'", "'.'", "'false'", "'class'", 
			"'inherits'", "'self'", "'SELF_TYPE'", "'else'", "'fi'", "'if'", "'while'", 
			"'new'", "'isvoid'", "'not'", "'return'", "'int'", "'string'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LBRACE", "RBRACE", "LPAREN", "RPAREN", "SEMI", "COMMA", "EQUALS", 
			"PLUS", "MINUS", "MULT", "DIV", "EQ", "LT", "GT", "TRUE", "DOT", "FALSE", 
			"CLASS", "INHERITS", "SELF", "SELF_TYPE", "ELSE", "FI", "IF", "WHILE", 
			"NEW", "ISVOID", "NOT", "RETURN", "INT", "STRING_TYPE", "ID", "TYPE_ID", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\'\u0109\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\3\2\3\2\3\3\3\3\3\4\3\4\3"+
		"\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3"+
		"\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
		"\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3!\3!\7!\u00cc"+
		"\n!\f!\16!\u00cf\13!\3\"\3\"\7\"\u00d3\n\"\f\"\16\"\u00d6\13\"\3#\6#\u00d9"+
		"\n#\r#\16#\u00da\3$\3$\3$\7$\u00e0\n$\f$\16$\u00e3\13$\3$\3$\3%\3%\3%"+
		"\3&\3&\3&\3&\7&\u00ee\n&\f&\16&\u00f1\13&\3&\3&\3&\3&\3&\7&\u00f8\n&\f"+
		"&\16&\u00fb\13&\3&\3&\5&\u00ff\n&\3&\3&\3\'\6\'\u0104\n\'\r\'\16\'\u0105"+
		"\3\'\3\'\4\u00ef\u00f9\2(\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25"+
		"\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32"+
		"\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I\2K&M\'\3\2\t\3\2c|\6\2\62;C\\"+
		"aac|\3\2C\\\3\2\62;\6\2\13\f\17\17$$^^\b\2^^ddhhppttvv\5\2\13\f\17\17"+
		"\"\"\2\u0110\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2"+
		"\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2"+
		"\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3"+
		"\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2"+
		"\2\2G\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\3O\3\2\2\2\5Q\3\2\2\2\7S\3\2\2\2\t"+
		"U\3\2\2\2\13W\3\2\2\2\rY\3\2\2\2\17[\3\2\2\2\21]\3\2\2\2\23_\3\2\2\2\25"+
		"a\3\2\2\2\27c\3\2\2\2\31e\3\2\2\2\33h\3\2\2\2\35j\3\2\2\2\37l\3\2\2\2"+
		"!q\3\2\2\2#s\3\2\2\2%y\3\2\2\2\'\177\3\2\2\2)\u0088\3\2\2\2+\u008d\3\2"+
		"\2\2-\u0097\3\2\2\2/\u009c\3\2\2\2\61\u009f\3\2\2\2\63\u00a2\3\2\2\2\65"+
		"\u00a8\3\2\2\2\67\u00ac\3\2\2\29\u00b3\3\2\2\2;\u00b7\3\2\2\2=\u00be\3"+
		"\2\2\2?\u00c2\3\2\2\2A\u00c9\3\2\2\2C\u00d0\3\2\2\2E\u00d8\3\2\2\2G\u00dc"+
		"\3\2\2\2I\u00e6\3\2\2\2K\u00fe\3\2\2\2M\u0103\3\2\2\2OP\7}\2\2P\4\3\2"+
		"\2\2QR\7\177\2\2R\6\3\2\2\2ST\7*\2\2T\b\3\2\2\2UV\7+\2\2V\n\3\2\2\2WX"+
		"\7=\2\2X\f\3\2\2\2YZ\7.\2\2Z\16\3\2\2\2[\\\7?\2\2\\\20\3\2\2\2]^\7-\2"+
		"\2^\22\3\2\2\2_`\7/\2\2`\24\3\2\2\2ab\7,\2\2b\26\3\2\2\2cd\7\61\2\2d\30"+
		"\3\2\2\2ef\7?\2\2fg\7?\2\2g\32\3\2\2\2hi\7>\2\2i\34\3\2\2\2jk\7@\2\2k"+
		"\36\3\2\2\2lm\7v\2\2mn\7t\2\2no\7w\2\2op\7g\2\2p \3\2\2\2qr\7\60\2\2r"+
		"\"\3\2\2\2st\7h\2\2tu\7c\2\2uv\7n\2\2vw\7u\2\2wx\7g\2\2x$\3\2\2\2yz\7"+
		"e\2\2z{\7n\2\2{|\7c\2\2|}\7u\2\2}~\7u\2\2~&\3\2\2\2\177\u0080\7k\2\2\u0080"+
		"\u0081\7p\2\2\u0081\u0082\7j\2\2\u0082\u0083\7g\2\2\u0083\u0084\7t\2\2"+
		"\u0084\u0085\7k\2\2\u0085\u0086\7v\2\2\u0086\u0087\7u\2\2\u0087(\3\2\2"+
		"\2\u0088\u0089\7u\2\2\u0089\u008a\7g\2\2\u008a\u008b\7n\2\2\u008b\u008c"+
		"\7h\2\2\u008c*\3\2\2\2\u008d\u008e\7U\2\2\u008e\u008f\7G\2\2\u008f\u0090"+
		"\7N\2\2\u0090\u0091\7H\2\2\u0091\u0092\7a\2\2\u0092\u0093\7V\2\2\u0093"+
		"\u0094\7[\2\2\u0094\u0095\7R\2\2\u0095\u0096\7G\2\2\u0096,\3\2\2\2\u0097"+
		"\u0098\7g\2\2\u0098\u0099\7n\2\2\u0099\u009a\7u\2\2\u009a\u009b\7g\2\2"+
		"\u009b.\3\2\2\2\u009c\u009d\7h\2\2\u009d\u009e\7k\2\2\u009e\60\3\2\2\2"+
		"\u009f\u00a0\7k\2\2\u00a0\u00a1\7h\2\2\u00a1\62\3\2\2\2\u00a2\u00a3\7"+
		"y\2\2\u00a3\u00a4\7j\2\2\u00a4\u00a5\7k\2\2\u00a5\u00a6\7n\2\2\u00a6\u00a7"+
		"\7g\2\2\u00a7\64\3\2\2\2\u00a8\u00a9\7p\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab"+
		"\7y\2\2\u00ab\66\3\2\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7u\2\2\u00ae\u00af"+
		"\7x\2\2\u00af\u00b0\7q\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7f\2\2\u00b2"+
		"8\3\2\2\2\u00b3\u00b4\7p\2\2\u00b4\u00b5\7q\2\2\u00b5\u00b6\7v\2\2\u00b6"+
		":\3\2\2\2\u00b7\u00b8\7t\2\2\u00b8\u00b9\7g\2\2\u00b9\u00ba\7v\2\2\u00ba"+
		"\u00bb\7w\2\2\u00bb\u00bc\7t\2\2\u00bc\u00bd\7p\2\2\u00bd<\3\2\2\2\u00be"+
		"\u00bf\7k\2\2\u00bf\u00c0\7p\2\2\u00c0\u00c1\7v\2\2\u00c1>\3\2\2\2\u00c2"+
		"\u00c3\7u\2\2\u00c3\u00c4\7v\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6\7k\2\2"+
		"\u00c6\u00c7\7p\2\2\u00c7\u00c8\7i\2\2\u00c8@\3\2\2\2\u00c9\u00cd\t\2"+
		"\2\2\u00ca\u00cc\t\3\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd"+
		"\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ceB\3\2\2\2\u00cf\u00cd\3\2\2\2"+
		"\u00d0\u00d4\t\4\2\2\u00d1\u00d3\t\3\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6"+
		"\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5D\3\2\2\2\u00d6"+
		"\u00d4\3\2\2\2\u00d7\u00d9\t\5\2\2\u00d8\u00d7\3\2\2\2\u00d9\u00da\3\2"+
		"\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00dbF\3\2\2\2\u00dc\u00e1"+
		"\7$\2\2\u00dd\u00e0\n\6\2\2\u00de\u00e0\5I%\2\u00df\u00dd\3\2\2\2\u00df"+
		"\u00de\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1\u00e2\3\2"+
		"\2\2\u00e2\u00e4\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e5\7$\2\2\u00e5"+
		"H\3\2\2\2\u00e6\u00e7\7^\2\2\u00e7\u00e8\t\7\2\2\u00e8J\3\2\2\2\u00e9"+
		"\u00ea\7/\2\2\u00ea\u00eb\7/\2\2\u00eb\u00ef\3\2\2\2\u00ec\u00ee\13\2"+
		"\2\2\u00ed\u00ec\3\2\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00f0\3\2\2\2\u00ef"+
		"\u00ed\3\2\2\2\u00f0\u00f2\3\2\2\2\u00f1\u00ef\3\2\2\2\u00f2\u00ff\7\f"+
		"\2\2\u00f3\u00f4\7*\2\2\u00f4\u00f5\7,\2\2\u00f5\u00f9\3\2\2\2\u00f6\u00f8"+
		"\13\2\2\2\u00f7\u00f6\3\2\2\2\u00f8\u00fb\3\2\2\2\u00f9\u00fa\3\2\2\2"+
		"\u00f9\u00f7\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f9\3\2\2\2\u00fc\u00fd"+
		"\7,\2\2\u00fd\u00ff\7+\2\2\u00fe\u00e9\3\2\2\2\u00fe\u00f3\3\2\2\2\u00ff"+
		"\u0100\3\2\2\2\u0100\u0101\b&\2\2\u0101L\3\2\2\2\u0102\u0104\t\b\2\2\u0103"+
		"\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0103\3\2\2\2\u0105\u0106\3\2"+
		"\2\2\u0106\u0107\3\2\2\2\u0107\u0108\b\'\2\2\u0108N\3\2\2\2\f\2\u00cd"+
		"\u00d4\u00da\u00df\u00e1\u00ef\u00f9\u00fe\u0105\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}