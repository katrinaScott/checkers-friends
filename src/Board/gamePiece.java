/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package checkersgame;

import java.awt.Color;

/**
 *
 * @author joehenning
 */
public class gamePiece {

    private int row;
    private int col;
    public Color color;
    int serversBoard[][] = new int[8][8];

    public gamePiece(Color c, int row, int col) {

        color = c;
        this.row = row;
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    
}
