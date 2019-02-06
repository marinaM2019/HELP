package service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import mySql.connection.MySqlConnect;

public class SukurtiSkyriu extends MySqlConnect{

	public void sukurtiNauja (String skyriausPavadinimas, String statusas) {
	    Connection conn = (Connection) getConnection();
	    String Sql = "INSERT  INTO skyriai (pavadinimas, statusas) VALUES (?, ?)";	    
	    try {
	        PreparedStatement pst = (PreparedStatement) conn.prepareStatement(Sql);
	        pst.setString(1, skyriausPavadinimas);
	        pst.setString(2, statusas);
	        pst.executeUpdate();
	        conn.close();
	    } catch (NullPointerException e) {
	    	System.out.println(e);
	    } catch (Exception ee){
	    	System.out.println(ee);
	    }finally {
	    	System.out.println("Skyriaus "+skyriausPavadinimas+" sukurimas");
	    }
	}
}
