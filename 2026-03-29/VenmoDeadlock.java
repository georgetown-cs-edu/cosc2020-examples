public class VenmoDeadlock {
    static final Object aliceAccount = new Object();
    static final Object bobAccount = new Object();

    public static void main(String[] args) {
        // Thread 1: Alice sends money to Bob
        new Thread(() -> {
            synchronized (aliceAccount) {
                System.out.println("Thread 1: Locked Alice's account");
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                } // Pause to ensure Thread 2 starts

                System.out.println("Thread 1: Waiting for Bob's account...");
                synchronized (bobAccount) {
                    System.out.println("Thread 1: Transferred money!");
                }
            }
        }).start();

        // Thread 2: Bob sends money to Alice
        new Thread(() -> {
            synchronized (bobAccount) {
                System.out.println("Thread 2: Locked Bob's account");
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                } // Pause to ensure Thread 1 starts

                System.out.println("Thread 2: Waiting for Alice's account...");
                synchronized (aliceAccount) {
                    System.out.println("Thread 2: Transferred money!");
                }
            }
        }).start();
    }
}
