/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Table;

import src.UI.TablePanel;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import src.Board.*;

/**
 *
 * @author XanderH11
 */
public class Table extends Place {
    int tableID;
    ArrayList<Integer> activePlayers = new ArrayList<Integer>();
    ArrayList<Integer> observers = new ArrayList<Integer>();
    private String username = "Temp User";
    private String opponent = "Temp Opponent";
    boolean active = false;
    Board gameboard = new Board();
    TablePanel frontend;
    private static JFrame frame = new JFrame();
    
    
    public Table(int ID){
        super();
        tableID = ID;
        frontend = new TablePanel(this);
        frame.setTitle("Table "+(ID+1));
    }
    
//    public boolean requestToPlay(int playerID){
//        if(activePlayers.size() < 2){
//            activePlayers.add(playerID);
//            readyToPlay();
//            frontend.setVisible(true);
//            return true;
//        }
//        else{
//            return false;
//        }
//    }
	
	public TablePanel requestToPlay(){
        if(activePlayers.size() < 2){
            activePlayers.add(activePlayers.size()+1);
            frame.add(frontend);
            frontend.setVisible(true);
            frame.pack();
            frame.setTitle("Table " + getID());
            frame.setSize(1500, 1000);
            frame.addWindowListener(new ConfirmExit());
            frame.setVisible(true);
            readyToPlay();
            return frontend;
        }
        return null;
    }
    
    public boolean requestToObserve(){
        observers.add(observers.size()+1);
        setBoard();
        frame.add(frontend);
        frontend.setVisible(true);
        frame.pack();
        frame.setTitle("Table " + tableID);
        frame.setSize(1500, 1000);
        frame.setVisible(true);
        return true;
    }
    
    public void readyToPlay(){
        if(activePlayers.size() == 2){
            //TODO call to server?
            setBoard();
        }
    }
    
    public int getID(){
        return tableID;
    }
    
    public Board getBoard(){
        return gameboard;
    }
    
    public boolean getStatus(){
        return active;
    }
    
    public void setBoard(){
        MakeBoard mb = new MakeBoard();
        mb.generateBoard(gameboard, frontend.boardPanel);
    }
    
    public TablePanel getTablePanel() {
    	return this.frontend;
    }
    
    public String getUsername() {
    	return this.username;
    }
    
    public String getOpponent() {
    	return this.opponent;
    }
    
    public static JFrame getFrame() {
    	return frame;
    }
    
	static class ConfirmExit extends WindowAdapter {
		
		@Override
		public void windowClosing(WindowEvent exit) {
			
			int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave the table? \nYou will automatically lose the game",
					"", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
			
			if (result == 0) {
				getFrame().dispose();
			} // end if-close
			
		} // end method windowClosing
		
	} // end class ConfirmExit
        
}
