/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package checkersgame;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author joe
 */
public class CheckersGame {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        MakeBoard MaketheBoard = new MakeBoard();

        JFrame myFrame = new JFrame("Checkers An Friends");
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(new FlowLayout());

        JPanel boardpanel = new JPanel(new GridLayout(8, 8));

        Board theGameBoard = new Board();

        MaketheBoard.generateBoard(theGameBoard, boardpanel);
        myFrame.add(boardpanel);
        myFrame.pack();

        myFrame.setVisible(true);

    }

}
