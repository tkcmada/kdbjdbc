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
		T__0=1, WS=2, NUMBER=3, ID=4;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'SELECT'", "WS", "NUMBER", "ID"
	};
	public static final String[] ruleNames = {
		"T__0", "WS", "NUMBER", "ID"
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
		case 1: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\6+\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\3\3\3\3\3\3\3\3\4\5\4\30\n\4\3\4\6\4\33\n\4\r\4\16\4\34\3\4\3\4\5"+
		"\4!\n\4\3\5\5\5$\n\5\3\5\7\5\'\n\5\f\5\16\5*\13\5\2\6\3\3\1\5\4\2\7\5"+
		"\1\t\6\1\3\2\7\4\13\13\"\"\3\62;\3\62;\5C\\aac|\6\62;C\\aac|.\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\3\13\3\2\2\2\5\22\3\2\2\2\7\27"+
		"\3\2\2\2\t#\3\2\2\2\13\f\7U\2\2\f\r\7G\2\2\r\16\7N\2\2\16\17\7G\2\2\17"+
		"\20\7E\2\2\20\21\7V\2\2\21\4\3\2\2\2\22\23\t\2\2\2\23\24\3\2\2\2\24\25"+
		"\b\3\2\2\25\6\3\2\2\2\26\30\7/\2\2\27\26\3\2\2\2\27\30\3\2\2\2\30\32\3"+
		"\2\2\2\31\33\t\3\2\2\32\31\3\2\2\2\33\34\3\2\2\2\34\32\3\2\2\2\34\35\3"+
		"\2\2\2\35 \3\2\2\2\36\37\7\60\2\2\37!\t\4\2\2 \36\3\2\2\2 !\3\2\2\2!\b"+
		"\3\2\2\2\"$\t\5\2\2#\"\3\2\2\2$(\3\2\2\2%\'\t\6\2\2&%\3\2\2\2\'*\3\2\2"+
		"\2(&\3\2\2\2()\3\2\2\2)\n\3\2\2\2*(\3\2\2\2\t\2\27\34 #&(";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}