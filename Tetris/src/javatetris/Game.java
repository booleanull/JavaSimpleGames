package javatetris;

import javatetris.figures.JFigure;
import javatetris.figures.Figure;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import static javatetris.figures.Figure.getFigure;
import static javatetris.JavaTetris.HEIGHT_BLOCK;
import static javatetris.JavaTetris.SIZE_BLOCK;
import static javatetris.JavaTetris.SPEED;
import static javatetris.JavaTetris.TITLE;
import static javatetris.JavaTetris.WIDTH_BLOCK;
import javax.swing.JFrame;
import javax.swing.Timer;

public class Game extends JFrame implements ActionListener {
    
    public static ArrayList<Block> GROUND = new ArrayList<Block>();
    public static int PGROUND[] = new int[HEIGHT_BLOCK];
    public static Figure FIGURE;
    
    public static final Color BACKGROUND_COLOR = Color.black;
    public static int TICKER = 0;
    
    public static int SCORE = 0;
    
    private Canvas canvas = new Canvas();
    private Timer timer = new Timer(SPEED, this);
    
    public Game() {
        super.setTitle(TITLE + SCORE);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setVisible(true);
        super.setResizable(false);
        super.setSize(SIZE_BLOCK * WIDTH_BLOCK + 7, SIZE_BLOCK * HEIGHT_BLOCK + 30);
        super.add(canvas);
        
        addKeyListener(new KeyAdapt());
        
        canvas.setBackground(BACKGROUND_COLOR);
        canvas.setFocusable(true);
        
        FIGURE = getFigure();
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        TICKER++;
        if(TICKER >= 10)
            doTick();
        
        canvas.repaint();
    }
    
    public void doTick() {
        FIGURE.move();
        TICKER = 0;
    }
    
    public static void gameOver() {
        for(int i = 0; i < HEIGHT_BLOCK; i++)
            PGROUND[i] = 0;
        
        removeBlocks();
        
        FIGURE = getFigure();
        
        SCORE = 0;
        Game.getFrames()[0].setTitle(TITLE + SCORE);
    }
    
    public static void removeBlocks() {
        for(Block block : GROUND) { 
            GROUND.remove(block);
            removeBlocks();
            return;
        }
    }
}