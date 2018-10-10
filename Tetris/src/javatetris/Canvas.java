package javatetris;

import java.awt.Graphics;
import static javatetris.Game.GROUND;
import static javatetris.Game.FIGURE;
import javax.swing.JPanel;

public class Canvas extends JPanel {
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        for(Block block : GROUND)
            block.draw(g);
        
        FIGURE.draw(g);
        new Borders().draw(g);
    }
}
