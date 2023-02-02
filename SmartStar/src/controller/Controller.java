package controller;
import java.util.ArrayList;

import model.Course;
import model.Global;
import model.User;
import view.AddCourse;
import view.CourseMain;
import view.JoinCourse;
import view.ViewCourse;
import view.ViewQuestion;

public class Controller {
	private Course c;
	private User currentUser;
	private Global global = new Global();
	
	public Controller() {
//		this.displayScreen(1);
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
		else if(num==5)
			new ViewQuestion(this);
	}
	
	public void addCourse(String id, String name, String description) {
		
		c = new Course(id, name, description);
		c.setCourseOwner(currentUser);
		global.addCourse(c);
		currentUser.createCourse(c);
	}

	public void joinCourse(String cid){
		currentUser.joinCourse(global.getCourseByCourseID(cid));
	}
	
	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User user) {
		currentUser=user;
	}
	
	public Global getGlobal() {
		return global;
	}

	public void setGlobal(Global global) {
		this.global = global;
	}

	public boolean detetermineCourseExists(String courseID){
		return global.detetermineCourseExists(courseID);
	}

	public boolean detetermineCourseExistsByName(String courseName){
		return global.detetermineCourseExistsByName(courseName);
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

	public void removeCourses(String courseName){
		global.deleteCourse(global.getCourseByCourseName(courseName));
	}

}
