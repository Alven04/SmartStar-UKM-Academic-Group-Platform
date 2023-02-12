package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Color;
import controller.Controller;

import java.awt.*;

public class JoinCourse extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton backBtn;
	private Controller controller;
	private JLabel title;
	private JLabel searchCourseLabel;
	private JTextField searchCourseText;
	private JButton searchCourseButton;
	private JPanel panel1;
	private JPanel panel2,panel3,panel4;
	private Border blackline;
	private JFrame f;

	public JoinCourse(Controller controller) {
		blackline = BorderFactory.createLineBorder(Color.black);
		this.controller=controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SmartStar");
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);
		Container pane = getContentPane();
		pane.setLayout(new BoxLayout(pane,BoxLayout.Y_AXIS));
		
		panel1=new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.setAlignmentX(CENTER_ALIGNMENT);
		panel2=new JPanel();
		panel2.setBorder(blackline);
		panel2.setAlignmentX(CENTER_ALIGNMENT);
		panel3=new JPanel();
		panel3.setLayout(new BorderLayout());
		panel4=new JPanel();
		
		title=new JLabel("Join Course");
		title.setForeground(Color.black);
		title.setFont(new Font("SegoeUI", Font.BOLD, 36));
		title.setHorizontalAlignment(JLabel.CENTER);
		
		searchCourseLabel=new JLabel("Join a course by entering the course ID:");
		searchCourseLabel.setForeground(Color.BLACK);
		searchCourseLabel.setFont(new Font("Times New Roman", Font.PLAIN,16));
		
		searchCourseText=new JTextField(20);
		
		searchCourseButton=new JButton("Search");
		searchCourseButton.setForeground(new Color(0,0,0));
		
		backBtn=new JButton("Back");
		backBtn.setForeground(new Color(0,0,0));
		
		panel2.add(searchCourseLabel);
		panel2.add(searchCourseText);
		panel1.add(panel2,BorderLayout.CENTER);
		panel4.add(backBtn);
		panel4.add(searchCourseButton);
		panel3.add(panel4,BorderLayout.CENTER);
		panel4.setAlignmentX(CENTER_ALIGNMENT);
		
		pane.add(title);
		pane.add(panel1);
		pane.add(panel3);
	
		backBtn.addActionListener(this);
		searchCourseButton.addActionListener(this);

		//Color
		panel4.setBackground(new Color(220, 174, 150));
		//panel3.setBackground(new Color(220, 174, 150));
		panel1.setBackground(Color.white);
		panel2.setBackground(Color.white);
		pane.setBackground(new Color(220, 174, 150));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj.equals(backBtn)) {
			this.setVisible(false);
			controller.displayScreen(1);
		}else if(obj.equals(searchCourseButton)){
			if(controller.detetermineCourseExists(searchCourseText.getText())){
				if(controller.determineIfUserAlreadyJoinedCourse(searchCourseText.getText())){
					JOptionPane.showMessageDialog(null, "You have already joined the course","Join Course",JOptionPane.PLAIN_MESSAGE);
					
				}else{
					int a=JOptionPane.showConfirmDialog(f, "Do you wish to join the course?");
					if(a==JOptionPane.YES_OPTION) {
						controller.joinCourse(searchCourseText.getText());
						JOptionPane.showMessageDialog(null, "You have joined the course","Join Course",JOptionPane.PLAIN_MESSAGE);
						setVisible(false);
						controller.displayScreen(1);
					}
				}
			}else{
				JOptionPane.showMessageDialog(null, "Course does not exists","Join Course",JOptionPane.PLAIN_MESSAGE);
			}
		}
		
	}
}
