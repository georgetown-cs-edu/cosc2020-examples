import java.math.BigInteger;

public class SomeObjectTypes {

    public static void main( String args[] ) {
        int n = 7; // int is a primitive type

        String s = "Hello"; // String is a class
        System.out.println( "length of s is " + s.length() );
    
         // BigInteger is a class
        BigInteger b = new BigInteger("12345678901234567890");
        b.add( new BigInteger("2") );
        System.out.println( "b is " + b );
    }
}
