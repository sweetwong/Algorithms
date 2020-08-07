package javas.concurrent;

public class ThreadUtils {

    public static void print(Object... objects) {
        String[] strings = new String[objects.length];
        for (int i = 0; i < objects.length; i++) {
            strings[i] = String.valueOf(objects[i]);
        }
        String res = String.join(", ", strings);
        System.out.println(Thread.currentThread().getName() + ": " + res);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
