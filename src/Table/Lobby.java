/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Table;

import src.UI.LobbyPanel;
import java.util.ArrayList;
import java.util.Hashtable;
import src.UI.TablePanel;

/**
 *
 * @author XanderH11
 */
public class Lobby extends Place {
    public ArrayList<Table> tables = new ArrayList<Table>();
    ArrayList<String> players;// = new ArrayList<Player>();
    public ArrayList<Table> freeTables = new ArrayList<Table>();
//    ArrayList<Table> playingTables = new ArrayList<Table>();
    LobbyPanel frontend;
    
    public Lobby(){
        super();
        Hashtable<Integer, Table> hash = new Hashtable();
        for(int i=-1; i< 9; i++){
            Table element = new Table(i);
            tables.add(element);
            freeTables.add(element);
            hash.put(i, element);
        }
        // fill preexisting tables before building panel
        frontend = new LobbyPanel(hash, this);
		//TODO get list of players from the server? to display for people to select for private chats?
        
    }
    
    public boolean joinTable(int table){
        for(int i=0; i < freeTables.size(); i++){
            if(freeTables.get(i).getID() == table){
                //TODO make request
                TablePanel response = freeTables.get(i).requestToPlay();
//                if (response != null) {
//                    response.setVisible(true);
//                }
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
    
    public boolean createTable(int newID, int join){
        if(newID > tables.size()) {
            Table newTable = new Table(newID);
            tables.add(newTable);
            freeTables.add(newTable);
        }
        if (join == 1){
            joinTable(newID);
        }
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
    
    public void addTable(int tid) {
    	frontend.addTable(tid, 0);
    }
}
