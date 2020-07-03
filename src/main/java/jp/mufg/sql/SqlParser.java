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
		T__24=1, T__23=2, T__22=3, T__21=4, T__20=5, T__19=6, T__18=7, T__17=8, 
		T__16=9, T__15=10, T__14=11, T__13=12, T__12=13, T__11=14, T__10=15, T__9=16, 
		T__8=17, T__7=18, T__6=19, T__5=20, T__4=21, T__3=22, T__2=23, T__1=24, 
		T__0=25, WS=26, NUMBER=27, ID1=28, ID2=29, STR=30;
	public static final String[] tokenNames = {
		"<INVALID>", "'LIMIT'", "'AS'", "'BY'", "'FROM'", "'WHERE'", "'!='", "'AND'", 
		"'='", "'<='", "'GROUP'", "'$'", "'('", "'SELECT'", "','", "'.'", "'>='", 
		"'<'", "'>'", "'OR'", "'or'", "'HAVING'", "'IN'", "'in'", "')'", "'and'", 
		"WS", "NUMBER", "ID1", "ID2", "STR"
	};
	public static final int
		RULE_selectStmt = 0, RULE_table = 1, RULE_columnNames = 2, RULE_columnName = 3, 
		RULE_where = 4, RULE_groupBy = 5, RULE_having = 6, RULE_limit = 7, RULE_expr = 8, 
		RULE_orExpr = 9, RULE_andExpr = 10, RULE_eqExpr = 11, RULE_compExpr = 12, 
		RULE_primaryExpr = 13, RULE_functionExpr = 14, RULE_numberExpr = 15, RULE_stringExpr = 16, 
		RULE_groupargs = 17, RULE_args = 18, RULE_columnExpr = 19, RULE_name = 20, 
		RULE_str = 21, RULE_pint = 22;
	public static final String[] ruleNames = {
		"selectStmt", "table", "columnNames", "columnName", "where", "groupBy", 
		"having", "limit", "expr", "orExpr", "andExpr", "eqExpr", "compExpr", 
		"primaryExpr", "functionExpr", "numberExpr", "stringExpr", "groupargs", 
		"args", "columnExpr", "name", "str", "pint"
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
		public WhereContext where() {
			return getRuleContext(WhereContext.class,0);
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
			setState(46); match(13);
			setState(47); columnNames();
			setState(48); match(4);
			setState(49); table();
			setState(51);
			_la = _input.LA(1);
			if (_la==5) {
				{
				setState(50); where();
				}
			}

			setState(54);
			_la = _input.LA(1);
			if (_la==10) {
				{
				setState(53); groupBy();
				}
			}

			setState(57);
			_la = _input.LA(1);
			if (_la==21) {
				{
				setState(56); having();
				}
			}

			setState(60);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(59); limit();
				}
			}

			setState(62); match(11);
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
		try {
			setState(94);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(64); ((TableContext)_localctx).t = name();
				setState(65); match(2);
				setState(66); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).tbl =  new Table(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(69); ((TableContext)_localctx).t = name();
				setState(70); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).tbl =  new Table(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(73); ((TableContext)_localctx).t = name();
				 ((TableContext)_localctx).tbl =  new Table(((TableContext)_localctx).t.text, null   ); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(76); name();
				setState(77); match(15);
				setState(78); ((TableContext)_localctx).t = name();
				setState(79); match(2);
				setState(80); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).tbl =  new Table(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(83); name();
				setState(84); match(15);
				setState(85); ((TableContext)_localctx).t = name();
				setState(86); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).tbl =  new Table(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(89); name();
				setState(90); match(15);
				setState(91); ((TableContext)_localctx).t = name();
				 ((TableContext)_localctx).tbl =  new Table(((TableContext)_localctx).t.text, null   ); 
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
			setState(96); ((ColumnNamesContext)_localctx).c1 = columnName();
			 ((ColumnNamesContext)_localctx).columns =  new LinkedList<ColumnExprWithAlias>(); _localctx.columns.add(((ColumnNamesContext)_localctx).c1.val); 
			setState(104);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==14) {
				{
				{
				setState(98); match(14);
				setState(99); ((ColumnNamesContext)_localctx).c2 = columnName();
				 _localctx.columns.add(((ColumnNamesContext)_localctx).c2.val); 
				}
				}
				setState(106);
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
			setState(115);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(107); ((ColumnNameContext)_localctx).expr = expr();
				setState(108); match(2);
				setState(109); ((ColumnNameContext)_localctx).id = name();
				 ((ColumnNameContext)_localctx).val =  new ColumnExprWithAlias(((ColumnNameContext)_localctx).expr.val, ((ColumnNameContext)_localctx).id.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(112); ((ColumnNameContext)_localctx).expr = expr();
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

	public static class WhereContext extends ParserRuleContext {
		public Expr val;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhereContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_where; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterWhere(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitWhere(this);
		}
	}

	public final WhereContext where() throws RecognitionException {
		WhereContext _localctx = new WhereContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_where);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117); match(5);
			setState(118); ((WhereContext)_localctx).expr = expr();
			 ((WhereContext)_localctx).val =  ((WhereContext)_localctx).expr.val; 
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
		public GroupargsContext groupargs() {
			return getRuleContext(GroupargsContext.class,0);
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
		enterRule(_localctx, 10, RULE_groupBy);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121); match(10);
			setState(122); match(3);
			setState(123); groupargs();
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
		enterRule(_localctx, 12, RULE_having);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(125); match(21);
			setState(126); expr();
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
		public PintContext pint() {
			return getRuleContext(PintContext.class,0);
		}
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
		enterRule(_localctx, 14, RULE_limit);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128); match(1);
			setState(129); pint();
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
		public OrExprContext lhs;
		public OrExprContext orExpr() {
			return getRuleContext(OrExprContext.class,0);
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
		enterRule(_localctx, 16, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(131); ((ExprContext)_localctx).lhs = orExpr();
			 ((ExprContext)_localctx).val =  ((ExprContext)_localctx).lhs.val; 
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

	public static class OrExprContext extends ParserRuleContext {
		public Expr val;
		public AndExprContext lhs;
		public Token op;
		public AndExprContext rhs;
		public AndExprContext andExpr(int i) {
			return getRuleContext(AndExprContext.class,i);
		}
		public List<AndExprContext> andExpr() {
			return getRuleContexts(AndExprContext.class);
		}
		public OrExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitOrExpr(this);
		}
	}

	public final OrExprContext orExpr() throws RecognitionException {
		OrExprContext _localctx = new OrExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_orExpr);
		int _la;
		try {
			setState(142);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(134); ((OrExprContext)_localctx).lhs = andExpr();
				setState(135);
				((OrExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==19 || _la==20) ) {
					((OrExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(136); ((OrExprContext)_localctx).rhs = andExpr();
				 ((OrExprContext)_localctx).val =  new BinaryExpr((((OrExprContext)_localctx).op!=null?((OrExprContext)_localctx).op.getText():null), ((OrExprContext)_localctx).lhs.val, ((OrExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(139); ((OrExprContext)_localctx).lhs = andExpr();
				 ((OrExprContext)_localctx).val =  ((OrExprContext)_localctx).lhs.val; 
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

	public static class AndExprContext extends ParserRuleContext {
		public Expr val;
		public EqExprContext lhs;
		public Token op;
		public EqExprContext rhs;
		public List<EqExprContext> eqExpr() {
			return getRuleContexts(EqExprContext.class);
		}
		public EqExprContext eqExpr(int i) {
			return getRuleContext(EqExprContext.class,i);
		}
		public AndExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_andExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitAndExpr(this);
		}
	}

	public final AndExprContext andExpr() throws RecognitionException {
		AndExprContext _localctx = new AndExprContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_andExpr);
		int _la;
		try {
			setState(152);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144); ((AndExprContext)_localctx).lhs = eqExpr();
				setState(145);
				((AndExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==7 || _la==25) ) {
					((AndExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(146); ((AndExprContext)_localctx).rhs = eqExpr();
				 ((AndExprContext)_localctx).val =  new BinaryExpr((((AndExprContext)_localctx).op!=null?((AndExprContext)_localctx).op.getText():null), ((AndExprContext)_localctx).lhs.val, ((AndExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149); ((AndExprContext)_localctx).lhs = eqExpr();
				 ((AndExprContext)_localctx).val =  ((AndExprContext)_localctx).lhs.val; 
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

	public static class EqExprContext extends ParserRuleContext {
		public Expr val;
		public CompExprContext lhs;
		public Token op;
		public CompExprContext rhs;
		public ArgsContext a;
		public ArgsContext args() {
			return getRuleContext(ArgsContext.class,0);
		}
		public CompExprContext compExpr(int i) {
			return getRuleContext(CompExprContext.class,i);
		}
		public List<CompExprContext> compExpr() {
			return getRuleContexts(CompExprContext.class);
		}
		public EqExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_eqExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterEqExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitEqExpr(this);
		}
	}

	public final EqExprContext eqExpr() throws RecognitionException {
		EqExprContext _localctx = new EqExprContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_eqExpr);
		int _la;
		try {
			setState(172);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(154); ((EqExprContext)_localctx).lhs = compExpr();
				setState(155); ((EqExprContext)_localctx).op = match(8);
				setState(156); ((EqExprContext)_localctx).rhs = compExpr();
				 ((EqExprContext)_localctx).val =  new EqExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).rhs.val);  
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159); ((EqExprContext)_localctx).lhs = compExpr();
				setState(160);
				((EqExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==22 || _la==23) ) {
					((EqExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(161); ((EqExprContext)_localctx).a = args();
				 ((EqExprContext)_localctx).val =  new EqExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).a.val); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(164); ((EqExprContext)_localctx).lhs = compExpr();
				setState(165); ((EqExprContext)_localctx).op = match(6);
				setState(166); ((EqExprContext)_localctx).rhs = compExpr();
				 ((EqExprContext)_localctx).val =  new BinaryExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).rhs.val);  
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(169); ((EqExprContext)_localctx).lhs = compExpr();
				 ((EqExprContext)_localctx).val =  ((EqExprContext)_localctx).lhs.val; 
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
		enterRule(_localctx, 24, RULE_compExpr);
		int _la;
		try {
			setState(182);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(174); ((CompExprContext)_localctx).lhs = primaryExpr();
				setState(175);
				((CompExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 9) | (1L << 16) | (1L << 17) | (1L << 18))) != 0)) ) {
					((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(176); ((CompExprContext)_localctx).rhs = primaryExpr();
				 ((CompExprContext)_localctx).val =  new BinaryExpr((((CompExprContext)_localctx).op!=null?((CompExprContext)_localctx).op.getText():null), ((CompExprContext)_localctx).lhs.val, ((CompExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(179); ((CompExprContext)_localctx).lhs = primaryExpr();
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
		public StringExprContext stringExpr;
		public ExprContext expr;
		public StringExprContext stringExpr() {
			return getRuleContext(StringExprContext.class,0);
		}
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
		enterRule(_localctx, 26, RULE_primaryExpr);
		try {
			setState(201);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(184); ((PrimaryExprContext)_localctx).e1 = columnExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).e1.val; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(187); ((PrimaryExprContext)_localctx).functionExpr = functionExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).functionExpr.val; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(190); ((PrimaryExprContext)_localctx).numberExpr = numberExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).numberExpr.val; 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(193); ((PrimaryExprContext)_localctx).stringExpr = stringExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).stringExpr.val; 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(196); match(12);
				setState(197); ((PrimaryExprContext)_localctx).expr = expr();
				setState(198); match(24);
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
		enterRule(_localctx, 28, RULE_functionExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203); ((FunctionExprContext)_localctx).id = name();
			setState(204); match(12);
			setState(205); ((FunctionExprContext)_localctx).args = args();
			setState(206); match(24);
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
		enterRule(_localctx, 30, RULE_numberExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(209); ((NumberExprContext)_localctx).numtk = match(NUMBER);
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

	public static class StringExprContext extends ParserRuleContext {
		public StringExpr val;
		public StrContext str;
		public StrContext str() {
			return getRuleContext(StrContext.class,0);
		}
		public StringExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterStringExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitStringExpr(this);
		}
	}

	public final StringExprContext stringExpr() throws RecognitionException {
		StringExprContext _localctx = new StringExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_stringExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(212); ((StringExprContext)_localctx).str = str();
			 ((StringExprContext)_localctx).val =  new StringExpr(((StringExprContext)_localctx).str.text); 
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

	public static class GroupargsContext extends ParserRuleContext {
		public List<Integer> val;
		public PintContext e1;
		public PintContext e2;
		public PintContext pint(int i) {
			return getRuleContext(PintContext.class,i);
		}
		public List<PintContext> pint() {
			return getRuleContexts(PintContext.class);
		}
		public GroupargsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_groupargs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterGroupargs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitGroupargs(this);
		}
	}

	public final GroupargsContext groupargs() throws RecognitionException {
		GroupargsContext _localctx = new GroupargsContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_groupargs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Integer> _args = new ArrayList<Integer>(); 
			setState(227);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(216); ((GroupargsContext)_localctx).e1 = pint();
				 _args.add(((GroupargsContext)_localctx).e1.val); 
				setState(224);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==14) {
					{
					{
					setState(218); match(14);
					setState(219); ((GroupargsContext)_localctx).e2 = pint();
					 _args.add(((GroupargsContext)_localctx).e2.val); 
					}
					}
					setState(226);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			 ((GroupargsContext)_localctx).val =  _args; 
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
		public ExprContext e2;
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
		enterRule(_localctx, 36, RULE_args);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			 List<Expr> _args = new ArrayList<Expr>(); 
			setState(243);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << NUMBER) | (1L << ID1) | (1L << ID2) | (1L << STR))) != 0)) {
				{
				setState(232); ((ArgsContext)_localctx).e1 = expr();
				 _args.add(((ArgsContext)_localctx).e1.val); 
				setState(240);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
				while ( _alt!=2 && _alt!=-1 ) {
					if ( _alt==1 ) {
						{
						{
						setState(234); match(14);
						setState(235); ((ArgsContext)_localctx).e2 = expr();
						 _args.add(((ArgsContext)_localctx).e2.val); 
						}
						} 
					}
					setState(242);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
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
		enterRule(_localctx, 38, RULE_columnExpr);
		try {
			setState(255);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(247); ((ColumnExprContext)_localctx).id2 = name();
				 ((ColumnExprContext)_localctx).val =  new ColumnExpr(null,      ((ColumnExprContext)_localctx).id2.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(250); ((ColumnExprContext)_localctx).id1 = name();
				setState(251); match(15);
				setState(252); ((ColumnExprContext)_localctx).id2 = name();
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
		enterRule(_localctx, 40, RULE_name);
		try {
			setState(261);
			switch (_input.LA(1)) {
			case ID1:
				enterOuterAlt(_localctx, 1);
				{
				setState(257); ((NameContext)_localctx).ID1 = match(ID1);
				 ((NameContext)_localctx).text =  (((NameContext)_localctx).ID1!=null?((NameContext)_localctx).ID1.getText():null); 
				}
				break;
			case ID2:
				enterOuterAlt(_localctx, 2);
				{
				setState(259); ((NameContext)_localctx).ID2 = match(ID2);
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

	public static class StrContext extends ParserRuleContext {
		public String text;
		public Token STR;
		public TerminalNode STR() { return getToken(SqlParser.STR, 0); }
		public StrContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_str; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterStr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitStr(this);
		}
	}

	public final StrContext str() throws RecognitionException {
		StrContext _localctx = new StrContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_str);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263); ((StrContext)_localctx).STR = match(STR);
			 String s = (((StrContext)_localctx).STR!=null?((StrContext)_localctx).STR.getText():null); ((StrContext)_localctx).text =  s.substring(1, s.length()-1); 
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

	public static class PintContext extends ParserRuleContext {
		public int val;
		public Token num;
		public TerminalNode NUMBER() { return getToken(SqlParser.NUMBER, 0); }
		public PintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pint; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterPint(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitPint(this);
		}
	}

	public final PintContext pint() throws RecognitionException {
		PintContext _localctx = new PintContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_pint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266); ((PintContext)_localctx).num = match(NUMBER);
			 ((PintContext)_localctx).val =  Integer.parseInt((((PintContext)_localctx).num!=null?((PintContext)_localctx).num.getText():null)); 
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
		"\2\3 \u0110\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\3\2\3\2\3\2\3\2\3\2\5\2\66\n\2\3\2\5\29\n\2\3\2\5\2<\n\2\3"+
		"\2\5\2?\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\5\3a\n\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4i\n\4\f\4\16\4l\13\4\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\5\5v\n\5\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5"+
		"\13\u0091\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u009b\n\f\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00af"+
		"\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00b9\n\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00cc\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00e1\n\23\f\23\16"+
		"\23\u00e4\13\23\5\23\u00e6\n\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24"+
		"\3\24\7\24\u00f1\n\24\f\24\16\24\u00f4\13\24\5\24\u00f6\n\24\3\24\3\24"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25\u0102\n\25\3\26\3\26\3\26"+
		"\3\26\5\26\u0108\n\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\2\31\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\6\3\25\26\4\t\t\33\33\3\30"+
		"\31\4\13\13\22\24\u0113\2\60\3\2\2\2\4`\3\2\2\2\6b\3\2\2\2\bu\3\2\2\2"+
		"\nw\3\2\2\2\f{\3\2\2\2\16\177\3\2\2\2\20\u0082\3\2\2\2\22\u0085\3\2\2"+
		"\2\24\u0090\3\2\2\2\26\u009a\3\2\2\2\30\u00ae\3\2\2\2\32\u00b8\3\2\2\2"+
		"\34\u00cb\3\2\2\2\36\u00cd\3\2\2\2 \u00d3\3\2\2\2\"\u00d6\3\2\2\2$\u00d9"+
		"\3\2\2\2&\u00e9\3\2\2\2(\u0101\3\2\2\2*\u0107\3\2\2\2,\u0109\3\2\2\2."+
		"\u010c\3\2\2\2\60\61\7\17\2\2\61\62\5\6\4\2\62\63\7\6\2\2\63\65\5\4\3"+
		"\2\64\66\5\n\6\2\65\64\3\2\2\2\65\66\3\2\2\2\668\3\2\2\2\679\5\f\7\28"+
		"\67\3\2\2\289\3\2\2\29;\3\2\2\2:<\5\16\b\2;:\3\2\2\2;<\3\2\2\2<>\3\2\2"+
		"\2=?\5\20\t\2>=\3\2\2\2>?\3\2\2\2?@\3\2\2\2@A\7\r\2\2A\3\3\2\2\2BC\5*"+
		"\26\2CD\7\4\2\2DE\5*\26\2EF\b\3\1\2Fa\3\2\2\2GH\5*\26\2HI\5*\26\2IJ\b"+
		"\3\1\2Ja\3\2\2\2KL\5*\26\2LM\b\3\1\2Ma\3\2\2\2NO\5*\26\2OP\7\21\2\2PQ"+
		"\5*\26\2QR\7\4\2\2RS\5*\26\2ST\b\3\1\2Ta\3\2\2\2UV\5*\26\2VW\7\21\2\2"+
		"WX\5*\26\2XY\5*\26\2YZ\b\3\1\2Za\3\2\2\2[\\\5*\26\2\\]\7\21\2\2]^\5*\26"+
		"\2^_\b\3\1\2_a\3\2\2\2`B\3\2\2\2`G\3\2\2\2`K\3\2\2\2`N\3\2\2\2`U\3\2\2"+
		"\2`[\3\2\2\2a\5\3\2\2\2bc\5\b\5\2cj\b\4\1\2de\7\20\2\2ef\5\b\5\2fg\b\4"+
		"\1\2gi\3\2\2\2hd\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2k\7\3\2\2\2lj\3"+
		"\2\2\2mn\5\22\n\2no\7\4\2\2op\5*\26\2pq\b\5\1\2qv\3\2\2\2rs\5\22\n\2s"+
		"t\b\5\1\2tv\3\2\2\2um\3\2\2\2ur\3\2\2\2v\t\3\2\2\2wx\7\7\2\2xy\5\22\n"+
		"\2yz\b\6\1\2z\13\3\2\2\2{|\7\f\2\2|}\7\5\2\2}~\5$\23\2~\r\3\2\2\2\177"+
		"\u0080\7\27\2\2\u0080\u0081\5\22\n\2\u0081\17\3\2\2\2\u0082\u0083\7\3"+
		"\2\2\u0083\u0084\5.\30\2\u0084\21\3\2\2\2\u0085\u0086\5\24\13\2\u0086"+
		"\u0087\b\n\1\2\u0087\23\3\2\2\2\u0088\u0089\5\26\f\2\u0089\u008a\t\2\2"+
		"\2\u008a\u008b\5\26\f\2\u008b\u008c\b\13\1\2\u008c\u0091\3\2\2\2\u008d"+
		"\u008e\5\26\f\2\u008e\u008f\b\13\1\2\u008f\u0091\3\2\2\2\u0090\u0088\3"+
		"\2\2\2\u0090\u008d\3\2\2\2\u0091\25\3\2\2\2\u0092\u0093\5\30\r\2\u0093"+
		"\u0094\t\3\2\2\u0094\u0095\5\30\r\2\u0095\u0096\b\f\1\2\u0096\u009b\3"+
		"\2\2\2\u0097\u0098\5\30\r\2\u0098\u0099\b\f\1\2\u0099\u009b\3\2\2\2\u009a"+
		"\u0092\3\2\2\2\u009a\u0097\3\2\2\2\u009b\27\3\2\2\2\u009c\u009d\5\32\16"+
		"\2\u009d\u009e\7\n\2\2\u009e\u009f\5\32\16\2\u009f\u00a0\b\r\1\2\u00a0"+
		"\u00af\3\2\2\2\u00a1\u00a2\5\32\16\2\u00a2\u00a3\t\4\2\2\u00a3\u00a4\5"+
		"&\24\2\u00a4\u00a5\b\r\1\2\u00a5\u00af\3\2\2\2\u00a6\u00a7\5\32\16\2\u00a7"+
		"\u00a8\7\b\2\2\u00a8\u00a9\5\32\16\2\u00a9\u00aa\b\r\1\2\u00aa\u00af\3"+
		"\2\2\2\u00ab\u00ac\5\32\16\2\u00ac\u00ad\b\r\1\2\u00ad\u00af\3\2\2\2\u00ae"+
		"\u009c\3\2\2\2\u00ae\u00a1\3\2\2\2\u00ae\u00a6\3\2\2\2\u00ae\u00ab\3\2"+
		"\2\2\u00af\31\3\2\2\2\u00b0\u00b1\5\34\17\2\u00b1\u00b2\t\5\2\2\u00b2"+
		"\u00b3\5\34\17\2\u00b3\u00b4\b\16\1\2\u00b4\u00b9\3\2\2\2\u00b5\u00b6"+
		"\5\34\17\2\u00b6\u00b7\b\16\1\2\u00b7\u00b9\3\2\2\2\u00b8\u00b0\3\2\2"+
		"\2\u00b8\u00b5\3\2\2\2\u00b9\33\3\2\2\2\u00ba\u00bb\5(\25\2\u00bb\u00bc"+
		"\b\17\1\2\u00bc\u00cc\3\2\2\2\u00bd\u00be\5\36\20\2\u00be\u00bf\b\17\1"+
		"\2\u00bf\u00cc\3\2\2\2\u00c0\u00c1\5 \21\2\u00c1\u00c2\b\17\1\2\u00c2"+
		"\u00cc\3\2\2\2\u00c3\u00c4\5\"\22\2\u00c4\u00c5\b\17\1\2\u00c5\u00cc\3"+
		"\2\2\2\u00c6\u00c7\7\16\2\2\u00c7\u00c8\5\22\n\2\u00c8\u00c9\7\32\2\2"+
		"\u00c9\u00ca\b\17\1\2\u00ca\u00cc\3\2\2\2\u00cb\u00ba\3\2\2\2\u00cb\u00bd"+
		"\3\2\2\2\u00cb\u00c0\3\2\2\2\u00cb\u00c3\3\2\2\2\u00cb\u00c6\3\2\2\2\u00cc"+
		"\35\3\2\2\2\u00cd\u00ce\5*\26\2\u00ce\u00cf\7\16\2\2\u00cf\u00d0\5&\24"+
		"\2\u00d0\u00d1\7\32\2\2\u00d1\u00d2\b\20\1\2\u00d2\37\3\2\2\2\u00d3\u00d4"+
		"\7\35\2\2\u00d4\u00d5\b\21\1\2\u00d5!\3\2\2\2\u00d6\u00d7\5,\27\2\u00d7"+
		"\u00d8\b\22\1\2\u00d8#\3\2\2\2\u00d9\u00e5\b\23\1\2\u00da\u00db\5.\30"+
		"\2\u00db\u00e2\b\23\1\2\u00dc\u00dd\7\20\2\2\u00dd\u00de\5.\30\2\u00de"+
		"\u00df\b\23\1\2\u00df\u00e1\3\2\2\2\u00e0\u00dc\3\2\2\2\u00e1\u00e4\3"+
		"\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e6\3\2\2\2\u00e4"+
		"\u00e2\3\2\2\2\u00e5\u00da\3\2\2\2\u00e5\u00e6\3\2\2\2\u00e6\u00e7\3\2"+
		"\2\2\u00e7\u00e8\b\23\1\2\u00e8%\3\2\2\2\u00e9\u00f5\b\24\1\2\u00ea\u00eb"+
		"\5\22\n\2\u00eb\u00f2\b\24\1\2\u00ec\u00ed\7\20\2\2\u00ed\u00ee\5\22\n"+
		"\2\u00ee\u00ef\b\24\1\2\u00ef\u00f1\3\2\2\2\u00f0\u00ec\3\2\2\2\u00f1"+
		"\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3\u00f6\3\2"+
		"\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00ea\3\2\2\2\u00f5\u00f6\3\2\2\2\u00f6"+
		"\u00f7\3\2\2\2\u00f7\u00f8\b\24\1\2\u00f8\'\3\2\2\2\u00f9\u00fa\5*\26"+
		"\2\u00fa\u00fb\b\25\1\2\u00fb\u0102\3\2\2\2\u00fc\u00fd\5*\26\2\u00fd"+
		"\u00fe\7\21\2\2\u00fe\u00ff\5*\26\2\u00ff\u0100\b\25\1\2\u0100\u0102\3"+
		"\2\2\2\u0101\u00f9\3\2\2\2\u0101\u00fc\3\2\2\2\u0102)\3\2\2\2\u0103\u0104"+
		"\7\36\2\2\u0104\u0108\b\26\1\2\u0105\u0106\7\37\2\2\u0106\u0108\b\26\1"+
		"\2\u0107\u0103\3\2\2\2\u0107\u0105\3\2\2\2\u0108+\3\2\2\2\u0109\u010a"+
		"\7 \2\2\u010a\u010b\b\27\1\2\u010b-\3\2\2\2\u010c\u010d\7\35\2\2\u010d"+
		"\u010e\b\30\1\2\u010e/\3\2\2\2\24\658;>`ju\u0090\u009a\u00ae\u00b8\u00cb"+
		"\u00e2\u00e5\u00f2\u00f5\u0101\u0107";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}