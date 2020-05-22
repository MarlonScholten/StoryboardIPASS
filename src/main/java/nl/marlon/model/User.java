package nl.marlon.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Objects;

public class User {
	private int id;
	private String username;
	private String email;
	private String password;
	private Archive archive;
	private static int numUsers = 0;
	@JsonIgnore
	private static ArrayList<User> allUsers = new ArrayList<>();

	// No archive
	public User(String username, String email, String password) {
		this.id = ++numUsers;
		this.username = username;
		this.email = email;
		this.password = password;
		this.archive = new Archive(this);
		allUsers.add(this);
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Archive getArchive() {
		return archive;
	}

	public void setArchive(Archive archive) {
		this.archive = archive;
	}

	public static ArrayList<User> getAllUsers() {
		return allUsers;
	}

	public int getId() {
		return id;
	}

	public static int getNumUsers() {
		return numUsers;
	}

	public static User createUser(String username, String email, String password){
		if(allUsers.stream().noneMatch(e->e.getEmail().equals(email))){
			return new User(username, email, password);
		}
		return null;
	}

	public void setAllUsers(ArrayList<User> allUsers) {
		this.allUsers = allUsers;
	}

	public static User getUserByEmail(String email){
		for(User user : allUsers){
			if(user.email.equals(email)){
				return user;
			}
		}
		return null;
	}
	public static User getUserById(int id){
		for(User user : allUsers){
			if(user.id == id){
				return user;
			}
		}
		return null;
	}

	public static boolean checkCredentials(String email, String password){
		User target = getUserByEmail(email);
		if(target.getPassword().equals(password)){
			return true;
		}
		return false;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		User user = (User) o;
		return username.equals(user.username) &&
				email.equals(user.email) &&
				password.equals(user.password) &&
				archive.equals(user.archive);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, username, email, password, archive);
	}

	@Override
	public String toString() {
		return "Type: " + this.getClass().getSimpleName() + "\n" +
				"Username: " + username + "\n" +
				"Email: " + email + "\n" +
				"Password: " + password + "\n";
	}
}
