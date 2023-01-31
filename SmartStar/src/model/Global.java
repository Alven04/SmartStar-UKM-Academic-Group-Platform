package model;
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
	
	public void deleteUser(User user) {
		userList.remove(user);
	}

	public void addCourse(Course course) {
		courseList.add(course);
	}
	
	public void deleteCourse(Course course) {
		courseList.remove(course);
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
	public boolean detetermineCourseExists(String courseID){
		for(Course c: courseList){
			if(c.getCourseID().equals(courseID)){
				return true;
			}
		}
		return false;
	}


}
