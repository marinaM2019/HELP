package mySql.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.annotation.Resource;

public class MySqlConnect {

		
	 private static MySqlConnect dbIsntance;
	    private static Connection con ;


	    private MySqlConnect() {
	    }

	    public static MySqlConnect getInstance(){
	    if(dbIsntance==null){
	        dbIsntance= new MySqlConnect();
	    }
	    return dbIsntance;
	    }

	    public  Connection getConnection() throws ClassNotFoundException, SQLException{

	        if(con==null){
	            try {
	            	Class.forName("com.mysql.jdbc.Driver");
	                String host = "jdbc:mysql://192.168.115.156/help_desk?autoReconnect=true&useSSL=false";
	                String username = "admin";
	                String password = "help1111";
	                con = DriverManager.getConnection( host, username, password );
	            } catch (SQLException ex) {
	                Logger.getLogger(MySqlConnect.class.getName()).log(Level.SEVERE, null, ex);
	            }
//	            finally {
//	                if(con != null)
//	                    con.close();
//	            }
	        }

	        return con;
	    }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	
//	private static final String DATABASE_DRIVER = "com.mysql.jdbc.Driver";
//    private static final String DATABASE_URL = "jdbc:mysql://192.168.200.7/help_desk?autoReconnect=true&useSSL=false";
//    private static final String USERNAME = "admin";
//    private static final String PASSWORD = "help1111";
//    private static final String MAX_POOL = "250";
//
//    // init connection object
//    private Connection connection;
//    // init properties object
//    private Properties properties;
//
//    // create properties
//    private Properties getProperties() {
//        if (properties == null) {
//            properties = new Properties();
//            properties.setProperty("user", USERNAME);
//            properties.setProperty("password", PASSWORD);
//            properties.setProperty("MaxPooledStatements", MAX_POOL);
//        }
//        return properties;
//    }
//
//    // connect database
//    public Connection getConnection() {
//        if (connection == null) {
//            try {
//                Class.forName(DATABASE_DRIVER);
//                connection = DriverManager.getConnection(DATABASE_URL, getProperties());
//            } catch (ClassNotFoundException | SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return connection;
//    }
//	
//	
//}
//	private static final String DB_DRIVER_CLASS_NAME = "driver_class_name";
//	private static final String DB_USERNAME = "username";
//	private static final String DB_PASSWORD = "password";
//	private static final String DB_URL = "url";
//	
//	private static Connection connection = null;
//	private static Properties properties = null;
//	static{
//		try {
//			properties = new Properties();
//			properties.load(new FileInputStream("src/database.properties"));
//			Class.forName(properties.getProperty(DB_DRIVER_CLASS_NAME));
//			connection = DriverManager.getConnection(properties.getProperty(DB_URL),properties.getProperty(DB_USERNAME) , properties.getProperty(DB_PASSWORD) );
//		} catch (ClassNotFoundException | SQLException | IOException e) {
//			e.printStackTrace();
//		}
//	}
//	
//	public static Connection getConnection(){
//		return connection;
//	}
//}
 

		
		
//		Properties props = new Properties();
//		FileInputStream fis = null;
//		Connection con = null;
//		try {
//			//InputStream is = Resource.class.getResourceAsStream("database.properties");
//			fis = new FileInputStream("database.properties");
//			props.load(fis);
//
//			// load the Driver Class
//			Class.forName(props.getProperty("driver.class.name"));
//
//			// create the connection now
//			con = DriverManager.getConnection(props.getProperty("db.url"),
//					props.getProperty("db.username"),
//					props.getProperty("db.password"));
//		} catch (IOException | ClassNotFoundException | SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return con;
	//}
	
//    public static Connection getConnection() {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            Connection conn= DriverManager.getConnection("jdbc:mysql://192.168.200.7/help_desk?autoReconnect=true&useSSL=false", "admin", "help1111");
//            //
//            return conn;
//        }
//        catch (Exception e) {
//        	e.printStackTrace();
//            return null;
//        }
//    }
//}