/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numbermuncher2munchersrevenge;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Label;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Don Adley Jr
 */
/**
 * Creates and maintains the score of the game
 * 
 */
public class ScoreBoard extends JPanel{
    private int score;
    JPanel contentPane = this;
    // Number of lives the player has left
    private int lives = 3;
   
    
    public ScoreBoard(){
        this.setPreferredSize(new Dimension(200,800));
        this.setBackground(Color.yellow);

    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        JLabel label = new JLabel();
       
        ImageIcon image = new ImageIcon("src/mobHero.gif");

        if(lives > 0) g.drawImage(image.getImage(), 0, 0, null);
        if(lives > 1) g.drawImage(image.getImage(), 0, (200), null);
        if(lives > 2) g.drawImage(image.getImage(), 0, (400), null);
        
        g.drawString("Score: ", this.getWidth()/2, this.getHeight());
    }
}
