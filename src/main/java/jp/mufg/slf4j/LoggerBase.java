package jp.mufg.slf4j;

import org.slf4j.Logger;
import org.slf4j.Marker;
import org.slf4j.event.Level;

public abstract class LoggerBase implements Logger {
	protected abstract void log(Level level, String msg);
	protected abstract void log(Level level, String format, Object...args);
	protected abstract void log(Level level, String msg, Throwable t);
	protected abstract void log(Level info, Marker marker, String msg);
	protected abstract void log(Level info, Marker marker, String format, Object... arguments);
	protected abstract void log(Level info, Marker marker, String msg, Throwable t);

	@Override
	public String getName() {
		throw new UnsupportedOperationException("LoggerBase.getName is not supported");
	}

	@Override
	public boolean isTraceEnabled() {
		throw new UnsupportedOperationException("LoggerBase.isTraceEnabled is not supported");
	}

	@Override
	public void trace(String msg) {
		throw new UnsupportedOperationException("LoggerBase.trace is not supported");
	}

	@Override
	public void trace(String format, Object arg) {
		throw new UnsupportedOperationException("LoggerBase.trace is not supported");
	}

	@Override
	public void trace(String format, Object arg1, Object arg2) {
		throw new UnsupportedOperationException("LoggerBase.trace is not supported");
	}

	@Override
	public void trace(String format, Object... arguments) {
		throw new UnsupportedOperationException("LoggerBase.trace is not supported");
	}

	@Override
	public void trace(String msg, Throwable t) {
		throw new UnsupportedOperationException("LoggerBase.trace is not supported");
	}

	@Override
	public boolean isTraceEnabled(Marker marker) {
		throw new UnsupportedOperationException("LoggerBase.isTraceEnabled is not supported");
	}

	@Override
	public void trace(Marker marker, String msg) {
		throw new UnsupportedOperationException("LoggerBase.trace is not supported");
	}

	@Override
	public void trace(Marker marker, String format, Object arg) {
		throw new UnsupportedOperationException("LoggerBase.trace is not supported");
	}

	@Override
	public void trace(Marker marker, String format, Object arg1, Object arg2) {
		throw new UnsupportedOperationException("LoggerBase.trace is not supported");
	}

	@Override
	public void trace(Marker marker, String format, Object... argArray) {
		throw new UnsupportedOperationException("LoggerBase.trace is not supported");
	}

	@Override
	public void trace(Marker marker, String msg, Throwable t) {
		throw new UnsupportedOperationException("LoggerBase.trace is not supported");
	}

	@Override
	public boolean isDebugEnabled() {
		throw new UnsupportedOperationException("LoggerBase.isDebugEnabled is not supported");
	}

	@Override
	public void debug(String msg) {
		throw new UnsupportedOperationException("LoggerBase.debug is not supported");
	}

	@Override
	public void debug(String format, Object arg) {
		throw new UnsupportedOperationException("LoggerBase.debug is not supported");
	}

	@Override
	public void debug(String format, Object arg1, Object arg2) {
		throw new UnsupportedOperationException("LoggerBase.debug is not supported");
	}

	@Override
	public void debug(String format, Object... arguments) {
		throw new UnsupportedOperationException("LoggerBase.debug is not supported");
	}

	@Override
	public void debug(String msg, Throwable t) {
		throw new UnsupportedOperationException("LoggerBase.debug is not supported");
	}

	@Override
	public boolean isDebugEnabled(Marker marker) {
		throw new UnsupportedOperationException("LoggerBase.isDebugEnabled is not supported");
	}

	@Override
	public void debug(Marker marker, String msg) {
		throw new UnsupportedOperationException("LoggerBase.debug is not supported");
	}

	@Override
	public void debug(Marker marker, String format, Object arg) {
		throw new UnsupportedOperationException("LoggerBase.debug is not supported");
	}

	@Override
	public void debug(Marker marker, String format, Object arg1, Object arg2) {
		throw new UnsupportedOperationException("LoggerBase.debug is not supported");
	}

	@Override
	public void debug(Marker marker, String format, Object... arguments) {
		throw new UnsupportedOperationException("LoggerBase.debug is not supported");
	}

	@Override
	public void debug(Marker marker, String msg, Throwable t) {
		throw new UnsupportedOperationException("LoggerBase.debug is not supported");
	}

	@Override
	public boolean isInfoEnabled() {
		return true;
	}

	@Override
	public void info(String msg) {
		log(Level.INFO, msg);
	}

	@Override
	public void info(String format, Object arg) {
		log(Level.INFO, format, arg);
	}

