package javas.concurrent;

public class ThreadUtils {

    public static <T> void print(T t) {
        System.out.println(Thread.currentThread().getName() + ": " + t);
    }
}
