package basic;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AWTExample {

	public static void main(String[] args) {
		Frame f = new Frame();
		Button b = new Button("I'm a button!");
		b.setBounds(30,100,80,30);
		f.add(b);
		
		f.addWindowListener( new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				f.dispose();
			}
		});
		f.setSize(300, 300);
		f.setLayout(null);
		f.setVisible(true);

	}

}
