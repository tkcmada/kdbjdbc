// Generated from jp/mufg/sql/Sql.g4 by ANTLR 4.0
package jp.mufg.sql;
 
//this is header

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
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		WS=10, NUMBER=11, ID=12;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'LIMIT'", "'AS'", "'FROM'", "'$'", "'('", "')'", "'SELECT'", "','", "'.'", 
		"WS", "NUMBER", "ID"
	};
	public static final String[] ruleNames = {
		"T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", 
		"WS", "NUMBER", "ID"
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
		case 9: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\16Z\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3"+
		"\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3\13\3\f\5\f@\n\f\3\f\6\fC\n\f"+
		"\r\f\16\fD\3\f\3\f\5\fI\n\f\3\r\3\r\7\rM\n\r\f\r\16\rP\13\r\3\r\3\r\6"+
		"\rT\n\r\r\r\16\rU\3\r\5\rY\n\r\2\16\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b"+
		"\1\17\t\1\21\n\1\23\13\1\25\f\2\27\r\1\31\16\1\3\2\b\4\13\13\"\"\3\62"+
		";\3\62;\6%%C\\aac|\7%&\62;B\\aac|\3$$_\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2"+
		"\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2"+
		"\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\3\33\3\2\2\2\5!\3\2"+
		"\2\2\7$\3\2\2\2\t)\3\2\2\2\13+\3\2\2\2\r-\3\2\2\2\17/\3\2\2\2\21\66\3"+
		"\2\2\2\238\3\2\2\2\25:\3\2\2\2\27?\3\2\2\2\31X\3\2\2\2\33\34\7N\2\2\34"+
		"\35\7K\2\2\35\36\7O\2\2\36\37\7K\2\2\37 \7V\2\2 \4\3\2\2\2!\"\7C\2\2\""+
		"#\7U\2\2#\6\3\2\2\2$%\7H\2\2%&\7T\2\2&\'\7Q\2\2\'(\7O\2\2(\b\3\2\2\2)"+
		"*\7&\2\2*\n\3\2\2\2+,\7*\2\2,\f\3\2\2\2-.\7+\2\2.\16\3\2\2\2/\60\7U\2"+
		"\2\60\61\7G\2\2\61\62\7N\2\2\62\63\7G\2\2\63\64\7E\2\2\64\65\7V\2\2\65"+
		"\20\3\2\2\2\66\67\7.\2\2\67\22\3\2\2\289\7\60\2\29\24\3\2\2\2:;\t\2\2"+
		"\2;<\3\2\2\2<=\b\13\2\2=\26\3\2\2\2>@\7/\2\2?>\3\2\2\2?@\3\2\2\2@B\3\2"+
		"\2\2AC\t\3\2\2BA\3\2\2\2CD\3\2\2\2DB\3\2\2\2DE\3\2\2\2EH\3\2\2\2FG\7\60"+
		"\2\2GI\t\4\2\2HF\3\2\2\2HI\3\2\2\2I\30\3\2\2\2JN\t\5\2\2KM\t\6\2\2LK\3"+
		"\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OY\3\2\2\2PN\3\2\2\2QS\7$\2\2RT\n"+
		"\7\2\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2\2VW\3\2\2\2WY\7$\2\2XJ\3"+
		"\2\2\2XQ\3\2\2\2Y\32\3\2\2\2\t\2?DHNUX";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}