// Generated from jp/mufg/sql/Sql.g4 by ANTLR 4.0
package jp.mufg.sql;
 
//this is header

import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class SqlParser extends Parser {
	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__6=1, T__5=2, T__4=3, T__3=4, T__2=5, T__1=6, T__0=7, WS=8, NUMBER=9, 
		ID=10;
	public static final String[] tokenNames = {
		"<INVALID>", "'LIMIT'", "'AS'", "'FROM'", "'$'", "'SELECT'", "','", "'.'", 
		"WS", "NUMBER", "ID"
	};
	public static final int
		RULE_selectStmt = 0, RULE_tableName = 1, RULE_columnNames = 2, RULE_columnName = 3;
	public static final String[] ruleNames = {
		"selectStmt", "tableName", "columnNames", "columnName"
	};

	@Override
	public String getGrammarFileName() { return "Sql.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public SqlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class SelectStmtContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(SqlParser.NUMBER, 0); }
		public ColumnNamesContext columnNames() {
			return getRuleContext(ColumnNamesContext.class,0);
		}
		public TableNameContext tableName() {
			return getRuleContext(TableNameContext.class,0);
		}
		public SelectStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSelectStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSelectStmt(this);
		}
	}

	public final SelectStmtContext selectStmt() throws RecognitionException {
		SelectStmtContext _localctx = new SelectStmtContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_selectStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(8); match(5);
			setState(9); columnNames();
			setState(10); match(3);
			setState(11); tableName();
			setState(14);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(12); match(1);
				setState(13); match(NUMBER);
				}
			}

			setState(16); match(4);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TableNameContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SqlParser.ID, i);
		}
		public TableNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tableName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterTableName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitTableName(this);
		}
	}

	public final TableNameContext tableName() throws RecognitionException {
		TableNameContext _localctx = new TableNameContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_tableName);
		int _la;
		try {
			setState(34);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(18); match(ID);
				setState(23);
				_la = _input.LA(1);
				if (_la==2 || _la==ID) {
					{
					setState(20);
					_la = _input.LA(1);
					if (_la==2) {
						{
						setState(19); match(2);
						}
					}

					setState(22); match(ID);
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25); match(ID);
				setState(26); match(7);
				setState(27); match(ID);
				setState(32);
				_la = _input.LA(1);
				if (_la==2 || _la==ID) {
					{
					setState(29);
					_la = _input.LA(1);
					if (_la==2) {
						{
						setState(28); match(2);
						}
					}

					setState(31); match(ID);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnNamesContext extends ParserRuleContext {
		public List<ColumnNameContext> columnName() {
			return getRuleContexts(ColumnNameContext.class);
		}
		public ColumnNameContext columnName(int i) {
			return getRuleContext(ColumnNameContext.class,i);
		}
		public ColumnNamesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnNames; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterColumnNames(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitColumnNames(this);
		}
	}

	public final ColumnNamesContext columnNames() throws RecognitionException {
		ColumnNamesContext _localctx = new ColumnNamesContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_columnNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(36); columnName();
			setState(41);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==6) {
				{
				{
				setState(37); match(6);
				setState(38); columnName();
				}
				}
				setState(43);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ColumnNameContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SqlParser.ID, i);
		}
		public ColumnNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterColumnName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitColumnName(this);
		}
	}

	public final ColumnNameContext columnName() throws RecognitionException {
		ColumnNameContext _localctx = new ColumnNameContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_columnName);
		int _la;
		try {
			setState(56);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(44); match(ID);
				setState(47);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(45); match(2);
					setState(46); match(ID);
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(49); match(ID);
				setState(50); match(7);
				setState(51); match(ID);
				setState(54);
				_la = _input.LA(1);
				if (_la==2) {
					{
					setState(52); match(2);
					setState(53); match(ID);
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\2\3\f=\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\3\2\3\2\3\2\3\2\3\2\3\2\5\2\21"+
		"\n\2\3\2\3\2\3\3\3\3\5\3\27\n\3\3\3\5\3\32\n\3\3\3\3\3\3\3\3\3\5\3 \n"+
		"\3\3\3\5\3#\n\3\5\3%\n\3\3\4\3\4\3\4\7\4*\n\4\f\4\16\4-\13\4\3\5\3\5\3"+
		"\5\5\5\62\n\5\3\5\3\5\3\5\3\5\3\5\5\59\n\5\5\5;\n\5\3\5\2\6\2\4\6\b\2"+
		"\2B\2\n\3\2\2\2\4$\3\2\2\2\6&\3\2\2\2\b:\3\2\2\2\n\13\7\7\2\2\13\f\5\6"+
		"\4\2\f\r\7\5\2\2\r\20\5\4\3\2\16\17\7\3\2\2\17\21\7\13\2\2\20\16\3\2\2"+
		"\2\20\21\3\2\2\2\21\22\3\2\2\2\22\23\7\6\2\2\23\3\3\2\2\2\24\31\7\f\2"+
		"\2\25\27\7\4\2\2\26\25\3\2\2\2\26\27\3\2\2\2\27\30\3\2\2\2\30\32\7\f\2"+
		"\2\31\26\3\2\2\2\31\32\3\2\2\2\32%\3\2\2\2\33\34\7\f\2\2\34\35\7\t\2\2"+
		"\35\"\7\f\2\2\36 \7\4\2\2\37\36\3\2\2\2\37 \3\2\2\2 !\3\2\2\2!#\7\f\2"+
		"\2\"\37\3\2\2\2\"#\3\2\2\2#%\3\2\2\2$\24\3\2\2\2$\33\3\2\2\2%\5\3\2\2"+
		"\2&+\5\b\5\2\'(\7\b\2\2(*\5\b\5\2)\'\3\2\2\2*-\3\2\2\2+)\3\2\2\2+,\3\2"+
		"\2\2,\7\3\2\2\2-+\3\2\2\2.\61\7\f\2\2/\60\7\4\2\2\60\62\7\f\2\2\61/\3"+
		"\2\2\2\61\62\3\2\2\2\62;\3\2\2\2\63\64\7\f\2\2\64\65\7\t\2\2\658\7\f\2"+
		"\2\66\67\7\4\2\2\679\7\f\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:.\3\2\2\2"+
		":\63\3\2\2\2;\t\3\2\2\2\f\20\26\31\37\"$+\618:";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}