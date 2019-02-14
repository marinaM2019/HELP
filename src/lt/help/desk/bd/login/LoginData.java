package lt.help.desk.bd.login;

import java.sql.Connection;
import java.sql.SQLException;

public class LoginData {

	public boolean getLoginFromDB(String loginName, String password) throws ClassNotFoundException, SQLException {

		Connection connectToDb = (Connection) JDBCConnection.getConnection();
		if (connectToDb != null) {
			return true;
		}

		return false;
	}

}
