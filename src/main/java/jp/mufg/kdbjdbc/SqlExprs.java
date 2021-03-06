package jp.mufg.kdbjdbc;

import java.util.ArrayList;
import java.util.IdentityHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;

public class SqlExprs {
    public static final String DUMMY_COLUMN_PREFIX = "dummy_";

    public static class SelectStatement {
        private final Table table;
        private final List<Column> columns;
        private final List<GroupArg> groupargs;
        private Expr where; //amendable
        private final Expr having;
        private Integer limit; //amendable
        private boolean forceSimpleLimit = false;
        private final Integer offset;

        public SelectStatement(
            @NotNull List<Column> columns,
            @NotNull Table table,
            @Nullable Expr where,
            @Nullable List<GroupArg> groupargs,
            @Nullable Expr having,
            @Nullable Integer limit,
            @Nullable Integer offset
        )
        {
            this.columns = columns;
            this.table = table;
            this.groupargs = groupargs;
            this.having = having;
            this.limit = limit;
            this.offset = offset;
            if(groupargs != null) {
                for(GroupArg g : groupargs) {
                    g.setReferenceColumn(columns);
                }
            }
            //top level and is converted into subphrase
            if(where != null) {
                where = uncurry(where);
                LinkedList<Expr> result = new LinkedList<SqlExprs.Expr>();
                where.collectTopLevelAndLeaf(result);
                if(result.size() > 1) {
                    //move date condition at first
                    LinkedList<Expr> date_result = new LinkedList<SqlExprs.Expr>();
                    LinkedList<Expr> non_date_result = new LinkedList<SqlExprs.Expr>();
                    LinkedList<Expr> sorted_result = new LinkedList<SqlExprs.Expr>();
                    for(Expr e : result) {
                        String q = e.toQscript();
                        if(q.matches("(.*^[\\w\\d_]|\\A)date .*")) {
                            date_result.add(e);
                        }
                        else {
                            non_date_result.add(e);
                        }
                    }
                    sorted_result.addAll(date_result);
                    sorted_result.addAll(non_date_result);
                    where = new SubphraseExpr(sorted_result);
                }
            }

            //special treatment for WHERE 0 = 1
            if(where != null && where.toQscript().equals("0 = 1") && (table instanceof TableSelect)) {
                this.where = null;
                SelectStatement sel = ((TableSelect)table).select;
                sel.limit = 1;
                sel.forceSimpleLimit = true;
            }
            else {
                this.where = where;
            }
        }

        @Override
        public String toString() {
            return "SELECT " + columns + " FROM " + table + " WHERE " + where + " GROUP BY " + groupargs + " HAVING " + having + " LIMIT " + limit + " OFFSET " + offset;
        }

        public void checkType(TypeContext ctxt) {
            //subquery

            if(where != null) {
                where.checkType(new TypeContextSupportSubquery(ctxt));
            }
        }

        private class TypeContextSupportSubquery implements TypeContext {
            private final TypeContext internal;

            TypeContextSupportSubquery(TypeContext internal) {
                this.internal = internal;
            }

            @Override
            public char getType(String tableName, String columnName) {
                // i.e. tableName is "Custom SQL Query" and its alias of another subquery
                if(tableName.equals(table.getAliasName())) {
                    tableName = table.getTableName();
                }
                return internal.getType(tableName, columnName);
            }
        }

