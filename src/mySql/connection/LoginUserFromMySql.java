package mySql.connection;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.mysql.jdbc.PreparedStatement;

import login.LoginUserAtribute;



public class LoginUserFromMySql{
	
	public boolean getSuperAdminLogin (String loginName, String loginPassword) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		
		Connection connection = MySqlConnect.getInstance().getConnection();
	    String sql = "SELECT login_name, passw FROM help_desk.users WHERE login_name='"+loginName+"' AND passw='"+loginPassword+"' AND vaidmuo='superAdmin'";
	    try {
	        PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            return true;
	        } connection.close();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	    	new Error().printStackTrace();
	    }
	    return false;
	}

	public boolean getBossConnection (String loginName, String loginPassword) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		Connection connection = MySqlConnect.getInstance().getConnection();
	    String sql = "SELECT login_name, passw FROM help_desk.users WHERE login_name='"+loginName+"' AND passw='"+loginPassword+"' AND vaidmuo='vadovas_it'";
	    try {
	        PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            return true;
	        } connection.close();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	    	new Error().printStackTrace();
	    }
	    return false;
	}
	
	public boolean getLocalAdminConnection (String loginName, String loginPassword) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		Connection connection = MySqlConnect.getInstance().getConnection();
	    String sql = "SELECT login_name, passw FROM help_desk.users WHERE login_name='"+loginName+"' AND passw='"+loginPassword+"' AND vaidmuo='darbuotojas_it'";
	    try {
	        PreparedStatement pst = (PreparedStatement) connection.prepareStatement(sql);
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            return true;
	        } connection.close();
	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    } finally {
	    	new Error().printStackTrace();
	    }
	    return false;
	}

	public boolean getUserConnection (String loginName, String loginPassword) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		Connection connection = MySqlConnect.getInstance().getConnection();
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
	    	new Error().printStackTrace();
	    }
	    return false;
	}
	

	public List<LoginUserAtribute> getLoginUserAtributes (String loginName) throws SQLException, FileNotFoundException, IOException, ClassNotFoundException {
		List<LoginUserAtribute> atributuSarasas = new ArrayList<>();
		Connection connection = MySqlConnect.getInstance().getConnection();
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
	    	new Error().printStackTrace();
	    }
	    return atributuSarasas;
	}
	
	
	
	
}
