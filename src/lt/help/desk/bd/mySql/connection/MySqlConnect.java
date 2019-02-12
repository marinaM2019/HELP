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

	private static MySqlConnect dbIsntance;
	private static Connection con;

	private MySqlConnect() {
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		if (con == null && (dbIsntance == null)) {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				String host = "jdbc:mysql://192.168.115.156/help_desk?autoReconnect=true&useSSL=false";
				String username = "admin";
				String password = "help1111";
				con = DriverManager.getConnection(host, username, password);
			} catch (SQLException ex) {
				throw new RuntimeException();
			}
		}

		return con;
	}
}