        private boolean isDistinct() {
            if(groupargs == null)
                return false;
            Map<Column,Column> colmap = new IdentityHashMap<Column,Column>();
            for(Column c : columns)
                colmap.put(c, c);
            for(GroupArg g : groupargs) {
                Column c = g.getReferenceColumn();
                if(c != null) {
                    colmap.remove(c);
                }
            }
            return colmap.size() == 0;
        }

        
        public String toQscript() {
            StringBuilder s = new StringBuilder();

            //SELECT * FROM (SELECT * FROM t) WHERE (0=1)
            //is converted into
            //SELECT * FROM (SELECT * FROM t LIMIT 1)
            //to push down condition

            String tblname = table.getTableName();
            //date condition is pushdown to function arg
            if(where != null && ((where instanceof SubphraseExpr) || (where instanceof BinaryExpr))) {
                List<Expr> subexprs;
                if(where instanceof SubphraseExpr) {
                    subexprs = ((SubphraseExpr)where).exprs;
                }
                else {
                    subexprs = new LinkedList<SqlExprs.Expr>();
                    subexprs.add(where);
                }
                String date_from = null;
                String date_to   = null;
                for(Expr e : subexprs) {
                    e = uncurry(e);
                    if(e.toQscript().matches("\\Adate = .+") && (e instanceof BinaryExpr)) {
                        date_from = date_to = uncurry(((BinaryExpr)e).rhs).toQscript();
                    }
                    else if(e.toQscript().matches("\\Adate >= .+") && (e instanceof BinaryExpr)) {
                        date_from = uncurry(((BinaryExpr)e).rhs).toQscript();
                    }
                    else if(e.toQscript().matches("\\Adate > .+") && (e instanceof BinaryExpr)) {
                        date_from = "(" + uncurry(((BinaryExpr)e).rhs).toQscript() + ") + 1";
                    }
                    else if(e.toQscript().matches("\\Adate <= .+") && (e instanceof BinaryExpr)) {
                        date_to = uncurry(((BinaryExpr)e).rhs).toQscript();
                    }
                    else if(e.toQscript().matches("\\Adate < .+") && (e instanceof BinaryExpr)) {
                        date_to = "(" + uncurry(((BinaryExpr)e).rhs).toQscript() + ") - 1";
                    }
                }                
                if(date_from != null && date_to != null) {
                    //First two arguments of function look date type and date_from and date_to are given.
                    tblname = tblname.replaceFirst( "\\[ *[0-9][0-9][0-9][0-9]\\.[0-9][0-9]\\.[0-9][0-9] *; *[0-9][0-9][0-9][0-9]\\.[0-9][0-9]\\.[0-9][0-9] *", "[" + date_from + ";" + date_to);
                }
                else if(date_from != null) {
                    //First one argument  of function look date type and date_from.
                    if(tblname.matches(".*\\[ *[0-9][0-9][0-9][0-9]\\.[0-9][0-9]\\.[0-9][0-9] *; *[0-9][0-9][0-9][0-9]\\.[0-9][0-9]\\.[0-9][0-9].*")) {
                        //if funciton has two dates arguments, we should skip it.
                        //TESTED by test_select_stmt_func_subquery_where_pushdown5_only_from_clause
                    }
                    else {
                        tblname = tblname.replaceFirst( "\\[ *[0-9][0-9][0-9][0-9]\\.[0-9][0-9]\\.[0-9][0-9] *", "[" + date_from);
                    }
                }
            }


            final boolean distinct = isDistinct();
            //groupby
            Map<Column, Column> excludedColumn = new IdentityHashMap<SqlExprs.Column,SqlExprs.Column>();
            StringBuilder gs = new StringBuilder();
            if(! distinct && groupargs != null) {
                int groupcnt = 0;
                for(GroupArg g : groupargs) {
                    if(gs.length() > 0)
                        gs.append(", ");
                    Column gc = g.getReferenceColumn();
                    if(gc != null) {
                        excludedColumn.put(gc, gc);
                        gs.append(SqlSelectToQscriptTranslator.escapeColumnName(gc.getAliasName()));
                    }
                    else {
                        gs.append(DUMMY_COLUMN_PREFIX + groupcnt);
                    }
                    gs.append(":");
                    gs.append(g.toQscript());
                    groupcnt++;
                }
            }

            if(distinct) {
                s.append("distinct ");
            }
            s.append("select ");
            {
                StringBuilder cs = new StringBuilder();
                for(Column c : columns) {
                    if(excludedColumn.get(c) == null) {
                        if(cs.length() > 0)
                            cs.append(", ");
                        if(! c.toQscript().equals("*")) {
                            String aliasname = c.getAliasName();
                            cs.append(SqlSelectToQscriptTranslator.escapeColumnName(aliasname));
                            cs.append(":");
                            cs.append(c.toQscript());
                        }
                    }
                }
                s.append(cs.toString());
            }
            if(gs.length() > 0) {
                s.append(" by ");
                s.append(gs.toString());
            }
            s.append(" from ");
            s.append(tblname);
            //ignore alias name
            //HAVING is ignored
            if(where != null) {
                s.append(" where ");
                s.append(where.toQscript());
            }

            String q = s.toString();
            if(limit != null) {
                if(forceSimpleLimit) {
                    q = limit + "#" + q;
                }
                else {
                    final int server_limit = offset != null ? limit + offset : limit;
                    q = "(min(" + server_limit + ",count(" + q + ")))#" + q;
                    if(offset != null) {
                        //add in-memory limit and offset
                        q = "select [" + offset + "," + limit + "] from " + q;
                    }
                }
            }

            return q;
        }
    }
    
    public static interface Table {
        public String getTableName();
        public String getAliasName();
    }

    public static class TableSelect implements Table {
        private final SelectStatement select;
        private final String aliasName;

        public TableSelect(
            @NotNull SelectStatement select,
            @NotNull String aliasName
        )
        {
            this.select = select;
            this.aliasName = aliasName;
        }

        @Override
        public String getAliasName() {
            return aliasName;
        }

        @Override
        public String getTableName() {
            return "(" + select.toQscript() + ")";
        }

        @Override
        public String toString() {
            return select.toString();
        }
    }

	public static class TableImpl implements Table
	{
		public enum JoinType
		{
			left("LEFT OUTER JOIN")
			, right("RIGHT OUTER JOIN")
			, inner("INNER JOIN")
			;
			
			private final String sql;

			private JoinType(String sql)
			{
				this.sql = sql;
			}
        }
        
		private final String tableName;
        private final String aliasName;
		private JoinType joinType;
		private Expr joinExpr;

		public TableImpl(@NotNull String tableName, @Nullable String aliasName)
		{
            super();
            if(tableName == null)
                throw new NullPointerException("tableName is null");
			this.tableName = tableName;
			this.aliasName = aliasName;
		}
		
        @Override
		public String getTableName()
		{
			return tableName;
		}

        @Override
		public String getAliasName()
		{
			return aliasName;
		}
		
		public JoinType getJoinType()
		{
			return joinType;
		}

		public void setJoinType(JoinType joinType)
		{
			this.joinType = joinType;
		}

