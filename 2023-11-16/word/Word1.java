package word;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Word1 extends JFrame
implements ActionListener
{
   JTextField writeOnMe; // place for user to enter text

   public static void main ( String[] args )
   {
      new Word1();
   }
   
    // constructor
	public Word1()
	{
	   setDefaultCloseOperation( EXIT_ON_CLOSE );
	   setTitle("WordWriter");
	   
	   setLayout( new FlowLayout() );
   
	   writeOnMe = new JTextField("write here" , 20 );
	   add( writeOnMe );
	   writeOnMe.addActionListener(this);
	   //writeOnMe.set
	   
	   setSize(500,100 );
	   setVisible(true);
	}

	@Override
	public void actionPerformed( ActionEvent e )
	{
	   if ( e.getSource()==writeOnMe )
	   { System.out.println("text:"+writeOnMe.getText()); }
	   repaint();
	}
	
	
	@Override
	public void paint( Graphics g )
	{
	   super.paint(g);
	   
	   g.setColor( Color.BLACK );
	   String writeMe = writeOnMe.getText();
	   g.drawString( writeMe, 10, 70 );	
	}
}

