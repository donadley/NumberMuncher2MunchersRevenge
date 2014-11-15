/**
 * @author Seth
 */

package numbermuncher2munchersrevenge;

import java.awt.Graphics;

/**
 * @author Seth
 * Just the mobile interface. 
 */

public interface mobInterface {

    void draw(Graphics page);
    
    void setPosX(int posX);
    void setPosY(int posY);
    
    int getPosX();
    int getPosY();
    
    void setEating(boolean eat);
}