		public Expr getJoinExpr()
		{
			return joinExpr;
		}

		public void setJoinExpr(Expr joinExpr)
		{
			this.joinExpr = joinExpr;
		}

		@Override
		public String toString()
		{
			StringBuilder s = new StringBuilder();
			if(joinType != null)
			{
				s.append(joinType.sql);
				s.append(" ");
			}
			s.append(tableName);
			if(aliasName != null)
			{
				s.append(" AS ");
				s.append(aliasName);
			}
			if(joinExpr != null)
			{
				s.append(" ON ");
				s.append(joinExpr.toString());
			}
			return s.toString();
		}
    }

    public static interface Column {
        public String getAliasName();
        public String toQscript();
    }

    public static class WildcardColumns implements Column {
        @Override
        public String getAliasName() {
            return null;
        }

        @Override
        public String toQscript() {
            return "*";
        }

        @Override
        public String toString() {
            return "*";
        }
    }

    public static class ColumnImpl implements Column {
        @NotNull
        private final Expr expr;
        @Nullable
        private final String aliasName;

        public ColumnImpl(@NotNull Expr expr, @Nullable String aliasName) {
            if(expr == null)
                throw new NullPointerException("expr is null");
            this.expr = expr;
            this.aliasName = aliasName;
        }

        public boolean isAliasSpecified() {
            return aliasName != null;
        }

        @Override
        public String getAliasName() {
            if(aliasName != null)
                return aliasName;
            if(expr instanceof ColumnExpr) {
                return ((ColumnExpr)expr).columnName;
            }
            return expr.toString();
        }

        @Override
        public String toQscript() {
            return expr.toQscript();
        }

        @Override
        public String toString() {
            return expr + " AS " + aliasName;
        }
    }

    public static interface GroupArg {
        public void setReferenceColumn(List<Column> columns);

        @Nullable
        public Column getReferenceColumn();

        public String toQscript();
    }

    public static class ColumnNumberArg implements GroupArg {
        private final int columnNumber;
        private Column refColumn;

        public ColumnNumberArg(int columnNumber) {
            this.columnNumber = columnNumber;
        }

        @Override
        public void setReferenceColumn(List<Column> columns) {
            this.refColumn = columns.get(columnNumber-1);
        }

        @Nullable
        @Override
        public Column getReferenceColumn() {
            return refColumn;
        }

        @Override
        public String toQscript() {
            return refColumn.toQscript();
        }

    }

    public static class GroupExpr implements GroupArg {
        @NotNull
        private final Expr expr;

        public GroupExpr(@NotNull Expr expr) {
            if(expr == null)
                throw new NullPointerException("expr is null");
            this.expr = expr;
        }

        @Override
        public void setReferenceColumn(List<Column> columns) {
            //do nothing
        }

        @Nullable
        @Override
        public Column getReferenceColumn() {
            return null;
        }

        @Override
        public String toQscript() {
            return expr.toQscript();
        }
    }

	public static abstract class Expr
	{
		/**
		 * Convert SQL into q-script
		 */
        public abstract String toQscript();
        
        public abstract char getType(TypeContext ctxt);

        public abstract void checkType(TypeContext ctxt);

        public abstract void collectStringLiteral(List<StringLiteral> result);

        public void collectTopLevelAndLeaf(List<Expr> result) {
            result.add(this);
        }
    }
    
    public static interface TypeContext {
        public char getType(String tableName, String columnName);
    }

    public static class TypeContextImpl implements TypeContext {
        private final Map<String, Map<String, Character>> type_by_col_by_tbl;
        
        public TypeContextImpl(Map<String, Map<String, Character>> type_by_col_by_tbl) {
            this.type_by_col_by_tbl = type_by_col_by_tbl;
        }

        @Override
        public char getType(String tableName, String columnName) {
            Map<String, Character> type_by_col = type_by_col_by_tbl.get(tableName);
            if(type_by_col == null)
                throw new IllegalArgumentException("meta data is not found for table=" + tableName);
            Character typeobj = type_by_col.get(columnName);
            if(typeobj == null)
                throw new IllegalArgumentException("meta data is not found for table=" + tableName + " column=" + columnName);
            return (char) typeobj;
        }
    }
	
	public static class CurryExpr extends Expr //カッコを出力するためにわざわざクラスを作成
	{
		private final Expr expr;

		public CurryExpr(Expr expr)
		{
			super();
			this.expr = expr;
		}
		
		@Override
		public String toString()
		{
			return "( " + expr + " )";
        }
        
		@Override
		public String toQscript()
		{
			return "( " + expr.toQscript() + " )";
        }
        
        @Override
        public char getType(TypeContext ctxt) {
            return expr.getType(ctxt);
        }

        @Override
        public void checkType(TypeContext ctxt) {
            expr.checkType(ctxt);
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            expr.collectStringLiteral(result);
        }

		public Expr getExpr()
		{
			return expr;
        }
        
        @Override
        public void collectTopLevelAndLeaf(List<Expr> result) {
            expr.collectTopLevelAndLeaf(result);
        }
	}
	
	// public static class NullExpr extends Expr
	// {
	// 	@Override
	// 	public String toString()
	// 	{
	// 		return "NULL";
	// 	}
		
