import java.util.ArrayList;
import java.util.Arrays;

import controller.Controller;

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
		initializeCourse("TK1964", "Database", "Learn Structured Query Language", "siti", new ArrayList<String>(Arrays.asList("hafiz", "faris")));
	}
	
	private static void initializeStudent(String username, String password, String name,
			String institution, int year, String major) {
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
}
