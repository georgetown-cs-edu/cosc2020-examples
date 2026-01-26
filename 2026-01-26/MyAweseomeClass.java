import java.util.Vector;


public class MyAweseomeClass {


    public static void main( String args[] ) {

        Vector myVector = new Vector();

        String s1 = "Hello world";
        String s2 = "Wuzzup?";
        Integer x = Integer.valueOf(561);

        myVector.add(s1);
        myVector.add(s2);
        myVector.add(x);


        for( Object o : myVector ) {
            System.out.println( o );
        }

    }
    
}
