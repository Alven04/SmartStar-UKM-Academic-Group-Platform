package view;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		int titleFontSize = 48;
		int subtitleHeight = 30;
		int subtitleFontSize = 12;
		int roleTitlePanelHeight = 30;
		int rolePanelHeight = 60;
		int usernamePanelHeight = 30;
		int usernameColumn = 20;
		int passwordPanelHeight = 30;
		int passwordColumn = 20;
		int confirmPasswordPanelHeight = 30;
		int confirmPasswordColumn = 20;
		int buttonPanelHeight = 50;
		int buttonWidth = 100;
		int buttonHeight = 50;
		String font = "Segoe UI";
		int bodyFontSize = 12;
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(screenWidth, screenHeight);
		this.setTitle(frameTitle);
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
//		lbl_title.setAlignmentX(Component.CENTER_ALIGNMENT);
		pnl_subtitle.add(lbl_subtitle);
		
		JPanel pnl_roleTitle = new JPanel();
		pnl_roleTitle.setBounds(0, titleHeight + subtitleHeight, screenWidth, roleTitlePanelHeight);
		pnl_roleTitle.setBackground(Color.GRAY);
		this.add(pnl_roleTitle);
		
		lbl_roleTitle = new JLabel(roleTitle);
		lbl_roleTitle.setFont(new Font(font, Font.BOLD, bodyFontSize));
		pnl_roleTitle.add(lbl_roleTitle);
		
		JPanel pnl_role = new JPanel();
//		pnl_role.setLayout(new GridLayout(2, 1));
		pnl_role.setBounds(0, titleHeight + subtitleHeight + roleTitlePanelHeight, screenWidth, rolePanelHeight);
		pnl_role.setBackground(Color.yellow);
		this.add(pnl_role);
		
		ButtonGroup grp_role = new ButtonGroup();
		
		rad_studentRole = new JRadioButton("Student");
		rad_studentRole.setFont(new Font(font, Font.PLAIN, bodyFontSize));
		grp_role.add(rad_studentRole);
		pnl_role.add(rad_studentRole);
		
		rad_lecturerRole = new JRadioButton("Lecturer");
		rad_lecturerRole.setFont(new Font(font, Font.PLAIN, bodyFontSize));
		grp_role.add(rad_lecturerRole);
		pnl_role.add(rad_lecturerRole);
		
		JPanel pnl_username = new JPanel();
		pnl_username.setBounds(0, titleHeight + subtitleHeight + roleTitlePanelHeight + rolePanelHeight, screenWidth, usernamePanelHeight);
		pnl_username.setBackground(Color.LIGHT_GRAY);
		this.add(pnl_username);

		lbl_username = new JLabel(usernameTitle);
		lbl_username.setFont(new Font(font, Font.BOLD, bodyFontSize));
		pnl_username.add(lbl_username);
		
		txt_username = new JTextField(usernameColumn);
		txt_username.setFont(new Font(font, Font.PLAIN, bodyFontSize));
		pnl_username.add(txt_username);
		
		JPanel pnl_password = new JPanel();
		pnl_password.setBounds(0, titleHeight + subtitleHeight + roleTitlePanelHeight + rolePanelHeight + usernamePanelHeight, screenWidth, passwordPanelHeight);
		pnl_password.setBackground(Color.blue);
		this.add(pnl_password);

		lbl_password = new JLabel(passwordTitle);
		lbl_password.setFont(new Font(font, Font.BOLD, bodyFontSize));
		pnl_password.add(lbl_password);
		
		txt_password = new JTextField(passwordColumn);
		txt_password.setFont(new Font(font, Font.PLAIN, bodyFontSize));
		pnl_password.add(txt_password);
		
		JPanel pnl_confirmPassword = new JPanel();
		pnl_confirmPassword.setBounds(0, titleHeight + subtitleHeight + roleTitlePanelHeight + rolePanelHeight + usernamePanelHeight + passwordPanelHeight, screenWidth, confirmPasswordPanelHeight);
		pnl_confirmPassword.setBackground(Color.blue);
		this.add(pnl_confirmPassword);

		lbl_confirmPassword = new JLabel(confirmPasswordTitle);
		lbl_confirmPassword.setFont(new Font(font, Font.BOLD, bodyFontSize));
		pnl_confirmPassword.add(lbl_confirmPassword);
		
		txt_confirmPassword = new JTextField(confirmPasswordColumn);
		txt_confirmPassword.setFont(new Font(font, Font.PLAIN, bodyFontSize));
		pnl_confirmPassword.add(txt_confirmPassword);

		JPanel pnl_button = new JPanel();
		pnl_button.setBounds(0, titleHeight + subtitleHeight + roleTitlePanelHeight + rolePanelHeight + usernamePanelHeight + passwordPanelHeight + confirmPasswordPanelHeight, screenWidth, buttonPanelHeight);
		pnl_button.setBackground(Color.GREEN);
		this.add(pnl_button);
		
		btn_signUp = new JButton("Sign Up");
		btn_signUp.setFont(new Font(font, Font.PLAIN, bodyFontSize));
		btn_signUp.setSize(buttonWidth, buttonHeight);
		pnl_button.add(btn_signUp);
		btn_signUp.addActionListener(this);
		
		btn_cancel = new JButton("Cancel");
		btn_cancel.setFont(new Font(font, Font.PLAIN, bodyFontSize));
		btn_cancel.setSize(buttonWidth, buttonHeight);
		pnl_button.add(btn_cancel);
		btn_cancel.addActionListener(this);


	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_signUp)) {
			JOptionPane.showMessageDialog(this, "Debug - Sign Up button clicked");
		} else if (e.getSource().equals(btn_cancel)){
			JOptionPane.showMessageDialog(this, "Debug - Cancel button clicked");
		}

		
	}

}
