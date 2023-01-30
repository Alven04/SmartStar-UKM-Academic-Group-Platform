
public class Controller {
	private Course c;
	protected User currentUser;
	private Global global = new Global();
	
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
	
	public void addCourse(String id, String name, String description) {
		// TEMPORARY LINE, DELETE THIS LINE AFTER LOGIN SCREEN IS DONE
		currentUser = new Student("test", "test");
		
		c = new Course(id, name, description);
		c.setCourseOwner(currentUser);
		global.addCourse(c);
	}
//	public void addCourseId(Course c, String id) {
//		c.setCourseID(id);
//	}
//	
//	public void addCourseName(Course c, String name) {
//		c.setCourseName(name);
//	}
//	
//	public void addCourseDescription(Course c, String description) {
//		c.setCourseDescription(description);
//	}
	
//	public void setCourseOwner() {
//		c.setCourseOwner(currentUser);
//	}
	
	public void setCurrentUser(User u) {
		currentUser=u;
	}
	
//	public String getCourseName() {
//		return c.getCourseName();
//	}
	
	public String printInformation(String course) {
		return "The course name is " + global.getCourseByCourseName(course).getCourseName();
	}
	
}
