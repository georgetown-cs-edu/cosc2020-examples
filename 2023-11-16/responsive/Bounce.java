package responsive;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Bounce {

	// Bounce owns the MODEL -- state of the balls
	Ball[] balls;
	int ballCount;

	// Bounce also owns the VIEW objects -- displaying the balls
	JFrame f;
	Game gamePanel;

	public static void main(String[] args) {
		new Bounce();
	}

	public Bounce() {
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setTitle("Bounce");
		f.setBackground(Color.white);

		// Initialize the model
		ballCount = 10;
		balls = new Ball[100];
		for (int i = 0; i < ballCount; i++) {
			balls[i] = new Ball();
		}

		// Create the play area
		gamePanel = new Game();
		f.add(gamePanel);

		// An anonymous MouseAdapter to add new balls
		gamePanel.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				if (ballCount < 100) {
					balls[ballCount++] = new Ball(e.getX(), e.getY());
				}
			}
		});

		// Create a timer
		Timer tick = new Timer(100, new Animator());
		tick.start();

		f.setSize(600, 600);
		f.setVisible(true);
	}

	// Ball is part of the MODEL -- an encapsulation of a single ball
	public class Ball {

		double x, y;
		double vx, vy;
		double oldx, oldy;

		public Ball() {
			x = (int) (Math.random() * 400 + 100); // [100, 500)
			y = (int) (Math.random() * 400 + 100);

			vx = (int) (Math.random() * 100 - 50); // [-50, 50)
			vy = (int) (Math.random() * 100 - 50);
		}

		public Ball(int xClick, int yClick) {
			x = xClick;
			y = yClick;

			vx = (int) (Math.random() * 100 - 50); // [-50, 50)
			vy = (int) (Math.random() * 100 - 50);
		}

		public void move(double delta) {
			oldx = x;
			oldy = y;
			x += vx * delta;
			y += vy * delta;
			stayOnScreen();
		}

		public void stayOnScreen() {
			// Check bounces off each edge of screen
			if (x < 0)
				vx *= -1;
			if (x > 550)
				vx *= -1;
			if (y < 0)
				vy *= -1;
			if (y > 550)
				vy *= -1;
		}

		// Balls draw themselves at current position
		public void draw(Graphics g) {
			g.setColor(Color.black);
			g.fillOval((int) (x - 2), (int) (y - 2), 5, 5);
			
			// g.drawString("("+vx+";"+vy+")", (int) x, (int) (y+12));
		}
	}

	// Game is part of the VIEW -- it displays the current ball positions
	public class Game extends JPanel {

		@Override
		public void paintComponent(Graphics g) {
	 		// Jpanel.paintComponent is too slow, so we just draw a white rectangle over everything
      // super.paintComponent(g);
      g.setColor(Color.white);
      g.fillRect(0,0,550,550);
			for (int i = 0; i < ballCount; i++) {
				balls[i].draw(g);
			}
		}
	}

	// Animator is the CONTROLLER -- it responds to events
	public class Animator implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			for (int i = 0; i < ballCount; i++) {
				balls[i].move(0.1);
			}
			gamePanel.repaint();

		}

	}

}
