package src.Communications;

import src.Communications.Interfaces.CheckersClient;
import src.Table.Lobby;
import src.UI.MainFrame;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.swing.JOptionPane;

import src.Chat.PrivateChat;
import src.Chat.PublicChat;

public class Client extends Thread implements CheckersClient {
	
	private static ServerCommunicator server;
	private static MainFrame frame;
	private static Lobby lobby;
	private static PublicChat chat;
	private Hashtable<String, PrivateChat> privateChats;
	private static String NAME_TAKEN = "NAME_TAKEN";
	private static String INVALID_NAME = "INVALID_NAME";
	
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
		frame = new MainFrame(server, lobby);
		//login();
	}
	
	public void login() {
		
		//server.connectToServer(ip, clientName);
		
	}
	
	//confirmation that you have connected and your username is registered.
	public void connectionOK() {
		
		frame.loginSuccess();
		
	}
	
	//notice that you are now in the game lobby.
	public void youInLobby(){
		
		//lobby.add();
		chat.appendServerMessage("you have joined the lobby");
		
	}
	
	//notice that you have left the lobby.
	public void youLeftLobby(){
		
		//lobby.remove();
		
	}
	
	//notice that you received the message <msg> from user <user>. pm is true if it is a priv. message.
	public void newMsg(String user, String msg, boolean pm) {
		
		if (pm) {
			if(!privateChats.containsKey(user)) {
				PrivateChat privateMsg = new PrivateChat();
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
		chat.appendServerMessage(user + " has joined the lobby");
		
	}
	
	//alert that <user> has left the lobby.
	public void nowLeftLobby(String user){
		
		lobby.remove(user);
		chat.appendServerMessage(user + " has left the lobby");
	}
	
	//alert that a new table has been created with id tid.
	public void newTable(int tid) {
	
            //Probably need more here
            chat.appendServerMessage("The table \"Table " + tid + "\" has been created!");
            
	}
	
	//alert that you have joined the table with id tid.
	public void joinedTable(int tid) {
	
            //Probably need more here
            chat.appendServerMessage("You have joined Table " + tid + "!");
            
            
	}
	
	//alert that you have left your table.
	public void alertLeftTable() {
		
            //Probably need more here
            chat.appendServerMessage("You have left the table! Rage quit?");
            
	}
	
	//alert that at the table you are sitting at, a game is starting.
	public void gameStart() {
	
            //Probably need more here
            chat.appendServerMessage("A game is starting at your table, get ready if you're playing!");
            
	}
	
	//alert that your color is Black, for the game.
	public void colorBlack() {
		
		//set player as black?
		chat.appendServerMessage("You are playing as black for the game.");
		
	}
	
	//alert that your color is Red, for the game.
	public void colorRed() {
		
		//set player as red?
		chat.appendServerMessage("You are playing as red for the game.");
		
	}
	
	//notice that your opponent has moved from position (fr,fc) to (tr,tc)
	public void oppMove(int fr, int fc, int tr, int tc) {
		
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
		
	}
	
	//a list of the current table ids on the server. To get the status of a table
	//you must query the server with a tid.
	public void tableList(int[] tids) {
		
	}
	
	//its your turn.
	public void yourTurn() {
		
	}
	
	//you are now observing table tid.
	public void nowObserving(int tid) {
		
	}
	
	//you stopped observing table tid.
	public void stoppedObserving(int tid) {
		
	}


	/** Error messages
	 */
	
	//a network exception occured. msg contains details.
	public void networkException(String msg) {
		
	}
	
	//the username sent is already in use. This error disconnects you from the server.
	public void nameInUseError() {
		
		frame.loginFail(NAME_TAKEN);
		
	}
	
	//the username sent is illegal...length = 0 or has whitespace.
	public void nameIllegal() {
		
		frame.loginFail(INVALID_NAME);
		
	}
	
	//the requested move is illegal.
	public void illegalMove() {
		
		//printMessageToClient("the move you tried to make is not valid");
		
	}
	
	//the table your trying to join is full.
	public void tableFull() {
		
	}
	
	//the table queried does not exist.
	public void tblNotExists() {
		
	}
	
	//called if you say you are ready on a table with no current game.
	public void gameNotCreatedYet() {
		
	}
	
	//called if it is not your turn but you make a move.
	public void notYourTurn() {
		
	}
	
	//called if you send a stop observing command but you are not observing a table.
	public void notObserving() {
		
	}
	
	//called if you send a game command but your opponent is not ready
	public void oppNotReady() {
		
	}
	
	//you cannot perform the requested operation because you are in the lobby.
	public void errorInLobby() {
		
	}
	
	//called if the client sends an ill-formated TCP message
	public void badMessage() {
		
	}

	//called when your opponent leaves the table
	public void oppLeftTable() {

	}

	//you cannot perform the requested op because you are not in the lobby.
	public void notInLobby() {

	}

}
