import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SplashScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public SplashScreen() {
		
		// GUI IS NOT FINAL, THE COLOUR IS FOR DEBUGGING ONLY, I KNOW IT IS VERY UGLY EWW
		
		int screenWidth = 800;
		int screenHeight = 600;
		int titleHeight = 80;
		int titleFontSize = 48;
		int subtitleHeight = 50;
		int subtitleFontSize = 24;
		int buttonWidth = 100;
		int buttonHeight = 50;
		int buttonFontSize = 18;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(screenWidth, screenHeight);
		this.setTitle("Sign In - SmartStar");
		this.setLayout(null);
		this.setVisible(true);
		
		JPanel pnl_title = new JPanel();
		pnl_title.setBounds(0, 0, screenWidth, titleHeight);
		pnl_title.setBackground(Color.cyan);
		this.add(pnl_title);

		JLabel lbl_title = new JLabel("SmartStar");
		lbl_title.setFont(new Font("Segoe UI", Font.BOLD, titleFontSize));
		lbl_title.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnl_title.add(lbl_title);

		JPanel pnl_subtitle = new JPanel();
		pnl_subtitle.setBounds(0, titleHeight, screenWidth, subtitleHeight);
		pnl_subtitle.setBackground(Color.green);
		this.add(pnl_subtitle);
		
		JLabel lbl_subtitle = new JLabel("by A Team");
		lbl_subtitle.setFont(new Font("Segoe UI", Font.BOLD, subtitleFontSize));
		lbl_title.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnl_subtitle.add(lbl_subtitle);
		
		JPanel pnl_button = new JPanel();
		pnl_button.setBounds(0, titleHeight + subtitleHeight, screenWidth, buttonHeight);
		pnl_button.setBackground(Color.magenta);
		this.add(pnl_button);
		
		JButton btn_signUp = new JButton("Sign Up");
		btn_signUp.setFont(new Font("Segoe UI", Font.PLAIN, buttonFontSize));
		btn_signUp.setSize(buttonWidth, buttonHeight);
		pnl_button.add(btn_signUp);
		
		JButton btn_signIn = new JButton("Sign In");
		btn_signIn.setFont(new Font("Segoe UI", Font.PLAIN, buttonFontSize));
		btn_signIn.setSize(buttonWidth, buttonHeight);
		pnl_button.add(btn_signIn);
	}

}
