package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.Controller;

public class AddAnswer extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Controller controller;

	private int screenWidth = 600;
	private int screenHeight = 400;
	private String frameTitle = "Post Answer - SmartStar";
	private String font = "SegoeUI";
	private Font titleFont = new Font(font, Font.BOLD, 24);
	private Font headingFont = new Font(font, Font.BOLD, 12);
	private Font bodyFont = new Font(font, Font.PLAIN, 12);

	private JPanel pnl_title = new JPanel();
	private JLabel lbl_title = new JLabel();
	private JButton btn_back = new JButton();

	private JPanel pnl_body = new JPanel();

	private JPanel pnl_asker = new JPanel();
	private JLabel lbl_asker = new JLabel();
	private JLabel lbl_askerDetail = new JLabel();
	
	private JPanel pnl_qna = new JPanel();
	
	private JPanel pnl_question = new JPanel();
	private JLabel lbl_question = new JLabel();
	private JTextArea txt_question = new JTextArea();
	private JScrollPane scr_question = new JScrollPane(txt_question);
	
	private JPanel pnl_answer = new JPanel();
	private JPanel pnl_answerer = new JPanel();
	private JLabel lbl_answerer = new JLabel();
	private JLabel lbl_answererDetail = new JLabel();
	private JPanel pnl_answerBody = new JPanel();
	private JLabel lbl_answer = new JLabel();
	private JTextArea txt_answer = new JTextArea();
	private JScrollPane scr_answer = new JScrollPane(txt_answer);
	
	private JPanel pnl_button = new JPanel();
	private JButton btn_post = new JButton();
	private JButton btn_cancel = new JButton();

	public AddAnswer(Controller controller) {
		
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

		// body panel
		add(pnl_body);
		pnl_body.setLayout(new BorderLayout());
		
		pnl_body.add(pnl_asker, BorderLayout.NORTH);
		pnl_asker.setLayout(new BorderLayout());
		pnl_asker.add(createLabel(lbl_asker, askerName()), BorderLayout.NORTH);
		pnl_asker.add(createLabel(lbl_askerDetail, askerDetail()));
		
		pnl_body.add(pnl_qna, BorderLayout.CENTER);
		pnl_qna.setLayout(new GridLayout(2, 1));
		
		pnl_qna.add(pnl_question);
		pnl_question.setLayout(new BorderLayout());
		pnl_question.add(createLabel(lbl_question, questionTitle()), BorderLayout.NORTH);
		pnl_question.add(createNoEditTextArea(txt_question, questionContent(), scr_question));

		pnl_qna.add(pnl_answer);
		
		pnl_answer.setLayout(new BorderLayout());
		pnl_answer.add(pnl_answerBody);
		pnl_answerBody.setLayout(new BorderLayout());
		pnl_answerBody.add(pnl_answerer, BorderLayout.NORTH);
		pnl_answerer.setLayout(new BorderLayout());
		pnl_answerer.add(createLabel(lbl_answerer, answererName()), BorderLayout.NORTH);
		pnl_answerer.add(createLabel(lbl_answererDetail, answererDetail()));
		pnl_answerBody.add(createLabel(lbl_answer, "Type your answer here:"));
		pnl_answerBody.add(createTextArea(txt_answer, answerContent(), scr_answer), BorderLayout.CENTER);

		// button panel
		add(pnl_button, BorderLayout.SOUTH);
		pnl_button.add(createButton(btn_cancel, "Cancel"));
		pnl_button.add(createButton(btn_post, "Post Answer"));

	}
	
	private String answerContent() {
		// TODO Auto-generated method stub
		return "Answer content";
	}

	private String answererDetail() {
		// TODO Auto-generated method stub
		return "Answerer detail";
	}

	private String answererName() {
		// TODO Auto-generated method stub
		return "Answerer name";
	}

	private String questionContent() {
		// TODO Auto-generated method stub
		return "Question content";
	}

	private String questionTitle() {
		// TODO Auto-generated method stub
		return "Question title";
	}

	private String askerDetail() {
		// TODO Auto-generated method stub
		return "Asker detail";
	}

	private String askerName() {
		// TODO Auto-generated method stub
		return "Asker name";
	}

	private String titleText() {
		// TODO Auto-generated method stub
		return "Add Answer - Course: ";
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
	
	private JTextArea createTextArea(JTextArea textArea, String text, JScrollPane scrollPane) {
		textArea.setText(text);
		textArea.setFont(bodyFont);
		textArea.setBorder(BorderFactory.createLineBorder(Color.black));
		scrollPane.add(textArea);
		
		return textArea;
	}
	
	private JTextArea createNoEditTextArea(JTextArea textArea, String text, JScrollPane scrollPane) {
		textArea.setText(text);
		textArea.setFont(bodyFont);
		textArea.setEditable(false);
		scrollPane.add(textArea);
		
		return textArea;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
