
class RaceCondition {
    
    private int balance = 0;

    public void increaseBalance(int amount) {
        int b = this.balance;
        
        try {
            Thread.sleep(5);
        } catch( InterruptedException e ) {
            System.out.println("Interrupted");
        }
        
        b += amount;

        this.balance = b;
    }



    public static void main( String args[] ) {

        final int numThreads = 500;

        RaceCondition rc = new RaceCondition();

        Thread threads[] = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) { 
            threads[i] = new Thread( new Runnable() {
                public void run() {
                    rc.increaseBalance(1);
                }
            });
        }
        
        for (int i = 0; i < numThreads; i++) { 
            threads[i].start();
        }

        for (int i = 0; i < numThreads; i++) { 
            try {
                threads[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("the balance is " + rc.balance );
    }

}
