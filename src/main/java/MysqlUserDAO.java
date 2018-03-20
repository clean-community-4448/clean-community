import java.util.HashMap;
import java.util.*;

public class MysqlUserDAO extends MysqlDAO {

	private static final String TABLE_NAME = "users";

	public void getUsers() {

		List<User> userList = new ArrayList<User>();
		List<HashMap<String,Object>> list;
		String sql_query = "SELECT * FROM " + TABLE_NAME;
		list = this.getQuery(sql_query);

		// TODO: Create the actual list of User objects
		for (HashMap<String, Object> row : list) {
			// userList.add(User(row.get("id"), row.get("userName")));
			System.out.println("ID: " + row.get("id").toString());
			System.out.println("username: " + row.get("userName").toString());
		}
	}

	public User getUser(String userName) {

		String sql_query = "SELECT * FROM users WHERE userName=\"" + userName + "\"";
		HashMap<String, Object> row = this.getQuery(sql_query).get(0);

		// TODO: Create the actual user object like a man
		return new User();
	}

	public Boolean addUser(String userName) {

		String sql_query = String.format("INSERT INTO %s (username) values (\"%s\")",
						TABLE_NAME, userName);

		// Returns true if query is valid and username is unique, otherwise false
		return this.updateQuery(sql_query);
	}

	public Boolean deleteUser(String userName) {

		String sql_query = String.format("DELETE FROM %s WHERE username = \"%s\"",
						TABLE_NAME, userName);

		// Returns true if query is valid and username exists
		return this.updateQuery(sql_query);
	}

	public static void main(String[] args) {
		MysqlUserDAO mysql = new MysqlUserDAO();

		// Add a user
		mysql.addUser("elitedarklord");

		// Get list of users
		mysql.getUsers();

		// Get a user
		mysql.getUser("t2nerb");

		// Delete a user
		mysql.deleteUser("elitedarklord");
	}

	// TODO: Wat dis function gonna do
	public Boolean updateUser(String userName) {

		return true;
	}
}
