package valuegenerator;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ValueGenerator implements Runnable {

    private Double value = 0.0;
    private final Object lock = new Object();
    ExecutorService executor = Executors.newFixedThreadPool(1);

    public void start() {
        executor.submit(this);
    }

    public void stop() {
        executor.shutdownNow();
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                value  = Math.random() * 10;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                break;
            }
        }
    }

    public Double getValue() {
        synchronized (lock) {
            return (double)Math.round(value * 100d) / 100d;
        }
    }
}


