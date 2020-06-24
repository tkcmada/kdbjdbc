package jp.mufg.slf4j;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Date;
import java.util.concurrent.atomic.AtomicReference;

import org.slf4j.Marker;
import org.slf4j.event.Level;

public class FileLogger extends LoggerBase {
	private final String name;
	
	public FileLogger(String name) {
		super();
		if(name == null)
			throw new NullPointerException("name is null");
		this.name = name;
	}

	private void writeLog(String log) {
		System.out.println(log);
		if(writer.get() != null) {
			try {
				writer.get().write(log);
			} catch (IOException e) {
				System.out.println("error writing log. " + e.getMessage());
				e.printStackTrace();
			}
		}
	}
	
	@Override
	protected void log(Level level, String format, Object... args) {
		String msg = String.format(format, args);
		String log = new Date() + " " + name + "[" + level + "] " + msg;
		writeLog(log);
	}

	@Override
	protected void log(Level level, String msg, Throwable t) {
		String log = new Date() + " " + name + "[" + level + "] " + msg;
		writeLog(log);
		if(t != null) {
			writeLog(t.getClass().getName() + " " + t.getMessage());
		}
	}

	@Override
	protected void log(Level level, Marker marker, String format, Object... args) {
		String log = new Date() + " " + name + "[" + level + "] " + marker + " " + String.format(format, args);
		writeLog(log);
	}

	@Override
	protected void log(Level level, Marker marker, String msg, Throwable t) {
		String log = new Date() + " " + name + "[" + level + "] " + marker + " " + msg;
		writeLog(log);
		if(t != null) {
			writeLog(t.getClass().getName() + " " + t.getMessage());
		}

	}
	
	public static org.slf4j.Logger getLogger(Class<?> klass) {
		if(klass == null)
			throw new NullPointerException("klass is null");
		return new FileLogger(klass.getName());
	}

	/**
	 * set log directory and enable file appending.
	 * 
	 * @param logdir
	 */
	public static void setDirectory(File logdir) {
		File logfile = new File(logdir, "log.txt");
		try {
			writer.compareAndSet(null, new FileWriter(logfile, true));
		} catch (IOException e) {
			System.out.println("error opening " + logfile + " " + e.getMessage());
			e.printStackTrace();
		}
	}
	
	private static final AtomicReference<Writer> writer = new AtomicReference<>(null);
}
