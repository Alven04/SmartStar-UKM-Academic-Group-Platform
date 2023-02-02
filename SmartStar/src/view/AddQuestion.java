package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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

public class AddQuestion extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private Controller controller;

	private int screenWidth = 500;
	private int screenHeight = 375;
	private String frameTitle = "New Question - SmartStar";
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

	private JPanel pnl_question = new JPanel();
	private JPanel pnl_questionTitle = new JPanel();
	private JLabel lbl_questionTitle = new JLabel();
	private JTextField txt_questionTitle = new JTextField();
	private JPanel pnl_questionContent = new JPanel();
	private JLabel lbl_questionContent = new JLabel();
	private JTextArea txt_questionContent = new JTextArea();
	private JScrollPane scr_questionContent = new JScrollPane(txt_questionContent);

	private JPanel pnl_button = new JPanel();
	private JButton btn_post = new JButton();
	private JButton btn_cancel = new JButton();
	
	public AddQuestion(Controller controller) {
		
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

		add(pnl_body);
		pnl_body.setLayout(new BorderLayout());
		
		// asker panel
		pnl_body.add(pnl_asker, BorderLayout.NORTH);		
		pnl_asker.setLayout(new BorderLayout());
		pnl_asker.add(createLabel(lbl_asker, askerName()), BorderLayout.NORTH);
		pnl_asker.add(createLabel(lbl_askerDetail, askerDetail()));

		// question panel
		pnl_body.add(pnl_question);
		pnl_question.setLayout(new BorderLayout());
		
		pnl_question.add(pnl_questionTitle, BorderLayout.NORTH);
		pnl_questionTitle.setLayout(new BorderLayout());
		pnl_questionTitle.add(createLabelTestFieldPair(lbl_questionTitle, "Title:", txt_questionTitle, 40), BorderLayout.WEST);
		
		pnl_question.add(pnl_questionContent);
		pnl_questionContent.setLayout(new BorderLayout());
		pnl_questionContent.add(createLabel(lbl_questionContent, "Type your question here:"), BorderLayout.NORTH);
		
		pnl_questionContent.add(createTextArea(txt_questionContent, "", scr_questionContent));

		// button panel
		add(pnl_button, BorderLayout.SOUTH);
		pnl_button.add(createButton(btn_cancel, "Cancel"));
		pnl_button.add(createButton(btn_post, "Post Question"));
		
	}
	
	private String askerDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	private String askerName() {
		// TODO Auto-generated method stub
		return null;
	}

	private String titleText() {
		// TODO Auto-generated method stub
		return "New Question - Course: ";
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
	
	private JPanel createLabelTestFieldPair(JLabel label, String labelText, JTextField textField, int textColumn) {
		JPanel newPanel = new JPanel();

		label.setText(labelText);
		label.setFont(headingFont);
		newPanel.add(label);
		
		textField.setColumns(textColumn);
		textField.setFont(bodyFont);
		newPanel.add(textField);
		
		return newPanel;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
