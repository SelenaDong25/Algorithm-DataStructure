package recursive;

/**
 *
 * @author Thomas.Abbott
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
 
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
 
public class FallingLines extends JFrame {
 
    private final float startX = 150.0f;
    private final float startY = 400.0f;
    private final float endX = 150.0f; 
    private final float endY = 200.0f;
    private final float deltaX = 25.0f;
    private final float deltaY = 25.0f;
    private final float scaleX = 0.8f;
    private final float scaleY = 0.8f;
    private final float AngularInc = (float) Math.PI / 16.0f;

    public FallingLines() {
        super("Line Drawing Demo");
 
        setSize(480, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    //add recursive helper - XinDong
    void drawFallingLinesHelper(Graphics2D g2d, int i) {
        if (i == 20) {
            return;
        }
        drawALine(g2d, startX, startY, endX, endY);
        g2d.translate(deltaX, deltaY);
        g2d.rotate(AngularInc, startX, startY);
        g2d.scale(scaleX, scaleY);
        drawFallingLinesHelper(g2d, i+1);
    }
    //add recursive method to draw - XinDong
    void drawFallingLines1(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

    	g2d.scale(1.0f, 1.0f);
        drawFallingLinesHelper(g2d, 0);
    }
 
    void drawFallingLines( Graphics g ) {
    	Graphics2D g2d = (Graphics2D) g;

    	g2d.scale(1.0f, 1.0f);
    	for( int i = 0; i < 20; i++ ) {
            drawALine(g2d, startX, startY, endX, endY);
            g2d.translate(deltaX, deltaY);
            g2d.rotate(AngularInc, startX, startY);
            g2d.scale(scaleX, scaleY);
    	}
    }

    void drawALine( Graphics2D g2d, float startX, float startY, float endX, float endY) {
    	Shape line = new Line2D.Float(startX, startY, endX, endY);
    	g2d.draw(line);
    }

    public void paint( Graphics g) {
    	super.paint(g);
    	drawFallingLines1(g);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FallingLines().setVisible(true);
            }
        });
    }
}