package nl.marlon.model;

import nl.marlon.Exceptions.UnauthorizedException;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

	@Test
	void setUsername() {
		User user = new User("user", "user@email.com", "123");
		user.setUsername("User");
		assertEquals("User", user.getUsername());
	}

	@Test
	void setEmail() {
		User user = new User("user", "user@email.com", "123");
		user.setEmail("user@hotmail.com");

		assertEquals("user@hotmail.com", user.getEmail());
	}

	@Test
	void setPassword() {
		User user = new User("user", "user@email.com", "123");
		user.setPassword("345");

		assertEquals("345", user.getPassword());
	}

	@Test
	void setArchive() {
		User user = new User("user", "user@email.com", "123");
		Archive archive = new Archive(user);
		User user1 = new User("user1", "user1@email.com", "1234");
		Archive archive1 = new Archive(user1);

		user.setArchive(archive1);

		assertEquals(archive1, user.getArchive());
	}

	@Test
	void getAllUsers() {
		// clearen omdat tests user blijven toevoegen
		User.getAllUsers().clear();

		User user = new User("user", "user@email.com", "123");
		User user1 = new User("user1", "user1@email.com", "1234");
		User user2 = new User("user2", "user2@email.com", "12345");
		ArrayList<User> expectedOutput = new ArrayList<>();
		expectedOutput.add(user);
		expectedOutput.add(user1);
		expectedOutput.add(user2);

		assertEquals(expectedOutput, User.getAllUsers());
	}

	@Test
	void createValidUser() throws UnauthorizedException {
		// clearen omdat tests user blijven toevoegen
		User.getAllUsers().clear();
		User user = User.createUser("user", "user@email.com", "123");

		assertEquals(User.getUserByEmail("user@email.com"), user);
	}

	@Test
	void createExistingUser() throws UnauthorizedException {
		User user = new User("user", "user@email.com", "123");
		User user1 = User.createUser("user", "user@email.com", "123");

		assertEquals(null, user1);
	}

	@Test
	void getUserByEmail() throws UnauthorizedException {
		// clearen omdat tests user blijven toevoegen
		User.getAllUsers().clear();

		User user = new User("user", "user@email.com", "123");

		assertEquals(user, User.getUserByEmail("user@email.com"));
	}

	@Test
	void getUserById() {
		// clearen omdat tests user blijven toevoegen
		User.getAllUsers().clear();
		User user = new User("user", "user@email.com", "123");

		assertEquals(user, User.getUserById(user.getId()));
	}

	@Test
	void checkCredentials() throws UnauthorizedException {
		User user = new User("user", "user@email.com", "123");

		assertEquals(true, User.checkCredentials("user@email.com", "123"));
	}

	@Test
	void checkFalseCredentials() throws UnauthorizedException {
		User user = new User("user", "user@email.com", "123");

		assertEquals(false, User.checkCredentials("user@email.com", "123456"));
	}

	@Test
	void checkPassword() {
		User user = new User("user", "user@email.com", "123");

		assertEquals(false, user.checkPassword("123456"));
	}
}