package javatetris.figures;

import java.awt.Color;
import javatetris.Block;
import static javatetris.Game.GROUND;
import static javatetris.JavaTetris.HEIGHT_BLOCK;
import static javatetris.JavaTetris.WIDTH_BLOCK;

public class TFigure extends Figure {
    public TFigure() {
        color = Color.red;
        addBlock(4,1);
        addBlock(3,1);
        addBlock(5,1);
        addBlock(4,0);
    }

    @Override
    public void rotate() {
        int x = figure.get(0).getX();
        int y = figure.get(0).getY();
        
        switch(rotate) {
            case 0: {
                if(y > HEIGHT_BLOCK -2)
                    return;
                
                for(Block block : GROUND)
                    if((block.getX() == x && block.getY() == y) ||
                            (block.getX() == x+1 && block.getY() == y+1) ||
                            (block.getX() == x+1 && block.getY() == y-1) ||
                            (block.getX() == x+1 && block.getY() == y))
                        return;

                figure.clear();

                addBlock(x, y);
                addBlock(x+1, y+1);
                addBlock(x+1, y-1);
                addBlock(x+1, y);
                rotate++;
                break;
            }
            case 1: {
                if(x < 1)
                    return;
                
                for(Block block : GROUND)
                    if((block.getX() == x && block.getY() == y) ||
                            (block.getX() == x-1 && block.getY() == y-1) ||
                            (block.getX() == x+1 && block.getY() == y-1) ||
                            (block.getX() == x && block.getY() == y-1))
                        return;
                
                figure.clear();

                addBlock(x, y);
                addBlock(x-1, y-1);
                addBlock(x+1, y-1);
                addBlock(x, y-1);
                rotate++;
                break;
            } 
            case 2: {
                if(y > HEIGHT_BLOCK -2)
                    return;
                
                for(Block block : GROUND)
                    if((block.getX() == x && block.getY() == y) ||
                            (block.getX() == x-1 && block.getY() == y+1) ||
                            (block.getX() == x-1 && block.getY() == y-1) ||
                            (block.getX() == x-1 && block.getY() == y))
                        return;

                figure.clear();

                addBlock(x, y);
                addBlock(x-1, y+1);
                addBlock(x-1, y-1);
                addBlock(x-1, y);
                rotate++;
                break;
            }
            case 3: {
                if(x > WIDTH_BLOCK - 2)
                    return;
                
                for(Block block : GROUND)
                    if((block.getX() == x && block.getY() == y) ||
                            (block.getX() == x-1 && block.getY() == y+1) ||
                            (block.getX() == x+1 && block.getY() == y+1) ||
                            (block.getX() == x && block.getY() == y+1))
                        return;
                
                figure.clear();

                addBlock(x, y);
                addBlock(x-1, y+1);
                addBlock(x+1, y+1);
                addBlock(x, y+1);
                rotate = 0;
                break;
            }
        }
    } 
}
