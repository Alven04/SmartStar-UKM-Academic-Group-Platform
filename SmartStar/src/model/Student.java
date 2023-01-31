package model;
public class Student extends User {

	private int year;
	private String major;
	
	public Student (String username, String password) {
		super(username, password);
		this.year = 0;
		this.major = "";
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public void updateDetails(String name, String institution, int year, String major) {
		setName(name);
		setInstitution(institution);
		setYear(year);
		setMajor(major);
	}
}
