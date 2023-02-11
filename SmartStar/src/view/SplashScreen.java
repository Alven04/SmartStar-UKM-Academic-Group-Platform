package view;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
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
		
		String frameTitle = "Welcome to SmartStar";
		String title = "SmartStar";
		String subtitle = "by A Team";
		
		int screenWidth = 400;
		int screenHeight = 300;
		int titleFontSize = 48;
		int subtitleFontSize = 24;
		int buttonWidth = 100;
		int buttonHeight = 50;
		int buttonFontSize = 18;
		String font = "Segoe UI";
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(screenWidth, screenHeight);
		setTitle(frameTitle);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);
		
		JPanel pnl_title = new JPanel();
		add(pnl_title, BorderLayout.NORTH);

		lbl_title = new JLabel(title);
		lbl_title.setFont(new Font(font, Font.BOLD, titleFontSize));
		pnl_title.add(lbl_title);
		
		JPanel pnl_body = new JPanel();
		pnl_body.setLayout(new BorderLayout());
		add(pnl_body);

		JPanel pnl_subtitle = new JPanel();
		pnl_body.add(pnl_subtitle, BorderLayout.NORTH);
		
		lbl_subtitle = new JLabel(subtitle);
		lbl_subtitle.setFont(new Font(font, Font.BOLD, subtitleFontSize));
		pnl_subtitle.add(lbl_subtitle);
		
		JPanel pnl_buttonArea = new JPanel(new BorderLayout());
		pnl_body.add(pnl_buttonArea);
		
		JPanel pnl_button = new JPanel();
		pnl_buttonArea.add(pnl_button, BorderLayout.NORTH);
		
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
		
		//Color
		pnl_button.setBackground(new Color(255, 253, 208));
		pnl_buttonArea.setBackground(new Color(255, 253, 208));
		pnl_subtitle.setBackground(new Color(255, 253, 208));
		pnl_title.setBackground(new Color(255, 253, 208));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_signUp)) {
			controller.displaySignUpScreen();
			setVisible(false);
		} else if (e.getSource().equals(btn_signIn)){
			controller.displaySignInScreen();
			setVisible(false);
		}
		
	}

}
