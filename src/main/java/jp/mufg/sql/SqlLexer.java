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
		T__10=1, T__9=2, T__8=3, T__7=4, T__6=5, T__5=6, T__4=7, T__3=8, T__2=9, 
		T__1=10, T__0=11, WS=12, NUMBER=13, ID=14;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"<INVALID>",
		"'LIMIT'", "'GROUP'", "'AS'", "'BY'", "'FROM'", "'$'", "'('", "')'", "'SELECT'", 
		"','", "'.'", "WS", "NUMBER", "ID"
	};
	public static final String[] ruleNames = {
		"T__10", "T__9", "T__8", "T__7", "T__6", "T__5", "T__4", "T__3", "T__2", 
		"T__1", "T__0", "WS", "NUMBER", "ID"
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
		case 11: WS_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void WS_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0: skip();  break;
		}
	}

	public static final String _serializedATN =
		"\2\4\20h\b\1\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\5\3\6\3\6"+
		"\3\6\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\16\5\16M\n\16\3\16\6\16P\n\16\r\16\16"+
		"\16Q\3\16\3\16\5\16V\n\16\3\17\3\17\7\17Z\n\17\f\17\16\17]\13\17\3\17"+
		"\3\17\7\17a\n\17\f\17\16\17d\13\17\3\17\5\17g\n\17\2\20\3\3\1\5\4\1\7"+
		"\5\1\t\6\1\13\7\1\r\b\1\17\t\1\21\n\1\23\13\1\25\f\1\27\r\1\31\16\2\33"+
		"\17\1\35\20\1\3\2\b\4\13\13\"\"\3\62;\3\62;\6%%C\\aac|\7%&\62;B\\aac|"+
		"\3$$m\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r"+
		"\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2"+
		"\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3\37\3\2\2\2\5%\3\2\2\2\7"+
		"+\3\2\2\2\t.\3\2\2\2\13\61\3\2\2\2\r\66\3\2\2\2\178\3\2\2\2\21:\3\2\2"+
		"\2\23<\3\2\2\2\25C\3\2\2\2\27E\3\2\2\2\31G\3\2\2\2\33L\3\2\2\2\35f\3\2"+
		"\2\2\37 \7N\2\2 !\7K\2\2!\"\7O\2\2\"#\7K\2\2#$\7V\2\2$\4\3\2\2\2%&\7I"+
		"\2\2&\'\7T\2\2\'(\7Q\2\2()\7W\2\2)*\7R\2\2*\6\3\2\2\2+,\7C\2\2,-\7U\2"+
		"\2-\b\3\2\2\2./\7D\2\2/\60\7[\2\2\60\n\3\2\2\2\61\62\7H\2\2\62\63\7T\2"+
		"\2\63\64\7Q\2\2\64\65\7O\2\2\65\f\3\2\2\2\66\67\7&\2\2\67\16\3\2\2\28"+
		"9\7*\2\29\20\3\2\2\2:;\7+\2\2;\22\3\2\2\2<=\7U\2\2=>\7G\2\2>?\7N\2\2?"+
		"@\7G\2\2@A\7E\2\2AB\7V\2\2B\24\3\2\2\2CD\7.\2\2D\26\3\2\2\2EF\7\60\2\2"+
		"F\30\3\2\2\2GH\t\2\2\2HI\3\2\2\2IJ\b\r\2\2J\32\3\2\2\2KM\7/\2\2LK\3\2"+
		"\2\2LM\3\2\2\2MO\3\2\2\2NP\t\3\2\2ON\3\2\2\2PQ\3\2\2\2QO\3\2\2\2QR\3\2"+
		"\2\2RU\3\2\2\2ST\7\60\2\2TV\t\4\2\2US\3\2\2\2UV\3\2\2\2V\34\3\2\2\2W["+
		"\t\5\2\2XZ\t\6\2\2YX\3\2\2\2Z]\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2\\g\3\2\2\2"+
		"][\3\2\2\2^b\7$\2\2_a\n\7\2\2`_\3\2\2\2ad\3\2\2\2b`\3\2\2\2bc\3\2\2\2"+
		"ce\3\2\2\2db\3\2\2\2eg\7$\2\2fW\3\2\2\2f^\3\2\2\2g\36\3\2\2\2\t\2LQU["+
		"bf";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}