// Generated from jp/mufg/sql/Sql.g4 by ANTLR 4.0
package jp.mufg.sql;
 
import jp.mufg.sqlutil.SqlExprs.*;

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
		T__13=1, T__12=2, T__11=3, T__10=4, T__9=5, T__8=6, T__7=7, T__6=8, T__5=9, 
		T__4=10, T__3=11, T__2=12, T__1=13, T__0=14, WS=15, NUMBER=16, ID=17;
	public static final String[] tokenNames = {
		"<INVALID>", "'LIMIT'", "'AS'", "'BY'", "'FROM'", "'<'", "'>'", "'HAVING'", 
		"'GROUP'", "'$'", "'('", "')'", "'SELECT'", "','", "'.'", "WS", "NUMBER", 
		"ID"
	};
	public static final int
		RULE_selectStmt = 0, RULE_tableName = 1, RULE_columnNames = 2, RULE_columnName = 3, 
		RULE_groupBy = 4, RULE_having = 5, RULE_limit = 6, RULE_expr = 7, RULE_compExpr = 8, 
		RULE_primaryExpr = 9, RULE_functionExpr = 10, RULE_numberExpr = 11, RULE_args = 12, 
		RULE_columnExpr = 13;
	public static final String[] ruleNames = {
		"selectStmt", "tableName", "columnNames", "columnName", "groupBy", "having", 
		"limit", "expr", "compExpr", "primaryExpr", "functionExpr", "numberExpr", 
		"args", "columnExpr"
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
		public HavingContext having() {
			return getRuleContext(HavingContext.class,0);
		}
		public ColumnNamesContext columnNames() {
			return getRuleContext(ColumnNamesContext.class,0);
		}
		public LimitContext limit() {
			return getRuleContext(LimitContext.class,0);
		}
		public GroupByContext groupBy() {
			return getRuleContext(GroupByContext.class,0);
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
			setState(28); match(12);
			setState(29); columnNames();
			setState(30); match(4);
			setState(31); tableName();
			setState(33);
			_la = _input.LA(1);
			if (_la==8) {
				{
				setState(32); groupBy();
				}
			}

			setState(36);
			_la = _input.LA(1);
			if (_la==7) {
				{
				setState(35); having();
				}
			}

			setState(39);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(38); limit();
				}
			}

			setState(41); match(9);
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
			setState(59);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(43); match(ID);
				setState(48);
				_la = _input.LA(1);
				if (_la==2 || _la==ID) {
					{
					setState(45);
					_la = _input.LA(1);
					if (_la==2) {
						{
						setState(44); match(2);
						}
					}

					setState(47); match(ID);
					}
				}

				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(50); match(ID);
				setState(51); match(14);
				setState(52); match(ID);
				setState(57);
				_la = _input.LA(1);
				if (_la==2 || _la==ID) {
					{
					setState(54);
					_la = _input.LA(1);
					if (_la==2) {
						{
						setState(53); match(2);
						}
					}

					setState(56); match(ID);
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
			setState(61); columnName();
			setState(66);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==13) {
				{
				{
				setState(62); match(13);
				setState(63); columnName();
				}
				}
				setState(68);
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
		public ColumnExprWithAlias val;
		public ExprContext expr;
		public Token ID;
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
		try {
			setState(77);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(69); ((ColumnNameContext)_localctx).expr = expr();
				setState(70); match(2);
				setState(71); ((ColumnNameContext)_localctx).ID = match(ID);
				 ((ColumnNameContext)_localctx).val =  new ColumnExprWithAlias(((ColumnNameContext)_localctx).expr.val, (((ColumnNameContext)_localctx).ID!=null?((ColumnNameContext)_localctx).ID.getText():null)); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74); ((ColumnNameContext)_localctx).expr = expr();
				 ((ColumnNameContext)_localctx).val =  new ColumnExprWithAlias(((ColumnNameContext)_localctx).expr.val, null); 
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

	public static class GroupByContext extends ParserRuleContext {
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public GroupByContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupBy; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterGroupBy(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitGroupBy(this);
		}
	}

	public final GroupByContext groupBy() throws RecognitionException {
		GroupByContext _localctx = new GroupByContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_groupBy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79); match(8);
			setState(80); match(3);
			setState(81); args();
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

	public static class HavingContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public HavingContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_having; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterHaving(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitHaving(this);
		}
	}

	public final HavingContext having() throws RecognitionException {
		HavingContext _localctx = new HavingContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_having);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83); match(7);
			setState(84); expr();
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

	public static class LimitContext extends ParserRuleContext {
		public TerminalNode NUMBER() { return getToken(SqlParser.NUMBER, 0); }
		public LimitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_limit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterLimit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitLimit(this);
		}
	}

	public final LimitContext limit() throws RecognitionException {
		LimitContext _localctx = new LimitContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_limit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(86); match(1);
			setState(87); match(NUMBER);
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
		public Expr val;
		public CompExprContext compExpr;
		public CompExprContext compExpr() {
			return getRuleContext(CompExprContext.class,0);
		}
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
		enterRule(_localctx, 14, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(89); ((ExprContext)_localctx).compExpr = compExpr();
			 ((ExprContext)_localctx).val =  ((ExprContext)_localctx).compExpr.val; 
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

	public static class CompExprContext extends ParserRuleContext {
		public Expr val;
		public PrimaryExprContext lhs;
		public PrimaryExprContext rhs;
		public PrimaryExprContext primaryExpr(int i) {
			return getRuleContext(PrimaryExprContext.class,i);
		}
		public List<PrimaryExprContext> primaryExpr() {
			return getRuleContexts(PrimaryExprContext.class);
		}
		public CompExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCompExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCompExpr(this);
		}
	}

	public final CompExprContext compExpr() throws RecognitionException {
		CompExprContext _localctx = new CompExprContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_compExpr);
		try {
			setState(105);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92); ((CompExprContext)_localctx).lhs = primaryExpr();
				setState(93); match(6);
				setState(94); ((CompExprContext)_localctx).rhs = primaryExpr();
				 ((CompExprContext)_localctx).val =  new BinaryExpr(">", ((CompExprContext)_localctx).lhs.val, ((CompExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97); ((CompExprContext)_localctx).lhs = primaryExpr();
				setState(98); match(5);
				setState(99); ((CompExprContext)_localctx).rhs = primaryExpr();
				 ((CompExprContext)_localctx).val =  new BinaryExpr("<", ((CompExprContext)_localctx).lhs.val, ((CompExprContext)_localctx).rhs.val); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(102); ((CompExprContext)_localctx).lhs = primaryExpr();
				 ((CompExprContext)_localctx).val =  ((CompExprContext)_localctx).lhs.val; 
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

	public static class PrimaryExprContext extends ParserRuleContext {
		public Expr val;
		public ColumnExprContext e1;
		public FunctionExprContext functionExpr;
		public NumberExprContext numberExpr;
		public ExprContext expr;
		public ColumnExprContext columnExpr() {
			return getRuleContext(ColumnExprContext.class,0);
		}
		public NumberExprContext numberExpr() {
			return getRuleContext(NumberExprContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public FunctionExprContext functionExpr() {
			return getRuleContext(FunctionExprContext.class,0);
		}
		public PrimaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterPrimaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitPrimaryExpr(this);
		}
	}

	public final PrimaryExprContext primaryExpr() throws RecognitionException {
		PrimaryExprContext _localctx = new PrimaryExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_primaryExpr);
		try {
			setState(121);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107); ((PrimaryExprContext)_localctx).e1 = columnExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).e1.val; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(110); ((PrimaryExprContext)_localctx).functionExpr = functionExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).functionExpr.val; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(113); ((PrimaryExprContext)_localctx).numberExpr = numberExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).numberExpr.val; 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(116); match(10);
				setState(117); ((PrimaryExprContext)_localctx).expr = expr();
				setState(118); match(11);
				 ((PrimaryExprContext)_localctx).val =  new BranketExpr(((PrimaryExprContext)_localctx).expr.val); 
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

	public static class FunctionExprContext extends ParserRuleContext {
		public FunctionCallExpr val;
		public Token ID;
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public TerminalNode ID() { return getToken(SqlParser.ID, 0); }
		public FunctionExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterFunctionExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitFunctionExpr(this);
		}
	}

	public final FunctionExprContext functionExpr() throws RecognitionException {
		FunctionExprContext _localctx = new FunctionExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_functionExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123); ((FunctionExprContext)_localctx).ID = match(ID);
			setState(124); match(10);
			setState(125); args();
			setState(126); match(11);
			 ((FunctionExprContext)_localctx).val =  new FunctionCallExpr((((FunctionExprContext)_localctx).ID!=null?((FunctionExprContext)_localctx).ID.getText():null), null); 
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

	public static class NumberExprContext extends ParserRuleContext {
		public NumberExpr val;
		public Token numtk;
		public TerminalNode NUMBER() { return getToken(SqlParser.NUMBER, 0); }
		public NumberExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterNumberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitNumberExpr(this);
		}
	}

	public final NumberExprContext numberExpr() throws RecognitionException {
		NumberExprContext _localctx = new NumberExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_numberExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(129); ((NumberExprContext)_localctx).numtk = match(NUMBER);
			 ((NumberExprContext)_localctx).val =  new NumberExpr((((NumberExprContext)_localctx).numtk!=null?((NumberExprContext)_localctx).numtk.getText():null)); 
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
		enterRule(_localctx, 24, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << NUMBER) | (1L << ID))) != 0)) {
				{
				setState(132); expr();
				setState(137);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==13) {
					{
					{
					setState(133); match(13);
					setState(134); expr();
					}
					}
					setState(139);
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
		public ColumnExpr val;
		public Token ID;
		public Token id1;
		public Token id2;
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
		enterRule(_localctx, 26, RULE_columnExpr);
		try {
			setState(148);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(142); ((ColumnExprContext)_localctx).ID = match(ID);
				 ((ColumnExprContext)_localctx).val =  new ColumnExpr(null,      (((ColumnExprContext)_localctx).ID!=null?((ColumnExprContext)_localctx).ID.getText():null)); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(144); ((ColumnExprContext)_localctx).id1 = match(ID);
				setState(145); match(14);
				setState(146); ((ColumnExprContext)_localctx).id2 = match(ID);
				 ((ColumnExprContext)_localctx).val =  new ColumnExpr((((ColumnExprContext)_localctx).id1!=null?((ColumnExprContext)_localctx).id1.getText():null), (((ColumnExprContext)_localctx).id2!=null?((ColumnExprContext)_localctx).id2.getText():null)); 
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
		"\2\3\23\u0099\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\3\2"+
		"\3\2\3\2\3\2\5\2$\n\2\3\2\5\2\'\n\2\3\2\5\2*\n\2\3\2\3\2\3\3\3\3\5\3\60"+
		"\n\3\3\3\5\3\63\n\3\3\3\3\3\3\3\3\3\5\39\n\3\3\3\5\3<\n\3\5\3>\n\3\3\4"+
		"\3\4\3\4\7\4C\n\4\f\4\16\4F\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5P"+
		"\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nl\n\n\3\13\3\13\3\13\3\13\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13|\n\13\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\7\16\u008a\n\16\f\16\16\16\u008d"+
		"\13\16\5\16\u008f\n\16\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u0097\n\17\3"+
		"\17\2\20\2\4\6\b\n\f\16\20\22\24\26\30\32\34\2\2\u009c\2\36\3\2\2\2\4"+
		"=\3\2\2\2\6?\3\2\2\2\bO\3\2\2\2\nQ\3\2\2\2\fU\3\2\2\2\16X\3\2\2\2\20["+
		"\3\2\2\2\22k\3\2\2\2\24{\3\2\2\2\26}\3\2\2\2\30\u0083\3\2\2\2\32\u008e"+
		"\3\2\2\2\34\u0096\3\2\2\2\36\37\7\16\2\2\37 \5\6\4\2 !\7\6\2\2!#\5\4\3"+
		"\2\"$\5\n\6\2#\"\3\2\2\2#$\3\2\2\2$&\3\2\2\2%\'\5\f\7\2&%\3\2\2\2&\'\3"+
		"\2\2\2\')\3\2\2\2(*\5\16\b\2)(\3\2\2\2)*\3\2\2\2*+\3\2\2\2+,\7\13\2\2"+
		",\3\3\2\2\2-\62\7\23\2\2.\60\7\4\2\2/.\3\2\2\2/\60\3\2\2\2\60\61\3\2\2"+
		"\2\61\63\7\23\2\2\62/\3\2\2\2\62\63\3\2\2\2\63>\3\2\2\2\64\65\7\23\2\2"+
		"\65\66\7\20\2\2\66;\7\23\2\2\679\7\4\2\28\67\3\2\2\289\3\2\2\29:\3\2\2"+
		"\2:<\7\23\2\2;8\3\2\2\2;<\3\2\2\2<>\3\2\2\2=-\3\2\2\2=\64\3\2\2\2>\5\3"+
		"\2\2\2?D\5\b\5\2@A\7\17\2\2AC\5\b\5\2B@\3\2\2\2CF\3\2\2\2DB\3\2\2\2DE"+
		"\3\2\2\2E\7\3\2\2\2FD\3\2\2\2GH\5\20\t\2HI\7\4\2\2IJ\7\23\2\2JK\b\5\1"+
		"\2KP\3\2\2\2LM\5\20\t\2MN\b\5\1\2NP\3\2\2\2OG\3\2\2\2OL\3\2\2\2P\t\3\2"+
		"\2\2QR\7\n\2\2RS\7\5\2\2ST\5\32\16\2T\13\3\2\2\2UV\7\t\2\2VW\5\20\t\2"+
		"W\r\3\2\2\2XY\7\3\2\2YZ\7\22\2\2Z\17\3\2\2\2[\\\5\22\n\2\\]\b\t\1\2]\21"+
		"\3\2\2\2^_\5\24\13\2_`\7\b\2\2`a\5\24\13\2ab\b\n\1\2bl\3\2\2\2cd\5\24"+
		"\13\2de\7\7\2\2ef\5\24\13\2fg\b\n\1\2gl\3\2\2\2hi\5\24\13\2ij\b\n\1\2"+
		"jl\3\2\2\2k^\3\2\2\2kc\3\2\2\2kh\3\2\2\2l\23\3\2\2\2mn\5\34\17\2no\b\13"+
		"\1\2o|\3\2\2\2pq\5\26\f\2qr\b\13\1\2r|\3\2\2\2st\5\30\r\2tu\b\13\1\2u"+
		"|\3\2\2\2vw\7\f\2\2wx\5\20\t\2xy\7\r\2\2yz\b\13\1\2z|\3\2\2\2{m\3\2\2"+
		"\2{p\3\2\2\2{s\3\2\2\2{v\3\2\2\2|\25\3\2\2\2}~\7\23\2\2~\177\7\f\2\2\177"+
		"\u0080\5\32\16\2\u0080\u0081\7\r\2\2\u0081\u0082\b\f\1\2\u0082\27\3\2"+
		"\2\2\u0083\u0084\7\22\2\2\u0084\u0085\b\r\1\2\u0085\31\3\2\2\2\u0086\u008b"+
		"\5\20\t\2\u0087\u0088\7\17\2\2\u0088\u008a\5\20\t\2\u0089\u0087\3\2\2"+
		"\2\u008a\u008d\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008f"+
		"\3\2\2\2\u008d\u008b\3\2\2\2\u008e\u0086\3\2\2\2\u008e\u008f\3\2\2\2\u008f"+
		"\33\3\2\2\2\u0090\u0091\7\23\2\2\u0091\u0097\b\17\1\2\u0092\u0093\7\23"+
		"\2\2\u0093\u0094\7\20\2\2\u0094\u0095\7\23\2\2\u0095\u0097\b\17\1\2\u0096"+
		"\u0090\3\2\2\2\u0096\u0092\3\2\2\2\u0097\35\3\2\2\2\21#&)/\628;=DOk{\u008b"+
		"\u008e\u0096";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}