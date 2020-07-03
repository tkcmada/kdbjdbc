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
		T__41=1, T__40=2, T__39=3, T__38=4, T__37=5, T__36=6, T__35=7, T__34=8, 
		T__33=9, T__32=10, T__31=11, T__30=12, T__29=13, T__28=14, T__27=15, T__26=16, 
		T__25=17, T__24=18, T__23=19, T__22=20, T__21=21, T__20=22, T__19=23, 
		T__18=24, T__17=25, T__16=26, T__15=27, T__14=28, T__13=29, T__12=30, 
		T__11=31, T__10=32, T__9=33, T__8=34, T__7=35, T__6=36, T__5=37, T__4=38, 
		T__3=39, T__2=40, T__1=41, T__0=42, WS=43, NUMBER=44, ID1=45, ID2=46, 
		STR=47;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'LIMIT'", "'INTEGER'", "'AS'", "'BY'", "'FROM'", "'ELSE'", "'WHERE'", 
		"'EXTRACT'", "'!='", "'END'", "'AND'", "'QUARTER'", "'='", "'THEN'", "'<='", 
		"'GROUP'", "'CASE'", "'SECOND'", "'$'", "'('", "'SELECT'", "','", "'.'", 
		"'WHEN'", "'MINUTE'", "'CAST'", "'MONTH'", "'DAY'", "'FALSE'", "'HOUR'", 
		"'>='", "'<'", "'YEAR'", "'>'", "'OR'", "'or'", "'HAVING'", "'IN'", "'in'", 
		"')'", "'and'", "'TRUE'", "WS", "NUMBER", "ID1", "ID2", "STR"
	};
	public static final String[] ruleNames = {
		"T__41", "T__40", "T__39", "T__38", "T__37", "T__36", "T__35", "T__34", 
		"T__33", "T__32", "T__31", "T__30", "T__29", "T__28", "T__27", "T__26", 
		"T__25", "T__24", "T__23", "T__22", "T__21", "T__20", "T__19", "T__18", 
		"T__17", "T__16", "T__15", "T__14", "T__13", "T__12", "T__11", "T__10", 
		"T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", 
		"T__0", "WS", "NUMBER", "ID1", "ID2", "STR"
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
		case 42: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\61\u0144\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6"+
		"\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3"+
		"\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\32\3"+
		"\32\3\32\3\32\3\32\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3"+
		"\37\3\37\3\37\3\37\3 \3 \3 \3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3$\3$\3$\3"+
		"%\3%\3%\3&\3&\3&\3&\3&\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3*\3*\3*\3*\3"+
		"+\3+\3+\3+\3+\3,\3,\3,\3,\3-\5-\u0121\n-\3-\6-\u0124\n-\r-\16-\u0125\3"+
		"-\3-\5-\u012a\n-\3.\3.\7.\u012e\n.\f.\16.\u0131\13.\3/\3/\7/\u0135\n/"+
		"\f/\16/\u0138\13/\3/\3/\3\60\3\60\7\60\u013e\n\60\f\60\16\60\u0141\13"+
		"\60\3\60\3\60\2\61\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1"+
		"\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1\37\21\1!\22\1#\23\1%\24"+
		"\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33\1\65\34\1\67\35\19\36"+
		"\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O)\1Q*\1S+\1U,\1W-\2Y.\1"+
		"[/\1]\60\1_\61\1\3\2\t\5\13\f\17\17\"\"\3\62;\3\62;\6%%C\\aac|\7%&\62"+
		";B\\aac|\3$$\3))\u0149\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2"+
		"\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25"+
		"\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2"+
		"\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2"+
		"\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3"+
		"\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2"+
		"\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2"+
		"Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3"+
		"\2\2\2\2_\3\2\2\2\3a\3\2\2\2\5g\3\2\2\2\7o\3\2\2\2\tr\3\2\2\2\13u\3\2"+
		"\2\2\rz\3\2\2\2\17\177\3\2\2\2\21\u0085\3\2\2\2\23\u008d\3\2\2\2\25\u0090"+
		"\3\2\2\2\27\u0094\3\2\2\2\31\u0098\3\2\2\2\33\u00a0\3\2\2\2\35\u00a2\3"+
		"\2\2\2\37\u00a7\3\2\2\2!\u00aa\3\2\2\2#\u00b0\3\2\2\2%\u00b5\3\2\2\2\'"+
		"\u00bc\3\2\2\2)\u00be\3\2\2\2+\u00c0\3\2\2\2-\u00c7\3\2\2\2/\u00c9\3\2"+
		"\2\2\61\u00cb\3\2\2\2\63\u00d0\3\2\2\2\65\u00d7\3\2\2\2\67\u00dc\3\2\2"+
		"\29\u00e2\3\2\2\2;\u00e6\3\2\2\2=\u00ec\3\2\2\2?\u00f1\3\2\2\2A\u00f4"+
		"\3\2\2\2C\u00f6\3\2\2\2E\u00fb\3\2\2\2G\u00fd\3\2\2\2I\u0100\3\2\2\2K"+
		"\u0103\3\2\2\2M\u010a\3\2\2\2O\u010d\3\2\2\2Q\u0110\3\2\2\2S\u0112\3\2"+
		"\2\2U\u0116\3\2\2\2W\u011b\3\2\2\2Y\u0120\3\2\2\2[\u012b\3\2\2\2]\u0132"+
		"\3\2\2\2_\u013b\3\2\2\2ab\7N\2\2bc\7K\2\2cd\7O\2\2de\7K\2\2ef\7V\2\2f"+
		"\4\3\2\2\2gh\7K\2\2hi\7P\2\2ij\7V\2\2jk\7G\2\2kl\7I\2\2lm\7G\2\2mn\7T"+
		"\2\2n\6\3\2\2\2op\7C\2\2pq\7U\2\2q\b\3\2\2\2rs\7D\2\2st\7[\2\2t\n\3\2"+
		"\2\2uv\7H\2\2vw\7T\2\2wx\7Q\2\2xy\7O\2\2y\f\3\2\2\2z{\7G\2\2{|\7N\2\2"+
		"|}\7U\2\2}~\7G\2\2~\16\3\2\2\2\177\u0080\7Y\2\2\u0080\u0081\7J\2\2\u0081"+
		"\u0082\7G\2\2\u0082\u0083\7T\2\2\u0083\u0084\7G\2\2\u0084\20\3\2\2\2\u0085"+
		"\u0086\7G\2\2\u0086\u0087\7Z\2\2\u0087\u0088\7V\2\2\u0088\u0089\7T\2\2"+
		"\u0089\u008a\7C\2\2\u008a\u008b\7E\2\2\u008b\u008c\7V\2\2\u008c\22\3\2"+
		"\2\2\u008d\u008e\7#\2\2\u008e\u008f\7?\2\2\u008f\24\3\2\2\2\u0090\u0091"+
		"\7G\2\2\u0091\u0092\7P\2\2\u0092\u0093\7F\2\2\u0093\26\3\2\2\2\u0094\u0095"+
		"\7C\2\2\u0095\u0096\7P\2\2\u0096\u0097\7F\2\2\u0097\30\3\2\2\2\u0098\u0099"+
		"\7S\2\2\u0099\u009a\7W\2\2\u009a\u009b\7C\2\2\u009b\u009c\7T\2\2\u009c"+
		"\u009d\7V\2\2\u009d\u009e\7G\2\2\u009e\u009f\7T\2\2\u009f\32\3\2\2\2\u00a0"+
		"\u00a1\7?\2\2\u00a1\34\3\2\2\2\u00a2\u00a3\7V\2\2\u00a3\u00a4\7J\2\2\u00a4"+
		"\u00a5\7G\2\2\u00a5\u00a6\7P\2\2\u00a6\36\3\2\2\2\u00a7\u00a8\7>\2\2\u00a8"+
		"\u00a9\7?\2\2\u00a9 \3\2\2\2\u00aa\u00ab\7I\2\2\u00ab\u00ac\7T\2\2\u00ac"+
		"\u00ad\7Q\2\2\u00ad\u00ae\7W\2\2\u00ae\u00af\7R\2\2\u00af\"\3\2\2\2\u00b0"+
		"\u00b1\7E\2\2\u00b1\u00b2\7C\2\2\u00b2\u00b3\7U\2\2\u00b3\u00b4\7G\2\2"+
		"\u00b4$\3\2\2\2\u00b5\u00b6\7U\2\2\u00b6\u00b7\7G\2\2\u00b7\u00b8\7E\2"+
		"\2\u00b8\u00b9\7Q\2\2\u00b9\u00ba\7P\2\2\u00ba\u00bb\7F\2\2\u00bb&\3\2"+
		"\2\2\u00bc\u00bd\7&\2\2\u00bd(\3\2\2\2\u00be\u00bf\7*\2\2\u00bf*\3\2\2"+
		"\2\u00c0\u00c1\7U\2\2\u00c1\u00c2\7G\2\2\u00c2\u00c3\7N\2\2\u00c3\u00c4"+
		"\7G\2\2\u00c4\u00c5\7E\2\2\u00c5\u00c6\7V\2\2\u00c6,\3\2\2\2\u00c7\u00c8"+
		"\7.\2\2\u00c8.\3\2\2\2\u00c9\u00ca\7\60\2\2\u00ca\60\3\2\2\2\u00cb\u00cc"+
		"\7Y\2\2\u00cc\u00cd\7J\2\2\u00cd\u00ce\7G\2\2\u00ce\u00cf\7P\2\2\u00cf"+
		"\62\3\2\2\2\u00d0\u00d1\7O\2\2\u00d1\u00d2\7K\2\2\u00d2\u00d3\7P\2\2\u00d3"+
		"\u00d4\7W\2\2\u00d4\u00d5\7V\2\2\u00d5\u00d6\7G\2\2\u00d6\64\3\2\2\2\u00d7"+
		"\u00d8\7E\2\2\u00d8\u00d9\7C\2\2\u00d9\u00da\7U\2\2\u00da\u00db\7V\2\2"+
		"\u00db\66\3\2\2\2\u00dc\u00dd\7O\2\2\u00dd\u00de\7Q\2\2\u00de\u00df\7"+
		"P\2\2\u00df\u00e0\7V\2\2\u00e0\u00e1\7J\2\2\u00e18\3\2\2\2\u00e2\u00e3"+
		"\7F\2\2\u00e3\u00e4\7C\2\2\u00e4\u00e5\7[\2\2\u00e5:\3\2\2\2\u00e6\u00e7"+
		"\7H\2\2\u00e7\u00e8\7C\2\2\u00e8\u00e9\7N\2\2\u00e9\u00ea\7U\2\2\u00ea"+
		"\u00eb\7G\2\2\u00eb<\3\2\2\2\u00ec\u00ed\7J\2\2\u00ed\u00ee\7Q\2\2\u00ee"+
		"\u00ef\7W\2\2\u00ef\u00f0\7T\2\2\u00f0>\3\2\2\2\u00f1\u00f2\7@\2\2\u00f2"+
		"\u00f3\7?\2\2\u00f3@\3\2\2\2\u00f4\u00f5\7>\2\2\u00f5B\3\2\2\2\u00f6\u00f7"+
		"\7[\2\2\u00f7\u00f8\7G\2\2\u00f8\u00f9\7C\2\2\u00f9\u00fa\7T\2\2\u00fa"+
		"D\3\2\2\2\u00fb\u00fc\7@\2\2\u00fcF\3\2\2\2\u00fd\u00fe\7Q\2\2\u00fe\u00ff"+
		"\7T\2\2\u00ffH\3\2\2\2\u0100\u0101\7q\2\2\u0101\u0102\7t\2\2\u0102J\3"+
		"\2\2\2\u0103\u0104\7J\2\2\u0104\u0105\7C\2\2\u0105\u0106\7X\2\2\u0106"+
		"\u0107\7K\2\2\u0107\u0108\7P\2\2\u0108\u0109\7I\2\2\u0109L\3\2\2\2\u010a"+
		"\u010b\7K\2\2\u010b\u010c\7P\2\2\u010cN\3\2\2\2\u010d\u010e\7k\2\2\u010e"+
		"\u010f\7p\2\2\u010fP\3\2\2\2\u0110\u0111\7+\2\2\u0111R\3\2\2\2\u0112\u0113"+
		"\7c\2\2\u0113\u0114\7p\2\2\u0114\u0115\7f\2\2\u0115T\3\2\2\2\u0116\u0117"+
		"\7V\2\2\u0117\u0118\7T\2\2\u0118\u0119\7W\2\2\u0119\u011a\7G\2\2\u011a"+
		"V\3\2\2\2\u011b\u011c\t\2\2\2\u011c\u011d\3\2\2\2\u011d\u011e\b,\2\2\u011e"+
		"X\3\2\2\2\u011f\u0121\7/\2\2\u0120\u011f\3\2\2\2\u0120\u0121\3\2\2\2\u0121"+
		"\u0123\3\2\2\2\u0122\u0124\t\3\2\2\u0123\u0122\3\2\2\2\u0124\u0125\3\2"+
		"\2\2\u0125\u0123\3\2\2\2\u0125\u0126\3\2\2\2\u0126\u0129\3\2\2\2\u0127"+
		"\u0128\7\60\2\2\u0128\u012a\t\4\2\2\u0129\u0127\3\2\2\2\u0129\u012a\3"+
		"\2\2\2\u012aZ\3\2\2\2\u012b\u012f\t\5\2\2\u012c\u012e\t\6\2\2\u012d\u012c"+
		"\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2\2\2\u012f\u0130\3\2\2\2\u0130"+
		"\\\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0136\7$\2\2\u0133\u0135\n\7\2\2"+
		"\u0134\u0133\3\2\2\2\u0135\u0138\3\2\2\2\u0136\u0134\3\2\2\2\u0136\u0137"+
		"\3\2\2\2\u0137\u0139\3\2\2\2\u0138\u0136\3\2\2\2\u0139\u013a\7$\2\2\u013a"+
		"^\3\2\2\2\u013b\u013f\7)\2\2\u013c\u013e\n\b\2\2\u013d\u013c\3\2\2\2\u013e"+
		"\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140\3\2\2\2\u0140\u0142\3\2"+
		"\2\2\u0141\u013f\3\2\2\2\u0142\u0143\7)\2\2\u0143`\3\2\2\2\t\2\u0120\u0125"+
		"\u0129\u012f\u0136\u013f";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}