package javasnake;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Snake {
    
    public ArrayList<Block> SNAKE = new ArrayList<Block>();
    public int D = 0;
    
    public Snake() {
        SNAKE.add(new Block(1, 4, Color.orange));
        SNAKE.add(new Block(1, 3, Color.yellow));
        SNAKE.add(new Block(1, 2, Color.yellow));
        SNAKE.add(new Block(1, 1, Color.yellow));
    }
    
    public void addEat(int x, int y) {
        SNAKE.add(new Block(x, y, Color.yellow));
    }
    
    public void draw(Graphics g) {
        for(Block block : SNAKE)
            block.draw(g);
    }
}
