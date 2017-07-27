/*
 * Name: Christian Paul Domingo
 * Date: 03 October 2011
 * Description:
 * Dice Component
 * this will draw all the graphical components of Dice Game
 */


import java.awt.*;
import javax.swing.*;

public class DiceFaceComponent extends JComponent
{
    public void paintComponent(Graphics g){
        // recover Graphics2d

        Graphics2D g2 = (Graphics2D) g;
        
        
        Dice newDice = new Dice(6);
        int diceFace = newDice.getDice();
        
        DiceFace dice = new DiceFace(diceFace,getWidth()/2,getHeight()/2);
        dice.setFaces(diceFace, g2);
        
//        dice.draw(g2);
        g2.setColor(Color.red);
        g2.drawString("The current Dice is " + newDice.getDice(), 100, 30);
    }
}