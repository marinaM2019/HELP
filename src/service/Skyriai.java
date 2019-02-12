package service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.mysql.jdbc.PreparedStatement;

import beans.Skyrius;
import mySql.connection.MySqlConnect;

public class Skyriai{
	
	
		public List<Skyrius> gautiSarasa () throws SQLException, ClassNotFoundException {
		List<Skyrius> sarasas = new ArrayList<>();
		Connection connection = MySqlConnect.getInstance().getConnection();
	    String sql = "SELECT id, pavadinimas FROM skyriai WHERE statusas=1 ORDER BY pavadinimas";
	    try {
	        PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        while (rs.next()) {
	        	String id = rs.getString("id");
	        	String pavadinimas = rs.getString("pavadinimas");
	            sarasas.add(new Skyrius(id, pavadinimas));
	            
	        }
	    } catch (SQLException e) {
	    	sarasas.add(null);
	    }
	    return sarasas;
	    
	}    
	

		
		public void sukurtiNauja (String skyriausPavadinimas, String skyriausStatusas) throws SQLException, ClassNotFoundException {
			Connection conn = MySqlConnect.getInstance().getConnection();
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
