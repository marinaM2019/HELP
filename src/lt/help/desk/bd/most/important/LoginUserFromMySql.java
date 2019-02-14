package lt.help.desk.bd.most.important;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import lt.help.desk.bd.beans.LoginUserAtribute;
import lt.help.desk.bd.login.JDBCConnection;

public class LoginUserFromMySql extends JDBCConnection {

	public boolean getSuperAdminLogin(String loginName, String loginPassword)
	 {
		Connection connection = (Connection) getConnection();
		String sql = "SELECT login_name, passw FROM help_desk.users WHERE login_name='" + loginName + "' AND passw='"
				+ loginPassword + "' AND vaidmuo='superAdmin'";
		try {
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

	public boolean getBossConnection(String loginName, String loginPassword)
	 {
		Connection connection = (Connection) getConnection();
		String sql = "SELECT login_name, passw FROM help_desk.users WHERE login_name='" + loginName + "' AND passw='"
				+ loginPassword + "' AND vaidmuo='vadovas_it'";
		try {
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

	public boolean getLocalAdminConnection(String loginName, String loginPassword)
 {
		Connection connection = (Connection) getConnection();
		String sql = "SELECT login_name, passw FROM help_desk.users WHERE login_name='" + loginName + "' AND passw='"
				+ loginPassword + "' AND vaidmuo='darbuotojas_it'";
		try {
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

	public boolean getUserConnection(String loginName, String loginPassword)
{
		Connection connection = (Connection) getConnection();
		String sql = "SELECT login_name, passw FROM help_desk.users WHERE login_name='" + loginName + "' AND passw='"
				+ loginPassword + "' AND vaidmuo='user'";
		try {
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

	public List<LoginUserAtribute> getLoginUserAtributes(String loginName)
 {
		List<LoginUserAtribute> atributuSarasas = new ArrayList<>();
		Connection connection = (Connection) getConnection();
		String sql = "SELECT user_name, user_surname, skyrius, pareigos FROM users WHERE login_name='" + loginName
				+ "'";
		try {
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
