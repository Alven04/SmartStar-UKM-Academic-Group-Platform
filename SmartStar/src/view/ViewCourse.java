package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import controller.Controller;

import java.awt.*;

public class ViewCourse extends JFrame implements ActionListener {
	private JButton backBtn;
	private Controller controller;
	private JLabel title;
	private JPanel panel1;
	private JPanel panel2;
	private JFrame f;
	
	public ViewCourse(Controller controller) {
		this.controller=controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SmartStar");
		setSize(700,500);
		setLocationRelativeTo(null);
		setVisible(true);
		Container pane = getContentPane();
		pane.setBackground(new Color(204,204,204));
		pane.setLayout(new BoxLayout(pane,BoxLayout.X_AXIS));
		
		panel1=new JPanel(new BorderLayout());
		panel1.setBackground(new Color(0,100,255));

		
		title=new JLabel("View Course");
		title.setForeground(Color.WHITE);
		title.setFont(new Font("Times New Roman", Font.PLAIN,16));
		title.setHorizontalAlignment(JLabel.CENTER);
		
		backBtn=new JButton("Back");
		backBtn.setForeground(new Color(0,0,0));
		
		panel1.add(backBtn,BorderLayout.LINE_START);
		panel1.add(title,BorderLayout.CENTER);
		
		
		
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
