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

	private static synchronized void writeLog(String log) {
		System.out.println(log);
		if(writer.get() != null) {
			try {
                writer.get().write(log);
                writer.get().write("\r\n");
                writer.get().flush();
			} catch (IOException e) {
				System.out.println("error writing log. " + e.getMessage());
				e.printStackTrace();
            }
        }
	}
	
	@Override
	protected void log(Level level, String format, Object... args) {
        log(level, format);
	}

	@Override
	protected void log(Level level, String msg) {
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
        log(level, marker, format);
	}

	@Override
	protected void log(Level level, Marker marker, String msg) {
		String log = new Date() + " " + name + "[" + level + "] " + marker + " " + msg;
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
        if (writer.get() != null)
            return;
        System.out.println("setting logdir " + logdir);
		File logfile = new File(logdir, "log.txt");
		try {
            FileWriter w = new FileWriter(logfile, false); //no append
            if ( ! writer.compareAndSet(null, w) ) {
                w.close();
            }
            else
            {
               writeLog(new Date().toString() + " starting logging " + logfile + " v1.4\r\n");
            }
 		} catch (IOException e) {
			System.out.println("error opening " + logfile + " " + e.getMessage());
			e.printStackTrace();
		}
	}
	
    private static final AtomicReference<Writer> writer = new AtomicReference<Writer>(null);
}
