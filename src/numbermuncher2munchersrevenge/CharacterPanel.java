/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numbermuncher2munchersrevenge;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

/**
 *
 * @author Don Adley Jr
 */

/**
 * 
 * Creates a Panel that will hold either the Main Character or the enemies
 */
public class CharacterPanel extends JPanel {
//    private Character character;
    private boolean occupiedbyHero = false;
    private boolean occupiedbyEnemy = false;
    private boolean hasAnswer = false;
    private final Color panelColor = Color.BLUE;
    private int answer;
    private mobHero hero;
    private mobEnemy enemy;
    private Dimension dem;
    private int panelNumber;
    
    public CharacterPanel(){
        dem = new Dimension(200,200);
        this.setBackground(panelColor);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.setPreferredSize(dem);
        
        hero = new mobHero();
        enemy = new mobEnemy();
    }
    
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setFont(new Font("TimesRoman", Font.BOLD, 40));
        g.setColor(Color.WHITE); 
        if(hasAnswer)g.drawString(String.valueOf(answer), dem.width/2, dem.height/2);
        if(occupiedbyHero) hero.draw(g); 
        if(occupiedbyEnemy) enemy.draw(g);
                           
              
    }

    public int getAnswer() {
        return answer;
    }
    
    public void setAnswer(int answer) {
        this.answer = answer;
    }
    
    public void toggleHeroLocation(){
        occupiedbyHero = !occupiedbyHero;
    }
    
    public void toggleEnemyLocation(){
        occupiedbyEnemy = !occupiedbyEnemy;
    }
    
    public boolean ifoccupiedbyHero(){
      return occupiedbyHero;  
    }
    
    public boolean ifoccupiedbyEnemy(){
      return occupiedbyEnemy;  
    }
    
    public boolean isLoser(){
        return (ifoccupiedbyHero() && ifoccupiedbyEnemy());
    }
    
    public void toggleAnswer(){
        hasAnswer = !hasAnswer;
        repaint();
        revalidate();
    }
    public boolean hasAnswer(){
        return hasAnswer;
    }
}
