import java.util.ArrayList;

public class RuhOh {

    class Widget {   }

    private ArrayList<Widget> widgetList = new ArrayList<Widget>();

    class Producer implements Runnable {
        @Override
        public void run() {
            while (true) {
                Widget w = new Widget();
                System.out.println("I'm thread " + Thread.currentThread().getId() + " and I made a widget");
                widgetList.add(w);
            }
        }
    }

    class Consumer implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (widgetList.size() > 0) {
                    widgetList.remove(0);
                    System.out.println("I'm thread " + Thread.currentThread().getId() + " and I ate a widget");
                }
            }
        }
    }

    public static void main(String args[]) {
        final int numProducers = 10;
        final int numConsumers = 20;

        RuhOh ro = new RuhOh();

        // create the producers
        for (int p = 0; p < numProducers; p++) {
            Producer prod = ro.new Producer();
            Thread t = new Thread(prod);
            t.start();
        }
        // and now the consumers
        for (int c = 0; c < numConsumers; c++) {
            Consumer con = ro.new Consumer();
            Thread t = new Thread(con);
            t.start();
        }
    }
}
