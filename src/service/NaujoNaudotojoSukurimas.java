package service;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import mySql.connection.MySqlConnect;

public class NaujoNaudotojoSukurimas extends MySqlConnect {
	
	public void sukurtiNaudotoja (String loginName, String passwordas, String userName, String userSurname, String email, String skyrius, String pareigos, String vaidmuo) {
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
	        conn.close();
	    } catch (NullPointerException e) {
	    	System.out.println(e);
	    } catch (Exception ee){
	    	System.out.println(ee);
	    }finally {
	    	System.out.println("Naudotojo "+loginName+" - "+userName+" "+userSurname+" sukurimas");
	    }
	}
	
}