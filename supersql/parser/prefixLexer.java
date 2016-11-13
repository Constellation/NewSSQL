// Generated from prefix.g4 by ANTLR 4.5

package supersql.parser;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class prefixLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.5", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, DEF=4, K_FOREACH=5, K_FOREACH1=6, K_IMPORT=7, 
		K_DEFINE=8, OPEN_PARENTHESE=9, CLOSE_PARENTHESE=10, OPEN_BRACKET=11, CLOSE_BRACKET=12, 
		OPEN_BRACE=13, CLOSE_BRACE=14, IDENTIFIER=15, STRING_LITERAL=16, MULTI_LINE_COMMENT=17, 
		SINGLE_LINE_COMMENT=18, WS=19, UNEXPECTED_CHAR=20;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "DEF", "K_FOREACH", "K_FOREACH1", "K_IMPORT", 
		"K_DEFINE", "OPEN_PARENTHESE", "CLOSE_PARENTHESE", "OPEN_BRACKET", "CLOSE_BRACKET", 
		"OPEN_BRACE", "CLOSE_BRACE", "IDENTIFIER", "STRING_LITERAL", "MULTI_LINE_COMMENT", 
		"SINGLE_LINE_COMMENT", "WS", "UNEXPECTED_CHAR", "DIGIT", "A", "B", "C", 
		"D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", 
		"R", "S", "T", "U", "V", "W", "X", "Y", "Z"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "','", "'.'", "'#'", null, null, null, null, null, "'('", "')'", 
		"'['", "']'", "'{'", "'}'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, "DEF", "K_FOREACH", "K_FOREACH1", "K_IMPORT", 
		"K_DEFINE", "OPEN_PARENTHESE", "CLOSE_PARENTHESE", "OPEN_BRACKET", "CLOSE_BRACKET", 
		"OPEN_BRACE", "CLOSE_BRACE", "IDENTIFIER", "STRING_LITERAL", "MULTI_LINE_COMMENT", 
		"SINGLE_LINE_COMMENT", "WS", "UNEXPECTED_CHAR"
	};
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


	public prefixLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "prefix.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\26\u0110\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t"+
		" \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t"+
		"+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\6"+
		"\5j\n\5\r\5\16\5k\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\6\7"+
		"z\n\7\r\7\16\7{\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\20\7\20\u0099"+
		"\n\20\f\20\16\20\u009c\13\20\3\20\3\20\7\20\u00a0\n\20\f\20\16\20\u00a3"+
		"\13\20\3\21\3\21\7\21\u00a7\n\21\f\21\16\21\u00aa\13\21\3\21\3\21\3\21"+
		"\7\21\u00af\n\21\f\21\16\21\u00b2\13\21\3\21\5\21\u00b5\n\21\3\22\3\22"+
		"\3\22\3\22\7\22\u00bb\n\22\f\22\16\22\u00be\13\22\3\22\3\22\3\22\5\22"+
		"\u00c3\n\22\3\22\3\22\3\23\3\23\3\23\3\23\7\23\u00cb\n\23\f\23\16\23\u00ce"+
		"\13\23\3\23\3\23\3\24\6\24\u00d3\n\24\r\24\16\24\u00d4\3\24\3\24\3\25"+
		"\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34"+
		"\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3 \3 \3!\3!\3\"\3\"\3#\3#\3$\3$\3"+
		"%\3%\3&\3&\3\'\3\'\3(\3(\3)\3)\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3/\3/\3\60"+
		"\3\60\4k\u00bc\2\61\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r"+
		"\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\2-\2/\2\61\2\63\2\65\2"+
		"\67\29\2;\2=\2?\2A\2C\2E\2G\2I\2K\2M\2O\2Q\2S\2U\2W\2Y\2[\2]\2_\2\3\2"+
		"#\3\2\62;\6\2\62;C\\aac|\5\2C\\aac|\3\2$$\3\2))\4\2\f\f\17\17\5\2\13\f"+
		"\17\17\"\"\4\2CCcc\4\2DDdd\4\2EEee\4\2FFff\4\2GGgg\4\2HHhh\4\2IIii\4\2"+
		"JJjj\4\2KKkk\4\2LLll\4\2MMmm\4\2NNnn\4\2OOoo\4\2PPpp\4\2QQqq\4\2RRrr\4"+
		"\2SSss\4\2TTtt\4\2UUuu\4\2VVvv\4\2WWww\4\2XXxx\4\2YYyy\4\2ZZzz\4\2[[{"+
		"{\4\2\\\\||\u00ff\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\3a\3\2\2\2\5c\3"+
		"\2\2\2\7e\3\2\2\2\tg\3\2\2\2\13o\3\2\2\2\rw\3\2\2\2\17}\3\2\2\2\21\u0084"+
		"\3\2\2\2\23\u008b\3\2\2\2\25\u008d\3\2\2\2\27\u008f\3\2\2\2\31\u0091\3"+
		"\2\2\2\33\u0093\3\2\2\2\35\u0095\3\2\2\2\37\u009a\3\2\2\2!\u00b4\3\2\2"+
		"\2#\u00b6\3\2\2\2%\u00c6\3\2\2\2\'\u00d2\3\2\2\2)\u00d8\3\2\2\2+\u00da"+
		"\3\2\2\2-\u00dc\3\2\2\2/\u00de\3\2\2\2\61\u00e0\3\2\2\2\63\u00e2\3\2\2"+
		"\2\65\u00e4\3\2\2\2\67\u00e6\3\2\2\29\u00e8\3\2\2\2;\u00ea\3\2\2\2=\u00ec"+
		"\3\2\2\2?\u00ee\3\2\2\2A\u00f0\3\2\2\2C\u00f2\3\2\2\2E\u00f4\3\2\2\2G"+
		"\u00f6\3\2\2\2I\u00f8\3\2\2\2K\u00fa\3\2\2\2M\u00fc\3\2\2\2O\u00fe\3\2"+
		"\2\2Q\u0100\3\2\2\2S\u0102\3\2\2\2U\u0104\3\2\2\2W\u0106\3\2\2\2Y\u0108"+
		"\3\2\2\2[\u010a\3\2\2\2]\u010c\3\2\2\2_\u010e\3\2\2\2ab\7.\2\2b\4\3\2"+
		"\2\2cd\7\60\2\2d\6\3\2\2\2ef\7%\2\2f\b\3\2\2\2gi\7}\2\2hj\13\2\2\2ih\3"+
		"\2\2\2jk\3\2\2\2kl\3\2\2\2ki\3\2\2\2lm\3\2\2\2mn\7\177\2\2n\n\3\2\2\2"+
		"op\5\67\34\2pq\5I%\2qr\5O(\2rs\5\65\33\2st\5-\27\2tu\5\61\31\2uv\5;\36"+
		"\2v\f\3\2\2\2wy\5\13\6\2xz\t\2\2\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2\2{|\3\2"+
		"\2\2|\16\3\2\2\2}~\5=\37\2~\177\5E#\2\177\u0080\5K&\2\u0080\u0081\5I%"+
		"\2\u0081\u0082\5O(\2\u0082\u0083\5S*\2\u0083\20\3\2\2\2\u0084\u0085\5"+
		"\63\32\2\u0085\u0086\5\65\33\2\u0086\u0087\5\67\34\2\u0087\u0088\5=\37"+
		"\2\u0088\u0089\5G$\2\u0089\u008a\5\65\33\2\u008a\22\3\2\2\2\u008b\u008c"+
		"\7*\2\2\u008c\24\3\2\2\2\u008d\u008e\7+\2\2\u008e\26\3\2\2\2\u008f\u0090"+
		"\7]\2\2\u0090\30\3\2\2\2\u0091\u0092\7_\2\2\u0092\32\3\2\2\2\u0093\u0094"+
		"\7}\2\2\u0094\34\3\2\2\2\u0095\u0096\7\177\2\2\u0096\36\3\2\2\2\u0097"+
		"\u0099\t\3\2\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a\u0098\3\2"+
		"\2\2\u009a\u009b\3\2\2\2\u009b\u009d\3\2\2\2\u009c\u009a\3\2\2\2\u009d"+
		"\u00a1\t\4\2\2\u009e\u00a0\t\3\2\2\u009f\u009e\3\2\2\2\u00a0\u00a3\3\2"+
		"\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2 \3\2\2\2\u00a3\u00a1"+
		"\3\2\2\2\u00a4\u00a8\7$\2\2\u00a5\u00a7\n\5\2\2\u00a6\u00a5\3\2\2\2\u00a7"+
		"\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ab\3\2"+
		"\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00b5\7$\2\2\u00ac\u00b0\7)\2\2\u00ad\u00af"+
		"\n\6\2\2\u00ae\u00ad\3\2\2\2\u00af\u00b2\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b0"+
		"\u00b1\3\2\2\2\u00b1\u00b3\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b3\u00b5\7)"+
		"\2\2\u00b4\u00a4\3\2\2\2\u00b4\u00ac\3\2\2\2\u00b5\"\3\2\2\2\u00b6\u00b7"+
		"\7\61\2\2\u00b7\u00b8\7,\2\2\u00b8\u00bc\3\2\2\2\u00b9\u00bb\13\2\2\2"+
		"\u00ba\u00b9\3\2\2\2\u00bb\u00be\3\2\2\2\u00bc\u00bd\3\2\2\2\u00bc\u00ba"+
		"\3\2\2\2\u00bd\u00c2\3\2\2\2\u00be\u00bc\3\2\2\2\u00bf\u00c0\7,\2\2\u00c0"+
		"\u00c3\7\61\2\2\u00c1\u00c3\7\2\2\3\u00c2\u00bf\3\2\2\2\u00c2\u00c1\3"+
		"\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\u00c5\b\22\2\2\u00c5$\3\2\2\2\u00c6\u00c7"+
		"\7/\2\2\u00c7\u00c8\7/\2\2\u00c8\u00cc\3\2\2\2\u00c9\u00cb\n\7\2\2\u00ca"+
		"\u00c9\3\2\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ca\3\2\2\2\u00cc\u00cd\3\2"+
		"\2\2\u00cd\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d0\b\23\2\2\u00d0"+
		"&\3\2\2\2\u00d1\u00d3\t\b\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d4\3\2\2\2"+
		"\u00d4\u00d2\3\2\2\2\u00d4\u00d5\3\2\2\2\u00d5\u00d6\3\2\2\2\u00d6\u00d7"+
		"\b\24\3\2\u00d7(\3\2\2\2\u00d8\u00d9\13\2\2\2\u00d9*\3\2\2\2\u00da\u00db"+
		"\t\2\2\2\u00db,\3\2\2\2\u00dc\u00dd\t\t\2\2\u00dd.\3\2\2\2\u00de\u00df"+
		"\t\n\2\2\u00df\60\3\2\2\2\u00e0\u00e1\t\13\2\2\u00e1\62\3\2\2\2\u00e2"+
		"\u00e3\t\f\2\2\u00e3\64\3\2\2\2\u00e4\u00e5\t\r\2\2\u00e5\66\3\2\2\2\u00e6"+
		"\u00e7\t\16\2\2\u00e78\3\2\2\2\u00e8\u00e9\t\17\2\2\u00e9:\3\2\2\2\u00ea"+
		"\u00eb\t\20\2\2\u00eb<\3\2\2\2\u00ec\u00ed\t\21\2\2\u00ed>\3\2\2\2\u00ee"+
		"\u00ef\t\22\2\2\u00ef@\3\2\2\2\u00f0\u00f1\t\23\2\2\u00f1B\3\2\2\2\u00f2"+
		"\u00f3\t\24\2\2\u00f3D\3\2\2\2\u00f4\u00f5\t\25\2\2\u00f5F\3\2\2\2\u00f6"+
		"\u00f7\t\26\2\2\u00f7H\3\2\2\2\u00f8\u00f9\t\27\2\2\u00f9J\3\2\2\2\u00fa"+
		"\u00fb\t\30\2\2\u00fbL\3\2\2\2\u00fc\u00fd\t\31\2\2\u00fdN\3\2\2\2\u00fe"+
		"\u00ff\t\32\2\2\u00ffP\3\2\2\2\u0100\u0101\t\33\2\2\u0101R\3\2\2\2\u0102"+
		"\u0103\t\34\2\2\u0103T\3\2\2\2\u0104\u0105\t\35\2\2\u0105V\3\2\2\2\u0106"+
		"\u0107\t\36\2\2\u0107X\3\2\2\2\u0108\u0109\t\37\2\2\u0109Z\3\2\2\2\u010a"+
		"\u010b\t \2\2\u010b\\\3\2\2\2\u010c\u010d\t!\2\2\u010d^\3\2\2\2\u010e"+
		"\u010f\t\"\2\2\u010f`\3\2\2\2\16\2k{\u009a\u00a1\u00a8\u00b0\u00b4\u00bc"+
		"\u00c2\u00cc\u00d4\4\2\3\2\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}