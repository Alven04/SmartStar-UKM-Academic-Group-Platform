
public class Controller {
	private Course c;
	protected User currentUser;
	
	public Controller() {
		this.displayScreen(1);
	}
	
	public void displayScreen(int num) {
		if(num==1) 
			new CourseMain(this);
		else if(num==2) 
			new AddCourse(this);
		else if(num==3) 
			new JoinCourse(this);
	}
	public void addCourseId(String id) {
		c.setCourseID(id);
	}
	
	public void addCourseName(String name) {
		c.setCourseName(name);
	}
	
	public void addCourseDescription(String description) {
		c.setCourseDescription(description);
	}
	
	public void setCourseOwner() {
		c.setCourseOwner(currentUser);
	}
	
	public void setCurrentUser(User u) {
		currentUser=u;
	}
	
}
