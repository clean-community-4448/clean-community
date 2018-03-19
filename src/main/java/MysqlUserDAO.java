import java.util.HashMap;
import java.util.*;

public class MysqlUserDAO extends MysqlDAO {

	public void getUsers() {

		List<User> userList = new ArrayList<User>();
		List<HashMap<String,Object>> list;
		MysqlDAO mysql = new MysqlUserDAO();
		list = mysql.getQuery("SELECT * FROM users;");

		// TODO: Create the actual list of User objects
		for (HashMap<String, Object> row : list) {
			// userList.add(User(row.get("id"), row.get("userName")));
			System.out.println("ID: " + row.get("id").toString());
			System.out.println("username: " + row.get("userName").toString());
		}
	}

	public User getUser(String userName) {

		MysqlDAO mysql = new MysqlUserDAO();

		String sql_query = "SELECT * FROM users WHERE userName=\"" + userName + "\"";
		HashMap<String, Object> row = mysql.getQuery(sql_query).get(0);

		// TODO: Create the actual user object like a man
		return new User();
	}

	public static void main(String[] args) {
		MysqlUserDAO mysql = new MysqlUserDAO();

		// Get list of users
		mysql.getUsers();

		// Get a user
		mysql.getUser("t2nerb");
	}
}
