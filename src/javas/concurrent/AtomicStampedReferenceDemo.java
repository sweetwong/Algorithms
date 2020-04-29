package javas.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 用CAS方法原子地更新对象, 并加入Stamp来解决ABA问题
 */
class AtomicStampedReferenceDemo {

    // 这个地方会因为原子性问题导致count没有达到预期值, 即使加了volatile也没有用, 因为volatile只保证了可见性和有序性
    private volatile static int count = 0;

    // 通过标记stamped解决ABA问题
    private static AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(0, randomInt());

    public static void main(String[] args) throws InterruptedException {
        unsafeCount();
        Thread.sleep(3000);

        safeCount();
        Thread.sleep(3000);
        System.out.println("失败: " + failureMsg.size() + "次");
        System.out.println(failureMsg.toString());
    }

    private static final int M = 100;
    private static final int N = 1000;

    public static void unsafeCount() {
        for (int i = 0; i < M; i++) {
            new Thread(() -> {
                for (int j = 0; j < N; j++) {
                    System.out.println(Thread.currentThread().getName() + " " + ++count);

                }
            }).start();
        }
    }

    public static void safeCount() {
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

    private static List<String> failureMsg = new ArrayList<>();

    private static boolean retry() {
        // 第一步, asr.getReference()由于AtomicStampedReference的Pair是有volatile的, 因此拿到的值一定是最新的
        // 第二步, 赋值给expectReference的值一定是刚刚第一步拿到的值, 虽然到此时不一定是最新的, 因为这是第二步, 可能其他线程已经更新了
        Integer expectReference = asr.getReference();
        // 第三步, expectReference + 1
        // 第四步, 赋值给updateReference
        Integer updateReference = expectReference + 1;

        int expectStamp = asr.getStamp();
        int updateStamp = randomInt();

        boolean success = asr.compareAndSet(expectReference, updateReference, expectStamp, updateStamp);
        // 这里有个奇怪的错误, 估计也是因为多线程导致的
        if (!success) failureMsg.add("预期值为" + expectReference + "失败");
        return success;
    }

    private static int randomInt() {
        return (int) (Integer.MAX_VALUE * Math.random());
    }

}