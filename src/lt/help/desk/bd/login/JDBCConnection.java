package lt.help.desk.bd.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	private static String CLASSFORNAME = "com.mysql.jdbc.Driver";
	private static String HOST = "jdbc:mysql://192.168.115.156/help_desk?autoReconnect=true&useSSL=false";
	private static final String USERNAME = "admin";
	private static final String PASSWORD = "help1111";

	private static Connection conn;

	private JDBCConnection() {
	}

	public static Connection getConnection() {

		if (conn == null) {
			conn = createConnection();
		}

		if (isConnectionClosed()) {
			conn = createConnection();
		}

		return conn;

	}

	private static boolean isConnectionClosed() {
		try {
			return conn.isClosed();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private static Connection createConnection() {

		try {
			Class.forName(CLASSFORNAME);
			return DriverManager.getConnection(HOST, USERNAME, PASSWORD);
		} catch (SQLException | ClassNotFoundException e) {

			throw new RuntimeException(e);
		}
	}
}
