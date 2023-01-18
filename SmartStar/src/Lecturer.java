
public class Lecturer extends User {

	private String qualification;
	
	public Lecturer (String username, String password) {
		super(username, password);
		this.qualification = "";
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
