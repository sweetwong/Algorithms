package javas.concurrent;

/**
 * 重入锁示例
 */
class ReentrantLockDemo {

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockDemo demo = new ReentrantLockDemo();
        demo.first();
    }

    private UnReentrantLock lock = new UnReentrantLock();

    public void first() throws InterruptedException {
        lock.lock();
        ThreadUtils.print("first");
        last();
        lock.unlock();
    }

    public void last() {
        lock.lock();
        ThreadUtils.print("last");
        lock.unlock();

    }

}
