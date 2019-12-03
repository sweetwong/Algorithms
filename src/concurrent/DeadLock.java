package concurrent;

public class DeadLock {

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
          System.out.println("执行t1");
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
          System.out.println("执行t2");
        }
      }
    });
    t1.start();
    t2.start();
  }

  public static void main(String[] args) {
    new DeadLock().deadLock();
  }

}
