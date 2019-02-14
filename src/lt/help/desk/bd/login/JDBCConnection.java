package lt.help.desk.bd.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	private Connection con;

	private static String CLASSFORNAME = "com.mysql.jdbc.Driver";
	private static String HOST = "jdbc:mysql://localhost:3306/testdb";
	private static String USERNAME = "admin";
	private static String PASSWORD = "help1111";

	public Connection getConnection() {
		if (con == null) {
			try {
				Class.forName(CLASSFORNAME);
				con = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
			} catch (SQLException | ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

		return con;
	}
}
