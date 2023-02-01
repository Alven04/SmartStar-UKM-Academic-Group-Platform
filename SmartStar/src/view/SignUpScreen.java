package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
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
	private JLabel lbl_year;
	private JLabel lbl_major;
	private JLabel lbl_qualification;
	private JLabel lbl_name;
	private JLabel lbl_institution;
	private JRadioButton rad_studentRole;
	private JRadioButton rad_lecturerRole;
	private ButtonGroup grp_role;
	private JTextField txt_username = new JTextField();
	private JTextField txt_password = new JTextField();
	private JTextField txt_major = new JTextField();
	private JTextField txt_qualification = new JTextField();
	private JTextField txt_name = new JTextField();
	private JTextField txt_institution = new JTextField();
	private JSpinner spn_year = new JSpinner();
	private JButton btn_signUp;
	private JButton btn_cancel;
	private CardLayout crd_detail;
	private String com_student = "STUDENT";
	private String com_lecturer = "LECTURER";
	
	String font = "Segoe UI";
	int bodyFontSize = 12;
	private Font bodyFont = new Font(font, Font.PLAIN, bodyFontSize);
	private Font headingFont = new Font(font, Font.BOLD, bodyFontSize);
	
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
		
		int titleFontSize = 48;
		int subtitleFontSize = 12;

		Font titleFont = new Font(font, Font.BOLD, titleFontSize);
		Font subtitleFont = new Font(font, Font.BOLD, subtitleFontSize);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(screenWidth, screenHeight);
		setTitle(frameTitle);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);

		pnl_title = new JPanel();
		add(pnl_title, BorderLayout.NORTH);
		
		lbl_title = new JLabel(title);
		lbl_title.setFont(titleFont);
		pnl_title.add(lbl_title);

		pnl_body = new JPanel();
		pnl_body.setLayout(new BoxLayout(pnl_body, BoxLayout.Y_AXIS));
		add(pnl_body);
		
		JPanel pnl_subtitle = new JPanel();
		pnl_body.add(pnl_subtitle);
		
		lbl_subtitle = new JLabel(subtitle);
		lbl_subtitle.setFont(subtitleFont);
		pnl_subtitle.add(lbl_subtitle);
		
		JPanel pnl_roleTitle = new JPanel();
		pnl_body.add(pnl_roleTitle);
		
		lbl_roleTitle = new JLabel(roleTitle);
		lbl_roleTitle.setFont(headingFont);
		pnl_roleTitle.add(lbl_roleTitle);
		
		JPanel pnl_role = new JPanel();
		pnl_role.setLayout(new BoxLayout(pnl_role, BoxLayout.Y_AXIS));
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
		
		pnl_login.add(createLabelTestFieldPair(lbl_username, "Username:", txt_username, textColumn));
		pnl_login.add(createLabelTestFieldPair(lbl_password, "Password:", txt_password, textColumn));
		pnl_login.add(createLabelTestFieldPair(lbl_name, "Name:", txt_name, textColumn));
		pnl_login.add(createLabelTestFieldPair(lbl_institution, "Institution:", txt_institution, textColumn));

		
		crd_detail = new CardLayout();
		pnl_detail = new JPanel();
		pnl_detail.setLayout(crd_detail);
		pnl_body.add(pnl_detail);
				
		
		JPanel pnl_empty_detail = new JPanel();
		pnl_detail.add(pnl_empty_detail, "EMPTY");
		
		JPanel pnl_student_detail = new JPanel();
		pnl_student_detail.setLayout(new BoxLayout(pnl_student_detail, BoxLayout.Y_AXIS));
		pnl_detail.add(pnl_student_detail, com_student);
		
		pnl_student_detail.add(createLabelSpinnerPair(lbl_year, "Year:", spn_year, 1, 1, 10, 1));
		pnl_student_detail.add(createLabelTestFieldPair(lbl_major, "Major:", txt_major, textColumn));
		
		JPanel pnl_lecturer_detail = new JPanel();
		pnl_detail.add(pnl_lecturer_detail, com_lecturer);
		
		pnl_lecturer_detail.add(createLabelTestFieldPair(lbl_qualification, "Qualification:", txt_qualification, textColumn));
		
		pnl_button = new JPanel();
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


	private JPanel createLabelTestFieldPair(JLabel label, String labelText, JTextField textField, int textColumn) {
		JPanel newPanel = new JPanel();

		label = new JLabel(labelText);
		label.setFont(headingFont);
		newPanel.add(label);
		
		textField.setColumns(textColumn);
		textField.setFont(bodyFont);
		newPanel.add(textField);
		
		return newPanel;
	}
	
	private JPanel createLabelSpinnerPair(JLabel label, String labelText, JSpinner spinner, int value, int minimum, 
			int maximum, int stepSize) {
		JPanel newPanel = new JPanel();

		label = new JLabel(labelText);
		label.setFont(headingFont);
		newPanel.add(label);
		
		spinner.setModel((new SpinnerNumberModel(value, minimum, maximum, stepSize)));
		spinner.setFont(bodyFont);
		newPanel.add(spinner);
		
		return newPanel;
	}

	private void showUserCreatedMessage(String newUser) {
		if (newUser != null) {
			JOptionPane.showMessageDialog(this, "Your user account \"" + newUser  + "\" has been created. Welcome to SmartStar!");					
		} else {
			JOptionPane.showMessageDialog(this, "An error occured.");
		}
	}
	
	private void clearField() {
		txt_username.setText("");
		txt_password.setText("");
		txt_name.setText("");
		txt_institution.setText("");
		txt_qualification.setText("");
		txt_major.setText("");
		spn_year.setValue(1);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_signUp)) {

			if (controller.usernameTaken(txt_username.getText())) {
				JOptionPane.showMessageDialog(this, "The username has been taken. Please choose another username.");
			}
			else if (!controller.passwordValid(txt_password.getText())) {
				JOptionPane.showMessageDialog(this, "Invalid password. Your password should be at least 5 characters long.");
			}
			else if (rad_studentRole.isSelected()) {

				// save the value in spn_year
				try {
					spn_year.commitEdit();
				} catch (java.text.ParseException ex) {
					JOptionPane.showMessageDialog(this, "Error: Make sure \"Year\" is a number.");
				}

				int year = (int) spn_year.getValue();

				String newUser = controller.signUpStudent(txt_username.getText(), txt_password.getText(), txt_name.getText(),
						txt_institution.getText(), year, txt_major.getText());

				showUserCreatedMessage(newUser);
				
				clearField();
				setVisible(false);
				controller.displaySplashScreen();
			}
			else if (rad_lecturerRole.isSelected()) {

				String newUser = controller.signUpLecturer(txt_username.getText(), txt_password.getText(), txt_name.getText(),
						txt_institution.getText(), txt_qualification.getText());
				
				showUserCreatedMessage(newUser);
				
				clearField();
				setVisible(false);
				controller.displaySplashScreen();
			}
			else {		
				JOptionPane.showMessageDialog(this, "Please select a role (Student or Lecturer).");
			}

		} else if (e.getSource().equals(btn_cancel)){
			controller.displaySplashScreen();
			setVisible(false);
			
		} else if (e.getSource().equals(rad_studentRole)) {
			crd_detail.show(pnl_detail, com_student);
		} else if (e.getSource().equals(rad_lecturerRole)) {
			crd_detail.show(pnl_detail, com_lecturer);
		}

		
	}

}
