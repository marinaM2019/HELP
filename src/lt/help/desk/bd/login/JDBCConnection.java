package lt.help.desk.bd.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	private static JDBCConnection instance;

	private JDBCConnection() {
	}

	private static String CLASSFORNAME = "com.mysql.jdbc.Driver";
	private static String HOST = "jdbc:mysql://192.168.0.60/help_desk?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "help1111";

	public static Connection getConnection() throws SQLException, ClassNotFoundException {
		if (instance == null) {
			instance = new JDBCConnection();
		}
		Class.forName(CLASSFORNAME);
		Connection connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
		return connection;

	}
}
