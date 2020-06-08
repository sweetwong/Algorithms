package javas.concurrent;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

import static javas.concurrent.ThreadUtils.print;

class BlockingQueueDemo {

    private static BlockingQueue<Integer> mQueue = new ArrayBlockingQueue<>(10);

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                try {
                    mQueue.put(i);
                    print("put:" + i);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        for (; ; ) {
            try {
                Integer take = mQueue.take();
                TimeUnit.SECONDS.sleep(1);
                print("take: " + take);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }

}
