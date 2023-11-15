package art;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;

public class Art3 extends JPanel {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		Art3 a = new Art3();
		f.add(a);

		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		f.setVisible(true);
	}

	public void paintComponent(Graphics g) {
		// Rows
		for (int y = 20; y < 460; y += 40) {
			// Columns
			for (int x = 20; x < 460; x += 40) {
				// Gradient color
				g.setColor(new Color(x / 2, 255 - y / 2, 0));
				g.fillRect(x, y, 35, 35);
			}
		}
	}

}
