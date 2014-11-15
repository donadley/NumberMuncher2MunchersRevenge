/*
 * @author Seth
 */
package numbermuncher2munchersrevenge;

import java.awt.Graphics;
import javax.swing.ImageIcon;


public class mobHero implements mobInterface {

    int x,y;
    boolean eating;
    ImageIcon icon = new ImageIcon();
    public mobHero (){
        x = 1;
        y = 1;
        eating = false;
    }
    
    public mobHero (int thisX, int thisY, boolean isEating){
        x = thisX;
        y = thisY;
        eating = isEating;
    }
    
    @Override
    public void draw(Graphics page) {
//        if (this.eating){           
        icon = new ImageIcon("src/mobHero.gif");
//        } else {
//          icon = new ImageIcon("src/img/mobHeroEating.gif");
//        }
        page.drawImage(icon.getImage(), 50, 50, null);
    }

    @Override
    public void setPosX(int posX) {
        this.x = posX;
    }

    @Override
    public void setPosY(int posY) {
        this.y = posY;
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
        this.eating = eat;
    }
    
}
