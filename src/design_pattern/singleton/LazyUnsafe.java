package design_pattern.singleton;

/**
 * 懒汉式, 不安全
 */
public class LazyUnsafe {

    private static LazyUnsafe instance;

    private LazyUnsafe() {
    }

    public static LazyUnsafe getInstance() {
        if (instance == null) {
            instance = new LazyUnsafe();
        }
        return instance;
    }

}
