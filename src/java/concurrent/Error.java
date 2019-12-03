package java.concurrent;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 这种情况是因为某个线程获取到的num并不是最新的num,其他的线程已经更改过了
 */
class Error {

  public static void main(String[] args) {
    Error e = new Error();
    e.main();
  }

  private int num = 0;


  private ReentrantLock lock = new ReentrantLock();

  private void main() {
    new Thread(()->{
      lock.lock();
      try {
        Thread.sleep(2000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      lock.unlock();
    });

    for (int i = 1; i <= 10; i++) {
      int finalI = i;
      new Thread(() -> {
        go(finalI);
      }).start();
      System.out.println(i);
    }
  }

  private void go(int i) {
    lock.lock();
    for (int j = 0; j < 100000; j++) {
      System.out.println(i + "  go  " + ++num);
    }
    try {
      Thread.sleep(500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    lock.unlock();
  }

}
