import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.*;

public class JoinCourse extends JFrame implements ActionListener {
	private JButton backBtn;
	private Controller controller;
	private JLabel title;
	private JLabel searchCourseLabel;
	private JTextField searchCourseText;
	private JButton searchCourseButton;
	private JPanel panel1;
	private JPanel panel2;
	
	public JoinCourse(Controller controller) {
		this.controller=controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SmartStar");
		setSize(700,500);
		setLocationRelativeTo(null);
		setVisible(true);
		Container pane = getContentPane();
		pane.setBackground(new Color(204,204,204));
		pane.setLayout(new BorderLayout());
		
		panel1=new JPanel(new BorderLayout());
		panel1.setBackground(new Color(0,100,255));
		panel2=new JPanel(new FlowLayout());
		panel2.setBackground(new Color(0,100,255));
		
		title=new JLabel("Join Course");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Times New Roman", Font.PLAIN,16));
		title.setHorizontalAlignment(JLabel.CENTER);
		
		searchCourseLabel=new JLabel("Join a course by entering the course ID:");
		searchCourseLabel.setForeground(Color.BLACK);
		searchCourseLabel.setFont(new Font("Times New Roman", Font.PLAIN,16));
		
		searchCourseText=new JTextField(20);
		
		searchCourseButton=new JButton("Search");
		searchCourseButton.setForeground(new Color(0,0,0));
		
		backBtn=new JButton("Back");
		backBtn.setForeground(new Color(0,0,0));
		
		panel1.add(backBtn,BorderLayout.LINE_START);
		panel1.add(title,BorderLayout.CENTER);
		panel2.add(searchCourseLabel);
		panel2.add(searchCourseText);
		panel2.add(searchCourseButton);
		
		
		pane.add(panel1,BorderLayout.PAGE_START);
		pane.add(panel2,BorderLayout.CENTER);
		
		backBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj.equals(backBtn)) {
			this.setVisible(false);
			controller.displayScreen(1);
		}
		
	}
}
