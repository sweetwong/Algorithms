package util;

public class Time {

  /**
   * 观察一个函数执行需要的时间
   *
   * @param input 返回输入的参数
   * @param observable 被观察的函数
   * @param repeat 重复的次数
   * @param <T> 输入参数的类型
   */
  public static <T> void watch(Fun1<T> input, Fun2<T> observable, int repeat) {
    int totalTime = 0;
    for (int i = 0; i < repeat; i++) {
      T para = input.run();
      long prev = System.currentTimeMillis();
      observable.run(para);
      long curr = System.currentTimeMillis();
      totalTime += curr - prev;
      System.out.println("第" + (i + 1) + "次: " + (curr - prev) + "毫秒");
    }
    System.out.println("平均: " + totalTime / repeat + "毫秒");
    System.out.println();
  }

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

  public interface Fun1<T> {

    T run();

  }

  public interface Fun2<T> {

    void run(T t);

  }


}
