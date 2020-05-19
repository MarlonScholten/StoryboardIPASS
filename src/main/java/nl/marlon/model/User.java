package nl.marlon.model;

import java.util.ArrayList;

public class User {
	private String username;
	private String email;
	private String password;
	private Archive archive;
	private ArrayList<User> allUsers = new ArrayList<>();

	// Full constructor
	public User(String username, String email, String password, Archive archive) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.archive = archive;
		allUsers.add(this);
	}
	// No archive
	public User(String username, String email, String password) {
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

	public User getUserByEmail(String email){
		for(User user : allUsers){
			if(user.email.equals(email)){
				return user;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "Type: " + this.getClass().getSimpleName() + "\n" +
				"Username: " + username + "\n" +
				"Email: " + email + "\n" +
				"Password: " + password + "\n";
	}
}