	// 	@Override
	// 	public String toJxpath()
	// 	{
	// 		return LibJx.class.getName() + ".NULL";
	// 	}
		
	// 	@Override
	// 	public String toJavaExprSrc()
	// 	{
	// 		return "null";
	// 	}
	// }
	public static class SubphraseExpr extends Expr
	{
        @NotNull
        private final List<Expr> exprs;

        public SubphraseExpr(@NotNull List<Expr> exprs) {
            if(exprs == null)
                throw new NullPointerException("exprs is null");
            this.exprs = exprs;
        }

        @Override
        public void checkType(TypeContext ctxt) {
            for(Expr e : exprs)
                e.checkType(ctxt);
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            for(Expr e : exprs)
                e.collectStringLiteral(result);
        }

        @Override
        public char getType(TypeContext ctxt) {
            return exprs.get(0).getType(ctxt);
        }

        @Override
        public String toQscript() {
            StringBuilder s = new StringBuilder();
            for(Expr e : exprs) {
                if(s.length() > 0)
                    s.append(", ");
                s.append("(");
                s.append(e.toQscript());
                s.append(")");
            }
            return s.toString();
        }

        @Override
        public String toString() {
            return toQscript();
        }
    }

	public static class BinaryExpr extends Expr
	{
		protected String op;
		protected Expr lhs, rhs;

		public BinaryExpr(String op, Expr lhs, Expr rhs)
		{
			super();
			this.lhs = lhs;
			this.rhs = rhs;
			this.op  = op.toLowerCase();
		}
		
		public String getOp()
		{
			return op;
		}

		public Expr getLhs()
		{
			return lhs;
		}

		public Expr getRhs()
		{
			return rhs;
        }

        @Override
        public void checkType(TypeContext ctxt) {
            lhs.checkType(ctxt);
            rhs.checkType(ctxt);
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            lhs.collectStringLiteral(result);
            rhs.collectStringLiteral(result);
        }

        @Override
        public char getType(TypeContext ctxt) {
            if(op.equals("<=") || op.equals(">=") || op.equals("<") || op.equals(">") || op.equals("=") || op.equals("!=") || op.equals("in") || op.equals("and") || op.equals("or"))
                return 'b'; //boolean
            //+ - * /
            return lhs.getType(ctxt); //TODO apply lhs type or rhs type depends on operator and type
        }

		@Override
		public String toString()
		{
			return "(" + lhs + " " + op + " " + rhs + ")";
		}
		
		@Override
		public String toQscript()
		{
            return lhs.toQscript() + " " + op + " " + rhs.toQscript();
        }
    }

	public static class UnaryExpr extends Expr
	{
		protected String op;
		protected Expr lhs;

		public UnaryExpr(String op, Expr lhs)
		{
			super();
			this.lhs = lhs;
			this.op  = op.toLowerCase();
		}
		
		public String getOp()
		{
			return op;
		}

		public Expr getLhs()
		{
			return lhs;
		}

        @Override
        public void checkType(TypeContext ctxt) {
            lhs.checkType(ctxt);
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            lhs.collectStringLiteral(result);
        }

        @Override
        public char getType(TypeContext ctxt) {
            return lhs.getType(ctxt);
        }

		@Override
		public String toString()
		{
            return op + " " + lhs.toString();
		}
		
		@Override
		public String toQscript()
		{
            return op + " " + lhs.toQscript();
        }
    }

    @Nullable
    private static Expr uncurry(@Nullable Expr e) {
        if(e == null)
            return null;
        if(e instanceof CurryExpr)
            return uncurry(((CurryExpr) e).expr);
        return e;
    }

    public static class AndExpr extends BinaryExpr {
        public AndExpr(Expr lhs, Expr rhs) {
            super("and", lhs, rhs);
        }

        @Override
        public String toQscript() {
            return "(" + uncurry(lhs).toQscript() + ") " + op + " (" + uncurry(rhs).toQscript() + ")";
        }

        @Override
        public void collectTopLevelAndLeaf(List<Expr> result) {
            lhs.collectTopLevelAndLeaf(result);
            rhs.collectTopLevelAndLeaf(result);
        }
    }

    public static class EqExpr extends BinaryExpr {
        public EqExpr(String op, Expr lhs, Expr rhs) {
            super(op, lhs, rhs);
        }

        @Override
        public void checkType(TypeContext ctxt) {
            final List<StringLiteral> strs = new LinkedList<SqlExprs.StringLiteral>();
            rhs.collectStringLiteral(strs);
            final char type = lhs.getType(ctxt);
            fixStringType(strs, type);
            if(type == 'C') {
                op = "like";
            }
        }
    }

    private static void fixStringType(List<StringLiteral> strs, char targetType) {
        for(StringLiteral se : strs) {
            String s = se.string;
            switch(targetType) {
                case 'd':
                    se.string = s.replace("-", ".");
                    se.type   = 'd';
                    break;
                case 'p': //fall-through
                case 'n': //fall-through
                case 'c': //fall-through
                case 'C': //fall-through
                case 'g': //fall-through
                case 's':
                    se.type = targetType;
                    break;
                default:
                    //do nothing
            }

        }
    }

	// public static class UnaryExpr extends Expr
	// {
	// 	private final String op;
	// 	private final Expr rhs;

