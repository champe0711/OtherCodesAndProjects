package wk3;

//package test;
import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;

/**
 * For our purposes only two of the GLEventListeners matter. Those would be
 * init() and display().
 */
public class ThirdGLEventListener implements GLEventListener {

    GLU glu;

    /**
     * Constructor here.
     */
    public ThirdGLEventListener() {
    }

    /**
     * Take care of initialization here.
     */
    public void init(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        glu = new GLU();

        gl.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        gl.glViewport(-250, -150, 250, 150);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(-250.0, 250.0, -150.0, 150.0);

    }

    public void display(GLAutoDrawable drawable) {

        float red = 1.0f;
        float green = 0.0f;
        float blue = 0.0f;

        GL gl = drawable.getGL();

        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        //color
        gl.glColor3f(red, green, blue);

        //start point and end point (x1,y1) (x2,y2)
        int x1 = 0, y1 = 0, x2 = 100, y2 = 100;
        
        //drawline method
        drawline(gl, x1, y1, x2, y2);
    }

    private void drawline(GL gl, int x1, int y1, int x2, int y2) {
        //eq of the line (y = m.x+c)
        int dx = x2 - x1;
        int dy = y2 - y1;
        float m = dy / dx;
        float c = (y1 - m * x1);
        //pen size
        gl.glPointSize(1.0f);
        //create points
        gl.glBegin(GL.GL_POINTS);
        for (int x = x1; x <= x2; ++x) {
            float y = m * x + c;
            //start point of line
            gl.glVertex2i(x, Math.round(y));
        }
        //finish point
        gl.glEnd();
    }

    /**
     * Called when the GLAutoDrawable (GLCanvas or GLJPanel) has changed in size. We won't
     * need this, but you will eventually need it -- just not yet.
     */
    public void reshape(GLAutoDrawable drawable, int x, int y, int width, int height) {
    }

    /**
     * If the display depth is changed while the program is running this method is called.
     * Nowadays this doesn't happen much, unless a programmer has his program do it.
     */
    public void displayChanged(GLAutoDrawable drawable, boolean modeChanged, boolean deviceChanged) {
    }
}
