package view;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Color;
import controller.Controller;

import java.awt.Color;


public class AddCourse extends JFrame implements ActionListener {
	private JButton btn_back,btn_confirm;
	private Controller controller;
	private JTextField txt_courseName,txt_courseID;
	private JTextArea txt_courseDescription;
	private JScrollPane scrollPane;
	private JFrame f;
	private JPanel titlePanel;
	private JPanel bodyPanel;
	private JLabel titleLabel=new JLabel("Add New Course");
	private JLabel courseNameLabel =new JLabel("Course Name :");
	private JLabel courseIDLabel =new JLabel("Course ID :");
	private JLabel courseDescriptionLabel =new JLabel("Description :");
	private Border blackline;
	
	String font = "Segoe UI";
	int bodyFontSize = 16;
	private Font bodyFont = new Font(font, Font.PLAIN, bodyFontSize);
	private Font headingFont = new Font(font, Font.BOLD, bodyFontSize);

	public AddCourse(Controller controller) {
		blackline = BorderFactory.createLineBorder(Color.black);
		this.controller= controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SmartStar");
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);
		Container pane = getContentPane();
		pane.setBackground(Color.black);
		pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
		
		titleLabel.setForeground(Color.black);
		titleLabel.setFont(new Font("SegoeUI", Font.BOLD, 48));
		courseNameLabel.setForeground(Color.BLACK);
		courseNameLabel.setFont(new Font("SegoeUI", Font.BOLD,16));
		courseIDLabel.setForeground(Color.BLACK);
		courseIDLabel.setFont(new Font("SegoeUI", Font.BOLD,16));
		courseDescriptionLabel.setForeground(Color.BLACK);
		courseDescriptionLabel.setFont(new Font("SegoeUI", Font.BOLD,16));
		
		txt_courseName=new JTextField(20); //courseName TextField
		txt_courseDescription=new JTextArea(5,30);
		scrollPane=new JScrollPane(txt_courseDescription);
		txt_courseID=new JTextField(20); //courseID TextField
		
		btn_back=new JButton("Back");
		btn_back.setForeground(new Color(0,0,0));
		btn_confirm=new JButton("Confirm");
		btn_confirm.setForeground(new Color(0,0,0));
		btn_confirm.setAlignmentX(CENTER_ALIGNMENT);

		titlePanel=new JPanel();
		bodyPanel=new JPanel();
		bodyPanel.setLayout(new BorderLayout());

		JPanel titleSubPanel=new JPanel(); //buttons
		titleSubPanel.add(titleLabel);

		JPanel subPanel=new JPanel(); //buttons
		subPanel.setLayout(new BoxLayout(subPanel ,BoxLayout.Y_AXIS));
		subPanel.setBackground(Color.WHITE);
		subPanel.setBorder(blackline);

		JPanel buttonPanel=new JPanel(); //buttons
		buttonPanel.add(btn_back);
		buttonPanel.add(btn_confirm);


		subPanel.add(createLabelTestFieldPair(courseNameLabel,"Course Name: ",txt_courseName,20));
		subPanel.add(createLabelTestFieldPair(courseIDLabel,"Course ID: ",txt_courseID,20));

		JPanel desc_panel=new JPanel(); //Course Description
		desc_panel.add(courseDescriptionLabel);
		desc_panel.add(scrollPane); //make the box fixed
		subPanel.add(desc_panel);
		titlePanel.add(titleSubPanel);
		bodyPanel.add(subPanel,BorderLayout.CENTER);
		pane.add(titlePanel);
		pane.add(bodyPanel);
		pane.add(buttonPanel);
		btn_back.addActionListener(this);
		btn_confirm.addActionListener(this);
		//Color
		titlePanel.setBackground(new Color(220, 174, 150));
		titleSubPanel.setBackground(new Color(220, 174, 150));
		buttonPanel.setBackground(new Color(220, 174, 150));
		bodyPanel.setBackground(Color.white);
		subPanel.setBackground(Color.white);
		desc_panel.setBackground(Color.white);

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

	

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj.equals(btn_back)) {
			this.setVisible(false);
			controller.displayScreen(1);
		}
		if(obj.equals(btn_confirm)) {
			int a=JOptionPane.showConfirmDialog(f, "Add Course?");
			if(a==JOptionPane.YES_OPTION) {
				if(controller.detetermineCourseExists(txt_courseID.getText())!=true){
					JOptionPane.showMessageDialog(null, "Your course has been created","Course Created",JOptionPane.PLAIN_MESSAGE);
					controller.addCourse(txt_courseID.getText(), txt_courseName.getText(), txt_courseDescription.getText());
					this.setVisible(false);
					controller.displayScreen(1);
				}else{
					JOptionPane.showMessageDialog(null, "Course already exists","Course Created",JOptionPane.PLAIN_MESSAGE);
				}
				
			}
		}
		
	}

}
