package javasnake;

import java.awt.event.KeyEvent;
import static javasnake.Game.SAE;

public class KeyAdapter extends java.awt.event.KeyAdapter{
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT)
            if(SAE.D != 2)
                SAE.D = 3;
        if(key == KeyEvent.VK_RIGHT)
            if(SAE.D != 3)
                SAE.D = 2;
        if(key == KeyEvent.VK_UP)
            if(SAE.D != 0)
                SAE.D = 1;
        if(key == KeyEvent.VK_DOWN)
            if(SAE.D != 1)
                SAE.D = 0;
    }
}
