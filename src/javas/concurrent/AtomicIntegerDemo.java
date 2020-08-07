package javas.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 这种情况是因为某个线程获取到的num并不是最新的num,其他的线程已经更改过了
 */
class AtomicIntegerDemo {

    public static void main(String[] args) {
        unsafeCount();
        safeCount();
        ThreadUtils.sleep(1000);
        System.out.println("count = " + count);
        System.out.println("countAtomicInt = " + countAtomicInt);
        ThreadUtils.sleep(1000);
    }

    static int count = 0;

    static AtomicInteger countAtomicInt = new AtomicInteger(0);

    /**
     * 此处多个线程共同修改一个参数, 考虑到Java内存模型, count最后不会如预期值, 这是因为没有保证原子性
     * 即使在count前面加volatile也没有, 因为volatile只能保证: 1. 可见性 2: 有序性
     */
    static void unsafeCount() {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    ++count;
                }
            }).start();
        }

    }

    static void safeCount() {
        for (int i = 0; i < 1000; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    countAtomicInt.incrementAndGet();
                }
            }).start();
        }
    }

}
