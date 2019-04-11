package test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ying on 2019/4/8.
 */
public class Counter implements Runnable {
    public static int count = 0;
    public static AtomicInteger atcount = new AtomicInteger(0);

    public void atocal() {
        atcount.incrementAndGet();
    }

    public synchronized void cal() {
        count++;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
//            cal();
            atocal();
        }

    }

    public static void main(String[] args) {
        Counter c = new Counter();
        for (int i = 0; i < 5; i++) {
            new Thread(c).start();
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(atcount);

    }
}
