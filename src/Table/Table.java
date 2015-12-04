/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Table;

import src.UI.TablePanel;
import java.util.ArrayList;
import javax.swing.JFrame;
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
    Board gameboard;
    TablePanel frontend;
    JFrame frame = new JFrame();
    
    public Table(int ID){
        super();
        tableID = ID;
        frontend = new TablePanel(this);
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
            frame.setVisible(true);
            readyToPlay();
            return frontend;
        }
        return null;
    }
    
    public boolean requestToObserve(){
        observers.add(observers.size()+1);
        frontend.setVisible(true);
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
        gameboard = new Board();
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
        
}
