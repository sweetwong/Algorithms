package javas.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private ReentrantLock mLock = new ReentrantLock();

    public void method1() {
        try {
            mLock.lock();
            try {
                Thread.sleep(1000);
                ThreadUtils.print();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            mLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        ExecutorService service = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 5; i++) {
            service.execute(() -> service.execute(demo::method1));
        }
    }

}
