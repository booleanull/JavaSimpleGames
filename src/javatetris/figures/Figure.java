package javatetris.figures;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;
import javatetris.Block;
import javatetris.Game;
import static javatetris.Game.GROUND;
import static javatetris.JavaTetris.HEIGHT_BLOCK;
import static javatetris.Game.FIGURE;
import static javatetris.Game.PGROUND;
import static javatetris.Game.SCORE;
import static javatetris.Game.gameOver;
import static javatetris.JavaTetris.TITLE;
import static javatetris.JavaTetris.WIDTH_BLOCK;

public abstract class Figure {
    
    public ArrayList<Block> figure = new ArrayList<Block>();
    public Block blocks[] = new Block[WIDTH_BLOCK];
    public Color color;
    public int rotate;
    
    public static Figure getFigure() {
        Random random = new Random();
        int rand = random.nextInt(7);
        
        switch(rand) {
            case 0:
                return new IFigure();
            case 1:
                return new JFigure();
            case 2:
                return new LFigure();
            case 3:
                return new OFigure();
            case 4:
                return new SFigure();
            case 5:
                return new TFigure();
            default:
                return new ZFigure();
        }
    }
    
    public abstract void rotate();
    
    public void moveLR(int i) {
        for(Block block : figure) {
            for(Block ground : GROUND) 
                if(block.getX() + i == ground.getX() && ground.getY() == block.getY()) {
                    return;
                }
                
            if(block.getX() + i == -1 || block.getX() + i == WIDTH_BLOCK) {
                return;
            }
        }
        
        for(Block block : figure) 
            block.setX(block.getX() + i);
    }
    
    public void addBlock(int x, int y) {
        figure.add(new Block(x, y, color));
    }
    
    public void draw(Graphics g) {
        for(Block block : figure) {
            block.draw(g);
        }
    }
    
    public void move() {
        for(Block block : figure) {
            for(Block ground : GROUND) 
                if(block.getX() == ground.getX() && ground.getY() == block.getY() + 1) {
                    punch();
                    return;
                }
                
            if(block.getY() == HEIGHT_BLOCK - 1) {
                punch();
                return;
            }
        }
        
        for(Block block : figure)
            block.setY(block.getY() + 1);
    }
    
    public void punch() {
        for(Block blockf : figure) {
            if(blockf.getY() < 3) {
                gameOver();
                return;
            }
            
            GROUND.add(blockf);
            PGROUND[blockf.getY()]++;
        }
        
        for(int i = 0; i < HEIGHT_BLOCK; i++)
            if(PGROUND[i] == WIDTH_BLOCK)
                clearGround(i);
        
        FIGURE = getFigure();
    }
    
    public void clearGround(int a) { 
        int i = 0;
        for(Block blockf : GROUND)
            if(blockf.getY() == a) {
                blocks[i] = blockf;
                i++;
            }
        
        for(int j = 0; j < WIDTH_BLOCK; j++)
            GROUND.remove(blocks[j]);
        
        for(Block block : GROUND)
            if(block.getY() < a)
                block.setY(block.getY() + 1);
        
        for(int j = a; j > 0; j--)
            PGROUND[j] = PGROUND[j-1];
        
        SCORE += 100;
        Game.getFrames()[0].setTitle(TITLE + SCORE);
    }
}
