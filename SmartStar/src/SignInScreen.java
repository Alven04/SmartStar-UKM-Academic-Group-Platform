import javax.swing.JFrame;

public class SignInScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private SignInController controller;
	
	public SignInScreen(SignInController controller) {
		
		this.controller = controller;
		
		String frameTitle = "Sign In - SmartStar";
		
		int screenWidth = 800;
		int screenHeight = 600;

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(screenWidth, screenHeight);
		this.setTitle(frameTitle);
		this.setLayout(null);
		this.setVisible(true);

	}

}
