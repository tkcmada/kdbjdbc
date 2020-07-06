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
		T__45=1, T__44=2, T__43=3, T__42=4, T__41=5, T__40=6, T__39=7, T__38=8, 
		T__37=9, T__36=10, T__35=11, T__34=12, T__33=13, T__32=14, T__31=15, T__30=16, 
		T__29=17, T__28=18, T__27=19, T__26=20, T__25=21, T__24=22, T__23=23, 
		T__22=24, T__21=25, T__20=26, T__19=27, T__18=28, T__17=29, T__16=30, 
		T__15=31, T__14=32, T__13=33, T__12=34, T__11=35, T__10=36, T__9=37, T__8=38, 
		T__7=39, T__6=40, T__5=41, T__4=42, T__3=43, T__2=44, T__1=45, T__0=46, 
		WS=47, NUMBER=48, ID1=49, ID2=50, STR=51;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'LIMIT'", "'INTEGER'", "'AS'", "'BY'", "'FROM'", "'ELSE'", "'WHERE'", 
		"'EXTRACT'", "'!='", "'END'", "'AND'", "'QUARTER'", "'='", "'THEN'", "'<='", 
		"'GROUP'", "'CASE'", "'SECOND'", "'$'", "'from'", "'('", "'*'", "'SELECT'", 
		"','", "'.'", "'WHEN'", "'MINUTE'", "'DISTINCT'", "'CAST'", "'MONTH'", 
		"'DAY'", "'FALSE'", "'HOUR'", "'>='", "'<'", "'select'", "'YEAR'", "'>'", 
		"'OR'", "'or'", "'HAVING'", "'IN'", "'in'", "')'", "'and'", "'TRUE'", 
		"WS", "NUMBER", "ID1", "ID2", "STR"
	};
	public static final String[] ruleNames = {
		"T__45", "T__44", "T__43", "T__42", "T__41", "T__40", "T__39", "T__38", 
		"T__37", "T__36", "T__35", "T__34", "T__33", "T__32", "T__31", "T__30", 
		"T__29", "T__28", "T__27", "T__26", "T__25", "T__24", "T__23", "T__22", 
		"T__21", "T__20", "T__19", "T__18", "T__17", "T__16", "T__15", "T__14", 
		"T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", 
		"T__4", "T__3", "T__2", "T__1", "T__0", "WS", "NUMBER", "ID1", "ID2", 
		"STR"
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
		case 46: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\65\u0163\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3"+
		"\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\21\3\21\3\21\3"+
		"\21\3\21\3\21\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\27\3\27\3\30\3\30\3"+
		"\30\3\30\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\33\3\33\3\33\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3"+
		"\35\3\35\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 "+
		"\3 \3 \3!\3!\3!\3!\3!\3!\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3$\3$\3%\3%\3%\3"+
		"%\3%\3%\3%\3&\3&\3&\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3*\3*\3*"+
		"\3*\3+\3+\3+\3,\3,\3,\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3/\3\60\3\60\3\60"+
		"\3\60\3\61\5\61\u0140\n\61\3\61\6\61\u0143\n\61\r\61\16\61\u0144\3\61"+
		"\3\61\5\61\u0149\n\61\3\62\3\62\7\62\u014d\n\62\f\62\16\62\u0150\13\62"+
		"\3\63\3\63\7\63\u0154\n\63\f\63\16\63\u0157\13\63\3\63\3\63\3\64\3\64"+
		"\7\64\u015d\n\64\f\64\16\64\u0160\13\64\3\64\3\64\2\65\3\3\1\5\4\1\7\5"+
		"\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17"+
		"\1\35\20\1\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61"+
		"\32\1\63\33\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1"+
		"K\'\1M(\1O)\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\2a\62\1c\63\1e\64\1g\65"+
		"\1\3\2\t\5\13\f\17\17\"\"\3\62;\3\62;\6%%C\\aac|\7%&\62;B\\aac|\3$$\3"+
		"))\u0168\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2"+
		"\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\3i\3\2\2\2\5o\3\2\2\2"+
		"\7w\3\2\2\2\tz\3\2\2\2\13}\3\2\2\2\r\u0082\3\2\2\2\17\u0087\3\2\2\2\21"+
		"\u008d\3\2\2\2\23\u0095\3\2\2\2\25\u0098\3\2\2\2\27\u009c\3\2\2\2\31\u00a0"+
		"\3\2\2\2\33\u00a8\3\2\2\2\35\u00aa\3\2\2\2\37\u00af\3\2\2\2!\u00b2\3\2"+
		"\2\2#\u00b8\3\2\2\2%\u00bd\3\2\2\2\'\u00c4\3\2\2\2)\u00c6\3\2\2\2+\u00cb"+
		"\3\2\2\2-\u00cd\3\2\2\2/\u00cf\3\2\2\2\61\u00d6\3\2\2\2\63\u00d8\3\2\2"+
		"\2\65\u00da\3\2\2\2\67\u00df\3\2\2\29\u00e6\3\2\2\2;\u00ef\3\2\2\2=\u00f4"+
		"\3\2\2\2?\u00fa\3\2\2\2A\u00fe\3\2\2\2C\u0104\3\2\2\2E\u0109\3\2\2\2G"+
		"\u010c\3\2\2\2I\u010e\3\2\2\2K\u0115\3\2\2\2M\u011a\3\2\2\2O\u011c\3\2"+
		"\2\2Q\u011f\3\2\2\2S\u0122\3\2\2\2U\u0129\3\2\2\2W\u012c\3\2\2\2Y\u012f"+
		"\3\2\2\2[\u0131\3\2\2\2]\u0135\3\2\2\2_\u013a\3\2\2\2a\u013f\3\2\2\2c"+
		"\u014a\3\2\2\2e\u0151\3\2\2\2g\u015a\3\2\2\2ij\7N\2\2jk\7K\2\2kl\7O\2"+
		"\2lm\7K\2\2mn\7V\2\2n\4\3\2\2\2op\7K\2\2pq\7P\2\2qr\7V\2\2rs\7G\2\2st"+
		"\7I\2\2tu\7G\2\2uv\7T\2\2v\6\3\2\2\2wx\7C\2\2xy\7U\2\2y\b\3\2\2\2z{\7"+
		"D\2\2{|\7[\2\2|\n\3\2\2\2}~\7H\2\2~\177\7T\2\2\177\u0080\7Q\2\2\u0080"+
		"\u0081\7O\2\2\u0081\f\3\2\2\2\u0082\u0083\7G\2\2\u0083\u0084\7N\2\2\u0084"+
		"\u0085\7U\2\2\u0085\u0086\7G\2\2\u0086\16\3\2\2\2\u0087\u0088\7Y\2\2\u0088"+
		"\u0089\7J\2\2\u0089\u008a\7G\2\2\u008a\u008b\7T\2\2\u008b\u008c\7G\2\2"+
		"\u008c\20\3\2\2\2\u008d\u008e\7G\2\2\u008e\u008f\7Z\2\2\u008f\u0090\7"+
		"V\2\2\u0090\u0091\7T\2\2\u0091\u0092\7C\2\2\u0092\u0093\7E\2\2\u0093\u0094"+
		"\7V\2\2\u0094\22\3\2\2\2\u0095\u0096\7#\2\2\u0096\u0097\7?\2\2\u0097\24"+
		"\3\2\2\2\u0098\u0099\7G\2\2\u0099\u009a\7P\2\2\u009a\u009b\7F\2\2\u009b"+
		"\26\3\2\2\2\u009c\u009d\7C\2\2\u009d\u009e\7P\2\2\u009e\u009f\7F\2\2\u009f"+
		"\30\3\2\2\2\u00a0\u00a1\7S\2\2\u00a1\u00a2\7W\2\2\u00a2\u00a3\7C\2\2\u00a3"+
		"\u00a4\7T\2\2\u00a4\u00a5\7V\2\2\u00a5\u00a6\7G\2\2\u00a6\u00a7\7T\2\2"+
		"\u00a7\32\3\2\2\2\u00a8\u00a9\7?\2\2\u00a9\34\3\2\2\2\u00aa\u00ab\7V\2"+
		"\2\u00ab\u00ac\7J\2\2\u00ac\u00ad\7G\2\2\u00ad\u00ae\7P\2\2\u00ae\36\3"+
		"\2\2\2\u00af\u00b0\7>\2\2\u00b0\u00b1\7?\2\2\u00b1 \3\2\2\2\u00b2\u00b3"+
		"\7I\2\2\u00b3\u00b4\7T\2\2\u00b4\u00b5\7Q\2\2\u00b5\u00b6\7W\2\2\u00b6"+
		"\u00b7\7R\2\2\u00b7\"\3\2\2\2\u00b8\u00b9\7E\2\2\u00b9\u00ba\7C\2\2\u00ba"+
		"\u00bb\7U\2\2\u00bb\u00bc\7G\2\2\u00bc$\3\2\2\2\u00bd\u00be\7U\2\2\u00be"+
		"\u00bf\7G\2\2\u00bf\u00c0\7E\2\2\u00c0\u00c1\7Q\2\2\u00c1\u00c2\7P\2\2"+
		"\u00c2\u00c3\7F\2\2\u00c3&\3\2\2\2\u00c4\u00c5\7&\2\2\u00c5(\3\2\2\2\u00c6"+
		"\u00c7\7h\2\2\u00c7\u00c8\7t\2\2\u00c8\u00c9\7q\2\2\u00c9\u00ca\7o\2\2"+
		"\u00ca*\3\2\2\2\u00cb\u00cc\7*\2\2\u00cc,\3\2\2\2\u00cd\u00ce\7,\2\2\u00ce"+
		".\3\2\2\2\u00cf\u00d0\7U\2\2\u00d0\u00d1\7G\2\2\u00d1\u00d2\7N\2\2\u00d2"+
		"\u00d3\7G\2\2\u00d3\u00d4\7E\2\2\u00d4\u00d5\7V\2\2\u00d5\60\3\2\2\2\u00d6"+
		"\u00d7\7.\2\2\u00d7\62\3\2\2\2\u00d8\u00d9\7\60\2\2\u00d9\64\3\2\2\2\u00da"+
		"\u00db\7Y\2\2\u00db\u00dc\7J\2\2\u00dc\u00dd\7G\2\2\u00dd\u00de\7P\2\2"+
		"\u00de\66\3\2\2\2\u00df\u00e0\7O\2\2\u00e0\u00e1\7K\2\2\u00e1\u00e2\7"+
		"P\2\2\u00e2\u00e3\7W\2\2\u00e3\u00e4\7V\2\2\u00e4\u00e5\7G\2\2\u00e58"+
		"\3\2\2\2\u00e6\u00e7\7F\2\2\u00e7\u00e8\7K\2\2\u00e8\u00e9\7U\2\2\u00e9"+
		"\u00ea\7V\2\2\u00ea\u00eb\7K\2\2\u00eb\u00ec\7P\2\2\u00ec\u00ed\7E\2\2"+
		"\u00ed\u00ee\7V\2\2\u00ee:\3\2\2\2\u00ef\u00f0\7E\2\2\u00f0\u00f1\7C\2"+
		"\2\u00f1\u00f2\7U\2\2\u00f2\u00f3\7V\2\2\u00f3<\3\2\2\2\u00f4\u00f5\7"+
		"O\2\2\u00f5\u00f6\7Q\2\2\u00f6\u00f7\7P\2\2\u00f7\u00f8\7V\2\2\u00f8\u00f9"+
		"\7J\2\2\u00f9>\3\2\2\2\u00fa\u00fb\7F\2\2\u00fb\u00fc\7C\2\2\u00fc\u00fd"+
		"\7[\2\2\u00fd@\3\2\2\2\u00fe\u00ff\7H\2\2\u00ff\u0100\7C\2\2\u0100\u0101"+
		"\7N\2\2\u0101\u0102\7U\2\2\u0102\u0103\7G\2\2\u0103B\3\2\2\2\u0104\u0105"+
		"\7J\2\2\u0105\u0106\7Q\2\2\u0106\u0107\7W\2\2\u0107\u0108\7T\2\2\u0108"+
		"D\3\2\2\2\u0109\u010a\7@\2\2\u010a\u010b\7?\2\2\u010bF\3\2\2\2\u010c\u010d"+
		"\7>\2\2\u010dH\3\2\2\2\u010e\u010f\7u\2\2\u010f\u0110\7g\2\2\u0110\u0111"+
		"\7n\2\2\u0111\u0112\7g\2\2\u0112\u0113\7e\2\2\u0113\u0114\7v\2\2\u0114"+
		"J\3\2\2\2\u0115\u0116\7[\2\2\u0116\u0117\7G\2\2\u0117\u0118\7C\2\2\u0118"+
		"\u0119\7T\2\2\u0119L\3\2\2\2\u011a\u011b\7@\2\2\u011bN\3\2\2\2\u011c\u011d"+
		"\7Q\2\2\u011d\u011e\7T\2\2\u011eP\3\2\2\2\u011f\u0120\7q\2\2\u0120\u0121"+
		"\7t\2\2\u0121R\3\2\2\2\u0122\u0123\7J\2\2\u0123\u0124\7C\2\2\u0124\u0125"+
		"\7X\2\2\u0125\u0126\7K\2\2\u0126\u0127\7P\2\2\u0127\u0128\7I\2\2\u0128"+
		"T\3\2\2\2\u0129\u012a\7K\2\2\u012a\u012b\7P\2\2\u012bV\3\2\2\2\u012c\u012d"+
		"\7k\2\2\u012d\u012e\7p\2\2\u012eX\3\2\2\2\u012f\u0130\7+\2\2\u0130Z\3"+
		"\2\2\2\u0131\u0132\7c\2\2\u0132\u0133\7p\2\2\u0133\u0134\7f\2\2\u0134"+
		"\\\3\2\2\2\u0135\u0136\7V\2\2\u0136\u0137\7T\2\2\u0137\u0138\7W\2\2\u0138"+
		"\u0139\7G\2\2\u0139^\3\2\2\2\u013a\u013b\t\2\2\2\u013b\u013c\3\2\2\2\u013c"+
		"\u013d\b\60\2\2\u013d`\3\2\2\2\u013e\u0140\7/\2\2\u013f\u013e\3\2\2\2"+
		"\u013f\u0140\3\2\2\2\u0140\u0142\3\2\2\2\u0141\u0143\t\3\2\2\u0142\u0141"+
		"\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0142\3\2\2\2\u0144\u0145\3\2\2\2\u0145"+
		"\u0148\3\2\2\2\u0146\u0147\7\60\2\2\u0147\u0149\t\4\2\2\u0148\u0146\3"+
		"\2\2\2\u0148\u0149\3\2\2\2\u0149b\3\2\2\2\u014a\u014e\t\5\2\2\u014b\u014d"+
		"\t\6\2\2\u014c\u014b\3\2\2\2\u014d\u0150\3\2\2\2\u014e\u014c\3\2\2\2\u014e"+
		"\u014f\3\2\2\2\u014fd\3\2\2\2\u0150\u014e\3\2\2\2\u0151\u0155\7$\2\2\u0152"+
		"\u0154\n\7\2\2\u0153\u0152\3\2\2\2\u0154\u0157\3\2\2\2\u0155\u0153\3\2"+
		"\2\2\u0155\u0156\3\2\2\2\u0156\u0158\3\2\2\2\u0157\u0155\3\2\2\2\u0158"+
		"\u0159\7$\2\2\u0159f\3\2\2\2\u015a\u015e\7)\2\2\u015b\u015d\n\b\2\2\u015c"+
		"\u015b\3\2\2\2\u015d\u0160\3\2\2\2\u015e\u015c\3\2\2\2\u015e\u015f\3\2"+
		"\2\2\u015f\u0161\3\2\2\2\u0160\u015e\3\2\2\2\u0161\u0162\7)\2\2\u0162"+
		"h\3\2\2\2\t\2\u013f\u0144\u0148\u014e\u0155\u015e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}