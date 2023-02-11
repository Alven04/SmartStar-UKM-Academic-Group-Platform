package view;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controller.Controller;

public class EditProfile extends JFrame implements ActionListener {
	private Controller controller;
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
	private JTextField txt_username = new JTextField();
	private JTextField txt_password = new JTextField();
	private JTextField txt_major = new JTextField();
	private JTextField txt_qualification = new JTextField();
	private JTextField txt_name = new JTextField();
	private JTextField txt_institution = new JTextField();
	private JSpinner spn_year = new JSpinner();
	private JButton btn_makechanges;
	private JButton btn_back;
	private CardLayout crd_detail;
	private String com_student = "STUDENT";
	private String com_lecturer = "LECTURER";
	private JFrame f;
	String font = "Segoe UI";
	int bodyFontSize = 16;
	private Font bodyFont = new Font(font, Font.PLAIN, bodyFontSize);
	private Font headingFont = new Font(font, Font.BOLD, bodyFontSize);
	
	public EditProfile(Controller controller) {
		this.controller=controller;
		
		String frameTitle = "Edit Profile - SmartStar";
		String title = "Edit Profile";

		int screenWidth = 800;
		int screenHeight = 600;
		int textColumn = 20;
		int buttonWidth = 100;
		int buttonHeight = 50;
		
		int titleFontSize = 48;
		int subtitleFontSize = 16;

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
		
		JPanel pnl_role = new JPanel();
		pnl_role.setLayout(new BoxLayout(pnl_role, BoxLayout.Y_AXIS));
		pnl_body.add(pnl_role);
        pnl_role.setAlignmentX(CENTER_ALIGNMENT);

        
        lbl_roleTitle=new JLabel("User's Role : "+controller.determineRole());
        lbl_roleTitle.setFont(headingFont);
		pnl_role.add(lbl_roleTitle);

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
		
		btn_makechanges = new JButton("Make Changes");
		btn_makechanges.setFont(bodyFont);
		btn_makechanges.setSize(buttonWidth, buttonHeight);
		pnl_button.add(btn_makechanges);
		btn_makechanges.addActionListener(this);
		
		btn_back = new JButton("Back");
		btn_back.setFont(bodyFont);
		btn_back.setSize(buttonWidth, buttonHeight);
		pnl_button.add(btn_back);
		btn_back.addActionListener(this);
        getUserInformation();

        //Color
		pnl_body.setBackground(new Color(220, 174, 150));
		pnl_empty_detail.setBackground(new Color(220, 174, 150));
		pnl_login.setBackground(new Color(220, 174, 150));
		pnl_role.setBackground(new Color(220, 174, 150));
		pnl_button.setBackground(new Color(220, 174, 150));
		pnl_title.setBackground(new Color(220, 174, 150));
		pnl_lecturer_detail.setBackground(Color.white);
		pnl_detail.setBackground(Color.white);
		
		
	}


	private JPanel createLabelTestFieldPair(JLabel label, String labelText, JTextField textField, int textColumn) {
		JPanel newPanel = new JPanel();

		label = new JLabel(labelText);
		label.setFont(headingFont);
		newPanel.add(label);
		
		textField.setColumns(textColumn);
		textField.setFont(bodyFont);
		newPanel.add(textField);
		newPanel.setBackground(Color.white);
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
		newPanel.setBackground(Color.white);
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

    public void getUserInformation(){
        if (controller.determineRole().equals("Student")) {
            txt_username.setText(controller.getUserUsername());
            txt_password.setText(controller.getUserPassword());
            txt_name.setText(controller.getUserName());
            txt_institution.setText(controller.getUserInstitution());
            spn_year.setValue(controller.getStudentYear());
            txt_major.setText(controller.getStudentMajor());

			crd_detail.show(pnl_detail, com_student);
            
		} else if (controller.determineRole().equals("Lecturer")) {
            txt_username.setText(controller.getUserUsername());
            txt_password.setText(controller.getUserPassword());
            txt_name.setText(controller.getUserName());
            txt_institution.setText(controller.getUserInstitution());
            txt_qualification.setText(controller.getLecturerQualification());
            
			crd_detail.show(pnl_detail, com_lecturer);
		}
        
    }


	@Override
	public void actionPerformed(ActionEvent e) {
        Object obj=e.getSource();
		if(obj.equals(btn_back)) {
			this.setVisible(false);
			controller.displayScreen(1);
		}else if(obj.equals(btn_makechanges)){
            int a=JOptionPane.showConfirmDialog(f, "Do you wish to modify the user's information?");
            if(a==JOptionPane.YES_OPTION){
                JOptionPane.showMessageDialog(null, "Your profile's information have been modified","Edit Profile",JOptionPane.PLAIN_MESSAGE);
                if(controller.determineRole().equals("Student")){
                    controller.setUserUsername(txt_username.getText());
                    controller.setUserPassword(txt_password.getText());
                    controller.setUserName(txt_name.getText());
                    controller.setUserInstitution(txt_institution.getText());
                    int year=(int)spn_year.getValue();
                    controller.setStudentYear(year);
                    controller.setStudentMajor(txt_major.getText());

                    this.setVisible(false);
                    controller.displayScreen(1);

            }else if(controller.determineRole().equals("Lecturer")){
                    controller.setUserUsername(txt_username.getText());
                    controller.setUserPassword(txt_password.getText());
                    controller.setUserName(txt_name.getText());
                    controller.setUserInstitution(txt_institution.getText());
                    controller.setLecturerQualification(txt_qualification.getText());

                    this.setVisible(false);
                    controller.displayScreen(1);
                }
            }
        }
    }

}
