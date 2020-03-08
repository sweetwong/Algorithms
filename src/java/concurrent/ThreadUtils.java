package java.concurrent;

class ThreadUtils {

  public static void print() {
    System.out.println(Thread.currentThread().getName());
  }

  public static void print(String msg) {
    System.out.println(Thread.currentThread().getName() + ", " + msg);
  }

}
