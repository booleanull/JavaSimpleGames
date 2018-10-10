package javatetris.figures;

import java.awt.Color;

public class OFigure extends Figure {
    public OFigure() {
        color = Color.white;
        addBlock(4,0);
        addBlock(4,1);
        addBlock(5,0);
        addBlock(5,1);
    }

    @Override
    public void rotate() {
        
    } 
}
