package javas.concurrent;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierDemo {

    public static void main(String[] args) {
        int threadNum = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(threadNum);
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < threadNum; i++) {
            int finalI = i;
            executorService.execute(() -> {
                try {
                    ThreadUtils.print("开始睡觉");
                    ThreadUtils.sleep(1000 * finalI);
                    ThreadUtils.print("睡觉结束");
                    cyclicBarrier.await();
                    ThreadUtils.print("结束");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        }
        executorService.shutdown();
    }

}
