package javatetris.figures;

import java.awt.Color;
import javatetris.Block;
import static javatetris.Game.GROUND;
import static javatetris.JavaTetris.HEIGHT_BLOCK;
import static javatetris.JavaTetris.WIDTH_BLOCK;

public class IFigure extends Figure {

    public IFigure() {
        color = Color.yellow;
        addBlock(3,0);
        addBlock(4,0);
        addBlock(5,0);
        addBlock(6,0);
    }
    
    @Override
    public void rotate() {
        int x = figure.get(0).getX();
        int y = figure.get(0).getY();
        
        switch(rotate) {
            case 0: {
                if(y + 4 > HEIGHT_BLOCK)
                    return;
                
                for(Block block : GROUND)
                    if(block.getX() == x && (block.getY() == y+3 || block.getY() == y+2 || block.getY() == y+1))
                        return;

                figure.clear();

                addBlock(x, y);
                addBlock(x, y+1);
                addBlock(x, y+2);
                addBlock(x, y+3);
                rotate++;
                break;
            }
            case 1: {
                if(x + 4 > WIDTH_BLOCK)
                    return;
                
                for(Block block : GROUND)
                    if(block.getY() == y && (block.getX() == x+3 || block.getX() == x+2 || block.getX() == x+1))
                        return;
                
                figure.clear();

                addBlock(x, y);
                addBlock(x+1, y);
                addBlock(x+2, y);
                addBlock(x+3, y);
                rotate = 0;
            } 
        }
    }
}
