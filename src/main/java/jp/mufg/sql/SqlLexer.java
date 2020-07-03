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
		T__24=1, T__23=2, T__22=3, T__21=4, T__20=5, T__19=6, T__18=7, T__17=8, 
		T__16=9, T__15=10, T__14=11, T__13=12, T__12=13, T__11=14, T__10=15, T__9=16, 
		T__8=17, T__7=18, T__6=19, T__5=20, T__4=21, T__3=22, T__2=23, T__1=24, 
		T__0=25, WS=26, NUMBER=27, ID1=28, ID2=29, STR=30;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'LIMIT'", "'AS'", "'BY'", "'FROM'", "'WHERE'", "'!='", "'AND'", "'='", 
		"'<='", "'GROUP'", "'$'", "'('", "'SELECT'", "','", "'.'", "'>='", "'<'", 
		"'>'", "'OR'", "'or'", "'HAVING'", "'IN'", "'in'", "')'", "'and'", "WS", 
		"NUMBER", "ID1", "ID2", "STR"
	};
	public static final String[] ruleNames = {
		"T__24", "T__23", "T__22", "T__21", "T__20", "T__19", "T__18", "T__17", 
		"T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", 
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"WS", "NUMBER", "ID1", "ID2", "STR"
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
		case 25: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4 \u00c0\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t"+
		"\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3"+
		"\5\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\20\3\20\3\21\3\21\3\21\3\22\3"+
		"\22\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3"+
		"\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3"+
		"\33\3\33\3\33\3\33\3\34\5\34\u009d\n\34\3\34\6\34\u00a0\n\34\r\34\16\34"+
		"\u00a1\3\34\3\34\5\34\u00a6\n\34\3\35\3\35\7\35\u00aa\n\35\f\35\16\35"+
		"\u00ad\13\35\3\36\3\36\7\36\u00b1\n\36\f\36\16\36\u00b4\13\36\3\36\3\36"+
		"\3\37\3\37\7\37\u00ba\n\37\f\37\16\37\u00bd\13\37\3\37\3\37\2 \3\3\1\5"+
		"\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16"+
		"\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1"+
		"/\31\1\61\32\1\63\33\1\65\34\2\67\35\19\36\1;\37\1= \1\3\2\t\5\13\f\17"+
		"\17\"\"\3\62;\3\62;\6%%C\\aac|\7%&\62;B\\aac|\3$$\3))\u00c5\2\3\3\2\2"+
		"\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3"+
		"\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2"+
		"\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2"+
		"\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2"+
		"\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3"+
		"\2\2\2\3?\3\2\2\2\5E\3\2\2\2\7H\3\2\2\2\tK\3\2\2\2\13P\3\2\2\2\rV\3\2"+
		"\2\2\17Y\3\2\2\2\21]\3\2\2\2\23_\3\2\2\2\25b\3\2\2\2\27h\3\2\2\2\31j\3"+
		"\2\2\2\33l\3\2\2\2\35s\3\2\2\2\37u\3\2\2\2!w\3\2\2\2#z\3\2\2\2%|\3\2\2"+
		"\2\'~\3\2\2\2)\u0081\3\2\2\2+\u0084\3\2\2\2-\u008b\3\2\2\2/\u008e\3\2"+
		"\2\2\61\u0091\3\2\2\2\63\u0093\3\2\2\2\65\u0097\3\2\2\2\67\u009c\3\2\2"+
		"\29\u00a7\3\2\2\2;\u00ae\3\2\2\2=\u00b7\3\2\2\2?@\7N\2\2@A\7K\2\2AB\7"+
		"O\2\2BC\7K\2\2CD\7V\2\2D\4\3\2\2\2EF\7C\2\2FG\7U\2\2G\6\3\2\2\2HI\7D\2"+
		"\2IJ\7[\2\2J\b\3\2\2\2KL\7H\2\2LM\7T\2\2MN\7Q\2\2NO\7O\2\2O\n\3\2\2\2"+
		"PQ\7Y\2\2QR\7J\2\2RS\7G\2\2ST\7T\2\2TU\7G\2\2U\f\3\2\2\2VW\7#\2\2WX\7"+
		"?\2\2X\16\3\2\2\2YZ\7C\2\2Z[\7P\2\2[\\\7F\2\2\\\20\3\2\2\2]^\7?\2\2^\22"+
		"\3\2\2\2_`\7>\2\2`a\7?\2\2a\24\3\2\2\2bc\7I\2\2cd\7T\2\2de\7Q\2\2ef\7"+
		"W\2\2fg\7R\2\2g\26\3\2\2\2hi\7&\2\2i\30\3\2\2\2jk\7*\2\2k\32\3\2\2\2l"+
		"m\7U\2\2mn\7G\2\2no\7N\2\2op\7G\2\2pq\7E\2\2qr\7V\2\2r\34\3\2\2\2st\7"+
		".\2\2t\36\3\2\2\2uv\7\60\2\2v \3\2\2\2wx\7@\2\2xy\7?\2\2y\"\3\2\2\2z{"+
		"\7>\2\2{$\3\2\2\2|}\7@\2\2}&\3\2\2\2~\177\7Q\2\2\177\u0080\7T\2\2\u0080"+
		"(\3\2\2\2\u0081\u0082\7q\2\2\u0082\u0083\7t\2\2\u0083*\3\2\2\2\u0084\u0085"+
		"\7J\2\2\u0085\u0086\7C\2\2\u0086\u0087\7X\2\2\u0087\u0088\7K\2\2\u0088"+
		"\u0089\7P\2\2\u0089\u008a\7I\2\2\u008a,\3\2\2\2\u008b\u008c\7K\2\2\u008c"+
		"\u008d\7P\2\2\u008d.\3\2\2\2\u008e\u008f\7k\2\2\u008f\u0090\7p\2\2\u0090"+
		"\60\3\2\2\2\u0091\u0092\7+\2\2\u0092\62\3\2\2\2\u0093\u0094\7c\2\2\u0094"+
		"\u0095\7p\2\2\u0095\u0096\7f\2\2\u0096\64\3\2\2\2\u0097\u0098\t\2\2\2"+
		"\u0098\u0099\3\2\2\2\u0099\u009a\b\33\2\2\u009a\66\3\2\2\2\u009b\u009d"+
		"\7/\2\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e"+
		"\u00a0\t\3\2\2\u009f\u009e\3\2\2\2\u00a0\u00a1\3\2\2\2\u00a1\u009f\3\2"+
		"\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a5\3\2\2\2\u00a3\u00a4\7\60\2\2\u00a4"+
		"\u00a6\t\4\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a68\3\2\2\2"+
		"\u00a7\u00ab\t\5\2\2\u00a8\u00aa\t\6\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad"+
		"\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac:\3\2\2\2\u00ad"+
		"\u00ab\3\2\2\2\u00ae\u00b2\7$\2\2\u00af\u00b1\n\7\2\2\u00b0\u00af\3\2"+
		"\2\2\u00b1\u00b4\3\2\2\2\u00b2\u00b0\3\2\2\2\u00b2\u00b3\3\2\2\2\u00b3"+
		"\u00b5\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b5\u00b6\7$\2\2\u00b6<\3\2\2\2\u00b7"+
		"\u00bb\7)\2\2\u00b8\u00ba\n\b\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2"+
		"\2\2\u00bb\u00b9\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd"+
		"\u00bb\3\2\2\2\u00be\u00bf\7)\2\2\u00bf>\3\2\2\2\t\2\u009c\u00a1\u00a5"+
		"\u00ab\u00b2\u00bb";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}