	// 	public UnaryExpr(String op, Expr rhs)
	// 	{
	// 		super();
	// 		this.op  = op;
	// 		this.rhs = rhs;
	// 	}
		
	// 	@Override
	// 	public String toString()
	// 	{
	// 		if(op.equals("-"))
	// 		{
	// 			return op + rhs;
	// 		}
	// 		else
	// 		{
	// 			return op + " " + rhs;
	// 		}
	// 	}
		
	// 	@Override
	// 	public String toJxpath()
	// 	{
	// 		return op + rhs.toJxpath();
	// 	}
		
	// 	@Override
	// 	public String toJavaExprSrc()
	// 	{
	// 		return op + rhs.toJavaExprSrc();
	// 	}
    // }
    
	// /**
	//  * lhs IS NULLまたはlhs IS NOT NULL
	//  */
	// public static class IsExpr extends Expr
	// {
	// 	private final Expr lhs;
	// 	private final boolean not;

	// 	public IsExpr(Expr lhs, boolean not)
	// 	{
	// 		super();
	// 		this.lhs = lhs;
	// 		this.not = not;
	// 	}
		
	// 	@Override
	// 	public String toString()
	// 	{
	// 		return lhs + " " + (not ? "IS NOT NULL" : "IS NULL");
	// 	}
		
	// 	@Override
	// 	public String toJxpath()
	// 	{
	// 		StringBuilder s = new StringBuilder();
	// 		if(not) s.append("not(");
	// 		s.append(LibJx.class.getName() + ".isNull(" + lhs.toJxpath() + ")");
	// 		if(not) s.append(")");
	// 		return s.toString();
	// 	}
		
	// 	@Override
	// 	public String toJavaExprSrc()
	// 	{
	// 		return lhs.toJavaExprSrc() + " " + (not ? "!=" : "==") + " null";
	// 	}
	// }

	public static class InExpr extends Expr
	{
		private final Expr lhs;
		private final Arguments arguments;
		private final boolean not;

		public InExpr(Expr lhs, Arguments arguments, boolean not)
		{
			super();
			this.lhs = lhs;
			this.arguments = arguments;
			this.not = not;
		}
		
		public Expr getLhs()
		{
			return lhs;
        }

		public Arguments getArguments()
		{
			return arguments;
		}

		public boolean isNot()
		{
			return not;
        }
        
        @Override
        public char getType(TypeContext ctxt) {
            return 'b'; //boolean
        }

        @Override
        public void checkType(TypeContext ctxt) {
            List<StringLiteral> strs = new LinkedList<SqlExprs.StringLiteral>();
            arguments.collectStringLiteral(strs);
            fixStringType(strs, lhs.getType(ctxt));
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            lhs.collectStringLiteral(result);
            arguments.collectStringLiteral(result);
        }

		@Override
		public String toString()
		{
			return lhs + (not ? " NOT IN " : " IN ") + arguments;
		}

        @Override
        public String toQscript() {
            StringBuilder s = new StringBuilder();
            if(not)
                s.append("not (");
            s.append(lhs.toQscript());
            s.append(" in ");
            s.append("(");
            int i = 0;
            for(Expr e : arguments.exprs) {
                if(i > 0)
                    s.append("; ");
                s.append(e.toQscript());
                i++;
            }
            s.append(")");
            if(not)
                s.append(")");
            return s.toString();
        }
	}

	public static class WhenThen
	{
		private final Expr whenExpr;
		private final Expr thenExpr;
		
		public WhenThen(Expr whenExpr, Expr thenExpr)
		{
			super();
			this.whenExpr = uncurry(whenExpr);
			this.thenExpr = uncurry(thenExpr);
		}
		
		public Expr getWhenExpr()
		{
			return whenExpr;
		}
		
		public Expr getThenExpr()
		{
			return thenExpr;
		}
		
		@Override
		public String toString()
		{
			return "WHEN " + whenExpr + " THEN " + thenExpr;
		}
	}
	
	public static class CaseExpr extends Expr
	{
		private final List<WhenThen> whenThens;
		//@Nullable 
		private final Expr elseExpr;
		//@Nullable 
		private final Expr baseExpr;
		
		public CaseExpr(
                @Nullable Expr baseExpr
				, List<WhenThen> whenThens
				, @Nullable Expr elseExpr
		)
		{
            super();
			this.baseExpr = baseExpr;
			this.whenThens = whenThens;
			this.elseExpr = uncurry(elseExpr);
        }
        
		@Override
		public String toString()
		{
			StringBuilder s = new StringBuilder();
			s.append("CASE");
			// if(baseExpr != null)
			// {
			// 	s.append(" ");
			// 	s.append(baseExpr);
			// }
			for(WhenThen wt : whenThens)
			{
				s.append(" ");
				s.append(wt.toString());
			}
			if(elseExpr != null)
			{
				s.append(" ELSE ");
				s.append(elseExpr);
			}
			s.append(" END");
			return s.toString();
        }
        
        @Override
        public char getType(TypeContext ctxt) {
            return whenThens.get(0).thenExpr.getType(ctxt);
        }

