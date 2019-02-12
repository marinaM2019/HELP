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
import lt.help.desk.bd.mySql.connection.MySqlConnect;

public class Gedimai {

	public void itraukti(String tema, String aprasymas, String gedimaPateike) throws IOException
			 {

		Connection conn = MySqlConnect.getConnection();
		String Sql = "INSERT  INTO gedimai (tema, aprasymas, gedima_pateike) VALUES (?, ?, ?)";
		try {
			PreparedStatement pst = (PreparedStatement) conn.prepareStatement(Sql);
			pst.setString(1, tema);
			pst.setString(2, aprasymas);
			pst.setString(3, gedimaPateike);
			pst.executeUpdate();

		} catch (Exception ee) {
			throw new RuntimeException();
		} 
	}

	public List<Gedimas> gautiManoPateiktus(String loginName) throws IOException
			 {
		List<Gedimas> sarasas = new ArrayList<>();
		Connection connection = MySqlConnect.getConnection();
		String sql = "SELECT iraso_data, tema, aprasymas, statusas, vykdytojas, vykdytojo_iraso_data FROM gedimai WHERE gedima_pateike=? ORDER BY iraso_data DESC";
		try {
			PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String irasoData = rs.getString("iraso_data");
				String tema = rs.getString("tema");
				String aprasymas = rs.getString("aprasymas");
				String statusas = rs.getString("statusas");
				String vykdytojas = rs.getString("vykdytojas");
				String vykdytojoIrasoData = rs.getString("vykdytojo_iraso_data");

				sarasas.add(new Gedimas(irasoData, tema, aprasymas, statusas, vykdytojas, vykdytojoIrasoData));

			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		return sarasas;

	}

}
