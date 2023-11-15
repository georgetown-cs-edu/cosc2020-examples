package word;

import java.awt.*;

public class Swatch
{
   protected Color color;
   protected int x, y; // pixels from upper left to upper left corner
   
   // constructor, give upper left corner and color
   public Swatch( int x1, int y1, Color c1 )
   {
      x = x1; y = y1; color = c1;
   }
   
   // constructor without color, makes random color
   public Swatch( int x1, int y1 )
   {
      x = x1; y = y1; 
      setRandomColor();
   }
   
   // given coordinates mx,my (like a mouse click) say if
   // the click is on THIS Swatch.
   public boolean zatyou( int mx, int my )
   {
	   return ( x<=mx && mx<x+20 && y<=my && my<y+20
			  );
   }
   
   // sets the color attribute to a random color
   public void setRandomColor()
   {
      color = new Color(
            (int)( Math.random()*255),
            (int)( Math.random()*255),
            (int)( Math.random()*255)
                       );
   }
   
   // fills a rectangle at xy with color, 20x20 pixels
   public void drawMe ( Graphics g )
   {
      g.setColor( color );
      g.fillRect( x, y, 20, 20 ); 
   }
   
   // access
   public void setColor( Color c ) { color = c; }
   public Color getColor() { return color ; }
}

