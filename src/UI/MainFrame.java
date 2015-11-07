package src.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
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
//		mainFrame.setVisible(true);
		
		JPanel mainPanel = new JPanel();
		mainPanel.setBackground(Color.DARK_GRAY);
		mainPanel.setLayout(new BorderLayout());
		
		JLabel login = new JLabel("LOGIN");
		login.setForeground(Color.WHITE);
		login.setFont(new Font("DejaVu Sans", Font.BOLD, 100));
		login.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(login, BorderLayout.CENTER);
		
		JTextField username = new JTextField("Username");
		username.setSize(150, 10);
		username.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(username, BorderLayout.SOUTH);
		//username.setColumns(50);
		
		JButton loginButton = new JButton(">");
		//set shit
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent send) {
				login();
			}
		});

		mainFrame.setContentPane(mainPanel);
		mainFrame.setVisible(true);
		
	} // End method initialize
	
	/*
	 * 
	 */
	
	private void login() {
		
		mainFrame.getContentPane().removeAll();
		
		JPanel loadingPanel = new JPanel();
		loadingPanel.setBackground(Color.DARK_GRAY);
		loadingPanel.setLayout(new BorderLayout());
		//add loading icon to panel and set center
		mainFrame.add(loadingPanel);
		
		//wait until response for server and display either "accepted" or "declined" icon panels
		
		//load lobby or go back to login panel
	}
	
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
