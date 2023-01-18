
public abstract class User {

	private String username;
	private String password;
	private String name;
	private String institution;
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.name = "";
		this.institution = "";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
}
