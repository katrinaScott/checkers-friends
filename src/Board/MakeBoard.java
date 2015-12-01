/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package src.Board;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author joe
 */
public final class MakeBoard {

    ServerBoardView serverBoard;
    
    public void generateBoard(Board theBoard, JPanel thePanel) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Squares theSquare = theBoard.getSquare(i, j);

                JPanel ContainerPanel = new JPanel(new FlowLayout());
                ContainerPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

                if (theSquare.getBgColor() == Squares.BackgroundColor.DARK) {
                    ContainerPanel.setBackground(Color.BLACK);
                    theSquare.setBgColor(Squares.BackgroundColor.DARK);
                    //System.out.println("BLACK");
                } else {
                    ContainerPanel.setBackground(Color.LIGHT_GRAY);
                    //System.out.println("Gray");
                    theSquare.setBgColor(Squares.BackgroundColor.LIGHT);
                }
                thePanel.add(ContainerPanel);
                ContainerPanel.add(theSquare);
            }

        }
        initialPieces(theBoard);
    }

    public void initialPieces(Board theBoard) {

        serverBoard = new ServerBoardView();
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 8; j++) {

                Squares theSquare = theBoard.getSquare(i, j);

                if (theSquare.getBgColor() == Squares.BackgroundColor.LIGHT) {
                    theBoard.getSquare(i, j).theGamePiece(new gamePiece(Color.WHITE, i, j));
                }
            }
        }

        for (int i = 5; i < 8; i++) {
            for (int j = 0; j < 8; j++) {

                Squares theSquare = theBoard.getSquare(i, j);

                if (theSquare.getBgColor() == Squares.BackgroundColor.DARK) {
                    theBoard.getSquare(i, j).theGamePiece(new gamePiece(Color.RED, i, j));
                }
            }
        }

    }

}
