import controller.SignInController;

public class Main {

	public static void main(String[] args) {
		
		SignInController controller = new SignInController();
		initialize(controller);
		controller.displaySplashScreen();

	}
	
	private static void initialize(SignInController controller) {
		
		controller.signUpStudent("rebekah", "admin", "Rebekah", "UKM", 1, "Computer Science");
		controller.signUpLecturer("hafiz", "password", "Dr Hafiz", "UKM", "Very Good Database Lecturer");
	}

}
