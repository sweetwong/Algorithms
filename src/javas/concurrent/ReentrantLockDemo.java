package javas.concurrent;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockDemo {

    private ReentrantLock mLock = new ReentrantLock();

    public void go() {
        mLock.lock();
        try {
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
        demo.go();
        new Thread(demo::go).start();
    }

}
