// Generated from jp/mufg/sql/Sql.g4 by ANTLR 4.0
package jp.mufg.sql;
 
import jp.mufg.sqlutil.SqlExprs.*;

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
		T__13=1, T__12=2, T__11=3, T__10=4, T__9=5, T__8=6, T__7=7, T__6=8, T__5=9, 
		T__4=10, T__3=11, T__2=12, T__1=13, T__0=14, WS=15, NUMBER=16, ID1=17, 
		ID2=18;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'LIMIT'", "'AS'", "'BY'", "'FROM'", "'<'", "'>'", "'HAVING'", "'GROUP'", 
		"'$'", "'('", "')'", "'SELECT'", "','", "'.'", "WS", "NUMBER", "ID1", 
		"ID2"
	};
	public static final String[] ruleNames = {
		"T__13", "T__12", "T__11", "T__10", "T__9", "T__8", "T__7", "T__6", "T__5", 
		"T__4", "T__3", "T__2", "T__1", "T__0", "WS", "NUMBER", "ID1", "ID2"
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
		case 14: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\24z\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\21\5\21`\n\21\3\21"+
		"\6\21c\n\21\r\21\16\21d\3\21\3\21\5\21i\n\21\3\22\3\22\7\22m\n\22\f\22"+
		"\16\22p\13\22\3\23\3\23\7\23t\n\23\f\23\16\23w\13\23\3\23\3\23\2\24\3"+
		"\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r"+
		"\1\31\16\1\33\17\1\35\20\1\37\21\2!\22\1#\23\1%\24\1\3\2\b\4\13\13\"\""+
		"\3\62;\3\62;\6%%C\\aac|\7%&\62;B\\aac|\3$$~\2\3\3\2\2\2\2\5\3\2\2\2\2"+
		"\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2"+
		"\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2"+
		"\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2"+
		"\2\5-\3\2\2\2\7\60\3\2\2\2\t\63\3\2\2\2\138\3\2\2\2\r:\3\2\2\2\17<\3\2"+
		"\2\2\21C\3\2\2\2\23I\3\2\2\2\25K\3\2\2\2\27M\3\2\2\2\31O\3\2\2\2\33V\3"+
		"\2\2\2\35X\3\2\2\2\37Z\3\2\2\2!_\3\2\2\2#j\3\2\2\2%q\3\2\2\2\'(\7N\2\2"+
		"()\7K\2\2)*\7O\2\2*+\7K\2\2+,\7V\2\2,\4\3\2\2\2-.\7C\2\2./\7U\2\2/\6\3"+
		"\2\2\2\60\61\7D\2\2\61\62\7[\2\2\62\b\3\2\2\2\63\64\7H\2\2\64\65\7T\2"+
		"\2\65\66\7Q\2\2\66\67\7O\2\2\67\n\3\2\2\289\7>\2\29\f\3\2\2\2:;\7@\2\2"+
		";\16\3\2\2\2<=\7J\2\2=>\7C\2\2>?\7X\2\2?@\7K\2\2@A\7P\2\2AB\7I\2\2B\20"+
		"\3\2\2\2CD\7I\2\2DE\7T\2\2EF\7Q\2\2FG\7W\2\2GH\7R\2\2H\22\3\2\2\2IJ\7"+
		"&\2\2J\24\3\2\2\2KL\7*\2\2L\26\3\2\2\2MN\7+\2\2N\30\3\2\2\2OP\7U\2\2P"+
		"Q\7G\2\2QR\7N\2\2RS\7G\2\2ST\7E\2\2TU\7V\2\2U\32\3\2\2\2VW\7.\2\2W\34"+
		"\3\2\2\2XY\7\60\2\2Y\36\3\2\2\2Z[\t\2\2\2[\\\3\2\2\2\\]\b\20\2\2] \3\2"+
		"\2\2^`\7/\2\2_^\3\2\2\2_`\3\2\2\2`b\3\2\2\2ac\t\3\2\2ba\3\2\2\2cd\3\2"+
		"\2\2db\3\2\2\2de\3\2\2\2eh\3\2\2\2fg\7\60\2\2gi\t\4\2\2hf\3\2\2\2hi\3"+
		"\2\2\2i\"\3\2\2\2jn\t\5\2\2km\t\6\2\2lk\3\2\2\2mp\3\2\2\2nl\3\2\2\2no"+
		"\3\2\2\2o$\3\2\2\2pn\3\2\2\2qu\7$\2\2rt\n\7\2\2sr\3\2\2\2tw\3\2\2\2us"+
		"\3\2\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2xy\7$\2\2y&\3\2\2\2\b\2_dhnu";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}