        @Override
        public void checkType(TypeContext ctxt) {
            for(WhenThen wt : whenThens) {
                wt.whenExpr.checkType(ctxt);
                wt.thenExpr.checkType(ctxt);
            }
            if(elseExpr != null) {
                elseExpr.checkType(ctxt);
            }   
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            for(WhenThen wt : whenThens) {
                wt.whenExpr.collectStringLiteral(result);
                wt.thenExpr.collectStringLiteral(result);
            }
            if(elseExpr != null) {
                elseExpr.collectStringLiteral(result);
            }
        }

        @Override
        public String toQscript() {
            try {
                return tryInQscript();
            }
            catch(UnsupportedOperationException ignored) {
                return toConditionQscript();
            }
        }

        private String toConditionQscript() {
            if(baseExpr != null)
                throw new UnsupportedOperationException("case with baseExpr is not supported. " + toString());
            StringBuilder s = new StringBuilder();
            s.append("$[");
            int i = 0;
            for(WhenThen wt : whenThens) {
                if(i > 0)
                    s.append(";");
                s.append(uncurry(wt.whenExpr).toString());
                s.append(";");
                s.append(uncurry(wt.thenExpr).toQscript());
                i++;
            }
            if(elseExpr != null) {
                s.append(";");
                s.append(uncurry(elseExpr).toQscript());
            }
            s.append("]");
            return s.toString();
        }

        private String tryInQscript() {
            //assuming all when expression is ColExpr = <expr> and THEN is false and ELSE is true 
            //and then it can be converted into in condition.
            if(baseExpr != null)
                throw new UnsupportedOperationException("case with baseExpr is not supported. " + toString());
            List<Expr> inlist = new LinkedList<SqlExprs.Expr>();
            ColumnExpr colexpr = null;
            if(! (uncurry(elseExpr) instanceof BooleanLiteral))
                throw new UnsupportedOperationException("else should be BooleanLiteral");
            if(! ((BooleanLiteral)uncurry(elseExpr)).getValue())
                throw new UnsupportedOperationException("else should be TRUE");
            for(WhenThen wt : whenThens) {
                final Expr e = uncurry(wt.whenExpr);
                if(! (e instanceof EqExpr))
                    throw new UnsupportedOperationException();
                final Expr t = uncurry(wt.thenExpr);
                if(! (t instanceof BooleanLiteral))
                    throw new UnsupportedOperationException();
                EqExpr eq = (EqExpr) e;
                boolean thenval = ((BooleanLiteral) t).getValue();
                if(thenval)
                    throw new UnsupportedOperationException("not support true in WHEN THEN");
                if(colexpr != null) {
                    if(! colexpr.toQscript().equals(eq.getLhs().toQscript()))
                        throw new UnsupportedOperationException("unmatch column");
                }
                else {
                    colexpr = (ColumnExpr) eq.getLhs();
                }
                inlist.add(eq.getRhs());
            }            
            return new InExpr(colexpr, new Arguments(inlist), true).toQscript();
        }
	}

	public static class Arguments extends Expr
	{
        private final List<Expr> exprs;
        private boolean withCurry;

    	public Arguments() {
            this(new LinkedList<Expr>(), false);
        }

    	public Arguments(List<Expr> exprs) {
            this(exprs, false);
        }

		public Arguments(List<Expr> exprs, boolean withCurry)
		{
			super();
            this.exprs = new ArrayList<SqlExprs.Expr>(exprs);
            this.withCurry = withCurry;
        }

        public void setWithCurry(boolean v) {
            this.withCurry = v;
        }
        
        public List<Expr> getExprs() { return exprs; }

        @Override
        public char getType(TypeContext ctxt) {
            return exprs.size() > 0 ? exprs.get(0).getType(ctxt) : ' '; //return unknown if size == 0
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            for(Expr e : exprs)
                e.collectStringLiteral(result);
        }

        @Override
        public void checkType(TypeContext ctxt) {
            for(Expr e : exprs)
                e.checkType(ctxt);
        }

		@Override
		public String toString()
		{
			StringBuilder s = new StringBuilder();
			s.append("(");
			for(int i = 0; i < exprs.size(); i++)
			{
				if(i > 0)
				{
					s.append(", ");
				}
				s.append(exprs.get(i).toString());
			}
			s.append(")");
			return s.toString();
        }
        
        @Override
        public String toQscript()
		{
            StringBuilder s = new StringBuilder();
            if(withCurry)
                s.append("(");
			for(int i = 0; i < exprs.size(); i++)
			{
				if(i > 0)
				{
					s.append(", ");
				}
				Expr expr = exprs.get(i);
				s.append(expr.toQscript());
			}
            if(withCurry)
                s.append(")");
			return s.toString();
        }
	}

    public static class DistinctExpr extends Expr
    {
        private final Expr expr;

        public DistinctExpr(Expr expr) {
            this.expr = expr;
        }

        @Override
        public char getType(TypeContext ctxt) {
            return expr.getType(ctxt);
        }

        @Override
        public void checkType(TypeContext ctxt) {
            expr.checkType(ctxt);
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            expr.collectStringLiteral(result);
        }

        @Override
        public String toQscript() {
            return "distinct " + expr.toQscript();
        }

        @Override
        public String toString() {
            return toQscript();
        }
    }

    public static class CastExpr extends Expr
    {
        private final Expr expr;
        private final String sqltype;

