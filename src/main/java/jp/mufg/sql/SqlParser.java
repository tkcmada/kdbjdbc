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
		T__45=1, T__44=2, T__43=3, T__42=4, T__41=5, T__40=6, T__39=7, T__38=8, 
		T__37=9, T__36=10, T__35=11, T__34=12, T__33=13, T__32=14, T__31=15, T__30=16, 
		T__29=17, T__28=18, T__27=19, T__26=20, T__25=21, T__24=22, T__23=23, 
		T__22=24, T__21=25, T__20=26, T__19=27, T__18=28, T__17=29, T__16=30, 
		T__15=31, T__14=32, T__13=33, T__12=34, T__11=35, T__10=36, T__9=37, T__8=38, 
		T__7=39, T__6=40, T__5=41, T__4=42, T__3=43, T__2=44, T__1=45, T__0=46, 
		WS=47, NUMBER=48, ID1=49, ID2=50, STR=51;
	public static final String[] tokenNames = {
		"<INVALID>", "'LIMIT'", "'INTEGER'", "'AS'", "'BY'", "'FROM'", "'ELSE'", 
		"'WHERE'", "'EXTRACT'", "'!='", "'END'", "'AND'", "'QUARTER'", "'='", 
		"'THEN'", "'<='", "'GROUP'", "'CASE'", "'SECOND'", "'$'", "'from'", "'('", 
		"'*'", "'SELECT'", "','", "'.'", "'WHEN'", "'MINUTE'", "'DISTINCT'", "'CAST'", 
		"'MONTH'", "'DAY'", "'FALSE'", "'HOUR'", "'>='", "'<'", "'select'", "'YEAR'", 
		"'>'", "'OR'", "'or'", "'HAVING'", "'IN'", "'in'", "')'", "'and'", "'TRUE'", 
		"WS", "NUMBER", "ID1", "ID2", "STR"
	};
	public static final int
		RULE_selectStmtWhole = 0, RULE_selectStmt = 1, RULE_table = 2, RULE_columnNames = 3, 
		RULE_columnName = 4, RULE_where = 5, RULE_groupBy = 6, RULE_having = 7, 
		RULE_limit = 8, RULE_expr = 9, RULE_orExpr = 10, RULE_andExpr = 11, RULE_eqExpr = 12, 
		RULE_compExpr = 13, RULE_primaryExpr = 14, RULE_caseExpr = 15, RULE_whenThenExpr = 16, 
		RULE_functionExpr = 17, RULE_booleanLiteral = 18, RULE_numberExpr = 19, 
		RULE_stringExpr = 20, RULE_groupargs = 21, RULE_args = 22, RULE_columnExpr = 23, 
		RULE_name = 24, RULE_str = 25, RULE_pint = 26;
	public static final String[] ruleNames = {
		"selectStmtWhole", "selectStmt", "table", "columnNames", "columnName", 
		"where", "groupBy", "having", "limit", "expr", "orExpr", "andExpr", "eqExpr", 
		"compExpr", "primaryExpr", "caseExpr", "whenThenExpr", "functionExpr", 
		"booleanLiteral", "numberExpr", "stringExpr", "groupargs", "args", "columnExpr", 
		"name", "str", "pint"
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
	public static class SelectStmtWholeContext extends ParserRuleContext {
		public SelectStatement val;
		public SelectStmtContext selectStmt;
		public SelectStmtContext selectStmt() {
			return getRuleContext(SelectStmtContext.class,0);
		}
		public SelectStmtWholeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selectStmtWhole; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterSelectStmtWhole(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitSelectStmtWhole(this);
		}
	}

	public final SelectStmtWholeContext selectStmtWhole() throws RecognitionException {
		SelectStmtWholeContext _localctx = new SelectStmtWholeContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_selectStmtWhole);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54); ((SelectStmtWholeContext)_localctx).selectStmt = selectStmt();
			setState(55); match(19);
			 ((SelectStmtWholeContext)_localctx).val =  ((SelectStmtWholeContext)_localctx).selectStmt.val; 
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

	public static class SelectStmtContext extends ParserRuleContext {
		public SelectStatement val;
		public ColumnNamesContext columnNames;
		public TableContext table;
		public WhereContext where;
		public GroupByContext groupBy;
		public HavingContext having;
		public LimitContext limit;
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
		enterRule(_localctx, 2, RULE_selectStmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			_la = _input.LA(1);
			if ( !(_la==23 || _la==36) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(59); ((SelectStmtContext)_localctx).columnNames = columnNames();
			setState(60);
			_la = _input.LA(1);
			if ( !(_la==5 || _la==20) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(61); ((SelectStmtContext)_localctx).table = table();
			setState(62); ((SelectStmtContext)_localctx).where = where();
			setState(63); ((SelectStmtContext)_localctx).groupBy = groupBy();
			setState(64); ((SelectStmtContext)_localctx).having = having();
			setState(65); ((SelectStmtContext)_localctx).limit = limit();
			 ((SelectStmtContext)_localctx).val =  new SelectStatement(
			            ((SelectStmtContext)_localctx).columnNames.columns,
			            ((SelectStmtContext)_localctx).table.val,
			            ((SelectStmtContext)_localctx).where.val,
			            ((SelectStmtContext)_localctx).groupBy.val,
			            ((SelectStmtContext)_localctx).having.val,
			            ((SelectStmtContext)_localctx).limit.val
			            );
			        
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
		public Table val;
		public NameContext t;
		public NameContext a;
		public SelectStmtContext selectStmt;
		public List<NameContext> name() {
			return getRuleContexts(NameContext.class);
		}
		public NameContext name(int i) {
			return getRuleContext(NameContext.class,i);
		}
		public SelectStmtContext selectStmt() {
			return getRuleContext(SelectStmtContext.class,0);
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
		enterRule(_localctx, 4, RULE_table);
		try {
			setState(116);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(68); ((TableContext)_localctx).t = name();
				setState(69); match(3);
				setState(70); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(73); ((TableContext)_localctx).t = name();
				setState(74); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(77); ((TableContext)_localctx).t = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, null   ); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(80); name();
				setState(81); match(25);
				setState(82); ((TableContext)_localctx).t = name();
				setState(83); match(3);
				setState(84); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(87); name();
				setState(88); match(25);
				setState(89); ((TableContext)_localctx).t = name();
				setState(90); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(93); name();
				setState(94); match(25);
				setState(95); ((TableContext)_localctx).t = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, null   ); 
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(98); match(21);
				setState(99); ((TableContext)_localctx).selectStmt = selectStmt();
				setState(100); match(44);
				setState(101); match(3);
				setState(102); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableSelect(((TableContext)_localctx).selectStmt.val, ((TableContext)_localctx).a.text); 
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(105); match(21);
				setState(106); ((TableContext)_localctx).selectStmt = selectStmt();
				setState(107); match(44);
				setState(108); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableSelect(((TableContext)_localctx).selectStmt.val, ((TableContext)_localctx).a.text); 
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(111); match(21);
				setState(112); ((TableContext)_localctx).selectStmt = selectStmt();
				setState(113); match(44);
				 ((TableContext)_localctx).val =  new TableSelect(((TableContext)_localctx).selectStmt.val, null   ); 
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
		public List<Column> columns;
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
		enterRule(_localctx, 6, RULE_columnNames);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(118); ((ColumnNamesContext)_localctx).c1 = columnName();
			 ((ColumnNamesContext)_localctx).columns =  new LinkedList<Column>(); _localctx.columns.add(((ColumnNamesContext)_localctx).c1.val); 
			setState(126);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(120); match(24);
				setState(121); ((ColumnNamesContext)_localctx).c2 = columnName();
				 _localctx.columns.add(((ColumnNamesContext)_localctx).c2.val); 
				}
				}
				setState(128);
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
		public Column val;
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
		enterRule(_localctx, 8, RULE_columnName);
		try {
			setState(139);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(129); ((ColumnNameContext)_localctx).expr = expr();
				setState(130); match(3);
				setState(131); ((ColumnNameContext)_localctx).id = name();
				 ((ColumnNameContext)_localctx).val =  new ColumnImpl(((ColumnNameContext)_localctx).expr.val, ((ColumnNameContext)_localctx).id.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134); ((ColumnNameContext)_localctx).expr = expr();
				 ((ColumnNameContext)_localctx).val =  new ColumnImpl(((ColumnNameContext)_localctx).expr.val, null); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(137); match(22);
				 ((ColumnNameContext)_localctx).val =  new WildcardColumns(); 
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
		enterRule(_localctx, 10, RULE_where);
		try {
			setState(146);
			switch (_input.LA(1)) {
			case 7:
				enterOuterAlt(_localctx, 1);
				{
				setState(141); match(7);
				setState(142); ((WhereContext)_localctx).expr = expr();
				 ((WhereContext)_localctx).val =  ((WhereContext)_localctx).expr.val; 
				}
				break;
			case 1:
			case 16:
			case 19:
			case 41:
			case 44:
				enterOuterAlt(_localctx, 2);
				{
				 ((WhereContext)_localctx).val =  null;      
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

	public static class GroupByContext extends ParserRuleContext {
		public List<Integer> val;
		public GroupargsContext groupargs;
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
		enterRule(_localctx, 12, RULE_groupBy);
		try {
			setState(154);
			switch (_input.LA(1)) {
			case 16:
				enterOuterAlt(_localctx, 1);
				{
				setState(148); match(16);
				setState(149); match(4);
				setState(150); ((GroupByContext)_localctx).groupargs = groupargs();
				 ((GroupByContext)_localctx).val =  ((GroupByContext)_localctx).groupargs.val; 
				}
				break;
			case 1:
			case 19:
			case 41:
			case 44:
				enterOuterAlt(_localctx, 2);
				{
				 ((GroupByContext)_localctx).val =  null;           
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

	public static class HavingContext extends ParserRuleContext {
		public Expr val;
		public ExprContext expr;
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
		enterRule(_localctx, 14, RULE_having);
		try {
			setState(161);
			switch (_input.LA(1)) {
			case 41:
				enterOuterAlt(_localctx, 1);
				{
				setState(156); match(41);
				setState(157); ((HavingContext)_localctx).expr = expr();
				 ((HavingContext)_localctx).val =  ((HavingContext)_localctx).expr.val; 
				}
				break;
			case 1:
			case 19:
			case 44:
				enterOuterAlt(_localctx, 2);
				{
				 ((HavingContext)_localctx).val =  null;      
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

	public static class LimitContext extends ParserRuleContext {
		public Integer val;
		public PintContext pint;
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
		enterRule(_localctx, 16, RULE_limit);
		try {
			setState(168);
			switch (_input.LA(1)) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(163); match(1);
				setState(164); ((LimitContext)_localctx).pint = pint();
				 ((LimitContext)_localctx).val =  ((LimitContext)_localctx).pint.val; 
				}
				break;
			case 19:
			case 44:
				enterOuterAlt(_localctx, 2);
				{
				 ((LimitContext)_localctx).val =  null;      
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
		enterRule(_localctx, 18, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(170); ((ExprContext)_localctx).lhs = orExpr();
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
		enterRule(_localctx, 20, RULE_orExpr);
		int _la;
		try {
			setState(181);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(173); ((OrExprContext)_localctx).lhs = andExpr();
				setState(174);
				((OrExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==39 || _la==40) ) {
					((OrExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(175); ((OrExprContext)_localctx).rhs = andExpr();
				 ((OrExprContext)_localctx).val =  new BinaryExpr((((OrExprContext)_localctx).op!=null?((OrExprContext)_localctx).op.getText():null), ((OrExprContext)_localctx).lhs.val, ((OrExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(178); ((OrExprContext)_localctx).lhs = andExpr();
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
		enterRule(_localctx, 22, RULE_andExpr);
		int _la;
		try {
			setState(191);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(183); ((AndExprContext)_localctx).lhs = eqExpr();
				setState(184);
				((AndExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==11 || _la==45) ) {
					((AndExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(185); ((AndExprContext)_localctx).rhs = eqExpr();
				 ((AndExprContext)_localctx).val =  new BinaryExpr((((AndExprContext)_localctx).op!=null?((AndExprContext)_localctx).op.getText():null), ((AndExprContext)_localctx).lhs.val, ((AndExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(188); ((AndExprContext)_localctx).lhs = eqExpr();
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
		enterRule(_localctx, 24, RULE_eqExpr);
		int _la;
		try {
			setState(213);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(193); ((EqExprContext)_localctx).lhs = compExpr();
				setState(194); ((EqExprContext)_localctx).op = match(13);
				setState(195); ((EqExprContext)_localctx).rhs = compExpr();
				 ((EqExprContext)_localctx).val =  new EqExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).rhs.val);  
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(198); ((EqExprContext)_localctx).lhs = compExpr();
				setState(199);
				((EqExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==42 || _la==43) ) {
					((EqExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(200); match(21);
				setState(201); ((EqExprContext)_localctx).a = args();
				setState(202); match(44);
				 ((EqExprContext)_localctx).a.val.setWithCurry(true); ((EqExprContext)_localctx).val =  new EqExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).a.val);  
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(205); ((EqExprContext)_localctx).lhs = compExpr();
				setState(206); ((EqExprContext)_localctx).op = match(9);
				setState(207); ((EqExprContext)_localctx).rhs = compExpr();
				 ((EqExprContext)_localctx).val =  new BinaryExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).rhs.val);  
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(210); ((EqExprContext)_localctx).lhs = compExpr();
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
		enterRule(_localctx, 26, RULE_compExpr);
		int _la;
		try {
			setState(223);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215); ((CompExprContext)_localctx).lhs = primaryExpr();
				setState(216);
				((CompExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << 34) | (1L << 35) | (1L << 38))) != 0)) ) {
					((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(217); ((CompExprContext)_localctx).rhs = primaryExpr();
				 ((CompExprContext)_localctx).val =  new BinaryExpr((((CompExprContext)_localctx).op!=null?((CompExprContext)_localctx).op.getText():null), ((CompExprContext)_localctx).lhs.val, ((CompExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220); ((CompExprContext)_localctx).lhs = primaryExpr();
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
		enterRule(_localctx, 28, RULE_primaryExpr);
		int _la;
		try {
			setState(268);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(225); ((PrimaryExprContext)_localctx).e1 = columnExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).e1.val; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(228); ((PrimaryExprContext)_localctx).functionExpr = functionExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).functionExpr.val; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(231); ((PrimaryExprContext)_localctx).numberExpr = numberExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).numberExpr.val; 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(234); ((PrimaryExprContext)_localctx).stringExpr = stringExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).stringExpr.val; 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(237); ((PrimaryExprContext)_localctx).booleanLiteral = booleanLiteral();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).booleanLiteral.val; 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(240); ((PrimaryExprContext)_localctx).caseExpr = caseExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).caseExpr.val; 
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(243); match(28);
				setState(244); ((PrimaryExprContext)_localctx).expr = expr();
				 ((PrimaryExprContext)_localctx).val =  new DistinctExpr(((PrimaryExprContext)_localctx).expr.val); 
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(247); match(29);
				setState(248); match(21);
				setState(249); ((PrimaryExprContext)_localctx).expr = expr();
				setState(250); match(3);
				setState(251); ((PrimaryExprContext)_localctx).type = match(2);
				setState(252); match(44);
				 ((PrimaryExprContext)_localctx).val =  new CastExpr(((PrimaryExprContext)_localctx).expr.val, (((PrimaryExprContext)_localctx).type!=null?((PrimaryExprContext)_localctx).type.getText():null)); 
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(255); match(8);
				setState(256); match(21);
				setState(257);
				((PrimaryExprContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 18) | (1L << 27) | (1L << 30) | (1L << 31) | (1L << 33) | (1L << 37))) != 0)) ) {
					((PrimaryExprContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(258); match(5);
				setState(259); ((PrimaryExprContext)_localctx).expr = expr();
				setState(260); match(44);
				 ((PrimaryExprContext)_localctx).val =  new ExtractExpr(((PrimaryExprContext)_localctx).expr.val, (((PrimaryExprContext)_localctx).type!=null?((PrimaryExprContext)_localctx).type.getText():null)); 
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(263); match(21);
				setState(264); ((PrimaryExprContext)_localctx).expr = expr();
				setState(265); match(44);
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
		enterRule(_localctx, 30, RULE_caseExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(270); match(17);
			setState(271); ((CaseExprContext)_localctx).wt = whenThenExpr();
			setState(272); match(6);
			setState(273); ((CaseExprContext)_localctx).e = expr();
			setState(274); match(10);
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
		enterRule(_localctx, 32, RULE_whenThenExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(277); match(26);
			setState(278); ((WhenThenExprContext)_localctx).e1 = expr();
			setState(279); match(14);
			setState(280); ((WhenThenExprContext)_localctx).e2 = expr();
			 ((WhenThenExprContext)_localctx).val =  new LinkedList<WhenThen>(); _localctx.val.add(new WhenThen(((WhenThenExprContext)_localctx).e1.val, ((WhenThenExprContext)_localctx).e2.val)); 
			setState(290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(282); match(26);
				setState(283); ((WhenThenExprContext)_localctx).e3 = expr();
				setState(284); match(14);
				setState(285); ((WhenThenExprContext)_localctx).e4 = expr();
				 _localctx.val.add(new WhenThen(((WhenThenExprContext)_localctx).e3.val, ((WhenThenExprContext)_localctx).e4.val)); 
				}
				}
				setState(292);
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
		enterRule(_localctx, 34, RULE_functionExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(293); ((FunctionExprContext)_localctx).id = name();
			setState(294); match(21);
			setState(295); ((FunctionExprContext)_localctx).args = args();
			setState(296); match(44);
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
		enterRule(_localctx, 36, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(299);
			((BooleanLiteralContext)_localctx).tk = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==32 || _la==46) ) {
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
		enterRule(_localctx, 38, RULE_numberExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(302); ((NumberExprContext)_localctx).numtk = match(NUMBER);
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
		enterRule(_localctx, 40, RULE_stringExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(305); ((StringExprContext)_localctx).str = str();
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
		enterRule(_localctx, 42, RULE_groupargs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Integer> _args = new ArrayList<Integer>(); 
			setState(320);
			_la = _input.LA(1);
			if (_la==NUMBER) {
				{
				setState(309); ((GroupargsContext)_localctx).e1 = pint();
				 _args.add(((GroupargsContext)_localctx).e1.val); 
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==24) {
					{
					{
					setState(311); match(24);
					setState(312); ((GroupargsContext)_localctx).e2 = pint();
					 _args.add(((GroupargsContext)_localctx).e2.val); 
					}
					}
					setState(319);
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
		enterRule(_localctx, 44, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Expr> _args = new ArrayList<Expr>(); 
			setState(336);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 8) | (1L << 17) | (1L << 21) | (1L << 28) | (1L << 29) | (1L << 32) | (1L << 46) | (1L << NUMBER) | (1L << ID1) | (1L << ID2) | (1L << STR))) != 0)) {
				{
				setState(325); ((ArgsContext)_localctx).e1 = expr();
				 _args.add(((ArgsContext)_localctx).e1.val); 
				setState(333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==24) {
					{
					{
					setState(327); match(24);
					setState(328); ((ArgsContext)_localctx).e2 = expr();
					 _args.add(((ArgsContext)_localctx).e2.val); 
					}
					}
					setState(335);
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
		enterRule(_localctx, 46, RULE_columnExpr);
		try {
			setState(348);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(340); ((ColumnExprContext)_localctx).id2 = name();
				 ((ColumnExprContext)_localctx).val =  new ColumnExpr(null,      ((ColumnExprContext)_localctx).id2.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(343); ((ColumnExprContext)_localctx).id1 = name();
				setState(344); match(25);
				setState(345); ((ColumnExprContext)_localctx).id2 = name();
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
		enterRule(_localctx, 48, RULE_name);
		try {
			setState(354);
			switch (_input.LA(1)) {
			case ID1:
				enterOuterAlt(_localctx, 1);
				{
				setState(350); ((NameContext)_localctx).ID1 = match(ID1);
				 ((NameContext)_localctx).text =  (((NameContext)_localctx).ID1!=null?((NameContext)_localctx).ID1.getText():null); 
				}
				break;
			case ID2:
				enterOuterAlt(_localctx, 2);
				{
				setState(352); ((NameContext)_localctx).ID2 = match(ID2);
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
		enterRule(_localctx, 50, RULE_str);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(356); ((StrContext)_localctx).STR = match(STR);
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
		enterRule(_localctx, 52, RULE_pint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(359); ((PintContext)_localctx).num = match(NUMBER);
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
		"\2\3\65\u016d\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t"+
		"\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\3\2\3\2\3\2\3\2"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\5\4w\n\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5\177\n\5\f"+
		"\5\16\5\u0082\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u008e\n"+
		"\6\3\7\3\7\3\7\3\7\3\7\5\7\u0095\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u009d"+
		"\n\b\3\t\3\t\3\t\3\t\3\t\5\t\u00a4\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u00ab\n"+
		"\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b8\n\f\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c2\n\r\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\5\16\u00d8\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00e2\n"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
		"\20\3\20\5\20\u010f\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0123\n\22\f\22\16"+
		"\22\u0126\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u013e\n\27"+
		"\f\27\16\27\u0141\13\27\5\27\u0143\n\27\3\27\3\27\3\30\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\7\30\u014e\n\30\f\30\16\30\u0151\13\30\5\30\u0153\n\30"+
		"\3\30\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u015f\n\31\3\32"+
		"\3\32\3\32\3\32\5\32\u0165\n\32\3\33\3\33\3\33\3\34\3\34\3\34\3\34\2\35"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\66\2\n\4\31"+
		"\31&&\4\7\7\26\26\3)*\4\r\r//\3,-\5\21\21$%((\b\16\16\24\24\35\35 !##"+
		"\'\'\4\"\"\60\60\u0176\28\3\2\2\2\4<\3\2\2\2\6v\3\2\2\2\bx\3\2\2\2\n\u008d"+
		"\3\2\2\2\f\u0094\3\2\2\2\16\u009c\3\2\2\2\20\u00a3\3\2\2\2\22\u00aa\3"+
		"\2\2\2\24\u00ac\3\2\2\2\26\u00b7\3\2\2\2\30\u00c1\3\2\2\2\32\u00d7\3\2"+
		"\2\2\34\u00e1\3\2\2\2\36\u010e\3\2\2\2 \u0110\3\2\2\2\"\u0117\3\2\2\2"+
		"$\u0127\3\2\2\2&\u012d\3\2\2\2(\u0130\3\2\2\2*\u0133\3\2\2\2,\u0136\3"+
		"\2\2\2.\u0146\3\2\2\2\60\u015e\3\2\2\2\62\u0164\3\2\2\2\64\u0166\3\2\2"+
		"\2\66\u0169\3\2\2\289\5\4\3\29:\7\25\2\2:;\b\2\1\2;\3\3\2\2\2<=\t\2\2"+
		"\2=>\5\b\5\2>?\t\3\2\2?@\5\6\4\2@A\5\f\7\2AB\5\16\b\2BC\5\20\t\2CD\5\22"+
		"\n\2DE\b\3\1\2E\5\3\2\2\2FG\5\62\32\2GH\7\5\2\2HI\5\62\32\2IJ\b\4\1\2"+
		"Jw\3\2\2\2KL\5\62\32\2LM\5\62\32\2MN\b\4\1\2Nw\3\2\2\2OP\5\62\32\2PQ\b"+
		"\4\1\2Qw\3\2\2\2RS\5\62\32\2ST\7\33\2\2TU\5\62\32\2UV\7\5\2\2VW\5\62\32"+
		"\2WX\b\4\1\2Xw\3\2\2\2YZ\5\62\32\2Z[\7\33\2\2[\\\5\62\32\2\\]\5\62\32"+
		"\2]^\b\4\1\2^w\3\2\2\2_`\5\62\32\2`a\7\33\2\2ab\5\62\32\2bc\b\4\1\2cw"+
		"\3\2\2\2de\7\27\2\2ef\5\4\3\2fg\7.\2\2gh\7\5\2\2hi\5\62\32\2ij\b\4\1\2"+
		"jw\3\2\2\2kl\7\27\2\2lm\5\4\3\2mn\7.\2\2no\5\62\32\2op\b\4\1\2pw\3\2\2"+
		"\2qr\7\27\2\2rs\5\4\3\2st\7.\2\2tu\b\4\1\2uw\3\2\2\2vF\3\2\2\2vK\3\2\2"+
		"\2vO\3\2\2\2vR\3\2\2\2vY\3\2\2\2v_\3\2\2\2vd\3\2\2\2vk\3\2\2\2vq\3\2\2"+
		"\2w\7\3\2\2\2xy\5\n\6\2y\u0080\b\5\1\2z{\7\32\2\2{|\5\n\6\2|}\b\5\1\2"+
		"}\177\3\2\2\2~z\3\2\2\2\177\u0082\3\2\2\2\u0080~\3\2\2\2\u0080\u0081\3"+
		"\2\2\2\u0081\t\3\2\2\2\u0082\u0080\3\2\2\2\u0083\u0084\5\24\13\2\u0084"+
		"\u0085\7\5\2\2\u0085\u0086\5\62\32\2\u0086\u0087\b\6\1\2\u0087\u008e\3"+
		"\2\2\2\u0088\u0089\5\24\13\2\u0089\u008a\b\6\1\2\u008a\u008e\3\2\2\2\u008b"+
		"\u008c\7\30\2\2\u008c\u008e\b\6\1\2\u008d\u0083\3\2\2\2\u008d\u0088\3"+
		"\2\2\2\u008d\u008b\3\2\2\2\u008e\13\3\2\2\2\u008f\u0090\7\t\2\2\u0090"+
		"\u0091\5\24\13\2\u0091\u0092\b\7\1\2\u0092\u0095\3\2\2\2\u0093\u0095\b"+
		"\7\1\2\u0094\u008f\3\2\2\2\u0094\u0093\3\2\2\2\u0095\r\3\2\2\2\u0096\u0097"+
		"\7\22\2\2\u0097\u0098\7\6\2\2\u0098\u0099\5,\27\2\u0099\u009a\b\b\1\2"+
		"\u009a\u009d\3\2\2\2\u009b\u009d\b\b\1\2\u009c\u0096\3\2\2\2\u009c\u009b"+
		"\3\2\2\2\u009d\17\3\2\2\2\u009e\u009f\7+\2\2\u009f\u00a0\5\24\13\2\u00a0"+
		"\u00a1\b\t\1\2\u00a1\u00a4\3\2\2\2\u00a2\u00a4\b\t\1\2\u00a3\u009e\3\2"+
		"\2\2\u00a3\u00a2\3\2\2\2\u00a4\21\3\2\2\2\u00a5\u00a6\7\3\2\2\u00a6\u00a7"+
		"\5\66\34\2\u00a7\u00a8\b\n\1\2\u00a8\u00ab\3\2\2\2\u00a9\u00ab\b\n\1\2"+
		"\u00aa\u00a5\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\23\3\2\2\2\u00ac\u00ad"+
		"\5\26\f\2\u00ad\u00ae\b\13\1\2\u00ae\25\3\2\2\2\u00af\u00b0\5\30\r\2\u00b0"+
		"\u00b1\t\4\2\2\u00b1\u00b2\5\30\r\2\u00b2\u00b3\b\f\1\2\u00b3\u00b8\3"+
		"\2\2\2\u00b4\u00b5\5\30\r\2\u00b5\u00b6\b\f\1\2\u00b6\u00b8\3\2\2\2\u00b7"+
		"\u00af\3\2\2\2\u00b7\u00b4\3\2\2\2\u00b8\27\3\2\2\2\u00b9\u00ba\5\32\16"+
		"\2\u00ba\u00bb\t\5\2\2\u00bb\u00bc\5\32\16\2\u00bc\u00bd\b\r\1\2\u00bd"+
		"\u00c2\3\2\2\2\u00be\u00bf\5\32\16\2\u00bf\u00c0\b\r\1\2\u00c0\u00c2\3"+
		"\2\2\2\u00c1\u00b9\3\2\2\2\u00c1\u00be\3\2\2\2\u00c2\31\3\2\2\2\u00c3"+
		"\u00c4\5\34\17\2\u00c4\u00c5\7\17\2\2\u00c5\u00c6\5\34\17\2\u00c6\u00c7"+
		"\b\16\1\2\u00c7\u00d8\3\2\2\2\u00c8\u00c9\5\34\17\2\u00c9\u00ca\t\6\2"+
		"\2\u00ca\u00cb\7\27\2\2\u00cb\u00cc\5.\30\2\u00cc\u00cd\7.\2\2\u00cd\u00ce"+
		"\b\16\1\2\u00ce\u00d8\3\2\2\2\u00cf\u00d0\5\34\17\2\u00d0\u00d1\7\13\2"+
		"\2\u00d1\u00d2\5\34\17\2\u00d2\u00d3\b\16\1\2\u00d3\u00d8\3\2\2\2\u00d4"+
		"\u00d5\5\34\17\2\u00d5\u00d6\b\16\1\2\u00d6\u00d8\3\2\2\2\u00d7\u00c3"+
		"\3\2\2\2\u00d7\u00c8\3\2\2\2\u00d7\u00cf\3\2\2\2\u00d7\u00d4\3\2\2\2\u00d8"+
		"\33\3\2\2\2\u00d9\u00da\5\36\20\2\u00da\u00db\t\7\2\2\u00db\u00dc\5\36"+
		"\20\2\u00dc\u00dd\b\17\1\2\u00dd\u00e2\3\2\2\2\u00de\u00df\5\36\20\2\u00df"+
		"\u00e0\b\17\1\2\u00e0\u00e2\3\2\2\2\u00e1\u00d9\3\2\2\2\u00e1\u00de\3"+
		"\2\2\2\u00e2\35\3\2\2\2\u00e3\u00e4\5\60\31\2\u00e4\u00e5\b\20\1\2\u00e5"+
		"\u010f\3\2\2\2\u00e6\u00e7\5$\23\2\u00e7\u00e8\b\20\1\2\u00e8\u010f\3"+
		"\2\2\2\u00e9\u00ea\5(\25\2\u00ea\u00eb\b\20\1\2\u00eb\u010f\3\2\2\2\u00ec"+
		"\u00ed\5*\26\2\u00ed\u00ee\b\20\1\2\u00ee\u010f\3\2\2\2\u00ef\u00f0\5"+
		"&\24\2\u00f0\u00f1\b\20\1\2\u00f1\u010f\3\2\2\2\u00f2\u00f3\5 \21\2\u00f3"+
		"\u00f4\b\20\1\2\u00f4\u010f\3\2\2\2\u00f5\u00f6\7\36\2\2\u00f6\u00f7\5"+
		"\24\13\2\u00f7\u00f8\b\20\1\2\u00f8\u010f\3\2\2\2\u00f9\u00fa\7\37\2\2"+
		"\u00fa\u00fb\7\27\2\2\u00fb\u00fc\5\24\13\2\u00fc\u00fd\7\5\2\2\u00fd"+
		"\u00fe\7\4\2\2\u00fe\u00ff\7.\2\2\u00ff\u0100\b\20\1\2\u0100\u010f\3\2"+
		"\2\2\u0101\u0102\7\n\2\2\u0102\u0103\7\27\2\2\u0103\u0104\t\b\2\2\u0104"+
		"\u0105\7\7\2\2\u0105\u0106\5\24\13\2\u0106\u0107\7.\2\2\u0107\u0108\b"+
		"\20\1\2\u0108\u010f\3\2\2\2\u0109\u010a\7\27\2\2\u010a\u010b\5\24\13\2"+
		"\u010b\u010c\7.\2\2\u010c\u010d\b\20\1\2\u010d\u010f\3\2\2\2\u010e\u00e3"+
		"\3\2\2\2\u010e\u00e6\3\2\2\2\u010e\u00e9\3\2\2\2\u010e\u00ec\3\2\2\2\u010e"+
		"\u00ef\3\2\2\2\u010e\u00f2\3\2\2\2\u010e\u00f5\3\2\2\2\u010e\u00f9\3\2"+
		"\2\2\u010e\u0101\3\2\2\2\u010e\u0109\3\2\2\2\u010f\37\3\2\2\2\u0110\u0111"+
		"\7\23\2\2\u0111\u0112\5\"\22\2\u0112\u0113\7\b\2\2\u0113\u0114\5\24\13"+
		"\2\u0114\u0115\7\f\2\2\u0115\u0116\b\21\1\2\u0116!\3\2\2\2\u0117\u0118"+
		"\7\34\2\2\u0118\u0119\5\24\13\2\u0119\u011a\7\20\2\2\u011a\u011b\5\24"+
		"\13\2\u011b\u0124\b\22\1\2\u011c\u011d\7\34\2\2\u011d\u011e\5\24\13\2"+
		"\u011e\u011f\7\20\2\2\u011f\u0120\5\24\13\2\u0120\u0121\b\22\1\2\u0121"+
		"\u0123\3\2\2\2\u0122\u011c\3\2\2\2\u0123\u0126\3\2\2\2\u0124\u0122\3\2"+
		"\2\2\u0124\u0125\3\2\2\2\u0125#\3\2\2\2\u0126\u0124\3\2\2\2\u0127\u0128"+
		"\5\62\32\2\u0128\u0129\7\27\2\2\u0129\u012a\5.\30\2\u012a\u012b\7.\2\2"+
		"\u012b\u012c\b\23\1\2\u012c%\3\2\2\2\u012d\u012e\t\t\2\2\u012e\u012f\b"+
		"\24\1\2\u012f\'\3\2\2\2\u0130\u0131\7\62\2\2\u0131\u0132\b\25\1\2\u0132"+
		")\3\2\2\2\u0133\u0134\5\64\33\2\u0134\u0135\b\26\1\2\u0135+\3\2\2\2\u0136"+
		"\u0142\b\27\1\2\u0137\u0138\5\66\34\2\u0138\u013f\b\27\1\2\u0139\u013a"+
		"\7\32\2\2\u013a\u013b\5\66\34\2\u013b\u013c\b\27\1\2\u013c\u013e\3\2\2"+
		"\2\u013d\u0139\3\2\2\2\u013e\u0141\3\2\2\2\u013f\u013d\3\2\2\2\u013f\u0140"+
		"\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f\3\2\2\2\u0142\u0137\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\u0144\3\2\2\2\u0144\u0145\b\27\1\2\u0145-\3\2\2\2"+
		"\u0146\u0152\b\30\1\2\u0147\u0148\5\24\13\2\u0148\u014f\b\30\1\2\u0149"+
		"\u014a\7\32\2\2\u014a\u014b\5\24\13\2\u014b\u014c\b\30\1\2\u014c\u014e"+
		"\3\2\2\2\u014d\u0149\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u014d\3\2\2\2\u014f"+
		"\u0150\3\2\2\2\u0150\u0153\3\2\2\2\u0151\u014f\3\2\2\2\u0152\u0147\3\2"+
		"\2\2\u0152\u0153\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0155\b\30\1\2\u0155"+
		"/\3\2\2\2\u0156\u0157\5\62\32\2\u0157\u0158\b\31\1\2\u0158\u015f\3\2\2"+
		"\2\u0159\u015a\5\62\32\2\u015a\u015b\7\33\2\2\u015b\u015c\5\62\32\2\u015c"+
		"\u015d\b\31\1\2\u015d\u015f\3\2\2\2\u015e\u0156\3\2\2\2\u015e\u0159\3"+
		"\2\2\2\u015f\61\3\2\2\2\u0160\u0161\7\63\2\2\u0161\u0165\b\32\1\2\u0162"+
		"\u0163\7\64\2\2\u0163\u0165\b\32\1\2\u0164\u0160\3\2\2\2\u0164\u0162\3"+
		"\2\2\2\u0165\63\3\2\2\2\u0166\u0167\7\65\2\2\u0167\u0168\b\33\1\2\u0168"+
		"\65\3\2\2\2\u0169\u016a\7\62\2\2\u016a\u016b\b\34\1\2\u016b\67\3\2\2\2"+
		"\25v\u0080\u008d\u0094\u009c\u00a3\u00aa\u00b7\u00c1\u00d7\u00e1\u010e"+
		"\u0124\u013f\u0142\u014f\u0152\u015e\u0164";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}