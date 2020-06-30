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
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, WS=8, NUMBER=9, 
		ID=10;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'LIMIT'", "'AS'", "'FROM'", "'$'", "'SELECT'", "','", "'.'", "WS", "NUMBER", 
		"ID"
	};
	public static final String[] ruleNames = {
		"T__6", "T__5", "T__4", "T__3", "T__2", "T__1", "T__0", "WS", "NUMBER", 
		"ID"
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
		case 7: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\fT\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\3\2\3\2\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3"+
		"\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t"+
		"\3\t\3\t\3\n\5\n8\n\n\3\n\6\n;\n\n\r\n\16\n<\3\n\3\n\5\nA\n\n\3\13\3\13"+
		"\7\13E\n\13\f\13\16\13H\13\13\3\13\3\13\3\13\7\13M\n\13\f\13\16\13P\13"+
		"\13\3\13\5\13S\n\13\2\f\3\3\1\5\4\1\7\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21"+
		"\n\2\23\13\1\25\f\1\3\2\t\4\13\13\"\"\3\62;\3\62;\6%%C\\aac|\7%&\62;B"+
		"\\aac|\6%%C\\aac|\7%&\62;B\\aac|Y\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2"+
		"\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3"+
		"\2\2\2\2\25\3\2\2\2\3\27\3\2\2\2\5\35\3\2\2\2\7 \3\2\2\2\t%\3\2\2\2\13"+
		"\'\3\2\2\2\r.\3\2\2\2\17\60\3\2\2\2\21\62\3\2\2\2\23\67\3\2\2\2\25R\3"+
		"\2\2\2\27\30\7N\2\2\30\31\7K\2\2\31\32\7O\2\2\32\33\7K\2\2\33\34\7V\2"+
		"\2\34\4\3\2\2\2\35\36\7C\2\2\36\37\7U\2\2\37\6\3\2\2\2 !\7H\2\2!\"\7T"+
		"\2\2\"#\7Q\2\2#$\7O\2\2$\b\3\2\2\2%&\7&\2\2&\n\3\2\2\2\'(\7U\2\2()\7G"+
		"\2\2)*\7N\2\2*+\7G\2\2+,\7E\2\2,-\7V\2\2-\f\3\2\2\2./\7.\2\2/\16\3\2\2"+
		"\2\60\61\7\60\2\2\61\20\3\2\2\2\62\63\t\2\2\2\63\64\3\2\2\2\64\65\b\t"+
		"\2\2\65\22\3\2\2\2\668\7/\2\2\67\66\3\2\2\2\678\3\2\2\28:\3\2\2\29;\t"+
		"\3\2\2:9\3\2\2\2;<\3\2\2\2<:\3\2\2\2<=\3\2\2\2=@\3\2\2\2>?\7\60\2\2?A"+
		"\t\4\2\2@>\3\2\2\2@A\3\2\2\2A\24\3\2\2\2BF\t\5\2\2CE\t\6\2\2DC\3\2\2\2"+
		"EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GS\3\2\2\2HF\3\2\2\2IJ\7$\2\2JN\t\7\2\2"+
		"KM\t\b\2\2LK\3\2\2\2MP\3\2\2\2NL\3\2\2\2NO\3\2\2\2OQ\3\2\2\2PN\3\2\2\2"+
		"QS\7$\2\2RB\3\2\2\2RI\3\2\2\2S\26\3\2\2\2\t\2\67<@FNR";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}