        public CastExpr(Expr expr, String sqltype) {
            this.expr = expr;
            this.sqltype = sqltype;
        }

        @Override
        public char getType(TypeContext ctxt) {
            if(sqltype.equals("INTEGER"))
                return 'i';
            if(sqltype.equals("DATE"))
                return 'd';
            if(sqltype.equals("TIMESTAMP"))
                return 'p';
            if(sqltype.equals("TEXT"))
                return 'C';
            throw new UnsupportedOperationException("Not support cast type. " + sqltype);
        }

        @Override
        public void checkType(TypeContext ctxt) {
            expr.checkType(ctxt);
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            expr.collectStringLiteral(result);
        }

        @Override
        public String toQscript() {
            if(sqltype.equals("INTEGER"))
                return "(`int$(" + expr.toQscript() + "))";
            else if(sqltype.equals("DATE"))
                return "(`date$(" + expr.toQscript() + "))";
            else if(sqltype.equals("TIMESTAMP"))
                return "(`timestamp$(" + expr.toQscript() + "))";
            else if(sqltype.equals("TEXT"))
                return "string(" + expr.toQscript() + ")";
            else
                throw new UnsupportedOperationException("toQscript doesn't support cast type. " + sqltype);
        }

        @Override
        public String toString() {
            return toQscript();
        }
    }

    public static class ExtractExpr extends Expr
    {
        private final Expr expr;
        private final String field;

        public ExtractExpr(Expr expr, String field) {
            this.expr = expr;
            this.field = field;
        }

        @Override
        public char getType(TypeContext ctxt) {
            return 'i';
        }

            @Override
        public void checkType(TypeContext ctxt) {
            expr.checkType(ctxt);
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            expr.collectStringLiteral(result);
        }

        @Override
        public String toQscript() {
            if(field.equals("YEAR"))
                return "`year$(" + expr.toQscript() + ")";
            if(field.equals("QUARTER"))
                return "`int$floor((2+(`mm$(" + expr.toQscript() + ")))%3)"; //Jan-Mar returns 1, Apr-Jun returns 2, Jul-Sep returns 3, Oct-Dec returns 4
            if(field.equals("MONTH"))
                return "`mm$(" + expr.toQscript() + ")";
            if(field.equals("DAY"))
                return "`dd$(" + expr.toQscript() + ")";
            if(field.equals("HOUR"))
                return "`hh$(" + expr.toQscript() + ")";
            if(field.equals("MINUTE"))
                return "`uu$(" + expr.toQscript() + ")";
            if(field.equals("SECOND"))
                return "`ss$(" + expr.toQscript() + ")";
            throw new UnsupportedOperationException("Not support extract type. " + field);
        }

        @Override
        public String toString() {
            return toQscript();
        }
    }


	public static class FunctionCallExpr extends Expr
	{
		private final String identifiers;
		private final Arguments arguments;
		
		public FunctionCallExpr(String identifiers, Arguments args)
		{
            super();
            if(identifiers == null)
                throw new NullPointerException("identifiers is null");
            if(args == null)
                throw new NullPointerException("args is null");
			this.identifiers = identifiers;
			this.arguments = args;
		}

		public String getIdentifiers()
		{
			return identifiers;
		}

		public Arguments getArguments()
		{
			return arguments;
		}

        @Override
        public char getType(TypeContext ctxt) {
            if(identifiers.toLowerCase().equals("count"))
                return 'i';
            else if(identifiers.toLowerCase().equals("current_date"))
                return 'd';
            else if(identifiers.toLowerCase().equals("date_trunc"))
                return 'p';
            else
                return getArguments().getType(ctxt);
        }

        @Override
        public void checkType(TypeContext ctxt) {
            arguments.checkType(ctxt);
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            arguments.collectStringLiteral(result);
        }


		@Override
		public String toString()
		{
			StringBuilder s = new StringBuilder();
			s.append(identifiers);
			s.append(arguments);
			return s.toString();
		}

		@Override
        public String toQscript()
		{
            String name = this.identifiers.toUpperCase();
            if(name.equals("TRUNC")) {
                return arguments.exprs.get(0).toQscript(); //do nthing
            }
            else if(name.equals("VARIANCE")) {
                return "(" + new FunctionCallExpr("STDDEV", arguments).toQscript() + ") xexp 2";
            }
            else if(name.equals("CURRENT_DATE")) {
                return ".z.D";
            }
            // else if(identifiers.equals("DATE_TRUNC")) {
            //     if(arguments.exprs.get(0).toQscript().equals("`DAY")) {
            //         uncurry(arguments.exprs.get(1))
            //     }
            //     throw new UnsupportedOperationException("DATE_TRUNC is not supported. " + toString());
            // }
            String qfunc;
            if(name.equals("STDDEV"))
                qfunc = "dev";
            else
                qfunc = name.toLowerCase();
			StringBuilder s = new StringBuilder();
            s.append(qfunc);
            s.append(" ");
            s.append(arguments.toQscript());
            return s.toString();
        }
	}
	
	public static abstract class LiteralExpr extends Expr
	{
        @Override
        public final void checkType(TypeContext ctxt) {}
	}

	//@Immutable
	public static final class BooleanLiteral extends LiteralExpr
	{
		private final boolean value;

