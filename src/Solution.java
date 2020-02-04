import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

class Solution {

  private static int count = 0;
  private static AtomicReference<Integer> atomicReference = new AtomicReference<>(0);

  public static void main(String[] args) throws InterruptedException {
    unsafeCount();
    Thread.sleep(3000);

    safeCount();
    Thread.sleep(3000);
    System.out.println("失败: " + failureMsg.size() + "次");
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

  private static List<String> failureMsg = new ArrayList<>();

  public static void safeCount() {
    for (int i = 0; i < M; i++) {
      new Thread(() -> {
        for (int j = 0; j < N; j++) {
          for (; ; ) {
            if (retry()) {
              break;
            } else {
              failureMsg.add("");
            }
          }
          System.out.println(Thread.currentThread().getName() + " " + atomicReference.get());
        }
      }).start();
    }
  }

  private static boolean retry() {
    Integer expect = atomicReference.get();
    return atomicReference.compareAndSet(expect, expect + 1);
  }


}