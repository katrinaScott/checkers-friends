package src.UI;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;

public class HelpPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private JLabel section1, section2, section3, section4, section5;

	/*
	 * 
	 */
	
	public HelpPanel() {
		
		setBackground(Color.DARK_GRAY);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel header = createHeader();
		JScrollPane scrollable = new JScrollPane();
		scrollable.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollable.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollable.setBackground(Color.DARK_GRAY);
		
		section1 = createSection1();
		section2 = createSection2();
		section3 = createSection3();
		section4 = createSection4();
		section5 = createSection5();
		// etc etc fill these in
		
		add(header);
		scrollable.add(section1);
		scrollable.add(section2);
		scrollable.add(section3);
		scrollable.add(section4);
		scrollable.add(section5);
		add(scrollable);
		
		JButton close = closeButton();
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// close this panel, hopefully leaving the lobby intact underneath
			}
		});
		add(close);
		
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
		
		JLabel section1 = new JLabel("How To Play Checkers");
		//section1.setHorizontalAlignment(SwingConstants.LEFT);
		//section1.setVerticalAlignment(SwingConstants.TOP);
		section1.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		section1.setForeground(Color.WHITE);
		
		// open subsections when clicked
		section1.addMouseListener(new ClickListener());
		
		return section1;
		
	} // end of method createSection1
	
	private JLabel createSection2() {
		
		JLabel section2 = new JLabel("How To Join A Table");
		//section1.setHorizontalAlignment(SwingConstants.LEFT);
		//section1.setVerticalAlignment(SwingConstants.TOP);
		section2.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		section2.setForeground(Color.WHITE);
		
		// open subsections when clicked
		section2.addMouseListener(new ClickListener());
		
		return section2;
		
	} // end of method createSection2
	
	private JLabel createSection3() {
		
		JLabel section3 = new JLabel("How To Observe A Table");
		//section1.setHorizontalAlignment(SwingConstants.LEFT);
		//section1.setVerticalAlignment(SwingConstants.TOP);
		section3.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		section3.setForeground(Color.WHITE);
		
		// open subsections when clicked
		section3.addMouseListener(new ClickListener());
		
		return section3;
		
	} // end of method createSection3
	
	private JLabel createSection4() {
		
		JLabel section4 = new JLabel("How To Create A Table");
		//section1.setHorizontalAlignment(SwingConstants.LEFT);
		//section1.setVerticalAlignment(SwingConstants.TOP);
		section4.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		section4.setForeground(Color.WHITE);
		
		// open subsections when clicked
		section4.addMouseListener(new ClickListener());
		
		return section4;
		
	} // end of method createSection4

	private JLabel createSection5() {
	
		JLabel section5 = new JLabel("How To Chat");
		//section1.setHorizontalAlignment(SwingConstants.LEFT);
		//section1.setVerticalAlignment(SwingConstants.TOP);
		section5.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		section5.setForeground(Color.WHITE);

		// open subsections when clicked
		section5.addMouseListener(new ClickListener());

		return section5;
	
} // end of method createSection5
	
	private void populateSection1() {
		
		JTextArea section1 = new JTextArea("Blah blah blah");
		// set alignment
		section1.setFont(new Font("DejaVu Sans", Font.PLAIN, 10));
		section1.setForeground(Color.WHITE);
		add(section1);
		
	} // end of method populateSection1
	
	private void populateSection2() {
		
		JTextArea section2 = new JTextArea("Blah blah blah");
		// set alignment
		section2.setFont(new Font("DejaVu Sans", Font.PLAIN, 10));
		section2.setForeground(Color.WHITE);
		add(section2);
		
	} // end of method populateSection2
	
	private void populateSection3() {
		
		JTextArea section3 = new JTextArea("Blah blah blah");
		// set alignment
		section3.setFont(new Font("DejaVu Sans", Font.PLAIN, 10));
		section3.setForeground(Color.WHITE);
		add(section3);
		
	} // end of method populateSection3
	
	private void populateSection4() {
		
		JTextArea section4 = new JTextArea("Blah blah blah");
		// set alignment
		section4.setFont(new Font("DejaVu Sans", Font.PLAIN, 10));
		section4.setForeground(Color.WHITE);
		add(section4);
		
	} // end of method populateSection4
	
	private void populateSection5() {
		
		JTextArea section5 = new JTextArea("Blah blah blah");
		// set alignment
		section5.setFont(new Font("DejaVu Sans", Font.PLAIN, 10));
		section5.setForeground(Color.WHITE);
		add(section5);
		
	} // end of method populateSection2
	
	private JButton closeButton() {
		
		JButton close = new JButton("Close");
		close.setHorizontalAlignment(SwingConstants.RIGHT);
		close.setVerticalAlignment(SwingConstants.BOTTOM);
		close.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		close.setForeground(Color.WHITE);
		close.setBackground(Color.GRAY);
		close.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent click) {
				// close panel
			}
		});
		
		return close;
		
	} // end of method close
	
	private class ClickListener implements MouseListener {

		public void mouseClicked(MouseEvent click) {
			
			if (click.getSource().equals(section1)) {
				
				populateSection1();
				
			} else if (click.getSource().equals(section2)) {
				
				populateSection2();
				
			} else if (click.getSource().equals(section3)) {
				
				populateSection3();
				
			} else if (click.getSource().equals(section4)) {
				
				populateSection4();
				
			} else if (click.getSource().equals(section5)) {
				
				populateSection5();
				
			} // etc.
			
		} // end of method mouseClicked
		
		/*
		 * These shouldn't do anything
		 */

		public void mouseEntered(MouseEvent e) {}

		public void mouseExited(MouseEvent e) {}

		public void mousePressed(MouseEvent e) {}

		public void mouseReleased(MouseEvent e) {}
		
	} // end of class ClickListener

} // end class HelpPanel
