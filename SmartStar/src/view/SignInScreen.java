package view;
import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;

import controller.SignInController;

public class SignInScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private SignInController controller;

	private int screenWidth = 800;
	private int screenHeight = 600;
	private String frameTitle = "Sign In - SmartStar";
	private String title = "Sign In";
	private String font = "SegoeUI";
	private Font titleFont = new Font(font, Font.BOLD, 48);
	private Font headingFont = new Font(font, Font.BOLD, 16);
	private Font bodyFont = new Font(font, Font.PLAIN, 16);

	private JPanel pnl_title = new JPanel();
	private JLabel lbl_title = new JLabel(title);
	
	private JPanel pnl_body = new JPanel();
	private JLabel lbl_instruction = new JLabel();
	private JLabel lbl_username = new JLabel();
	private JTextField txt_username = new JTextField();
	private JLabel lbl_password = new JLabel();
	private JTextField txt_password = new JTextField();
	
	private JPanel pnl_button = new JPanel();
	private JButton btn_signIn = new JButton();
	private JButton btn_cancel = new JButton();
//	JLabel lbl_subtitle = new JLabel("Please enter your username and password.");
	
	
	public SignInScreen(SignInController controller) {
		
		this.controller = controller;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(screenWidth, screenHeight);
		setTitle(frameTitle);
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		setVisible(true);

		// title panel
		add(pnl_title, BorderLayout.NORTH);
		
		lbl_title.setFont(titleFont);
		pnl_title.add(lbl_title);
		
		// body panel
		pnl_body.setLayout(new BoxLayout(pnl_body, BoxLayout.Y_AXIS));
		add(pnl_body);
		
		int textColumn = 20;
		pnl_body.add(createLabel(lbl_instruction, 
				"Please enter your username and password."));
		pnl_body.add(createLabelTestFieldPair(lbl_username, "Username:", txt_username, textColumn));
		pnl_body.add(createLabelTestFieldPair(lbl_password, "Password:", txt_password, textColumn));
		
		// button panel
		add(pnl_button, BorderLayout.SOUTH);
		pnl_button.add(createButton(btn_cancel, "Cancel"));
		pnl_button.add(createButton(btn_signIn, "Sign In"));
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
	
	private JPanel createLabel(JLabel label, String labelText) {
		JPanel newPanel = new JPanel();

		label.setText(labelText);
		label.setFont(headingFont);
		newPanel.add(label);
		
		return newPanel;
	}
	
	private JButton createButton(JButton button, String buttonText) {

		button.setText(buttonText);
		button.setFont(bodyFont);

		return button;
	}
}
