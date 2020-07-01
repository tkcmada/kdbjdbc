// Generated from jp/mufg/sql/Sql.g4 by ANTLR 4.0
package jp.mufg.sql;
 
import jp.mufg.sqlutil.SqlExprs.*;
import java.util.*;

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
		T__4=10, T__3=11, T__2=12, T__1=13, T__0=14, WS=15, NUMBER=16, ID1=17, 
		ID2=18;
	public static final String[] tokenNames = {
		"<INVALID>", "'LIMIT'", "'AS'", "'BY'", "'FROM'", "'<'", "'>'", "'HAVING'", 
		"'GROUP'", "'$'", "'('", "')'", "'SELECT'", "','", "'.'", "WS", "NUMBER", 
		"ID1", "ID2"
	};
	public static final int
		RULE_selectStmt = 0, RULE_table = 1, RULE_columnNames = 2, RULE_columnName = 3, 
		RULE_groupBy = 4, RULE_having = 5, RULE_limit = 6, RULE_expr = 7, RULE_compExpr = 8, 
		RULE_primaryExpr = 9, RULE_functionExpr = 10, RULE_numberExpr = 11, RULE_args = 12, 
		RULE_columnExpr = 13, RULE_name = 14;
	public static final String[] ruleNames = {
		"selectStmt", "table", "columnNames", "columnName", "groupBy", "having", 
		"limit", "expr", "compExpr", "primaryExpr", "functionExpr", "numberExpr", 
		"args", "columnExpr", "name"
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
		public TableContext table() {
			return getRuleContext(TableContext.class,0);
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
			setState(30); match(12);
			setState(31); columnNames();
			setState(32); match(4);
			setState(33); table();
			setState(35);
			_la = _input.LA(1);
			if (_la==8) {
				{
				setState(34); groupBy();
				}
			}

			setState(38);
			_la = _input.LA(1);
			if (_la==7) {
				{
				setState(37); having();
				}
			}

			setState(41);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(40); limit();
				}
			}

			setState(43); match(9);
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

	public static class TableContext extends ParserRuleContext {
		public Table tbl;
		public NameContext t;
		public NameContext a;
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public TableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_table; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterTable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitTable(this);
		}
	}

	public final TableContext table() throws RecognitionException {
		TableContext _localctx = new TableContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_table);
		int _la;
		try {
			setState(65);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(45); ((TableContext)_localctx).t = name();
				setState(50);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << ID1) | (1L << ID2))) != 0)) {
					{
					setState(47);
					_la = _input.LA(1);
					if (_la==2) {
						{
						setState(46); match(2);
						}
					}

					setState(49); ((TableContext)_localctx).a = name();
					}
				}

				 ((TableContext)_localctx).tbl =  new Table(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(54); name();
				setState(55); match(14);
				setState(56); ((TableContext)_localctx).t = name();
				setState(61);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << ID1) | (1L << ID2))) != 0)) {
					{
					setState(58);
					_la = _input.LA(1);
					if (_la==2) {
						{
						setState(57); match(2);
						}
					}

					setState(60); ((TableContext)_localctx).a = name();
					}
				}

				 ((TableContext)_localctx).tbl =  new Table(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
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
		public List<ColumnExprWithAlias> columns;
		public ColumnNameContext c1;
		public ColumnNameContext c2;
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
			setState(67); ((ColumnNamesContext)_localctx).c1 = columnName();
			 ((ColumnNamesContext)_localctx).columns =  new LinkedList<ColumnExprWithAlias>(); _localctx.columns.add(((ColumnNamesContext)_localctx).c1.val); 
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==13) {
				{
				{
				setState(69); match(13);
				setState(70); ((ColumnNamesContext)_localctx).c2 = columnName();
				 _localctx.columns.add(((ColumnNamesContext)_localctx).c2.val); 
				}
				}
				setState(77);
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
		public NameContext id;
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
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
		try {
			setState(86);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(78); ((ColumnNameContext)_localctx).expr = expr();
				setState(79); match(2);
				setState(80); ((ColumnNameContext)_localctx).id = name();
				 ((ColumnNameContext)_localctx).val =  new ColumnExprWithAlias(((ColumnNameContext)_localctx).expr.val, ((ColumnNameContext)_localctx).id.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(83); ((ColumnNameContext)_localctx).expr = expr();
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
			setState(88); match(8);
			setState(89); match(3);
			setState(90); args();
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
			setState(92); match(7);
			setState(93); expr();
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
			setState(95); match(1);
			setState(96); match(NUMBER);
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
			setState(98); ((ExprContext)_localctx).compExpr = compExpr();
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
		public Token op;
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
		int _la;
		try {
			setState(109);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(101); ((CompExprContext)_localctx).lhs = primaryExpr();
				setState(102);
				((CompExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==5 || _la==6) ) {
					((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(103); ((CompExprContext)_localctx).rhs = primaryExpr();
				 ((CompExprContext)_localctx).val =  new BinaryExpr((((CompExprContext)_localctx).op!=null?((CompExprContext)_localctx).op.getText():null), ((CompExprContext)_localctx).lhs.val, ((CompExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(106); ((CompExprContext)_localctx).lhs = primaryExpr();
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
			setState(125);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(111); ((PrimaryExprContext)_localctx).e1 = columnExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).e1.val; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114); ((PrimaryExprContext)_localctx).functionExpr = functionExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).functionExpr.val; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(117); ((PrimaryExprContext)_localctx).numberExpr = numberExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).numberExpr.val; 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(120); match(10);
				setState(121); ((PrimaryExprContext)_localctx).expr = expr();
				setState(122); match(11);
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
		public NameContext id;
		public ArgsContext args;
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public NameContext name() {
			return getRuleContext(NameContext.class,0);
		}
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
			setState(127); ((FunctionExprContext)_localctx).id = name();
			setState(128); match(10);
			setState(129); ((FunctionExprContext)_localctx).args = args();
			setState(130); match(11);
			 ((FunctionExprContext)_localctx).val =  new FunctionCallExpr(((FunctionExprContext)_localctx).id.text, ((FunctionExprContext)_localctx).args.val); 
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
			setState(133); ((NumberExprContext)_localctx).numtk = match(NUMBER);
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
		public Arguments val;
		public ExprContext e1;
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
			 List<Expr> _args = new ArrayList<Expr>(); 
			setState(148);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 10) | (1L << NUMBER) | (1L << ID1) | (1L << ID2))) != 0)) {
				{
				setState(137); ((ArgsContext)_localctx).e1 = expr();
				 _args.add(((ArgsContext)_localctx).e1.val); 
				setState(145);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==13) {
					{
					{
					setState(139); match(13);
					setState(140); expr();
					 _args.add(((ArgsContext)_localctx).e1.val); 
					}
					}
					setState(147);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			 ((ArgsContext)_localctx).val =  new Arguments(_args); 
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
		public NameContext id2;
		public NameContext id1;
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
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
			setState(160);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(152); ((ColumnExprContext)_localctx).id2 = name();
				 ((ColumnExprContext)_localctx).val =  new ColumnExpr(null,      ((ColumnExprContext)_localctx).id2.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155); ((ColumnExprContext)_localctx).id1 = name();
				setState(156); match(14);
				setState(157); ((ColumnExprContext)_localctx).id2 = name();
				 ((ColumnExprContext)_localctx).val =  new ColumnExpr(((ColumnExprContext)_localctx).id1.text, ((ColumnExprContext)_localctx).id2.text); 
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

	public static class NameContext extends ParserRuleContext {
		public String text;
		public Token ID1;
		public Token ID2;
		public TerminalNode ID2() { return getToken(SqlParser.ID2, 0); }
		public TerminalNode ID1() { return getToken(SqlParser.ID1, 0); }
		public NameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_name; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitName(this);
		}
	}

	public final NameContext name() throws RecognitionException {
		NameContext _localctx = new NameContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_name);
		try {
			setState(166);
			switch (_input.LA(1)) {
			case ID1:
				enterOuterAlt(_localctx, 1);
				{
				setState(162); ((NameContext)_localctx).ID1 = match(ID1);
				 ((NameContext)_localctx).text =  (((NameContext)_localctx).ID1!=null?((NameContext)_localctx).ID1.getText():null); 
				}
				break;
			case ID2:
				enterOuterAlt(_localctx, 2);
				{
				setState(164); ((NameContext)_localctx).ID2 = match(ID2);
				 String s = (((NameContext)_localctx).ID2!=null?((NameContext)_localctx).ID2.getText():null); ((NameContext)_localctx).text =  s.substring(1, s.length()-1); 
				}
				break;
			default:
				throw new NoViableAltException(this);
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
		"\2\3\24\u00ab\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\3\2\3\2\3\2\3\2\3\2\5\2&\n\2\3\2\5\2)\n\2\3\2\5\2,\n\2\3\2\3\2\3\3"+
		"\3\3\5\3\62\n\3\3\3\5\3\65\n\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3=\n\3\3\3\5"+
		"\3@\n\3\3\3\3\3\5\3D\n\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4L\n\4\f\4\16\4O\13"+
		"\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5Y\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3"+
		"\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\np\n\n\3"+
		"\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u0080\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\7\16\u0092\n\16\f\16\16\16\u0095\13\16\5\16\u0097\n\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00a3\n\17\3\20"+
		"\3\20\3\20\3\20\5\20\u00a9\n\20\3\20\2\21\2\4\6\b\n\f\16\20\22\24\26\30"+
		"\32\34\36\2\3\3\7\b\u00ad\2 \3\2\2\2\4C\3\2\2\2\6E\3\2\2\2\bX\3\2\2\2"+
		"\nZ\3\2\2\2\f^\3\2\2\2\16a\3\2\2\2\20d\3\2\2\2\22o\3\2\2\2\24\177\3\2"+
		"\2\2\26\u0081\3\2\2\2\30\u0087\3\2\2\2\32\u008a\3\2\2\2\34\u00a2\3\2\2"+
		"\2\36\u00a8\3\2\2\2 !\7\16\2\2!\"\5\6\4\2\"#\7\6\2\2#%\5\4\3\2$&\5\n\6"+
		"\2%$\3\2\2\2%&\3\2\2\2&(\3\2\2\2\')\5\f\7\2(\'\3\2\2\2()\3\2\2\2)+\3\2"+
		"\2\2*,\5\16\b\2+*\3\2\2\2+,\3\2\2\2,-\3\2\2\2-.\7\13\2\2.\3\3\2\2\2/\64"+
		"\5\36\20\2\60\62\7\4\2\2\61\60\3\2\2\2\61\62\3\2\2\2\62\63\3\2\2\2\63"+
		"\65\5\36\20\2\64\61\3\2\2\2\64\65\3\2\2\2\65\66\3\2\2\2\66\67\b\3\1\2"+
		"\67D\3\2\2\289\5\36\20\29:\7\20\2\2:?\5\36\20\2;=\7\4\2\2<;\3\2\2\2<="+
		"\3\2\2\2=>\3\2\2\2>@\5\36\20\2?<\3\2\2\2?@\3\2\2\2@A\3\2\2\2AB\b\3\1\2"+
		"BD\3\2\2\2C/\3\2\2\2C8\3\2\2\2D\5\3\2\2\2EF\5\b\5\2FM\b\4\1\2GH\7\17\2"+
		"\2HI\5\b\5\2IJ\b\4\1\2JL\3\2\2\2KG\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2"+
		"\2N\7\3\2\2\2OM\3\2\2\2PQ\5\20\t\2QR\7\4\2\2RS\5\36\20\2ST\b\5\1\2TY\3"+
		"\2\2\2UV\5\20\t\2VW\b\5\1\2WY\3\2\2\2XP\3\2\2\2XU\3\2\2\2Y\t\3\2\2\2Z"+
		"[\7\n\2\2[\\\7\5\2\2\\]\5\32\16\2]\13\3\2\2\2^_\7\t\2\2_`\5\20\t\2`\r"+
		"\3\2\2\2ab\7\3\2\2bc\7\22\2\2c\17\3\2\2\2de\5\22\n\2ef\b\t\1\2f\21\3\2"+
		"\2\2gh\5\24\13\2hi\t\2\2\2ij\5\24\13\2jk\b\n\1\2kp\3\2\2\2lm\5\24\13\2"+
		"mn\b\n\1\2np\3\2\2\2og\3\2\2\2ol\3\2\2\2p\23\3\2\2\2qr\5\34\17\2rs\b\13"+
		"\1\2s\u0080\3\2\2\2tu\5\26\f\2uv\b\13\1\2v\u0080\3\2\2\2wx\5\30\r\2xy"+
		"\b\13\1\2y\u0080\3\2\2\2z{\7\f\2\2{|\5\20\t\2|}\7\r\2\2}~\b\13\1\2~\u0080"+
		"\3\2\2\2\177q\3\2\2\2\177t\3\2\2\2\177w\3\2\2\2\177z\3\2\2\2\u0080\25"+
		"\3\2\2\2\u0081\u0082\5\36\20\2\u0082\u0083\7\f\2\2\u0083\u0084\5\32\16"+
		"\2\u0084\u0085\7\r\2\2\u0085\u0086\b\f\1\2\u0086\27\3\2\2\2\u0087\u0088"+
		"\7\22\2\2\u0088\u0089\b\r\1\2\u0089\31\3\2\2\2\u008a\u0096\b\16\1\2\u008b"+
		"\u008c\5\20\t\2\u008c\u0093\b\16\1\2\u008d\u008e\7\17\2\2\u008e\u008f"+
		"\5\20\t\2\u008f\u0090\b\16\1\2\u0090\u0092\3\2\2\2\u0091\u008d\3\2\2\2"+
		"\u0092\u0095\3\2\2\2\u0093\u0091\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0097"+
		"\3\2\2\2\u0095\u0093\3\2\2\2\u0096\u008b\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0098\3\2\2\2\u0098\u0099\b\16\1\2\u0099\33\3\2\2\2\u009a\u009b\5\36"+
		"\20\2\u009b\u009c\b\17\1\2\u009c\u00a3\3\2\2\2\u009d\u009e\5\36\20\2\u009e"+
		"\u009f\7\20\2\2\u009f\u00a0\5\36\20\2\u00a0\u00a1\b\17\1\2\u00a1\u00a3"+
		"\3\2\2\2\u00a2\u009a\3\2\2\2\u00a2\u009d\3\2\2\2\u00a3\35\3\2\2\2\u00a4"+
		"\u00a5\7\23\2\2\u00a5\u00a9\b\20\1\2\u00a6\u00a7\7\24\2\2\u00a7\u00a9"+
		"\b\20\1\2\u00a8\u00a4\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a9\37\3\2\2\2\22"+
		"%(+\61\64<?CMXo\177\u0093\u0096\u00a2\u00a8";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}