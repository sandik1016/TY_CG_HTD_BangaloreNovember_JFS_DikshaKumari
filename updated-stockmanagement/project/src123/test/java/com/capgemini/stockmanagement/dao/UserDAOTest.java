package com.capgemini.stockmanagement.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.stockmanagement.dto.User;

@SpringBootTest
class UserDAOTest {

	@Autowired
	private UserDAO dao;
	private User user = new User();

	@Test
	void testAddUser() {
		try {
			User user = new User();
			user.setEmail("mahi@gmail.com");
			user.setName("Mahi");
			user.setPassword("Mahi@123");
			user.setRole("ComapanyManager");
			boolean result = dao.addUser(user);
			assertEquals(result, true);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				dao.addUser(user);
			});
		}
	}



	

	@Test
	void testLoginUser() {
		try {
			User user = new User();
			user.setEmail("mahi@gmail.com");
			user.setPassword("Mahi@123");
			User result = dao.loginUser(user.getEmail(), user.getPassword());
			assertNotNull(result);
		} catch (Exception e) {
			assertThrows(Exception.class, () -> {
				dao.addUser(user);
			});
		}
	}

	@Test
	void testGetAllUsers() {
		List<User> user = dao.getAllUsers();
		assertNotNull(user);
	}

}
