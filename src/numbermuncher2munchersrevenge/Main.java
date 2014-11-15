/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numbermuncher2munchersrevenge;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 *
 * @author Don Adley Jr
 */
public class Main {
   
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
        int width = gd.getDisplayMode().getWidth();
        int height = gd.getDisplayMode().getHeight();
        // Sizes of the screen (not being used)
        Dimension ScreenSize = new Dimension(width,height);
        Dimension HalfScreenSize = new Dimension(width/2,height/2);
        
        //Make a new Game and a new Board
        final GameBoard panel = new GameBoard(6,6);   
        JPanel gamePanel = new Game(panel.getGrid());
        gamePanel.add(panel);       
        
        // Frame set up
        JFrame frame =new JFrame();        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(gamePanel);        
        frame.pack(); 
        frame.setVisible(true); 
        
        // Repainting after every 100 to move gifs
         Timer timer = new Timer(100, new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent ae) {
                panel.repaint();
            }
            
        });
        timer.start();
    }
}
    
    