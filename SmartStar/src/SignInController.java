public class SignInController {

	private SplashScreen splashScreen;
	private SignUpScreen1 signUpScreen1;
	private SignInScreen signInScreen;
	
	private Global global = new Global();
	
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
