/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Board;

import static src.Board.Squares.BackgroundColor.DARK;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

/**
 *
 * @author joe
 */
public final class Squares extends Canvas {

    private gamePiece occupant;

    public enum BackgroundColor {

        LIGHT, DARK
    };
    private BackgroundColor bgColor;
    private boolean hasPiece;
    private int row;
    private int column;

    public Squares(BackgroundColor squareColor, int row, int column) {

        this.setSize(64, 64);

        if (squareColor == BackgroundColor.DARK) {
            this.setBackground(Color.BLACK);
            this.setBgColor(DARK);
        } else {
            this.setBackground(Color.GRAY);
        }
        this.row = row;
        this.column = column;

    }

    public void theGamePiece(gamePiece visitor) {
        if (visitor != null) {

            this.occupant = visitor;
            this.hasPiece = true;

        }
    }

    public BackgroundColor getBgColor() {
        return bgColor;
    }

    public void setBgColor(BackgroundColor bgColor) {
        this.bgColor = bgColor;
    }

    public boolean hasPiece() {
        return hasPiece;
    }

    public void setHasPiece(boolean hasPiece) {
        this.hasPiece = hasPiece;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    @Override
    public void paint(Graphics g) {

        if (this.getBgColor() == Squares.BackgroundColor.DARK) {
            this.setBackground(Color.BLACK);
        } else {
            this.setBackground(Color.GRAY);
        }
        if (this.hasPiece()) {
            g.setColor(occupant.getColor());
            g.fillOval(5, 5, 54, 54);

        } else {
            g.clearRect(0, 0, 64, 64);
        }

    }
}
