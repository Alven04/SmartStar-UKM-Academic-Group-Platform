package view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import controller.QnaController;
import model.Course;

public class ViewQuestion extends JFrame implements ActionListener, ListSelectionListener {

	private static final long serialVersionUID = 1L;
	private QnaController controller;
	private Course course;
	
	private int screenWidth = 800;
	private int screenHeight = 600;
	private String frameTitle = "View Question - SmartStar";
	private String font = "SegoeUI";
	private Font titleFont = new Font(font, Font.BOLD, 24);
	private Font headingFont = new Font(font, Font.BOLD, 12);
	private Font bodyFont = new Font(font, Font.PLAIN, 12);

	private JPanel pnl_title = new JPanel();
	private JLabel lbl_title = new JLabel();
	private JButton btn_back = new JButton();
	
	private JPanel pnl_list = new JPanel();
	private JPanel pnl_content = new JPanel();
	private JSplitPane spl_body = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, pnl_list, pnl_content);
	
	private JLabel lbl_list = new JLabel();
	private JList<String> lst_list = new JList<>();
	private JButton btn_post = new JButton();
	
	private JPanel pnl_asker = new JPanel();
	private JLabel lbl_asker = new JLabel();
	private JLabel lbl_askerDetail = new JLabel();
	
	private JPanel pnl_qna = new JPanel();
	
	private JPanel pnl_question = new JPanel();
	private JLabel lbl_question = new JLabel();
	private JTextArea txt_question = new JTextArea();
	private JScrollPane scr_question = new JScrollPane(txt_question);
	
	private JPanel pnl_answer = new JPanel();
	private JPanel pnl_answerBody = new JPanel();
	private JPanel pnl_answerer = new JPanel();
	private JLabel lbl_answerer = new JLabel();
	private JLabel lbl_answererDetail = new JLabel();
	private JTextArea txt_answer = new JTextArea();
	private JScrollPane scr_answer = new JScrollPane(txt_answer);
	private JPanel pnl_vote = new JPanel();
	private JLabel lbl_upvote = new JLabel();
	private JButton btn_upvote = new JButton();
	private JLabel lbl_downvote = new JLabel();
	private JButton btn_downvote = new JButton();
	private JLabel lbl_star = new JLabel();
	private JButton btn_star = new JButton();
	private JList<String> lst_star = new JList<>();
	
	private JPanel pnl_index = new JPanel();
	private JButton btn_previous = new JButton();
	private JLabel lbl_index = new JLabel();
	private JButton btn_next = new JButton();
	private JButton btn_postAnswer = new JButton();
	

	public ViewQuestion(QnaController controller) {
		
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
		
		// body split --> list panel & content panel
		// list panel
		add(spl_body, BorderLayout.CENTER);
		
		pnl_list.setLayout(new BorderLayout());
		pnl_list.add(createLabel(lbl_list, "Questions:"), BorderLayout.NORTH);
		pnl_list.add(createList(lst_list), BorderLayout.CENTER);
		pnl_list.add(createButton(btn_post, "New Question..."), BorderLayout.SOUTH);
		refreshList();
		
		// content panel
		pnl_content.setLayout(new BorderLayout());
		
		pnl_content.add(pnl_asker, BorderLayout.NORTH);
		pnl_asker.setLayout(new BorderLayout());
		pnl_asker.add(createLabel(lbl_asker, controller.askerName()), BorderLayout.NORTH);
		pnl_asker.add(createLabel(lbl_askerDetail, controller.askerDetail()));
		
		pnl_content.add(pnl_qna, BorderLayout.CENTER);
		pnl_qna.setLayout(new GridLayout(2, 1));
		
		pnl_qna.add(pnl_question);
		pnl_question.setLayout(new BorderLayout());
		pnl_question.add(createLabel(lbl_question, controller.questionTitle()), BorderLayout.NORTH);
		pnl_question.add(createNoEditTextArea(txt_question, controller.questionContent(), scr_question));
		
		pnl_qna.add(pnl_answer);
		
		pnl_answer.setLayout(new BorderLayout());
		pnl_answer.add(pnl_answerBody);
		pnl_answerBody.setLayout(new BorderLayout());
		pnl_answerBody.add(pnl_answerer, BorderLayout.NORTH);
		pnl_answerer.setLayout(new BorderLayout());
		pnl_answerer.add(createLabel(lbl_answerer, controller.answererName()), BorderLayout.NORTH);
		pnl_answerer.add(createLabel(lbl_answererDetail, controller.answererDetail()));
		pnl_answerBody.add(createNoEditTextArea(txt_answer, controller.answerContent(), scr_answer), BorderLayout.CENTER);
		
		pnl_answer.add(pnl_vote, BorderLayout.EAST);
		pnl_vote.setLayout(new BoxLayout(pnl_vote, BoxLayout.Y_AXIS));
		pnl_vote.add(createButton(btn_upvote, "Upvote"));
		pnl_vote.add(createLabel(lbl_upvote, controller.upvoteCount()));
		pnl_vote.add(createButton(btn_downvote, "Downvote"));
		pnl_vote.add(createLabel(lbl_downvote, controller.downvoteCount()));
		pnl_vote.add(createButton(btn_star, "Star"));
		pnl_vote.add(createLabel(lbl_star, controller.starCount()));
		pnl_vote.add(createList(lst_star));
		
		pnl_content.add(pnl_index, BorderLayout.SOUTH);
		pnl_index.add(createButton(btn_previous, "Previous"));
		pnl_index.add(createLabel(lbl_index, controller.index()));
		pnl_index.add(createButton(btn_next, "Next"));
		pnl_index.add(createButton(btn_postAnswer, "Add Answer"));
	}
		
	public String titleText() {
		return "Course: " + controller.getCourse().getCourseID() + " - " + controller.getCourse().getCourseName();
	}

	private void refreshList() {
		lst_list.setListData(controller.getQuestionTitles());
	}
	
	private void refreshStarList() {
		lst_star.setListData(controller.getStarLecturerNames());
	}
	
	private void refreshContent() {
		lbl_asker.setText(controller.askerName());
		lbl_askerDetail.setText(controller.askerDetail());
		lbl_question.setText(controller.questionTitle());
		txt_question.setText(controller.questionContent());
		lbl_answerer.setText(controller.answererName());
		lbl_answererDetail.setText(controller.answererDetail());
		txt_answer.setText(controller.answerContent());
		lbl_upvote.setText(controller.upvoteCount());
		lbl_downvote.setText(controller.downvoteCount());
		lbl_star.setText(controller.starCount());
		refreshStarList();
		lbl_index.setText(controller.index());
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
	
	private JTextArea createNoEditTextArea(JTextArea textArea, String text, JScrollPane scrollPane) {
		textArea.setText(text);
		textArea.setFont(bodyFont);
		textArea.setEditable(false);
		scrollPane.add(textArea);
		
		return textArea;
	}
	
	private JList<?> createList(JList<?> list) {
		
		list.setFont(bodyFont);
		list.addListSelectionListener(this);
		
		return list;
	}
		
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(btn_back)) {
			controller.getController().displayScreen(4);
			setVisible(false);
		}
		else if (e.getSource().equals(btn_post)) {
			controller.displayAddQuestion(course);
			setVisible(false);
		}
		else if (e.getSource().equals(btn_postAnswer)) {
			controller.displayAddAnswer(course);
			setVisible(false);
		}
		else if (e.getSource().equals(btn_next)) {
			
		}
		else if (e.getSource().equals(btn_previous)) {
			
		}
		else if (e.getSource().equals(btn_upvote)) {
			
		}
		else if (e.getSource().equals(btn_downvote)) {
			
		}
		else if (e.getSource().equals(btn_star)) {
			
		}
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		controller.setCurrentQuestion(controller.getCourse().getQuestionByTitle(lst_list.getSelectedValue()));
		refreshContent();
	}	

}
