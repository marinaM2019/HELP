package lt.help.desk.bd.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import lt.help.desk.bd.beans.Gedimas;
import lt.help.desk.bd.login.JDBCConnection;

public class Gedimai extends JDBCConnection {

	public void itraukti(String gedimoTema, String gedimoAprasymas, String loginName) {
		try {
			Connection conn = (Connection) getConnection();
			String Sql = "INSERT  INTO gedimai (tema, aprasymas, gedima_pateike) VALUES (?, ?, ?)";

			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(Sql);
			pst.setString(1, gedimoTema);
			pst.setString(2, gedimoAprasymas);
			pst.setString(3, loginName);
			pst.executeUpdate();

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	public List<Gedimas> gautiNepaskirtus() {
		List<Gedimas> sarasas = new ArrayList<>();
		try {

			Connection connection = (Connection) getConnection();

			String sql = "SELECT iraso_data, tema, aprasymas, gedima_pateike, statusas FROM gedimai WHERE statusas='pateikta'";

			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String data = rs.getString("iraso_data");
				String tema = rs.getString("tema");
				String aprasymas = rs.getString("aprasymas");
				String gedimaPateike = rs.getString("gedima_pateike");
				String statusas = rs.getString("statusas");
				sarasas.add(new Gedimas(data, tema, aprasymas, gedimaPateike, statusas));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return sarasas;

	}

	public List<Gedimas> gautiManoGedimus(String gedimaPateike) {
		List<Gedimas> sarasas = new ArrayList<>();
		try {

			Connection connection = (Connection) getConnection();

			String sql = "SELECT iraso_data, tema, aprasymas, statusas, vykdytojas, vykdytojo_iraso_data FROM gedimai WHERE gedima_pateike=? ORDER BY iraso_data DESC";

			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String data = rs.getString("iraso_data");
				String tema = rs.getString("tema");
				String aprasymas = rs.getString("aprasymas");
				String statusas = rs.getString("statusas");
				String vykdytojas = rs.getString("vykdytojas");
				String vykdytojoIrasoData = rs.getString("vykdytojo_iraso_data");
				sarasas.add(new Gedimas(data, tema, aprasymas, statusas, vykdytojas, vykdytojoIrasoData));

			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return sarasas;

	}
}
