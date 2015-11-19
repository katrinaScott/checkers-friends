package src.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.WindowConstants;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width - 150;
	private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - 150;
	private Timer pause;
	
	/*
	 * 
	 */
	
	public MainFrame() {
		
		// set up frame
		setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		setBackground(Color.DARK_GRAY);
		setTitle("CHECKERS & FRIENDS");
		// set icon
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		addWindowListener(new ConfirmExit());
		setVisible(true);
		
		// initialize default panel
		JPanel init = new JPanel();
		init.setBackground(Color.DARK_GRAY);
		init.setLayout(new BorderLayout());
		JLabel name = new JLabel("CHECKERS & FRIENDS");
		name.setFont(new Font("DejaVu Sans", Font.BOLD, 100));
		name.setForeground(Color.WHITE);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		init.add(name, BorderLayout.CENTER);
		add(init);
		
		// pause for 5 seconds
		ActionListener wait = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// load login panel
				load();
				pause.stop();
			}
		};
		pause = new Timer(3000, wait);
		pause.start();

		setVisible(true);
		
	} // end constructor
	
	/*
	 * 
	 */
	
	private void load() {
		
		JPanel login = new LoginPanel();
		add(login);

		revalidate();
		
	} // end of method load
	
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
