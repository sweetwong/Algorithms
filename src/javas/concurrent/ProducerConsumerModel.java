package javas.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumerModel {

    static BlockingQueue<String> sBuffer = new ArrayBlockingQueue<>(5);

    static class Reader extends Thread {

        @Override
        public void run() {
            try {
                for (; ; ) {
                    String s = sBuffer.take();
                    System.out.println(s);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class Writer extends Thread {

        @Override
        public void run() {
            for (; ; ) {
                try {
                    sBuffer.put(String.valueOf(System.currentTimeMillis()));
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public static void main(String[] args) {
        new Reader().start();
        new Writer().start();
    }

}
