import java.util.ArrayList;
import java.util.Arrays;

import controller.Controller;
import controller.SignInController;

public class Main {

	private static Controller controller = new Controller();
	private static SignInController signIn = new SignInController(controller);

	public static void main(String[] args) {
		
		initialize();
		signIn.displaySplashScreen();
//		new ViewQuestion(null);
	}
	
	private static void initialize() {
		
		initializeStudent("rebekah", "admin", "Rebekah", "UKM", 1, "Computer Science");
		initializeStudent("daphne", "daphnee", "Daphne", "USM", 2, "Computer Science");
		initializeLecturer("hafiz", "password", "Dr Hafiz", "UKM", "Very Good Database Lecturer");
		initializeCourse("TK1143", "Programming", "Learn Java Programming", "hafiz", new ArrayList<String>(Arrays.asList("daphne", "rebekah")));
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
