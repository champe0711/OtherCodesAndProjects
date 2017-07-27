/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eeuc1c
 */
import java.awt.*;
import javax.swing.*;

public class HelloComponent extends JComponent
{
    public void paintComponent(Graphics g){
        // recover Graphics2d
        
        Graphics2D g2 = (Graphics2D) g;
        
        // insert code to draw string
        Font font = new Font("Verdana", Font.BOLD + Font.ITALIC, 48);
        
        g2.setFont(font);
        
        g2.setColor(Color.red);
        g2.drawString("Hello", 10, 150);
        
        g2.setColor(Color.green);
        g2.drawString("coloured", 150, 150);
        
        g2.setColor(Color.blue);
        g2.drawString("world . . .", 400, 150);
        
    }
}
