package src.Table;

import java.util.ArrayList;
import java.util.Hashtable;

import src.UI.LobbyPanel;

public class Lobby extends Table {
	
	private LobbyPanel lobbyPanel;
	private ArrayList<String> users;
	private Hashtable<Integer, Table> tables;
	
	/*
	 * 
	 */
	
	public Lobby() {
		
		users = new ArrayList<String>();
		tables = new Hashtable<Integer, Table>();
		lobbyPanel = new LobbyPanel(tables);
		
	} // end constructor
	
	/*
	 * 
	 */
	
	public LobbyPanel getLobbyPanel() {
		
		return lobbyPanel;
		
	} // end of method getLobbyPanel
	
	public void add(String user) {
		
		if (!users.contains(user)) {
			users.add(user);
		}
		
	}
	
	public void remove(String user) {
		
		users.remove(user);
		
	}
	
	public void refresh(String[] users) {
		
		//
	}

} // end class Lobby
