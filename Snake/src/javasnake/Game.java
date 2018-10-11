package javasnake;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javasnake.JavaSnake.HEIGHT_BLOCK;
import static javasnake.JavaSnake.SIZE_BLOCK;
import static javasnake.JavaSnake.SPEED;
import static javasnake.JavaSnake.TITLE;
import static javasnake.JavaSnake.WIDTH_BLOCK;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends JFrame implements ActionListener {
    
    public static final Color BACKGROUND_COLOR = Color.black;
    public static Snake SAE = new Snake();
    public static Food FOOD = new Food();
    public static int SCORE = 0;
    
    public Canvas canvas;
    
    private Timer timer = new Timer(SPEED, this);
    
    public Game() {
        canvas = new Canvas();
        canvas.setBackground(BACKGROUND_COLOR);
        
        super.setTitle(TITLE + " : " + SCORE);
        super.setSize(WIDTH_BLOCK * SIZE_BLOCK + 7, HEIGHT_BLOCK * SIZE_BLOCK + 30);
        super.setVisible(true);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setResizable(false);
        super.add(canvas);
        
        addKeyListener(new KeyAdapter());
        timer.start();
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = SAE.SNAKE.size() - 1; i > 0; i--) {
            SAE.SNAKE.get(i).setX(SAE.SNAKE.get(i-1).getX());
            SAE.SNAKE.get(i).setY(SAE.SNAKE.get(i-1).getY());
        }
        
        setD(SAE.D);
        
        if(SAE.SNAKE.get(0).getX() == FOOD.x &&
                SAE.SNAKE.get(0).getY() == FOOD.y)
            eat();
        
        for(int i = 1; i < SAE.SNAKE.size(); i++)
            if(SAE.SNAKE.get(i).getX() == SAE.SNAKE.get(0).getX()
                    && SAE.SNAKE.get(i).getY() == SAE.SNAKE.get(0).getY())
                die();
        
        canvas.repaint();
    }
    
    public void setD(int d) {
        if(d == 0) {
            SAE.SNAKE.get(0).setY(SAE.SNAKE.get(0).getY() + 1);
            if(SAE.SNAKE.get(0).getY() == HEIGHT_BLOCK)
                SAE.SNAKE.get(0).setY(0);
        }
        else if(d == 1) {
            SAE.SNAKE.get(0).setY(SAE.SNAKE.get(0).getY() - 1);
            if(SAE.SNAKE.get(0).getY() == -1)
                SAE.SNAKE.get(0).setY(HEIGHT_BLOCK-1);
        }
        else if(d == 2) {
            SAE.SNAKE.get(0).setX(SAE.SNAKE.get(0).getX() + 1);
            if(SAE.SNAKE.get(0).getX() == WIDTH_BLOCK)
                SAE.SNAKE.get(0).setX(0);
        }
        else {
            SAE.SNAKE.get(0).setX(SAE.SNAKE.get(0).getX() - 1);
            if(SAE.SNAKE.get(0).getX() == -1)
                SAE.SNAKE.get(0).setX(WIDTH_BLOCK-1);
        }
    }
    
    public void eat() {
        FOOD = new Food();
        
        SAE.addEat(SAE.SNAKE.get(SAE.SNAKE.size() - 1).getX(), SAE.SNAKE.get(SAE.SNAKE.size() - 1).getY());
        
        SCORE += 10;
        super.setTitle(TITLE + " : " + SCORE);
    }
    
    public void die() {
        FOOD = new Food();
        SAE = new Snake();
        SCORE = 0;
        super.setTitle(TITLE + " : " + SCORE);
    }
}
