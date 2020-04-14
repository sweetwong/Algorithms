package java.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class ThreadPoolDemo {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 1000000; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "  " + finalI);
                }
            });
        }
        executor.shutdown();
        for (int i = 0; i < 10000; i++) {
            int finalI = i;
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() + "  " + finalI);
                }
            });
        }

    }
}
