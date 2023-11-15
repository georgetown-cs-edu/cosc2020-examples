package art;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;

public class Art2 extends JFrame {

	public static void main(String[] args) {
		System.out.println("hi there.");
		new Art2();
	}

	// constructor
	public Art2() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		setSize(500, 500);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);

		notebook(g);
	}

	// draw a bunch of lines in a progression
	public void notebook(Graphics g) {
		g.setColor(new Color(150, 150, 250));
		for (int y = 100; y < 500; y = y + 20) {
			g.drawLine(20, y, 480, y); // notebook paper lines
			int x = y;
			g.drawLine(x, 50, 480, y); // shift x and y together, makes a curve
		}
	}
}
