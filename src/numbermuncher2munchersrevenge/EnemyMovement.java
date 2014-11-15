/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package numbermuncher2munchersrevenge;

import java.util.Random;

/**
 *
 * @author Don Adley Jr
 */
public class EnemyMovement {
    private mobEnemy enemy;
    private Random rand;
    
    public EnemyMovement(){
         enemy = new mobEnemy();
    }
    
    // Move the enemy using a random number between 0 -3
    public int moveEnemy(){
        return rand.nextInt(3);
    }
    
}
