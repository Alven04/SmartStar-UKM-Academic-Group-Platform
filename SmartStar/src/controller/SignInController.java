package controller;
import model.Lecturer;
import model.Student;
import model.User;
import view.SignInScreen;
import view.SignUpScreen;
import view.SplashScreen;

public class SignInController {

	private SplashScreen splashScreen;
	private SignUpScreen signUpScreen1;
	private SignInScreen signInScreen;
	
	private Controller controller;
	
	public SignInController(Controller controller) {
		this.controller = controller;
	}
	
	public Controller getController() {
		return controller;
	}

	public boolean usernameTaken(String username) {
		return controller.getGlobal().getUserByUsername(username) != null;
	}
	
	public boolean passwordValid(String password) {
		return password.length() >= User.MIN_PASSWORD_LENGTH;
	}
	
	public String signUpStudent(String username, String password, String name, String institution, int year, String major) {
		controller.getGlobal().addUser(new Student(username, password, name, institution, year, major));
		return controller.getGlobal().getUserByUsername(username).getUsername();
	}
	
	public String signUpLecturer(String username, String password, String name, String institution, String qualification) {
		controller.getGlobal().addUser(new Lecturer(username, password, name, institution, qualification));
		return controller.getGlobal().getUserByUsername(username).getUsername();
	}

	public boolean signIn(String username, String password) {
		User user = controller.getGlobal().getUserByUsername(username);
		if (user == null) {
			return false;
		} else {
			if (password.equals(user.getPassword())) {
				controller.setCurrentUser(user);
				return true;
			} else {
				return false;
			}
		}
	}
	
	public void displaySplashScreen() {
		if (splashScreen == null)
			splashScreen = new SplashScreen(this);
		else
			splashScreen.setVisible(true);
	}
	
	public void displaySignUpScreen() {
		if (signUpScreen1 == null)
			signUpScreen1 = new SignUpScreen(this);
		else
			signUpScreen1.setVisible(true);	
	}

	public void displaySignInScreen() {
		if (signInScreen == null)
			signInScreen = new SignInScreen(this);
		else
			signInScreen.setVisible(true);
	}
	
	public void displayMainMenu() {
		controller.displayScreen(1);
	}
}
