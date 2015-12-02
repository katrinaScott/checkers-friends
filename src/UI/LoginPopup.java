package src.UI;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPopup extends JOptionPane {
	
	private String username;
	private String ip;
	
	public LoginPopup() {
		
		JTextField username = new JTextField(15);
		JTextField ip = new JTextField(15);
		
		JPanel loginPanel = new JPanel();
		loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));
		loginPanel.add(new JLabel("Username: "));
		loginPanel.add(username);
		loginPanel.add(new JLabel("IP Address: "));
		loginPanel.add(ip);
		
		int result = JOptionPane.showOptionDialog(loginPanel, loginPanel, "LOGIN", JOptionPane.OK_OPTION, JOptionPane.PLAIN_MESSAGE, null, new String[] {"Login"}, "default");
		
		if (result == JOptionPane.OK_OPTION) {
			setUsername(username.getText());
			setIP(ip.getText());
		} else {
			// will we need to close the client as well? or no since we haven't connected yet...
			System.exit(0);
		}
		
		setVisible(true);
	}
	
	public String getUsername() {
		return this.username;
	}
	
	private void setUsername(String username) {
		this.username = username;
	}
	
	public String getIP() {
		return this.ip;
	}
	
	private void setIP(String ip) {
		this.ip = ip;
	}

}
