import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Color;


public class AddCourse extends JFrame implements ActionListener {
	private JButton backBtn,confirmBtn;
	private Controller controller;
	private JTextField courseName;
	private JTextArea courseDescription;
	
	public AddCourse(Controller controller) {
		this.controller= controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SmartStar");
		setSize(700,500);
		setLocationRelativeTo(null);
		setVisible(true);
		Container pane = getContentPane();
		pane.setBackground(new Color(204,204,204));
		pane.setLayout(new BorderLayout());
		
		JLabel label1 =new JLabel("SmartStar Course");
		label1.setForeground(Color.WHITE);
		label1.setFont(new Font("Times New Roman", Font.PLAIN,16));
		
		JLabel lname =new JLabel("Course Name");
		lname.setForeground(Color.RED.darker());
		lname.setFont(new Font("Times New Roman", Font.PLAIN,16));
		
		JLabel ldescription =new JLabel("Description");
		ldescription.setForeground(Color.RED.darker());
		ldescription.setFont(new Font("Times New Roman", Font.PLAIN,16));
		
		courseName=new JTextField(20);
		courseDescription=new JTextArea(5,30);
		
		backBtn=new JButton("Back");
		backBtn.setForeground(new Color(0,0,0));
		confirmBtn=new JButton("Confirm");
		confirmBtn.setForeground(new Color(0,0,0));
		
		JPanel panel1a=new JPanel();
		panel1a.add(label1);
		panel1a.setBackground(new Color(0,0,255));
		
		JPanel panel1=new JPanel(); //title
		panel1.setLayout(new BorderLayout());
		panel1.add(backBtn, BorderLayout.WEST);
		panel1.add(panel1a, BorderLayout.CENTER);
		panel1.setBackground(new Color(0,0,255));
		
		
		JPanel panel2=new JPanel(); //Course Name
		panel2.setLayout(new FlowLayout());
		panel2.add(lname);
		panel2.add(courseName);
		panel2.setBackground(new Color(0,100,155));
		
		JPanel panel3=new JPanel(); //Course Description
		panel3.setLayout(new FlowLayout());
		panel3.add(ldescription);
		panel3.add(courseDescription);
		panel3.setBackground(new Color(0,100,155));
		
		
		JPanel mainPanel=new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(new Color(0,100,155));
		
		mainPanel.add(panel2, BorderLayout.PAGE_START);
		mainPanel.add(panel3, BorderLayout.CENTER);
		mainPanel.add(confirmBtn,BorderLayout.SOUTH);
		
		pane.add(panel1, BorderLayout.PAGE_START);
		pane.add(mainPanel,BorderLayout.CENTER);
		
		backBtn.addActionListener(this);
		confirmBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		this.setVisible(false);
		if(obj.equals(backBtn)) {
			controller.displayScreen(1);
		}
		if(obj.equals(confirmBtn)) {
			controller.setCourseName(courseName.getText());
			controller.setCourseDescription(courseDescription.getText());
			controller.displayScreen(1);
		}
		
	}
}
