package javas.concurrent;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 用CAS方法原子地更新对象, 并加入Stamp来解决ABA问题
 */
class AtomicStampedReferenceDemo {

    public static void main(String[] args) throws InterruptedException {
        unsafeCount();
        Thread.sleep(3000);
        safeCount();
    }

    // 这个地方会因为原子性问题导致count没有达到预期值, 即使加了volatile也没有用, 因为volatile只保证了可见性和有序性
    volatile static int count = 0;

    // 通过标记stamped解决ABA问题
    static AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(0, randomInt());

    static final int M = 100;
    static final int N = 1000;

    static void unsafeCount() {
        for (int i = 0; i < M; i++) {
            new Thread(() -> {
                for (int j = 0; j < N; j++) {
                    System.out.println(Thread.currentThread().getName() + " " + ++count);

                }
            }).start();
        }
    }

    static void safeCount() {
        for (int i = 0; i < M; i++) {
            new Thread(() -> {
                for (int j = 0; j < N; j++) {
                    for (; ; ) {
                        if (retry()) break;
                    }
                    System.out.println(Thread.currentThread().getName() + " " + asr.getReference());
                }
            }).start();
        }
    }

    static boolean retry() {
        // 第一步, asr.getReference()由于AtomicStampedReference的Pair是有volatile的, 因此拿到的值一定是最新的
        // 第二步, 赋值给expectReference的值一定是刚刚第一步拿到的值, 虽然到此时不一定是最新的, 因为这是第二步, 可能其他线程已经更新了
        Integer expectReference = asr.getReference();
        // 第三步, expectReference + 1
        // 第四步, 赋值给updateReference
        Integer updateReference = expectReference + 1;

        int expectStamp = asr.getStamp();
        int updateStamp = randomInt();

        return asr.compareAndSet(expectReference, updateReference, expectStamp, updateStamp);
    }

    static int randomInt() {
        return (int) (Integer.MAX_VALUE * Math.random());
    }

}