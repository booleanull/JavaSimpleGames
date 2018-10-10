package javatetris;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import static javatetris.Game.FIGURE;
import static javatetris.Game.TICKER;

public class KeyAdapt extends KeyAdapter{
    public void keyPressed(KeyEvent event) {
        int key = event.getKeyCode();
        
        if(key == KeyEvent.VK_LEFT)
            FIGURE.moveLR(-1);
        if(key == KeyEvent.VK_RIGHT)
            FIGURE.moveLR(1);
        if(key == KeyEvent.VK_UP)
            FIGURE.rotate();
        if(key == KeyEvent.VK_DOWN)
            TICKER++;
    }
}
