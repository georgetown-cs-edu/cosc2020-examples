class CrazyThreads {

    class MyRunnable implements Runnable {

        private String name;

        MyRunnable( String name ) {
            this.name = name;
        }


        @Override
        public void run() {
            for (int i = 0; i < 50; i++ ) {
                System.out.println("Hello, I am " + name + "!");
                try {
                    Thread.sleep( (int)(Math.random() *  1000.0) );
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main( String args[] ) {

        final int NUM_THREADS = 100;

        CrazyThreads ct = new CrazyThreads();

        for( int t = 0; t < NUM_THREADS; t++ ) {
            MyRunnable mr = ct.new MyRunnable("Thread " + t);
            Thread newThread = new Thread(mr);
            newThread.start();
        }

    }

}