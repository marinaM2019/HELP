package mySql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlConnect {
	
	
	private static MySqlConnect instance;
    private Connection connection;
    private String url = "jdbc:mysql://192.168.115.156/help_desk?autoReconnect=true&useSSL=false";
    private String username = "admin";
    private String password = "help1111";

    private MySqlConnect() throws SQLException {
        try {
            Class.forName("org.postgresql.Driver");
            this.connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Database Connection Creation Failed : " + ex.getMessage());
        }
    }

    private Connection getConnection2() {
        return connection;
    }

    public static MySqlConnect getConnection() throws SQLException {
        if (instance == null) {
            instance = new MySqlConnect();
        }
        return instance;
    }
}
	
	
	
	
//	
//    public Connection getConnection() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            //reiktu is properties
//            Connection conn= DriverManager.getConnection("jdbc:mysql://192.168.0.60/help_desk?autoReconnect=true&useSSL=false", "admin", "help1111");
//            return conn;
//        }
//        catch (Exception e) {
//        	e.printStackTrace();
//            return null;
//        }
//    }
//}