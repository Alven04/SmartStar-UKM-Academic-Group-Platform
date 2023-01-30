
public class Controller {
	private Course c=new Course(); //optimize this if possible (idk how)
	
	public Controller() {
		Controller controller = new Controller(); //this as well
		controller.displayScreen(1);
	}
	
	public void displayScreen(int num) {
		if(num==1) 
			new CourseMain(this);
		else if(num==2) 
			new AddCourse(this);
		else if(num==3) 
			new JoinCourse(this);
		
	}
	
	public void addCourseName(String name) {
		c.setCourseName(name);
	}
	
	public void addCourseDescription(String description) {
		c.setCourseDescription(description);
	}
	
	public void addCoursePrivacy(String privacy) {
		c.setCoursePrivacy(privacy);
	}
}
