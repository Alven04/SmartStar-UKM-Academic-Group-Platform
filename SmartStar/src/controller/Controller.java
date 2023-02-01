package controller;
import java.util.ArrayList;

import model.Course;
import model.Global;
import model.Student;
import model.User;
import view.AddCourse;
import view.CourseMain;
import view.JoinCourse;
import view.ViewCourse;

public class Controller {
	private Course c;
	protected User currentUser;
	private Global global;
	
	public Controller(Global global) {
		this.displayScreen(1);
		this.global = global;
	}
	
	public void displayScreen(int num) {
		if(num==1) 
			new CourseMain(this);
		else if(num==2) 
			new AddCourse(this);
		else if(num==3) 
			new JoinCourse(this);
		else if(num==4)
			new ViewCourse(this);
	}
	
	public void addCourse(String id, String name, String description) {
		
		c = new Course(id, name, description);
		c.setCourseOwner(currentUser);
		global.addCourse(c);
		currentUser.createCourse(c);
	}
	
	public void setCurrentUser(User u) {
		currentUser=u;
	}
	public boolean detetermineCourseExists(String courseID){
		return global.detetermineCourseExists(courseID);
	}
	
	public String printInformation(String course) {
		return "The course name is " + global.getCourseByCourseName(course).getCourseName();
	}

	public String[] getCourseJoinedByUser(){
		ArrayList<Course> list=new ArrayList<Course>();
		list.addAll(currentUser.getCoursesJoined());
		String[] arrayList=new String[list.size()];
		int i=0;
		for(Course c: list){
			String courseName=c.getCourseName();
			arrayList[i]=courseName;
			i++;
		}
		return arrayList;
	}
}
