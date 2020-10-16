package helloWorld.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Mysql connection util
 * 
 * @author htv-banghhk
 *
 */
public class ConnectionUtils {

	// singleton load propfile config
	private static final String DB_CONFIG = "jdbcLocal.properties";
	private static ConnectionUtils instance = null;
	private Properties properties = new Properties();

	private ConnectionUtils() {
	}

	public String getProperty(String key) {
		return this.properties.getProperty(key);
	}

	public static ConnectionUtils getInstance() {
		if (instance == null) {
			instance = new ConnectionUtils();
			instance.getDBProp();
		}
		return instance;
	}

	public Properties getDBProp() {
		InputStream input = null;
		URL pathToConfig = ClassLoader.getSystemResource(ConnectionUtils.DB_CONFIG);
		try {
			input = new FileInputStream(pathToConfig.getPath());
			// load properties
			this.properties.load(input);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return this.properties;
	}

	/**
	 * connect to mysql database
	 * 
	 * @return java.sql.Connection
	 */
	public Connection getConnection() {
		ConnectionUtils util = ConnectionUtils.getInstance();
		Connection conn = null;
		try {
			Class.forName(util.getProperty("jdbc.driver"));
			conn = DriverManager.getConnection(util.getProperty("jdbc.url"), util.getProperty("jdbc.user"),
					util.getProperty("jdbc.password"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * kill connection silently
	 */
	public void silentKillConnection(Connection conn) {
		try {
			conn.close();
		} catch (SQLException e) {
		}
	}
}
