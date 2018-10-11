package javasnake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static javasnake.JavaSnake.HEIGHT_BLOCK;
import static javasnake.JavaSnake.SIZE_BLOCK;
import static javasnake.JavaSnake.WIDTH_BLOCK;

public class Borders {
    
    public static final Color COLOR = Color.gray;
    
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(COLOR);
        
        for(int i = 0; i < HEIGHT_BLOCK + 1; i++)
            g2d.drawLine(0, SIZE_BLOCK * i, WIDTH_BLOCK * SIZE_BLOCK, SIZE_BLOCK * i);
        
        for(int i = 0; i < WIDTH_BLOCK + 1; i++)
            g2d.drawLine(SIZE_BLOCK * i, 0, SIZE_BLOCK * i, HEIGHT_BLOCK * SIZE_BLOCK);
    }
}
