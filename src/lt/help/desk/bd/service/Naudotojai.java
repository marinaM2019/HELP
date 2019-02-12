package lt.help.desk.bd.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import lt.help.desk.bd.beans.Naudotojas;
import lt.help.desk.bd.mySql.connection.MySqlConnect;

public class Naudotojai {

	public List<Naudotojas> gautiNaudotojuSarasa()
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		List<Naudotojas> sarasas = new ArrayList<>();
		Connection connection = MySqlConnect.getInstance().getConnection();

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
		} catch (SQLException e) {
			sarasas.add(null);
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return sarasas;

	}

	public void sukurtiNauja(String loginName, String passwordas, String userName, String userSurname, String email,
			String skyrius, String pareigos, String vaidmuo)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		Connection conn = MySqlConnect.getInstance().getConnection();
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

		} catch (Exception ee) {
			System.out.println(ee);
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
