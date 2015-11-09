package src.UI;

import src.Chat.*;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.BoxLayout;

public class LobbyPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	/*
	 * 
	 */
	
	public LobbyPanel() {
		
		setBackground(Color.DARK_GRAY);
		
		setLayout(new BorderLayout(0, 0));
		
		JPanel tablePane = new JPanel();
		tablePane.setBackground(Color.DARK_GRAY);
		
		tablePane.setLayout(new BoxLayout(tablePane, BoxLayout.Y_AXIS));
		// for each table in database
		for (int i = 0; i < 10; i++) {
			JPanel table = addTable(i+1);
			tablePane.add(table);
		}
		
		JButton createTable = new JButton("Create Table");
		createTable.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		createTable.setForeground(Color.WHITE);
		createTable.setBackground(Color.GRAY);
		createTable.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent create) {
				createNewTable();
			}
		});
		tablePane.add(createTable);
		
		JButton help = new JButton("HELP");
		help.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		help.setForeground(Color.WHITE);
		help.setBackground(Color.GRAY);
		help.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent help) {
				JPanel helpPanel = new HelpPanel();
				add(helpPanel);
			}
		});
		tablePane.add(help);
		
		add(tablePane, BorderLayout.CENTER);
		
		JTabbedPane chat = new JTabbedPane();
		JPanel lobbyChat = new PublicChat();
		lobbyChat.setBackground(Color.DARK_GRAY);
		chat.add(lobbyChat, "Public Chat");
		add(chat, BorderLayout.EAST);

	} // end constructor
	
	/*
	 * 
	 */
	
	private JPanel addTable(int number) {
		
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.X_AXIS));
		
		JLabel table = new JLabel("Table " + number);
		table.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		table.setForeground(Color.WHITE);
		tablePanel.add(table);
		
		// if applicable, create join button
		JButton joinButton = new JButton("Join");
		joinButton.setBackground(Color.GRAY);
		joinButton.setFont(new Font("DejaVu Sans", Font.PLAIN, 10));
		joinButton.setForeground(Color.WHITE);
		joinButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent join) {
				// join table as player
			}
		});
		tablePanel.add(joinButton);
		
		// create watch button
		JButton watchButton = new JButton("Watch");
		watchButton.setFont(new Font("DejaVu Sans", Font.PLAIN, 10));
		watchButton.setForeground(Color.WHITE);
		watchButton.setBackground(Color.GRAY);
		watchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent watch) {
				// join table as observer
			}
		});
		tablePanel.add(watchButton);
		
		return tablePanel;
	} // end method addTable
	
	/*
	 * 
	 */
	
	private void createNewTable() {
		
	} // end method createNewTable
	
} // end class LobbyPanel
