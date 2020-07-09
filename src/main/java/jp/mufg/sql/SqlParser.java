// Generated from jp/mufg/sql/Sql.g4 by ANTLR 4.0
package jp.mufg.sql;
 
import jp.mufg.kdbjdbc.SqlExprs.*;
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
		WS=47, NUMBER_LITERAL=48, ID1=49, ID2=50, STR=51;
	public static final String[] tokenNames = {
		"<INVALID>", "'LIMIT'", "'INTEGER'", "'AS'", "'BY'", "'FROM'", "'ELSE'", 
		"'WHERE'", "'EXTRACT'", "'!='", "'END'", "'AND'", "'QUARTER'", "'='", 
		"'THEN'", "'<='", "'GROUP'", "'CASE'", "'SECOND'", "'$'", "'from'", "'('", 
		"'*'", "'SELECT'", "','", "'.'", "'WHEN'", "'MINUTE'", "'DISTINCT'", "'CAST'", 
		"'MONTH'", "'DAY'", "'FALSE'", "'HOUR'", "'>='", "'<'", "'select'", "'YEAR'", 
		"'>'", "'OR'", "'or'", "'HAVING'", "'IN'", "'in'", "')'", "'and'", "'TRUE'", 
		"WS", "NUMBER_LITERAL", "ID1", "ID2", "STR"
	};
	public static final int
		RULE_selectStmtWhole = 0, RULE_selectStmt = 1, RULE_table = 2, RULE_columnNames = 3, 
		RULE_columnName = 4, RULE_where = 5, RULE_groupBy = 6, RULE_having = 7, 
		RULE_limit = 8, RULE_expr = 9, RULE_orExpr = 10, RULE_andExpr = 11, RULE_eqExpr = 12, 
		RULE_compExpr = 13, RULE_primaryExpr = 14, RULE_caseExpr = 15, RULE_whenThenExpr = 16, 
		RULE_functionExpr = 17, RULE_booleanLiteral = 18, RULE_numberLiteral = 19, 
		RULE_stringLiteral = 20, RULE_groupargs = 21, RULE_grouparg = 22, RULE_args = 23, 
		RULE_columnExpr = 24, RULE_name = 25, RULE_str = 26, RULE_pint = 27;
	public static final String[] ruleNames = {
		"selectStmtWhole", "selectStmt", "table", "columnNames", "columnName", 
		"where", "groupBy", "having", "limit", "expr", "orExpr", "andExpr", "eqExpr", 
		"compExpr", "primaryExpr", "caseExpr", "whenThenExpr", "functionExpr", 
		"booleanLiteral", "numberLiteral", "stringLiteral", "groupargs", "grouparg", 
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
			setState(56); ((SelectStmtWholeContext)_localctx).selectStmt = selectStmt();
			setState(57); match(19);
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
			setState(60);
			_la = _input.LA(1);
			if ( !(_la==23 || _la==36) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(61); ((SelectStmtContext)_localctx).columnNames = columnNames();
			setState(62);
			_la = _input.LA(1);
			if ( !(_la==5 || _la==20) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(63); ((SelectStmtContext)_localctx).table = table();
			setState(64); ((SelectStmtContext)_localctx).where = where();
			setState(65); ((SelectStmtContext)_localctx).groupBy = groupBy();
			setState(66); ((SelectStmtContext)_localctx).having = having();
			setState(67); ((SelectStmtContext)_localctx).limit = limit();
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
			setState(118);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70); ((TableContext)_localctx).t = name();
				setState(71); match(3);
				setState(72); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(75); ((TableContext)_localctx).t = name();
				setState(76); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(79); ((TableContext)_localctx).t = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, null   ); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(82); name();
				setState(83); match(25);
				setState(84); ((TableContext)_localctx).t = name();
				setState(85); match(3);
				setState(86); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(89); name();
				setState(90); match(25);
				setState(91); ((TableContext)_localctx).t = name();
				setState(92); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(95); name();
				setState(96); match(25);
				setState(97); ((TableContext)_localctx).t = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, null   ); 
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(100); match(21);
				setState(101); ((TableContext)_localctx).selectStmt = selectStmt();
				setState(102); match(44);
				setState(103); match(3);
				setState(104); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableSelect(((TableContext)_localctx).selectStmt.val, ((TableContext)_localctx).a.text); 
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(107); match(21);
				setState(108); ((TableContext)_localctx).selectStmt = selectStmt();
				setState(109); match(44);
				setState(110); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableSelect(((TableContext)_localctx).selectStmt.val, ((TableContext)_localctx).a.text); 
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(113); match(21);
				setState(114); ((TableContext)_localctx).selectStmt = selectStmt();
				setState(115); match(44);
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
			setState(120); ((ColumnNamesContext)_localctx).c1 = columnName();
			 ((ColumnNamesContext)_localctx).columns =  new LinkedList<Column>(); _localctx.columns.add(((ColumnNamesContext)_localctx).c1.val); 
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==24) {
				{
				{
				setState(122); match(24);
				setState(123); ((ColumnNamesContext)_localctx).c2 = columnName();
				 _localctx.columns.add(((ColumnNamesContext)_localctx).c2.val); 
				}
				}
				setState(130);
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
			setState(141);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(131); ((ColumnNameContext)_localctx).expr = expr();
				setState(132); match(3);
				setState(133); ((ColumnNameContext)_localctx).id = name();
				 ((ColumnNameContext)_localctx).val =  new ColumnImpl(((ColumnNameContext)_localctx).expr.val, ((ColumnNameContext)_localctx).id.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(136); ((ColumnNameContext)_localctx).expr = expr();
				 ((ColumnNameContext)_localctx).val =  new ColumnImpl(((ColumnNameContext)_localctx).expr.val, null); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(139); match(22);
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
			setState(148);
			switch (_input.LA(1)) {
			case 7:
				enterOuterAlt(_localctx, 1);
				{
				setState(143); match(7);
				setState(144); ((WhereContext)_localctx).expr = expr();
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
		public List<GroupArg> val;
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
			setState(156);
			switch (_input.LA(1)) {
			case 16:
				enterOuterAlt(_localctx, 1);
				{
				setState(150); match(16);
				setState(151); match(4);
				setState(152); ((GroupByContext)_localctx).groupargs = groupargs();
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
			setState(163);
			switch (_input.LA(1)) {
			case 41:
				enterOuterAlt(_localctx, 1);
				{
				setState(158); match(41);
				setState(159); ((HavingContext)_localctx).expr = expr();
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
			setState(170);
			switch (_input.LA(1)) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(165); match(1);
				setState(166); ((LimitContext)_localctx).pint = pint();
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
			setState(172); ((ExprContext)_localctx).lhs = orExpr();
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
			setState(183);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(175); ((OrExprContext)_localctx).lhs = andExpr();
				setState(176);
				((OrExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==39 || _la==40) ) {
					((OrExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(177); ((OrExprContext)_localctx).rhs = andExpr();
				 ((OrExprContext)_localctx).val =  new BinaryExpr((((OrExprContext)_localctx).op!=null?((OrExprContext)_localctx).op.getText():null), ((OrExprContext)_localctx).lhs.val, ((OrExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(180); ((OrExprContext)_localctx).lhs = andExpr();
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
			setState(193);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(185); ((AndExprContext)_localctx).lhs = eqExpr();
				setState(186);
				((AndExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==11 || _la==45) ) {
					((AndExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(187); ((AndExprContext)_localctx).rhs = eqExpr();
				 ((AndExprContext)_localctx).val =  new BinaryExpr((((AndExprContext)_localctx).op!=null?((AndExprContext)_localctx).op.getText():null), ((AndExprContext)_localctx).lhs.val, ((AndExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(190); ((AndExprContext)_localctx).lhs = eqExpr();
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
			setState(215);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195); ((EqExprContext)_localctx).lhs = compExpr();
				setState(196); ((EqExprContext)_localctx).op = match(13);
				setState(197); ((EqExprContext)_localctx).rhs = compExpr();
				 ((EqExprContext)_localctx).val =  new EqExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).rhs.val);  
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(200); ((EqExprContext)_localctx).lhs = compExpr();
				setState(201);
				((EqExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==42 || _la==43) ) {
					((EqExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(202); match(21);
				setState(203); ((EqExprContext)_localctx).a = args();
				setState(204); match(44);
				 ((EqExprContext)_localctx).a.val.setWithCurry(true); ((EqExprContext)_localctx).val =  new EqExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).a.val);  
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(207); ((EqExprContext)_localctx).lhs = compExpr();
				setState(208); ((EqExprContext)_localctx).op = match(9);
				setState(209); ((EqExprContext)_localctx).rhs = compExpr();
				 ((EqExprContext)_localctx).val =  new BinaryExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).rhs.val);  
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(212); ((EqExprContext)_localctx).lhs = compExpr();
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
			setState(225);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(217); ((CompExprContext)_localctx).lhs = primaryExpr();
				setState(218);
				((CompExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 15) | (1L << 34) | (1L << 35) | (1L << 38))) != 0)) ) {
					((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(219); ((CompExprContext)_localctx).rhs = primaryExpr();
				 ((CompExprContext)_localctx).val =  new BinaryExpr((((CompExprContext)_localctx).op!=null?((CompExprContext)_localctx).op.getText():null), ((CompExprContext)_localctx).lhs.val, ((CompExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(222); ((CompExprContext)_localctx).lhs = primaryExpr();
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
		public NumberLiteralContext numberLiteral;
		public StringLiteralContext stringLiteral;
		public BooleanLiteralContext booleanLiteral;
		public CaseExprContext caseExpr;
		public ExprContext expr;
		public Token type;
		public ColumnExprContext columnExpr() {
			return getRuleContext(ColumnExprContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
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
		public NumberLiteralContext numberLiteral() {
			return getRuleContext(NumberLiteralContext.class,0);
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
			setState(270);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(227); ((PrimaryExprContext)_localctx).e1 = columnExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).e1.val; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(230); ((PrimaryExprContext)_localctx).functionExpr = functionExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).functionExpr.val; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(233); ((PrimaryExprContext)_localctx).numberLiteral = numberLiteral();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).numberLiteral.val; 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(236); ((PrimaryExprContext)_localctx).stringLiteral = stringLiteral();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).stringLiteral.val; 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(239); ((PrimaryExprContext)_localctx).booleanLiteral = booleanLiteral();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).booleanLiteral.val; 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(242); ((PrimaryExprContext)_localctx).caseExpr = caseExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).caseExpr.val; 
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(245); match(28);
				setState(246); ((PrimaryExprContext)_localctx).expr = expr();
				 ((PrimaryExprContext)_localctx).val =  new DistinctExpr(((PrimaryExprContext)_localctx).expr.val); 
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(249); match(29);
				setState(250); match(21);
				setState(251); ((PrimaryExprContext)_localctx).expr = expr();
				setState(252); match(3);
				setState(253); ((PrimaryExprContext)_localctx).type = match(2);
				setState(254); match(44);
				 ((PrimaryExprContext)_localctx).val =  new CastExpr(((PrimaryExprContext)_localctx).expr.val, (((PrimaryExprContext)_localctx).type!=null?((PrimaryExprContext)_localctx).type.getText():null)); 
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(257); match(8);
				setState(258); match(21);
				setState(259);
				((PrimaryExprContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 12) | (1L << 18) | (1L << 27) | (1L << 30) | (1L << 31) | (1L << 33) | (1L << 37))) != 0)) ) {
					((PrimaryExprContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(260); match(5);
				setState(261); ((PrimaryExprContext)_localctx).expr = expr();
				setState(262); match(44);
				 ((PrimaryExprContext)_localctx).val =  new ExtractExpr(((PrimaryExprContext)_localctx).expr.val, (((PrimaryExprContext)_localctx).type!=null?((PrimaryExprContext)_localctx).type.getText():null)); 
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(265); match(21);
				setState(266); ((PrimaryExprContext)_localctx).expr = expr();
				setState(267); match(44);
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
			setState(272); match(17);
			setState(273); ((CaseExprContext)_localctx).wt = whenThenExpr();
			setState(274); match(6);
			setState(275); ((CaseExprContext)_localctx).e = expr();
			setState(276); match(10);
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
			setState(279); match(26);
			setState(280); ((WhenThenExprContext)_localctx).e1 = expr();
			setState(281); match(14);
			setState(282); ((WhenThenExprContext)_localctx).e2 = expr();
			 ((WhenThenExprContext)_localctx).val =  new LinkedList<WhenThen>(); _localctx.val.add(new WhenThen(((WhenThenExprContext)_localctx).e1.val, ((WhenThenExprContext)_localctx).e2.val)); 
			setState(292);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==26) {
				{
				{
				setState(284); match(26);
				setState(285); ((WhenThenExprContext)_localctx).e3 = expr();
				setState(286); match(14);
				setState(287); ((WhenThenExprContext)_localctx).e4 = expr();
				 _localctx.val.add(new WhenThen(((WhenThenExprContext)_localctx).e3.val, ((WhenThenExprContext)_localctx).e4.val)); 
				}
				}
				setState(294);
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
			setState(295); ((FunctionExprContext)_localctx).id = name();
			setState(296); match(21);
			setState(297); ((FunctionExprContext)_localctx).args = args();
			setState(298); match(44);
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
			setState(301);
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

	public static class NumberLiteralContext extends ParserRuleContext {
		public NumberLiteral val;
		public Token numtk;
		public TerminalNode NUMBER_LITERAL() { return getToken(SqlParser.NUMBER_LITERAL, 0); }
		public NumberLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_numberLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterNumberLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitNumberLiteral(this);
		}
	}

	public final NumberLiteralContext numberLiteral() throws RecognitionException {
		NumberLiteralContext _localctx = new NumberLiteralContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_numberLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304); ((NumberLiteralContext)_localctx).numtk = match(NUMBER_LITERAL);
			 ((NumberLiteralContext)_localctx).val =  new NumberLiteral((((NumberLiteralContext)_localctx).numtk!=null?((NumberLiteralContext)_localctx).numtk.getText():null)); 
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

	public static class StringLiteralContext extends ParserRuleContext {
		public StringLiteral val;
		public StrContext str;
		public StrContext str() {
			return getRuleContext(StrContext.class,0);
		}
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterStringLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitStringLiteral(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(307); ((StringLiteralContext)_localctx).str = str();
			 ((StringLiteralContext)_localctx).val =  new StringLiteral(((StringLiteralContext)_localctx).str.text); 
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
		public List<GroupArg> val;
		public GroupargContext e1;
		public GroupargContext e2;
		public GroupargContext grouparg(int i) {
			return getRuleContext(GroupargContext.class,i);
		}
		public List<GroupargContext> grouparg() {
			return getRuleContexts(GroupargContext.class);
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
			 List<GroupArg> _args = new ArrayList<GroupArg>(); 
			setState(322);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 8) | (1L << 17) | (1L << 21) | (1L << 28) | (1L << 29) | (1L << 32) | (1L << 46) | (1L << NUMBER_LITERAL) | (1L << ID1) | (1L << ID2) | (1L << STR))) != 0)) {
				{
				setState(311); ((GroupargsContext)_localctx).e1 = grouparg();
				 _args.add(((GroupargsContext)_localctx).e1.val); 
				setState(319);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==24) {
					{
					{
					setState(313); match(24);
					setState(314); ((GroupargsContext)_localctx).e2 = grouparg();
					 _args.add(((GroupargsContext)_localctx).e2.val); 
					}
					}
					setState(321);
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

	public static class GroupargContext extends ParserRuleContext {
		public GroupArg val;
		public PintContext pint;
		public ExprContext expr;
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public PintContext pint() {
			return getRuleContext(PintContext.class,0);
		}
		public GroupargContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grouparg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterGrouparg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitGrouparg(this);
		}
	}

	public final GroupargContext grouparg() throws RecognitionException {
		GroupargContext _localctx = new GroupargContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_grouparg);
		try {
			setState(332);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(326); ((GroupargContext)_localctx).pint = pint();
				 ((GroupargContext)_localctx).val =  new ColumnNumberArg(((GroupargContext)_localctx).pint.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(329); ((GroupargContext)_localctx).expr = expr();
				 ((GroupargContext)_localctx).val =  new GroupExpr(((GroupargContext)_localctx).expr.val);       
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
		enterRule(_localctx, 46, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Expr> _args = new ArrayList<Expr>(); 
			setState(346);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 8) | (1L << 17) | (1L << 21) | (1L << 28) | (1L << 29) | (1L << 32) | (1L << 46) | (1L << NUMBER_LITERAL) | (1L << ID1) | (1L << ID2) | (1L << STR))) != 0)) {
				{
				setState(335); ((ArgsContext)_localctx).e1 = expr();
				 _args.add(((ArgsContext)_localctx).e1.val); 
				setState(343);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==24) {
					{
					{
					setState(337); match(24);
					setState(338); ((ArgsContext)_localctx).e2 = expr();
					 _args.add(((ArgsContext)_localctx).e2.val); 
					}
					}
					setState(345);
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
		enterRule(_localctx, 48, RULE_columnExpr);
		try {
			setState(358);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(350); ((ColumnExprContext)_localctx).id2 = name();
				 ((ColumnExprContext)_localctx).val =  new ColumnExpr(null,      ((ColumnExprContext)_localctx).id2.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(353); ((ColumnExprContext)_localctx).id1 = name();
				setState(354); match(25);
				setState(355); ((ColumnExprContext)_localctx).id2 = name();
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
		enterRule(_localctx, 50, RULE_name);
		try {
			setState(364);
			switch (_input.LA(1)) {
			case ID1:
				enterOuterAlt(_localctx, 1);
				{
				setState(360); ((NameContext)_localctx).ID1 = match(ID1);
				 ((NameContext)_localctx).text =  (((NameContext)_localctx).ID1!=null?((NameContext)_localctx).ID1.getText():null); 
				}
				break;
			case ID2:
				enterOuterAlt(_localctx, 2);
				{
				setState(362); ((NameContext)_localctx).ID2 = match(ID2);
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
		enterRule(_localctx, 52, RULE_str);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366); ((StrContext)_localctx).STR = match(STR);
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
		public TerminalNode NUMBER_LITERAL() { return getToken(SqlParser.NUMBER_LITERAL, 0); }
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
		enterRule(_localctx, 54, RULE_pint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369); ((PintContext)_localctx).num = match(NUMBER_LITERAL);
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
		"\2\3\65\u0177\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b"+
		"\4\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t"+
		"\20\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t"+
		"\27\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3"+
		"\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4y\n\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5"+
		"\u0081\n\5\f\5\16\5\u0084\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\5\6\u0090\n\6\3\7\3\7\3\7\3\7\3\7\5\7\u0097\n\7\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\5\b\u009f\n\b\3\t\3\t\3\t\3\t\3\t\5\t\u00a6\n\t\3\n\3\n\3\n\3\n\3\n"+
		"\5\n\u00ad\n\n\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00ba"+
		"\n\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c4\n\r\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16"+
		"\3\16\3\16\5\16\u00da\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00e4\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\5\20\u0111\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u0125\n\22\f\22"+
		"\16\22\u0128\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\24\3\24\3\24\3\25\3"+
		"\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27\7\27\u0140"+
		"\n\27\f\27\16\27\u0143\13\27\5\27\u0145\n\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\5\30\u014f\n\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\7\31"+
		"\u0158\n\31\f\31\16\31\u015b\13\31\5\31\u015d\n\31\3\31\3\31\3\32\3\32"+
		"\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0169\n\32\3\33\3\33\3\33\3\33\5\33"+
		"\u016f\n\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\2\36\2\4\6\b\n\f\16\20"+
		"\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668\2\n\4\31\31&&\4\7\7\26\26"+
		"\3)*\4\r\r//\3,-\5\21\21$%((\b\16\16\24\24\35\35 !##\'\'\4\"\"\60\60\u0180"+
		"\2:\3\2\2\2\4>\3\2\2\2\6x\3\2\2\2\bz\3\2\2\2\n\u008f\3\2\2\2\f\u0096\3"+
		"\2\2\2\16\u009e\3\2\2\2\20\u00a5\3\2\2\2\22\u00ac\3\2\2\2\24\u00ae\3\2"+
		"\2\2\26\u00b9\3\2\2\2\30\u00c3\3\2\2\2\32\u00d9\3\2\2\2\34\u00e3\3\2\2"+
		"\2\36\u0110\3\2\2\2 \u0112\3\2\2\2\"\u0119\3\2\2\2$\u0129\3\2\2\2&\u012f"+
		"\3\2\2\2(\u0132\3\2\2\2*\u0135\3\2\2\2,\u0138\3\2\2\2.\u014e\3\2\2\2\60"+
		"\u0150\3\2\2\2\62\u0168\3\2\2\2\64\u016e\3\2\2\2\66\u0170\3\2\2\28\u0173"+
		"\3\2\2\2:;\5\4\3\2;<\7\25\2\2<=\b\2\1\2=\3\3\2\2\2>?\t\2\2\2?@\5\b\5\2"+
		"@A\t\3\2\2AB\5\6\4\2BC\5\f\7\2CD\5\16\b\2DE\5\20\t\2EF\5\22\n\2FG\b\3"+
		"\1\2G\5\3\2\2\2HI\5\64\33\2IJ\7\5\2\2JK\5\64\33\2KL\b\4\1\2Ly\3\2\2\2"+
		"MN\5\64\33\2NO\5\64\33\2OP\b\4\1\2Py\3\2\2\2QR\5\64\33\2RS\b\4\1\2Sy\3"+
		"\2\2\2TU\5\64\33\2UV\7\33\2\2VW\5\64\33\2WX\7\5\2\2XY\5\64\33\2YZ\b\4"+
		"\1\2Zy\3\2\2\2[\\\5\64\33\2\\]\7\33\2\2]^\5\64\33\2^_\5\64\33\2_`\b\4"+
		"\1\2`y\3\2\2\2ab\5\64\33\2bc\7\33\2\2cd\5\64\33\2de\b\4\1\2ey\3\2\2\2"+
		"fg\7\27\2\2gh\5\4\3\2hi\7.\2\2ij\7\5\2\2jk\5\64\33\2kl\b\4\1\2ly\3\2\2"+
		"\2mn\7\27\2\2no\5\4\3\2op\7.\2\2pq\5\64\33\2qr\b\4\1\2ry\3\2\2\2st\7\27"+
		"\2\2tu\5\4\3\2uv\7.\2\2vw\b\4\1\2wy\3\2\2\2xH\3\2\2\2xM\3\2\2\2xQ\3\2"+
		"\2\2xT\3\2\2\2x[\3\2\2\2xa\3\2\2\2xf\3\2\2\2xm\3\2\2\2xs\3\2\2\2y\7\3"+
		"\2\2\2z{\5\n\6\2{\u0082\b\5\1\2|}\7\32\2\2}~\5\n\6\2~\177\b\5\1\2\177"+
		"\u0081\3\2\2\2\u0080|\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2"+
		"\u0082\u0083\3\2\2\2\u0083\t\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0086\5"+
		"\24\13\2\u0086\u0087\7\5\2\2\u0087\u0088\5\64\33\2\u0088\u0089\b\6\1\2"+
		"\u0089\u0090\3\2\2\2\u008a\u008b\5\24\13\2\u008b\u008c\b\6\1\2\u008c\u0090"+
		"\3\2\2\2\u008d\u008e\7\30\2\2\u008e\u0090\b\6\1\2\u008f\u0085\3\2\2\2"+
		"\u008f\u008a\3\2\2\2\u008f\u008d\3\2\2\2\u0090\13\3\2\2\2\u0091\u0092"+
		"\7\t\2\2\u0092\u0093\5\24\13\2\u0093\u0094\b\7\1\2\u0094\u0097\3\2\2\2"+
		"\u0095\u0097\b\7\1\2\u0096\u0091\3\2\2\2\u0096\u0095\3\2\2\2\u0097\r\3"+
		"\2\2\2\u0098\u0099\7\22\2\2\u0099\u009a\7\6\2\2\u009a\u009b\5,\27\2\u009b"+
		"\u009c\b\b\1\2\u009c\u009f\3\2\2\2\u009d\u009f\b\b\1\2\u009e\u0098\3\2"+
		"\2\2\u009e\u009d\3\2\2\2\u009f\17\3\2\2\2\u00a0\u00a1\7+\2\2\u00a1\u00a2"+
		"\5\24\13\2\u00a2\u00a3\b\t\1\2\u00a3\u00a6\3\2\2\2\u00a4\u00a6\b\t\1\2"+
		"\u00a5\u00a0\3\2\2\2\u00a5\u00a4\3\2\2\2\u00a6\21\3\2\2\2\u00a7\u00a8"+
		"\7\3\2\2\u00a8\u00a9\58\35\2\u00a9\u00aa\b\n\1\2\u00aa\u00ad\3\2\2\2\u00ab"+
		"\u00ad\b\n\1\2\u00ac\u00a7\3\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\23\3\2\2"+
		"\2\u00ae\u00af\5\26\f\2\u00af\u00b0\b\13\1\2\u00b0\25\3\2\2\2\u00b1\u00b2"+
		"\5\30\r\2\u00b2\u00b3\t\4\2\2\u00b3\u00b4\5\30\r\2\u00b4\u00b5\b\f\1\2"+
		"\u00b5\u00ba\3\2\2\2\u00b6\u00b7\5\30\r\2\u00b7\u00b8\b\f\1\2\u00b8\u00ba"+
		"\3\2\2\2\u00b9\u00b1\3\2\2\2\u00b9\u00b6\3\2\2\2\u00ba\27\3\2\2\2\u00bb"+
		"\u00bc\5\32\16\2\u00bc\u00bd\t\5\2\2\u00bd\u00be\5\32\16\2\u00be\u00bf"+
		"\b\r\1\2\u00bf\u00c4\3\2\2\2\u00c0\u00c1\5\32\16\2\u00c1\u00c2\b\r\1\2"+
		"\u00c2\u00c4\3\2\2\2\u00c3\u00bb\3\2\2\2\u00c3\u00c0\3\2\2\2\u00c4\31"+
		"\3\2\2\2\u00c5\u00c6\5\34\17\2\u00c6\u00c7\7\17\2\2\u00c7\u00c8\5\34\17"+
		"\2\u00c8\u00c9\b\16\1\2\u00c9\u00da\3\2\2\2\u00ca\u00cb\5\34\17\2\u00cb"+
		"\u00cc\t\6\2\2\u00cc\u00cd\7\27\2\2\u00cd\u00ce\5\60\31\2\u00ce\u00cf"+
		"\7.\2\2\u00cf\u00d0\b\16\1\2\u00d0\u00da\3\2\2\2\u00d1\u00d2\5\34\17\2"+
		"\u00d2\u00d3\7\13\2\2\u00d3\u00d4\5\34\17\2\u00d4\u00d5\b\16\1\2\u00d5"+
		"\u00da\3\2\2\2\u00d6\u00d7\5\34\17\2\u00d7\u00d8\b\16\1\2\u00d8\u00da"+
		"\3\2\2\2\u00d9\u00c5\3\2\2\2\u00d9\u00ca\3\2\2\2\u00d9\u00d1\3\2\2\2\u00d9"+
		"\u00d6\3\2\2\2\u00da\33\3\2\2\2\u00db\u00dc\5\36\20\2\u00dc\u00dd\t\7"+
		"\2\2\u00dd\u00de\5\36\20\2\u00de\u00df\b\17\1\2\u00df\u00e4\3\2\2\2\u00e0"+
		"\u00e1\5\36\20\2\u00e1\u00e2\b\17\1\2\u00e2\u00e4\3\2\2\2\u00e3\u00db"+
		"\3\2\2\2\u00e3\u00e0\3\2\2\2\u00e4\35\3\2\2\2\u00e5\u00e6\5\62\32\2\u00e6"+
		"\u00e7\b\20\1\2\u00e7\u0111\3\2\2\2\u00e8\u00e9\5$\23\2\u00e9\u00ea\b"+
		"\20\1\2\u00ea\u0111\3\2\2\2\u00eb\u00ec\5(\25\2\u00ec\u00ed\b\20\1\2\u00ed"+
		"\u0111\3\2\2\2\u00ee\u00ef\5*\26\2\u00ef\u00f0\b\20\1\2\u00f0\u0111\3"+
		"\2\2\2\u00f1\u00f2\5&\24\2\u00f2\u00f3\b\20\1\2\u00f3\u0111\3\2\2\2\u00f4"+
		"\u00f5\5 \21\2\u00f5\u00f6\b\20\1\2\u00f6\u0111\3\2\2\2\u00f7\u00f8\7"+
		"\36\2\2\u00f8\u00f9\5\24\13\2\u00f9\u00fa\b\20\1\2\u00fa\u0111\3\2\2\2"+
		"\u00fb\u00fc\7\37\2\2\u00fc\u00fd\7\27\2\2\u00fd\u00fe\5\24\13\2\u00fe"+
		"\u00ff\7\5\2\2\u00ff\u0100\7\4\2\2\u0100\u0101\7.\2\2\u0101\u0102\b\20"+
		"\1\2\u0102\u0111\3\2\2\2\u0103\u0104\7\n\2\2\u0104\u0105\7\27\2\2\u0105"+
		"\u0106\t\b\2\2\u0106\u0107\7\7\2\2\u0107\u0108\5\24\13\2\u0108\u0109\7"+
		".\2\2\u0109\u010a\b\20\1\2\u010a\u0111\3\2\2\2\u010b\u010c\7\27\2\2\u010c"+
		"\u010d\5\24\13\2\u010d\u010e\7.\2\2\u010e\u010f\b\20\1\2\u010f\u0111\3"+
		"\2\2\2\u0110\u00e5\3\2\2\2\u0110\u00e8\3\2\2\2\u0110\u00eb\3\2\2\2\u0110"+
		"\u00ee\3\2\2\2\u0110\u00f1\3\2\2\2\u0110\u00f4\3\2\2\2\u0110\u00f7\3\2"+
		"\2\2\u0110\u00fb\3\2\2\2\u0110\u0103\3\2\2\2\u0110\u010b\3\2\2\2\u0111"+
		"\37\3\2\2\2\u0112\u0113\7\23\2\2\u0113\u0114\5\"\22\2\u0114\u0115\7\b"+
		"\2\2\u0115\u0116\5\24\13\2\u0116\u0117\7\f\2\2\u0117\u0118\b\21\1\2\u0118"+
		"!\3\2\2\2\u0119\u011a\7\34\2\2\u011a\u011b\5\24\13\2\u011b\u011c\7\20"+
		"\2\2\u011c\u011d\5\24\13\2\u011d\u0126\b\22\1\2\u011e\u011f\7\34\2\2\u011f"+
		"\u0120\5\24\13\2\u0120\u0121\7\20\2\2\u0121\u0122\5\24\13\2\u0122\u0123"+
		"\b\22\1\2\u0123\u0125\3\2\2\2\u0124\u011e\3\2\2\2\u0125\u0128\3\2\2\2"+
		"\u0126\u0124\3\2\2\2\u0126\u0127\3\2\2\2\u0127#\3\2\2\2\u0128\u0126\3"+
		"\2\2\2\u0129\u012a\5\64\33\2\u012a\u012b\7\27\2\2\u012b\u012c\5\60\31"+
		"\2\u012c\u012d\7.\2\2\u012d\u012e\b\23\1\2\u012e%\3\2\2\2\u012f\u0130"+
		"\t\t\2\2\u0130\u0131\b\24\1\2\u0131\'\3\2\2\2\u0132\u0133\7\62\2\2\u0133"+
		"\u0134\b\25\1\2\u0134)\3\2\2\2\u0135\u0136\5\66\34\2\u0136\u0137\b\26"+
		"\1\2\u0137+\3\2\2\2\u0138\u0144\b\27\1\2\u0139\u013a\5.\30\2\u013a\u0141"+
		"\b\27\1\2\u013b\u013c\7\32\2\2\u013c\u013d\5.\30\2\u013d\u013e\b\27\1"+
		"\2\u013e\u0140\3\2\2\2\u013f\u013b\3\2\2\2\u0140\u0143\3\2\2\2\u0141\u013f"+
		"\3\2\2\2\u0141\u0142\3\2\2\2\u0142\u0145\3\2\2\2\u0143\u0141\3\2\2\2\u0144"+
		"\u0139\3\2\2\2\u0144\u0145\3\2\2\2\u0145\u0146\3\2\2\2\u0146\u0147\b\27"+
		"\1\2\u0147-\3\2\2\2\u0148\u0149\58\35\2\u0149\u014a\b\30\1\2\u014a\u014f"+
		"\3\2\2\2\u014b\u014c\5\24\13\2\u014c\u014d\b\30\1\2\u014d\u014f\3\2\2"+
		"\2\u014e\u0148\3\2\2\2\u014e\u014b\3\2\2\2\u014f/\3\2\2\2\u0150\u015c"+
		"\b\31\1\2\u0151\u0152\5\24\13\2\u0152\u0159\b\31\1\2\u0153\u0154\7\32"+
		"\2\2\u0154\u0155\5\24\13\2\u0155\u0156\b\31\1\2\u0156\u0158\3\2\2\2\u0157"+
		"\u0153\3\2\2\2\u0158\u015b\3\2\2\2\u0159\u0157\3\2\2\2\u0159\u015a\3\2"+
		"\2\2\u015a\u015d\3\2\2\2\u015b\u0159\3\2\2\2\u015c\u0151\3\2\2\2\u015c"+
		"\u015d\3\2\2\2\u015d\u015e\3\2\2\2\u015e\u015f\b\31\1\2\u015f\61\3\2\2"+
		"\2\u0160\u0161\5\64\33\2\u0161\u0162\b\32\1\2\u0162\u0169\3\2\2\2\u0163"+
		"\u0164\5\64\33\2\u0164\u0165\7\33\2\2\u0165\u0166\5\64\33\2\u0166\u0167"+
		"\b\32\1\2\u0167\u0169\3\2\2\2\u0168\u0160\3\2\2\2\u0168\u0163\3\2\2\2"+
		"\u0169\63\3\2\2\2\u016a\u016b\7\63\2\2\u016b\u016f\b\33\1\2\u016c\u016d"+
		"\7\64\2\2\u016d\u016f\b\33\1\2\u016e\u016a\3\2\2\2\u016e\u016c\3\2\2\2"+
		"\u016f\65\3\2\2\2\u0170\u0171\7\65\2\2\u0171\u0172\b\34\1\2\u0172\67\3"+
		"\2\2\2\u0173\u0174\7\62\2\2\u0174\u0175\b\35\1\2\u01759\3\2\2\2\26x\u0082"+
		"\u008f\u0096\u009e\u00a5\u00ac\u00b9\u00c3\u00d9\u00e3\u0110\u0126\u0141"+
		"\u0144\u014e\u0159\u015c\u0168\u016e";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}