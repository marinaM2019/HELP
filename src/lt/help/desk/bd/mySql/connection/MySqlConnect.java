package lt.help.desk.bd.mySql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;

public class MySqlConnect {
	
	
	private static final String DB_DRIVER_CLASS_NAME = "driver_class_name";
	private static final String DB_USERNAME = "username";
	private static final String DB_PASSWORD = "password";
	private static final String DB_URL = "url";
	private static Properties properties = null;
	
	private static Connection con;

	private MySqlConnect() {}

	public static Connection getConnection() {

		
		if (con == null ) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String host = "jdbc:mysql://192.168.0.60/help_desk?autoReconnect=true&useSSL=false";
				String username = "admin";
				String password = "help1111";
				con = DriverManager.getConnection(host, username, password);
			} catch (SQLException | ClassNotFoundException ex) {
				throw new RuntimeException();
			}
		}

		return con;
	}
}
