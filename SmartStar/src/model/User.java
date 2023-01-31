package model;
import java.util.ArrayList;

public abstract class User {

	private String username;
	private String password;
	private String name;
	private String institution;
	
	private ArrayList<Course> coursesJoined = new ArrayList<>();
	private ArrayList<Course> coursesCreated = new ArrayList<>();
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		this.name = "";
		this.institution = "";
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}
	
	public ArrayList<Course> getCoursesJoined() {
		return coursesJoined;
	}

	public void setCoursesJoined(ArrayList<Course> coursesJoined) {
		this.coursesJoined = coursesJoined;
	}
	
	public ArrayList<Course> getCoursesCreated() {
		return coursesCreated;
	}

	public void setCoursesCreated(ArrayList<Course> coursesCreated) {
		this.coursesCreated = coursesCreated;
	}

	/**
	 * Adds the course into coursesJoined ArrayList.
	 * If the coursesJoined ArrayList already contains the course,
	 * then do nothing, return false
	 * @param course course to add
	 * @return true if course is added to coursesJoined ArrayList, 
	 * otherwise return false
	 */
	public boolean joinCourse(Course course) {
		if (coursesJoined.contains(course)) {
			return false;
		}
		coursesJoined.add(course);	
		return true;
	}
	
	/**
	 * Removes the course from coursesJoined ArrayList. 
	 * If the coursesJoined ArrayList does not contain the course, 
	 * then do nothing, return false
	 * @param course course to remove
	 * @return true if the course is removed from coursesJoined ArrayList,
	 * otherwise return false
	 */
	public boolean leaveCourse(Course course) {
		return coursesJoined.remove(course);
	}
	
	/**
	 * Adds the course into coursesCreated ArrayList.
	 * Also adds the course into coursesJoined ArrayList if the User
	 * is not yet a member of the course
	 * @param course
	 * @return
	 */
	public boolean createCourse(Course course) {
		if (coursesCreated.contains(course)) {
			return false;
		}
		coursesCreated.add(course);	
		joinCourse(course);
		return true;
	}
	
}
