/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Board;

/**
 *
 * @author joe
 */
public class Board {

    public final int rows = 8;
    public final int columns = 8;
    private Squares[][] theBoard;
    int serverBoardArray[][] = new int[8][8];
    

    public Board() {
        theBoard = new Squares[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (i % 2 == j % 2) {
                    theBoard[i][j] = new Squares(Squares.BackgroundColor.DARK, i, j);
                } else {
                    theBoard[i][j] = new Squares(Squares.BackgroundColor.LIGHT, i, j);
                }
            }
        }
       
    }
    
    

    public Squares[][] getTheBoard() {
        return theBoard;
    }

    public void setTheBoard(Squares[][] theBoard) {
        this.theBoard = theBoard;
    }

    public Squares getSquare(int row, int col) {

        return theBoard[row][col];


    }
}
