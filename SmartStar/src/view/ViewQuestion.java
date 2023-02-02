package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import controller.Controller;

public class ViewQuestion extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Controller controller;
	
	private int screenWidth = 800;
	private int screenHeight = 600;
	private String frameTitle = "View Question - SmartStar";
	private String title;
	private String font = "SegoeUI";
	private Font titleFont = new Font(font, Font.BOLD, 32);
	private Font headingFont = new Font(font, Font.BOLD, 12);
	private Font bodyFont = new Font(font, Font.PLAIN, 12);

	private JPanel pnl_title = new JPanel();
	private JLabel lbl_title = new JLabel();
	private JButton btn_back = new JButton();
	
	
	private JPanel pnl_list = new JPanel();
	private JPanel pnl_body = new JPanel();
	private JSplitPane spl_question = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnl_list, pnl_body);
	
	private JLabel lbl_list = new JLabel();
	private JList<String> lst_list = new JList<>();
	private JButton btn_post = new JButton();
	
	private JPanel pnl_asker = new JPanel();
	private JLabel lbl_asker = new JLabel();
	private JLabel lbl_askerDetail = new JLabel();
	
	private JPanel pnl_question = new JPanel();
	private JLabel lbl_question = new JLabel();
	private JTextField txt_question = new JTextField();
	private JScrollPane scr_question = new JScrollPane(txt_question);
	
	private JPanel pnl_answer = new JPanel();
	private JPanel pnl_answerBody = new JPanel();
	private JLabel lbl_answerer = new JLabel();
	private JLabel lbl_answererDetail = new JLabel();
	private JTextField txt_answer = new JTextField();
	private JScrollPane scr_answer = new JScrollPane(txt_answer);
	private JPanel pnl_vote = new JPanel();
	private JButton btn_upvote = new JButton();
	private JButton btn_downvote = new JButton();
	private JButton btn_star = new JButton();
	
	private JPanel pnl_index = new JPanel();
	private JButton btn_previous = new JButton();
	private JLabel lbl_index = new JLabel();
	private JButton btn_next = new JButton();
	private JButton btn_postAnswer = new JButton();
	

	public ViewQuestion(Controller controller) {
		
		this.controller = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(screenWidth, screenHeight);
		setTitle(frameTitle);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);

		// title panel
		add(pnl_title, BorderLayout.NORTH);

		pnl_title.setLayout(new BorderLayout(10, 0));
		
		pnl_title.add(createButton(btn_back, "Back"), BorderLayout.WEST);
		
		lbl_title.setText(titleText());
		lbl_title.setFont(titleFont);
		pnl_title.add(lbl_title);
		
		// list panel
		pnl_list.setLayout(new BorderLayout());
		pnl_list.add(btn_back);

	}
	
	public String titleText() {
		return "Course: ";
	}
	
	private JButton createButton(JButton button, String buttonText) {

		button.setText(buttonText);
		button.setFont(bodyFont);
		button.addActionListener(this);
		return button;
	}
	
	private JPanel createLabel(JLabel label, String labelText) {
		JPanel newPanel = new JPanel();

		label.setText(labelText);
		label.setFont(headingFont);
		newPanel.add(label);
		
		return newPanel;
	}
	
	 

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}	

}
