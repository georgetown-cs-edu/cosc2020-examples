
public class Fun {


    public static void doSomethingWithBase( Base base ) {
        System.out.println( base );
    }

    public static void doSomethingWithDerived( Derived derived ) {
        System.out.println( derived );
    }

    public static void main( String args[] ) {
        Base b = new Base();
        Derived d = new Derived();
        Base c = new Derived();

        System.out.println( b );
        System.out.println( d );
        System.out.println( c );

        doSomethingWithBase(b);
        doSomethingWithBase(d);
        doSomethingWithBase(c);

        // doSomethingWithDerived( b ); // ERROR!
        doSomethingWithDerived( d );
        // doSomethingWithDerived( c ); // ERROR!

    }

}
