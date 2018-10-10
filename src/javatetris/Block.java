package javatetris;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import static javatetris.JavaTetris.SIZE_BLOCK;

public class Block {
    private int x;
    private int y;
    private Color color; 
    
    public Block(int x, int y, Color color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }
    
    public void draw(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        g2d.setColor(color);
        g2d.fillRect(x * SIZE_BLOCK, y * SIZE_BLOCK, SIZE_BLOCK, SIZE_BLOCK);
    }
}
