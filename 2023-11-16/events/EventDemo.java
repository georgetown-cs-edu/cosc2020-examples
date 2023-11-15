package events;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventDemo extends JFrame implements ActionListener {
    
	JButton dogButton;
	JButton catButton;
	JLabel outputLabel;
	
	public static void main(String[] args) {
		new EventDemo();
	}
	
	public EventDemo() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setTitle("dog cat button thing");
		setLayout( new FlowLayout() );
		
		dogButton = new JButton("dog");
		add(dogButton);
		dogButton.addActionListener(this);
		
		catButton = new JButton("cat");
		add(catButton);
		catButton.addActionListener(this);
		
		outputLabel = new JLabel("");
		add(outputLabel);
		
		setSize( new Dimension(500, 500));
		setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("An event!");
		outputLabel.setText("You pushed a button!");
		
		if ( e.getSource() == dogButton ) {
			System.out.println("bow wow");
			JOptionPane.showMessageDialog(null,  "bow wow", "The dog says", JOptionPane.INFORMATION_MESSAGE);
		}
		else if ( e.getSource() == catButton ) {
			System.out.println("meow");
			JOptionPane.showMessageDialog(null,  "meow", "The cat says", JOptionPane.INFORMATION_MESSAGE);
		}
		
		outputLabel.setText("");
		
		repaint();
	}

}
