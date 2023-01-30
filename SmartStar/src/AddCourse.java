import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;


public class AddCourse extends JFrame implements ActionListener {
	private JButton backBtn,confirmBtn;
	private JRadioButton privacyPublic,privacyPrivate;
	private ButtonGroup bg;
	private Controller controller;
	private JTextField courseName,courseID;
	private JTextArea courseDescription;
	private JScrollPane scrollPane;
	private JFrame f;
	
	
	public AddCourse(Controller controller) {
		this.controller= controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SmartStar");
		setSize(700,500);
		setLocationRelativeTo(null);
		setVisible(true);
		Container pane = getContentPane();
		pane.setBackground(Color.black);
		pane.setLayout(new BorderLayout());
		
		JLabel label1 =new JLabel("Add New Course");
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Times New Roman", Font.PLAIN,16));
		
		JLabel lname =new JLabel("Course Name :");
		lname.setForeground(Color.BLACK);
		lname.setFont(new Font("Times New Roman", Font.PLAIN,16));
		
		JLabel courseIDLabel =new JLabel("Course ID :");
		courseIDLabel.setForeground(Color.BLACK);
		courseIDLabel.setFont(new Font("Times New Roman", Font.PLAIN,16));
		
		JLabel privacy =new JLabel("Privacy :");
		privacy.setForeground(Color.BLACK);
		privacy.setFont(new Font("Times New Roman", Font.PLAIN,16));
		
		JLabel ldescription =new JLabel("Description :");
		ldescription.setForeground(Color.BLACK);
		ldescription.setFont(new Font("Times New Roman", Font.PLAIN,16));
		
		courseName=new JTextField(20); //courseName TextField
		courseDescription=new JTextArea(5,30);
		scrollPane=new JScrollPane(courseDescription);
		courseID=new JTextField(10); //courseID TextField
		
		backBtn=new JButton("Back");
		backBtn.setForeground(new Color(0,0,0));
		confirmBtn=new JButton("Confirm");
		confirmBtn.setForeground(new Color(0,0,0));
		
		bg=new ButtonGroup();
		privacyPublic=new JRadioButton("Public");
		privacyPublic.setForeground(new Color(0,0,0));
		privacyPrivate=new JRadioButton("Private");
		privacyPrivate.setForeground(new Color(0,0,0));
		bg.add(privacyPublic);
		bg.add(privacyPrivate);
		
		JPanel panel1a=new JPanel();
		panel1a.add(label1);
		panel1a.setBackground(new Color(0,0,255));
		
		JPanel panel1=new JPanel(); //title
		panel1.setLayout(new BorderLayout());
		panel1.add(backBtn, BorderLayout.WEST);
		panel1.add(panel1a, BorderLayout.CENTER);
		panel1.setBackground(new Color(0,0,255));
		
		JPanel panel1b=new JPanel(); //Course ID
		panel1b.add(courseIDLabel);
		panel1b.add(courseID);
		panel1b.setBackground(new Color(0,100,255));
		
		JPanel panel2=new JPanel(); //Course Name
		panel2.add(lname);
		panel2.add(courseName);
		panel2.setBackground(new Color(0,100,255));
		panel2.setSize(10,10);
		
		JPanel panel3=new JPanel(); //Course Name
		panel3.add(privacy);
		panel3.add(privacyPublic);
		panel3.add(privacyPrivate);
		panel3.setBackground(new Color(0,100,255));
		
		JPanel panel4=new JPanel(); //Course Description
		panel4.add(ldescription);
		panel4.add(scrollPane); //make the box fixed
		panel4.setBackground(new Color(0,100,255));
		
		JPanel mainPanel=new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.PAGE_AXIS));
		mainPanel.setBackground(new Color(0,100,255));
		mainPanel.add(panel1b);
		mainPanel.add(panel2);
		mainPanel.add(panel3);
		mainPanel.add(panel4);
		mainPanel.add(confirmBtn);
		
		
		pane.add(panel1, BorderLayout.PAGE_START);
		pane.add(mainPanel,BorderLayout.CENTER);
		
		backBtn.addActionListener(this);
		confirmBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj.equals(backBtn)) {
			this.setVisible(false);
			controller.displayScreen(1);
		}
		if(obj.equals(confirmBtn)) {
			int a=JOptionPane.showConfirmDialog(f, "Add Course?");
			if(a==JOptionPane.YES_OPTION) {
				JOptionPane.showMessageDialog(null, "Your course has been created","Course Created",JOptionPane.PLAIN_MESSAGE);
//				controller.addCourseId(courseID.getText()); //Add course id
//				controller.addCourseName(courseName.getText()); //Add coursename
//				controller.addCourseDescription(courseDescription.getText()); //add coursedesc 
				controller.addCourse(courseID.getText(), courseName.getText(), courseDescription.getText());
//				controller.setCourseOwner(); //set course owner
				this.setVisible(false);
				controller.displayScreen(1);
//				System.out.println(controller.printInformation(controller.getCourseName()));
				System.out.println(controller.printInformation(courseName.getText()));
			}
		}
		
	}
}
