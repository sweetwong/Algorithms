public class Test {
  public static Object object = new Object();

  public static void main(String[] args) throws InterruptedException {
    Thread1 thread1 = new Thread1("线程1");
    Thread2 thread2 = new Thread2("线程2");
    Thread3 thread3 = new Thread3("线程3");

    thread1.start();
    thread2.start();

    Thread.sleep(2000);

    thread3.start();
  }

  static class Thread1 extends Thread {

    public Thread1(String name) {
      super(name);
    }

    @Override
    public void run() {
      synchronized (object) {
        System.out.println(Thread.currentThread().getName() + "获取到了锁...");
        try {
          System.out.println(Thread.currentThread().getName() + "阻塞并释放锁...");
          object.wait();
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + "执行完成...");
      }
    }
  }

  static class Thread2 extends Thread {

    public Thread2(String name) {
      super(name);
    }

    @Override
    public void run() {
      synchronized (object) {
        System.out.println(Thread.currentThread().getName() + "获取到了锁...");
        try {
          System.out.println(Thread.currentThread().getName() + "阻塞并释放锁...");
          object.wait();
        } catch (InterruptedException e) {
        }
        System.out.println(Thread.currentThread().getName() + "执行完成...");
      }
    }
  }

  static class Thread3 extends Thread {

    public Thread3(String name) {
      super(name);
    }

    @Override
    public void run() {
      synchronized (object) {
        System.out.println(Thread.currentThread().getName() + "获取到了锁...");
        object.notifyAll();
        System.out.println(Thread.currentThread().getName() + "唤醒了正在wait的线程...");
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "执行完成...");
      }
    }
  }
}
