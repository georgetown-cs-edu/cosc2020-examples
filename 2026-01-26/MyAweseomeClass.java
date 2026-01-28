import java.util.Vector;


public class MyAweseomeClass {


    public static void main( String args[] ) {

        Vector myVector = new Vector();

        String s1 = "Hello world";
        String s2 = "Wuzzup?";

        myVector.add(s1);
        myVector.add(s2);

        for( String s : myVector ) {
            System.out.println( s );
        }

    }
    
}
