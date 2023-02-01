package model;
import java.util.ArrayList;

public class Course {
	private String courseName;
	private String courseDescription;
	private String courseID;
	private User courseOwner;
	private ArrayList<User> courseMembers=new ArrayList<User>();
	
	public Course(String courseID,String courseName,String courseDescription) { 
		this.courseID=courseID;
		this.courseName=courseName;
		this.courseDescription=courseDescription;
		
	}
	public String getCourseID() {
		return courseID;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseID(String id) {
		courseID=id;
	}
	
	public void setCourseName(String name) {
		courseName=name;
	}
	
	public void setCourseDescription(String description) {
		courseDescription=description;
	}
	
	public void setCourseOwner(User currentUser) {
		courseOwner=currentUser;
	}

	public void setCourseMembers(User currentUser) {
		courseMembers.add(currentUser);
	}
	
	
}