	@Override
	public void info(String format, Object arg1, Object arg2) {
		log(Level.INFO, format, arg1, arg2);
	}

	@Override
	public void info(String format, Object... arguments) {
		log(Level.INFO, format, arguments);
	}

	@Override
	public void info(String msg, Throwable t) {
		log(Level.INFO, msg, t);
	}

	@Override
	public boolean isInfoEnabled(Marker marker) {
		return true;
	}

	@Override
	public void info(Marker marker, String msg) {
		log(Level.INFO, marker, msg);
	}

	@Override
	public void info(Marker marker, String format, Object arg) {
		log(Level.INFO, marker, format, arg);
	}

	@Override
	public void info(Marker marker, String format, Object arg1, Object arg2) {
		log(Level.INFO, marker, format, arg1, arg2);
	}

	@Override
	public void info(Marker marker, String format, Object... arguments) {
		log(Level.INFO, marker, format, arguments);
	}

	@Override
	public void info(Marker marker, String msg, Throwable t) {
		log(Level.INFO, marker, msg, t);
	}

	@Override
	public boolean isWarnEnabled() {
		throw new UnsupportedOperationException("LoggerBase.isWarnEnabled is not supported");
	}

	@Override
	public void warn(String msg) {
		throw new UnsupportedOperationException("LoggerBase.warn is not supported");
	}

	@Override
	public void warn(String format, Object arg) {
		throw new UnsupportedOperationException("LoggerBase.warn is not supported");
	}

	@Override
	public void warn(String format, Object... arguments) {
		throw new UnsupportedOperationException("LoggerBase.warn is not supported");
	}

	@Override
	public void warn(String format, Object arg1, Object arg2) {
		throw new UnsupportedOperationException("LoggerBase.warn is not supported");
	}

	@Override
	public void warn(String msg, Throwable t) {
		throw new UnsupportedOperationException("LoggerBase.warn is not supported");
	}

	@Override
	public boolean isWarnEnabled(Marker marker) {
		throw new UnsupportedOperationException("LoggerBase.isWarnEnabled is not supported");
	}

	@Override
	public void warn(Marker marker, String msg) {
		throw new UnsupportedOperationException("LoggerBase.warn is not supported");
	}

	@Override
	public void warn(Marker marker, String format, Object arg) {
		throw new UnsupportedOperationException("LoggerBase.warn is not supported");
	}

	@Override
	public void warn(Marker marker, String format, Object arg1, Object arg2) {
		throw new UnsupportedOperationException("LoggerBase.warn is not supported");
	}

	@Override
	public void warn(Marker marker, String format, Object... arguments) {
		throw new UnsupportedOperationException("LoggerBase.warn is not supported");
	}

	@Override
	public void warn(Marker marker, String msg, Throwable t) {
		throw new UnsupportedOperationException("LoggerBase.warn is not supported");
	}

	@Override
	public boolean isErrorEnabled() {
		throw new UnsupportedOperationException("LoggerBase.isErrorEnabled is not supported");
	}

	@Override
	public void error(String msg) {
		throw new UnsupportedOperationException("LoggerBase.error is not supported");
	}

	@Override
	public void error(String format, Object arg) {
		throw new UnsupportedOperationException("LoggerBase.error is not supported");
	}

	@Override
	public void error(String format, Object arg1, Object arg2) {
		throw new UnsupportedOperationException("LoggerBase.error is not supported");
	}

	@Override
	public void error(String format, Object... arguments) {
		throw new UnsupportedOperationException("LoggerBase.error is not supported");
	}

	@Override
	public void error(String msg, Throwable t) {
		throw new UnsupportedOperationException("LoggerBase.error is not supported");
	}

	@Override
	public boolean isErrorEnabled(Marker marker) {
		throw new UnsupportedOperationException("LoggerBase.isErrorEnabled is not supported");
	}

	@Override
	public void error(Marker marker, String msg) {
		throw new UnsupportedOperationException("LoggerBase.error is not supported");
	}

	@Override
	public void error(Marker marker, String format, Object arg) {
		throw new UnsupportedOperationException("LoggerBase.error is not supported");
	}

	@Override
	public void error(Marker marker, String format, Object arg1, Object arg2) {
		throw new UnsupportedOperationException("LoggerBase.error is not supported");
	}

	@Override
	public void error(Marker marker, String format, Object... arguments) {
		throw new UnsupportedOperationException("LoggerBase.error is not supported");
	}

	@Override
	public void error(Marker marker, String msg, Throwable t) {
		throw new UnsupportedOperationException("LoggerBase.error is not supported");
	}
}
