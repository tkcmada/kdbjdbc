package jp.mufg.logjdbc;

import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.StringJoiner;

public class Srcgen {
	public static void main(String[] args) {
		srcgen(LogResultSet.class);
	}

	private static void srcgen(Class<?> cls) {
		StringBuilder s = new StringBuilder();
		for(Method m : cls.getMethods()) {
			int n = m.getParameterCount();
			s.append(String.format("public %s %s(%s)", type(m.getReturnType()), m.getName(), args(m)));
			if(m.getExceptionTypes().length > 0) {
				StringJoiner sj = new StringJoiner(", ");
				Arrays.stream(m.getExceptionTypes()).forEach((excls)->sj.add(type(excls)));
				s.append(" throws ");
				s.append(sj.toString());
			}
			s.append("{");
			System.out.println(s.toString());
			System.out.println("logger.info(String.format(\"" + m.getName() + "(" + sn(n) + ")\", " + argnames(n) + "));");
			if(m.getReturnType() != void.class)
				System.out.print("var result = ");
			System.out.println(String.format("target.%s(%s);", m.getName(), argnames(n)));
			if(m.getReturnType() != void.class)
				System.out.print("return result;");
			System.out.println("}");
			System.out.println("");
		}
	}

	private static Object argnames(int n) {
		StringJoiner sj = new StringJoiner(", ");
		for(int i = 0; i < n; i++) {
			sj.add("arg" + i);
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
			sj.add(type(m.getParameterTypes()[i]) + " arg" + i);
		}
		return sj.toString();
	}

	private static String type(Type type) {
		return type.toString();
	}

	private static String type(Class<?> type) {
		return type.getName();
	}
}
