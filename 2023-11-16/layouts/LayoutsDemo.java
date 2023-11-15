package layouts;

import java.awt.*;
import javax.swing.*;

public class LayoutsDemo {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setLayout( new GridLayout(2,2));
		
		JPanel panel0 = new JPanel();
		panel0.setBackground( Color.yellow);
		f.add(panel0);
	    
		panel0.setLayout( new BorderLayout() );
	    panel0.add( new JButton("CA"), BorderLayout.WEST );
	    panel0.add( new JButton("MN"), BorderLayout.NORTH );
	    panel0.add( new JButton("DC"), BorderLayout.EAST );
	    panel0.add( new JButton("OH"), BorderLayout.CENTER );
	    panel0.add( new JButton("TX"), BorderLayout.SOUTH );
	    
	    JPanel panel1 = new JPanel();
        panel1.setBackground( Color.pink );
	    panel1.setLayout(new FlowLayout());
	    f.add(panel1);
	    
	    panel1.add(new JButton("dog") );
	    panel1.add(new JButton("cat") );
	    panel1.add(new JButton("aardvark") );
	    panel1.add(new JButton("zebra") );
	    
	    JPanel panel2 = new JPanel();
	    panel2.setBackground( new Color(200, 100, 200));
	    f.add(panel2);
	    
	    panel2.setLayout( new GridLayout(4,3));
	    for (int i = 0; i < 10; i++ ) {
	    	panel2.add( new JButton(""+i));
	    }
	    
	    f.add( new JButton("blah"));
	    
	    f.setSize( new Dimension( 500, 500 ));
	    f.setVisible(true);
		

	}

}
