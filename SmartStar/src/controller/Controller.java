package controller;
import java.util.ArrayList;

import model.Course;
import model.Global;
import model.Lecturer;
import model.Student;
import model.User;
import view.AddCourse;
import view.CourseMain;
import view.EditProfile;
import view.JoinCourse;
import view.ViewCourse;

public class Controller {
	private Course c;
	private User currentUser;
	private Global global = new Global();
	
	private SignInController signInController = new SignInController(this);
	private QnaController qnaController = new QnaController(this);
	
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
		else if(num==6)
			new EditProfile(this);
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

	public String getCourseOwner(String courseName){
		return global.getCourseByCourseName(courseName).getCourseOwner().getName();
	}

	public String getCourseDesc(String courseName){
		return global.getCourseByCourseName(courseName).getCourseDescription();
	}

	public String[] getCourseJoinedByUser(){
		ArrayList<Course> list=currentUser.getCoursesJoined();
		String[] arrayList=new String[list.size()];
		int i=0;
		for(Course c: list){
			arrayList[i]=c.getCourseName();
			i++;
		}
		return arrayList;
	}

	public boolean determineIfUserAlreadyJoinedCourse(String courseID){
		ArrayList<Course> list=currentUser.getCoursesJoined();
		boolean opt=false;
		for(Course c: list){
			if(c.getCourseID().equals(courseID)){
				opt= true;
				break;
			}else{
				opt= false;
			}
		}
		return opt;
	}

	public void removeCourses(String courseName){
		global.getCourseByCourseName(courseName).removeAllCourseMembers();
		currentUser.leaveCourse(global.getCourseByCourseName(courseName));
		global.deleteCourse(global.getCourseByCourseName(courseName));
	}

	public void leaveCourse(String courseName){
		currentUser.leaveCourse(global.getCourseByCourseName(courseName));
	}

	public void setUserUsername(String username){
		if(currentUser instanceof Student){
			Student student= (Student) currentUser;
			student.setUsername(username);
		}else if(currentUser instanceof Lecturer){
			Lecturer lecturer= (Lecturer) currentUser;
			 lecturer.setUsername(username);
		}
	}

	public void setUserPassword(String password){
		if(currentUser instanceof Student){
			Student student= (Student) currentUser;
			 student.setPassword(password);
		}else if(currentUser instanceof Lecturer){
			Lecturer lecturer= (Lecturer) currentUser;
			 lecturer.setPassword(password);
		}
	}

	public void setUserName(String name){
		if(currentUser instanceof Student){
			Student student= (Student) currentUser;
			student.setName(name);
		}else if(currentUser instanceof Lecturer){
			Lecturer lecturer= (Lecturer) currentUser;
			lecturer.setName(name);
		}
	}

	public void setUserInstitution(String institution){
		if(currentUser instanceof Student){
			Student student= (Student) currentUser;
			student.setInstitution(institution);
		}else if(currentUser instanceof Lecturer){
			Lecturer lecturer= (Lecturer) currentUser;
			lecturer.setInstitution(institution);
		}
	}

	public void setLecturerQualification(String qualification){
		if(currentUser instanceof Lecturer){
			Lecturer lecturer= (Lecturer) currentUser;
			lecturer.setQualification(qualification);
		}
	}

	public void setStudentYear(int year){
		if(currentUser instanceof Student){
			Student student= (Student) currentUser;
			student.setYear(year);
		}
	}

	public void setStudentMajor(String major){
		if(currentUser instanceof Student){
			Student student= (Student) currentUser;
			student.setMajor(major);
		}
	}

	public String getUserUsername(){
		if(currentUser instanceof Student){
			Student student= (Student) currentUser;
			return student.getUsername();
		}else if(currentUser instanceof Lecturer){
			Lecturer lecturer= (Lecturer) currentUser;
			return lecturer.getUsername();
		}
		return null;
	}

	public String getUserPassword(){
		if(currentUser instanceof Student){
			Student student= (Student) currentUser;
			return student.getPassword();
		}else if(currentUser instanceof Lecturer){
			Lecturer lecturer= (Lecturer) currentUser;
			return lecturer.getPassword();
		}
		return null;
	}

	public String getUserName(){
		if(currentUser instanceof Student){
			Student student= (Student) currentUser;
			return student.getName();
		}else if(currentUser instanceof Lecturer){
			Lecturer lecturer= (Lecturer) currentUser;
			return lecturer.getName();
		}
		return null;
	}

	public String getUserInstitution(){
		if(currentUser instanceof Student){
			Student student= (Student) currentUser;
			return student.getInstitution();
		}else if(currentUser instanceof Lecturer){
			Lecturer lecturer= (Lecturer) currentUser;
			return lecturer.getInstitution();
		}
		return null;
	}

	public String getLecturerQualification(){
		if(currentUser instanceof Lecturer){
			Lecturer lecturer= (Lecturer) currentUser;
			return lecturer.getQualification();
		}
		return null;
	}

	public int getStudentYear(){
		if(currentUser instanceof Student){
			Student student= (Student) currentUser;
			return student.getYear();
		}
		return 0;
	}

	public String getStudentMajor(){
		if(currentUser instanceof Student){
			Student student= (Student) currentUser;
			return student.getMajor();
		}
		return null;
	}

	public String determineRole(){
		if(currentUser instanceof Student){
			return "Student";
		}else if(currentUser  instanceof Lecturer){
			return "Lecturer";
		}
		return null;
	}

	public SignInController getSignInController() {
		return signInController;
	}

	public void setSignInController(SignInController signInController) {
		this.signInController = signInController;
	}

	public QnaController getQnaController() {
		return qnaController;
	}

	public void setQnaController(QnaController qnaController) {
		this.qnaController = qnaController;
	}

	public boolean isOwner(String courseName){
		return currentUser.equals(global.getCourseByCourseName(courseName).getCourseOwner());
	}

}
