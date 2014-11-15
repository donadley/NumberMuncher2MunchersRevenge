/*
 * 
 * @author Seth
 */
package numbermuncher2munchersrevenge;

import java.awt.Graphics;
import javax.swing.ImageIcon;


public class mobEnemy implements mobInterface {

    int x,y;
    boolean eating;
    ImageIcon icon = new ImageIcon();
    
    public mobEnemy(){
        x = 1;
        y = 1;
        eating = false;
    }
    
    public mobEnemy (int thisX, int thisY){
        x = thisX;
        y = thisY;
    }
    
    @Override
    public void draw(Graphics page) {
        ImageIcon image = new ImageIcon("src/mobEnemy.gif");
        page.drawImage(image.getImage(), 0, 0, null);
//        icon = new ImageIcon("src/img/mobEnemy.gif");
    }

    @Override
    public void setPosX(int posX) {
        this.x = posX;
    }

    @Override
    public void setPosY(int posY) {
        this.y = posY;
    }
    
    public void randomMovement(int intDirection) {
       switch (intDirection) {
        case 1:
            this.x += this.x;
            break;
        case 2: 
            this.x -= this.x;
            break;
        case 3:
            this.y += this.y;
            break;
        case 4:
            this.y -= this.y;
            break;
       }   
    }
    
    @Override
    public int getPosX() {
        return this.x;
    }

    @Override
    public int getPosY() {
        return this.y;
    }
    
    @Override
    public void setEating(boolean eat){
        
    }
    
}
