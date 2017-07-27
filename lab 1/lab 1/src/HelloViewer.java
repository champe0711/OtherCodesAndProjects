/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author eeuc1c
 */
import javax.swing.*;

public class HelloViewer {
    public static void main(String[] args)
    {
        JFrame frame = new JFrame();
        
        HelloComponent helloComponent = new HelloComponent();
        
        final int FRAME_WIDTH = 600;
        final int FRAME_HEIGHT = 450;
        
        // set frame attributes
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Component Viewer");
        frame.setVisible(true);
        frame.add(helloComponent);
    }
    
}
