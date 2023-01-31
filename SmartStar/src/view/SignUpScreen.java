package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
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
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controller.SignInController;

public class SignUpScreen extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private SignInController controller;
	
	private JPanel pnl_title;
	private JPanel pnl_body;
	private JPanel pnl_detail;
	private JPanel pnl_button;
	private JLabel lbl_title;
	private JLabel lbl_subtitle;
	private JLabel lbl_roleTitle;
	private JLabel lbl_username;
	private JLabel lbl_password;
	private JLabel lbl_confirmPassword;
	private JLabel lbl_year;
	private JLabel lbl_major;
	private JLabel lbl_qualification;
	private JRadioButton rad_studentRole;
	private JRadioButton rad_lecturerRole;
	private ButtonGroup grp_role;
	private JTextField txt_username;
	private JTextField txt_password;
	private JTextField txt_confirmPassword;
	private JTextField txt_major;
	private JTextField txt_qualification;
	private JSpinner spn_year;
	private JButton btn_signUp;
	private JButton btn_cancel;
	private CardLayout crd_detail;
	private String com_student = "STUDENT";
	private String com_lecturer = "LECTURER";
	
	public SignUpScreen(SignInController controller) {
		
		this.controller = controller;
		
		String frameTitle = "Sign Up - SmartStar";
		String title = "Sign Up";
		String subtitle = "Please select your role, then enter your username and password.";
		String roleTitle = "Are you a student or a lecturer?";
		
		int screenWidth = 800;
		int screenHeight = 600;
		int textColumn = 20;
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
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);

		pnl_title = new JPanel();
		pnl_title.setBackground(Color.cyan);
		add(pnl_title, BorderLayout.NORTH);
		
		lbl_title = new JLabel(title);
		lbl_title.setFont(titleFont);
		pnl_title.add(lbl_title);

		pnl_body = new JPanel();
		pnl_body.setLayout(new BoxLayout(pnl_body, BoxLayout.Y_AXIS));
		add(pnl_body);
		
		JPanel pnl_subtitle = new JPanel();
		pnl_subtitle.setBackground(Color.green);
		pnl_body.add(pnl_subtitle);
		
		lbl_subtitle = new JLabel(subtitle);
		lbl_subtitle.setFont(subtitleFont);
		pnl_subtitle.add(lbl_subtitle);
		
		JPanel pnl_roleTitle = new JPanel();
		pnl_roleTitle.setBackground(Color.GRAY);
		pnl_body.add(pnl_roleTitle);
		
		lbl_roleTitle = new JLabel(roleTitle);
		lbl_roleTitle.setFont(headingFont);
		pnl_roleTitle.add(lbl_roleTitle);
		
		JPanel pnl_role = new JPanel();
		pnl_role.setLayout(new BoxLayout(pnl_role, BoxLayout.Y_AXIS));
		pnl_role.setBackground(Color.yellow);
		pnl_body.add(pnl_role);

		grp_role = new ButtonGroup();
		
		rad_studentRole = new JRadioButton("Student");
		rad_studentRole.setFont(bodyFont);
		rad_studentRole.setAlignmentX(Component.CENTER_ALIGNMENT);
		rad_studentRole.addActionListener(this);
		grp_role.add(rad_studentRole);
		pnl_role.add(rad_studentRole);
		
		rad_lecturerRole = new JRadioButton("Lecturer");
		rad_lecturerRole.setFont(bodyFont);
		rad_lecturerRole.setAlignmentX(Component.CENTER_ALIGNMENT);
		rad_lecturerRole.addActionListener(this);
		grp_role.add(rad_lecturerRole);
		pnl_role.add(rad_lecturerRole);
		
		JPanel pnl_login = new JPanel();
		pnl_login.setLayout(new BoxLayout(pnl_login, BoxLayout.Y_AXIS));
		pnl_body.add(pnl_login);
		
		pnl_login.add(createLabelTestFieldPair(lbl_username, "Username:", txt_username, textColumn, bodyFont, headingFont));
		pnl_login.add(createLabelTestFieldPair(lbl_password, "Password:", txt_password, textColumn, bodyFont, headingFont));
		pnl_login.add(createLabelTestFieldPair(lbl_confirmPassword, "Confirm password:", txt_confirmPassword, textColumn, bodyFont, headingFont));

		
		crd_detail = new CardLayout();
		pnl_detail = new JPanel();
		pnl_detail.setBackground(Color.magenta);
		pnl_detail.setLayout(crd_detail);
		pnl_body.add(pnl_detail);
				
		
		JPanel pnl_empty_detail = new JPanel();
		pnl_empty_detail.setBackground(Color.magenta);
		pnl_detail.add(pnl_empty_detail, "EMPTY");
		
		JPanel pnl_student_detail = new JPanel();
		pnl_student_detail.setLayout(new BoxLayout(pnl_student_detail, BoxLayout.Y_AXIS));
		pnl_student_detail.setBackground(Color.ORANGE);
		pnl_detail.add(pnl_student_detail, com_student);
		
		pnl_student_detail.add(createLabelSpinnerPair(lbl_year, "Year:", spn_year, 1, 1, 10, 1, bodyFont, headingFont));
		pnl_student_detail.add(createLabelTestFieldPair(lbl_major, "Major:", txt_major, textColumn, bodyFont, headingFont));
		
		JPanel pnl_lecturer_detail = new JPanel();
		pnl_lecturer_detail.setBackground(Color.cyan);
		pnl_detail.add(pnl_lecturer_detail, com_lecturer);
		
		pnl_lecturer_detail.add(createLabelTestFieldPair(lbl_qualification, "Qualification:", txt_qualification, textColumn, bodyFont, headingFont));
		
		pnl_button = new JPanel();
		pnl_button.setBackground(Color.GREEN);
		pnl_body.add(pnl_button, BorderLayout.SOUTH);
		
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


	private JPanel createLabelTestFieldPair(JLabel label, String labelText, JTextField textField, int textColumn,
			Font bodyFont, Font headingFont) {
		JPanel newPanel = new JPanel();

		label = new JLabel(labelText);
		label.setFont(headingFont);
		newPanel.add(label);
		
		textField = new JTextField(textColumn);
		textField.setFont(bodyFont);
		newPanel.add(textField);
		
		return newPanel;
	}
	
	private JPanel createLabelSpinnerPair(JLabel label, String labelText, JSpinner spinner, int value, int minimum, 
			int maximum, int stepSize, Font bodyFont, Font headingFont) {
		JPanel newPanel = new JPanel();

		label = new JLabel(labelText);
		label.setFont(headingFont);
		newPanel.add(label);
		
		spinner = new JSpinner(new SpinnerNumberModel(value, minimum, maximum, stepSize));
		spinner.setFont(bodyFont);
		newPanel.add(spinner);
		
		return newPanel;
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
		} else if (e.getSource().equals(rad_studentRole)) {
			JOptionPane.showMessageDialog(this, "Debug - Student selected");
			crd_detail.show(pnl_detail, com_student);
		} else if (e.getSource().equals(rad_lecturerRole)) {
			JOptionPane.showMessageDialog(this, "Debug - Lecturer selected");
			crd_detail.show(pnl_detail, com_lecturer);
		}

		
	}

}
