package wk3;

//:if expand("%") == ""|browse confirm w|else|confirm w|endif
//package test;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.media.opengl.*;

//import test.*;

/**
 * This is a basic JOGL app. Feel free to 
 * reuse this code or modify it.
 */
public class ThirdJoglApp extends JFrame {

    public static void main(String[] args) {
        final ThirdJoglApp app = new ThirdJoglApp();

        // show what we've done
        SwingUtilities.invokeLater (
            new Runnable() {
                public void run() {
                    app.setVisible(true);
                }
            }
        );
    }
    
    public ThirdJoglApp() {
        //set the JFrame title
        super("Simple JOGL Application");
        
        //kill the process when the JFrame is closed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       

	ThirdGLEventListener s = new ThirdGLEventListener();

        //only two JOGL lines of code ... and here they are 
        GLCanvas glcanvas = new GLCanvas();
        glcanvas.addGLEventListener(s);
        
        //add the GLCanvas just like we would any Component
        getContentPane().add("Center", glcanvas);
        setSize(500, 300);
        
        //center the JFrame on the screen
        centerWindow(this);
    }
    
    public void centerWindow(Component frame) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize  = frame.getSize();

        if (frameSize.width  > screenSize.width ) frameSize.width  = screenSize.width;
        if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;

        frame.setLocation (
            (screenSize.width  - frameSize.width ) >> 1, 
            (screenSize.height - frameSize.height) >> 1
        );
    }
}
