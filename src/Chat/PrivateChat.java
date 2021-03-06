package src.Chat;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PrivateChat extends JPanel implements Chat {
	
	JScrollPane scrollPane;
	JTextArea chatArea;
	JTextField input;
	JButton sendButton;
	String userName = "Temp Username";
	String otherUser;
	
	public PrivateChat(String other) {
		
		this.otherUser = other;
		
		setLayout(new BorderLayout(0, 0));
		
		chatArea = new JTextArea();
		chatArea.setLineWrap(true);
		chatArea.setEditable(false);
		
		add(chatArea, BorderLayout.CENTER);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new BorderLayout(0, 0));
		
		sendButton = new JButton(">");
		sendButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent send) {
				getInput();
			}
		});
		
		inputPanel.add(sendButton, BorderLayout.EAST);
		
		input = new JTextField();
		inputPanel.add(input, BorderLayout.CENTER);
		input.setColumns(10);
		input.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent enter) {
				if (enter.getKeyCode() == 10)
					getInput();
			}
		});
		
		add(inputPanel, BorderLayout.SOUTH);
		
	}
	
	private void getInput() {
		// TODO Auto-generated method stub
		String userInput = input.getText();
		appendUserMessage(getUserName(), userInput);
		input.setText("");

	}

	@Override
	public void appendUserMessage(String user, String msg) {
		// TODO Auto-generated method stub
		if (msg.charAt(msg.length() - 1) != '\n') {
			msg += "\n";
		}
		
		String newLine = user + ": " + msg;
		//display bold/colored username
		
		chatArea.setText(chatArea.getText() + newLine);

	}

	@Override
	public void setUserName(String user) {
		// TODO Auto-generated method stub
		this.userName = user;

	}

	@Override
	public String getUserName() {
		// TODO Auto-generated method stub
		return this.userName;
	}
	
	public void setOtherUser(String user) {
		this.otherUser = user;
	}
	
	public String getOtherUser() {
		return this.otherUser;
	}

}
