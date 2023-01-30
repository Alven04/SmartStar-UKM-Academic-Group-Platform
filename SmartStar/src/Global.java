import java.util.ArrayList;

public class Global {

	private ArrayList<User> userList = new ArrayList<>();
	private ArrayList<Course> courseList = new ArrayList<>();
	
	public ArrayList<User> getUserList() {
		return userList;
	}

	public ArrayList<Course> getCourseList() {
		return courseList;
	}
	
	public void addUser(User user) {
		userList.add(user);
	}

	public void addCourse(Course course) {
		courseList.add(course);
	}
	
	public User getUserByUsername(String username) {
		for (User user : userList) {
			if (user.getUsername().equals(username)) {
				return user;
			}
		}
		return null;
	}

	public Course getCourseByCourseName(String courseName) {
		for (Course course : courseList) {
			if (course.getCourseName().equals(courseName)) {
				return course;
			}
		}
		return null;
	}

}
