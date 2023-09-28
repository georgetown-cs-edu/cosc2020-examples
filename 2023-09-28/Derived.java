class Derived extends Base {

    public Derived() {
        super();
        System.out.println( "I am the derived constructor" );
    }

    public static void main( String[] args ) {
        Derived d = new Derived();
    }
}