/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Table;

import src.UI.TablePanel;
import java.util.ArrayList;
import src.Board.*;

/**
 *
 * @author XanderH11
 */
public class Table extends Place {
    int tableID;
    ArrayList<Integer> activePlayers = new ArrayList<Integer>();
    ArrayList<Integer> observers = new ArrayList<Integer>();
    boolean active = false;
    Board gameboard;
    TablePanel frontend;
    
    public Table(int ID){
        super();
        tableID = ID;
        frontend = new TablePanel(this);
    }
    
    public boolean requestToPlay(int playerID){
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
            activePlayers.add(activePlayers.size()+1);
			readyToPlay();
            return true;
        }
        else{
            return false;
        }
    }
    
    public boolean requestToObserve(){
		//TODO make observerID
        observers.add(observers.size()+1);
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
        MakeBoard mb = new MakeBoard();
        mb.generateBoard(gameboard, frontend.boardPanel);
    }
        
}
