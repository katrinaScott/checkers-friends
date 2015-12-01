/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkersgame;

/**
 *
 * @author joehenning
 */
public class ServerBoardView {

    String state;
    byte[][] boardState = new byte[8][8];
    
    public ServerBoardView() {
        
        
    }

    public String getState() {
        return state;
    }

    public void setValue(int a, int b, int value)
    {
        this.boardState[a][b] = (byte) value;
    }
    
    public void setState(String state) {
        this.state = state;
    }

    public byte[][] getBoardState() {
        return boardState;
    }

    public void setBoardState(byte[][] boardState) {
        this.boardState = boardState;
    }
    
    
    
}
   
    