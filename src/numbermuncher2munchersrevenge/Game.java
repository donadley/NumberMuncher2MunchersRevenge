/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numbermuncher2munchersrevenge;

import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 * The panel that contains the game
 * @author Don Adley Jr
 */
public class Game extends JPanel{
    private final int IMAGE_SIZE = 35;
    private mobHero hero;
    private mobEnemy enemy;
    private GameRules gameRules;
    private CharacterPanel[][] panelArray;
    private GameQuestions question;
    private EnemyMovement enemymovement;
    private int[][] questions;
    private ArrayList[][] doublearray;
    
    public Game(CharacterPanel[][] panelArray){
      
        this.panelArray = panelArray;
        gameRules = new GameRules();        
        hero  = new mobHero();
        enemy  = new mobEnemy();
        question = new GameQuestions(25);
        questions = question.createAnswers();
        this.add(new Label(question.getQuestion()));
        panelArray[hero.getPosX()][hero.getPosY()].toggleHeroLocation();
        
        //iterates through the panelArray and places answers in each panel
        int count = 0;
        System.out.println("length " +panelArray.length);
        for(int i = 0; i < panelArray.length-1; i++){
            for(int j = 0; j < panelArray[i].length-1; j++){
                System.out.println("Count in game: " + count);
                int tempint;
                tempint = questions[i][j];
                panelArray[i][j].setAnswer(tempint);
                panelArray[i][j].toggleAnswer();
                count++;                
            }}
        // Sets the focus to the gamepanel
        setFocusable(true);
        requestFocusInWindow();
        addKeyListener(new DirectionListener());
    }
    
    public class DirectionListener implements KeyListener
   {
      //--------------------------------------------------------------
      //  Responds to the user pressing arrow keys by adjusting the
      //  image and image location accordingly.
      //--------------------------------------------------------------
      @Override
      public void keyPressed (KeyEvent event)
      {
         switch (event.getKeyCode())
         {
            case KeyEvent.VK_UP:
                if(BorderCheck(hero.getPosX(),hero.getPosY()-1)){
                    panelArray[hero.getPosX()][hero.getPosY()].toggleHeroLocation();
                    hero.setPosY(hero.getPosY()-1);
                    moveCharacter(hero.getPosX(),hero.getPosY(),0);
                    System.out.println("up pressed");
//                    int x = enemymovement.moveEnemy();
//                    enemy.randomMovement(x);
//                    while(BorderCheck(enemy.getPosX(),enemy.getPosY())){// while enemy is not off of the board
//                        x = enemymovement.moveEnemy();
//                        enemy.randomMovement(x);
//                        moveCharacter(enemy.getPosX(),enemy.getPosY(),1);
//                    }
                }else{
                    System.out.println("Can't go that far");
                }
                break;
            case KeyEvent.VK_DOWN:
                if(BorderCheck(hero.getPosX(),hero.getPosY()+1)){
                    panelArray[hero.getPosX()][hero.getPosY()].toggleHeroLocation();
                    hero.setPosY(hero.getPosY()+1);
                    moveCharacter(hero.getPosX(),hero.getPosY(),0);
                     //Enemy Movement
//                    int x = enemymovement.moveEnemy();
//                    enemy.randomMovement(x);
//                    while(BorderCheck(enemy.getPosX(),enemy.getPosY())){// while enemy is not off of the board
//                        x = enemymovement.moveEnemy();
//                        enemy.randomMovement(x);
//                        moveCharacter(enemy.getPosX(),enemy.getPosY(),1);
//                    }
                }else{
                    System.out.println("Can't go that far");
                }
                break;
            case KeyEvent.VK_LEFT:
                if(BorderCheck(hero.getPosX()-1,hero.getPosY())){
                    panelArray[hero.getPosX()][hero.getPosY()].toggleHeroLocation();
                    hero.setPosX(hero.getPosX()-1);
                    moveCharacter(hero.getPosX(),hero.getPosY(),0);
//                    int x = enemymovement.moveEnemy();
//                    enemy.randomMovement(x);
//                    while(BorderCheck(enemy.getPosX(),enemy.getPosY())){// while enemy is not off of the board
//                        x = enemymovement.moveEnemy();
//                        enemy.randomMovement(x);
//                        moveCharacter(enemy.getPosX(),enemy.getPosY(),1);
//                    }
                }else{
                    System.out.println("Can't go that far");
                }
                break;
            case KeyEvent.VK_RIGHT:
                if(BorderCheck(hero.getPosX()+1,hero.getPosY())){
                    panelArray[hero.getPosX()][hero.getPosY()].toggleHeroLocation();
                    hero.setPosX(hero.getPosX()+1);
                    moveCharacter(hero.getPosX(),hero.getPosY(),0);
                     //Enemy Movement
//                    moveCharacter(enemy.getPosX(),enemy.getPosY(),1);
                }else{
                    System.out.println("Can't go that far");
                }                 
                break;
         case KeyEvent.VK_SPACE: 
             gameRules.checkAnswer(panelArray,question);                      
         }}

        @Override
        public void keyTyped(KeyEvent ke) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public void keyReleased(KeyEvent ke) {
//            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
    
    // Checks to see if the charcter is able to move in a direction
    public boolean BorderCheck(int x, int y){        
        return panelArray.length-2 >= x && panelArray.length-2 >= y && 0 <= x && 0 <= y;
             
    }
    
    // A Hero is 0, Enemy is 1
    public void moveCharacter(int x, int y, int character){        
            CharacterPanel panel = (CharacterPanel)panelArray[x][y];
            switch(character){
                case 0:
                    panel.toggleHeroLocation();
                break;
                case 1:
                    panel.toggleEnemyLocation();
                break;
            }
    }   
}