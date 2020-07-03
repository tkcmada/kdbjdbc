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
		T__42=1, T__41=2, T__40=3, T__39=4, T__38=5, T__37=6, T__36=7, T__35=8, 
		T__34=9, T__33=10, T__32=11, T__31=12, T__30=13, T__29=14, T__28=15, T__27=16, 
		T__26=17, T__25=18, T__24=19, T__23=20, T__22=21, T__21=22, T__20=23, 
		T__19=24, T__18=25, T__17=26, T__16=27, T__15=28, T__14=29, T__13=30, 
		T__12=31, T__11=32, T__10=33, T__9=34, T__8=35, T__7=36, T__6=37, T__5=38, 
		T__4=39, T__3=40, T__2=41, T__1=42, T__0=43, WS=44, NUMBER=45, ID1=46, 
		ID2=47, STR=48;
	public static final String[] tokenNames = {
		"<INVALID>", "'LIMIT'", "'INTEGER'", "'AS'", "'BY'", "'FROM'", "'ELSE'", 
		"'WHERE'", "'EXTRACT'", "'!='", "'END'", "'AND'", "'QUARTER'", "'='", 
		"'THEN'", "'<='", "'GROUP'", "'CASE'", "'SECOND'", "'$'", "'('", "'SELECT'", 
		"','", "'.'", "'WHEN'", "'MINUTE'", "'DISTINCT'", "'CAST'", "'MONTH'", 
		"'DAY'", "'FALSE'", "'HOUR'", "'>='", "'<'", "'YEAR'", "'>'", "'OR'", 
		"'or'", "'HAVING'", "'IN'", "'in'", "')'", "'and'", "'TRUE'", "WS", "NUMBER", 
		"ID1", "ID2", "STR"
	};
	public static final int
		RULE_selectStmt = 0, RULE_table = 1, RULE_columnNames = 2, RULE_columnName = 3, 
		RULE_where = 4, RULE_groupBy = 5, RULE_having = 6, RULE_limit = 7, RULE_expr = 8, 
		RULE_orExpr = 9, RULE_andExpr = 10, RULE_eqExpr = 11, RULE_compExpr = 12, 
		RULE_primaryExpr = 13, RULE_caseExpr = 14, RULE_whenThenExpr = 15, RULE_functionExpr = 16, 
		RULE_booleanLiteral = 17, RULE_numberExpr = 18, RULE_stringExpr = 19, 
		RULE_groupargs = 20, RULE_args = 21, RULE_columnExpr = 22, RULE_name = 23, 
		RULE_str = 24, RULE_pint = 25;
	public static final String[] ruleNames = {
		"selectStmt", "table", "columnNames", "columnName", "where", "groupBy", 
		"having", "limit", "expr", "orExpr", "andExpr", "eqExpr", "compExpr", 
		"primaryExpr", "caseExpr", "whenThenExpr", "functionExpr", "booleanLiteral", 
		"numberExpr", "stringExpr", "groupargs", "args", "columnExpr", "name", 
		"str", "pint"
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
			setState(52); match(21);
			setState(53); columnNames();
			setState(54); match(5);
			setState(55); table();
			setState(57);
			_la = _input.LA(1);
			if (_la==7) {
				{
				setState(56); where();
				}
			}

			setState(60);
			_la = _input.LA(1);
			if (_la==16) {
				{
				setState(59); groupBy();
				}
			}

			setState(63);
			_la = _input.LA(1);
			if (_la==38) {
				{
				setState(62); having();
				}
			}

			setState(66);
			_la = _input.LA(1);
			if (_la==1) {
				{
				setState(65); limit();
				}
			}

			setState(68); match(19);
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
			setState(100);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70); ((TableContext)_localctx).t = name();
				setState(71); match(3);
				setState(72); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).tbl =  new Table(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75); ((TableContext)_localctx).t = name();
				setState(76); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).tbl =  new Table(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79); ((TableContext)_localctx).t = name();
				 ((TableContext)_localctx).tbl =  new Table(((TableContext)_localctx).t.text, null   ); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(82); name();
				setState(83); match(23);
				setState(84); ((TableContext)_localctx).t = name();
				setState(85); match(3);
				setState(86); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).tbl =  new Table(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(89); name();
				setState(90); match(23);
				setState(91); ((TableContext)_localctx).t = name();
				setState(92); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).tbl =  new Table(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(95); name();
				setState(96); match(23);
				setState(97); ((TableContext)_localctx).t = name();
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
			setState(102); ((ColumnNamesContext)_localctx).c1 = columnName();
			 ((ColumnNamesContext)_localctx).columns =  new LinkedList<ColumnExprWithAlias>(); _localctx.columns.add(((ColumnNamesContext)_localctx).c1.val); 
			setState(110);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==22) {
				{
				{
				setState(104); match(22);
				setState(105); ((ColumnNamesContext)_localctx).c2 = columnName();
				 _localctx.columns.add(((ColumnNamesContext)_localctx).c2.val); 
				}
				}
				setState(112);
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
			setState(121);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(113); ((ColumnNameContext)_localctx).expr = expr();
				setState(114); match(3);
				setState(115); ((ColumnNameContext)_localctx).id = name();
				 ((ColumnNameContext)_localctx).val =  new ColumnExprWithAlias(((ColumnNameContext)_localctx).expr.val, ((ColumnNameContext)_localctx).id.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(118); ((ColumnNameContext)_localctx).expr = expr();
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
			setState(123); match(7);
			setState(124); ((WhereContext)_localctx).expr = expr();
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
			setState(127); match(16);
			setState(128); match(4);
			setState(129); groupargs();
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
			setState(131); match(38);
			setState(132); expr();
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
			setState(134); match(1);
			setState(135); pint();
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
			setState(137); ((ExprContext)_localctx).lhs = orExpr();
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
			setState(148);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(140); ((OrExprContext)_localctx).lhs = andExpr();
				setState(141);
				((OrExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==36 || _la==37) ) {
					((OrExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(142); ((OrExprContext)_localctx).rhs = andExpr();
				 ((OrExprContext)_localctx).val =  new BinaryExpr((((OrExprContext)_localctx).op!=null?((OrExprContext)_localctx).op.getText():null), ((OrExprContext)_localctx).lhs.val, ((OrExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(145); ((OrExprContext)_localctx).lhs = andExpr();
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
			setState(158);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(150); ((AndExprContext)_localctx).lhs = eqExpr();
				setState(151);
				((AndExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==11 || _la==42) ) {
					((AndExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(152); ((AndExprContext)_localctx).rhs = eqExpr();
				 ((AndExprContext)_localctx).val =  new BinaryExpr((((AndExprContext)_localctx).op!=null?((AndExprContext)_localctx).op.getText():null), ((AndExprContext)_localctx).lhs.val, ((AndExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(155); ((AndExprContext)_localctx).lhs = eqExpr();
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
			setState(180);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(160); ((EqExprContext)_localctx).lhs = compExpr();
				setState(161); ((EqExprContext)_localctx).op = match(13);
				setState(162); ((EqExprContext)_localctx).rhs = compExpr();
				 ((EqExprContext)_localctx).val =  new EqExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).rhs.val);  
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(165); ((EqExprContext)_localctx).lhs = compExpr();
				setState(166);
				((EqExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==39 || _la==40) ) {
					((EqExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(167); match(20);
				setState(168); ((EqExprContext)_localctx).a = args();
				setState(169); match(41);
				 ((EqExprContext)_localctx).a.val.setWithCurry(true); ((EqExprContext)_localctx).val =  new EqExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).a.val);  
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(172); ((EqExprContext)_localctx).lhs = compExpr();
				setState(173); ((EqExprContext)_localctx).op = match(9);
				setState(174); ((EqExprContext)_localctx).rhs = compExpr();
				 ((EqExprContext)_localctx).val =  new BinaryExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).rhs.val);  
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(177); ((EqExprContext)_localctx).lhs = compExpr();
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
			setState(190);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(182); ((CompExprContext)_localctx).lhs = primaryExpr();
				setState(183);
				((CompExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << 32) | (1L << 33) | (1L << 35))) != 0)) ) {
					((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(184); ((CompExprContext)_localctx).rhs = primaryExpr();
				 ((CompExprContext)_localctx).val =  new BinaryExpr((((CompExprContext)_localctx).op!=null?((CompExprContext)_localctx).op.getText():null), ((CompExprContext)_localctx).lhs.val, ((CompExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(187); ((CompExprContext)_localctx).lhs = primaryExpr();
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
		public BooleanLiteralContext booleanLiteral;
		public CaseExprContext caseExpr;
		public ExprContext expr;
		public Token type;
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
		public CaseExprContext caseExpr() {
			return getRuleContext(CaseExprContext.class,0);
		}
		public BooleanLiteralContext booleanLiteral() {
			return getRuleContext(BooleanLiteralContext.class,0);
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
		int _la;
		try {
			setState(235);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(192); ((PrimaryExprContext)_localctx).e1 = columnExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).e1.val; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195); ((PrimaryExprContext)_localctx).functionExpr = functionExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).functionExpr.val; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(198); ((PrimaryExprContext)_localctx).numberExpr = numberExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).numberExpr.val; 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(201); ((PrimaryExprContext)_localctx).stringExpr = stringExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).stringExpr.val; 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(204); ((PrimaryExprContext)_localctx).booleanLiteral = booleanLiteral();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).booleanLiteral.val; 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(207); ((PrimaryExprContext)_localctx).caseExpr = caseExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).caseExpr.val; 
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(210); match(26);
				setState(211); ((PrimaryExprContext)_localctx).expr = expr();
				 ((PrimaryExprContext)_localctx).val =  new DistinctExpr(((PrimaryExprContext)_localctx).expr.val); 
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(214); match(27);
				setState(215); match(20);
				setState(216); ((PrimaryExprContext)_localctx).expr = expr();
				setState(217); match(3);
				setState(218); ((PrimaryExprContext)_localctx).type = match(2);
				setState(219); match(41);
				 ((PrimaryExprContext)_localctx).val =  new CastExpr(((PrimaryExprContext)_localctx).expr.val, (((PrimaryExprContext)_localctx).type!=null?((PrimaryExprContext)_localctx).type.getText():null)); 
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(222); match(8);
				setState(223); match(20);
				setState(224);
				((PrimaryExprContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 18) | (1L << 25) | (1L << 28) | (1L << 29) | (1L << 31) | (1L << 34))) != 0)) ) {
					((PrimaryExprContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(225); match(5);
				setState(226); ((PrimaryExprContext)_localctx).expr = expr();
				setState(227); match(41);
				 ((PrimaryExprContext)_localctx).val =  new ExtractExpr(((PrimaryExprContext)_localctx).expr.val, (((PrimaryExprContext)_localctx).type!=null?((PrimaryExprContext)_localctx).type.getText():null)); 
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(230); match(20);
				setState(231); ((PrimaryExprContext)_localctx).expr = expr();
				setState(232); match(41);
				 ((PrimaryExprContext)_localctx).val =  new CurryExpr(((PrimaryExprContext)_localctx).expr.val); 
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

	public static class CaseExprContext extends ParserRuleContext {
		public CaseExpr val;
		public WhenThenExprContext wt;
		public ExprContext e;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public WhenThenExprContext whenThenExpr() {
			return getRuleContext(WhenThenExprContext.class,0);
		}
		public CaseExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_caseExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterCaseExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitCaseExpr(this);
		}
	}

	public final CaseExprContext caseExpr() throws RecognitionException {
		CaseExprContext _localctx = new CaseExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_caseExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(237); match(17);
			setState(238); ((CaseExprContext)_localctx).wt = whenThenExpr();
			setState(239); match(6);
			setState(240); ((CaseExprContext)_localctx).e = expr();
			setState(241); match(10);
			 ((CaseExprContext)_localctx).val =  new CaseExpr(null, ((CaseExprContext)_localctx).wt.val, ((CaseExprContext)_localctx).e.val); 
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

	public static class WhenThenExprContext extends ParserRuleContext {
		public List<WhenThen> val;
		public ExprContext e1;
		public ExprContext e2;
		public ExprContext e3;
		public ExprContext e4;
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public WhenThenExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenThenExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterWhenThenExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitWhenThenExpr(this);
		}
	}

	public final WhenThenExprContext whenThenExpr() throws RecognitionException {
		WhenThenExprContext _localctx = new WhenThenExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_whenThenExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(244); match(24);
			setState(245); ((WhenThenExprContext)_localctx).e1 = expr();
			setState(246); match(14);
			setState(247); ((WhenThenExprContext)_localctx).e2 = expr();
			 ((WhenThenExprContext)_localctx).val =  new LinkedList<WhenThen>(); _localctx.val.add(new WhenThen(((WhenThenExprContext)_localctx).e1.val, ((WhenThenExprContext)_localctx).e2.val)); 
			setState(257);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(249); match(24);
				setState(250); ((WhenThenExprContext)_localctx).e3 = expr();
				setState(251); match(14);
				setState(252); ((WhenThenExprContext)_localctx).e4 = expr();
				 _localctx.val.add(new WhenThen(((WhenThenExprContext)_localctx).e3.val, ((WhenThenExprContext)_localctx).e4.val)); 
				}
				}
				setState(259);
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
		enterRule(_localctx, 32, RULE_functionExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(260); ((FunctionExprContext)_localctx).id = name();
			setState(261); match(20);
			setState(262); ((FunctionExprContext)_localctx).args = args();
			setState(263); match(41);
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

	public static class BooleanLiteralContext extends ParserRuleContext {
		public BooleanLiteral val;
		public Token tk;
		public BooleanLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterBooleanLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitBooleanLiteral(this);
		}
	}

	public final BooleanLiteralContext booleanLiteral() throws RecognitionException {
		BooleanLiteralContext _localctx = new BooleanLiteralContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(266);
			((BooleanLiteralContext)_localctx).tk = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==30 || _la==43) ) {
				((BooleanLiteralContext)_localctx).tk = (Token)_errHandler.recoverInline(this);
			}
			consume();
			 ((BooleanLiteralContext)_localctx).val =  new BooleanLiteral(Boolean.parseBoolean((((BooleanLiteralContext)_localctx).tk!=null?((BooleanLiteralContext)_localctx).tk.getText():null))); 
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
		enterRule(_localctx, 36, RULE_numberExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(269); ((NumberExprContext)_localctx).numtk = match(NUMBER);
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
		enterRule(_localctx, 38, RULE_stringExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(272); ((StringExprContext)_localctx).str = str();
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
		enterRule(_localctx, 40, RULE_groupargs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Integer> _args = new ArrayList<Integer>(); 
			setState(287);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(276); ((GroupargsContext)_localctx).e1 = pint();
				 _args.add(((GroupargsContext)_localctx).e1.val); 
				setState(284);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==22) {
					{
					{
					setState(278); match(22);
					setState(279); ((GroupargsContext)_localctx).e2 = pint();
					 _args.add(((GroupargsContext)_localctx).e2.val); 
					}
					}
					setState(286);
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
		enterRule(_localctx, 42, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Expr> _args = new ArrayList<Expr>(); 
			setState(303);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 8) | (1L << 17) | (1L << 20) | (1L << 26) | (1L << 27) | (1L << 30) | (1L << 43) | (1L << NUMBER) | (1L << ID1) | (1L << ID2) | (1L << STR))) != 0)) {
				{
				setState(292); ((ArgsContext)_localctx).e1 = expr();
				 _args.add(((ArgsContext)_localctx).e1.val); 
				setState(300);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==22) {
					{
					{
					setState(294); match(22);
					setState(295); ((ArgsContext)_localctx).e2 = expr();
					 _args.add(((ArgsContext)_localctx).e2.val); 
					}
					}
					setState(302);
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
		enterRule(_localctx, 44, RULE_columnExpr);
		try {
			setState(315);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(307); ((ColumnExprContext)_localctx).id2 = name();
				 ((ColumnExprContext)_localctx).val =  new ColumnExpr(null,      ((ColumnExprContext)_localctx).id2.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(310); ((ColumnExprContext)_localctx).id1 = name();
				setState(311); match(23);
				setState(312); ((ColumnExprContext)_localctx).id2 = name();
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
		enterRule(_localctx, 46, RULE_name);
		try {
			setState(321);
			switch (_input.LA(1)) {
			case ID1:
				enterOuterAlt(_localctx, 1);
				{
				setState(317); ((NameContext)_localctx).ID1 = match(ID1);
				 ((NameContext)_localctx).text =  (((NameContext)_localctx).ID1!=null?((NameContext)_localctx).ID1.getText():null); 
				}
				break;
			case ID2:
				enterOuterAlt(_localctx, 2);
				{
				setState(319); ((NameContext)_localctx).ID2 = match(ID2);
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
		enterRule(_localctx, 48, RULE_str);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(323); ((StrContext)_localctx).STR = match(STR);
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
		enterRule(_localctx, 50, RULE_pint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326); ((PintContext)_localctx).num = match(NUMBER);
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
		"\2\3\62\u014c\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t"+
		"\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\3\2\3\2\3\2\3\2\3\2\5\2<\n"+
		"\2\3\2\5\2?\n\2\3\2\5\2B\n\2\3\2\5\2E\n\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3g\n\3\3\4\3\4\3\4\3\4\3\4\3\4\7\4o\n"+
		"\4\f\4\16\4r\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5|\n\5\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\13\5\13\u0097\n\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f"+
		"\3\f\5\f\u00a1\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r"+
		"\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00b7\n\r\3\16\3\16\3\16\3\16\3\16\3"+
		"\16\3\16\3\16\5\16\u00c1\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ee\n\17\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\7\21\u0102\n\21\f\21\16\21\u0105\13\21\3\22\3\22\3\22\3\22\3\22\3\22"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\7\26\u011d\n\26\f\26\16\26\u0120\13\26\5\26\u0122\n\26\3\26"+
		"\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u012d\n\27\f\27\16\27\u0130"+
		"\13\27\5\27\u0132\n\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\30\3"+
		"\30\5\30\u013e\n\30\3\31\3\31\3\31\3\31\5\31\u0144\n\31\3\32\3\32\3\32"+
		"\3\33\3\33\3\33\3\33\2\34\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&"+
		"(*,.\60\62\64\2\b\3&\'\4\r\r,,\3)*\5\21\21\"#%%\b\16\16\24\24\33\33\36"+
		"\37!!$$\4  --\u0152\2\66\3\2\2\2\4f\3\2\2\2\6h\3\2\2\2\b{\3\2\2\2\n}\3"+
		"\2\2\2\f\u0081\3\2\2\2\16\u0085\3\2\2\2\20\u0088\3\2\2\2\22\u008b\3\2"+
		"\2\2\24\u0096\3\2\2\2\26\u00a0\3\2\2\2\30\u00b6\3\2\2\2\32\u00c0\3\2\2"+
		"\2\34\u00ed\3\2\2\2\36\u00ef\3\2\2\2 \u00f6\3\2\2\2\"\u0106\3\2\2\2$\u010c"+
		"\3\2\2\2&\u010f\3\2\2\2(\u0112\3\2\2\2*\u0115\3\2\2\2,\u0125\3\2\2\2."+
		"\u013d\3\2\2\2\60\u0143\3\2\2\2\62\u0145\3\2\2\2\64\u0148\3\2\2\2\66\67"+
		"\7\27\2\2\678\5\6\4\289\7\7\2\29;\5\4\3\2:<\5\n\6\2;:\3\2\2\2;<\3\2\2"+
		"\2<>\3\2\2\2=?\5\f\7\2>=\3\2\2\2>?\3\2\2\2?A\3\2\2\2@B\5\16\b\2A@\3\2"+
		"\2\2AB\3\2\2\2BD\3\2\2\2CE\5\20\t\2DC\3\2\2\2DE\3\2\2\2EF\3\2\2\2FG\7"+
		"\25\2\2G\3\3\2\2\2HI\5\60\31\2IJ\7\5\2\2JK\5\60\31\2KL\b\3\1\2Lg\3\2\2"+
		"\2MN\5\60\31\2NO\5\60\31\2OP\b\3\1\2Pg\3\2\2\2QR\5\60\31\2RS\b\3\1\2S"+
		"g\3\2\2\2TU\5\60\31\2UV\7\31\2\2VW\5\60\31\2WX\7\5\2\2XY\5\60\31\2YZ\b"+
		"\3\1\2Zg\3\2\2\2[\\\5\60\31\2\\]\7\31\2\2]^\5\60\31\2^_\5\60\31\2_`\b"+
		"\3\1\2`g\3\2\2\2ab\5\60\31\2bc\7\31\2\2cd\5\60\31\2de\b\3\1\2eg\3\2\2"+
		"\2fH\3\2\2\2fM\3\2\2\2fQ\3\2\2\2fT\3\2\2\2f[\3\2\2\2fa\3\2\2\2g\5\3\2"+
		"\2\2hi\5\b\5\2ip\b\4\1\2jk\7\30\2\2kl\5\b\5\2lm\b\4\1\2mo\3\2\2\2nj\3"+
		"\2\2\2or\3\2\2\2pn\3\2\2\2pq\3\2\2\2q\7\3\2\2\2rp\3\2\2\2st\5\22\n\2t"+
		"u\7\5\2\2uv\5\60\31\2vw\b\5\1\2w|\3\2\2\2xy\5\22\n\2yz\b\5\1\2z|\3\2\2"+
		"\2{s\3\2\2\2{x\3\2\2\2|\t\3\2\2\2}~\7\t\2\2~\177\5\22\n\2\177\u0080\b"+
		"\6\1\2\u0080\13\3\2\2\2\u0081\u0082\7\22\2\2\u0082\u0083\7\6\2\2\u0083"+
		"\u0084\5*\26\2\u0084\r\3\2\2\2\u0085\u0086\7(\2\2\u0086\u0087\5\22\n\2"+
		"\u0087\17\3\2\2\2\u0088\u0089\7\3\2\2\u0089\u008a\5\64\33\2\u008a\21\3"+
		"\2\2\2\u008b\u008c\5\24\13\2\u008c\u008d\b\n\1\2\u008d\23\3\2\2\2\u008e"+
		"\u008f\5\26\f\2\u008f\u0090\t\2\2\2\u0090\u0091\5\26\f\2\u0091\u0092\b"+
		"\13\1\2\u0092\u0097\3\2\2\2\u0093\u0094\5\26\f\2\u0094\u0095\b\13\1\2"+
		"\u0095\u0097\3\2\2\2\u0096\u008e\3\2\2\2\u0096\u0093\3\2\2\2\u0097\25"+
		"\3\2\2\2\u0098\u0099\5\30\r\2\u0099\u009a\t\3\2\2\u009a\u009b\5\30\r\2"+
		"\u009b\u009c\b\f\1\2\u009c\u00a1\3\2\2\2\u009d\u009e\5\30\r\2\u009e\u009f"+
		"\b\f\1\2\u009f\u00a1\3\2\2\2\u00a0\u0098\3\2\2\2\u00a0\u009d\3\2\2\2\u00a1"+
		"\27\3\2\2\2\u00a2\u00a3\5\32\16\2\u00a3\u00a4\7\17\2\2\u00a4\u00a5\5\32"+
		"\16\2\u00a5\u00a6\b\r\1\2\u00a6\u00b7\3\2\2\2\u00a7\u00a8\5\32\16\2\u00a8"+
		"\u00a9\t\4\2\2\u00a9\u00aa\7\26\2\2\u00aa\u00ab\5,\27\2\u00ab\u00ac\7"+
		"+\2\2\u00ac\u00ad\b\r\1\2\u00ad\u00b7\3\2\2\2\u00ae\u00af\5\32\16\2\u00af"+
		"\u00b0\7\13\2\2\u00b0\u00b1\5\32\16\2\u00b1\u00b2\b\r\1\2\u00b2\u00b7"+
		"\3\2\2\2\u00b3\u00b4\5\32\16\2\u00b4\u00b5\b\r\1\2\u00b5\u00b7\3\2\2\2"+
		"\u00b6\u00a2\3\2\2\2\u00b6\u00a7\3\2\2\2\u00b6\u00ae\3\2\2\2\u00b6\u00b3"+
		"\3\2\2\2\u00b7\31\3\2\2\2\u00b8\u00b9\5\34\17\2\u00b9\u00ba\t\5\2\2\u00ba"+
		"\u00bb\5\34\17\2\u00bb\u00bc\b\16\1\2\u00bc\u00c1\3\2\2\2\u00bd\u00be"+
		"\5\34\17\2\u00be\u00bf\b\16\1\2\u00bf\u00c1\3\2\2\2\u00c0\u00b8\3\2\2"+
		"\2\u00c0\u00bd\3\2\2\2\u00c1\33\3\2\2\2\u00c2\u00c3\5.\30\2\u00c3\u00c4"+
		"\b\17\1\2\u00c4\u00ee\3\2\2\2\u00c5\u00c6\5\"\22\2\u00c6\u00c7\b\17\1"+
		"\2\u00c7\u00ee\3\2\2\2\u00c8\u00c9\5&\24\2\u00c9\u00ca\b\17\1\2\u00ca"+
		"\u00ee\3\2\2\2\u00cb\u00cc\5(\25\2\u00cc\u00cd\b\17\1\2\u00cd\u00ee\3"+
		"\2\2\2\u00ce\u00cf\5$\23\2\u00cf\u00d0\b\17\1\2\u00d0\u00ee\3\2\2\2\u00d1"+
		"\u00d2\5\36\20\2\u00d2\u00d3\b\17\1\2\u00d3\u00ee\3\2\2\2\u00d4\u00d5"+
		"\7\34\2\2\u00d5\u00d6\5\22\n\2\u00d6\u00d7\b\17\1\2\u00d7\u00ee\3\2\2"+
		"\2\u00d8\u00d9\7\35\2\2\u00d9\u00da\7\26\2\2\u00da\u00db\5\22\n\2\u00db"+
		"\u00dc\7\5\2\2\u00dc\u00dd\7\4\2\2\u00dd\u00de\7+\2\2\u00de\u00df\b\17"+
		"\1\2\u00df\u00ee\3\2\2\2\u00e0\u00e1\7\n\2\2\u00e1\u00e2\7\26\2\2\u00e2"+
		"\u00e3\t\6\2\2\u00e3\u00e4\7\7\2\2\u00e4\u00e5\5\22\n\2\u00e5\u00e6\7"+
		"+\2\2\u00e6\u00e7\b\17\1\2\u00e7\u00ee\3\2\2\2\u00e8\u00e9\7\26\2\2\u00e9"+
		"\u00ea\5\22\n\2\u00ea\u00eb\7+\2\2\u00eb\u00ec\b\17\1\2\u00ec\u00ee\3"+
		"\2\2\2\u00ed\u00c2\3\2\2\2\u00ed\u00c5\3\2\2\2\u00ed\u00c8\3\2\2\2\u00ed"+
		"\u00cb\3\2\2\2\u00ed\u00ce\3\2\2\2\u00ed\u00d1\3\2\2\2\u00ed\u00d4\3\2"+
		"\2\2\u00ed\u00d8\3\2\2\2\u00ed\u00e0\3\2\2\2\u00ed\u00e8\3\2\2\2\u00ee"+
		"\35\3\2\2\2\u00ef\u00f0\7\23\2\2\u00f0\u00f1\5 \21\2\u00f1\u00f2\7\b\2"+
		"\2\u00f2\u00f3\5\22\n\2\u00f3\u00f4\7\f\2\2\u00f4\u00f5\b\20\1\2\u00f5"+
		"\37\3\2\2\2\u00f6\u00f7\7\32\2\2\u00f7\u00f8\5\22\n\2\u00f8\u00f9\7\20"+
		"\2\2\u00f9\u00fa\5\22\n\2\u00fa\u0103\b\21\1\2\u00fb\u00fc\7\32\2\2\u00fc"+
		"\u00fd\5\22\n\2\u00fd\u00fe\7\20\2\2\u00fe\u00ff\5\22\n\2\u00ff\u0100"+
		"\b\21\1\2\u0100\u0102\3\2\2\2\u0101\u00fb\3\2\2\2\u0102\u0105\3\2\2\2"+
		"\u0103\u0101\3\2\2\2\u0103\u0104\3\2\2\2\u0104!\3\2\2\2\u0105\u0103\3"+
		"\2\2\2\u0106\u0107\5\60\31\2\u0107\u0108\7\26\2\2\u0108\u0109\5,\27\2"+
		"\u0109\u010a\7+\2\2\u010a\u010b\b\22\1\2\u010b#\3\2\2\2\u010c\u010d\t"+
		"\7\2\2\u010d\u010e\b\23\1\2\u010e%\3\2\2\2\u010f\u0110\7/\2\2\u0110\u0111"+
		"\b\24\1\2\u0111\'\3\2\2\2\u0112\u0113\5\62\32\2\u0113\u0114\b\25\1\2\u0114"+
		")\3\2\2\2\u0115\u0121\b\26\1\2\u0116\u0117\5\64\33\2\u0117\u011e\b\26"+
		"\1\2\u0118\u0119\7\30\2\2\u0119\u011a\5\64\33\2\u011a\u011b\b\26\1\2\u011b"+
		"\u011d\3\2\2\2\u011c\u0118\3\2\2\2\u011d\u0120\3\2\2\2\u011e\u011c\3\2"+
		"\2\2\u011e\u011f\3\2\2\2\u011f\u0122\3\2\2\2\u0120\u011e\3\2\2\2\u0121"+
		"\u0116\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\b\26"+
		"\1\2\u0124+\3\2\2\2\u0125\u0131\b\27\1\2\u0126\u0127\5\22\n\2\u0127\u012e"+
		"\b\27\1\2\u0128\u0129\7\30\2\2\u0129\u012a\5\22\n\2\u012a\u012b\b\27\1"+
		"\2\u012b\u012d\3\2\2\2\u012c\u0128\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c"+
		"\3\2\2\2\u012e\u012f\3\2\2\2\u012f\u0132\3\2\2\2\u0130\u012e\3\2\2\2\u0131"+
		"\u0126\3\2\2\2\u0131\u0132\3\2\2\2\u0132\u0133\3\2\2\2\u0133\u0134\b\27"+
		"\1\2\u0134-\3\2\2\2\u0135\u0136\5\60\31\2\u0136\u0137\b\30\1\2\u0137\u013e"+
		"\3\2\2\2\u0138\u0139\5\60\31\2\u0139\u013a\7\31\2\2\u013a\u013b\5\60\31"+
		"\2\u013b\u013c\b\30\1\2\u013c\u013e\3\2\2\2\u013d\u0135\3\2\2\2\u013d"+
		"\u0138\3\2\2\2\u013e/\3\2\2\2\u013f\u0140\7\60\2\2\u0140\u0144\b\31\1"+
		"\2\u0141\u0142\7\61\2\2\u0142\u0144\b\31\1\2\u0143\u013f\3\2\2\2\u0143"+
		"\u0141\3\2\2\2\u0144\61\3\2\2\2\u0145\u0146\7\62\2\2\u0146\u0147\b\32"+
		"\1\2\u0147\63\3\2\2\2\u0148\u0149\7/\2\2\u0149\u014a\b\33\1\2\u014a\65"+
		"\3\2\2\2\25;>ADfp{\u0096\u00a0\u00b6\u00c0\u00ed\u0103\u011e\u0121\u012e"+
		"\u0131\u013d\u0143";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}