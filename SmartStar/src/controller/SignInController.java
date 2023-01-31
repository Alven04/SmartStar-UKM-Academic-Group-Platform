package controller;
import model.Global;
import model.Lecturer;
import model.Student;
import view.SignInScreen;
import view.SignUpScreen1;
import view.SplashScreen;

public class SignInController {

	private SplashScreen splashScreen;
	private SignUpScreen1 signUpScreen1;
	private SignInScreen signInScreen;
	
	private Global global = new Global();
	
	public void signUp(boolean isStudent, boolean isLecturer, String username, String password) {
		if (isStudent) {
			global.addUser(new Student(username, password));
		} else if (isLecturer) {
			global.addUser(new Lecturer(username, password));
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
			signUpScreen1 = new SignUpScreen1(this);
		else
			signUpScreen1.setVisible(true);	
	}

	public void displaySignInScreen() {
		if (signInScreen == null)
			signInScreen = new SignInScreen(this);
		else
			signInScreen.setVisible(true);
	}
}
