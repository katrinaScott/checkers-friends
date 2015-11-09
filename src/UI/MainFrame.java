package src.UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width - 150;
	private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - 150;
	
	/*
	 * 
	 */
	
	public MainFrame() {
		
		// set up frame
		setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		setBackground(Color.GRAY);
		setForeground(Color.WHITE);
		setTitle("CHECKERS & FRIENDS");
		// set icon
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new ConfirmExit());
		
		// initialize default panel
		JPanel login = new LoginPanel();
		add(login);
		setVisible(true);
		
	} // end constructor
	
	/*
	 * 
	 */
	
	static class ConfirmExit extends WindowAdapter {
	
		@Override
		public void windowClosing(WindowEvent exit) {
			
			int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?",
					"", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (result == 0) {
				System.exit(0);
			} // end if-close
			
		} // end method windowClosing
		
	} // end class ConfirmExit
	
} // end class MainFrame
