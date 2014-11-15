/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numbermuncher2munchersrevenge;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JPanel;

/**
 *
 * @author Don Adley Jr
 */

/**
 * Create a JPanel which is a tile for the game board
 */
public class GameBoard extends JPanel {
    private CharacterPanel[][] grid;
   
    public GameBoard(int width, int height){
        this.setLayout(new FlowLayout());
//        Dimension dim = new Dimension(1000,1000);
//        this.setPreferredSize(dim);
        JPanel panel = new JPanel();        
        panel.setLayout(new GridLayout(width, height));
        grid = new CharacterPanel[width][height];
        for(int y = 0; y < height-1; y++){ 
            for(int x = 0; x < width-1; x++){
                    grid[x][y] = new CharacterPanel();   
                    panel.add(grid[x][y]);
            }
        }
        this.add(panel);
        this.add(new ScoreBoard());
    }
    public CharacterPanel[][] getGrid(){
        return grid;
    }
}
