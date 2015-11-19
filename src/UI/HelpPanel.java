package src.UI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
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
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel header = createHeader();
		
		JLabel section1 = createSection1();
		JLabel section2 = createSection2();
		// etc etc fill these in
		
		add(header);
		add(section1);
		add(section2);
		
	} // end constructor
	
	private JLabel createHeader() {
		
		JLabel help = new JLabel(" HELP");
		help.setHorizontalAlignment(SwingConstants.LEFT);
		help.setVerticalAlignment(SwingConstants.TOP);
		help.setFont(new Font("DejaVu Sans", Font.BOLD, 30));
		help.setForeground(Color.WHITE);
		
		return help;
		
	} // end of method createHeader
	
	private JLabel createSection1() {
		
		JLabel section1 = new JLabel("Section 1");
		//section1.setHorizontalAlignment(SwingConstants.LEFT);
		//section1.setVerticalAlignment(SwingConstants.TOP);
		section1.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		section1.setForeground(Color.WHITE);
		
		// open jtextareas upon clicking
		
		return section1;
		
	} // end of method createSection1
	
	private JLabel createSection2() {
		
		JLabel section2 = new JLabel("Section 2");
		//section1.setHorizontalAlignment(SwingConstants.LEFT);
		//section1.setVerticalAlignment(SwingConstants.TOP);
		section2.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		section2.setForeground(Color.WHITE);
		
		// open jtextareas upon clicking
		
		return section2;
		
	} // end of method createSection2

} // end class HelpPanel
