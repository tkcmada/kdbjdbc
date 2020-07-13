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
		T__49=1, T__48=2, T__47=3, T__46=4, T__45=5, T__44=6, T__43=7, T__42=8, 
		T__41=9, T__40=10, T__39=11, T__38=12, T__37=13, T__36=14, T__35=15, T__34=16, 
		T__33=17, T__32=18, T__31=19, T__30=20, T__29=21, T__28=22, T__27=23, 
		T__26=24, T__25=25, T__24=26, T__23=27, T__22=28, T__21=29, T__20=30, 
		T__19=31, T__18=32, T__17=33, T__16=34, T__15=35, T__14=36, T__13=37, 
		T__12=38, T__11=39, T__10=40, T__9=41, T__8=42, T__7=43, T__6=44, T__5=45, 
		T__4=46, T__3=47, T__2=48, T__1=49, T__0=50, WS=51, NUMBER_LITERAL=52, 
		ID1=53, ID2=54, STR=55;
	public static final String[] tokenNames = {
		"<INVALID>", "'INTEGER'", "'FROM'", "'!='", "'QUARTER'", "'='", "'GROUP'", 
		"'CASE'", "'$'", "'('", "','", "'DISTINCT'", "'CAST'", "'MONTH'", "'FALSE'", 
		"'HOUR'", "'>='", "'<'", "'YEAR'", "'HAVING'", "'TIMESTAMP'", "'TRUE'", 
		"'LIMIT'", "'AS'", "'BY'", "'ELSE'", "'WHERE'", "'EXTRACT'", "'END'", 
		"'AND'", "'THEN'", "'<='", "'SECOND'", "'from'", "'*'", "'SELECT'", "'OFFSET'", 
		"'.'", "'WHEN'", "'MINUTE'", "'TEXT'", "'DATE'", "'DAY'", "'select'", 
		"'>'", "'OR'", "'or'", "'IN'", "'in'", "')'", "'and'", "WS", "NUMBER_LITERAL", 
		"ID1", "ID2", "STR"
	};
	public static final int
		RULE_selectStmtWhole = 0, RULE_selectStmt = 1, RULE_table = 2, RULE_columnNames = 3, 
		RULE_columnName = 4, RULE_where = 5, RULE_groupBy = 6, RULE_having = 7, 
		RULE_limit = 8, RULE_offset = 9, RULE_expr = 10, RULE_orExpr = 11, RULE_andExpr = 12, 
		RULE_eqExpr = 13, RULE_compExpr = 14, RULE_primaryExpr = 15, RULE_caseExpr = 16, 
		RULE_whenThenExpr = 17, RULE_functionExpr = 18, RULE_booleanLiteral = 19, 
		RULE_numberLiteral = 20, RULE_stringLiteral = 21, RULE_dateLiteral = 22, 
		RULE_groupargs = 23, RULE_grouparg = 24, RULE_args = 25, RULE_columnExpr = 26, 
		RULE_name = 27, RULE_str = 28, RULE_pint = 29;
	public static final String[] ruleNames = {
		"selectStmtWhole", "selectStmt", "table", "columnNames", "columnName", 
		"where", "groupBy", "having", "limit", "offset", "expr", "orExpr", "andExpr", 
		"eqExpr", "compExpr", "primaryExpr", "caseExpr", "whenThenExpr", "functionExpr", 
		"booleanLiteral", "numberLiteral", "stringLiteral", "dateLiteral", "groupargs", 
		"grouparg", "args", "columnExpr", "name", "str", "pint"
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
			setState(60); ((SelectStmtWholeContext)_localctx).selectStmt = selectStmt();
			setState(61); match(8);
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
			setState(64);
			_la = _input.LA(1);
			if ( !(_la==35 || _la==43) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(65); ((SelectStmtContext)_localctx).columnNames = columnNames();
			setState(66);
			_la = _input.LA(1);
			if ( !(_la==2 || _la==33) ) {
			_errHandler.recoverInline(this);
			}
			consume();
			setState(67); ((SelectStmtContext)_localctx).table = table();
			setState(68); ((SelectStmtContext)_localctx).where = where();
			setState(69); ((SelectStmtContext)_localctx).groupBy = groupBy();
			setState(70); ((SelectStmtContext)_localctx).having = having();
			setState(71); ((SelectStmtContext)_localctx).limit = limit();
			setState(72); ((SelectStmtContext)_localctx).offset = offset();
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
			setState(123);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(75); ((TableContext)_localctx).t = name();
				setState(76); match(23);
				setState(77); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(80); ((TableContext)_localctx).t = name();
				setState(81); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(84); ((TableContext)_localctx).t = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, null   ); 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(87); name();
				setState(88); match(37);
				setState(89); ((TableContext)_localctx).t = name();
				setState(90); match(23);
				setState(91); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(94); name();
				setState(95); match(37);
				setState(96); ((TableContext)_localctx).t = name();
				setState(97); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, ((TableContext)_localctx).a.text); 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(100); name();
				setState(101); match(37);
				setState(102); ((TableContext)_localctx).t = name();
				 ((TableContext)_localctx).val =  new TableImpl(((TableContext)_localctx).t.text, null   ); 
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(105); match(9);
				setState(106); ((TableContext)_localctx).selectStmt = selectStmt();
				setState(107); match(49);
				setState(108); match(23);
				setState(109); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableSelect(((TableContext)_localctx).selectStmt.val, ((TableContext)_localctx).a.text); 
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(112); match(9);
				setState(113); ((TableContext)_localctx).selectStmt = selectStmt();
				setState(114); match(49);
				setState(115); ((TableContext)_localctx).a = name();
				 ((TableContext)_localctx).val =  new TableSelect(((TableContext)_localctx).selectStmt.val, ((TableContext)_localctx).a.text); 
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(118); match(9);
				setState(119); ((TableContext)_localctx).selectStmt = selectStmt();
				setState(120); match(49);
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
			setState(125); ((ColumnNamesContext)_localctx).c1 = columnName();
			 ((ColumnNamesContext)_localctx).columns =  new LinkedList<Column>(); _localctx.columns.add(((ColumnNamesContext)_localctx).c1.val); 
			setState(133);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==10) {
				{
				{
				setState(127); match(10);
				setState(128); ((ColumnNamesContext)_localctx).c2 = columnName();
				 _localctx.columns.add(((ColumnNamesContext)_localctx).c2.val); 
				}
				}
				setState(135);
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
			setState(146);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(136); ((ColumnNameContext)_localctx).expr = expr();
				setState(137); match(23);
				setState(138); ((ColumnNameContext)_localctx).id = name();
				 ((ColumnNameContext)_localctx).val =  new ColumnImpl(((ColumnNameContext)_localctx).expr.val, ((ColumnNameContext)_localctx).id.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(141); ((ColumnNameContext)_localctx).expr = expr();
				 ((ColumnNameContext)_localctx).val =  new ColumnImpl(((ColumnNameContext)_localctx).expr.val, null); 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(144); match(34);
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
			setState(153);
			switch (_input.LA(1)) {
			case 26:
				enterOuterAlt(_localctx, 1);
				{
				setState(148); match(26);
				setState(149); ((WhereContext)_localctx).expr = expr();
				 ((WhereContext)_localctx).val =  ((WhereContext)_localctx).expr.val; 
				}
				break;
			case 6:
			case 8:
			case 19:
			case 22:
			case 36:
			case 49:
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
			setState(161);
			switch (_input.LA(1)) {
			case 6:
				enterOuterAlt(_localctx, 1);
				{
				setState(155); match(6);
				setState(156); match(24);
				setState(157); ((GroupByContext)_localctx).groupargs = groupargs();
				 ((GroupByContext)_localctx).val =  ((GroupByContext)_localctx).groupargs.val; 
				}
				break;
			case 8:
			case 19:
			case 22:
			case 36:
			case 49:
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
			setState(168);
			switch (_input.LA(1)) {
			case 19:
				enterOuterAlt(_localctx, 1);
				{
				setState(163); match(19);
				setState(164); ((HavingContext)_localctx).expr = expr();
				 ((HavingContext)_localctx).val =  ((HavingContext)_localctx).expr.val; 
				}
				break;
			case 8:
			case 22:
			case 36:
			case 49:
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
			setState(175);
			switch (_input.LA(1)) {
			case 22:
				enterOuterAlt(_localctx, 1);
				{
				setState(170); match(22);
				setState(171); ((LimitContext)_localctx).pint = pint();
				 ((LimitContext)_localctx).val =  ((LimitContext)_localctx).pint.val; 
				}
				break;
			case 8:
			case 36:
			case 49:
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
			setState(182);
			switch (_input.LA(1)) {
			case 36:
				enterOuterAlt(_localctx, 1);
				{
				setState(177); match(36);
				setState(178); ((OffsetContext)_localctx).pint = pint();
				 ((OffsetContext)_localctx).val =  ((OffsetContext)_localctx).pint.val; 
				}
				break;
			case 8:
			case 49:
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
			setState(184); ((ExprContext)_localctx).lhs = orExpr();
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
			setState(195);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(187); ((OrExprContext)_localctx).lhs = andExpr();
				setState(188);
				((OrExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==45 || _la==46) ) {
					((OrExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(189); ((OrExprContext)_localctx).rhs = andExpr();
				 ((OrExprContext)_localctx).val =  new BinaryExpr((((OrExprContext)_localctx).op!=null?((OrExprContext)_localctx).op.getText():null), ((OrExprContext)_localctx).lhs.val, ((OrExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(192); ((OrExprContext)_localctx).lhs = andExpr();
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
			setState(205);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(197); ((AndExprContext)_localctx).lhs = eqExpr();
				setState(198);
				((AndExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==29 || _la==50) ) {
					((AndExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(199); ((AndExprContext)_localctx).rhs = eqExpr();
				 ((AndExprContext)_localctx).val =  new AndExpr(((AndExprContext)_localctx).lhs.val, ((AndExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(202); ((AndExprContext)_localctx).lhs = eqExpr();
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
			setState(227);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(207); ((EqExprContext)_localctx).lhs = compExpr();
				setState(208); ((EqExprContext)_localctx).op = match(5);
				setState(209); ((EqExprContext)_localctx).rhs = compExpr();
				 ((EqExprContext)_localctx).val =  new EqExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).rhs.val);  
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(212); ((EqExprContext)_localctx).lhs = compExpr();
				setState(213);
				((EqExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==47 || _la==48) ) {
					((EqExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(214); match(9);
				setState(215); ((EqExprContext)_localctx).a = args();
				setState(216); match(49);
				 ((EqExprContext)_localctx).a.val.setWithCurry(true); ((EqExprContext)_localctx).val =  new EqExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).a.val);  
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(219); ((EqExprContext)_localctx).lhs = compExpr();
				setState(220); ((EqExprContext)_localctx).op = match(3);
				setState(221); ((EqExprContext)_localctx).rhs = compExpr();
				 ((EqExprContext)_localctx).val =  new BinaryExpr((((EqExprContext)_localctx).op!=null?((EqExprContext)_localctx).op.getText():null), ((EqExprContext)_localctx).lhs.val, ((EqExprContext)_localctx).rhs.val);  
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(224); ((EqExprContext)_localctx).lhs = compExpr();
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
		enterRule(_localctx, 28, RULE_compExpr);
		int _la;
		try {
			setState(237);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(229); ((CompExprContext)_localctx).lhs = primaryExpr();
				setState(230);
				((CompExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 16) | (1L << 17) | (1L << 31) | (1L << 44))) != 0)) ) {
					((CompExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(231); ((CompExprContext)_localctx).rhs = primaryExpr();
				 ((CompExprContext)_localctx).val =  new BinaryExpr((((CompExprContext)_localctx).op!=null?((CompExprContext)_localctx).op.getText():null), ((CompExprContext)_localctx).lhs.val, ((CompExprContext)_localctx).rhs.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(234); ((CompExprContext)_localctx).lhs = primaryExpr();
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
		public DateLiteralContext dateLiteral;
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
		enterRule(_localctx, 30, RULE_primaryExpr);
		int _la;
		try {
			setState(285);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(239); ((PrimaryExprContext)_localctx).e1 = columnExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).e1.val; 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(242); ((PrimaryExprContext)_localctx).functionExpr = functionExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).functionExpr.val; 
				}
				break;

			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(245); ((PrimaryExprContext)_localctx).numberLiteral = numberLiteral();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).numberLiteral.val; 
				}
				break;

			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(248); ((PrimaryExprContext)_localctx).stringLiteral = stringLiteral();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).stringLiteral.val; 
				}
				break;

			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(251); ((PrimaryExprContext)_localctx).booleanLiteral = booleanLiteral();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).booleanLiteral.val; 
				}
				break;

			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(254); ((PrimaryExprContext)_localctx).dateLiteral = dateLiteral();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).dateLiteral.val; 
				}
				break;

			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(257); ((PrimaryExprContext)_localctx).caseExpr = caseExpr();
				 ((PrimaryExprContext)_localctx).val =  ((PrimaryExprContext)_localctx).caseExpr.val; 
				}
				break;

			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(260); match(11);
				setState(261); ((PrimaryExprContext)_localctx).expr = expr();
				 ((PrimaryExprContext)_localctx).val =  new DistinctExpr(((PrimaryExprContext)_localctx).expr.val); 
				}
				break;

			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(264); match(12);
				setState(265); match(9);
				setState(266); ((PrimaryExprContext)_localctx).expr = expr();
				setState(267); match(23);
				setState(268);
				((PrimaryExprContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 1) | (1L << 20) | (1L << 40) | (1L << 41))) != 0)) ) {
					((PrimaryExprContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(269); match(49);
				 ((PrimaryExprContext)_localctx).val =  new CastExpr(((PrimaryExprContext)_localctx).expr.val, (((PrimaryExprContext)_localctx).type!=null?((PrimaryExprContext)_localctx).type.getText():null)); 
				}
				break;

			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(272); match(27);
				setState(273); match(9);
				setState(274);
				((PrimaryExprContext)_localctx).type = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 4) | (1L << 13) | (1L << 15) | (1L << 18) | (1L << 32) | (1L << 39) | (1L << 42))) != 0)) ) {
					((PrimaryExprContext)_localctx).type = (Token)_errHandler.recoverInline(this);
				}
				consume();
				setState(275); match(2);
				setState(276); ((PrimaryExprContext)_localctx).expr = expr();
				setState(277); match(49);
				 ((PrimaryExprContext)_localctx).val =  new ExtractExpr(((PrimaryExprContext)_localctx).expr.val, (((PrimaryExprContext)_localctx).type!=null?((PrimaryExprContext)_localctx).type.getText():null)); 
				}
				break;

			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(280); match(9);
				setState(281); ((PrimaryExprContext)_localctx).expr = expr();
				setState(282); match(49);
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
		enterRule(_localctx, 32, RULE_caseExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(287); match(7);
			setState(288); ((CaseExprContext)_localctx).wt = whenThenExpr();
			setState(289); match(25);
			setState(290); ((CaseExprContext)_localctx).e = expr();
			setState(291); match(28);
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
		enterRule(_localctx, 34, RULE_whenThenExpr);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(294); match(38);
			setState(295); ((WhenThenExprContext)_localctx).e1 = expr();
			setState(296); match(30);
			setState(297); ((WhenThenExprContext)_localctx).e2 = expr();
			 ((WhenThenExprContext)_localctx).val =  new LinkedList<WhenThen>(); _localctx.val.add(new WhenThen(((WhenThenExprContext)_localctx).e1.val, ((WhenThenExprContext)_localctx).e2.val)); 
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==38) {
				{
				{
				setState(299); match(38);
				setState(300); ((WhenThenExprContext)_localctx).e3 = expr();
				setState(301); match(30);
				setState(302); ((WhenThenExprContext)_localctx).e4 = expr();
				 _localctx.val.add(new WhenThen(((WhenThenExprContext)_localctx).e3.val, ((WhenThenExprContext)_localctx).e4.val)); 
				}
				}
				setState(309);
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
		enterRule(_localctx, 36, RULE_functionExpr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(310); ((FunctionExprContext)_localctx).id = name();
			setState(311); match(9);
			setState(312); ((FunctionExprContext)_localctx).args = args();
			setState(313); match(49);
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
		enterRule(_localctx, 38, RULE_booleanLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(316);
			((BooleanLiteralContext)_localctx).tk = _input.LT(1);
			_la = _input.LA(1);
			if ( !(_la==14 || _la==21) ) {
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
		enterRule(_localctx, 40, RULE_numberLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(319); ((NumberLiteralContext)_localctx).numtk = match(NUMBER_LITERAL);
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
		enterRule(_localctx, 42, RULE_stringLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(322); ((StringLiteralContext)_localctx).str = str();
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
		enterRule(_localctx, 44, RULE_dateLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(325); match(41);
			setState(326); ((DateLiteralContext)_localctx).str = str();
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
		enterRule(_localctx, 46, RULE_groupargs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<GroupArg> _args = new ArrayList<GroupArg>(); 
			setState(341);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 9) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 21) | (1L << 27) | (1L << 41) | (1L << NUMBER_LITERAL) | (1L << ID1) | (1L << ID2) | (1L << STR))) != 0)) {
				{
				setState(330); ((GroupargsContext)_localctx).e1 = grouparg();
				 _args.add(((GroupargsContext)_localctx).e1.val); 
				setState(338);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==10) {
					{
					{
					setState(332); match(10);
					setState(333); ((GroupargsContext)_localctx).e2 = grouparg();
					 _args.add(((GroupargsContext)_localctx).e2.val); 
					}
					}
					setState(340);
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
		enterRule(_localctx, 48, RULE_grouparg);
		try {
			setState(351);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(345); ((GroupargContext)_localctx).pint = pint();
				 ((GroupargContext)_localctx).val =  new ColumnNumberArg(((GroupargContext)_localctx).pint.val); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(348); ((GroupargContext)_localctx).expr = expr();
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
		enterRule(_localctx, 50, RULE_args);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			 List<Expr> _args = new ArrayList<Expr>(); 
			setState(365);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << 7) | (1L << 9) | (1L << 11) | (1L << 12) | (1L << 14) | (1L << 21) | (1L << 27) | (1L << 41) | (1L << NUMBER_LITERAL) | (1L << ID1) | (1L << ID2) | (1L << STR))) != 0)) {
				{
				setState(354); ((ArgsContext)_localctx).e1 = expr();
				 _args.add(((ArgsContext)_localctx).e1.val); 
				setState(362);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==10) {
					{
					{
					setState(356); match(10);
					setState(357); ((ArgsContext)_localctx).e2 = expr();
					 _args.add(((ArgsContext)_localctx).e2.val); 
					}
					}
					setState(364);
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
		enterRule(_localctx, 52, RULE_columnExpr);
		try {
			setState(377);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(369); ((ColumnExprContext)_localctx).id2 = name();
				 ((ColumnExprContext)_localctx).val =  new ColumnExpr(null,      ((ColumnExprContext)_localctx).id2.text); 
				}
				break;

			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(372); ((ColumnExprContext)_localctx).id1 = name();
				setState(373); match(37);
				setState(374); ((ColumnExprContext)_localctx).id2 = name();
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
		enterRule(_localctx, 54, RULE_name);
		try {
			setState(383);
			switch (_input.LA(1)) {
			case ID1:
				enterOuterAlt(_localctx, 1);
				{
				setState(379); ((NameContext)_localctx).ID1 = match(ID1);
				 ((NameContext)_localctx).text =  (((NameContext)_localctx).ID1!=null?((NameContext)_localctx).ID1.getText():null); 
				}
				break;
			case ID2:
				enterOuterAlt(_localctx, 2);
				{
				setState(381); ((NameContext)_localctx).ID2 = match(ID2);
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
		enterRule(_localctx, 56, RULE_str);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385); ((StrContext)_localctx).STR = match(STR);
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
		enterRule(_localctx, 58, RULE_pint);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(388); ((PintContext)_localctx).num = match(NUMBER_LITERAL);
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
		"\2\39\u018a\4\2\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4"+
		"\t\t\t\4\n\t\n\4\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20"+
		"\4\21\t\21\4\22\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27"+
		"\4\30\t\30\4\31\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36"+
		"\4\37\t\37\3\2\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4~\n\4\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\7\5\u0086\n\5\f\5\16\5\u0089\13\5\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\5\6\u0095\n\6\3\7\3\7\3\7\3\7\3\7\5\7\u009c\n\7\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\b\u00a4\n\b\3\t\3\t\3\t\3\t\3\t\5\t\u00ab\n\t"+
		"\3\n\3\n\3\n\3\n\3\n\5\n\u00b2\n\n\3\13\3\13\3\13\3\13\3\13\5\13\u00b9"+
		"\n\13\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00c6\n\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\3\16\3\16\5\16\u00d0\n\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\5\17\u00e6\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20"+
		"\u00f0\n\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0120\n\21\3\22\3\22\3\22\3\22\3\22"+
		"\3\22\3\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23"+
		"\u0134\n\23\f\23\16\23\u0137\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\31\3\31"+
		"\3\31\3\31\3\31\3\31\3\31\7\31\u0153\n\31\f\31\16\31\u0156\13\31\5\31"+
		"\u0158\n\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3\32\5\32\u0162\n\32\3"+
		"\33\3\33\3\33\3\33\3\33\3\33\3\33\7\33\u016b\n\33\f\33\16\33\u016e\13"+
		"\33\5\33\u0170\n\33\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34"+
		"\5\34\u017c\n\34\3\35\3\35\3\35\3\35\5\35\u0182\n\35\3\36\3\36\3\36\3"+
		"\37\3\37\3\37\3\37\2 \2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,."+
		"\60\62\64\668:<\2\13\4%%--\4\4\4##\3/\60\4\37\37\64\64\3\61\62\5\22\23"+
		"!!..\5\3\3\26\26*+\t\6\6\17\17\21\21\24\24\"\")),,\4\20\20\27\27\u0193"+
		"\2>\3\2\2\2\4B\3\2\2\2\6}\3\2\2\2\b\177\3\2\2\2\n\u0094\3\2\2\2\f\u009b"+
		"\3\2\2\2\16\u00a3\3\2\2\2\20\u00aa\3\2\2\2\22\u00b1\3\2\2\2\24\u00b8\3"+
		"\2\2\2\26\u00ba\3\2\2\2\30\u00c5\3\2\2\2\32\u00cf\3\2\2\2\34\u00e5\3\2"+
		"\2\2\36\u00ef\3\2\2\2 \u011f\3\2\2\2\"\u0121\3\2\2\2$\u0128\3\2\2\2&\u0138"+
		"\3\2\2\2(\u013e\3\2\2\2*\u0141\3\2\2\2,\u0144\3\2\2\2.\u0147\3\2\2\2\60"+
		"\u014b\3\2\2\2\62\u0161\3\2\2\2\64\u0163\3\2\2\2\66\u017b\3\2\2\28\u0181"+
		"\3\2\2\2:\u0183\3\2\2\2<\u0186\3\2\2\2>?\5\4\3\2?@\7\n\2\2@A\b\2\1\2A"+
		"\3\3\2\2\2BC\t\2\2\2CD\5\b\5\2DE\t\3\2\2EF\5\6\4\2FG\5\f\7\2GH\5\16\b"+
		"\2HI\5\20\t\2IJ\5\22\n\2JK\5\24\13\2KL\b\3\1\2L\5\3\2\2\2MN\58\35\2NO"+
		"\7\31\2\2OP\58\35\2PQ\b\4\1\2Q~\3\2\2\2RS\58\35\2ST\58\35\2TU\b\4\1\2"+
		"U~\3\2\2\2VW\58\35\2WX\b\4\1\2X~\3\2\2\2YZ\58\35\2Z[\7\'\2\2[\\\58\35"+
		"\2\\]\7\31\2\2]^\58\35\2^_\b\4\1\2_~\3\2\2\2`a\58\35\2ab\7\'\2\2bc\58"+
		"\35\2cd\58\35\2de\b\4\1\2e~\3\2\2\2fg\58\35\2gh\7\'\2\2hi\58\35\2ij\b"+
		"\4\1\2j~\3\2\2\2kl\7\13\2\2lm\5\4\3\2mn\7\63\2\2no\7\31\2\2op\58\35\2"+
		"pq\b\4\1\2q~\3\2\2\2rs\7\13\2\2st\5\4\3\2tu\7\63\2\2uv\58\35\2vw\b\4\1"+
		"\2w~\3\2\2\2xy\7\13\2\2yz\5\4\3\2z{\7\63\2\2{|\b\4\1\2|~\3\2\2\2}M\3\2"+
		"\2\2}R\3\2\2\2}V\3\2\2\2}Y\3\2\2\2}`\3\2\2\2}f\3\2\2\2}k\3\2\2\2}r\3\2"+
		"\2\2}x\3\2\2\2~\7\3\2\2\2\177\u0080\5\n\6\2\u0080\u0087\b\5\1\2\u0081"+
		"\u0082\7\f\2\2\u0082\u0083\5\n\6\2\u0083\u0084\b\5\1\2\u0084\u0086\3\2"+
		"\2\2\u0085\u0081\3\2\2\2\u0086\u0089\3\2\2\2\u0087\u0085\3\2\2\2\u0087"+
		"\u0088\3\2\2\2\u0088\t\3\2\2\2\u0089\u0087\3\2\2\2\u008a\u008b\5\26\f"+
		"\2\u008b\u008c\7\31\2\2\u008c\u008d\58\35\2\u008d\u008e\b\6\1\2\u008e"+
		"\u0095\3\2\2\2\u008f\u0090\5\26\f\2\u0090\u0091\b\6\1\2\u0091\u0095\3"+
		"\2\2\2\u0092\u0093\7$\2\2\u0093\u0095\b\6\1\2\u0094\u008a\3\2\2\2\u0094"+
		"\u008f\3\2\2\2\u0094\u0092\3\2\2\2\u0095\13\3\2\2\2\u0096\u0097\7\34\2"+
		"\2\u0097\u0098\5\26\f\2\u0098\u0099\b\7\1\2\u0099\u009c\3\2\2\2\u009a"+
		"\u009c\b\7\1\2\u009b\u0096\3\2\2\2\u009b\u009a\3\2\2\2\u009c\r\3\2\2\2"+
		"\u009d\u009e\7\b\2\2\u009e\u009f\7\32\2\2\u009f\u00a0\5\60\31\2\u00a0"+
		"\u00a1\b\b\1\2\u00a1\u00a4\3\2\2\2\u00a2\u00a4\b\b\1\2\u00a3\u009d\3\2"+
		"\2\2\u00a3\u00a2\3\2\2\2\u00a4\17\3\2\2\2\u00a5\u00a6\7\25\2\2\u00a6\u00a7"+
		"\5\26\f\2\u00a7\u00a8\b\t\1\2\u00a8\u00ab\3\2\2\2\u00a9\u00ab\b\t\1\2"+
		"\u00aa\u00a5\3\2\2\2\u00aa\u00a9\3\2\2\2\u00ab\21\3\2\2\2\u00ac\u00ad"+
		"\7\30\2\2\u00ad\u00ae\5<\37\2\u00ae\u00af\b\n\1\2\u00af\u00b2\3\2\2\2"+
		"\u00b0\u00b2\b\n\1\2\u00b1\u00ac\3\2\2\2\u00b1\u00b0\3\2\2\2\u00b2\23"+
		"\3\2\2\2\u00b3\u00b4\7&\2\2\u00b4\u00b5\5<\37\2\u00b5\u00b6\b\13\1\2\u00b6"+
		"\u00b9\3\2\2\2\u00b7\u00b9\b\13\1\2\u00b8\u00b3\3\2\2\2\u00b8\u00b7\3"+
		"\2\2\2\u00b9\25\3\2\2\2\u00ba\u00bb\5\30\r\2\u00bb\u00bc\b\f\1\2\u00bc"+
		"\27\3\2\2\2\u00bd\u00be\5\32\16\2\u00be\u00bf\t\4\2\2\u00bf\u00c0\5\32"+
		"\16\2\u00c0\u00c1\b\r\1\2\u00c1\u00c6\3\2\2\2\u00c2\u00c3\5\32\16\2\u00c3"+
		"\u00c4\b\r\1\2\u00c4\u00c6\3\2\2\2\u00c5\u00bd\3\2\2\2\u00c5\u00c2\3\2"+
		"\2\2\u00c6\31\3\2\2\2\u00c7\u00c8\5\34\17\2\u00c8\u00c9\t\5\2\2\u00c9"+
		"\u00ca\5\34\17\2\u00ca\u00cb\b\16\1\2\u00cb\u00d0\3\2\2\2\u00cc\u00cd"+
		"\5\34\17\2\u00cd\u00ce\b\16\1\2\u00ce\u00d0\3\2\2\2\u00cf\u00c7\3\2\2"+
		"\2\u00cf\u00cc\3\2\2\2\u00d0\33\3\2\2\2\u00d1\u00d2\5\36\20\2\u00d2\u00d3"+
		"\7\7\2\2\u00d3\u00d4\5\36\20\2\u00d4\u00d5\b\17\1\2\u00d5\u00e6\3\2\2"+
		"\2\u00d6\u00d7\5\36\20\2\u00d7\u00d8\t\6\2\2\u00d8\u00d9\7\13\2\2\u00d9"+
		"\u00da\5\64\33\2\u00da\u00db\7\63\2\2\u00db\u00dc\b\17\1\2\u00dc\u00e6"+
		"\3\2\2\2\u00dd\u00de\5\36\20\2\u00de\u00df\7\5\2\2\u00df\u00e0\5\36\20"+
		"\2\u00e0\u00e1\b\17\1\2\u00e1\u00e6\3\2\2\2\u00e2\u00e3\5\36\20\2\u00e3"+
		"\u00e4\b\17\1\2\u00e4\u00e6\3\2\2\2\u00e5\u00d1\3\2\2\2\u00e5\u00d6\3"+
		"\2\2\2\u00e5\u00dd\3\2\2\2\u00e5\u00e2\3\2\2\2\u00e6\35\3\2\2\2\u00e7"+
		"\u00e8\5 \21\2\u00e8\u00e9\t\7\2\2\u00e9\u00ea\5 \21\2\u00ea\u00eb\b\20"+
		"\1\2\u00eb\u00f0\3\2\2\2\u00ec\u00ed\5 \21\2\u00ed\u00ee\b\20\1\2\u00ee"+
		"\u00f0\3\2\2\2\u00ef\u00e7\3\2\2\2\u00ef\u00ec\3\2\2\2\u00f0\37\3\2\2"+
		"\2\u00f1\u00f2\5\66\34\2\u00f2\u00f3\b\21\1\2\u00f3\u0120\3\2\2\2\u00f4"+
		"\u00f5\5&\24\2\u00f5\u00f6\b\21\1\2\u00f6\u0120\3\2\2\2\u00f7\u00f8\5"+
		"*\26\2\u00f8\u00f9\b\21\1\2\u00f9\u0120\3\2\2\2\u00fa\u00fb\5,\27\2\u00fb"+
		"\u00fc\b\21\1\2\u00fc\u0120\3\2\2\2\u00fd\u00fe\5(\25\2\u00fe\u00ff\b"+
		"\21\1\2\u00ff\u0120\3\2\2\2\u0100\u0101\5.\30\2\u0101\u0102\b\21\1\2\u0102"+
		"\u0120\3\2\2\2\u0103\u0104\5\"\22\2\u0104\u0105\b\21\1\2\u0105\u0120\3"+
		"\2\2\2\u0106\u0107\7\r\2\2\u0107\u0108\5\26\f\2\u0108\u0109\b\21\1\2\u0109"+
		"\u0120\3\2\2\2\u010a\u010b\7\16\2\2\u010b\u010c\7\13\2\2\u010c\u010d\5"+
		"\26\f\2\u010d\u010e\7\31\2\2\u010e\u010f\t\b\2\2\u010f\u0110\7\63\2\2"+
		"\u0110\u0111\b\21\1\2\u0111\u0120\3\2\2\2\u0112\u0113\7\35\2\2\u0113\u0114"+
		"\7\13\2\2\u0114\u0115\t\t\2\2\u0115\u0116\7\4\2\2\u0116\u0117\5\26\f\2"+
		"\u0117\u0118\7\63\2\2\u0118\u0119\b\21\1\2\u0119\u0120\3\2\2\2\u011a\u011b"+
		"\7\13\2\2\u011b\u011c\5\26\f\2\u011c\u011d\7\63\2\2\u011d\u011e\b\21\1"+
		"\2\u011e\u0120\3\2\2\2\u011f\u00f1\3\2\2\2\u011f\u00f4\3\2\2\2\u011f\u00f7"+
		"\3\2\2\2\u011f\u00fa\3\2\2\2\u011f\u00fd\3\2\2\2\u011f\u0100\3\2\2\2\u011f"+
		"\u0103\3\2\2\2\u011f\u0106\3\2\2\2\u011f\u010a\3\2\2\2\u011f\u0112\3\2"+
		"\2\2\u011f\u011a\3\2\2\2\u0120!\3\2\2\2\u0121\u0122\7\t\2\2\u0122\u0123"+
		"\5$\23\2\u0123\u0124\7\33\2\2\u0124\u0125\5\26\f\2\u0125\u0126\7\36\2"+
		"\2\u0126\u0127\b\22\1\2\u0127#\3\2\2\2\u0128\u0129\7(\2\2\u0129\u012a"+
		"\5\26\f\2\u012a\u012b\7 \2\2\u012b\u012c\5\26\f\2\u012c\u0135\b\23\1\2"+
		"\u012d\u012e\7(\2\2\u012e\u012f\5\26\f\2\u012f\u0130\7 \2\2\u0130\u0131"+
		"\5\26\f\2\u0131\u0132\b\23\1\2\u0132\u0134\3\2\2\2\u0133\u012d\3\2\2\2"+
		"\u0134\u0137\3\2\2\2\u0135\u0133\3\2\2\2\u0135\u0136\3\2\2\2\u0136%\3"+
		"\2\2\2\u0137\u0135\3\2\2\2\u0138\u0139\58\35\2\u0139\u013a\7\13\2\2\u013a"+
		"\u013b\5\64\33\2\u013b\u013c\7\63\2\2\u013c\u013d\b\24\1\2\u013d\'\3\2"+
		"\2\2\u013e\u013f\t\n\2\2\u013f\u0140\b\25\1\2\u0140)\3\2\2\2\u0141\u0142"+
		"\7\66\2\2\u0142\u0143\b\26\1\2\u0143+\3\2\2\2\u0144\u0145\5:\36\2\u0145"+
		"\u0146\b\27\1\2\u0146-\3\2\2\2\u0147\u0148\7+\2\2\u0148\u0149\5:\36\2"+
		"\u0149\u014a\b\30\1\2\u014a/\3\2\2\2\u014b\u0157\b\31\1\2\u014c\u014d"+
		"\5\62\32\2\u014d\u0154\b\31\1\2\u014e\u014f\7\f\2\2\u014f\u0150\5\62\32"+
		"\2\u0150\u0151\b\31\1\2\u0151\u0153\3\2\2\2\u0152\u014e\3\2\2\2\u0153"+
		"\u0156\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2\2\2\u0155\u0158\3\2"+
		"\2\2\u0156\u0154\3\2\2\2\u0157\u014c\3\2\2\2\u0157\u0158\3\2\2\2\u0158"+
		"\u0159\3\2\2\2\u0159\u015a\b\31\1\2\u015a\61\3\2\2\2\u015b\u015c\5<\37"+
		"\2\u015c\u015d\b\32\1\2\u015d\u0162\3\2\2\2\u015e\u015f\5\26\f\2\u015f"+
		"\u0160\b\32\1\2\u0160\u0162\3\2\2\2\u0161\u015b\3\2\2\2\u0161\u015e\3"+
		"\2\2\2\u0162\63\3\2\2\2\u0163\u016f\b\33\1\2\u0164\u0165\5\26\f\2\u0165"+
		"\u016c\b\33\1\2\u0166\u0167\7\f\2\2\u0167\u0168\5\26\f\2\u0168\u0169\b"+
		"\33\1\2\u0169\u016b\3\2\2\2\u016a\u0166\3\2\2\2\u016b\u016e\3\2\2\2\u016c"+
		"\u016a\3\2\2\2\u016c\u016d\3\2\2\2\u016d\u0170\3\2\2\2\u016e\u016c\3\2"+
		"\2\2\u016f\u0164\3\2\2\2\u016f\u0170\3\2\2\2\u0170\u0171\3\2\2\2\u0171"+
		"\u0172\b\33\1\2\u0172\65\3\2\2\2\u0173\u0174\58\35\2\u0174\u0175\b\34"+
		"\1\2\u0175\u017c\3\2\2\2\u0176\u0177\58\35\2\u0177\u0178\7\'\2\2\u0178"+
		"\u0179\58\35\2\u0179\u017a\b\34\1\2\u017a\u017c\3\2\2\2\u017b\u0173\3"+
		"\2\2\2\u017b\u0176\3\2\2\2\u017c\67\3\2\2\2\u017d\u017e\7\67\2\2\u017e"+
		"\u0182\b\35\1\2\u017f\u0180\78\2\2\u0180\u0182\b\35\1\2\u0181\u017d\3"+
		"\2\2\2\u0181\u017f\3\2\2\2\u01829\3\2\2\2\u0183\u0184\79\2\2\u0184\u0185"+
		"\b\36\1\2\u0185;\3\2\2\2\u0186\u0187\7\66\2\2\u0187\u0188\b\37\1\2\u0188"+
		"=\3\2\2\2\27}\u0087\u0094\u009b\u00a3\u00aa\u00b1\u00b8\u00c5\u00cf\u00e5"+
		"\u00ef\u011f\u0135\u0154\u0157\u0161\u016c\u016f\u017b\u0181";
	public static final ATN _ATN =
		ATNSimulator.deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
	}
}