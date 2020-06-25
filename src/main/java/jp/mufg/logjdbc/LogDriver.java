package jp.mufg.logjdbc;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

import jp.mufg.slf4j.FileLogger;

public class LogDriver implements java.sql.Driver {
	private static final org.slf4j.Logger logger = FileLogger.getLogger(LogDriver.class);
	private static final String URL_PREFIX = "jdbc:log:"; //jdbc:log:jdbc:mysql:.....

    static {
        logger.info("registering LogDriver...");
        try {
            java.sql.DriverManager.registerDriver(new LogDriver());
        } catch (SQLException ex) {
            throw new RuntimeException("Can't register LogDriver!", ex);
        }
    }

	private String newUrl(String url) {
		return url.replace("jdbc:log:", "").replaceFirst("[\\?\\&]logdir=.+", "");
	}
	
	@Override
	public Connection connect(String orgurl, Properties info) throws SQLException {
        if (! orgurl.startsWith(URL_PREFIX))
            return null;
		String url = newUrl(orgurl);
		String logdir = (String) info.get("logdir");
		if (logdir != null) {
			FileLogger.setDirectory(new File(logdir));
			info = (Properties) info.clone();
			info.remove("logdir");
        }
        logger.info("original url is " + orgurl);
        logger.info("connect " + url + " " + String.valueOf(info));
		return new LogConnection(DriverManager.getConnection(url, info));
	}

	@Override
	public boolean acceptsURL(String url) throws SQLException {
		logger.info("acceptsURL " + url);
		return url.startsWith(URL_PREFIX);
	}

	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		logger.info("getPropertyInfo " + url + " " + info);
		throw new UnsupportedOperationException("getPropertyInfo is not supported");
	}

	@Override
	public int getMajorVersion() {
		logger.info("getMajorVersion");
		return 1;
	}

	@Override
	public int getMinorVersion() {
		logger.info("getMinorVersion");
		return 0;
	}

	@Override
	public boolean jdbcCompliant() {
		logger.info("jdbcCompliant");
		return true;
	}

	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		logger.info("getParentLogger");
		throw new SQLFeatureNotSupportedException("getParentLogger is not supported");
	}
}
