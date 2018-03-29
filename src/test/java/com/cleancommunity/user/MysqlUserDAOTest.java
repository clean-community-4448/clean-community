package com.cleancommunity.user;

import org.junit.Test;

import static org.junit.Assert.*;

public class MysqlUserDAOTest {

	@Test
	public void getUsers() {
		UserDAO mysql = new MysqlUserDAO();
		User sample = mysql.getUserByUsername("t2nerb");

		assertEquals(sample.getUsername(), "t2nerb");
		assertNotNull(sample.getPassword());
	}

	@Test
	public void getUserByUsername() {
	}

	@Test
	public void addUser() {
	}

	@Test
	public void deleteUser() {
	}
}