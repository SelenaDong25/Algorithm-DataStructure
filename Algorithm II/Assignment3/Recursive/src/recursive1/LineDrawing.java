
package recursive1;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Line2D;
 
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
 
public class LineDrawing extends JFrame {
 
    public LineDrawing() {
        super("Lines Drawing Demo");
 
        setSize(480, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
    //add recursive helper - XinDong
    void drawSquaresHelper( Graphics2D g2d, float theta ) {
        if (theta >= Math.PI * 2.0f) {
            return;
        }
        final float originX = 150.0f;
    	final float originY = 150.0f;
    	final float width = 50.0f;
    	final float height = 50.0f;
    	final float AngularInc = (float) Math.PI / 8.0f;
        
        drawASquare(g2d, originX, originY, width, height);
        g2d.rotate(AngularInc, originX, originY);
        drawSquaresHelper(g2d, theta + AngularInc);
    }
    //add recursive method to draw - XinDong
    void drawSquares1( Graphics g ) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.scale(1.0f, 1.0f);
        drawSquaresHelper(g2d, 0.0f);
    }
    void drawSquares( Graphics g ) {
    	Graphics2D g2d = (Graphics2D) g;

    	final float originX = 150.0f;
    	final float originY = 150.0f;
    	final float width = 50.0f;
    	final float height = 50.0f;
    	final float AngularInc = (float) Math.PI / 8.0f;
    	
    	g2d.scale(1.0f, 1.0f);
    	for( float theta = 0.0f; theta < Math.PI * 2.0f; theta += AngularInc ) {
            drawASquare(g2d, originX, originY, width, height);
            g2d.rotate(AngularInc, originX, originY);
    	}
    }
    
    void drawASquare(Graphics2D g2d, float originX, float originY, float width, float height) {
        drawALine( g2d, 
            originX, originY, 
            originX + width, originY );
        drawALine( g2d, 
            originX + width, originY, 
            originX + width, originY + height);
        drawALine( g2d, 
            originX + width , originY + height, 
            originX, originY + height );
        drawALine( g2d, 
            originX, originY + height, 
            originX, originY );
    }

    void drawALine( Graphics2D g2d, float startX, float startY, float endX, float endY) {
    	Shape line = new Line2D.Float(startX, startY, endX, endY);
    	g2d.draw(line);
    }

    public void paint( Graphics g) {
    	super.paint(g);
    	drawSquares1(g);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LineDrawing().setVisible(true);
            }
        });
    }
}