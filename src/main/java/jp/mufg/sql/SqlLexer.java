// Generated from jp/mufg/sql/Sql.g4 by ANTLR 4.0
package jp.mufg.sql;
 
import jp.mufg.sqlutil.SqlExprs.*;
import java.util.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlLexer extends Lexer {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__31=1, T__30=2, T__29=3, T__28=4, T__27=5, T__26=6, T__25=7, T__24=8, 
		T__23=9, T__22=10, T__21=11, T__20=12, T__19=13, T__18=14, T__17=15, T__16=16, 
		T__15=17, T__14=18, T__13=19, T__12=20, T__11=21, T__10=22, T__9=23, T__8=24, 
		T__7=25, T__6=26, T__5=27, T__4=28, T__3=29, T__2=30, T__1=31, T__0=32, 
		WS=33, NUMBER=34, ID1=35, ID2=36, STR=37;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'LIMIT'", "'AS'", "'BY'", "'FROM'", "'ELSE'", "'WHERE'", "'!='", "'END'", 
		"'AND'", "'='", "'THEN'", "'<='", "'GROUP'", "'CASE'", "'$'", "'('", "'SELECT'", 
		"','", "'.'", "'WHEN'", "'FALSE'", "'>='", "'<'", "'>'", "'OR'", "'or'", 
		"'HAVING'", "'IN'", "'in'", "')'", "'and'", "'TRUE'", "WS", "NUMBER", 
		"ID1", "ID2", "STR"
	};
	public static final String[] ruleNames = {
		"T__31", "T__30", "T__29", "T__28", "T__27", "T__26", "T__25", "T__24", 
		"T__23", "T__22", "T__21", "T__20", "T__19", "T__18", "T__17", "T__16", 
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "WS", 
		"NUMBER", "ID1", "ID2", "STR"
	};


	public SqlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Sql.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 32: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\'\u00f1\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3"+
		"\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3"+
		"\36\3\36\3\36\3\37\3\37\3 \3 \3 \3 \3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3#"+
		"\5#\u00ce\n#\3#\6#\u00d1\n#\r#\16#\u00d2\3#\3#\5#\u00d7\n#\3$\3$\7$\u00db"+
		"\n$\f$\16$\u00de\13$\3%\3%\7%\u00e2\n%\f%\16%\u00e5\13%\3%\3%\3&\3&\7"+
		"&\u00eb\n&\f&\16&\u00ee\13&\3&\3&\2\'\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r"+
		"\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21"+
		"\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65"+
		"\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\2E$\1G%\1I&\1K\'\1\3\2\t\5\13"+
		"\f\17\17\"\"\3\62;\3\62;\6%%C\\aac|\7%&\62;B\\aac|\3$$\3))\u00f6\2\3\3"+
		"\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2"+
		"\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3"+
		"\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2"+
		"%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61"+
		"\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2"+
		"\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I"+
		"\3\2\2\2\2K\3\2\2\2\3M\3\2\2\2\5S\3\2\2\2\7V\3\2\2\2\tY\3\2\2\2\13^\3"+
		"\2\2\2\rc\3\2\2\2\17i\3\2\2\2\21l\3\2\2\2\23p\3\2\2\2\25t\3\2\2\2\27v"+
		"\3\2\2\2\31{\3\2\2\2\33~\3\2\2\2\35\u0084\3\2\2\2\37\u0089\3\2\2\2!\u008b"+
		"\3\2\2\2#\u008d\3\2\2\2%\u0094\3\2\2\2\'\u0096\3\2\2\2)\u0098\3\2\2\2"+
		"+\u009d\3\2\2\2-\u00a3\3\2\2\2/\u00a6\3\2\2\2\61\u00a8\3\2\2\2\63\u00aa"+
		"\3\2\2\2\65\u00ad\3\2\2\2\67\u00b0\3\2\2\29\u00b7\3\2\2\2;\u00ba\3\2\2"+
		"\2=\u00bd\3\2\2\2?\u00bf\3\2\2\2A\u00c3\3\2\2\2C\u00c8\3\2\2\2E\u00cd"+
		"\3\2\2\2G\u00d8\3\2\2\2I\u00df\3\2\2\2K\u00e8\3\2\2\2MN\7N\2\2NO\7K\2"+
		"\2OP\7O\2\2PQ\7K\2\2QR\7V\2\2R\4\3\2\2\2ST\7C\2\2TU\7U\2\2U\6\3\2\2\2"+
		"VW\7D\2\2WX\7[\2\2X\b\3\2\2\2YZ\7H\2\2Z[\7T\2\2[\\\7Q\2\2\\]\7O\2\2]\n"+
		"\3\2\2\2^_\7G\2\2_`\7N\2\2`a\7U\2\2ab\7G\2\2b\f\3\2\2\2cd\7Y\2\2de\7J"+
		"\2\2ef\7G\2\2fg\7T\2\2gh\7G\2\2h\16\3\2\2\2ij\7#\2\2jk\7?\2\2k\20\3\2"+
		"\2\2lm\7G\2\2mn\7P\2\2no\7F\2\2o\22\3\2\2\2pq\7C\2\2qr\7P\2\2rs\7F\2\2"+
		"s\24\3\2\2\2tu\7?\2\2u\26\3\2\2\2vw\7V\2\2wx\7J\2\2xy\7G\2\2yz\7P\2\2"+
		"z\30\3\2\2\2{|\7>\2\2|}\7?\2\2}\32\3\2\2\2~\177\7I\2\2\177\u0080\7T\2"+
		"\2\u0080\u0081\7Q\2\2\u0081\u0082\7W\2\2\u0082\u0083\7R\2\2\u0083\34\3"+
		"\2\2\2\u0084\u0085\7E\2\2\u0085\u0086\7C\2\2\u0086\u0087\7U\2\2\u0087"+
		"\u0088\7G\2\2\u0088\36\3\2\2\2\u0089\u008a\7&\2\2\u008a \3\2\2\2\u008b"+
		"\u008c\7*\2\2\u008c\"\3\2\2\2\u008d\u008e\7U\2\2\u008e\u008f\7G\2\2\u008f"+
		"\u0090\7N\2\2\u0090\u0091\7G\2\2\u0091\u0092\7E\2\2\u0092\u0093\7V\2\2"+
		"\u0093$\3\2\2\2\u0094\u0095\7.\2\2\u0095&\3\2\2\2\u0096\u0097\7\60\2\2"+
		"\u0097(\3\2\2\2\u0098\u0099\7Y\2\2\u0099\u009a\7J\2\2\u009a\u009b\7G\2"+
		"\2\u009b\u009c\7P\2\2\u009c*\3\2\2\2\u009d\u009e\7H\2\2\u009e\u009f\7"+
		"C\2\2\u009f\u00a0\7N\2\2\u00a0\u00a1\7U\2\2\u00a1\u00a2\7G\2\2\u00a2,"+
		"\3\2\2\2\u00a3\u00a4\7@\2\2\u00a4\u00a5\7?\2\2\u00a5.\3\2\2\2\u00a6\u00a7"+
		"\7>\2\2\u00a7\60\3\2\2\2\u00a8\u00a9\7@\2\2\u00a9\62\3\2\2\2\u00aa\u00ab"+
		"\7Q\2\2\u00ab\u00ac\7T\2\2\u00ac\64\3\2\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af"+
		"\7t\2\2\u00af\66\3\2\2\2\u00b0\u00b1\7J\2\2\u00b1\u00b2\7C\2\2\u00b2\u00b3"+
		"\7X\2\2\u00b3\u00b4\7K\2\2\u00b4\u00b5\7P\2\2\u00b5\u00b6\7I\2\2\u00b6"+
		"8\3\2\2\2\u00b7\u00b8\7K\2\2\u00b8\u00b9\7P\2\2\u00b9:\3\2\2\2\u00ba\u00bb"+
		"\7k\2\2\u00bb\u00bc\7p\2\2\u00bc<\3\2\2\2\u00bd\u00be\7+\2\2\u00be>\3"+
		"\2\2\2\u00bf\u00c0\7c\2\2\u00c0\u00c1\7p\2\2\u00c1\u00c2\7f\2\2\u00c2"+
		"@\3\2\2\2\u00c3\u00c4\7V\2\2\u00c4\u00c5\7T\2\2\u00c5\u00c6\7W\2\2\u00c6"+
		"\u00c7\7G\2\2\u00c7B\3\2\2\2\u00c8\u00c9\t\2\2\2\u00c9\u00ca\3\2\2\2\u00ca"+
		"\u00cb\b\"\2\2\u00cbD\3\2\2\2\u00cc\u00ce\7/\2\2\u00cd\u00cc\3\2\2\2\u00cd"+
		"\u00ce\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00d1\t\3\2\2\u00d0\u00cf\3\2"+
		"\2\2\u00d1\u00d2\3\2\2\2\u00d2\u00d0\3\2\2\2\u00d2\u00d3\3\2\2\2\u00d3"+
		"\u00d6\3\2\2\2\u00d4\u00d5\7\60\2\2\u00d5\u00d7\t\4\2\2\u00d6\u00d4\3"+
		"\2\2\2\u00d6\u00d7\3\2\2\2\u00d7F\3\2\2\2\u00d8\u00dc\t\5\2\2\u00d9\u00db"+
		"\t\6\2\2\u00da\u00d9\3\2\2\2\u00db\u00de\3\2\2\2\u00dc\u00da\3\2\2\2\u00dc"+
		"\u00dd\3\2\2\2\u00ddH\3\2\2\2\u00de\u00dc\3\2\2\2\u00df\u00e3\7$\2\2\u00e0"+
		"\u00e2\n\7\2\2\u00e1\u00e0\3\2\2\2\u00e2\u00e5\3\2\2\2\u00e3\u00e1\3\2"+
		"\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e6\3\2\2\2\u00e5\u00e3\3\2\2\2\u00e6"+
		"\u00e7\7$\2\2\u00e7J\3\2\2\2\u00e8\u00ec\7)\2\2\u00e9\u00eb\n\b\2\2\u00ea"+
		"\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2"+
		"\2\2\u00ed\u00ef\3\2\2\2\u00ee\u00ec\3\2\2\2\u00ef\u00f0\7)\2\2\u00f0"+
		"L\3\2\2\2\t\2\u00cd\u00d2\u00d6\u00dc\u00e3\u00ec";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}