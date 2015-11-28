package src.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import src.Table.Lobby;

public class MainFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private static final int WINDOW_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().width - 150;
	private static final int WINDOW_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().height - 150;
	private Timer pause;
	private LoginPanel login;
	private Lobby lobby;
	
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
		
		// initialize title screen
		JPanel title = new JPanel();
		title.setBackground(Color.DARK_GRAY);
		title.setLayout(new BorderLayout());
		JLabel name = new JLabel("CHECKERS & FRIENDS");
		name.setFont(new Font("DejaVu Sans", Font.BOLD, 100));
		name.setForeground(Color.WHITE);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		title.add(name, BorderLayout.CENTER);
		add(title);
		
		// initialize login screen
		login = new LoginPanel();
		
		// pause for 5 seconds
		ActionListener wait = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// load login panel
				remove(title);
				add(login);
				revalidate();
				
				pause.stop();
			}
		};
		pause = new Timer(3000, wait);
		pause.start();

	} // end constructor
	
	/*
	 * 
	 */
	
	//public void login(String userName) {
		
		//client.login(userName);
		
	//} // end of method connect
	
	/*
	 * 
	 */
	
	public void loginSuccess() {
		
		login.success();
		
		// pause for 3 seconds
		ActionListener wait = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// load lobby
				lobby = new Lobby();
				add(lobby.getLobbyPanel());
				revalidate();
				
				pause.stop();
			}
		};
		pause = new Timer(3000, wait);
		pause.start();
		
	} // end of method loginSuccess
	
	/*
	 * 
	 */
	
	public void loginFail(String failMsg) {
		
		login.fail(failMsg);
		
		// pause for 5 seconds
		ActionListener wait = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// return to login page
				login = new LoginPanel();
				add(login);
				revalidate();
				
				pause.stop();
			}
		};
		pause = new Timer(5000, wait);
		pause.start();
		
	} // end of method loginFail
	
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
