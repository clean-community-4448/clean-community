package code.jdbc;

import java.sql.*;

abstract class MysqlDAO {

	static final String JDBC_DRIVER = "com.mysql.jdbc.driver";
	private String tableName;

	// Database credentials
	private final String USER = "root";
	private final String PASS = "password";

	// jdbc:mysql://<server_name>/<database>
	private final String serverName = "localhost";
	private final String dbName = "cleancommunity";
	private final String DB_URL = "jdbc:mysql://" + serverName + "/" + dbName;

	public Connection conn = null;

	// TODO: Return the list of ResultSet
	protected boolean submitQuery() {
		Connection conn = null;
		Statement stmt = null;
		try{
			// Register jdbc driver
			Class.forName("com.mysql.jdbc.Driver");

			// Create connection to database
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			// Execute query
			stmt = conn.createStatement();
			String sql;
			sql = "SELECT id, name FROM example";
			ResultSet rs = stmt.executeQuery(sql);

			// Iterate through returns rows and print them
			while(rs.next()){
				//Retrieve by column name
				int id  = rs.getInt("id");
				String last = rs.getString("name");

				//Display values
				System.out.println("ID: " + id);
				System.out.println("Last: " + last);
			}

			// Cleanup
			rs.close();
			stmt.close();
			conn.close();
		}catch(SQLException se){
			//Handle errors for JDBC
			se.printStackTrace();
		}catch(Exception e){
			//Handle errors for Class.forName
			e.printStackTrace();
		}finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			}catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}catch(SQLException se){
				se.printStackTrace();
			}
		}
		return true;
	}

}