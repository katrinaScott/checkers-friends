import java.awt.BorderLayout;
import java.awt.Color;
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

	private JFrame mainFrame;
	
	/*
	 * 
	 */
	
	public MainFrame() {
		
		initialize();
		
	}
	
	/*
	 * 
	 */
	
	public void initialize() {
		
		mainFrame = new JFrame("CHECKERS & FRIENDS");
		mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		mainFrame.addWindowListener(new ConfirmExit());
		mainFrame.setVisible(true);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setLayout(new BorderLayout(0, 0));
		
		mainFrame.setContentPane(mainPanel);
		
	} // End method initialize
	
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
			} // End if-close
			
		} // End method windowClosing
		
	} // End class ConfirmExit
	
} // End class MainFrame
