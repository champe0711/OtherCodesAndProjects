/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eeuc1c
 */

import javax.swing.*;

public class CarViewer {

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        
        frame.setSize(300, 400);
        frame.setTitle("Two Cars");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        CarComponent component = new CarComponent();
        frame.add(component);
        
        frame.setVisible(true);
    }
}
