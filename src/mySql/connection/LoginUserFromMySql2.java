package mySql.connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import login.LoginUserAtribute;



public class LoginUserFromMySql2 extends MySqlConnect{
 
	public boolean getBossConnection (String loginName, String loginPassword) {
	    Connection connection = (Connection) getConnection();
	    String sql = "SELECT login_name, passw FROM help_desk.users WHERE vaidmuo='vadovas%' AND login_name='"+loginName+"' AND passw='"+loginPassword+"' AND vaidmuo='vadovas_it'";
	    try {
	        PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            return true;
	        } connection.close();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	    	System.out.println("finally - select Boss user "+loginName+" to connect to DB");
	    }
	    return false;
	}
	
	public boolean getLocalAdminConnection (String loginName, String loginPassword) {
	    Connection connection = (Connection) getConnection();
	    String sql = "SELECT login_name, passw FROM help_desk.users WHERE vaidmuo='darbuotojas%' AND login_name='"+loginName+"' AND passw='"+loginPassword+"' AND vaidmuo='darbuotojas_it'";
	    try {
	        PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            return true;
	        } connection.close();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	    	System.out.println("finally - select LocalAdmin user "+loginName+" to connect to DB");
	    }
	    return false;
	}

	public boolean getUserConnection (String loginName, String loginPassword) {
	    Connection connection = (Connection) getConnection();
	    String sql = "SELECT login_name, passw FROM help_desk.users WHERE login_name='"+loginName+"' AND passw='"+loginPassword+"' AND vaidmuo='user'";
	    try {
	        PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            return true;
	        } connection.close();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	    	System.out.println("finally - select user "+loginName+" to connect to DB");
	    }
	    return false;
	}
	

	public List<LoginUserAtribute> getLoginUserAtributes (String loginName) {
		List<LoginUserAtribute> atributuSarasas = new ArrayList<>();
	    Connection connection = (Connection) getConnection();
	    String sql = "SELECT user_name, user_surname, skyrius, pareigos FROM users WHERE login_name='"+loginName+"'";
	    try {
	    	PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
	        pst.setString (1, loginName);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	        	String name = rs.getString("user_name");
	        	String surname = rs.getString("user_surname");
	        	String skyrius = rs.getString("skyrius");
	        	String pareigos = rs.getString("pareigos");
	        	atributuSarasas.add(new LoginUserAtribute (name, surname, skyrius, pareigos));
	        } connection.close();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	    	System.out.println("finally - "+loginName+" atribut� s�ra�as");
	    }
	    return atributuSarasas;
	}
	
	
	
	
}
