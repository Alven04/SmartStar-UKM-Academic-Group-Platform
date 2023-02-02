import java.util.ArrayList;
import java.util.Arrays;

import controller.Controller;
import controller.QnaController;
import controller.SignInController;

public class Main {

	private static Controller controller = new Controller();
	private static SignInController signIn = new SignInController(controller);
	private static QnaController qna = new QnaController(controller);

	public static void main(String[] args) {
		
		controller.setSignInController(signIn);
		controller.setQnaController(qna);
		initialize();
		signIn.displaySplashScreen();

	}
	
	private static void initialize() {
		
		initializeStudent("rebekah", "admin", "Rebekah", "USM", 1, "Information Technology");
		initializeStudent("stuart", "handsome", "Stuart", "UKM", 2, "Computer Science");
		initializeStudent("alven", "alven", "Alvenlim", "UKM", 2, "Computer Science");
		
		//test only: allows sign in without entering username/password
		initializeStudent("", "", "Speedrunner", "Speedrun school", 9, "Speedrun");
		
		initializeLecturer("hafiz", "password", "Dr Hafiz", "UKM", "Professor");
		initializeLecturer("siti", "12345", "Dr Siti", "UKM", "Professor");
		initializeLecturer("rohizah", "12345", "Dr Rohizah", "UKM", "Assosciate Professor");

		initializeCourse("TK2023", "OOSE", "Learn Software Development Life Cycle", "hafiz", new ArrayList<String>(Arrays.asList("daphne", "rebekah")));
		initializeCourse("TK1143", "Programming", "Learn Java Programming", "rohizah", new ArrayList<String>(Arrays.asList("daphne", "rebekah")));
		initializeCourse("TK1964", "Database", "Learn Structured Query Language", "siti", new ArrayList<String>(Arrays.asList("daphne", "rebekah")));
	}
	
	private static void initializeStudent(String username, String password, String name,
			String institution, int year, String major) {
		signIn.signUpStudent(username, password, name, institution, year, major);
	}

	private static void initializeLecturer(String username, String password, String name,
			String institution, String qualification) {
		signIn.signUpLecturer(username, password, name, institution, qualification);
	}

	private static void initializeCourse(String id, String name, String description, 
			String ownerUsername, ArrayList<String> membersUsername) {
		signIn.signIn(ownerUsername, signIn.getController().getGlobal().getUserByUsername(ownerUsername).getPassword());
		signIn.getController().addCourse(id, name, description);
		for (String member : membersUsername) {
			signIn.signIn(member, signIn.getController().getGlobal().getUserByUsername(member).getPassword());
			signIn.getController().joinCourse(id);
		}
	}
}
