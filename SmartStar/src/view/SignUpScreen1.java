package view;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import controller.SignInController;

public class SignUpScreen1 extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private SignInController controller;
	
	private JLabel lbl_title;
	private JLabel lbl_subtitle;
	private JLabel lbl_roleTitle;
	private JLabel lbl_username;
	private JLabel lbl_password;
	private JLabel lbl_confirmPassword;
	private JRadioButton rad_studentRole;
	private JRadioButton rad_lecturerRole;
	private ButtonGroup grp_role;
	private JTextField txt_username;
	private JTextField txt_password;
	private JTextField txt_confirmPassword;
	private JButton btn_signUp;
	private JButton btn_cancel;
	
	public SignUpScreen1(SignInController controller) {
		
		this.controller = controller;
		
		String frameTitle = "Sign Up - SmartStar";
		String title = "Sign Up";
		String subtitle = "Please select your role, then enter your username and password.";
		String roleTitle = "Are you a student or a lecturer?";
		String usernameTitle = "Username:";
		String passwordTitle = "Password:";
		String confirmPasswordTitle = "Confirm password:";
		
		int screenWidth = 800;
		int screenHeight = 600;
		int titleHeight = 80;
		int subtitleHeight = 30;
		int roleTitlePanelHeight = 30;
		int rolePanelHeight = 60;
		int textPanelHeight = 90;
		int textColumn = 20;
		int buttonPanelHeight = 50;
		int buttonWidth = 100;
		int buttonHeight = 50;
		
		String font = "Segoe UI";
		int titleFontSize = 48;
		int subtitleFontSize = 12;
		int bodyFontSize = 12;

		Font titleFont = new Font(font, Font.BOLD, titleFontSize);
		Font subtitleFont = new Font(font, Font.BOLD, subtitleFontSize);
		Font bodyFont = new Font(font, Font.PLAIN, bodyFontSize);
		Font headingFont = new Font(font, Font.BOLD, bodyFontSize);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(screenWidth, screenHeight);
		setTitle(frameTitle);
		setLayout(null);
		setVisible(true);

		JPanel pnl_title = new JPanel();
		pnl_title.setBounds(0, 0, screenWidth, titleHeight);
		pnl_title.setBackground(Color.cyan);
		add(pnl_title);
		
		lbl_title = new JLabel(title);
		lbl_title.setFont(titleFont);
//		lbl_title.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnl_title.add(lbl_title);

		JPanel pnl_subtitle = new JPanel();
		pnl_subtitle.setBounds(0, titleHeight, screenWidth, subtitleHeight);
		pnl_subtitle.setBackground(Color.green);
		add(pnl_subtitle);
		
		lbl_subtitle = new JLabel(subtitle);
		lbl_subtitle.setFont(subtitleFont);
//		lbl_title.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnl_subtitle.add(lbl_subtitle);
		
		JPanel pnl_roleTitle = new JPanel();
		pnl_roleTitle.setBounds(0, titleHeight + subtitleHeight, screenWidth, roleTitlePanelHeight);
		pnl_roleTitle.setBackground(Color.GRAY);
		add(pnl_roleTitle);
		
		lbl_roleTitle = new JLabel(roleTitle);
		lbl_roleTitle.setFont(headingFont);
		pnl_roleTitle.add(lbl_roleTitle);
		
//		JPanel pnl_role = new JPanel();
////		pnl_role.setLayout(new GridLayout(2, 1));
//		pnl_role.setBounds(0, titleHeight + subtitleHeight + roleTitlePanelHeight, screenWidth, rolePanelHeight);
//		pnl_role.setBackground(Color.yellow);
//		add(pnl_role);
		
		JPanel pnl_role = new JPanel();
		pnl_role.setLayout(new BoxLayout(pnl_role, BoxLayout.Y_AXIS));
		pnl_role.setBounds(0, titleHeight + subtitleHeight + roleTitlePanelHeight, screenWidth, rolePanelHeight);
		pnl_role.setBackground(Color.yellow);
		add(pnl_role);

		
		grp_role = new ButtonGroup();
		
		rad_studentRole = new JRadioButton("Student");
		rad_studentRole.setFont(bodyFont);
		rad_studentRole.setAlignmentX(Component.CENTER_ALIGNMENT);
		grp_role.add(rad_studentRole);
		pnl_role.add(rad_studentRole);
		
		rad_lecturerRole = new JRadioButton("Lecturer");
		rad_lecturerRole.setFont(bodyFont);
		rad_lecturerRole.setAlignmentX(Component.CENTER_ALIGNMENT);
		grp_role.add(rad_lecturerRole);
		pnl_role.add(rad_lecturerRole);
		
		JPanel pnl_login = new JPanel();
		pnl_login.setBounds(0, titleHeight + subtitleHeight + roleTitlePanelHeight + rolePanelHeight, screenWidth, textPanelHeight);
		pnl_login.setLayout(new BoxLayout(pnl_login, BoxLayout.Y_AXIS));
		pnl_login.setBackground(Color.LIGHT_GRAY);
		add(pnl_login);
		
		JPanel pnl_username = new JPanel();
		pnl_login.add(pnl_username);

		lbl_username = new JLabel(usernameTitle);
		lbl_username.setFont(headingFont);
		pnl_username.add(lbl_username);
		
		txt_username = new JTextField(textColumn);
		txt_username.setFont(bodyFont);
		pnl_username.add(txt_username);
		
		JPanel pnl_password = new JPanel();
		pnl_login.add(pnl_password);

		lbl_password = new JLabel(passwordTitle);
		lbl_password.setFont(headingFont);
		pnl_password.add(lbl_password);
		
		txt_password = new JTextField(textColumn);
		txt_password.setFont(bodyFont);
		pnl_password.add(txt_password);
		
		JPanel pnl_confirmPassword = new JPanel();
		pnl_login.add(pnl_confirmPassword);

		lbl_confirmPassword = new JLabel(confirmPasswordTitle);
		lbl_confirmPassword.setFont(headingFont);
		pnl_confirmPassword.add(lbl_confirmPassword);
		
		txt_confirmPassword = new JTextField(textColumn);
		txt_confirmPassword.setFont(bodyFont);
		pnl_confirmPassword.add(txt_confirmPassword);

		JPanel pnl_button = new JPanel();
		pnl_button.setBounds(0, titleHeight + subtitleHeight + roleTitlePanelHeight + rolePanelHeight + textPanelHeight, screenWidth, buttonPanelHeight);
		pnl_button.setBackground(Color.GREEN);
		add(pnl_button);
		
		btn_signUp = new JButton("Sign Up");
		btn_signUp.setFont(bodyFont);
		btn_signUp.setSize(buttonWidth, buttonHeight);
		pnl_button.add(btn_signUp);
		btn_signUp.addActionListener(this);
		
		btn_cancel = new JButton("Cancel");
		btn_cancel.setFont(bodyFont);
		btn_cancel.setSize(buttonWidth, buttonHeight);
		pnl_button.add(btn_cancel);
		btn_cancel.addActionListener(this);


	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_signUp)) {
			JOptionPane.showMessageDialog(this, "Debug - Sign Up button clicked");
			controller.signUp(rad_studentRole.isSelected(), rad_lecturerRole.isSelected(), txt_username.getText(), txt_password.getText());
			
		} else if (e.getSource().equals(btn_cancel)){
			JOptionPane.showMessageDialog(this, "Debug - Cancel button clicked");
			controller.displaySplashScreen();
			setVisible(false);
		}

		
	}

}
