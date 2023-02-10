package controller;
import java.util.ArrayList;
import java.util.Arrays;

import model.Course;
import model.Question;

public class Main {

	private static Controller controller = new Controller();

	public static void main(String[] args) {
		
		initialize();
		controller.getSignInController().displaySplashScreen();

	}
	
	private static void initialize() {
		
		initializeStudent("faris", "admin", "Faris", "USM", 1, "Information Technology");
		initializeStudent("stuart", "handsome", "Stuart", "UM", 2, "Computer Science");
		initializeStudent("alven", "alven", "Alvenlim", "UKM", 2, "Computer Science");
		
		//PLEASE DELETE BEFORE SUBMIT: allows sign in without entering username/password (for debug only)
		initializeStudent("", "", "Speedrunner", "Speedrun school", 9, "Speedrun");
		
		initializeLecturer("hafiz", "password", "Dr Hafiz", "UKM", "Professor");
		initializeLecturer("siti", "12345", "Dr Siti", "UKM", "Professor");
		initializeLecturer("rohizah", "12345", "Dr Rohizah", "UKM", "Assosciate Professor");

		initializeCourse("TK2023", "OOSE", "Learn Software Development Life Cycle", "hafiz", new ArrayList<String>(Arrays.asList("rohizah", "faris", "stuart")));
		initializeCourse("TK1143", "Programming", "Learn Java Programming", "rohizah", new ArrayList<String>(Arrays.asList("siti", "faris", "alven", "stuart")));
		initializeCourse("TK1964", "Database", "Learn Structured Query Language", "siti", new ArrayList<String>(Arrays.asList("hafiz", "faris", "stuart")));
		
		initializeQuestion("Database Newbie", "What is a database? And what is SQL language used for? Why are some commercial databases(oracle) really expensive and some are free?",
				"TK1964", "faris");
		initializeAnswer("A database is a place to store data.\n\nSQL or Structured Query Language is a specific language used to do things (query) with the data. This includes things like selecting records created between given dates or updating a record that matches given criteria.",
				"TK1964", 0, "hafiz");
		initializeAnswer("Databases are the backbone of most of the world at this point, everything is driven by data, every website, every piece of software. This being the case, the database software itself is incredibly valuable. The commercial ones tend to be the ones that are the most stable/best support/best for LARGE data sets.",
				"TK1964", 0, "hafiz");
		initializeAnswer("SQL is different from other programming languages. Object oriented languages attempt to model things with objects, procedural languages are a list of instructions, but in SQL you describe the data you want from the database. It's up to the database to figure out how to get that data for you.",
				"TK1964", 0, "stuart");

		initializeQuestion("Microsoft Access", "I am new to database. How do I create a table in Microsoft Access?",
				"TK1964", "stuart");
		initializeAnswer("Check this out:\nhttps://support.microsoft.com/en-us/office/create-a-database-in-access-f200d95b-e429-4acc-98c1-b883d4e9fc0a",
				"TK1964", 1, "hafiz");
	}
	
	private static void initializeStudent(String username, String password, String name, String institution, int year, String major) {
		controller.getSignInController().signUpStudent(username, password, name, institution, year, major);
	}

	private static void initializeLecturer(String username, String password, String name,
			String institution, String qualification) {
		controller.getSignInController().signUpLecturer(username, password, name, institution, qualification);
	}

	private static void initializeCourse(String id, String name, String description, 
			String ownerUsername, ArrayList<String> membersUsername) {
		controller.getSignInController().signIn(ownerUsername, controller.getGlobal().getUserByUsername(ownerUsername).getPassword());
		controller.addCourse(id, name, description);
		for (String member : membersUsername) {
			controller.getSignInController().signIn(member, controller.getGlobal().getUserByUsername(member).getPassword());
			controller.joinCourse(id);
		}
	}
	
	private static void initializeQuestion(String title, String content, String courseID, String ownerUsername) {
		controller.getSignInController().signIn(ownerUsername, controller.getGlobal().getUserByUsername(ownerUsername).getPassword());
		Course course = controller.getGlobal().getCourseByCourseID(courseID);
		controller.getQnaController().setCourse(course);
		controller.getQnaController().addQuestion(title, content);
	}
	
	private static void initializeAnswer(String content, String courseID, int questionID, String ownerUsername) {
		controller.getSignInController().signIn(ownerUsername, controller.getGlobal().getUserByUsername(ownerUsername).getPassword());
		Course course = controller.getGlobal().getCourseByCourseID(courseID);
		Question question = course.getQuestions().get(questionID);
		controller.getQnaController().setCurrentQuestion(question);
		controller.getQnaController().addAnswer(content);
	}
}
