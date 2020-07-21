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
		T__54=1, T__53=2, T__52=3, T__51=4, T__50=5, T__49=6, T__48=7, T__47=8, 
		T__46=9, T__45=10, T__44=11, T__43=12, T__42=13, T__41=14, T__40=15, T__39=16, 
		T__38=17, T__37=18, T__36=19, T__35=20, T__34=21, T__33=22, T__32=23, 
		T__31=24, T__30=25, T__29=26, T__28=27, T__27=28, T__26=29, T__25=30, 
		T__24=31, T__23=32, T__22=33, T__21=34, T__20=35, T__19=36, T__18=37, 
		T__17=38, T__16=39, T__15=40, T__14=41, T__13=42, T__12=43, T__11=44, 
		T__10=45, T__9=46, T__8=47, T__7=48, T__6=49, T__5=50, T__4=51, T__3=52, 
		T__2=53, T__1=54, T__0=55, WS=56, NUMBER_LITERAL=57, ID1=58, ID2=59, STR=60;
	public static final String[] tokenNames = {
		"<INVALID>", "'INTERVAL'", "'INTEGER'", "'FROM'", "'!='", "'QUARTER'", 
		"'='", "'GROUP'", "'CASE'", "'$'", "'CURRENT_DATE'", "'('", "','", "'DISTINCT'", 
		"'CAST'", "'MONTH'", "'FALSE'", "'HOUR'", "'>='", "'<'", "'YEAR'", "'HAVING'", 
		"'TIMESTAMP'", "'+'", "'TRUE'", "'/'", "'LIMIT'", "'AS'", "'BY'", "'ELSE'", 
		"'WHERE'", "'EXTRACT'", "'END'", "'AND'", "'THEN'", "'<='", "'SECOND'", 
		"'from'", "'*'", "'SELECT'", "'OFFSET'", "'.'", "'WHEN'", "'MINUTE'", 
		"'TEXT'", "'DATE'", "'DAY'", "'select'", "'>'", "'OR'", "'or'", "'IN'", 
		"'in'", "')'", "'and'", "'-'", "WS", "NUMBER_LITERAL", "ID1", "ID2", "STR"
	};
	public static final int
		RULE_selectStmtWhole = 0, RULE_selectStmt = 1, RULE_table = 2, RULE_columnNames = 3, 
		RULE_columnName = 4, RULE_where = 5, RULE_groupBy = 6, RULE_having = 7, 
		RULE_limit = 8, RULE_offset = 9, RULE_expr = 10, RULE_orExpr = 11, RULE_andExpr = 12, 
		RULE_eqExpr = 13, RULE_compExpr = 14, RULE_mulExpr = 15, RULE_addExpr = 16, 
		RULE_unaryExpr = 17, RULE_primaryExpr = 18, RULE_caseExpr = 19, RULE_whenThenExpr = 20, 
		RULE_functionExpr = 21, RULE_booleanLiteral = 22, RULE_numberLiteral = 23, 
		RULE_stringLiteral = 24, RULE_dateLiteral = 25, RULE_intervalLiteral = 26, 
		RULE_groupargs = 27, RULE_grouparg = 28, RULE_args = 29, RULE_columnExpr = 30, 
		RULE_name = 31, RULE_str = 32, RULE_pint = 33;
	public static final String[] ruleNames = {
		"selectStmtWhole", "selectStmt", "table", "columnNames", "columnName", 
		"where", "groupBy", "having", "limit", "offset", "expr", "orExpr", "andExpr", 
		"eqExpr", "compExpr", "mulExpr", "addExpr", "unaryExpr", "primaryExpr", 
		"caseExpr", "whenThenExpr", "functionExpr", "booleanLiteral", "numberLiteral", 
		"stringLiteral", "dateLiteral", "intervalLiteral", "groupargs", "grouparg", 
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
			setState(68); ((SelectStmtWholeContext)_localctx).selectStmt = selectStmt();
			setState(69); match(9);
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
		public OffsetContext offset;
		public HavingContext having() {
			return getRuleContext(HavingContext.class,0);
		}
		public ColumnNamesContext columnNames() {
			return getRuleContext(ColumnNamesContext.class,0);
		}
		public OffsetContext offset() {
			return getRuleContext(OffsetContext.class,0);
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
			setState(72);
			_la = _input.LA(1);
			if ( !(_la==39 || _la==47) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(73); ((SelectStmtContext)_localctx).columnNames = columnNames();
			setState(74);
			_la = _input.LA(1);
			if ( !(_la==3 || _la==37) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(75); ((SelectStmtContext)_localctx).table = table();
			setState(76); ((SelectStmtContext)_localctx).where = where();
			setState(77); ((SelectStmtContext)_localctx).groupBy = groupBy();
			setState(78); ((SelectStmtContext)_localctx).having = having();
			setState(79); ((SelectStmtContext)_localctx).limit = limit();
			setState(80); ((SelectStmtContext)_localctx).offset = offset();
			 ((SelectStmtContext)_localctx).val =  new SelectStatement(
			            ((SelectStmtContext)_localctx).columnNames.columns,
			            ((SelectStmtContext)_localctx).table.val,
			            ((SelectStmtContext)_localctx).where.val,
			            ((SelectStmtContext)_localctx).groupBy.val,
			            ((SelectStmtContext)_localctx).having.val,
			            ((SelectStmtContext)_localctx).limit.val,
			            ((SelectStmtContext)_localctx).offset.val
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
			setState(131);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(83); ((TableContext)_localctx).t = name();
				setState(84); match(27);
				setState(85); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(88); ((TableContext)_localctx).t = name();
				setState(89); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(92); ((TableContext)_localctx).t = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, null   ); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(95); name();
				setState(96); match(41);
				setState(97); ((TableContext)_localctx).t = name();
				setState(98); match(27);
				setState(99); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(102); name();
				setState(103); match(41);
				setState(104); ((TableContext)_localctx).t = name();
				setState(105); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(108); name();
				setState(109); match(41);
				setState(110); ((TableContext)_localctx).t = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, null   ); 
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(113); match(11);
				setState(114); ((TableContext)_localctx).selectStmt = selectStmt();
				setState(115); match(53);
				setState(116); match(27);
				setState(117); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableSelect(((TableContext)_localctx).selectStmt.val, ((TableContext)_localctx).a.text); 
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(120); match(11);
				setState(121); ((TableContext)_localctx).selectStmt = selectStmt();
				setState(122); match(53);
				setState(123); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableSelect(((TableContext)_localctx).selectStmt.val, ((TableContext)_localctx).a.text); 
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(126); match(11);
				setState(127); ((TableContext)_localctx).selectStmt = selectStmt();
				setState(128); match(53);
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
			setState(133); ((ColumnNamesContext)_localctx).c1 = columnName();
			 ((ColumnNamesContext)_localctx).columns =  new LinkedList<Column>(); _localctx.columns.add(((ColumnNamesContext)_localctx).c1.val); 
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==12) {
				{
				{
				setState(135); match(12);
				setState(136); ((ColumnNamesContext)_localctx).c2 = columnName();
				 _localctx.columns.add(((ColumnNamesContext)_localctx).c2.val); 
				}
				}
				setState(143);
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
			setState(154);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144); ((ColumnNameContext)_localctx).expr = expr();
				setState(145); match(27);
				setState(146); ((ColumnNameContext)_localctx).id = name();
				 ((ColumnNameContext)_localctx).val =  new ColumnImpl(((ColumnNameContext)_localctx).expr.val, ((ColumnNameContext)_localctx).id.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(149); ((ColumnNameContext)_localctx).expr = expr();
				 ((ColumnNameContext)_localctx).val =  new ColumnImpl(((ColumnNameContext)_localctx).expr.val, null); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(152); match(38);
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
			setState(161);
			switch (_input.LA(1)) {
			case 30:
				enterOuterAlt(_localctx, 1);
				{
				setState(156); match(30);
				setState(157); ((WhereContext)_localctx).expr = expr();
				 ((WhereContext)_localctx).val =  ((WhereContext)_localctx).expr.val; 
				}
				break;
			case 7:
			case 9:
			case 21:
			case 26:
			case 40:
			case 53:
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
			setState(169);
			switch (_input.LA(1)) {
			case 7:
				enterOuterAlt(_localctx, 1);
				{
				setState(163); match(7);
				setState(164); match(28);
				setState(165); ((GroupByContext)_localctx).groupargs = groupargs();
				 ((GroupByContext)_localctx).val =  ((GroupByContext)_localctx).groupargs.val; 
				}
				break;
			case 9:
			case 21:
			case 26:
			case 40:
			case 53:
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
			setState(176);
			switch (_input.LA(1)) {
			case 21:
				enterOuterAlt(_localctx, 1);
				{
				setState(171); match(21);
				setState(172); ((HavingContext)_localctx).expr = expr();
				 ((HavingContext)_localctx).val =  ((HavingContext)_localctx).expr.val; 
				}
				break;
			case 9:
			case 26:
			case 40:
			case 53:
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
			setState(183);
			switch (_input.LA(1)) {
			case 26:
				enterOuterAlt(_localctx, 1);
				{
				setState(178); match(26);
				setState(179); ((LimitContext)_localctx).pint = pint();
				 ((LimitContext)_localctx).val =  ((LimitContext)_localctx).pint.val; 
				}
				break;
			case 9:
			case 40:
			case 53:
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

	public static class OffsetContext extends ParserRuleContext {
		public Integer val;
		public PintContext pint;
		public PintContext pint() {
			return getRuleContext(PintContext.class,0);
		}
		public OffsetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_offset; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterOffset(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitOffset(this);
		}
	}

	public final OffsetContext offset() throws RecognitionException {
		OffsetContext _localctx = new OffsetContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_offset);
		try {
			setState(190);
			switch (_input.LA(1)) {
			case 40:
				enterOuterAlt(_localctx, 1);
				{
				setState(185); match(40);
				setState(186); ((OffsetContext)_localctx).pint = pint();
				 ((OffsetContext)_localctx).val =  ((OffsetContext)_localctx).pint.val; 
				}
				break;
			case 9:
			case 53:
				enterOuterAlt(_localctx, 2);
				{
				 ((OffsetContext)_localctx).val =  null;      
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
		enterRule(_localctx, 20, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(192); ((ExprContext)_localctx).lhs = orExpr();
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
		enterRule(_localctx, 22, RULE_orExpr);
		int _la;
		try {
			setState(203);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(195); ((OrExprContext)_localctx).lhs = andExpr();
				setState(196);
				((OrExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==49 || _la==50) ) {
					((OrExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(197); ((OrExprContext)_localctx).rhs = andExpr();
				 ((OrExprContext)_localctx).val =  new BinaryExpr((((OrExprContext)_localctx).op!=null?((OrExprContext)_localctx).op.getText():null), ((OrExprContext)_localctx).lhs.val, ((OrExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(200); ((OrExprContext)_localctx).lhs = andExpr();
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
		enterRule(_localctx, 24, RULE_andExpr);
		int _la;
		try {
			setState(213);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(205); ((AndExprContext)_localctx).lhs = eqExpr();
				setState(206);
				((AndExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==33 || _la==54) ) {
					((AndExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(207); ((AndExprContext)_localctx).rhs = eqExpr();
				 ((AndExprContext)_localctx).val =  new AndExpr(((AndExprContext)_localctx).lhs.val, ((AndExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(210); ((AndExprContext)_localctx).lhs = eqExpr();
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
		enterRule(_localctx, 26, RULE_eqExpr);
		int _la;
		try {
			setState(235);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(215); ((EqExprContext)_localctx).lhs = compExpr();
				setState(216); ((EqExprContext)_localctx).op = match(6);
				setState(217); ((EqExprContext)_localctx).rhs = compExpr();
				 ((EqExprContext)_localctx).val =  new EqExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).rhs.val);  
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(220); ((EqExprContext)_localctx).lhs = compExpr();
				setState(221);
				((EqExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==51 || _la==52) ) {
					((EqExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(222); match(11);
				setState(223); ((EqExprContext)_localctx).a = args();
				setState(224); match(53);
				 ((EqExprContext)_localctx).a.val.setWithCurry(true); ((EqExprContext)_localctx).val =  new EqExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).a.val);  
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(227); ((EqExprContext)_localctx).lhs = compExpr();
				setState(228); ((EqExprContext)_localctx).op = match(4);
				setState(229); ((EqExprContext)_localctx).rhs = compExpr();
				 ((EqExprContext)_localctx).val =  new BinaryExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).rhs.val);  
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(232); ((EqExprContext)_localctx).lhs = compExpr();
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
		public MulExprContext lhs;
		public Token op;
		public MulExprContext rhs;
		public List<MulExprContext> mulExpr() {
			return getRuleContexts(MulExprContext.class);
		}
		public MulExprContext mulExpr(int i) {
			return getRuleContext(MulExprContext.class,i);
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
		enterRule(_localctx, 28, RULE_compExpr);
		int _la;
		try {
			setState(245);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(237); ((CompExprContext)_localctx).lhs = mulExpr();
				setState(238);
				((CompExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 18) | (1L << 19) | (1L << 35) | (1L << 48))) != 0)) ) {
					((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(239); ((CompExprContext)_localctx).rhs = mulExpr();
				 ((CompExprContext)_localctx).val =  new BinaryExpr((((CompExprContext)_localctx).op!=null?((CompExprContext)_localctx).op.getText():null), ((CompExprContext)_localctx).lhs.val, ((CompExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(242); ((CompExprContext)_localctx).lhs = mulExpr();
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

	public static class MulExprContext extends ParserRuleContext {
		public Expr val;
		public AddExprContext lhs;
		public Token op;
		public MulExprContext rhs;
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public MulExprContext mulExpr() {
			return getRuleContext(MulExprContext.class,0);
		}
		public MulExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mulExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterMulExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitMulExpr(this);
		}
	}

	public final MulExprContext mulExpr() throws RecognitionException {
		MulExprContext _localctx = new MulExprContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_mulExpr);
		int _la;
		try {
			setState(255);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(247); ((MulExprContext)_localctx).lhs = addExpr();
				setState(248);
				((MulExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==25 || _la==38) ) {
					((MulExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(249); ((MulExprContext)_localctx).rhs = mulExpr();
				 ((MulExprContext)_localctx).val =  new BinaryExpr((((MulExprContext)_localctx).op!=null?((MulExprContext)_localctx).op.getText():null), ((MulExprContext)_localctx).lhs.val, ((MulExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(252); ((MulExprContext)_localctx).lhs = addExpr();
				 ((MulExprContext)_localctx).val =  ((MulExprContext)_localctx).lhs.val; 
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

	public static class AddExprContext extends ParserRuleContext {
		public Expr val;
		public UnaryExprContext lhs;
		public Token op;
		public AddExprContext rhs;
		public UnaryExprContext unaryExpr() {
			return getRuleContext(UnaryExprContext.class,0);
		}
		public AddExprContext addExpr() {
			return getRuleContext(AddExprContext.class,0);
		}
		public AddExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_addExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterAddExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitAddExpr(this);
		}
	}

	public final AddExprContext addExpr() throws RecognitionException {
		AddExprContext _localctx = new AddExprContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_addExpr);
		int _la;
		try {
			setState(265);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(257); ((AddExprContext)_localctx).lhs = unaryExpr();
				setState(258);
				((AddExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==23 || _la==55) ) {
					((AddExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(259); ((AddExprContext)_localctx).rhs = addExpr();
				 ((AddExprContext)_localctx).val =  new BinaryExpr((((AddExprContext)_localctx).op!=null?((AddExprContext)_localctx).op.getText():null), ((AddExprContext)_localctx).lhs.val, ((AddExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(262); ((AddExprContext)_localctx).lhs = unaryExpr();
				 ((AddExprContext)_localctx).val =  ((AddExprContext)_localctx).lhs.val; 
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

	public static class UnaryExprContext extends ParserRuleContext {
		public Expr val;
		public PrimaryExprContext lhs;
		public Token op;
		public PrimaryExprContext rhs;
		public PrimaryExprContext primaryExpr() {
			return getRuleContext(PrimaryExprContext.class,0);
		}
		public UnaryExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryExpr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterUnaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitUnaryExpr(this);
		}
	}

	public final UnaryExprContext unaryExpr() throws RecognitionException {
		UnaryExprContext _localctx = new UnaryExprContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_unaryExpr);
		try {
			setState(274);
			switch (_input.LA(1)) {
			case 1:
			case 8:
			case 10:
			case 11:
			case 13:
			case 14:
			case 16:
			case 24:
			case 31:
			case 45:
			case NUMBER_LITERAL:
			case ID1:
			case ID2:
			case STR:
				enterOuterAlt(_localctx, 1);
				{
				setState(267); ((UnaryExprContext)_localctx).lhs = primaryExpr();
				 ((UnaryExprContext)_localctx).val =  ((UnaryExprContext)_localctx).lhs.val; 
				}
				break;
			case 55:
				enterOuterAlt(_localctx, 2);
				{
				setState(270); ((UnaryExprContext)_localctx).op = match(55);
				setState(271); ((UnaryExprContext)_localctx).rhs = primaryExpr();
				 ((UnaryExprContext)_localctx).val =  new UnaryExpr((((UnaryExprContext)_localctx).op!=null?((UnaryExprContext)_localctx).op.getText():null), ((UnaryExprContext)_localctx).rhs.val); 
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

	public static class PrimaryExprContext extends ParserRuleContext {
		public Expr val;
		public ColumnExprContext e1;
		public FunctionExprContext functionExpr;
		public NumberLiteralContext numberLiteral;
		public StringLiteralContext stringLiteral;
		public BooleanLiteralContext booleanLiteral;
		public DateLiteralContext dateLiteral;
		public IntervalLiteralContext intervalLiteral;
		public CaseExprContext caseExpr;
		public ExprContext expr;
		public Token type;
		public ColumnExprContext columnExpr() {
			return getRuleContext(ColumnExprContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public DateLiteralContext dateLiteral() {
			return getRuleContext(DateLiteralContext.class,0);
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
		public IntervalLiteralContext intervalLiteral() {
			return getRuleContext(IntervalLiteralContext.class,0);
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
		enterRule(_localctx, 36, RULE_primaryExpr);
		int _la;
		try {
			setState(325);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(276); ((PrimaryExprContext)_localctx).e1 = columnExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).e1.val; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(279); ((PrimaryExprContext)_localctx).functionExpr = functionExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).functionExpr.val; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(282); ((PrimaryExprContext)_localctx).numberLiteral = numberLiteral();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).numberLiteral.val; 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(285); ((PrimaryExprContext)_localctx).stringLiteral = stringLiteral();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).stringLiteral.val; 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(288); ((PrimaryExprContext)_localctx).booleanLiteral = booleanLiteral();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).booleanLiteral.val; 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(291); ((PrimaryExprContext)_localctx).dateLiteral = dateLiteral();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).dateLiteral.val; 
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(294); ((PrimaryExprContext)_localctx).intervalLiteral = intervalLiteral();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).intervalLiteral.val; 
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(297); ((PrimaryExprContext)_localctx).caseExpr = caseExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).caseExpr.val; 
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(300); match(13);
				setState(301); ((PrimaryExprContext)_localctx).expr = expr();
				 ((PrimaryExprContext)_localctx).val =  new DistinctExpr(((PrimaryExprContext)_localctx).expr.val); 
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(304); match(14);
				setState(305); match(11);
				setState(306); ((PrimaryExprContext)_localctx).expr = expr();
				setState(307); match(27);
				setState(308);
				((PrimaryExprContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 2) | (1L << 22) | (1L << 44) | (1L << 45))) != 0)) ) {
					((PrimaryExprContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(309); match(53);
				 ((PrimaryExprContext)_localctx).val =  new CastExpr(((PrimaryExprContext)_localctx).expr.val, (((PrimaryExprContext)_localctx).type!=null?((PrimaryExprContext)_localctx).type.getText():null)); 
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(312); match(31);
				setState(313); match(11);
				setState(314);
				((PrimaryExprContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 5) | (1L << 15) | (1L << 17) | (1L << 20) | (1L << 36) | (1L << 43) | (1L << 46))) != 0)) ) {
					((PrimaryExprContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(315); match(3);
				setState(316); ((PrimaryExprContext)_localctx).expr = expr();
				setState(317); match(53);
				 ((PrimaryExprContext)_localctx).val =  new ExtractExpr(((PrimaryExprContext)_localctx).expr.val, (((PrimaryExprContext)_localctx).type!=null?((PrimaryExprContext)_localctx).type.getText():null)); 
				}
				break;

			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(320); match(11);
				setState(321); ((PrimaryExprContext)_localctx).expr = expr();
				setState(322); match(53);
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
		enterRule(_localctx, 38, RULE_caseExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(327); match(8);
			setState(328); ((CaseExprContext)_localctx).wt = whenThenExpr();
			setState(329); match(29);
			setState(330); ((CaseExprContext)_localctx).e = expr();
			setState(331); match(32);
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
		enterRule(_localctx, 40, RULE_whenThenExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334); match(42);
			setState(335); ((WhenThenExprContext)_localctx).e1 = expr();
			setState(336); match(34);
			setState(337); ((WhenThenExprContext)_localctx).e2 = expr();
			 ((WhenThenExprContext)_localctx).val =  new LinkedList<WhenThen>(); _localctx.val.add(new WhenThen(((WhenThenExprContext)_localctx).e1.val, ((WhenThenExprContext)_localctx).e2.val)); 
			setState(347);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==42) {
				{
				{
				setState(339); match(42);
				setState(340); ((WhenThenExprContext)_localctx).e3 = expr();
				setState(341); match(34);
				setState(342); ((WhenThenExprContext)_localctx).e4 = expr();
				 _localctx.val.add(new WhenThen(((WhenThenExprContext)_localctx).e3.val, ((WhenThenExprContext)_localctx).e4.val)); 
				}
				}
				setState(349);
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
		public Token tk;
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
		enterRule(_localctx, 42, RULE_functionExpr);
		try {
			setState(358);
			switch (_input.LA(1)) {
			case ID1:
			case ID2:
				enterOuterAlt(_localctx, 1);
				{
				setState(350); ((FunctionExprContext)_localctx).id = name();
				setState(351); match(11);
				setState(352); ((FunctionExprContext)_localctx).args = args();
				setState(353); match(53);
				 ((FunctionExprContext)_localctx).val =  new FunctionCallExpr(((FunctionExprContext)_localctx).id.text, ((FunctionExprContext)_localctx).args.val); 
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 2);
				{
				setState(356); ((FunctionExprContext)_localctx).tk = match(10);
				 ((FunctionExprContext)_localctx).val =  new FunctionCallExpr((((FunctionExprContext)_localctx).tk!=null?((FunctionExprContext)_localctx).tk.getText():null), new Arguments()); 
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
		enterRule(_localctx, 44, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(360);
			((BooleanLiteralContext)_localctx).tk = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==16 || _la==24) ) {
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
		enterRule(_localctx, 46, RULE_numberLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(363); ((NumberLiteralContext)_localctx).numtk = match(NUMBER_LITERAL);
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
		enterRule(_localctx, 48, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(366); ((StringLiteralContext)_localctx).str = str();
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

	public static class DateLiteralContext extends ParserRuleContext {
		public DateLiteral val;
		public StrContext str;
		public StrContext str() {
			return getRuleContext(StrContext.class,0);
		}
		public DateLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dateLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterDateLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitDateLiteral(this);
		}
	}

	public final DateLiteralContext dateLiteral() throws RecognitionException {
		DateLiteralContext _localctx = new DateLiteralContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_dateLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(369); match(45);
			setState(370); ((DateLiteralContext)_localctx).str = str();
			 ((DateLiteralContext)_localctx).val =  new DateLiteral(((DateLiteralContext)_localctx).str.text); 
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

	public static class IntervalLiteralContext extends ParserRuleContext {
		public IntervalLiteral val;
		public StrContext str;
		public StrContext str() {
			return getRuleContext(StrContext.class,0);
		}
		public IntervalLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_intervalLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).enterIntervalLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof SqlListener ) ((SqlListener)listener).exitIntervalLiteral(this);
		}
	}

	public final IntervalLiteralContext intervalLiteral() throws RecognitionException {
		IntervalLiteralContext _localctx = new IntervalLiteralContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_intervalLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(373); match(1);
			setState(374); ((IntervalLiteralContext)_localctx).str = str();
			 ((IntervalLiteralContext)_localctx).val =  new IntervalLiteral(((IntervalLiteralContext)_localctx).str.text); 
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
		enterRule(_localctx, 54, RULE_groupargs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<GroupArg> _args = new ArrayList<GroupArg>(); 
			setState(389);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 8) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 16) | (1L << 24) | (1L << 31) | (1L << 45) | (1L << 55) | (1L << NUMBER_LITERAL) | (1L << ID1) | (1L << ID2) | (1L << STR))) != 0)) {
				{
				setState(378); ((GroupargsContext)_localctx).e1 = grouparg();
				 _args.add(((GroupargsContext)_localctx).e1.val); 
				setState(386);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==12) {
					{
					{
					setState(380); match(12);
					setState(381); ((GroupargsContext)_localctx).e2 = grouparg();
					 _args.add(((GroupargsContext)_localctx).e2.val); 
					}
					}
					setState(388);
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
		enterRule(_localctx, 56, RULE_grouparg);
		try {
			setState(399);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(393); ((GroupargContext)_localctx).pint = pint();
				 ((GroupargContext)_localctx).val =  new ColumnNumberArg(((GroupargContext)_localctx).pint.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(396); ((GroupargContext)_localctx).expr = expr();
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
		enterRule(_localctx, 58, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Expr> _args = new ArrayList<Expr>(); 
			setState(413);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 8) | (1L << 10) | (1L << 11) | (1L << 13) | (1L << 14) | (1L << 16) | (1L << 24) | (1L << 31) | (1L << 45) | (1L << 55) | (1L << NUMBER_LITERAL) | (1L << ID1) | (1L << ID2) | (1L << STR))) != 0)) {
				{
				setState(402); ((ArgsContext)_localctx).e1 = expr();
				 _args.add(((ArgsContext)_localctx).e1.val); 
				setState(410);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==12) {
					{
					{
					setState(404); match(12);
					setState(405); ((ArgsContext)_localctx).e2 = expr();
					 _args.add(((ArgsContext)_localctx).e2.val); 
					}
					}
					setState(412);
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
		enterRule(_localctx, 60, RULE_columnExpr);
		try {
			setState(425);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(417); ((ColumnExprContext)_localctx).id2 = name();
				 ((ColumnExprContext)_localctx).val =  new ColumnExpr(null,      ((ColumnExprContext)_localctx).id2.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(420); ((ColumnExprContext)_localctx).id1 = name();
				setState(421); match(41);
				setState(422); ((ColumnExprContext)_localctx).id2 = name();
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
		enterRule(_localctx, 62, RULE_name);
		try {
			setState(431);
			switch (_input.LA(1)) {
			case ID1:
				enterOuterAlt(_localctx, 1);
				{
				setState(427); ((NameContext)_localctx).ID1 = match(ID1);
				 ((NameContext)_localctx).text =  (((NameContext)_localctx).ID1!=null?((NameContext)_localctx).ID1.getText():null); 
				}
				break;
			case ID2:
				enterOuterAlt(_localctx, 2);
				{
				setState(429); ((NameContext)_localctx).ID2 = match(ID2);
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
		enterRule(_localctx, 64, RULE_str);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(433); ((StrContext)_localctx).STR = match(STR);
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
		enterRule(_localctx, 66, RULE_pint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436); ((PintContext)_localctx).num = match(NUMBER_LITERAL);
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
		"\2\3>\u01ba\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\4 \t \4!\t!\4\"\t\"\4#\t#\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\5\4\u0086\n\4\3\5\3\5\3\5\3\5\3\5\3\5\7\5\u008e\n\5\f\5\16\5"+
		"\u0091\13\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6\u009d\n\6\3\7"+
		"\3\7\3\7\3\7\3\7\5\7\u00a4\n\7\3\b\3\b\3\b\3\b\3\b\3\b\5\b\u00ac\n\b\3"+
		"\t\3\t\3\t\3\t\3\t\5\t\u00b3\n\t\3\n\3\n\3\n\3\n\3\n\5\n\u00ba\n\n\3\13"+
		"\3\13\3\13\3\13\3\13\5\13\u00c1\n\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\5\r\u00ce\n\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16"+
		"\u00d8\n\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00ee\n\17\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\5\20\u00f8\n\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u0102\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5\22"+
		"\u010c\n\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0115\n\23\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3"+
		"\24\3\24\3\24\3\24\3\24\3\24\5\24\u0148\n\24\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\3\26\7\26"+
		"\u015c\n\26\f\26\16\26\u015f\13\26\3\27\3\27\3\27\3\27\3\27\3\27\3\27"+
		"\3\27\5\27\u0169\n\27\3\30\3\30\3\30\3\31\3\31\3\31\3\32\3\32\3\32\3\33"+
		"\3\33\3\33\3\33\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\7\35\u0183\n\35\f\35\16\35\u0186\13\35\5\35\u0188\n\35\3\35\3\35\3\36"+
		"\3\36\3\36\3\36\3\36\3\36\5\36\u0192\n\36\3\37\3\37\3\37\3\37\3\37\3\37"+
		"\3\37\7\37\u019b\n\37\f\37\16\37\u019e\13\37\5\37\u01a0\n\37\3\37\3\37"+
		"\3 \3 \3 \3 \3 \3 \3 \3 \5 \u01ac\n \3!\3!\3!\3!\5!\u01b2\n!\3\"\3\"\3"+
		"\"\3#\3#\3#\3#\2$\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62"+
		"\64\668:<>@BD\2\r\4))\61\61\4\5\5\'\'\3\63\64\4##88\3\65\66\5\24\25%%"+
		"\62\62\4\33\33((\4\31\3199\5\4\4\30\30./\t\7\7\21\21\23\23\26\26&&--\60"+
		"\60\4\22\22\32\32\u01c4\2F\3\2\2\2\4J\3\2\2\2\6\u0085\3\2\2\2\b\u0087"+
		"\3\2\2\2\n\u009c\3\2\2\2\f\u00a3\3\2\2\2\16\u00ab\3\2\2\2\20\u00b2\3\2"+
		"\2\2\22\u00b9\3\2\2\2\24\u00c0\3\2\2\2\26\u00c2\3\2\2\2\30\u00cd\3\2\2"+
		"\2\32\u00d7\3\2\2\2\34\u00ed\3\2\2\2\36\u00f7\3\2\2\2 \u0101\3\2\2\2\""+
		"\u010b\3\2\2\2$\u0114\3\2\2\2&\u0147\3\2\2\2(\u0149\3\2\2\2*\u0150\3\2"+
		"\2\2,\u0168\3\2\2\2.\u016a\3\2\2\2\60\u016d\3\2\2\2\62\u0170\3\2\2\2\64"+
		"\u0173\3\2\2\2\66\u0177\3\2\2\28\u017b\3\2\2\2:\u0191\3\2\2\2<\u0193\3"+
		"\2\2\2>\u01ab\3\2\2\2@\u01b1\3\2\2\2B\u01b3\3\2\2\2D\u01b6\3\2\2\2FG\5"+
		"\4\3\2GH\7\13\2\2HI\b\2\1\2I\3\3\2\2\2JK\t\2\2\2KL\5\b\5\2LM\t\3\2\2M"+
		"N\5\6\4\2NO\5\f\7\2OP\5\16\b\2PQ\5\20\t\2QR\5\22\n\2RS\5\24\13\2ST\b\3"+
		"\1\2T\5\3\2\2\2UV\5@!\2VW\7\35\2\2WX\5@!\2XY\b\4\1\2Y\u0086\3\2\2\2Z["+
		"\5@!\2[\\\5@!\2\\]\b\4\1\2]\u0086\3\2\2\2^_\5@!\2_`\b\4\1\2`\u0086\3\2"+
		"\2\2ab\5@!\2bc\7+\2\2cd\5@!\2de\7\35\2\2ef\5@!\2fg\b\4\1\2g\u0086\3\2"+
		"\2\2hi\5@!\2ij\7+\2\2jk\5@!\2kl\5@!\2lm\b\4\1\2m\u0086\3\2\2\2no\5@!\2"+
		"op\7+\2\2pq\5@!\2qr\b\4\1\2r\u0086\3\2\2\2st\7\r\2\2tu\5\4\3\2uv\7\67"+
		"\2\2vw\7\35\2\2wx\5@!\2xy\b\4\1\2y\u0086\3\2\2\2z{\7\r\2\2{|\5\4\3\2|"+
		"}\7\67\2\2}~\5@!\2~\177\b\4\1\2\177\u0086\3\2\2\2\u0080\u0081\7\r\2\2"+
		"\u0081\u0082\5\4\3\2\u0082\u0083\7\67\2\2\u0083\u0084\b\4\1\2\u0084\u0086"+
		"\3\2\2\2\u0085U\3\2\2\2\u0085Z\3\2\2\2\u0085^\3\2\2\2\u0085a\3\2\2\2\u0085"+
		"h\3\2\2\2\u0085n\3\2\2\2\u0085s\3\2\2\2\u0085z\3\2\2\2\u0085\u0080\3\2"+
		"\2\2\u0086\7\3\2\2\2\u0087\u0088\5\n\6\2\u0088\u008f\b\5\1\2\u0089\u008a"+
		"\7\16\2\2\u008a\u008b\5\n\6\2\u008b\u008c\b\5\1\2\u008c\u008e\3\2\2\2"+
		"\u008d\u0089\3\2\2\2\u008e\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090"+
		"\3\2\2\2\u0090\t\3\2\2\2\u0091\u008f\3\2\2\2\u0092\u0093\5\26\f\2\u0093"+
		"\u0094\7\35\2\2\u0094\u0095\5@!\2\u0095\u0096\b\6\1\2\u0096\u009d\3\2"+
		"\2\2\u0097\u0098\5\26\f\2\u0098\u0099\b\6\1\2\u0099\u009d\3\2\2\2\u009a"+
		"\u009b\7(\2\2\u009b\u009d\b\6\1\2\u009c\u0092\3\2\2\2\u009c\u0097\3\2"+
		"\2\2\u009c\u009a\3\2\2\2\u009d\13\3\2\2\2\u009e\u009f\7 \2\2\u009f\u00a0"+
		"\5\26\f\2\u00a0\u00a1\b\7\1\2\u00a1\u00a4\3\2\2\2\u00a2\u00a4\b\7\1\2"+
		"\u00a3\u009e\3\2\2\2\u00a3\u00a2\3\2\2\2\u00a4\r\3\2\2\2\u00a5\u00a6\7"+
		"\t\2\2\u00a6\u00a7\7\36\2\2\u00a7\u00a8\58\35\2\u00a8\u00a9\b\b\1\2\u00a9"+
		"\u00ac\3\2\2\2\u00aa\u00ac\b\b\1\2\u00ab\u00a5\3\2\2\2\u00ab\u00aa\3\2"+
		"\2\2\u00ac\17\3\2\2\2\u00ad\u00ae\7\27\2\2\u00ae\u00af\5\26\f\2\u00af"+
		"\u00b0\b\t\1\2\u00b0\u00b3\3\2\2\2\u00b1\u00b3\b\t\1\2\u00b2\u00ad\3\2"+
		"\2\2\u00b2\u00b1\3\2\2\2\u00b3\21\3\2\2\2\u00b4\u00b5\7\34\2\2\u00b5\u00b6"+
		"\5D#\2\u00b6\u00b7\b\n\1\2\u00b7\u00ba\3\2\2\2\u00b8\u00ba\b\n\1\2\u00b9"+
		"\u00b4\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\23\3\2\2\2\u00bb\u00bc\7*\2\2"+
		"\u00bc\u00bd\5D#\2\u00bd\u00be\b\13\1\2\u00be\u00c1\3\2\2\2\u00bf\u00c1"+
		"\b\13\1\2\u00c0\u00bb\3\2\2\2\u00c0\u00bf\3\2\2\2\u00c1\25\3\2\2\2\u00c2"+
		"\u00c3\5\30\r\2\u00c3\u00c4\b\f\1\2\u00c4\27\3\2\2\2\u00c5\u00c6\5\32"+
		"\16\2\u00c6\u00c7\t\4\2\2\u00c7\u00c8\5\32\16\2\u00c8\u00c9\b\r\1\2\u00c9"+
		"\u00ce\3\2\2\2\u00ca\u00cb\5\32\16\2\u00cb\u00cc\b\r\1\2\u00cc\u00ce\3"+
		"\2\2\2\u00cd\u00c5\3\2\2\2\u00cd\u00ca\3\2\2\2\u00ce\31\3\2\2\2\u00cf"+
		"\u00d0\5\34\17\2\u00d0\u00d1\t\5\2\2\u00d1\u00d2\5\34\17\2\u00d2\u00d3"+
		"\b\16\1\2\u00d3\u00d8\3\2\2\2\u00d4\u00d5\5\34\17\2\u00d5\u00d6\b\16\1"+
		"\2\u00d6\u00d8\3\2\2\2\u00d7\u00cf\3\2\2\2\u00d7\u00d4\3\2\2\2\u00d8\33"+
		"\3\2\2\2\u00d9\u00da\5\36\20\2\u00da\u00db\7\b\2\2\u00db\u00dc\5\36\20"+
		"\2\u00dc\u00dd\b\17\1\2\u00dd\u00ee\3\2\2\2\u00de\u00df\5\36\20\2\u00df"+
		"\u00e0\t\6\2\2\u00e0\u00e1\7\r\2\2\u00e1\u00e2\5<\37\2\u00e2\u00e3\7\67"+
		"\2\2\u00e3\u00e4\b\17\1\2\u00e4\u00ee\3\2\2\2\u00e5\u00e6\5\36\20\2\u00e6"+
		"\u00e7\7\6\2\2\u00e7\u00e8\5\36\20\2\u00e8\u00e9\b\17\1\2\u00e9\u00ee"+
		"\3\2\2\2\u00ea\u00eb\5\36\20\2\u00eb\u00ec\b\17\1\2\u00ec\u00ee\3\2\2"+
		"\2\u00ed\u00d9\3\2\2\2\u00ed\u00de\3\2\2\2\u00ed\u00e5\3\2\2\2\u00ed\u00ea"+
		"\3\2\2\2\u00ee\35\3\2\2\2\u00ef\u00f0\5 \21\2\u00f0\u00f1\t\7\2\2\u00f1"+
		"\u00f2\5 \21\2\u00f2\u00f3\b\20\1\2\u00f3\u00f8\3\2\2\2\u00f4\u00f5\5"+
		" \21\2\u00f5\u00f6\b\20\1\2\u00f6\u00f8\3\2\2\2\u00f7\u00ef\3\2\2\2\u00f7"+
		"\u00f4\3\2\2\2\u00f8\37\3\2\2\2\u00f9\u00fa\5\"\22\2\u00fa\u00fb\t\b\2"+
		"\2\u00fb\u00fc\5 \21\2\u00fc\u00fd\b\21\1\2\u00fd\u0102\3\2\2\2\u00fe"+
		"\u00ff\5\"\22\2\u00ff\u0100\b\21\1\2\u0100\u0102\3\2\2\2\u0101\u00f9\3"+
		"\2\2\2\u0101\u00fe\3\2\2\2\u0102!\3\2\2\2\u0103\u0104\5$\23\2\u0104\u0105"+
		"\t\t\2\2\u0105\u0106\5\"\22\2\u0106\u0107\b\22\1\2\u0107\u010c\3\2\2\2"+
		"\u0108\u0109\5$\23\2\u0109\u010a\b\22\1\2\u010a\u010c\3\2\2\2\u010b\u0103"+
		"\3\2\2\2\u010b\u0108\3\2\2\2\u010c#\3\2\2\2\u010d\u010e\5&\24\2\u010e"+
		"\u010f\b\23\1\2\u010f\u0115\3\2\2\2\u0110\u0111\79\2\2\u0111\u0112\5&"+
		"\24\2\u0112\u0113\b\23\1\2\u0113\u0115\3\2\2\2\u0114\u010d\3\2\2\2\u0114"+
		"\u0110\3\2\2\2\u0115%\3\2\2\2\u0116\u0117\5> \2\u0117\u0118\b\24\1\2\u0118"+
		"\u0148\3\2\2\2\u0119\u011a\5,\27\2\u011a\u011b\b\24\1\2\u011b\u0148\3"+
		"\2\2\2\u011c\u011d\5\60\31\2\u011d\u011e\b\24\1\2\u011e\u0148\3\2\2\2"+
		"\u011f\u0120\5\62\32\2\u0120\u0121\b\24\1\2\u0121\u0148\3\2\2\2\u0122"+
		"\u0123\5.\30\2\u0123\u0124\b\24\1\2\u0124\u0148\3\2\2\2\u0125\u0126\5"+
		"\64\33\2\u0126\u0127\b\24\1\2\u0127\u0148\3\2\2\2\u0128\u0129\5\66\34"+
		"\2\u0129\u012a\b\24\1\2\u012a\u0148\3\2\2\2\u012b\u012c\5(\25\2\u012c"+
		"\u012d\b\24\1\2\u012d\u0148\3\2\2\2\u012e\u012f\7\17\2\2\u012f\u0130\5"+
		"\26\f\2\u0130\u0131\b\24\1\2\u0131\u0148\3\2\2\2\u0132\u0133\7\20\2\2"+
		"\u0133\u0134\7\r\2\2\u0134\u0135\5\26\f\2\u0135\u0136\7\35\2\2\u0136\u0137"+
		"\t\n\2\2\u0137\u0138\7\67\2\2\u0138\u0139\b\24\1\2\u0139\u0148\3\2\2\2"+
		"\u013a\u013b\7!\2\2\u013b\u013c\7\r\2\2\u013c\u013d\t\13\2\2\u013d\u013e"+
		"\7\5\2\2\u013e\u013f\5\26\f\2\u013f\u0140\7\67\2\2\u0140\u0141\b\24\1"+
		"\2\u0141\u0148\3\2\2\2\u0142\u0143\7\r\2\2\u0143\u0144\5\26\f\2\u0144"+
		"\u0145\7\67\2\2\u0145\u0146\b\24\1\2\u0146\u0148\3\2\2\2\u0147\u0116\3"+
		"\2\2\2\u0147\u0119\3\2\2\2\u0147\u011c\3\2\2\2\u0147\u011f\3\2\2\2\u0147"+
		"\u0122\3\2\2\2\u0147\u0125\3\2\2\2\u0147\u0128\3\2\2\2\u0147\u012b\3\2"+
		"\2\2\u0147\u012e\3\2\2\2\u0147\u0132\3\2\2\2\u0147\u013a\3\2\2\2\u0147"+
		"\u0142\3\2\2\2\u0148\'\3\2\2\2\u0149\u014a\7\n\2\2\u014a\u014b\5*\26\2"+
		"\u014b\u014c\7\37\2\2\u014c\u014d\5\26\f\2\u014d\u014e\7\"\2\2\u014e\u014f"+
		"\b\25\1\2\u014f)\3\2\2\2\u0150\u0151\7,\2\2\u0151\u0152\5\26\f\2\u0152"+
		"\u0153\7$\2\2\u0153\u0154\5\26\f\2\u0154\u015d\b\26\1\2\u0155\u0156\7"+
		",\2\2\u0156\u0157\5\26\f\2\u0157\u0158\7$\2\2\u0158\u0159\5\26\f\2\u0159"+
		"\u015a\b\26\1\2\u015a\u015c\3\2\2\2\u015b\u0155\3\2\2\2\u015c\u015f\3"+
		"\2\2\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e+\3\2\2\2\u015f\u015d"+
		"\3\2\2\2\u0160\u0161\5@!\2\u0161\u0162\7\r\2\2\u0162\u0163\5<\37\2\u0163"+
		"\u0164\7\67\2\2\u0164\u0165\b\27\1\2\u0165\u0169\3\2\2\2\u0166\u0167\7"+
		"\f\2\2\u0167\u0169\b\27\1\2\u0168\u0160\3\2\2\2\u0168\u0166\3\2\2\2\u0169"+
		"-\3\2\2\2\u016a\u016b\t\f\2\2\u016b\u016c\b\30\1\2\u016c/\3\2\2\2\u016d"+
		"\u016e\7;\2\2\u016e\u016f\b\31\1\2\u016f\61\3\2\2\2\u0170\u0171\5B\"\2"+
		"\u0171\u0172\b\32\1\2\u0172\63\3\2\2\2\u0173\u0174\7/\2\2\u0174\u0175"+
		"\5B\"\2\u0175\u0176\b\33\1\2\u0176\65\3\2\2\2\u0177\u0178\7\3\2\2\u0178"+
		"\u0179\5B\"\2\u0179\u017a\b\34\1\2\u017a\67\3\2\2\2\u017b\u0187\b\35\1"+
		"\2\u017c\u017d\5:\36\2\u017d\u0184\b\35\1\2\u017e\u017f\7\16\2\2\u017f"+
		"\u0180\5:\36\2\u0180\u0181\b\35\1\2\u0181\u0183\3\2\2\2\u0182\u017e\3"+
		"\2\2\2\u0183\u0186\3\2\2\2\u0184\u0182\3\2\2\2\u0184\u0185\3\2\2\2\u0185"+
		"\u0188\3\2\2\2\u0186\u0184\3\2\2\2\u0187\u017c\3\2\2\2\u0187\u0188\3\2"+
		"\2\2\u0188\u0189\3\2\2\2\u0189\u018a\b\35\1\2\u018a9\3\2\2\2\u018b\u018c"+
		"\5D#\2\u018c\u018d\b\36\1\2\u018d\u0192\3\2\2\2\u018e\u018f\5\26\f\2\u018f"+
		"\u0190\b\36\1\2\u0190\u0192\3\2\2\2\u0191\u018b\3\2\2\2\u0191\u018e\3"+
		"\2\2\2\u0192;\3\2\2\2\u0193\u019f\b\37\1\2\u0194\u0195\5\26\f\2\u0195"+
		"\u019c\b\37\1\2\u0196\u0197\7\16\2\2\u0197\u0198\5\26\f\2\u0198\u0199"+
		"\b\37\1\2\u0199\u019b\3\2\2\2\u019a\u0196\3\2\2\2\u019b\u019e\3\2\2\2"+
		"\u019c\u019a\3\2\2\2\u019c\u019d\3\2\2\2\u019d\u01a0\3\2\2\2\u019e\u019c"+
		"\3\2\2\2\u019f\u0194\3\2\2\2\u019f\u01a0\3\2\2\2\u01a0\u01a1\3\2\2\2\u01a1"+
		"\u01a2\b\37\1\2\u01a2=\3\2\2\2\u01a3\u01a4\5@!\2\u01a4\u01a5\b \1\2\u01a5"+
		"\u01ac\3\2\2\2\u01a6\u01a7\5@!\2\u01a7\u01a8\7+\2\2\u01a8\u01a9\5@!\2"+
		"\u01a9\u01aa\b \1\2\u01aa\u01ac\3\2\2\2\u01ab\u01a3\3\2\2\2\u01ab\u01a6"+
		"\3\2\2\2\u01ac?\3\2\2\2\u01ad\u01ae\7<\2\2\u01ae\u01b2\b!\1\2\u01af\u01b0"+
		"\7=\2\2\u01b0\u01b2\b!\1\2\u01b1\u01ad\3\2\2\2\u01b1\u01af\3\2\2\2\u01b2"+
		"A\3\2\2\2\u01b3\u01b4\7>\2\2\u01b4\u01b5\b\"\1\2\u01b5C\3\2\2\2\u01b6"+
		"\u01b7\7;\2\2\u01b7\u01b8\b#\1\2\u01b8E\3\2\2\2\33\u0085\u008f\u009c\u00a3"+
		"\u00ab\u00b2\u00b9\u00c0\u00cd\u00d7\u00ed\u00f7\u0101\u010b\u0114\u0147"+
		"\u015d\u0168\u0184\u0187\u0191\u019c\u019f\u01ab\u01b1";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}