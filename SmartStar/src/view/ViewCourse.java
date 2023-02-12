package view;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controller.Controller;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.*;

public class ViewCourse extends JFrame implements ActionListener {
	private JButton backBtn;
	private Controller controller;
	private JLabel title;
	private JPanel panel1,panel2,panel3;
	private JFrame f;
	private Border raisedbevel;
	private Container pane;
	private int width=800;
	private int height=600;
	
	public ViewCourse(Controller controller) {
		this.controller=controller;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("SmartStar");
		setSize(width,height);
		setLocationRelativeTo(null);
		setVisible(true);
		pane = getContentPane();
		pane.setBackground(new Color(204,204,204));
		pane.setLayout(new BorderLayout());
		
		raisedbevel = BorderFactory.createRaisedBevelBorder();
		
		panel1=new JPanel();
		panel1.setLayout(new BorderLayout());

        
		panel2=new JPanel();
		panel2.setLayout(new BorderLayout());

		
		panel3=new JPanel();
		panel3.setLayout(new BoxLayout(panel3,BoxLayout.X_AXIS));


		title=new JLabel("View Course");
		title.setForeground(Color.BLACK);
		title.setFont(new Font("SegoeUI", Font.BOLD, 32));
		title.setHorizontalAlignment(JLabel.CENTER);
		
		backBtn=new JButton("Back");
		backBtn.setForeground(new Color(0,0,0));

		panel1.add(backBtn,BorderLayout.LINE_START);
		panel1.add(title,BorderLayout.CENTER);
		panel2.add(panel1);

		pane.add(panel2,BorderLayout.NORTH);
		pane.add(panel3,BorderLayout.CENTER);
		backBtn.addActionListener(this);
		listOutAllCourse();
		
		//Color
		panel1.setBackground(new Color(255, 253, 208));
		panel2.setBackground(new Color(255, 253, 208));
		panel3.setBackground(new Color(255, 253, 208));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj=e.getSource();
		if(obj.equals(backBtn)) {
			this.setVisible(false);
			controller.displayScreen(1);
		}
		
	}

    public void listOutAllCourse(){
    	
        for(String courseName: controller.getCourseJoinedByUser() ){
            courseName=courseName.trim();
            JPanel panel=new JPanel();
            panel.setLayout(new BoxLayout(panel,BoxLayout.Y_AXIS));
			panel.setBackground(new Color(220, 174, 150));
			panel.setMaximumSize(new Dimension(200,200));
			
            JLabel courseTitle=new JLabel(courseName);
            courseTitle.setForeground(Color.BLACK);
            courseTitle.setFont(new Font("SegoeUI", Font.BOLD, 25));
            courseTitle.setAlignmentX(Component.CENTER_ALIGNMENT);

			JButton enter=new JButton("Enter Course");
			enter.setForeground(new Color(0,0,0));
			enter.setBackground(new Color(0,255,51));
			enter.setAlignmentX(Component.CENTER_ALIGNMENT);

			String btn_deleteOrLeave="";
			if(controller.isOwner(courseName)==true){
				btn_deleteOrLeave="Delete Course";
			}else{
				btn_deleteOrLeave="Leave Course";
			}
			JButton delete=new JButton(btn_deleteOrLeave);
			delete.setForeground(new Color(0,0,0));
			delete.setBackground(new Color(255,51,51));
            delete.setAlignmentX(Component.CENTER_ALIGNMENT);

            panel.add(courseTitle);
            panel.add(Box.createVerticalStrut(10));
            panel.add(enter);
			panel.add(Box.createVerticalStrut(10));
			panel.add(delete);
            
         	panel.setBorder(raisedbevel);
            panel3.add(Box.createHorizontalStrut(10));
			panel3.add(panel);
			
			enter.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(controller.detetermineCourseExistsByName(courseTitle.getText())){
						controller.getQnaController().displayViewQuestion(controller.getGlobal().getCourseByCourseName(courseTitle.getText()));
						setVisible(false);
					}else{
						JOptionPane.showMessageDialog(null, "Course no longer exists","View Course",JOptionPane.PLAIN_MESSAGE);
					}
				}

			});

			delete.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					if(controller.detetermineCourseExistsByName(courseTitle.getText())){
						if(controller.isOwner(courseTitle.getText())==true){
							int a=JOptionPane.showConfirmDialog(f, "Do you wish to delete the course?");
							if(a==JOptionPane.YES_OPTION){
								JOptionPane.showMessageDialog(null, "You have deleted the course","Leave Course",JOptionPane.PLAIN_MESSAGE);
								String text= courseTitle.getText();
								controller.removeCourses(text);
								panel.removeAll();
								panel3.remove(panel);
								panel3.validate();
								panel3.repaint();
							}
						}else{
							int a=JOptionPane.showConfirmDialog(f, "Do you wish to leave the course?");
							if(a==JOptionPane.YES_OPTION){
								JOptionPane.showMessageDialog(null, "You have left the course","Leave Course",JOptionPane.PLAIN_MESSAGE);
								String text= courseTitle.getText();
								controller.leaveCourse(text);
								panel.removeAll();
								panel3.remove(panel);
								panel3.validate();
								panel3.repaint();
							}
						}
					}else{
						JOptionPane.showMessageDialog(null, "Course no longer exists","View Course",JOptionPane.PLAIN_MESSAGE);
					}

					
					
				}
				
			});
			

        }
		
		
    }

}
