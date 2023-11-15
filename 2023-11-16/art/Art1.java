package art;

import java.awt.*;
import javax.swing.*;

public class Art1 extends JFrame {

	public static void main(String[] args) {
		new Art1();

	}

	public Art1() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(800, 500);
		setVisible(true);
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g); // Call JFrame.paint()

		g.drawLine(50, 50, 250, 100);
		g.drawRect(50, 150, 100, 30);
		g.drawOval(50, 150, 100, 300);

		g.setColor(Color.pink);
		g.fillRect(200, 200, 50, 50);
		g.drawString("words words", 300, 300);

		int[] x = { 500, 400, 350 };
		int[] y = { 350, 150, 400 };

		g.setColor(Color.red);
		g.fillPolygon(x, y, 3);

	}

}
