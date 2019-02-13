package lt.help.desk.bd.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.PreparedStatement;

import lt.help.desk.bd.beans.Gedimas;
import lt.help.desk.bd.beans.Naudotojas;
import lt.help.desk.bd.mySql.connection.MySqlConnect;

public class Gedimai {
	
	
	public void itraukti(String gedimoTema, String gedimoAprasymas, String loginName)
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		Connection conn = MySqlConnect.getConnection();
		String Sql = "INSERT  INTO gedimai (tema, aprasymas, gedima_pateike) VALUES (?, ?, ?)";
		try {
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(Sql);
			pst.setString(1, gedimoTema);
			pst.setString(2, gedimoAprasymas);
			pst.setString(3, loginName);
			pst.executeUpdate();

		} catch (Exception ee) {
			throw new RuntimeException();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
	}
	
	
	
	
	
	public List<Gedimas> gautiNepaskirtus()
			throws SQLException, ClassNotFoundException, FileNotFoundException, IOException {
		List<Gedimas> sarasas = new ArrayList<>();
		Connection connection = MySqlConnect.getConnection();

		String sql = "SELECT iraso_data, tema, aprasymas, gedima_pateike, statusas FROM gedimai WHERE statusas='pateikta'";
		try {
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
				throw new RuntimeException();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException();
			}
		}
		return sarasas;

	}

}
