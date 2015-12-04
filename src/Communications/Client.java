package src.Communications;

import src.Communications.Interfaces.CheckersClient;
import src.Table.Lobby;
import src.Table.Table;
import src.UI.MainFrame;
import src.UI.LoginPopup;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import src.Board.ServerBoardView;
import src.Chat.PrivateChat;
import src.Chat.PublicChat;

public class Client extends Thread implements CheckersClient {
	
	private static ServerCommunicator server;
	private static MainFrame frame;
	private static Lobby lobby;
	private static PublicChat chat;
	private LoginPopup login;
	private String clientName;
	private String ip;
	private Hashtable<String, PrivateChat> privateChats;
	
	public static void main(String[] args) {
		
		// this is so ugly but it works for now
		Client client = new Client();
		client.start();
		
	}

	public Client() {
		
		server = new ServerCommunicator(this);
		chat = new PublicChat();
		privateChats = new Hashtable<String, PrivateChat>();
		
	} // end of constructor
	
	@Override
	public void run() {
		
		login();
	}
	
	public void login() {
		
		login = new LoginPopup();
		ip = login.getIP();
		clientName = login.getUsername();
		chat.setUserName(clientName);
		// do the same for any privateChats
		// cheating so we can work on the lobby/tables - should NOT manually call connectionOK
		boolean connected = server.connectToServer(ip, clientName);
		if (connected) {
			connectionOK();
		}
		
	}
	
	//confirmation that you have connected and your username is registered.
	public void connectionOK() {
		
		JOptionPane.showMessageDialog(null, "Login successful!");
		frame = new MainFrame(server, lobby);
	}
	
	//notice that you are now in the game lobby.
	public void youInLobby(){
		
		lobby.add(clientName);
		chat.appendServerMessage("You have joined the lobby.\n");
		
	}
	
	//notice that you have left the lobby.
	public void youLeftLobby(){
		
		lobby.remove(clientName);
		
	}
	
	//notice that you received the message <msg> from user <user>. pm is true if it is a priv. message.
	public void newMsg(String user, String msg, boolean pm) {
		
		if (pm) {
			if(!privateChats.containsKey(user)) {
				PrivateChat privateMsg = new PrivateChat(user);
				privateChats.put(user, privateMsg);
				privateMsg.appendUserMessage(user, msg);
			} else {
				PrivateChat existing = privateChats.get(user);
				existing.appendUserMessage(user, msg);
			}
		} else {
			chat.appendUserMessage(user, msg);
		}
		
	}
	
	//information about who is in the lobby. users is an array of all usernames in the lobby.
	public void usersInLobby(String[] users) {
		
		lobby.refresh(users);
		
	}
	
	//alert that <user> has joined the lobby.
	public void nowJoinedLobby(String user) {
		
		lobby.add(user);
		chat.appendServerMessage(user + " has joined the lobby.\n");
		
	}
	
	//alert that <user> has left the lobby.
	public void nowLeftLobby(String user){
		
		lobby.remove(user);
		chat.appendServerMessage(user + " has left the lobby.\n");
	}
	
	//alert that a new table has been created with id tid.
	public void newTable(int tid) {
	
            //Probably need more here
            chat.appendServerMessage("The table \"Table " + tid + "\" has been created!\n");
            lobby.addTable(tid);
            
	}
	
	//alert that you have joined the table with id tid.
	public void joinedTable(int tid) {
	
            //Probably need more here
            chat.appendServerMessage("You have joined Table " + tid + "!\n");
            
            
	}
	
	//alert that you have left your table.
	public void alertLeftTable() {
		
            //Probably need more here
            chat.appendServerMessage("You have left the table! Rage quit?\n");
            
	}
	
	//alert that at the table you are sitting at, a game is starting.
	public void gameStart() {
	
            //Probably need more here
            chat.appendServerMessage("A game is starting at your table, get ready if you're playing!\n");
            
	}
	
	//alert that your color is Black, for the game.
	public void colorBlack() {
		
		//set player as black?
		chat.appendServerMessage("You are playing as black for the game.\n");
		
	}
	
	//alert that your color is Red, for the game.
	public void colorRed() {
		
		//set player as red?
		chat.appendServerMessage("You are playing as red for the game.\n");
		
	}
	
	//notice that your opponent has moved from position (fr,fc) to (tr,tc)
	public void oppMove(int fr, int fc, int tr, int tc) {
            
		chat.appendServerMessage("Your opponent moved from square (" + fr + ", " + fc + ") to square (" + tr + ", " + tc + ").\n");
                
	}
	
