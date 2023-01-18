import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frm_SignIn extends JFrame {

	private static final long serialVersionUID = 1L;
	
	public Frm_SignIn() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 600);
		this.setTitle("Sign In - SmartStar");
		this.setVisible(true);
		this.setLayout(new FlowLayout());
		
		JLabel lbl_title = new JLabel("SmartStar");
		lbl_title.setFont(new Font("Georgia", Font.BOLD, 36));
		lbl_title.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(lbl_title);

		JLabel lbl_subtitle = new JLabel("by A Team");
		lbl_subtitle.setFont(new Font("Georgia", Font.BOLD, 24));
		lbl_title.setAlignmentX(Component.CENTER_ALIGNMENT);
		this.add(lbl_subtitle);
		
	}

}
