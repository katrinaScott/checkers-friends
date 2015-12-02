/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Table;

import src.UI.LobbyPanel;
import java.util.ArrayList;

/**
 *
 * @author XanderH11
 */
public class Lobby extends Place {
    ArrayList<Table> tables = new ArrayList<Table>();
    ArrayList<Player> freePlayers;// = new ArrayList<Player>();
    ArrayList<Table> freeTables = new ArrayList<Table>();
//    ArrayList<Table> playingTables = new ArrayList<Table>();
    
    public Lobby(){
        super();
		//TODO get list of players from the server? to display for people to select for private chats?
    }
    
    public boolean joinTable(int table){
        for(int i=0; i < freeTables.size(); i++){
            if(freeTables.get(i).getID() == table){
                //TODO make request
                return true;
            }
        }
        return false;
    }
    
    public boolean observeTable(int table){
        for(int i=0; i < tables.size(); i++){
            if(i == table){
                tables.get(i).requestToObserve();
                return true;
            }
        }
        return false;//this should never happen
    }
    
    public boolean createTable(){
		//TODO make table create id and pass that to join?
        int newID = tables.size();
        Table newTable = new Table(newID);
        tables.add(newTable);
        freeTables.add(newTable);
		if(creatorID.length() > 0){
			joinTable(creatorID, newID);
		}
        return true;
    }
}
