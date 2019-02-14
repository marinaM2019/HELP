package lt.help.desk.bd.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;
import org.apache.commons.io.FileUtils;


public class MySqlConnect {
	
	
//	private final String DB_DRIVER_CLASS_NAME = "driver_class_name";
//	private final String DB_USERNAME = "username";
//	private final String DB_PASSWORD = "password";
//	private final String DB_URL = "url";
//	private Properties properties = null;
	
	private Connection con;

	public Connection getConnection() {
		if (con == null ) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String host = "jdbc:mysql://192.168.115.156/help_desk?autoReconnect=true&useSSL=false";
				String username = "admin";
				String password = "help1111";
				con = DriverManager.getConnection(host, username, password);
			} catch (SQLException | ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

		return con;
	}
}
