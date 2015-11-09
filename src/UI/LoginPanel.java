package src.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

public class LoginPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * 
	 */
	
	public LoginPanel() {
		
		setBackground(Color.DARK_GRAY);
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JLabel login = new JLabel("LOGIN");
		login.setHorizontalAlignment(SwingConstants.CENTER);
		springLayout.putConstraint(SpringLayout.WEST, login, 616, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.EAST, login, 898, SpringLayout.WEST, this);
		login.setForeground(Color.WHITE);
		login.setFont(new Font("DejaVu Sans", Font.BOLD, 80));
		add(login);
		
		JTextField username = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, username, 616, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, username, -432, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, username, -616, SpringLayout.EAST, this);
		username.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		username.setText("Username");
		add(username);
		username.setColumns(10);
		
		JButton button = new JButton(">");
		springLayout.putConstraint(SpringLayout.NORTH, button, 12, SpringLayout.SOUTH, username);
		springLayout.putConstraint(SpringLayout.EAST, button, -616, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, login, -32, SpringLayout.NORTH, button);
		button.setForeground(Color.WHITE);
		button.setBackground(Color.GRAY);
		button.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent send) {
				String name = username.getText();
				login(name);
			}
		});
		add(button);
		setVisible(true);

	} // end constructor
	
	/*
	 * 
	 */
	
	private void login(String username) {
		
		// clear panel
		removeAll();
		
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout());
		
		ImageIcon loadingImg = new ImageIcon(getClass().getResource("/res/loading.gif"));
		JLabel image = new JLabel();
		image.setIcon(loadingImg);
		image.setHorizontalAlignment(SwingConstants.CENTER);
		add(image, BorderLayout.NORTH);
		
		JLabel loading = new JLabel("Loading...");
		loading.setHorizontalAlignment(SwingConstants.CENTER);
		loading.setForeground(Color.WHITE);
		loading.setFont(new Font("DejaVu Sans", Font.PLAIN, 40));
		add(loading, BorderLayout.CENTER);

		// refresh panel
		revalidate();
		
		/*
		// query server for username validity
		// TRUE until functionality implemented
		Boolean loginAttempt = true;
		
		// if username is valid
		if (loginAttempt) {
		
		// clear panel
		removeAll();
		
		// load success icon
		ImageIcon successImg = new ImageIcon(getClass().getResource("/res/success.gif"));
		JLabel check = new JLabel();
		check.setIcon(successImg);
		check.setHorizontalAlignment(SwingConstants.CENTER);
		add(check, BorderLayout.NORTH);
		
		JLabel success = new JLabel("Login successful!");
		success.setHorizontalAlignment(SwingConstants.CENTER);
		success.setForeground(Color.WHITE);
		success.setFont(new Font("DejaVu Sans", Font.PLAIN, 40));
		add(success, BorderLayout.CENTER);
		
		revalidate();
		
		// set username 
		
		// pause for 5 seconds
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // this is not a very helpful catch... figure out s/t to do here
		
		// load lobby
		new Lobby();
		
		// else if invalid
		} else {
		
		// clear panel
		removeAll();
		
		// load fail icon
		ImageIcon failImg = new ImageIcon(getClass().getResource("/res/X.png"));
		JLabel x = new JLabel();
		x.setIcon(failImg);
		x.setHorizontalAlignment(SwingConstants.CENTER);
		add(x, BorderLayout.NORTH);
		
		JLabel fail = new JLabel("Login failed");
		fail.setHorizontalAlignment(SwingConstants.CENTER);
		fail.setForeground(Color.WHITE);
		fail.setFont(new Font("DejaVu Sans", Font.PLAIN, 40));
		add(fail, BorderLayout.CENTER);
		
		revalidate();
		
		// pause for 5 seconds
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} // this is not a very helpful catch... figure out s/t to do here
		
		// return to login page
		// look into getTopLevelAncestor- there has to be some way call LoginPanel() from in here
		
		} // end connectionOK if-else
		*/
		
	} // end method login

} // end class LoginPanel
