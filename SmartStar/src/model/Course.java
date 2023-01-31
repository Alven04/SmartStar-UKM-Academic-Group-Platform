package model;
import java.util.ArrayList;

public class Course {
	private String courseName;
	private String courseDescription;
	private String courseID;
	private User courseOwner;
	private User courseMembers;
	
	private ArrayList<Course> listOfCourse=new ArrayList<Course>();
	public Course(String courseID,String courseName,String courseDescription) { //removed coursePrivacy
		this.courseID=courseID;
		this.courseName=courseName;
		this.courseDescription=courseDescription;
		
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
	
	
}
