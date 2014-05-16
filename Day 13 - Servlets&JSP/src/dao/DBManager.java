package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBManager {
	
	private static final String userName = "root";
	private static final String password = "root";
	private static final String serverName = "localhost";
	private static final int portNumber = 3306;
	private static final String dbName = "mydb";
	private static Connection conn = null;
	
	/**
	 * Get a new database connection
	 * 
	 * @return
	 * @throws SQLException
	 */
	public  Connection getConnection() throws SQLException {
		Connection conn = null;
		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("password", password);

		try {
		    Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException ex) {
		    // error out
			System.out.println("DB error");
		}
		
		conn = DriverManager.getConnection("jdbc:mysql://"
				+ serverName + ":" + portNumber + "/" + dbName,
				connectionProps);

		return conn;
	}
	
	public void connectToDatabase(){
		
		// Connect to MySQL
		try {
			conn = getConnection();
			System.out.println("Connected to database");
		} catch (SQLException e) {
			System.out.println("ERROR: Could not connect to the database");
			e.printStackTrace();
			return;
			}
	}
	
	public boolean executeUpdate(Connection conn, String command) throws SQLException {
	    Statement stmt = null;
	    try {
	        stmt = conn.createStatement();
	        stmt.executeUpdate(command); // This will throw a SQLException if it fails
	        return true;
	    } finally {

	        if (stmt != null) { stmt.close(); }
	    }
	}
	
	public void dropTable(String tableName){
		
		// Drop the table
		try {
		    String dropString = "DROP TABLE " + tableName;
			executeUpdate(conn, dropString);
			System.out.println("Dropped the table");
	    } catch (SQLException e) {
			System.out.println("ERROR: Could not drop the table");
			e.printStackTrace();
			return;
		}
	}
	
	public void insertInTable(String insertString){
		
		System.out.println("Inserting records into the table...");
		try{
			executeUpdate(conn, insertString);
			System.out.println("Records inserted successfuly");
			
		}catch (SQLException e) {
			System.out.println("ERROR: Could not insert to table");
			e.printStackTrace();
			return;
		}	
	}
	
	public ResultSet selectfromTable(String selectString){
		
		System.out.println("Selecting records from the table...");
		try{
			 Statement stmt = null;  
			 stmt = conn.createStatement();
			 System.out.println("Records selected successfuly");
			 
			 return stmt.executeQuery(selectString);
		}catch (SQLException e) {
			System.out.println("ERROR: Could not select");
			e.printStackTrace();
			return null;
		}	
		
	}
	
}
