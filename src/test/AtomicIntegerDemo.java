package test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by ying on 2019/4/24.
 */
public class AtomicIntegerDemo {
    static AtomicInteger i = new AtomicInteger();
    public static class AddThread implements Runnable{

        @Override
        public void run() {
            for (int j = 0; j <1000 ; j++) {
                i.incrementAndGet();
            }

        }
    }

   /* public static void main(String[] args) throws InterruptedException {
        Thread[] t = new Thread[10];
        for (int j = 0; j < t.length; j++) {
            t[j] = new Thread(new AddThread());
        }
        for (int j = 0; j <t.length ; j++) {
            t[j].start();
        }
        for (int j = 0; j <t.length ; j++) {
            t[j].join();
        }
        System.out.println(i);
    }*/
   public static void main(String[] args) {
       System.out.println(AtomicIntegerDemo.class.getClassLoader());
       System.out.println(Object.class.getClassLoader());
       System.out.println(String.class.getClassLoader());
   }
}
