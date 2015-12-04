package src.UI;

import src.Table.Table;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SpringLayout;

import src.Board.Board;
import src.Board.MakeBoard;
import src.Chat.PublicChat;
import javax.swing.JLabel;
import src.Board.*;

public class TablePanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	Table backend;
        public JPanel boardPanel;
                
	/*
	 * 
	 */
	
	public TablePanel(Table backend) {
		
		this.backend = backend;
		
		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		boardPanel = new JPanel();
		boardPanel.setBackground(Color.DARK_GRAY);
		SpringLayout boardLayout = new SpringLayout();
		boardPanel.setLayout(boardLayout);
		
		// add help if playing, otherwise add back to lobby
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
		
		JLabel username = new JLabel(backend.getUsername());
		username.setFont(new Font("DejaVu Sans", Font.BOLD, 30));
		username.setForeground(Color.WHITE);
		boardLayout.putConstraint(SpringLayout.WEST, username, 10, SpringLayout.WEST, boardPanel);
		boardLayout.putConstraint(SpringLayout.SOUTH, username, -22, SpringLayout.NORTH, help);
		boardPanel.add(username);
		
		JLabel opponent = new JLabel(backend.getOpponent());
		boardLayout.putConstraint(SpringLayout.NORTH, opponent, 10, SpringLayout.NORTH, boardPanel);
		boardLayout.putConstraint(SpringLayout.WEST, opponent, 0, SpringLayout.WEST, help);
		opponent.setForeground(Color.WHITE);
		opponent.setFont(new Font("DejaVu Sans", Font.BOLD, 30));
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
		lblScore.setFont(new Font("DejaVu Sans", Font.BOLD, 50));
		lblScore.setForeground(Color.WHITE);
		lblScore.setBackground(Color.DARK_GRAY);
		boardLayout.putConstraint(SpringLayout.NORTH, lblScore, 150, SpringLayout.NORTH, boardPanel);
		boardLayout.putConstraint(SpringLayout.EAST, lblScore, -500, SpringLayout.EAST, boardPanel);
		boardPanel.add(lblScore);
		
		JLabel label = new JLabel("score");
		boardLayout.putConstraint(SpringLayout.NORTH, label, 375, SpringLayout.SOUTH, lblScore);
		boardLayout.putConstraint(SpringLayout.EAST, label, 0, SpringLayout.EAST, lblScore);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("DejaVu Sans", Font.BOLD, 50));
		label.setBackground(Color.DARK_GRAY);
		boardPanel.add(label);
		 
		add(boardPanel, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		boardLayout.putConstraint(SpringLayout.NORTH, panel, 50, SpringLayout.SOUTH, opponent);
		boardLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, help);
		boardLayout.putConstraint(SpringLayout.SOUTH, panel, 675, SpringLayout.SOUTH, opponent);
		boardLayout.putConstraint(SpringLayout.EAST, panel, 625, SpringLayout.WEST, boardPanel);
		
		MakeBoard MaketheBoard = new MakeBoard();
		
		JPanel board = new JPanel(new GridLayout(8, 8));

        Board theGameBoard = new Board();

        MaketheBoard.generateBoard(theGameBoard, board);
        panel.add(board);
		
		boardPanel.add(panel);
		setVisible(true);
		
		JTabbedPane chat = new JTabbedPane();
		JPanel lobbyChat = new PublicChat();
		lobbyChat.setBackground(Color.DARK_GRAY);
		chat.add(lobbyChat, "Public Chat");
		add(chat, BorderLayout.EAST);
		
		setVisible(true);
	} // end constructor
} // end class TablePanel
