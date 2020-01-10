package design_pattern.singleton;

public class LazySafe {

  private static LazySafe instance;

  private LazySafe() {
  }

  public synchronized static LazySafe getInstance() {
    if (instance == null) {
      instance = new LazySafe();
    }
    return instance;
  }

}
