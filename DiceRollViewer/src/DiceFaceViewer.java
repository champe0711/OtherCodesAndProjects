
/**
 * @author  Christian Paul Domingo
 * @date    05 October 2011
 * @description
 * 
 * This is the viewer class for the dice face program
 * 
 */
//import java packages
import javax.swing.*;

public class DiceFaceViewer {
    
    public static void main(String[] args)
    {
        // create frame
        JFrame frame = new JFrame();
        
        // create diceFacecomponent
        DiceFaceComponent diceCom = new DiceFaceComponent();
        
        // set frame dimension
        final int WIDTH = 500;
        final int HEIGHT = 500;
        
        
        // set frame attributes
        frame.setSize(WIDTH, HEIGHT);
        frame.setTitle("Dice Viewer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        
        frame.add(diceCom);
        frame.setVisible(true);
    }
}