/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Gemma
 */
import javax.swing.*;

public class FontMetricViewer {

    public static void main(String[] args)
    {
        JFrame frame = new JFrame();

        FontMetricComponent fMComponent = new FontMetricComponent();

        final int FRAME_WIDTH = 600;
        final int FRAME_HEIGHT = 450;

        // set frame attributes

        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setTitle("Font Metrics");
        frame.setVisible(true);
        frame.add(fMComponent);
    }

}