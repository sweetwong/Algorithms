package javas.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private ReentrantLock mLock = new ReentrantLock();

    public void go() {
        mLock.lock();
        try {
            ThreadUtils.sleep(20000);
            ThreadUtils.print();
        } finally {
            mLock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        new Thread(() -> {
            demo.go();
        }).start();
        demo.go();
    }

}
