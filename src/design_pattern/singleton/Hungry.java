package design_pattern.singleton;

/**
 * 饿汉式, 最常用的单例, 线程安全, 非懒加载
 */
public class Hungry {

  private static Hungry instance = new Hungry();

  private Hungry() {
  }

  public static Hungry getInstance() {
    return instance;
  }

}
