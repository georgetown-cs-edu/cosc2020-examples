package responsive;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Snappy 
       extends JFrame 
       implements MouseListener, MouseMotionListener {
	
	// Attributes used by listeners
	int downX, downY;  // Position where button pressed
	int mouseX, mouseY; // Position where mouse is now

	public static void main(String[] args) {
		new Snappy();

	}
	
	public Snappy() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("Snappy Lines");
		
		addMouseListener(this);
		addMouseMotionListener(this);
		
		setSize(500, 500);
		setVisible(true);
	}
    
	/* MouseMotionListener methods
	 * + Implement mouseDragged to update mouse XY
	 * - Stub mouseMoved (don't care unless button is pressed)
	 */
	
	@Override
	public void mouseDragged(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();
		// Repaint to redraw the line
		repaint();
		
	}

	@Override
	public void mouseMoved(MouseEvent e) { }
    
	/* MouseListener methods
	 * + Implement mousePressed and mouseReleased
	 * - Stub mouseClicked, mouseEntered, mouseExited
	 */
	
	@Override
	public void mousePressed(MouseEvent e) {
		mouseX = downX = e.getX();
		mouseY = downY = e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		mouseX = e.getX();
		mouseY = e.getY();		
	}
    
	@Override
	public void mouseClicked(MouseEvent e) { }
	
	@Override
	public void mouseEntered(MouseEvent e) { }

	@Override
	public void mouseExited(MouseEvent e) { }
    
	/* Paint
	 * Draw a line from where mouse was pressed to where mouse was
	 * released (or current position, if still pressed)
	 */
	
	@Override
	public void paint(Graphics g) {
		super.paint(g); // "Erase" by redrawing
		g.drawLine(downX, downY, mouseX, mouseY);
	}
	
}
