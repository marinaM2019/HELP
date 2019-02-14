package lt.help.desk.bd.login;

import java.sql.Connection;

public class LoginData extends JDBCConnection {

	public boolean getLoginFromDB(String loginName, String password) {

		Connection connectToDb = (Connection) getConnection();
		if (connectToDb != null) {
			return true;
		}

		return false;
	}

}
