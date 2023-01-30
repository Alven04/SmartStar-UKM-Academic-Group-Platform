
public class Controller {
	private Course c;
	
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
		else if (num==11)
			new SplashScreen(this);
		else if (num==12)
			new SignUpScreen(this);
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
