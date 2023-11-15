package art;

import java.awt.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.*;

public class Art4 extends JPanel {
	Random r = new Random();
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		Art4 a = new Art4();
		f.add(a);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(500, 500);
		f.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		for (int i = 0; i < 50; i++) {
			// Create a random circle
			int red = r.nextInt(250);
			int green = r.nextInt(250);
			int blue = r.nextInt(250);
			g.setColor( new Color(red, green, blue) );
			
			int x = r.nextInt(460);
			int y = r.nextInt(460);
			g.fillOval(x, y, 35, 35);
		}
	}
	
}
