/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gemma
 */

import java.awt.*;
import javax.swing.*;

public class FontMetricComponent extends JComponent
{
    public void paintComponent(Graphics g){
        // recover Graphics2d

        Graphics2D g2 = (Graphics2D) g;

        // insert code to draw string
        Font font = new Font("SERIF", Font.ITALIC, 14);

        FontMetrics fM = new FontMetrics(font) {

        };

        g2.setFont(font);
        g2.drawString("Current font: " + fM.getFont(), 100, 150);
        g2.drawString("Ascent: " + fM.getAscent(), 100, 170);
        g2.drawString("Descent: " + fM.getDescent(), 100, 190);
        g2.drawString("Height: " + fM.getHeight(), 100 ,210);
        g2.drawString("Leading: " + fM.getLeading(), 100, 230);

    }
}