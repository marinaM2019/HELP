package service;

import java.sql.SQLException;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import mySql.connection.MySqlConnect;

public class SukurtiSkyriu extends MySqlConnect{

	public void sukurtiNauja (String skyriausPavadinimas, String skyriausStatusas) {
	    Connection conn = (Connection) getConnection();
	    String Sql = "INSERT  INTO skyriai (pavadinimas, statusas) VALUES (?, ?)";	    
	    try {
	        PreparedStatement pst = (PreparedStatement) conn.prepareStatement(Sql);
	        pst.setString(1, skyriausPavadinimas);
	        pst.setString(2, skyriausStatusas);
	        pst.executeUpdate();
	        
	    } catch (Exception ee){
	    	System.out.println(ee);
	    }finally {
	    	try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    	}
	}
}
