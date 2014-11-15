/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package numbermuncher2munchersrevenge;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

/**calls characterPanel for movement
 * this class keeps track of the location of character
 * responsibility of key controls (arrows and space bar) have been moved to Game Class 
 * @author Tiaerra
 */
public class GameRules  {
    private CharacterPanel panel; // Panel currently being checked
    //if muncher eats incorrect answer, game over/lose life (iterate 3 times)
    //if muncher eats/touches enemy, game over/lose life(iterate 3 times)
    //
    public GameRules()
    {        
        //call problem class
        //check for answer
        //display "You Lose" if wrong answer is choses or if frog is in same location as enemy
        //display introduction
        //go through array of panels to see if isLoser() (from the CharacterPanel) is true
        //GameQuestions questions = new GameQuestions();//GameQuestions object
        // something is missing....
        
 }

    // run when spacebar is pressed
    //  Checks all panel in the array to check the position of the hero
    // Check to see if the answer choosen was correct
    public void checkAnswer(CharacterPanel[][] panelArray, GameQuestions gameQuestion) // GameQ -> int[][]
    {   
        System.out.println("panelArray.length " + panelArray.length);
        for(int i = 0; i < panelArray.length-1; i++){
            for(int j = 0; j < panelArray[i].length-1; j++){
//                System.out.println(questions.size());
                panel = (CharacterPanel)panelArray[i][j];
                
                if(panel.ifoccupiedbyHero()){
                    if(gameQuestion.getCorrectAnswers().contains(panel.getAnswer())){
                       gameQuestion.getCorrectAnswers().remove(panel.getAnswer());
                       if(panel.hasAnswer())panel.toggleAnswer();
                        System.out.println("Right answer " + panel.getAnswer() + " has been"
                                + " taken from the list!!");
                    }else{
                        //Wrong Answer
                        JOptionPane.showMessageDialog(panel, "Wrong answer... Game Over!!");
                        System.out.println("Wrong answer... Game Over!!");
                    }                   
                }else{
                    System.out.println("Hmm... The hero can't be found. must have taken a nap");
                }                 
            }
        }
    }
    
    // Ran every move, check to see if the enemy and hero are in the same panel
    public void eaten(CharacterPanel[][] panelArray)
    {
        for(int i = 0; i <= panelArray.length; i++){
            for(int j = 0; j <= panelArray[i].length; j++){
                panel = (CharacterPanel)panelArray[i][j];
                if(panel.isLoser()){    
                    System.out.println("You've been eaten...GAME OVER!!");
                }
            }
        }
    //revalidate and repaint with enemy eating
    }
}
     
