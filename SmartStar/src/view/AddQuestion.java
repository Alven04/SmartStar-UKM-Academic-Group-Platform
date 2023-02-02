package view;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controller.Controller;

public class AddQuestion extends JFrame {

	private static final long serialVersionUID = 1L;
	private Controller controller;

	private int screenWidth = 800;
	private int screenHeight = 600;
	private String frameTitle = "Add Question - SmartStar";
	private String font = "SegoeUI";
	private Font titleFont = new Font(font, Font.BOLD, 32);
	private Font headingFont = new Font(font, Font.BOLD, 12);
	private Font bodyFont = new Font(font, Font.PLAIN, 12);

	private JPanel pnl_title = new JPanel();
	private JLabel lbl_title = new JLabel();
	private JButton btn_back = new JButton();

	private JPanel pnl_asker = new JPanel();
	private JLabel lbl_asker = new JLabel();
	private JLabel lbl_askerDetail = new JLabel();

	private JPanel pnl_question = new JPanel();
	private JLabel lbl_question = new JLabel();
	private JTextArea txt_question = new JTextArea();
	private JScrollPane scr_question = new JScrollPane(txt_question);

	private JButton btn_post = new JButton();
}
