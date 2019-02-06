package mySql.connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnect {
    public Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost/help_desk?autoReconnect=true&useSSL=false", "admin", "help1111");
            return conn;
        }
        catch (Exception e) {
        	System.out.println("Ávyko MySqlConnect klaida: "+e);
            return null;
        }
    }
}