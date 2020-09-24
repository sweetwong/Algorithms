package javas.concurrent;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int totalThread = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalThread);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < totalThread; i++) {
            executorService.execute(() -> {
                ThreadUtils.print("before..");
                try {
                    cyclicBarrier.await();
                    Thread.sleep(2000);
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
                ThreadUtils.print("after..");
            });
        }
        executorService.shutdown();
    }

}
