import java.sql.*;
import java.util.*;

abstract class MysqlDAO {

	private String tableName;

	// Database credentials
	private final String USER = "root";
	private final String PASS = "password";

	// jdbc:mysql://<server_name>/<database>
	private final String SERVER_NAME = "localhost";
	private final String DB_NAME = "cleancommunity";
	private final String DB_URL = "jdbc:mysql://" + SERVER_NAME + "/" + DB_NAME;

	protected List<HashMap<String,Object>> getQuery(String sql_query) {

		List<HashMap<String,Object>> getList = new ArrayList<HashMap<String,Object>>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs;

		try {
			// Register jdbc driver
			Class.forName("com.mysql.jdbc.Driver");

			// Create connection to database
			conn = DriverManager.getConnection(DB_URL,USER,PASS);

			// Execute query
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql_query);

			// Iterate through returns rows and print them
			getList = resultSetToList(rs);

			// Cleanup
			rs.close();
			stmt.close();
			conn.close();
		} catch(SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch(Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// Finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			} catch(SQLException se2) {
			} try {
				if(conn != null)
					conn.close();
			} catch(SQLException se) {
				se.printStackTrace();
			}
		}

		return getList;
	}

	private List<HashMap<String,Object>> resultSetToList(ResultSet rs) throws SQLException {
		ResultSetMetaData md = rs.getMetaData();
		int columns = md.getColumnCount();
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();

		while (rs.next()) {
			HashMap<String,Object> row = new HashMap<String, Object>(columns);
			for(int i=1; i<=columns; ++i) {
				row.put(md.getColumnName(i),rs.getObject(i));
			}
			list.add(row);
		}

		return list;
	}

}