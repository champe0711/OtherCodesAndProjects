/**
 * Name: Christian Paul Domingo
 * Date: 02 October 2011
 * Description:
 * Drawing 2 dimensional shapes 
 * COMPONENT
 * 
 */
import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class CircleComponent extends JComponent
{
    public void paintComponent(Graphics g){
        // recover Graphics2d

        Graphics2D g2 = (Graphics2D) g;

        // insert code to draw circle
        
        Ellipse2D.Double circle1 = new Ellipse2D.Double(20, 20, 100, 100);
        g2.draw(circle1);
        g2.setColor(Color.red);
        g2.fill(circle1);
        
        Ellipse2D.Double circle2 = new Ellipse2D.Double(150, 20, 100, 100);
        g2.setColor(Color.blue);
        g2.draw(circle2);
        
        
    }
}