import java.util.HashMap;
import java.util.*;

public class MysqlUserDAO extends MysqlDAO implements UserDAO {

	private static final String TABLE_NAME = "users";

	private User createUserFromHashMap(HashMap<String, Object> row) {

		int userId = (int) row.get("id");
		String username = row.get("username").toString();
		String password = row.get("password").toString();
		Boolean isAdmin = (Boolean) row.get("is_admin");
		String fname = row.get("firstname").toString();
		String lname = row.get("lastname").toString();

		if (isAdmin) {
			return new Admin(username, password, fname, lname, userId);
		} else {
			return new Volunteer(username, password, fname, lname, userId);
		}
	}

	public List<User> getUsers() {

		List<User> userList = new ArrayList<User>();
		List<HashMap<String,Object>> list;
		String sql_query = "SELECT * FROM " + TABLE_NAME;
		list = this.getQuery(sql_query);

		// TODO: Create the actual list of User objects
		for (HashMap<String, Object> row : list) {
			userList.add(createUserFromHashMap(row));
		}

		return userList;
	}

	public User getUserByUsername(String username) {

		String sql_query = String.format(
				"SELECT * FROM users WHERE username=\"%s\"",
				username);
		HashMap<String, Object> row = this.getQuery(sql_query).get(0);

		return createUserFromHashMap(row);
	}

	public Boolean addUser(User user) {

		int is_admin = 0;
		if (user instanceof Admin) is_admin = 1;

		String sql_query = String.format(
				"INSERT INTO %s (username, password, firstname, lastname, is_admin) values " +
						"('%s', '%s', '%s', '%s', '%d')",
				TABLE_NAME, user.getUsername(), user.getPassword(), user.getFirstName(),
				user.getLastName(), is_admin);

		// Returns true if query is valid and username is unique, otherwise false
		return this.updateQuery(sql_query);
	}

	public Boolean deleteUser(User user) {

		String sql_query = String.format(
				"DELETE FROM %s WHERE username = \"%s\"",
				TABLE_NAME, user.getUsername());

		// Returns true if query is valid and username exists
		return this.updateQuery(sql_query);
	}

	public static void main(String[] args) {
		MysqlUserDAO mysql = new MysqlUserDAO();

		User darf = new Volunteer("Darfy", "supersecret","d", "f", 99);

		// Add a user
		Boolean added = mysql.addUser(darf);
		if (!added) {
			System.err.println("Username conflict for " + darf.getUsername());
		}

		// Delete a user
		Boolean deleted = mysql.deleteUser(darf);
		if (!deleted) {
			System.out.println("Ruh roh user doesn't exist");
		}

		// Get list of all users
		List<User> userList = mysql.getUsers();
		for (User user : userList) {
			if (user instanceof Volunteer) {System.out.println("USER:");}
			else {System.out.println("ADMIN:");}
			System.out.println("Username: " + user.getUsername());
			System.out.println("      ID: " + user.getId());
			System.out.println();
		}

		// Get a user by username
		User t2nerb = mysql.getUserByUsername("t2nerb");
		if (t2nerb instanceof Admin) {
			System.out.println(t2nerb.getUsername() + " has da power");
		}
	}

	// TODO: Wat dis function gonna do
	public Boolean updateUser(User user) {

		return true;
	}
}
