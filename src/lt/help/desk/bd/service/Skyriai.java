package lt.help.desk.bd.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import lt.help.desk.bd.beans.Skyrius;
import lt.help.desk.bd.login.JDBCConnection;

public class Skyriai extends JDBCConnection {

	public List<Skyrius> gautiSarasa() throws Exception {
		List<Skyrius> sarasas = new ArrayList<>();
		try {
			Connection connection = (Connection) getConnection();
			String sql = "SELECT id, pavadinimas FROM skyriai WHERE statusas=1 ORDER BY pavadinimas";

			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String id = rs.getString("id");
				String pavadinimas = rs.getString("pavadinimas");
				sarasas.add(new Skyrius(id, pavadinimas));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		return sarasas;
	}

	public void sukurtiNauja(String skyriausPavadinimas, String skyriausStatusas) {
		try {
			Connection conn = (Connection) getConnection();
			String Sql = "INSERT  INTO skyriai (pavadinimas, statusas) VALUES (?, ?)";
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(Sql);
			pst.setString(1, skyriausPavadinimas);
			pst.setString(2, skyriausStatusas);
			pst.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}
