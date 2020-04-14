package design_pattern.singleton;

/**
 * 登记式/静态内部类
 */
public class Registration {

    private Registration() {

    }

    public static Registration getInstance() {
        return SingletonHolder.instance;
    }

    private static class SingletonHolder {
        private static Registration instance = new Registration();
    }


}
