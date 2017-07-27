/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eeuc1c
 */
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class DiceFace {

    //global variables for DiceFace
    private int dice;
    private int xLeft;
    private int yTop;

    //box dimension 
    private int diceW = 200 - xLeft;
    private int diceH = 200 - yTop;

    //dot dimension
    private final int DOTW = 50;
    private final int DOTH = 50;

    public DiceFace(int currentDice, int x, int y) {
        dice = currentDice;
        xLeft = x;
        yTop = y;

    }

    public void draw1(Graphics2D g2) {
        //create shapes
        Rectangle diceBody = new Rectangle(xLeft - (diceW / 2), yTop - (diceH / 2), diceH, diceW);
        Ellipse2D.Double dotMid = new Ellipse2D.Double(xLeft - (diceW / 2) + 75, yTop - (diceH / 2) + 75, DOTW, DOTH);
        g2.setColor(Color.black);
        g2.fill(diceBody);
        g2.setColor(Color.white);
        g2.fill(dotMid);
    }

    public void draw2(Graphics2D g2) {
        //create shapes
        Rectangle diceBody = new Rectangle(xLeft - (diceW / 2), yTop - (diceH / 2), diceW, diceH);

        Ellipse2D.Double dotLeft2 = new Ellipse2D.Double(xLeft - (diceW / 2) + 20, yTop - (diceH / 2) + 75, DOTW, DOTH);

        Ellipse2D.Double dotRight2 = new Ellipse2D.Double(xLeft - (diceW / 2) + 130, yTop - (diceH / 2) + 75, DOTW, DOTH);

        g2.setColor(Color.black);
        g2.fill(diceBody);
        g2.setColor(Color.white);
        g2.fill(dotLeft2);
        g2.fill(dotRight2);
    }

    public void draw3(Graphics2D g2) {

        //create shapes
        Rectangle diceBody = new Rectangle(xLeft - (diceW / 2), yTop - (diceH / 2), diceW, diceH);

        Ellipse2D.Double dotLeft1 = new Ellipse2D.Double(xLeft - (diceW / 2) + 20, yTop - (diceH / 2) + 15, DOTW, DOTH);
        Ellipse2D.Double dotRight3 = new Ellipse2D.Double(xLeft - (diceW / 2) + 130, yTop - (diceH / 2) + 135, DOTW, DOTH);

        Ellipse2D.Double dotMid = new Ellipse2D.Double(xLeft - (diceW / 2), yTop - (diceH / 2), diceW, diceH);

        g2.setColor(Color.black);
        g2.fill(diceBody);
        g2.setColor(Color.white);
        g2.fill(dotLeft1);
        g2.fill(dotRight3);
        g2.fill(dotMid);
    }

    public void draw4(Graphics2D g2) {
        //create shapes
        Rectangle diceBody = new Rectangle(xLeft - (diceW / 2), yTop - (diceH / 2), diceW, diceH);

        Ellipse2D.Double dotLeft1 = new Ellipse2D.Double(xLeft - (diceW / 2) + 20, yTop - (diceH / 2) + 15, DOTW, DOTH);
        Ellipse2D.Double dotLeft3 = new Ellipse2D.Double(xLeft - (diceW / 2) + 20, yTop - (diceH / 2) + 135, DOTW, DOTH);

        Ellipse2D.Double dotRight1 = new Ellipse2D.Double(xLeft - (diceW / 2) + 130, yTop - (diceH / 2) + 15, DOTW, DOTH);
        Ellipse2D.Double dotRight3 = new Ellipse2D.Double(xLeft - (diceW / 2) + 130, yTop - (diceH / 2) + 135, DOTW, DOTH);

        g2.setColor(Color.black);
        g2.fill(diceBody);
        g2.setColor(Color.white);
        g2.fill(dotLeft1);
        g2.fill(dotLeft3);
        g2.fill(dotRight1);
        g2.fill(dotRight3);
    }

    public void draw5(Graphics2D g2) {
        //create shapes
        Rectangle diceBody = new Rectangle(xLeft - (diceW / 2), yTop - (diceH / 2), diceW, diceH);

        Ellipse2D.Double dotLeft1 = new Ellipse2D.Double(xLeft - (diceW / 2) + 20, yTop - (diceH / 2) + 15, DOTW, DOTH);
        Ellipse2D.Double dotLeft3 = new Ellipse2D.Double(xLeft - (diceW / 2) + 20, yTop - (diceH / 2) + 135, DOTW, DOTH);

        Ellipse2D.Double dotRight1 = new Ellipse2D.Double(xLeft - (diceW / 2) + 130, yTop - (diceH / 2) + 15, DOTW, DOTH);
        Ellipse2D.Double dotRight3 = new Ellipse2D.Double(xLeft - (diceW / 2) + 130, yTop - (diceH / 2) + 135, DOTW, DOTH);

        Ellipse2D.Double dotMid = new Ellipse2D.Double(xLeft - (diceW / 2), yTop - (diceH / 2), diceW, diceH);
        g2.setColor(Color.black);
        g2.fill(diceBody);
        g2.setColor(Color.white);
        g2.fill(dotLeft1);
        g2.fill(dotLeft3);
        g2.fill(dotRight1);
        g2.fill(dotRight3);
        g2.fill(dotMid);
    }

    public void draw6(Graphics2D g2) {
        //create shapes
        Rectangle diceBody = new Rectangle(xLeft - (diceW / 2), yTop - (diceH / 2), diceW, diceH);

        Ellipse2D.Double dotLeft1 = new Ellipse2D.Double(xLeft - (diceW / 2) + 20, yTop - (diceH / 2) + 15, DOTW, DOTH);
        Ellipse2D.Double dotLeft2 = new Ellipse2D.Double(xLeft - (diceW / 2) + 20, yTop - (diceH / 2) + 75, DOTW, DOTH);
        Ellipse2D.Double dotLeft3 = new Ellipse2D.Double(xLeft - (diceW / 2) + 20, yTop - (diceH / 2) + 135, DOTW, DOTH);

        Ellipse2D.Double dotRight1 = new Ellipse2D.Double(xLeft - (diceW / 2) + 130, yTop - (diceH / 2) + 15, DOTW, DOTH);
        Ellipse2D.Double dotRight2 = new Ellipse2D.Double(xLeft - (diceW / 2) + 130, yTop - (diceH / 2) + 75, DOTW, DOTH);
        Ellipse2D.Double dotRight3 = new Ellipse2D.Double(xLeft - (diceW / 2) + 130, yTop - (diceH / 2) + 135, DOTW, DOTH);

        //fill dice body and the dice numbers
        g2.setColor(Color.black);
        g2.fill(diceBody);
        g2.setColor(Color.white);
        g2.fill(dotLeft1);
        g2.fill(dotLeft2);
        g2.fill(dotLeft3);
        g2.fill(dotRight1);
        g2.fill(dotRight2);
        g2.fill(dotRight3);
    }

    void setFaces(int diceValue, Graphics2D g2) {
        switch (diceValue) {
            case 1:
                draw1(g2);
                break;
            case 2:
                draw2(g2);
                break;
            case 3:
                draw3(g2);
                break;
            case 4:
                draw4(g2);
                break;
            case 5:
                draw5(g2);
                break;
            case 6:
                draw6(g2);
                break;
            default:
                System.out.println("Error! value invalid");
                break;
        }
    }

}
