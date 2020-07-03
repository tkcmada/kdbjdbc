package jp.mufg.sqlutil;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.swing.text.DateFormatter;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;
import org.apache.commons.lang3.StringUtils;

import jp.mufg.kdbjdbc.KdbUtil;

public class SqlExprs {
	// public static class Tables
	// {
    //     private final List<Table> tables = new ArrayList<SqlExprs.Table>();
        		
	// 	public void add(Table t)
	// 	{
	// 		tables.add(t);
	// 	}
		
	// 	public List<Table> getTables()
	// 	{
	// 		return Collections.unmodifiableList(tables);
	// 	}
		
	// 	@Override
	// 	public String toString()
	// 	{
	// 		return StringUtils.join(tables, ' ');
	// 	}
    // }
    
	public static class Table
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

		public Table(@NotNull String tableName, @Nullable String aliasName)
		{
            super();
            if(tableName == null)
                throw new NullPointerException("tableName is null");
			this.tableName = tableName;
			this.aliasName = aliasName;
		}
		
		public String getTableName()
		{
			return tableName;
		}

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
    
    public static class ColumnExprWithAlias {
        @NotNull
        public final Expr expr;
        @Nullable
        private final String aliasName;

        public ColumnExprWithAlias(@NotNull Expr expr, @Nullable String aliasName) {
            if(expr == null)
                throw new NullPointerException("expr is null");
            this.expr = expr;
            this.aliasName = aliasName;
        }

        public boolean isAliasSpecified() {
            return aliasName != null;
        }

        public String getAliasName() {
            if(aliasName != null)
                return aliasName;
            if(expr instanceof ColumnExpr) {
                return ((ColumnExpr)expr).columnName;
            }
            return expr.toString();
        }
    }
	
	public static abstract class Expr
	{
		// /**
		//  * SQL表現をJXPath表現に変換する
		//  * 
		//  * @return jxpath
		//  */
		// public abstract String toJxpath();
		// /**
		//  * SQL表現をJava式のソースコードに変換する
		//  */
		// public abstract String toJavaExprSrc();
		/**
		 * SQL表現をq-scriptのソースコードに変換する
		 */
        public abstract String toQscript();
        
        public abstract char getType(TypeContext ctxt);

        public void checkType(TypeContext ctxt) {}

        public void collectStringExpr(List<StringExpr> result) {}
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
            Character typeobj = type_by_col.get(columnName);
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

		public Expr getExpr()
		{
			return expr;
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
        public char getType(TypeContext ctxt) {
            if(op.equals("<=") || op.equals(">=") || op.equals("<") || op.equals(">") || op.equals("=") || op.equals("!=") || op.equals("in") || op.equals("and") || op.equals("or"))
                return 'b'; //boolean
            //+ - * /
            return lhs.getType(ctxt); //TODO
        }

		@Override
		public String toString()
		{
			return lhs + " " + op + " " + rhs;
		}
		
		@Override
		public String toQscript()
		{
            return toString();
        }
    }
    
    public static class EqExpr extends BinaryExpr {
        public EqExpr(String op, Expr lhs, Expr rhs) {
            super(op, lhs, rhs);
        }

        @Override
        public void checkType(TypeContext ctxt) {
            List<StringExpr> strs = new LinkedList<SqlExprs.StringExpr>();
            rhs.collectStringExpr(strs);
            fixStringType(strs, lhs.getType(ctxt));
        }
    }

    private static void fixStringType(List<StringExpr> strs, char targetType) {
        for(StringExpr se : strs) {
            String s = se.string;
            switch(targetType) {
                // case 's':
                //     this.rhs = new SymbolLiteral(s);
                case 'd':
                    se.replacePlainString(s.replace("-", "."), 'd');
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
            List<StringExpr> strs = new LinkedList<SqlExprs.StringExpr>();
            arguments.collectStringExpr(strs);
            fixStringType(strs, lhs.getType(ctxt));
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
			this.whenExpr = whenExpr;
			this.thenExpr = thenExpr;
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
			this.elseExpr = elseExpr;
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
        public String toQscript() {
            //assuming all when expression is ColExpr = <expr> and THEN is false and ELSE is true 
            List<Expr> inlist = new LinkedList<SqlExprs.Expr>();
            ColumnExpr colexpr = null;
            for(WhenThen wt : whenThens) {
                Expr e = wt.whenExpr;
                if(e instanceof CurryExpr)
                    e = ((CurryExpr) e).expr;
                EqExpr eq = (EqExpr) e;
                boolean thenval = ((BooleanLiteral)wt.thenExpr).getValue();
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
            if(! ((BooleanLiteral)elseExpr).getValue())
                throw new UnsupportedOperationException("else should be TRUE");
            return new InExpr(colexpr, new Arguments(inlist), true).toQscript();
        }
	}

	public static class Arguments extends Expr
	{
        private final List<Expr> exprs;
        private boolean withCurry;

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
        public void collectStringExpr(List<StringExpr> result) {
            for(Expr e : exprs)
                e.collectStringExpr(result);
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
            if(identifiers.equals("count"))
                return 'i';
            else
                return getArguments().getType(ctxt);
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
            String qfunc = identifiers.toLowerCase(); //TODO
			StringBuilder s = new StringBuilder();
            s.append(qfunc);
            s.append(" ");
            s.append(arguments.toQscript());
            return s.toString();
        }
	}
	
	public static abstract class LiteralExpr extends Expr
	{
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
			return String.valueOf(value);
        }
        
        @Override
        public char getType(TypeContext ctxt) {
            return 'b';
        }
	}

	//@Immutable
	public static final class NumberExpr extends LiteralExpr
	{
		private final String numberString;

		public NumberExpr(String numberString)
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
	}

	//@Immutable
	public static final class StringExpr extends Expr
	{
        private final String string;
        private String replacedPlainString;
        private char replacedType;

		public StringExpr(String string)
		{
			super();
			this.string = string;
        }
        
        public void replacePlainString(String newstr, char newtype) {
            this.replacedPlainString = newstr;
            this.replacedType = newtype;
        }

        @Override
        public void collectStringExpr(List<StringExpr> result) {
            result.add(this);
        }

		@Override
		public String toString()
		{
            if(replacedPlainString != null)
                return replacedPlainString; //no quote required
			return "'" + string + "'";
		}
		
		@Override
		public String toQscript()
		{
            if(replacedPlainString != null)
                return replacedPlainString; //no quote required
			return "`" + string;
        }
        
        @Override
        public char getType(TypeContext ctxt) {
            if(replacedPlainString != null)
                return replacedType;
            return 's'; //list of char
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
		
		// @Override
		// public String toJxpath()
		// {
		// 	if(tableName == null)
		// 		return "$" + columnName;
		// 	else
		// 		return "$" + tableName + "/" + columnName;
		// }

		// @Override
		// public String toJavaExprSrc()
		// {
		// 	//checkNotNull(tableName, "tableName is null. columnName=" + String.valueOf(columnName));
		// 	String tblvar = tableName.toLowerCase();
		// 	return "(" + tblvar + " == null ? null : " + tblvar + ".get" + columnName + "())";
		// }
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