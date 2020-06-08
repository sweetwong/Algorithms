package javas.concurrent;

/**
 * 死锁示例
 *
 * 当两个线程互相占有对方的锁, 就会发生死锁
 */
public class DeadLockDemo {

    Object o1 = new Object();
    Object o2 = new Object();

    void deadLock() {
        Thread t1 = new Thread(() -> {
            synchronized (o1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o2) {
                    ThreadUtils.print("执行t1");
                }
            }
        });
        Thread t2 = new Thread(() -> {
            synchronized (o2) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (o1) {
                    ThreadUtils.print("执行t2");
                }
            }
        });

        t1.start();
        t2.start();
    }

    public static void main(String[] args) {
        new DeadLockDemo().deadLock();
    }

}
