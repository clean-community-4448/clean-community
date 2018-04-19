package com.cleancommunity.user;

import com.cleancommunity.misc.MysqlDAO;
import com.cleancommunity.posting.Posting;

import java.util.HashMap;
import java.util.*;

public class MysqlUserDAO extends MysqlDAO implements UserDAO {

	private static final String TABLE_NAME = "users";

	private static User createUserFromHashMap(HashMap<String, Object> row) {

		int userId = (int) row.get("id");
		String username = row.get("username").toString();
		String password = row.get("password").toString();
		Boolean isAdmin = (Boolean) row.get("is_admin");
		String fname = row.get("firstname").toString();
		String lname = row.get("lastname").toString();

		User user = UserFactory.createUser(username, password, fname, lname, userId, isAdmin);
		return user;
	}

	public List<User> getUsers() {

		List<User> userList = new ArrayList<User>();
		List<HashMap<String,Object>> list;
		String sql_query = "SELECT * FROM " + TABLE_NAME;
		list = this.getQuery(sql_query);

		// TODO: Create the actual list of com.cleancommunity.com.cleancommunity.user.com.cleancommunity.com.cleancommunity.user objects
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
	public Boolean updateUser(User user) {
		if (user instanceof Volunteer) {
			String sql_query = String.format(
					"UPDATE %s SET %s = %s, %s = %s, %s = %s WHERE username = \"%s\" AND password = \"%s\"",
					TABLE_NAME, "completed", ((Volunteer)user).getProjectsCompleted(),
					"inProgress", ((Volunteer)user).getProjectsCompleted(), "posted",
					((Volunteer)user).getProjectsPosted(), user.getUsername(), user.getPassword());

			// Returns true if query is valid and username is unique, otherwise false
			return this.updateQuery(sql_query);
		}
		return true;
	}

}
