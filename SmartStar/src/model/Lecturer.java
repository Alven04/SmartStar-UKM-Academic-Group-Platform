package model;
public class Lecturer extends User {

	private String qualification;
	
	public Lecturer (String username, String password) {
		super(username, password);
		this.qualification = "";
	}
	
	public Lecturer (String username, String password, String name, String institution, String qualification) {
		super(username, password, name, institution);
		this.qualification = qualification;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public void updateDetails(String name, String institution, String qualification) {
		setName(name);
		setInstitution(institution);
		setQualification(qualification);
	}
}
