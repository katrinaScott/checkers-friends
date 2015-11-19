package src.UI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;

public class HelpPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;

	/*
	 * 
	 */
	
	public HelpPanel() {
		
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		// that's it- that's programming in a nutshell
		JLabel lblHelp = new JLabel(" HELP");
		lblHelp.setHorizontalAlignment(SwingConstants.LEFT);
		lblHelp.setVerticalAlignment(SwingConstants.TOP);
		lblHelp.setFont(new Font("DejaVu Sans", Font.BOLD, 30));
		lblHelp.setForeground(Color.WHITE);
		add(lblHelp);
		
	} // end constructor

} // end class HelpPanel
