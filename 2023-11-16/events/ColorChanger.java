package events;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class ColorChanger {
    
	JFrame window = new JFrame("Color-changing panel!");
	JPanel colorPanel = new JPanel();
	JPanel buttonPanel = new JPanel();
	JButton blueButton = new JButton("Make it blue");
	JButton redButton = new JButton("Make it red");
	
    class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if ( e.getActionCommand().equals("red")) {
				redButton.setVisible(false);
				colorPanel.setBackground(Color.red);
				blueButton.setVisible(true);
			}
			else {
				blueButton.setVisible(false);
				colorPanel.setBackground(Color.blue);
				redButton.setVisible(true);
			}
		} // end void actionPerformed
    } // end class ButtonListener
	
	public ColorChanger() {
		colorPanel.setBackground(Color.blue);
		buttonPanel.setBackground(Color.gray);
		
		window.add(colorPanel, BorderLayout.CENTER);
		window.add(buttonPanel, BorderLayout.SOUTH);
		
		buttonPanel.setLayout(new GridLayout(1,2));
		buttonPanel.add(redButton);
		buttonPanel.add(blueButton);
		
		ButtonListener b = new ButtonListener();
		redButton.addActionListener(b);
		blueButton.addActionListener(b);
		redButton.setActionCommand("red");
		blueButton.setActionCommand("blue");
		
		blueButton.setVisible(false);
		
		window.setSize(400,400);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new ColorChanger();
	}

}
