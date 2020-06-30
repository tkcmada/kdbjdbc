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
		T__8=1, T__7=2, T__6=3, T__5=4, T__4=5, T__3=6, T__2=7, T__1=8, T__0=9, 
		WS=10, NUMBER=11, ID=12;
	public static final String[] tokenNames = {
		"<INVALID>", "'LIMIT'", "'AS'", "'FROM'", "'$'", "'('", "')'", "'SELECT'", 
		"','", "'.'", "WS", "NUMBER", "ID"
	};
	public static final int
		RULE_selectStmt = 0, RULE_tableName = 1, RULE_columnNames = 2, RULE_columnName = 3, 
		RULE_expr = 4, RULE_args = 5, RULE_columnExpr = 6;
	public static final String[] ruleNames = {
		"selectStmt", "tableName", "columnNames", "columnName", "expr", "args", 
		"columnExpr"
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
			setState(14); match(7);
			setState(15); columnNames();
			setState(16); match(3);
			setState(17); tableName();
			setState(20);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(18); match(1);
				setState(19); match(NUMBER);
				}
			}

			setState(22); match(4);
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
			setState(40);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24); match(ID);
				setState(29);
				_la = _input.LA(1);
				if (_la==2 || _la==ID) {
					{
					setState(26);
					_la = _input.LA(1);
					if (_la==2) {
						{
						setState(25); match(2);
						}
					}

					setState(28); match(ID);
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(31); match(ID);
				setState(32); match(9);
				setState(33); match(ID);
				setState(38);
				_la = _input.LA(1);
				if (_la==2 || _la==ID) {
					{
					setState(35);
					_la = _input.LA(1);
					if (_la==2) {
						{
						setState(34); match(2);
						}
					}

					setState(37); match(ID);
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
			setState(42); columnName();
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==8) {
				{
				{
				setState(43); match(8);
				setState(44); columnName();
				}
				}
				setState(49);
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
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
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
			enterOuterAlt(_localctx, 1);
			{
			setState(50); expr();
			setState(53);
			_la = _input.LA(1);
			if (_la==2) {
				{
				setState(51); match(2);
				setState(52); match(ID);
				}
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

	public static class ExprContext extends ParserRuleContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public ColumnExprContext columnExpr() {
			return getRuleContext(ColumnExprContext.class,0);
		}
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitExpr(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_expr);
		try {
			setState(61);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(55); columnExpr();
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(56); match(ID);
				setState(57); match(5);
				setState(58); args();
				setState(59); match(6);
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

	public static class ArgsContext extends ParserRuleContext {
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_args; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitArgs(this);
		}
	}

	public final ArgsContext args() throws RecognitionException {
		ArgsContext _localctx = new ArgsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(71);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(63); expr();
				setState(68);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==8) {
					{
					{
					setState(64); match(8);
					setState(65); expr();
					}
					}
					setState(70);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
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

	public static class ColumnExprContext extends ParserRuleContext {
		public List<TerminalNode> ID() { return getTokens(SqlParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(SqlParser.ID, i);
		}
		public ColumnExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_columnExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterColumnExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitColumnExpr(this);
		}
	}

	public final ColumnExprContext columnExpr() throws RecognitionException {
		ColumnExprContext _localctx = new ColumnExprContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_columnExpr);
		try {
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(73); match(ID);
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74); match(ID);
				setState(75); match(9);
				setState(76); match(ID);
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
		"\2\3\16R\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\5\2\27\n\2\3\2\3\2\3\3\3\3\5\3\35\n\3\3\3\5\3 \n\3"+
		"\3\3\3\3\3\3\3\3\5\3&\n\3\3\3\5\3)\n\3\5\3+\n\3\3\4\3\4\3\4\7\4\60\n\4"+
		"\f\4\16\4\63\13\4\3\5\3\5\3\5\5\58\n\5\3\6\3\6\3\6\3\6\3\6\3\6\5\6@\n"+
		"\6\3\7\3\7\3\7\7\7E\n\7\f\7\16\7H\13\7\5\7J\n\7\3\b\3\b\3\b\3\b\5\bP\n"+
		"\b\3\b\2\t\2\4\6\b\n\f\16\2\2V\2\20\3\2\2\2\4*\3\2\2\2\6,\3\2\2\2\b\64"+
		"\3\2\2\2\n?\3\2\2\2\fI\3\2\2\2\16O\3\2\2\2\20\21\7\t\2\2\21\22\5\6\4\2"+
		"\22\23\7\5\2\2\23\26\5\4\3\2\24\25\7\3\2\2\25\27\7\r\2\2\26\24\3\2\2\2"+
		"\26\27\3\2\2\2\27\30\3\2\2\2\30\31\7\6\2\2\31\3\3\2\2\2\32\37\7\16\2\2"+
		"\33\35\7\4\2\2\34\33\3\2\2\2\34\35\3\2\2\2\35\36\3\2\2\2\36 \7\16\2\2"+
		"\37\34\3\2\2\2\37 \3\2\2\2 +\3\2\2\2!\"\7\16\2\2\"#\7\13\2\2#(\7\16\2"+
		"\2$&\7\4\2\2%$\3\2\2\2%&\3\2\2\2&\'\3\2\2\2\')\7\16\2\2(%\3\2\2\2()\3"+
		"\2\2\2)+\3\2\2\2*\32\3\2\2\2*!\3\2\2\2+\5\3\2\2\2,\61\5\b\5\2-.\7\n\2"+
		"\2.\60\5\b\5\2/-\3\2\2\2\60\63\3\2\2\2\61/\3\2\2\2\61\62\3\2\2\2\62\7"+
		"\3\2\2\2\63\61\3\2\2\2\64\67\5\n\6\2\65\66\7\4\2\2\668\7\16\2\2\67\65"+
		"\3\2\2\2\678\3\2\2\28\t\3\2\2\29@\5\16\b\2:;\7\16\2\2;<\7\7\2\2<=\5\f"+
		"\7\2=>\7\b\2\2>@\3\2\2\2?9\3\2\2\2?:\3\2\2\2@\13\3\2\2\2AF\5\n\6\2BC\7"+
		"\n\2\2CE\5\n\6\2DB\3\2\2\2EH\3\2\2\2FD\3\2\2\2FG\3\2\2\2GJ\3\2\2\2HF\3"+
		"\2\2\2IA\3\2\2\2IJ\3\2\2\2J\r\3\2\2\2KP\7\16\2\2LM\7\16\2\2MN\7\13\2\2"+
		"NP\7\16\2\2OK\3\2\2\2OL\3\2\2\2P\17\3\2\2\2\16\26\34\37%(*\61\67?FIO";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}