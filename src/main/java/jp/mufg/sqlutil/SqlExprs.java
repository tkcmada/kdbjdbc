package jp.mufg.sqlutil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.misc.Nullable;
import org.apache.commons.lang3.StringUtils;

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
			//checkNotNull(tableName, "tableName is null");
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
        public final String aliasName;

        public ColumnExprWithAlias(@NotNull Expr expr, @Nullable String aliasName) {
            this.expr = expr;
            this.aliasName = aliasName;
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
	}
	
	public static class BranketExpr extends Expr //カッコを出力するためにわざわざクラスを作成
	{
		private final Expr expr;

		public BranketExpr(Expr expr)
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
        


		public Expr getExpr()
		{
			return expr;
		}

		// @Override
		// public String toJxpath()
		// {
		// 	return "(" + expr.toJxpath() + ")";
		// }
		
		// @Override
		// public String toJavaExprSrc()
		// {
		// 	throw new UnsupportedOperationException(getClass().getSimpleName() +  ".toJavaExprSrc is not supported " + toString());
		// }
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
		private final String op;
		private final Expr lhs, rhs;

		public BinaryExpr(String op, Expr lhs, Expr rhs)
		{
			super();
			this.lhs = lhs;
			this.rhs = rhs;
			this.op  = op;
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
		public String toString()
		{
			return lhs + " " + op + " " + rhs;
		}
		
		@Override
		public String toQscript()
		{
            return toString();
        }
		
		// @Override
		// public String toJxpath()
		// {
		// 	return lhs.toJxpath() + " " + op + " " + rhs.toJxpath();
		// }
		
		// @Override
		// public String toJavaExprSrc()
		// {
		// 	if(op.equals("="))
		// 	{
		// 		return "TypeSafeSqlFunctions.eq(" + lhs.toJavaExprSrc() + ", " + rhs.toJavaExprSrc() + ")";
		// 	}
		// 	else
		// 	{
		// 		String javaop = op;
		// 		if(op.equals("and")) javaop = "&&";
		// 		if(op.equals("or"))  javaop = "||";
		// 		return lhs.toJavaExprSrc() + " " + javaop + " " + rhs.toJavaExprSrc();
		// 	}
		// }
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

	// public static class InExpr extends Expr
	// {
	// 	private final Expr lhs;
	// 	private final Arguments arguments;
	// 	private final boolean not;

	// 	public InExpr(Expr lhs, Arguments arguments, boolean not)
	// 	{
	// 		super();
	// 		this.lhs = lhs;
	// 		this.arguments = arguments;
	// 		this.not = not;
	// 	}
		
	// 	public Expr getLhs()
	// 	{
	// 		return lhs;
	// 	}

	// 	public Arguments getArguments()
	// 	{
	// 		return arguments;
	// 	}

	// 	public boolean isNot()
	// 	{
	// 		return not;
	// 	}

	// 	@Override
	// 	public String toString()
	// 	{
	// 		return lhs + (not ? " NOT IN " : " IN ") + arguments;
	// 	}
		
	// 	@Override
	// 	public String toJxpath()
	// 	{
	// 		//INをORで書き換える
	// 		final StringBuilder s = new StringBuilder();
	// 		for(Expr arg : arguments.exprs)
	// 		{
	// 			if(s.length() > 0)
	// 			{
	// 				if(not)
	// 					s.append(" and ");
	// 				else
	// 					s.append(" or ");
	// 			}
	// 			s.append("(");
	// 			s.append(lhs.toJxpath());
	// 			if(not)
	// 				s.append(" != ");
	// 			else
	// 				s.append(" = ");
	// 			s.append(arg.toJxpath());
	// 			s.append(")");
	// 		}
	// 		return s.toString();
	// 	}
		
	// 	@Override
	// 	public String toJavaExprSrc()
	// 	{
	// 		//INをORで置き換える
	// 		//INをORで書き換える
	// 		final StringBuilder s = new StringBuilder();
	// 		for(Expr arg : arguments.exprs)
	// 		{
	// 			if(s.length() > 0)
	// 			{
	// 				if(not)
	// 					s.append(" && ");
	// 				else
	// 					s.append(" || ");
	// 			}
	// 			if(not)
	// 			{
	// 				s.append("!");
	// 			}
	// 			s.append(TypeSafeSqlFunctions.class.getName() + ".eq(");
	// 			s.append(lhs.toJavaExprSrc());
	// 			s.append(", ");
	// 			s.append(arg.toJavaExprSrc());
	// 			s.append(")");
	// 		}
	// 		return s.toString();
	// 	}
	// }

	// public static class WhenThen
	// {
	// 	private final Expr whenExpr;
	// 	private final Expr thenExpr;
		
	// 	public WhenThen(Expr whenExpr, Expr thenExpr)
	// 	{
	// 		super();
	// 		this.whenExpr = whenExpr;
	// 		this.thenExpr = thenExpr;
	// 	}
		
	// 	public Expr getWhenExpr()
	// 	{
	// 		return whenExpr;
	// 	}
		
	// 	public Expr getThenExpr()
	// 	{
	// 		return thenExpr;
	// 	}
		
	// 	@Override
	// 	public String toString()
	// 	{
	// 		return "WHEN " + whenExpr + " THEN " + thenExpr;
	// 	}
	// }
	
	// public static class CaseExpr extends Expr
	// {
	// 	private final List<WhenThen> whenThens;
	// 	//@Nullable 
	// 	private final Expr elseExpr;
	// 	//@Nullable 
	// 	private final Expr baseExpr;
		
	// 	public CaseExpr(
	// 			//@Nullable Expr baseExpr
	// 			, List<WhenThen> whenThens
	// 			, //@Nullable Expr elseExpr
	// 	)
	// 	{
	// 		super();
	// 		this.baseExpr = baseExpr;
	// 		this.whenThens = whenThens;
	// 		this.elseExpr = elseExpr;
	// 	}
		
	// 	public List<WhenThen> getWhenThens()
	// 	{
	// 		return Collections.unmodifiableList(whenThens);
	// 	}

	// 	//@Nullable
	// 	public Expr getBaseExpr()
	// 	{
	// 		return baseExpr;
	// 	}

	// 	//@Nullable 
	// 	public Expr getElseExpr()
	// 	{
	// 		return elseExpr;
	// 	}

	// 	@Override
	// 	public String toString()
	// 	{
	// 		StringBuilder s = new StringBuilder();
	// 		s.append("CASE");
	// 		if(baseExpr != null)
	// 		{
	// 			s.append(" ");
	// 			s.append(baseExpr);
	// 		}
	// 		for(WhenThen wt : whenThens)
	// 		{
	// 			s.append(" ");
	// 			s.append(wt.toString());
	// 		}
	// 		if(elseExpr != null)
	// 		{
	// 			s.append(" ELSE ");
	// 			s.append(elseExpr);
	// 		}
	// 		s.append(" END");
	// 		return s.toString();
	// 	}
		
	// 	@Override
	// 	public String toJxpath()
	// 	{
	// 		//非効率だがCASEをcom.mumss.feit.common.jxpath.LibJx.iifで書き換える
	// 		StringBuilder s = new StringBuilder();
	// 		StringBuilder post = new StringBuilder();
	// 		for(WhenThen wt : whenThens)
	// 		{
	// 			s.append("com.mumss.feit.common.jxpath.LibJx.iif(");
	// 			if(baseExpr != null)
	// 			{
	// 				s.append(baseExpr.toJxpath());
	// 				s.append(" = ");
	// 				s.append(wt.whenExpr.toJxpath());
	// 			}
	// 			else
	// 			{
	// 				s.append(wt.whenExpr.toJxpath());
	// 			}
	// 			s.append(", ");
	// 			s.append(wt.thenExpr.toJxpath());
	// 			s.append(", ");
	// 			post.append(")");
	// 		}
	// 		if(elseExpr != null)
	// 		{
	// 			s.append(elseExpr.toJxpath());
	// 		}
	// 		else
	// 		{
	// 			s.append("com.mumss.feit.common.jxpath.LibJx.NULL");
	// 		}
	// 		s.append(post.toString());
	// 		return s.toString();
	// 	}
		
	// 	@Override
	// 	public String toJavaExprSrc()
	// 	{
	// 		//CASEを三項演算子で書き換える
	// 		StringBuilder s = new StringBuilder();
	// 		StringBuilder post = new StringBuilder();
	// 		s.append("(");
	// 		for(WhenThen wt : whenThens)
	// 		{
	// 			s.append("(");
	// 			if(baseExpr != null)
	// 			{
	// 				s.append(TypeSafeSqlFunctions.class.getName() + ".eq(");
	// 				s.append(baseExpr.toJavaExprSrc());
	// 				s.append(", ");
	// 				s.append(wt.whenExpr.toJavaExprSrc());
	// 				s.append(")");
	// 			}
	// 			else
	// 			{
	// 				s.append(wt.whenExpr.toJavaExprSrc());
	// 			}
	// 			s.append(" ? ");
	// 			s.append(wt.thenExpr.toJavaExprSrc());
	// 			s.append(" : ");
	// 			post.append(")");
	// 		}
	// 		if(elseExpr != null)
	// 		{
	// 			s.append(elseExpr.toJavaExprSrc());
	// 		}
	// 		else
	// 		{
	// 			s.append("null");
	// 		}
	// 		s.append(post.toString());
	// 		s.append(")");
	// 		return s.toString();
	// 	}
	// }

	public static class Arguments
	{
		private final List<Expr> exprs;

		public Arguments(List<Expr> exprs)
		{
			super();
            this.exprs = new ArrayList<SqlExprs.Expr>(exprs);
        }
        
        public List<Expr> getExprs() { return exprs; }
		
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
        
        public String toQscript()
		{
			StringBuilder s = new StringBuilder();
			for(int i = 0; i < exprs.size(); i++)
			{
				if(i > 0)
				{
					s.append(", ");
				}
				Expr expr = exprs.get(i);
				s.append(expr.toQscript());
			}
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
	}

	//@Immutable
	public static final class StringExpr extends Expr
	{
		private final String string;

		public StringExpr(String string)
		{
			super();
			this.string = string;
		}

		@Override
		public String toString()
		{
			return "'" + string + "'";
		}
		
		@Override
		public String toQscript()
		{
			return toString();
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