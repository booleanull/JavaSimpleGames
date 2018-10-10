package javatetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static javatetris.JavaTetris.HEIGHT_BLOCK;
import static javatetris.JavaTetris.SIZE_BLOCK;
import static javatetris.JavaTetris.WIDTH_BLOCK;

public class Borders {
    
    public static final Color COLOR = Color.gray;
    
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(COLOR);
        for(int i = 0; i < WIDTH_BLOCK+1; i++)
            g2d.drawLine(SIZE_BLOCK * i, 0, SIZE_BLOCK * i, SIZE_BLOCK * HEIGHT_BLOCK);
        
        for(int i = 0; i < HEIGHT_BLOCK+1; i++)
            g2d.drawLine(0, SIZE_BLOCK * i, SIZE_BLOCK * WIDTH_BLOCK, SIZE_BLOCK * i);
        
        g2d.setColor(Color.ORANGE);
        g2d.drawLine(0, SIZE_BLOCK * 3, SIZE_BLOCK * WIDTH_BLOCK, SIZE_BLOCK * 3);
    }
}
