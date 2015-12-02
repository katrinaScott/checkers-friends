/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Table;

import src.UI.TablePanel;
import java.util.ArrayList;

/**
 *
 * @author XanderH11
 */
public class Table extends Place {
    int tableID;
    ArrayList<String> activePlayers = new ArrayList<String>();
    ArrayList<String> observers = new ArrayList<String>();
    boolean active = false;
    Board_temp gameboard;
    
    Table(int ID){
        super();
        tableID = ID;
		TablePanel frontend = new TablePanel(this);
    }
    
    public boolean requestToPlay(String playerID){
        if(activePlayers.size() < 2){
            activePlayers.add(playerID);
            return true;
        }
        else{
            return false;
        }
    }
	
	public boolean requestToPlay(){
		//TODO make playerID
        if(activePlayers.size() < 2){
            activePlayers.add(playerID);
			readyToPlay();
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean requestToObserve(){
		//TODO make observerID
        observers.add(observerID);
        return true;
    }
    
    public void readyToPlay(){
        if(activePlayers.size() == 2){
            //TODO call to server
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
    }
        
}
