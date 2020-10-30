package javas.concurrent;

import java.util.concurrent.Semaphore;

public class SemaphoreDemo {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    ThreadUtils.print("尝试");
                    ThreadUtils.sleep(1000);
                    semaphore.acquire();
                    ThreadUtils.print("成功");
                    ThreadUtils.sleep(1000);
                } catch (Exception e) {
                    ThreadUtils.print("异常");
                } finally {
                    semaphore.release();
                }
            }, "线程" + i).start();
        }
    }

}
