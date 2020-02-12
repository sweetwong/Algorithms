package util;

public class TimeWatcher {

  public static void watch(Fun fun) {
    long prev = System.currentTimeMillis();
    fun.run();
    long curr = System.currentTimeMillis();
    System.out.println(curr - prev + "毫秒");
  }

  public static void watch(Fun fun, String tag) {
    long prev = System.currentTimeMillis();
    fun.run();
    long curr = System.currentTimeMillis();
    System.out.println(tag + ": " + (curr - prev) + "毫秒");
  }


  public static void watchUS(Fun fun) {
    long prev = System.nanoTime();
    fun.run();
    long curr = System.nanoTime();
    System.out.println((curr - prev) / 1000 + "微秒");
  }

  public static void watchNS(Fun fun) {
    long prev = System.nanoTime();
    fun.run();
    long curr = System.nanoTime();
    System.out.println(curr - prev + "纳秒");
  }

  public interface Fun {

    void run();

  }
}
