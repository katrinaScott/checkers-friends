package src.Table;

import src.UI.LobbyPanel;

public class Lobby extends Table {
	
	private LobbyPanel lobbyPanel;
	
	/*
	 * 
	 */
	
	public Lobby() {
		
		lobbyPanel = new LobbyPanel();
		
	} // end constructor
	
	/*
	 * 
	 */
	
	public LobbyPanel getLobbyPanel() {
		
		return lobbyPanel;
		
	} // end of method getLobbyPanel

} // end class Lobby
