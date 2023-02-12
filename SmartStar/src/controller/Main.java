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
	
	// initialize sample user, course, questions for demo purpose only.
	private static void initialize() {
		
		initializeStudent("faris", "admin", "Faris", "USM", 1, "Information Technology");
		initializeStudent("stuart", "handsome", "Stuart", "UM", 2, "Computer Science");
		initializeStudent("alven", "alven", "Alvenlim", "UKM", 2, "Computer Science");
		
		initializeLecturer("hafiz", "password", "Dr Hafiz", "UKM", "Professor");
		initializeLecturer("siti", "12345", "Dr Siti", "UKM", "Professor");
		initializeLecturer("rohizah", "12345", "Dr Rohizah", "UKM", "Assosciate Professor");

		initializeCourse("TK2023", "OOSE", "Learn Software Development Life Cycle", "hafiz", new ArrayList<String>(Arrays.asList("rohizah", "faris", "stuart")));
		initializeCourse("TK1143", "Programming", "Learn Java Programming", "rohizah", new ArrayList<String>(Arrays.asList("siti", "faris", "alven", "stuart")));
		initializeCourse("TK1964", "Database", "Learn Structured Query Language", "siti", new ArrayList<String>(Arrays.asList("hafiz", "faris", "stuart")));
		
		// initialize questions in TK1143
		initializeQuestion("New Line", "I have a string like\n\"I am a boy\"\nI would like to print it this way\n\"I\nam\na\nboy\"\nCan anybody help me?",
				"TK1143", "faris");
		
		String[] upvote01 = {"siti", "faris"};
		String[] downvote01 = {};
		String[] star01 = {"rohizah"};
		initializeAnswer("System.out.println(\"I\\nam\\na\\nboy\");",
				"TK1143", 0, "alven", upvote01, downvote01, star01);

		// initialize questions in TK1964
		initializeQuestion("Database Newbie", "What is a database? And what is SQL language used for? Why are some commercial databases(oracle) really expensive and some are free?",
				"TK1964", "faris");
		
		String[] upvote11 = {"siti", "alven", "faris", "stuart"};
		String[] downvote11 = {};
		String[] star11 = {"siti", "hafiz", "rohizah"};
		initializeAnswer("A database is a place to store data.\n\nSQL or Structured Query Language is a specific language used to do things (query) with the data. This includes things like selecting records created between given dates or updating a record that matches given criteria.",
				"TK1964", 0, "alven", upvote11, downvote11, star11);
		
		String[] upvote12 = {"siti", "alven", "faris", "stuart"};
		String[] downvote12 = {};
		String[] star12 = {};
		initializeAnswer("Databases are the backbone of most of the world at this point, everything is driven by data, every website, every piece of software. This being the case, the database software itself is incredibly valuable. The commercial ones tend to be the ones that are the most stable/best support/best for LARGE data sets.",
				"TK1964", 0, "hafiz", upvote12, downvote12, star12);
		
		String[] upvote13 = {"siti", "alven", "faris", "hafiz", "rohizah"};
		String[] downvote13 = {};	
		String[] star13 = {"hafiz", "rohizah"};
		initializeAnswer("SQL is different from other programming languages. Object oriented languages attempt to model things with objects, procedural languages are a list of instructions, but in SQL you describe the data you want from the database. It's up to the database to figure out how to get that data for you.",
				"TK1964", 0, "stuart", upvote13, downvote13, star13);
		
		initializeQuestion("Microsoft Access", "I am new to database. How do I create a table in Microsoft Access?",
				"TK1964", "stuart");
		
		String[] upvote21 = {"stuart", "rohizah", "siti"};
		String[] downvote21 = {};
		String[] star21 = {"rohizah", "siti", "hafiz"};
		initializeAnswer("Check this out:\nhttps://support.microsoft.com/en-us/office/create-a-database-in-access-f200d95b-e429-4acc-98c1-b883d4e9fc0a",
				"TK1964", 1, "faris", upvote21, downvote21, star21);
		
		// initialize questions in TK2023
		initializeQuestion("Abstraction", "What does 'abstraction' mean in OOP?",
				"TK2023", "faris");
		
		String[] upvote31 = {"faris", "stuart", "alven", "rohizah", "siti", "hafiz"};
		String[] downvote31 = {};
		String[] star31 = {"rohizah", "siti", "hafiz"};
		initializeAnswer("Abstraction is capturing only the essential details about an object that are relevant to a particular perspective, and ignoring the unimportant.\n"
				+ "For example, from a university management’s perspective, important attributes and behaviour of a student should be name, matric number and register a course.",
				"TK2023", 0, "alven", upvote31, downvote31, star31);

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
	
	private static void initializeAnswer(String content, String courseID, int questionID, String ownerUsername, String[] upvoteUsernames, String[] downvoteUsernames, String[] starUsernames) {
		controller.getSignInController().signIn(ownerUsername, controller.getGlobal().getUserByUsername(ownerUsername).getPassword());
		Course course = controller.getGlobal().getCourseByCourseID(courseID);
		Question question = course.getQuestions().get(questionID);
		controller.getQnaController().setCurrentQuestion(question);
		controller.getQnaController().addAnswer(content);
		controller.getQnaController().setCurrentAnswer(question.getAnswers().size() - 1);
		
		for (String username : upvoteUsernames) {
			controller.getSignInController().signIn(username, controller.getGlobal().getUserByUsername(username).getPassword());
			controller.getQnaController().addUpvote();
		}
		
		for (String username : downvoteUsernames) {
			controller.getSignInController().signIn(username, controller.getGlobal().getUserByUsername(username).getPassword());
			controller.getQnaController().addDownvote();
		}
		
		for (String username : starUsernames) {
			controller.getSignInController().signIn(username, controller.getGlobal().getUserByUsername(username).getPassword());
			controller.getQnaController().addStar();
		}
	}
}
