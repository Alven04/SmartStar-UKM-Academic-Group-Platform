package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.SignInController;

public class SplashScreen extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private SignInController controller;

	private JButton btn_signUp;
	private JButton btn_signIn;
	private JLabel lbl_title;
	private JLabel lbl_subtitle;
	
	public SplashScreen(SignInController controller) {
		
		this.controller = controller;
		
		// GUI IS NOT FINAL, THE COLOUR IS FOR DEBUGGING ONLY, I KNOW IT IS VERY UGLY EWW
		
		String frameTitle = "Welcome to SmartStar";
		String title = "SmartStar";
		String subtitle = "by A Team";
		
		int screenWidth = 800;
		int screenHeight = 600;
		int titleHeight = 80;
		int titleFontSize = 48;
		int subtitleHeight = 50;
		int subtitleFontSize = 24;
		int buttonWidth = 100;
		int buttonHeight = 50;
		int buttonFontSize = 18;
		String font = "Segoe UI";
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(screenWidth, screenHeight);
		this.setTitle(frameTitle);
		setLocationRelativeTo(null);
		this.setLayout(null);
		this.setVisible(true);
		
		JPanel pnl_title = new JPanel();
		pnl_title.setBounds(0, 0, screenWidth, titleHeight);
		pnl_title.setBackground(Color.cyan);
		this.add(pnl_title);

		lbl_title = new JLabel(title);
		lbl_title.setFont(new Font(font, Font.BOLD, titleFontSize));
//		lbl_title.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnl_title.add(lbl_title);

		JPanel pnl_subtitle = new JPanel();
		pnl_subtitle.setBounds(0, titleHeight, screenWidth, subtitleHeight);
		pnl_subtitle.setBackground(Color.green);
		this.add(pnl_subtitle);
		
		lbl_subtitle = new JLabel(subtitle);
		lbl_subtitle.setFont(new Font(font, Font.BOLD, subtitleFontSize));
//		lbl_subtitle.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnl_subtitle.add(lbl_subtitle);
		
		JPanel pnl_button = new JPanel();
		pnl_button.setBounds(0, titleHeight + subtitleHeight, screenWidth, buttonHeight);
		pnl_button.setBackground(Color.magenta);
		this.add(pnl_button);
		
		btn_signUp = new JButton("Sign Up");
		btn_signUp.setFont(new Font(font, Font.PLAIN, buttonFontSize));
		btn_signUp.setSize(buttonWidth, buttonHeight);
		pnl_button.add(btn_signUp);
		btn_signUp.addActionListener(this);
		
		btn_signIn = new JButton("Sign In");
		btn_signIn.setFont(new Font("Segoe UI", Font.PLAIN, buttonFontSize));
		btn_signIn.setSize(buttonWidth, buttonHeight);
		pnl_button.add(btn_signIn);
		btn_signIn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_signUp)) {
			JOptionPane.showMessageDialog(this, "Debug - Sign Up button clicked");
			controller.displaySignUpScreen();
			this.setVisible(false);
		} else if (e.getSource().equals(btn_signIn)){
			JOptionPane.showMessageDialog(this, "Debug - Sign In button clicked");
			controller.displaySignInScreen();
		}
		
	}

}
