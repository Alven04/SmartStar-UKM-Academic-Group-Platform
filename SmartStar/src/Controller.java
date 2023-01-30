
public class Controller {

	public Controller() {
		new CourseMain(this);
	}
	
	public void displayScreen(int num) {
		if (num == 1)
			new CourseMain(this);
		else if (num == 2)
			new AddCourse(this);
	}
	
	public void addCourseDescription(String courseDescription) {

	}
	
	public void addCourseName(String courseName) {
		
	}
}