		public BooleanLiteral(boolean value)
		{
            super();
            this.value = value;
        }

        public boolean getValue() {
            return value;
        }
        
		@Override
		public String toString()
		{
			return String.valueOf(value).toUpperCase();
		}
		
		@Override
		public String toQscript()
		{
            return value ? "0x01" : "0x00";
        }
        
        @Override
        public char getType(TypeContext ctxt) {
            return 'b';
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
        }
	}

	//@Immutable
	public static final class NumberLiteral extends LiteralExpr
	{
		private final String numberString;

		public NumberLiteral(String numberString)
		{
            super();
            if(numberString == null)
                throw new NullPointerException("numberString is null");
			this.numberString = numberString;
        }
        
        public int intValue() {
            return Integer.parseInt(numberString);
        }

		@Override
		public String toString()
		{
			return numberString;
		}
		
		@Override
		public String toQscript()
		{
			return numberString;
        }
        
        @Override
        public char getType(TypeContext ctxt) {
            return 'f';
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
        }
	}

	//@Immutable
	public static final class StringLiteral extends LiteralExpr
	{
        private String string;
        private char type;

		public StringLiteral(String string)
		{
			super();
            this.string = string;
            this.type   = 's';
        }
        
        public void replaceString(String newstr, char newtype) {
            this.string = newstr;
            this.type   = newtype;
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            result.add(this);
        }

		@Override
		public String toString()
		{
            return toQscript();
		}
		
		@Override
		public String toQscript()
		{
            switch(type) {
                case 'p': //fall-through
                case 'n': //fall-through
                case 'd': //fall-through
                    return string;
                case 'c':
                    return "\"" + string + "\"";
                case 'C':
                    if(string.length() <= 1) {
                        return "string \"" + string + "\"";
                    } else {
                        return "\"" + string + "\"";
                    }
                case 'g':
                    return "\"G\"$\"" + string + "\"";
                case 's':
                    return "`" + string;
                default:
                    throw new UnsupportedOperationException("unknown StringLiteral type " + type); 
            }
        }
        
        @Override
        public char getType(TypeContext ctxt) {
            return type;
        }
    }

	//@Immutable
	public static final class DateLiteral extends LiteralExpr
	{
        private final String string;

		public DateLiteral(String string)
		{
			super();
            this.string = string;
        }
        
        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            //do nothing
        }

		@Override
		public String toString()
		{
            return toQscript();
		}
		
		@Override
		public String toQscript()
		{
            return string.replace('-', '.');
        }
        
        @Override
        public char getType(TypeContext ctxt) {
            return 'd';
        }
    }

	//@Immutable
	public static final class IntervalLiteral extends LiteralExpr
	{
        private final String string;

		public IntervalLiteral(String string)
		{
			super();
            this.string = string;
        }
        
        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            //do nothing
        }

		@Override
		public String toString()
		{
            return toQscript();
		}
		
		@Override
		public String toQscript()
		{
            return string.toUpperCase().replaceFirst(" *DAY?", "");
        }
        
        @Override
        public char getType(TypeContext ctxt) {
            return 'j';
        }
    }

	//@Immutable
	public static final class ColumnExpr extends Expr
	{
		@Nullable
		private final String tableName;
		@NotNull
		private final String columnName;

		public ColumnExpr(
				  String tableName
				, String columnName
		)
		{
			super();
			this.tableName  = tableName;
			this.columnName = columnName;
		}

        @Override
        public void checkType(TypeContext ctxt) {
            //do nothing            
        }

        @Override
        public void collectStringLiteral(List<StringLiteral> result) {
            //do nothing
        }

		@Override
		public String toString()
		{
			if(tableName == null)
				return columnName;
			else
				return tableName + "." + columnName;
        }
        
        @Override
        public String toQscript() {
            return columnName;
        }

        @Override
        public char getType(TypeContext ctxt) {
            return ctxt.getType(tableName, columnName);
        }

		public String getTableName()
		{
			return tableName;
		}

		public String getColumnName()
		{
			return columnName;
		}		
	}
	
	// /**
	//  * ColumnExpr = Expr と同一の意味を表すExpr(最適化のために用意されたクラス)
	//  */
	// //@Immutable
	// public static final class ColumnEqualsExpr extends Expr
	// {
	// 	private final String columnName;
	// 	private final Expr valueExpr;
		
	// 	public ColumnEqualsExpr(String columnName, Expr valueExpr)
	// 	{
	// 		super();
	// 		this.columnName = columnName;
	// 		this.valueExpr = valueExpr;
	// 	}

	// 	public String getColumnName()
	// 	{
	// 		return columnName;
	// 	}

	// 	public Expr getValueExpr()
	// 	{
	// 		return valueExpr;
	// 	}
		
	// 	@Override
	// 	public String toString()
	// 	{
	// 		return columnName + " = " + valueExpr;
	// 	}
		
	// 	@Override
	// 	public String toJxpath()
	// 	{
	// 		return columnName + " = " + valueExpr.toJxpath();
	// 	}

	// 	@Override
	// 	public String toJavaExprSrc()
	// 	{
	// 		throw new UnsupportedOperationException(getClass().getSimpleName() +  ".toJavaExprSrc is not supported " + toString());
	// 	}
	// }
}