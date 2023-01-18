
public class Student extends User {

	private String year;
	private String major;
	
	public Student (String username, String password) {
		super(username, password);
		this.year = "";
		this.major = "";
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public void updateDetails(String name, String institution, String year, String major) {
		setName(name);
		setInstitution(institution);
		setYear(year);
		setMajor(major);
	}
}
