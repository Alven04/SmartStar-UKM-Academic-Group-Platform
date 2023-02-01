package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Controller;

public class CourseMain extends JFrame implements ActionListener {
	private JButton btn1=new JButton("Add New Course");
	private JButton btn2=new JButton("Join Course");
	private JButton btn3=new JButton("View Course");
	
	private Controller controller;
	
	public CourseMain(Controller controller) {
		this.controller= controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SmartStar");
		setSize(800,600);
		setLocationRelativeTo(null);
		setVisible(true);
		
		Container pane = getContentPane();
		pane.setBackground(new Color(255,255,255));
		pane.setLayout(new BorderLayout());
		
		JLabel label1 =new JLabel("SmartStar Course");
		label1.setForeground(Color.black);
		label1.setFont(new Font("SegoeUI", Font.BOLD, 36));
		
		JPanel centerPanel=new JPanel(); //buttons
		centerPanel.setLayout(new BoxLayout(centerPanel ,BoxLayout.Y_AXIS));
		centerPanel.setPreferredSize(new Dimension(150,100));
		
		
		JPanel topPanel=new JPanel(); //title
		topPanel.setLayout(new FlowLayout());
		topPanel.add(label1);
		
		topPanel.setPreferredSize(new Dimension(150,100));
		
		modifyButton(btn1, centerPanel);
		
		modifyButton(btn2, centerPanel);
        modifyButton(btn3, centerPanel);
		
		JPanel leftPanel=new JPanel(); //buttons
		leftPanel.setPreferredSize(new Dimension(100,100));
		
		JPanel rightPanel=new JPanel(); //buttons
		rightPanel.setPreferredSize(new Dimension(100,100));
		
		JPanel bottomPanel=new JPanel(); //buttons
		bottomPanel.setPreferredSize(new Dimension(100,100));
		
		pane.add(topPanel, BorderLayout.NORTH);
		pane.add(centerPanel, BorderLayout.CENTER);
		pane.add(rightPanel, BorderLayout.EAST);
		pane.add(leftPanel, BorderLayout.WEST);
		pane.add(bottomPanel, BorderLayout.SOUTH);
		
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		this.setVisible(false);
		if(obj.equals(btn1)) {
			controller.displayScreen(2);
		}else if(obj.equals(btn2)) {
			controller.displayScreen(3);
		}else if(obj.equals(btn3)) {
			controller.displayScreen(4);
		}
		
	}
	
	private void modifyButton(JButton button, Container container) {
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setForeground(new Color(255,255,255));
		button.setMaximumSize(new Dimension(250,130));
		button.setBackground(new Color(0,0,153));
        container.add(button);
		container.add(Box.createVerticalStrut(15));
        //configure size
         
    }
}
