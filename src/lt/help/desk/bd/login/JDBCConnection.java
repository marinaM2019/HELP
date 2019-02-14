package lt.help.desk.bd.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnection {

	private Connection con;
	
	private Connection getInst() {
		if (con == null) {
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
	 

	public Connection getConnection() {
		return getInst();
	}
}