	/* this is alert is an update to the board state. <boardState> is a matrix
	 * where 0 = no piece is at that position,
	 * 		 1 = black is at that position
	 * 		 2 = red is at that position
	 * 	     3 = black King is at that position
	 * 		 4 = red King is at that position.
	 * The first index specifies the row (0-based) from top to bottom,
	 * and the second index specifies the column (0-based) from left to right.
	 * so boardState[0][0] = 3 means a black King is at the top left corner of the board
	 * and boardState[7][7] = 2 means a red piece is at the bottom right corner of the board.
	 */
	public void curBoardState(int tid, byte[][] boardState) {
		
		Table currentTable = new Table(tid);
        currentTable.setBoard();
        ServerBoardView serverBoard = new ServerBoardView();
        serverBoard.setBoardState(boardState);
        //make move?
        //send server message with new state?
        
	}
	
	//notice that for the game you are playing, you win!
	public void youWin() {
		
		JOptionPane.showMessageDialog(null, "CONGRATULATIONS!\n" + "You have won!");
		
	}
	
	//notice that for the game you are playing, you lost.
	public void youLose() {
		
		JOptionPane.showMessageDialog(null, "SORRY :/" + "\n" + "You have lost.");
		
	}
	
	//an alert saying that a table state has changed.
	//this is received whenever anyone joins or leaves a table.
	public void onTable(int tid, String blackSeat, String redSeat) {
	
            chat.appendServerMessage("Table " + tid + " has changed!" + "\n" + blackSeat + " " + redSeat + ".\n");
            
	}//End onTable
	
	//a list of the current table ids on the server. To get the status of a table
	//you must query the server with a tid.
	public void tableList(int[] tids) {
	
            chat.appendServerMessage("Here is a list of the current Table ids on the server: \n");
            
            for (int i = 0; i < tids.length; i++) {
                chat.appendServerMessage("Table " + tids[i] + "\n");
            }//End for
            
	}//End tableList
	
	//its your turn.
	public void yourTurn() {
		chat.appendServerMessage("It's your turn!\n");
	}//End yourTurn
	
	//you are now observing table tid.
	public void nowObserving(int tid) {
            
		chat.appendServerMessage("You are now observing Table " + tid + "\n");
                
	}//End nowObserving
	
	//you stopped observing table tid.
	public void stoppedObserving(int tid) {
		
            chat.appendServerMessage("You are no longer observing Table " + tid + "\n");
            
	}//End stoppedObserving


	/** Error messages
	 */
	
	//a network exception occured. msg contains details.
	public void networkException(String msg) {
		
            chat.appendServerMessage("Uh oh! Something went wrong with the network!\n");
            System.out.println("NETWORK EXCEPTION: " + msg);
            
	}//End networkException
	
	//the username sent is already in use. This error disconnects you from the server.
	public void nameInUseError() {
		
		JOptionPane.showMessageDialog(null, "Name already taken- try again");
		login();
		
	}//nameInUseError
	
	//the username sent is illegal...length = 0 or has whitespace.
	public void nameIllegal() {
		
		JOptionPane.showMessageDialog(null, "Invalid name- try again");
		login();
		
	}//end nameIllegal
	
	//the requested move is illegal.
	public void illegalMove() {
		
		//printMessageToClient("the move you tried to make is not valid");
            chat.appendServerMessage("The move you tried to make is not valid. Maybe the space is occupied?\n");
		
	}//End illegalMove
	
	//the table your trying to join is full.
	public void tableFull() {
		
            chat.appendServerMessage("The table you are trying to join is already full!\n");
            
	}//End tableFull
	
	//the table queried does not exist.
	public void tblNotExists() {
	
            chat.appendServerMessage("The table requested does not exist.\n");
            
	}//End tblNotExists
	
	//called if you say you are ready on a table with no current game.
	public void gameNotCreatedYet() {
		
            chat.appendServerMessage("I see you're ready, but there's no game at this table yet!\n");
            
	}//End gameNotCreatedYet
	
	//called if it is not your turn but you make a move.
	public void notYourTurn() {
		
            chat.appendServerMessage("Wait your turn!\n");
            
	}//End notYourTurn
	
	//called if you send a stop observing command but you are not observing a table.
	public void notObserving() {
		
            chat.appendServerMessage("You are not currently observing a table.\n");
            
	}//end notObserving
	
	//called if you send a game command but your opponent is not ready
	public void oppNotReady() {
		
            chat.appendServerMessage("You need to wait for your opponent to be ready before you try to play.\n");
            
	}//End oppNotReady
	
	//you cannot perform the requested operation because you are in the lobby.
	public void errorInLobby() {
		
            chat.appendServerMessage("You can't do that while you are in the lobby!\n");
            
	}//End errorInLobby
	
	//called if the client sends an ill-formated TCP message
	public void badMessage() {
	
            chat.appendServerMessage("Something funky happened during the last communication with the server...\n");
            
	}

	//called when your opponent leaves the table
	public void oppLeftTable() {

            chat.appendServerMessage("Your opponent left the table.\n");
            
	}//End oppLeftTable

	//you cannot perform the requested op because you are not in the lobby.
	public void notInLobby() {
            
            chat.appendServerMessage("You can't do that unless you are in the lobby!\n");

	}

}
