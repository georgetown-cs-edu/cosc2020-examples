package word;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Word2 extends JFrame
implements ActionListener
{
   JTextField writeOnMe; // place for user to enter text
   Font theFont;

   ColorPicker3 cp;

   public static void main ( String[] args )
   {
      new Word2();
   }

	public Word2()
	{
	   setDefaultCloseOperation( EXIT_ON_CLOSE );
	   setTitle("WordWriter");
	   
	   setLayout( new FlowLayout() );
	   
	   cp = new ColorPicker3();
	   cp.setLocation( 500, 120 );
	
	   theFont = new Font("Courier",Font.BOLD+Font.ITALIC,20);
	   
	   writeOnMe = new JTextField("write here", 20);
	   writeOnMe.setFont( theFont );
	   add( writeOnMe );
	   writeOnMe.addActionListener(this);
	   
	   setSize(500,200 );
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
	   
	   g.setFont ( theFont );
	   g.setColor( cp.getColor() );
	   String writeMe = writeOnMe.getText();
	   g.drawString( writeMe, 10, 70 );
	   
	
	}
}
