// Generated from jp/mufg/sql/Sql.g4 by ANTLR 4.0
package jp.mufg.sql;
 
import jp.mufg.kdbjdbc.SqlExprs.*;
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
		T__47=1, T__46=2, T__45=3, T__44=4, T__43=5, T__42=6, T__41=7, T__40=8, 
		T__39=9, T__38=10, T__37=11, T__36=12, T__35=13, T__34=14, T__33=15, T__32=16, 
		T__31=17, T__30=18, T__29=19, T__28=20, T__27=21, T__26=22, T__25=23, 
		T__24=24, T__23=25, T__22=26, T__21=27, T__20=28, T__19=29, T__18=30, 
		T__17=31, T__16=32, T__15=33, T__14=34, T__13=35, T__12=36, T__11=37, 
		T__10=38, T__9=39, T__8=40, T__7=41, T__6=42, T__5=43, T__4=44, T__3=45, 
		T__2=46, T__1=47, T__0=48, WS=49, NUMBER_LITERAL=50, ID1=51, ID2=52, STR=53;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'LIMIT'", "'INTEGER'", "'AS'", "'BY'", "'FROM'", "'ELSE'", "'WHERE'", 
		"'EXTRACT'", "'!='", "'END'", "'AND'", "'QUARTER'", "'='", "'THEN'", "'<='", 
		"'GROUP'", "'CASE'", "'SECOND'", "'$'", "'from'", "'('", "'*'", "'SELECT'", 
		"'OFFSET'", "','", "'.'", "'WHEN'", "'MINUTE'", "'DISTINCT'", "'CAST'", 
		"'MONTH'", "'DATE'", "'DAY'", "'FALSE'", "'HOUR'", "'>='", "'<'", "'select'", 
		"'YEAR'", "'>'", "'OR'", "'or'", "'HAVING'", "'IN'", "'in'", "')'", "'and'", 
		"'TRUE'", "WS", "NUMBER_LITERAL", "ID1", "ID2", "STR"
	};
	public static final String[] ruleNames = {
		"T__47", "T__46", "T__45", "T__44", "T__43", "T__42", "T__41", "T__40", 
		"T__39", "T__38", "T__37", "T__36", "T__35", "T__34", "T__33", "T__32", 
		"T__31", "T__30", "T__29", "T__28", "T__27", "T__26", "T__25", "T__24", 
		"T__23", "T__22", "T__21", "T__20", "T__19", "T__18", "T__17", "T__16", 
		"T__15", "T__14", "T__13", "T__12", "T__11", "T__10", "T__9", "T__8", 
		"T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "WS", 
		"NUMBER_LITERAL", "ID1", "ID2", "STR", "DQUOTA_STRING", "SQUOTA_STRING"
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
		case 48: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\67\u018d\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b"+
		"\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20"+
		"\t\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27"+
		"\t\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36"+
		"\t\36\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4"+
		"(\t(\4)\t)\4*\t*\4+\t+\4,\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62"+
		"\t\62\4\63\t\63\4\64\t\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\f\3\f\3"+
		"\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22\3\22\3\22\3"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\3"+
		"\31\3\31\3\31\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3"+
		"\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3\""+
		"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3$\3$\3$\3$\3$\3%\3%\3%\3&\3&\3\'\3\'\3"+
		"\'\3\'\3\'\3\'\3\'\3(\3(\3(\3(\3(\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3,"+
		"\3,\3,\3,\3-\3-\3-\3.\3.\3.\3/\3/\3\60\3\60\3\60\3\60\3\61\3\61\3\61\3"+
		"\61\3\61\3\62\6\62\u0150\n\62\r\62\16\62\u0151\3\62\3\62\3\63\5\63\u0157"+
		"\n\63\3\63\6\63\u015a\n\63\r\63\16\63\u015b\3\63\3\63\5\63\u0160\n\63"+
		"\3\64\3\64\7\64\u0164\n\64\f\64\16\64\u0167\13\64\3\65\3\65\7\65\u016b"+
		"\n\65\f\65\16\65\u016e\13\65\3\65\3\65\3\66\3\66\3\67\3\67\3\67\3\67\3"+
		"\67\3\67\7\67\u017a\n\67\f\67\16\67\u017d\13\67\3\67\3\67\38\38\38\38"+
		"\38\38\78\u0187\n8\f8\168\u018a\138\38\38\29\3\3\1\5\4\1\7\5\1\t\6\1\13"+
		"\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\1\33\17\1\35\20\1"+
		"\37\21\1!\22\1#\23\1%\24\1\'\25\1)\26\1+\27\1-\30\1/\31\1\61\32\1\63\33"+
		"\1\65\34\1\67\35\19\36\1;\37\1= \1?!\1A\"\1C#\1E$\1G%\1I&\1K\'\1M(\1O"+
		")\1Q*\1S+\1U,\1W-\1Y.\1[/\1]\60\1_\61\1a\62\1c\63\2e\64\1g\65\1i\66\1"+
		"k\67\1m\2\1o\2\1\3\2\n\5\13\f\17\17\"\"\3\62;\3\62;\6%%C\\aac|\7%&\62"+
		";B\\aac|\3$$\4$$^^\4))^^\u0196\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t"+
		"\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2"+
		"\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2"+
		"+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2"+
		"\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2"+
		"C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3"+
		"\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2"+
		"\2\2]\3\2\2\2\2_\3\2\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2"+
		"i\3\2\2\2\2k\3\2\2\2\3q\3\2\2\2\5w\3\2\2\2\7\177\3\2\2\2\t\u0082\3\2\2"+
		"\2\13\u0085\3\2\2\2\r\u008a\3\2\2\2\17\u008f\3\2\2\2\21\u0095\3\2\2\2"+
		"\23\u009d\3\2\2\2\25\u00a0\3\2\2\2\27\u00a4\3\2\2\2\31\u00a8\3\2\2\2\33"+
		"\u00b0\3\2\2\2\35\u00b2\3\2\2\2\37\u00b7\3\2\2\2!\u00ba\3\2\2\2#\u00c0"+
		"\3\2\2\2%\u00c5\3\2\2\2\'\u00cc\3\2\2\2)\u00ce\3\2\2\2+\u00d3\3\2\2\2"+
		"-\u00d5\3\2\2\2/\u00d7\3\2\2\2\61\u00de\3\2\2\2\63\u00e5\3\2\2\2\65\u00e7"+
		"\3\2\2\2\67\u00e9\3\2\2\29\u00ee\3\2\2\2;\u00f5\3\2\2\2=\u00fe\3\2\2\2"+
		"?\u0103\3\2\2\2A\u0109\3\2\2\2C\u010e\3\2\2\2E\u0112\3\2\2\2G\u0118\3"+
		"\2\2\2I\u011d\3\2\2\2K\u0120\3\2\2\2M\u0122\3\2\2\2O\u0129\3\2\2\2Q\u012e"+
		"\3\2\2\2S\u0130\3\2\2\2U\u0133\3\2\2\2W\u0136\3\2\2\2Y\u013d\3\2\2\2["+
		"\u0140\3\2\2\2]\u0143\3\2\2\2_\u0145\3\2\2\2a\u0149\3\2\2\2c\u014f\3\2"+
		"\2\2e\u0156\3\2\2\2g\u0161\3\2\2\2i\u0168\3\2\2\2k\u0171\3\2\2\2m\u0173"+
		"\3\2\2\2o\u0180\3\2\2\2qr\7N\2\2rs\7K\2\2st\7O\2\2tu\7K\2\2uv\7V\2\2v"+
		"\4\3\2\2\2wx\7K\2\2xy\7P\2\2yz\7V\2\2z{\7G\2\2{|\7I\2\2|}\7G\2\2}~\7T"+
		"\2\2~\6\3\2\2\2\177\u0080\7C\2\2\u0080\u0081\7U\2\2\u0081\b\3\2\2\2\u0082"+
		"\u0083\7D\2\2\u0083\u0084\7[\2\2\u0084\n\3\2\2\2\u0085\u0086\7H\2\2\u0086"+
		"\u0087\7T\2\2\u0087\u0088\7Q\2\2\u0088\u0089\7O\2\2\u0089\f\3\2\2\2\u008a"+
		"\u008b\7G\2\2\u008b\u008c\7N\2\2\u008c\u008d\7U\2\2\u008d\u008e\7G\2\2"+
		"\u008e\16\3\2\2\2\u008f\u0090\7Y\2\2\u0090\u0091\7J\2\2\u0091\u0092\7"+
		"G\2\2\u0092\u0093\7T\2\2\u0093\u0094\7G\2\2\u0094\20\3\2\2\2\u0095\u0096"+
		"\7G\2\2\u0096\u0097\7Z\2\2\u0097\u0098\7V\2\2\u0098\u0099\7T\2\2\u0099"+
		"\u009a\7C\2\2\u009a\u009b\7E\2\2\u009b\u009c\7V\2\2\u009c\22\3\2\2\2\u009d"+
		"\u009e\7#\2\2\u009e\u009f\7?\2\2\u009f\24\3\2\2\2\u00a0\u00a1\7G\2\2\u00a1"+
		"\u00a2\7P\2\2\u00a2\u00a3\7F\2\2\u00a3\26\3\2\2\2\u00a4\u00a5\7C\2\2\u00a5"+
		"\u00a6\7P\2\2\u00a6\u00a7\7F\2\2\u00a7\30\3\2\2\2\u00a8\u00a9\7S\2\2\u00a9"+
		"\u00aa\7W\2\2\u00aa\u00ab\7C\2\2\u00ab\u00ac\7T\2\2\u00ac\u00ad\7V\2\2"+
		"\u00ad\u00ae\7G\2\2\u00ae\u00af\7T\2\2\u00af\32\3\2\2\2\u00b0\u00b1\7"+
		"?\2\2\u00b1\34\3\2\2\2\u00b2\u00b3\7V\2\2\u00b3\u00b4\7J\2\2\u00b4\u00b5"+
		"\7G\2\2\u00b5\u00b6\7P\2\2\u00b6\36\3\2\2\2\u00b7\u00b8\7>\2\2\u00b8\u00b9"+
		"\7?\2\2\u00b9 \3\2\2\2\u00ba\u00bb\7I\2\2\u00bb\u00bc\7T\2\2\u00bc\u00bd"+
		"\7Q\2\2\u00bd\u00be\7W\2\2\u00be\u00bf\7R\2\2\u00bf\"\3\2\2\2\u00c0\u00c1"+
		"\7E\2\2\u00c1\u00c2\7C\2\2\u00c2\u00c3\7U\2\2\u00c3\u00c4\7G\2\2\u00c4"+
		"$\3\2\2\2\u00c5\u00c6\7U\2\2\u00c6\u00c7\7G\2\2\u00c7\u00c8\7E\2\2\u00c8"+
		"\u00c9\7Q\2\2\u00c9\u00ca\7P\2\2\u00ca\u00cb\7F\2\2\u00cb&\3\2\2\2\u00cc"+
		"\u00cd\7&\2\2\u00cd(\3\2\2\2\u00ce\u00cf\7h\2\2\u00cf\u00d0\7t\2\2\u00d0"+
		"\u00d1\7q\2\2\u00d1\u00d2\7o\2\2\u00d2*\3\2\2\2\u00d3\u00d4\7*\2\2\u00d4"+
		",\3\2\2\2\u00d5\u00d6\7,\2\2\u00d6.\3\2\2\2\u00d7\u00d8\7U\2\2\u00d8\u00d9"+
		"\7G\2\2\u00d9\u00da\7N\2\2\u00da\u00db\7G\2\2\u00db\u00dc\7E\2\2\u00dc"+
		"\u00dd\7V\2\2\u00dd\60\3\2\2\2\u00de\u00df\7Q\2\2\u00df\u00e0\7H\2\2\u00e0"+
		"\u00e1\7H\2\2\u00e1\u00e2\7U\2\2\u00e2\u00e3\7G\2\2\u00e3\u00e4\7V\2\2"+
		"\u00e4\62\3\2\2\2\u00e5\u00e6\7.\2\2\u00e6\64\3\2\2\2\u00e7\u00e8\7\60"+
		"\2\2\u00e8\66\3\2\2\2\u00e9\u00ea\7Y\2\2\u00ea\u00eb\7J\2\2\u00eb\u00ec"+
		"\7G\2\2\u00ec\u00ed\7P\2\2\u00ed8\3\2\2\2\u00ee\u00ef\7O\2\2\u00ef\u00f0"+
		"\7K\2\2\u00f0\u00f1\7P\2\2\u00f1\u00f2\7W\2\2\u00f2\u00f3\7V\2\2\u00f3"+
		"\u00f4\7G\2\2\u00f4:\3\2\2\2\u00f5\u00f6\7F\2\2\u00f6\u00f7\7K\2\2\u00f7"+
		"\u00f8\7U\2\2\u00f8\u00f9\7V\2\2\u00f9\u00fa\7K\2\2\u00fa\u00fb\7P\2\2"+
		"\u00fb\u00fc\7E\2\2\u00fc\u00fd\7V\2\2\u00fd<\3\2\2\2\u00fe\u00ff\7E\2"+
		"\2\u00ff\u0100\7C\2\2\u0100\u0101\7U\2\2\u0101\u0102\7V\2\2\u0102>\3\2"+
		"\2\2\u0103\u0104\7O\2\2\u0104\u0105\7Q\2\2\u0105\u0106\7P\2\2\u0106\u0107"+
		"\7V\2\2\u0107\u0108\7J\2\2\u0108@\3\2\2\2\u0109\u010a\7F\2\2\u010a\u010b"+
		"\7C\2\2\u010b\u010c\7V\2\2\u010c\u010d\7G\2\2\u010dB\3\2\2\2\u010e\u010f"+
		"\7F\2\2\u010f\u0110\7C\2\2\u0110\u0111\7[\2\2\u0111D\3\2\2\2\u0112\u0113"+
		"\7H\2\2\u0113\u0114\7C\2\2\u0114\u0115\7N\2\2\u0115\u0116\7U\2\2\u0116"+
		"\u0117\7G\2\2\u0117F\3\2\2\2\u0118\u0119\7J\2\2\u0119\u011a\7Q\2\2\u011a"+
		"\u011b\7W\2\2\u011b\u011c\7T\2\2\u011cH\3\2\2\2\u011d\u011e\7@\2\2\u011e"+
		"\u011f\7?\2\2\u011fJ\3\2\2\2\u0120\u0121\7>\2\2\u0121L\3\2\2\2\u0122\u0123"+
		"\7u\2\2\u0123\u0124\7g\2\2\u0124\u0125\7n\2\2\u0125\u0126\7g\2\2\u0126"+
		"\u0127\7e\2\2\u0127\u0128\7v\2\2\u0128N\3\2\2\2\u0129\u012a\7[\2\2\u012a"+
		"\u012b\7G\2\2\u012b\u012c\7C\2\2\u012c\u012d\7T\2\2\u012dP\3\2\2\2\u012e"+
		"\u012f\7@\2\2\u012fR\3\2\2\2\u0130\u0131\7Q\2\2\u0131\u0132\7T\2\2\u0132"+
		"T\3\2\2\2\u0133\u0134\7q\2\2\u0134\u0135\7t\2\2\u0135V\3\2\2\2\u0136\u0137"+
		"\7J\2\2\u0137\u0138\7C\2\2\u0138\u0139\7X\2\2\u0139\u013a\7K\2\2\u013a"+
		"\u013b\7P\2\2\u013b\u013c\7I\2\2\u013cX\3\2\2\2\u013d\u013e\7K\2\2\u013e"+
		"\u013f\7P\2\2\u013fZ\3\2\2\2\u0140\u0141\7k\2\2\u0141\u0142\7p\2\2\u0142"+
		"\\\3\2\2\2\u0143\u0144\7+\2\2\u0144^\3\2\2\2\u0145\u0146\7c\2\2\u0146"+
		"\u0147\7p\2\2\u0147\u0148\7f\2\2\u0148`\3\2\2\2\u0149\u014a\7V\2\2\u014a"+
		"\u014b\7T\2\2\u014b\u014c\7W\2\2\u014c\u014d\7G\2\2\u014db\3\2\2\2\u014e"+
		"\u0150\t\2\2\2\u014f\u014e\3\2\2\2\u0150\u0151\3\2\2\2\u0151\u014f\3\2"+
		"\2\2\u0151\u0152\3\2\2\2\u0152\u0153\3\2\2\2\u0153\u0154\b\62\2\2\u0154"+
		"d\3\2\2\2\u0155\u0157\7/\2\2\u0156\u0155\3\2\2\2\u0156\u0157\3\2\2\2\u0157"+
		"\u0159\3\2\2\2\u0158\u015a\t\3\2\2\u0159\u0158\3\2\2\2\u015a\u015b\3\2"+
		"\2\2\u015b\u0159\3\2\2\2\u015b\u015c\3\2\2\2\u015c\u015f\3\2\2\2\u015d"+
		"\u015e\7\60\2\2\u015e\u0160\t\4\2\2\u015f\u015d\3\2\2\2\u015f\u0160\3"+
		"\2\2\2\u0160f\3\2\2\2\u0161\u0165\t\5\2\2\u0162\u0164\t\6\2\2\u0163\u0162"+
		"\3\2\2\2\u0164\u0167\3\2\2\2\u0165\u0163\3\2\2\2\u0165\u0166\3\2\2\2\u0166"+
		"h\3\2\2\2\u0167\u0165\3\2\2\2\u0168\u016c\7$\2\2\u0169\u016b\n\7\2\2\u016a"+
		"\u0169\3\2\2\2\u016b\u016e\3\2\2\2\u016c\u016a\3\2\2\2\u016c\u016d\3\2"+
		"\2\2\u016d\u016f\3\2\2\2\u016e\u016c\3\2\2\2\u016f\u0170\7$\2\2\u0170"+
		"j\3\2\2\2\u0171\u0172\5o8\2\u0172l\3\2\2\2\u0173\u017b\7$\2\2\u0174\u0175"+
		"\7^\2\2\u0175\u017a\13\2\2\2\u0176\u0177\7$\2\2\u0177\u017a\7$\2\2\u0178"+
		"\u017a\n\b\2\2\u0179\u0174\3\2\2\2\u0179\u0176\3\2\2\2\u0179\u0178\3\2"+
		"\2\2\u017a\u017d\3\2\2\2\u017b\u0179\3\2\2\2\u017b\u017c\3\2\2\2\u017c"+
		"\u017e\3\2\2\2\u017d\u017b\3\2\2\2\u017e\u017f\7$\2\2\u017fn\3\2\2\2\u0180"+
		"\u0188\7)\2\2\u0181\u0182\7^\2\2\u0182\u0187\13\2\2\2\u0183\u0184\7)\2"+
		"\2\u0184\u0187\7)\2\2\u0185\u0187\n\t\2\2\u0186\u0181\3\2\2\2\u0186\u0183"+
		"\3\2\2\2\u0186\u0185\3\2\2\2\u0187\u018a\3\2\2\2\u0188\u0186\3\2\2\2\u0188"+
		"\u0189\3\2\2\2\u0189\u018b\3\2\2\2\u018a\u0188\3\2\2\2\u018b\u018c\7)"+
		"\2\2\u018cp\3\2\2\2\r\2\u0151\u0156\u015b\u015f\u0165\u016c\u0179\u017b"+
		"\u0186\u0188";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}