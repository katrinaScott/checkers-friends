package src.UI;

import src.Chat.*;
import src.Table.*;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.BoxLayout;

public class LobbyPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	private Hashtable<Integer, Table> tables;
	Lobby backend;
        private JPanel tablePane;
	/*
	 * 
	 */
	
	public LobbyPanel(Hashtable<Integer, Table> tables, Lobby backend) {
		
		this.tables = tables;
		
		////
		this.backend = backend;

		setBackground(Color.DARK_GRAY);
		setLayout(new BorderLayout(0, 0));
		
		tablePane = new JPanel();
		tablePane.setBackground(Color.DARK_GRAY);
		
		tablePane.setLayout(new BoxLayout(tablePane, BoxLayout.Y_AXIS));
		// for each table in database
		for(int i = 0; i < tables.size(); i++) {
			JPanel table = addTable(i+1, 0);
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
				revalidate();
			}
		});
		tablePane.add(help);
		
		add(tablePane, BorderLayout.CENTER);
		
		JTabbedPane chat = new JTabbedPane();
		JPanel lobbyChat = new PublicChat();
		lobbyChat.setBackground(Color.DARK_GRAY);
		chat.add(lobbyChat, "Public Chat");
		add(chat, BorderLayout.EAST);
		setVisible(true);

	} // end constructor
	
	/*
	 * 
	 */
	
	public JPanel addTable(int number, int join) {
		
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new BoxLayout(tablePanel, BoxLayout.X_AXIS));
		
		JLabel table = new JLabel("Table " + number);
		table.setFont(new Font("DejaVu Sans", Font.PLAIN, 15));
		table.setForeground(Color.WHITE);
		tablePanel.add(table);
		
		backend.createTable(number, join);////
		
		// if applicable, create join button
		JButton joinButton = new JButton("Join");
                joinButton.setName("" + number);
                //joinButton.setText("Join");//if the button shows up with a number instead of a word, uncomment this
		joinButton.setBackground(Color.GRAY);
		joinButton.setFont(new Font("DejaVu Sans", Font.PLAIN, 10));
		joinButton.setForeground(Color.WHITE);
		joinButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent join) {
				// join table as player
                            JButton b = (JButton) join.getSource();
                            int num = Character.getNumericValue(b.getName().charAt(0));
                            backend.joinTable(num);////
			}
		});
		tablePanel.add(joinButton);
		
		// create watch button
		JButton watchButton = new JButton("Watch");
		watchButton.setName("" + number);
                //joinButton.setText("Watch");//if the button shows up with a number instead of a word, uncomment this
		watchButton.setFont(new Font("DejaVu Sans", Font.PLAIN, 10));
		watchButton.setForeground(Color.WHITE);
		watchButton.setBackground(Color.GRAY);
		watchButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent watch) {
				// join table as observer
                            JButton b = (JButton) watch.getSource();
                            int num = Character.getNumericValue(b.getName().charAt(0));
                            backend.observeTable(num);////
			}
		});
		tablePanel.add(watchButton);
		tablePanel.setVisible(true);////
                tablePane.add(tablePanel);
		return tablePanel;
	} // end method addTable
	
	/*
	 * 
	 */
	
	private void createNewTable() {
		
		//add table to db
            addTable(backend.tables.size()+1, 1);
		
	} // end method createNewTable
	
} // end class LobbyPanel
