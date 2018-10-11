package javasnake;

import java.awt.Color;
import java.awt.Graphics;
import static javasnake.Game.FOOD;
import static javasnake.Game.SAE;
import javax.swing.JPanel;

public class Canvas extends JPanel {
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        SAE.draw(g);
        FOOD.draw(g);
        new Borders().draw(g);
    }
}
