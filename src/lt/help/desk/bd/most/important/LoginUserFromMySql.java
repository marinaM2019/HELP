package lt.help.desk.bd.most.important;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import lt.help.desk.bd.beans.LoginUserAtribute;
import lt.help.desk.bd.klasifikatoriai.Vaidmenys;
import lt.help.desk.bd.login.JDBCConnection;

public class LoginUserFromMySql {

	public boolean getLogin(String loginName, String loginPassword, Vaidmenys vaidmuo) {

		try {
			Connection connection = (Connection) JDBCConnection.getConnection();
			String sql = "SELECT login_name, passw FROM help_desk.users WHERE login_name='" + loginName
					+ "' AND passw='" + loginPassword + "' AND vaidmuo='" + vaidmuo + "'";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return false;
	}

	public boolean getSuperAdminLogin(String loginName, String loginPassword) {
		return getLogin(loginName, loginPassword, Vaidmenys.superAdmin);
	}

	public boolean getBossConnection(String loginName, String loginPassword) {
		return getLogin(loginName, loginPassword, Vaidmenys.vadovas_it);
	}

	public boolean getLocalAdminConnection(String loginName, String loginPassword) {
		return getLogin(loginName, loginPassword, Vaidmenys.darbuotojas_it);
	}

	public boolean getUserConnection(String loginName, String loginPassword) {
		return getLogin(loginName, loginPassword, Vaidmenys.user);
	}

	public List<LoginUserAtribute> getLoginUserAtributes(String loginName) {
		List<LoginUserAtribute> atributuSarasas = new ArrayList<>();

		try {
			Connection connection = (Connection) JDBCConnection.getConnection();
			String sql = "SELECT user_name, user_surname, skyrius, pareigos FROM users WHERE login_name='" + loginName
					+ "'";
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
			pst.setString(1, loginName);
			ResultSet rs = pst.executeQuery();
			if (rs.next()) {
				String name = rs.getString("user_name");
				String surname = rs.getString("user_surname");
				String skyrius = rs.getString("skyrius");
				String pareigos = rs.getString("pareigos");
				atributuSarasas.add(new LoginUserAtribute(name, surname, skyrius, pareigos));
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return atributuSarasas;
	}

}
