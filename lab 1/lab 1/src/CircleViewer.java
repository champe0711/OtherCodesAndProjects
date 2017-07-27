/*
 * Name:Christian Paul Domingo
 * Date: 02 October 2011
 * Description:
 * Drawing 2 dimensional shapes
 * Viewer
 */
import java.awt.Color;
import javax.swing.*;
public class CircleViewer
    {
    
    public static void main(String[] args)
    {
        // create frame
        JFrame frame = new JFrame();
        
        CircleComponent cComponent = new CircleComponent();
        
        final int FRAME_WIDTH = 600;
        final int FRAME_HEIGHT = 800;
        
        // set frame attributes
        
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Drawing 2 Dimensional shapes");
        frame.setVisible(true);
        frame.add(cComponent);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}