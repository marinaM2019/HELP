package lt.help.desk.bd.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import lt.help.desk.bd.beans.Naudotojas;
import lt.help.desk.bd.login.JDBCConnection;

public class Naudotojai extends JDBCConnection{

	public List<Naudotojas> gautiNaudotojuSarasa()
	 {
		List<Naudotojas> sarasas = new ArrayList<>();
		Connection connection = (Connection) getConnection();

		String sql = "SELECT u.id, u.login_name, u.user_name, u.user_surname, u.email, s.pavadinimas, u.pareigos, u.vaidmuo FROM users u INNER JOIN skyriai s ON u.skyrius=s.id ORDER BY u.id";
		try {
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString("u.id");
				String loginName = rs.getString("u.login_name");
				String userName = rs.getString("u.user_name");
				String userSurname = rs.getString("u.user_surname");
				String email = rs.getString("u.email");
				String skyriausPavadinimas = rs.getString("s.pavadinimas");
				String pareigos = rs.getString("u.pareigos");
				String vaidmuo = rs.getString("u.vaidmuo");
				sarasas.add(new Naudotojas(id, loginName, userName, userSurname, email, skyriausPavadinimas, pareigos,
						vaidmuo));

			}
		}  catch (Exception e) {
			throw new RuntimeException(e);
		}
		return sarasas;

	}

	public void sukurtiNauja(String loginName, String passwordas, String userName, String userSurname, String email,
			String skyrius, String pareigos, String vaidmuo)
	 {
		Connection conn = (Connection) getConnection();
		String Sql = "INSERT  INTO users (login_name, passw, user_name, user_surname, email, skyrius, pareigos, vaidmuo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(Sql);
			pst.setString(1, loginName);
			pst.setString(2, passwordas);
			pst.setString(3, userName);
			pst.setString(4, userSurname);
			pst.setString(5, email);
			pst.setString(6, skyrius);
			pst.setString(7, pareigos);
			pst.setString(8, vaidmuo);
			pst.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
