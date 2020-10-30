package javas.concurrent;

import java.util.StringJoiner;

public class ThreadUtils {

    public static void print(Object... objects) {
        String threadName = Thread.currentThread().getName();
        if (objects.length == 0) {
            System.out.println(threadName);
            return;
        }
        StringJoiner joiner = new StringJoiner(", ");
        for (Object object : objects) {
            joiner.add(String.valueOf(object));
        }
        System.out.println(threadName + ": " + joiner);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
