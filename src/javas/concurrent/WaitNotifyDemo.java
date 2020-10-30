package javas.concurrent;

class WaitNotifyDemo {

    void run() {
        Thread.currentThread().setName("主线程");

        Thread t1 = new Thread(() -> {
            synchronized (this) {
                try {
                    wait();
                    // 在被唤醒以后, t1不会立刻进入Runnable, 而是先进入Blocked, 等待下面的synchronized代码结束后, 才获取到锁, 进入Runnable状态
                    ThreadUtils.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                ThreadUtils.print("结束");
            }
        }, "子线程");
        t1.start();

        ThreadUtils.sleep(500);

        synchronized (this) {
            ThreadUtils.print("A", t1.getState());
            notify();
            ThreadUtils.print("B", t1.getState());
        }
        ThreadUtils.sleep(10);
        ThreadUtils.print("C", t1.getState());
    }

    public static void main(String[] args) {
        new WaitNotifyDemo().run();
    }
}
