/**
 * Name: Christian Paul Domingo
 * Date: 26 September 2011
 * Description:
 * Advance Java lab 1
 * 
 * @author eeuc1c
 */

import javax.swing.*;
public class EmptyFrameViewer
    {
    
    public static void main(String[] args)
    {
        // create frame
        JFrame frame = new JFrame();
        
        FontMetricComponent fMComponent = new FontMetricComponent();
        
        final int FRAME_WIDTH = 800;
        final int FRAME_HEIGHT = 800;
        
        // set frame attributes
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Empty");
        frame.setVisible(true);
        frame.add(fMComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /*CircleComponent circleComponent = new CircleComponent();
        frame.add(circleComponent);
         * 
         */
    }
}