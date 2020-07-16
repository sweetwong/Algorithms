package javas.concurrent;

public class ThreadUtils {

    public static void print(Object text) {
        System.out.println(Thread.currentThread().getName() + ": " + text);
    }
}
