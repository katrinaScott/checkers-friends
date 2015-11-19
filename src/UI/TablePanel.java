package src.UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;

import src.Chat.PublicChat;
import javax.swing.JLabel;

public class TablePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * 
	 */
	
	public TablePanel() {
		
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		JPanel boardPanel = new JPanel();
		boardPanel.setBackground(Color.DARK_GRAY);
		SpringLayout boardLayout = new SpringLayout();
		boardPanel.setLayout(boardLayout);
		
		// add help if player, otherwise add back to lobby
		JButton help = new JButton("HELP");
		boardLayout.putConstraint(SpringLayout.WEST, help, 10, SpringLayout.WEST, boardPanel);
		boardLayout.putConstraint(SpringLayout.SOUTH, help, -10, SpringLayout.SOUTH, boardPanel);
		help.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		help.setForeground(Color.WHITE);
		help.setBackground(Color.DARK_GRAY);
		help.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent help) {
				JPanel helpPanel = new HelpPanel();
				add(helpPanel);
			}
		});
		boardPanel.add(help);
		
//		JButton lobby = new JButton("Back to Lobby");
//		boardLayout.putConstraint(SpringLayout.WEST, lobby, 10, SpringLayout.WEST, boardPanel);
//		boardLayout.putConstraint(SpringLayout.SOUTH, lobby, -10, SpringLayout.SOUTH, boardPanel);
//		help.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
//		help.setForeground(Color.WHITE);
//		help.setBackground(Color.DARK_GRAY);
//		help.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent lobby) {
//				//idk how to go back to lobby
//			}
//		});
//		boardPanel.add(lobby);
		
		JLabel username = new JLabel("Username");
		username.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		username.setForeground(Color.WHITE);
		boardLayout.putConstraint(SpringLayout.WEST, username, 10, SpringLayout.WEST, boardPanel);
		boardLayout.putConstraint(SpringLayout.SOUTH, username, -22, SpringLayout.NORTH, help);
		boardPanel.add(username);
		
		JLabel opponent = new JLabel("Opponent");
		boardLayout.putConstraint(SpringLayout.NORTH, opponent, 10, SpringLayout.NORTH, boardPanel);
		boardLayout.putConstraint(SpringLayout.WEST, opponent, 0, SpringLayout.WEST, help);
		opponent.setForeground(Color.WHITE);
		opponent.setFont(new Font("DejaVu Sans", Font.BOLD, 15));
		boardPanel.add(opponent);
		
		// add hint if player
		JButton btnHint = new JButton("Hint");
		btnHint.setBackground(Color.DARK_GRAY);
		boardLayout.putConstraint(SpringLayout.NORTH, btnHint, -4, SpringLayout.NORTH, username);
		boardLayout.putConstraint(SpringLayout.WEST, btnHint, 6, SpringLayout.EAST, username);
		btnHint.setForeground(Color.WHITE);
		btnHint.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		boardPanel.add(btnHint);
		
		// obviously update to show variable score
		JLabel lblScore = new JLabel("score");
		lblScore.setFont(new Font("DejaVu Sans", Font.BOLD, 20));
		lblScore.setForeground(Color.WHITE);
		lblScore.setBackground(Color.DARK_GRAY);
		boardLayout.putConstraint(SpringLayout.NORTH, lblScore, 65, SpringLayout.NORTH, boardPanel);
		boardLayout.putConstraint(SpringLayout.EAST, lblScore, -27, SpringLayout.EAST, boardPanel);
		boardPanel.add(lblScore);
		
		JLabel label = new JLabel("score");
		boardLayout.putConstraint(SpringLayout.NORTH, label, 56, SpringLayout.SOUTH, lblScore);
		boardLayout.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, lblScore);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("DejaVu Sans", Font.BOLD, 20));
		label.setBackground(Color.DARK_GRAY);
		boardPanel.add(label);
		
		add(boardPanel, BorderLayout.CENTER);
		
		JTabbedPane chat = new JTabbedPane();
		JPanel lobbyChat = new PublicChat();
		lobbyChat.setBackground(Color.DARK_GRAY);
		chat.add(lobbyChat, "Public Chat");
		add(chat, BorderLayout.EAST);
		
	} // end constructor
} // end class TablePanel
