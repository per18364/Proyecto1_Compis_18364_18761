// Generated from e:\\UVG\\COMPU\\2023_2ndo_semestre\\COMPIS\\Proyecto1_Compis_18364_18761\\yapl.g4 by ANTLR 4.9.2
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
		MINUS=9, MULT=10, DIV=11, EQ=12, LT=13, TRUE=14, DOT=15, FALSE=16, CLASS=17, 
		INHERITS=18, SELF=19, SELF_TYPE=20, ELSE=21, FI=22, IF=23, WHILE=24, NEW=25, 
		ISVOID=26, NOT=27, RETURN=28, INT=29, STRING_TYPE=30, ID=31, TYPE_ID=32, 
		INTEGER=33, STRING=34, COMMENT=35, WS=36;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"LBRACE", "RBRACE", "LPAREN", "RPAREN", "SEMI", "COMMA", "EQUALS", "PLUS", 
			"MINUS", "MULT", "DIV", "EQ", "LT", "TRUE", "DOT", "FALSE", "CLASS", 
			"INHERITS", "SELF", "SELF_TYPE", "ELSE", "FI", "IF", "WHILE", "NEW", 
			"ISVOID", "NOT", "RETURN", "INT", "STRING_TYPE", "ID", "TYPE_ID", "INTEGER", 
			"STRING", "EscapeSequence", "COMMENT", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'{'", "'}'", "'('", "')'", "';'", "','", "'='", "'+'", "'-'", 
			"'*'", "'/'", "'=='", "'<'", "'true'", "'.'", "'false'", "'class'", "'inherits'", 
			"'self'", "'SELF_TYPE'", "'else'", "'fi'", "'if'", "'while'", "'new'", 
			"'isvoid'", "'not'", "'return'", "'int'", "'string'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "LBRACE", "RBRACE", "LPAREN", "RPAREN", "SEMI", "COMMA", "EQUALS", 
			"PLUS", "MINUS", "MULT", "DIV", "EQ", "LT", "TRUE", "DOT", "FALSE", "CLASS", 
			"INHERITS", "SELF", "SELF_TYPE", "ELSE", "FI", "IF", "WHILE", "NEW", 
			"ISVOID", "NOT", "RETURN", "INT", "STRING_TYPE", "ID", "TYPE_ID", "INTEGER", 
			"STRING", "COMMENT", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2&\u0105\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3"+
		"\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3"+
		"\21\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3"+
		"\31\3\31\3\31\3\31\3\31\3\31\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3"+
		"\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \7 \u00c8\n"+
		" \f \16 \u00cb\13 \3!\3!\7!\u00cf\n!\f!\16!\u00d2\13!\3\"\6\"\u00d5\n"+
		"\"\r\"\16\"\u00d6\3#\3#\3#\7#\u00dc\n#\f#\16#\u00df\13#\3#\3#\3$\3$\3"+
		"$\3%\3%\3%\3%\7%\u00ea\n%\f%\16%\u00ed\13%\3%\3%\3%\3%\3%\7%\u00f4\n%"+
		"\f%\16%\u00f7\13%\3%\3%\5%\u00fb\n%\3%\3%\3&\6&\u0100\n&\r&\16&\u0101"+
		"\3&\3&\4\u00eb\u00f5\2\'\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f"+
		"\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63"+
		"\33\65\34\67\359\36;\37= ?!A\"C#E$G\2I%K&\3\2\t\3\2c|\6\2\62;C\\aac|\3"+
		"\2C\\\3\2\62;\6\2\13\f\17\17$$^^\b\2^^ddhhppttvv\5\2\13\f\17\17\"\"\2"+
		"\u010c\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"I\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5O\3\2\2\2\7Q\3\2\2\2\tS\3\2\2\2\13U\3"+
		"\2\2\2\rW\3\2\2\2\17Y\3\2\2\2\21[\3\2\2\2\23]\3\2\2\2\25_\3\2\2\2\27a"+
		"\3\2\2\2\31c\3\2\2\2\33f\3\2\2\2\35h\3\2\2\2\37m\3\2\2\2!o\3\2\2\2#u\3"+
		"\2\2\2%{\3\2\2\2\'\u0084\3\2\2\2)\u0089\3\2\2\2+\u0093\3\2\2\2-\u0098"+
		"\3\2\2\2/\u009b\3\2\2\2\61\u009e\3\2\2\2\63\u00a4\3\2\2\2\65\u00a8\3\2"+
		"\2\2\67\u00af\3\2\2\29\u00b3\3\2\2\2;\u00ba\3\2\2\2=\u00be\3\2\2\2?\u00c5"+
		"\3\2\2\2A\u00cc\3\2\2\2C\u00d4\3\2\2\2E\u00d8\3\2\2\2G\u00e2\3\2\2\2I"+
		"\u00fa\3\2\2\2K\u00ff\3\2\2\2MN\7}\2\2N\4\3\2\2\2OP\7\177\2\2P\6\3\2\2"+
		"\2QR\7*\2\2R\b\3\2\2\2ST\7+\2\2T\n\3\2\2\2UV\7=\2\2V\f\3\2\2\2WX\7.\2"+
		"\2X\16\3\2\2\2YZ\7?\2\2Z\20\3\2\2\2[\\\7-\2\2\\\22\3\2\2\2]^\7/\2\2^\24"+
		"\3\2\2\2_`\7,\2\2`\26\3\2\2\2ab\7\61\2\2b\30\3\2\2\2cd\7?\2\2de\7?\2\2"+
		"e\32\3\2\2\2fg\7>\2\2g\34\3\2\2\2hi\7v\2\2ij\7t\2\2jk\7w\2\2kl\7g\2\2"+
		"l\36\3\2\2\2mn\7\60\2\2n \3\2\2\2op\7h\2\2pq\7c\2\2qr\7n\2\2rs\7u\2\2"+
		"st\7g\2\2t\"\3\2\2\2uv\7e\2\2vw\7n\2\2wx\7c\2\2xy\7u\2\2yz\7u\2\2z$\3"+
		"\2\2\2{|\7k\2\2|}\7p\2\2}~\7j\2\2~\177\7g\2\2\177\u0080\7t\2\2\u0080\u0081"+
		"\7k\2\2\u0081\u0082\7v\2\2\u0082\u0083\7u\2\2\u0083&\3\2\2\2\u0084\u0085"+
		"\7u\2\2\u0085\u0086\7g\2\2\u0086\u0087\7n\2\2\u0087\u0088\7h\2\2\u0088"+
		"(\3\2\2\2\u0089\u008a\7U\2\2\u008a\u008b\7G\2\2\u008b\u008c\7N\2\2\u008c"+
		"\u008d\7H\2\2\u008d\u008e\7a\2\2\u008e\u008f\7V\2\2\u008f\u0090\7[\2\2"+
		"\u0090\u0091\7R\2\2\u0091\u0092\7G\2\2\u0092*\3\2\2\2\u0093\u0094\7g\2"+
		"\2\u0094\u0095\7n\2\2\u0095\u0096\7u\2\2\u0096\u0097\7g\2\2\u0097,\3\2"+
		"\2\2\u0098\u0099\7h\2\2\u0099\u009a\7k\2\2\u009a.\3\2\2\2\u009b\u009c"+
		"\7k\2\2\u009c\u009d\7h\2\2\u009d\60\3\2\2\2\u009e\u009f\7y\2\2\u009f\u00a0"+
		"\7j\2\2\u00a0\u00a1\7k\2\2\u00a1\u00a2\7n\2\2\u00a2\u00a3\7g\2\2\u00a3"+
		"\62\3\2\2\2\u00a4\u00a5\7p\2\2\u00a5\u00a6\7g\2\2\u00a6\u00a7\7y\2\2\u00a7"+
		"\64\3\2\2\2\u00a8\u00a9\7k\2\2\u00a9\u00aa\7u\2\2\u00aa\u00ab\7x\2\2\u00ab"+
		"\u00ac\7q\2\2\u00ac\u00ad\7k\2\2\u00ad\u00ae\7f\2\2\u00ae\66\3\2\2\2\u00af"+
		"\u00b0\7p\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2\7v\2\2\u00b28\3\2\2\2\u00b3"+
		"\u00b4\7t\2\2\u00b4\u00b5\7g\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7w\2\2"+
		"\u00b7\u00b8\7t\2\2\u00b8\u00b9\7p\2\2\u00b9:\3\2\2\2\u00ba\u00bb\7k\2"+
		"\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7v\2\2\u00bd<\3\2\2\2\u00be\u00bf\7"+
		"u\2\2\u00bf\u00c0\7v\2\2\u00c0\u00c1\7t\2\2\u00c1\u00c2\7k\2\2\u00c2\u00c3"+
		"\7p\2\2\u00c3\u00c4\7i\2\2\u00c4>\3\2\2\2\u00c5\u00c9\t\2\2\2\u00c6\u00c8"+
		"\t\3\2\2\u00c7\u00c6\3\2\2\2\u00c8\u00cb\3\2\2\2\u00c9\u00c7\3\2\2\2\u00c9"+
		"\u00ca\3\2\2\2\u00ca@\3\2\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00d0\t\4\2\2"+
		"\u00cd\u00cf\t\3\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce"+
		"\3\2\2\2\u00d0\u00d1\3\2\2\2\u00d1B\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d3"+
		"\u00d5\t\5\2\2\u00d4\u00d3\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d4\3\2"+
		"\2\2\u00d6\u00d7\3\2\2\2\u00d7D\3\2\2\2\u00d8\u00dd\7$\2\2\u00d9\u00dc"+
		"\n\6\2\2\u00da\u00dc\5G$\2\u00db\u00d9\3\2\2\2\u00db\u00da\3\2\2\2\u00dc"+
		"\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\u00e0\3\2"+
		"\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\7$\2\2\u00e1F\3\2\2\2\u00e2\u00e3"+
		"\7^\2\2\u00e3\u00e4\t\7\2\2\u00e4H\3\2\2\2\u00e5\u00e6\7/\2\2\u00e6\u00e7"+
		"\7/\2\2\u00e7\u00eb\3\2\2\2\u00e8\u00ea\13\2\2\2\u00e9\u00e8\3\2\2\2\u00ea"+
		"\u00ed\3\2\2\2\u00eb\u00ec\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ee\3\2"+
		"\2\2\u00ed\u00eb\3\2\2\2\u00ee\u00fb\7\f\2\2\u00ef\u00f0\7*\2\2\u00f0"+
		"\u00f1\7,\2\2\u00f1\u00f5\3\2\2\2\u00f2\u00f4\13\2\2\2\u00f3\u00f2\3\2"+
		"\2\2\u00f4\u00f7\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6"+
		"\u00f8\3\2\2\2\u00f7\u00f5\3\2\2\2\u00f8\u00f9\7,\2\2\u00f9\u00fb\7+\2"+
		"\2\u00fa\u00e5\3\2\2\2\u00fa\u00ef\3\2\2\2\u00fb\u00fc\3\2\2\2\u00fc\u00fd"+
		"\b%\2\2\u00fdJ\3\2\2\2\u00fe\u0100\t\b\2\2\u00ff\u00fe\3\2\2\2\u0100\u0101"+
		"\3\2\2\2\u0101\u00ff\3\2\2\2\u0101\u0102\3\2\2\2\u0102\u0103\3\2\2\2\u0103"+
		"\u0104\b&\2\2\u0104L\3\2\2\2\f\2\u00c9\u00d0\u00d6\u00db\u00dd\u00eb\u00f5"+
		"\u00fa\u0101\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}