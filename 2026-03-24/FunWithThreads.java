
public class FunWithThreads {

    public class HelloItsMe implements Runnable {

        private String name;

        HelloItsMe( String name ) {
            this.name = name;
        }

        @Override
        public void run() {
            while( true ) {
                System.out.println( "Hello, I'm " + name );

                 try {
                    Thread.sleep( 1000 );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } 
            }
                
        }
    }

    public static void main(String[] args) {
        FunWithThreads fwt = new FunWithThreads();

        for( int i = 0; i < 20; i++ ) {
            FunWithThreads.HelloItsMe h = fwt.new HelloItsMe( "" + i );
            Thread t = new Thread(h);
            t.start();
        }
        
    }

}
