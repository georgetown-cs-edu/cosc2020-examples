import java.util.concurrent.Semaphore;

public class SemaphoreExample {

    class Worker implements Runnable {

        private Semaphore semaphore;
        private int id;

        public Worker(Semaphore semaphore, int id) {
            this.semaphore = semaphore;
            this.id = id;
        }

        @Override
        public void run() {
            try {
                // Acquire a permit from the semaphore
                semaphore.acquire();

                // Perform some work
                System.out.println("Thread " + id + " is working");
                Thread.sleep(2000);
                System.out.println("Thread " + id + " finished working");

                // Release the permit back to the semaphore
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        SemaphoreExample example = new SemaphoreExample();

        // Create a semaphore with 3 permits
        Semaphore semaphore = new Semaphore(3);

        // Create and start multiple threads
        for (int i = 1; i <= 5; i++) {
            Thread thread = new Thread(example.new Worker(semaphore, i));
            thread.start();
        }
    }
}
