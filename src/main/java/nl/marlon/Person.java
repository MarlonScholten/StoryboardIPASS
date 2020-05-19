package nl.marlon;

public class Person {
	private String username;
	private String email;
	private String password;
	private Archive archive;

	// Full constructor
	public Person(String username, String email, String password, Archive archive) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.archive = archive;
	}
	// No archive
	public Person(String username, String email, String password) {
		this.username = username;
		this.email = email;
		this.password = password;
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
}
