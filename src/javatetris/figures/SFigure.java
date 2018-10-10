package javatetris.figures;

import java.awt.Color;
import javatetris.Block;
import static javatetris.Game.GROUND;
import static javatetris.JavaTetris.HEIGHT_BLOCK;
import static javatetris.JavaTetris.WIDTH_BLOCK;

public class SFigure extends Figure {
    public SFigure() {
        color = Color.cyan;
        addBlock(5,0);
        addBlock(4,0);
        addBlock(4,1);
        addBlock(3,1);
    }

    @Override
    public void rotate() {
        int x = figure.get(0).getX();
        int y = figure.get(0).getY();
        
        switch(rotate) {
            case 0: {
                if(x > WIDTH_BLOCK - 2 || y > HEIGHT_BLOCK -3)
                    return;
                
                for(Block block : GROUND)
                    if((block.getX() == x && block.getY() == y) ||
                            (block.getX() == x && block.getY() == y+1) ||
                            (block.getX() == x+1 && block.getY() == y+1) ||
                            (block.getX() == x+1 && block.getY() == y+2))
                        return;

                figure.clear();

                addBlock(x, y);
                addBlock(x, y+1);
                addBlock(x+1, y+1);
                addBlock(x+1, y+2);
                rotate++;
                break;
            }
            case 1: {
                if(x < 2)
                    return;
                
                for(Block block : GROUND)
                    if((block.getX() == x && block.getY() == y) ||
                            (block.getX() == x-1 && block.getY() == y) ||
                            (block.getX() == x-1 && block.getY() == y+1) ||
                            (block.getX() == x-2 && block.getY() == y+1))
                        return;
                
                figure.clear();

                addBlock(x, y);
                addBlock(x-1, y);
                addBlock(x-1, y+1);
                addBlock(x-2, y+1);
                rotate = 0;
            } 
        }
    }
}
