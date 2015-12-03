/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Table;

import src.UI.LobbyPanel;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 *
 * @author XanderH11
 */
public class Lobby extends Place {
    ArrayList<Table> tables = new ArrayList<Table>();
    ArrayList<String> players;// = new ArrayList<Player>();
    ArrayList<Table> freeTables = new ArrayList<Table>();
//    ArrayList<Table> playingTables = new ArrayList<Table>();
    LobbyPanel frontend;
    
    public Lobby(){
        super();
        Hashtable<Integer, Table> hash = new Hashtable();
        frontend = new LobbyPanel(hash, this);
		//TODO get list of players from the server? to display for people to select for private chats?
        
    }
    
    public boolean joinTable(int table){
        for(int i=0; i < freeTables.size(); i++){
            if(freeTables.get(i).getID() == table){
                //TODO make request
                freeTables.get(i).requestToPlay();
                return true;
            }else{
                
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
        joinTable(newID);
        return true;
    }
    
    public void refresh(String[] playerIDs){
        //TODO not sure what to put here?
        for(int i=0; i<playerIDs.length; i++){
            players.add(playerIDs[i]);
        }
    }
    
    public void add(String playerID){
        //TODO
        players.add(playerID);
    }
    
    public void remove(String playerID){
        //TODO
        players.remove(playerID);
    }
    
    public LobbyPanel getLobbyPanel(){
        return frontend;
    }
}
