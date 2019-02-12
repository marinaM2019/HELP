package login;

import java.sql.Connection;

//import java.util.ArrayList;
//import java.util.List;

import mySql.connection.MySqlConnect;

public class LoginData {

	public boolean getLoginFromDB(String loginName, String password) {
		try {
			Connection connectToDb = MySqlConnect.getInstance().getConnection();
			if (connectToDb != null) {
				return true;
			}
		} catch (Exception e) {
			System.out.println("Klaida: " + e);
		}
		return false;
	}

}
