package jp.mufg.logjdbc;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.StringJoiner;

public class Srcgen {
	public static void main(String[] args) throws ClassNotFoundException {
		// srcgen(Class.forName("jp.mufg.logjdbc.LogResultSet"));
		// srcgen(Class.forName("jp.mufg.logjdbc.LogResultSetMetaData"));
		// srcgen(Class.forName("jp.mufg.logjdbc.LogStatement"));
		// srcgen(Class.forName("jp.mufg.logjdbc.LogConnection"));
		srcgen(Class.forName("jp.mufg.logjdbc.LogDatabaseMetaData"));
	}

	private static void srcgen(Class<?> cls) {
		for(Method m : cls.getMethods()) {
            String name = m.getName();
            if(name.equals("notify") || name.equals("notifyAll") || name.equals("wait") || name.equals("getClass") || name.equals("equals") || name.equals("hashCode") || name.equals("toString"))
                continue;
			int n = m.getParameterCount();
			StringBuilder s = new StringBuilder();
            s.append(String.format("public %s %s(%s)", type(m.getGenericReturnType(), true), m.getName(), args(m)));
            s.append(exstmt(m));
			s.append("{");
			System.out.println(s.toString());
            System.out.print("\tlogger.info(\"" + m.getName() + "\"");
            for(int i = 0; i < n; i++) {
                System.out.print(" + \" , \" + arg" + i + " ");
            }
            System.out.println(");");
			if(m.getReturnType() != void.class)
				System.out.print("\t" + type(m.getGenericReturnType()) + " result = ");
			System.out.println(String.format("target.%s(%s);", m.getName(), argnames(m)));
			if(m.getReturnType() != void.class) {
                System.out.println("\tlogger.info(\"" + m.getName() + " result is \" + result);");
                System.out.println("\treturn result;");
            }
			
			System.out.println("}");
			System.out.println("");
		}
    }
    
    private static String exstmt(Method m) {
        if(m.getGenericExceptionTypes().length == 0)
            return "";
        StringBuilder s = new StringBuilder();
        s.append(" throws ");
        for(int i = 0; i < m.getGenericExceptionTypes().length; i++) {
            if(i > 0)
                s.append(", ");
            s.append(type(m.getGenericExceptionTypes()[i]));
        }
        s.append(" ");
        return s.toString();
    }

	private static Object argnames(Method m) {
		StringJoiner sj = new StringJoiner(", ");
		for(int i = 0; i < m.getParameterCount(); i++) {
            sj.add(m.getParameters()[i].getName());
		}
		return sj.toString();
	}

	private static Object sn(int n ) {		
		StringJoiner sj = new StringJoiner(", ");
		for(int i = 0; i < n; i++) {
			sj.add("%s");
		}
		return sj.toString();
	}

	private static Object args(Method m) {
		StringJoiner sj = new StringJoiner(", ");
		for(int i = 0; i < m.getParameterCount(); i++) {
            sj.add(type(m.getGenericParameterTypes()[i]) + " " + m.getParameters()[i].getName());
		}
		return sj.toString();
	}

	private static String type(Class<?> type) {
        if(type.isArray()) {
            return type.getSimpleName();
        }
		return type.getName().replace("java.lang.", "");
	}

    private static String type(Type type) {
        return type(type, false);
    }

	private static String type(Type type, boolean withGenericDeclare) {
        if(type instanceof Class)
            return type((Class<?>)type);
        if(type instanceof ParameterizedType) {
            ParameterizedType ptype = (ParameterizedType)type;
            return ptype.getTypeName();
        }
        if(type instanceof TypeVariable) {
            TypeVariable tvar = (TypeVariable)type;
            if(! withGenericDeclare)
                return type.getTypeName();
            if(tvar.getBounds()[0] == Object.class)
                return "<" + tvar.getTypeName() + "> " + tvar.getTypeName();
            return  "<" + type(tvar.getBounds()[0]) + "> " + tvar.getTypeName();
        }
        return type.getClass().getName() + " " + type.toString();
	}
}
