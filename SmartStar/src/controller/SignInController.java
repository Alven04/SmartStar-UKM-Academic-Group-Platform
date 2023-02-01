package controller;
import model.Global;
import model.Lecturer;
import model.Student;
import model.User;
import view.SignInScreen;
import view.SignUpScreen;
import view.SplashScreen;

public class SignInController {

	private int minPasswordLength = 5;
	
	
	private SplashScreen splashScreen;
	private SignUpScreen signUpScreen1;
	private SignInScreen signInScreen;
	
	private Global global = new Global();

	private Controller controller;
	
	
	public boolean usernameTaken(String username) {
		return global.getUserByUsername(username) != null;
	}
	
	public boolean passwordValid(String password) {
		return password.length() >= minPasswordLength;
	}
	
	public String signUpStudent(String username, String password, String name, String institution, int year, String major) {
		global.addUser(new Student(username, password, name, institution, year, major));
		return global.getUserByUsername(username).getUsername();
	}
	
	public String signUpLecturer(String username, String password, String name, String institution, String qualification) {
		global.addUser(new Lecturer(username, password, name, institution, qualification));
		return global.getUserByUsername(username).getUsername();
	}

	public boolean signIn(String username, String password) {
		User user = global.getUserByUsername(username);
		if (user == null) {
			return false;
		} else {
			return password.equals(user.getPassword());
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
		controller = new Controller(global);
		controller.displayScreen(1);
	}
}
