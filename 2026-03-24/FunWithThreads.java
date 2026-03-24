
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

                int waitTime = (int)(500.0 + (500.0 * Math.random()));
                try {
                    Thread.sleep( waitTime );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        FunWithThreads fwt = new FunWithThreads();
        FunWithThreads.HelloItsMe h1 = fwt.new HelloItsMe("Micah");
        FunWithThreads.HelloItsMe h2 = fwt.new HelloItsMe("Harriet");

        Thread t1 = new Thread(h1);
        Thread t2 = new Thread(h2);

        t1.start();
        t2.start();
    }

}
