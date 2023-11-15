package basic;

import javax.swing.*;

public class SwingExample {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		JButton b = new JButton("I'm a button");
		b.setBounds(30,100,80,30);
		f.add(b);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(300,300);
		f.setLayout(null);
		f.setVisible(true);

	}

}
