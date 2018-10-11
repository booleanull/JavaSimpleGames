package javasnake;

import java.awt.Color;
import java.util.Random;
import static javasnake.Game.SAE;
import static javasnake.JavaSnake.HEIGHT_BLOCK;
import static javasnake.JavaSnake.WIDTH_BLOCK;

public class Food extends Block {
    
    public static final Color COLOR = Color.red;
    
    public int x;
    public int y;
    
    public Food() {
        super(0, 0, COLOR);
        randomFood();
        
        setX(x);
        setY(y);
    }
    
    public void randomFood() {
        Random random = new Random();
        x = random.nextInt(WIDTH_BLOCK);
        y = random.nextInt(HEIGHT_BLOCK);
        
        for(Block block : SAE.SNAKE)
            if(block.getX() == x && block.getY() == y)
                randomFood();
    }
}
