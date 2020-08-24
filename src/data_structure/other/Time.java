package data_structure.other;

public class Time {

    public static void watch(Runnable runnable) {
        long prev = System.currentTimeMillis();
        runnable.run();
        long curr = System.currentTimeMillis();
        System.out.println(curr - prev + "毫秒");
    }

    public static void watch(Runnable runnable, String tag) {
        long prev = System.currentTimeMillis();
        runnable.run();
        long curr = System.currentTimeMillis();
        System.out.println(tag + ": " + (curr - prev) + "毫秒");
    }


    public static void watchUS(Runnable runnable) {
        long prev = System.nanoTime();
        runnable.run();
        long curr = System.nanoTime();
        System.out.println((curr - prev) / 1000 + "微秒");
    }

    public static void watchNS(Runnable runnable) {
        long prev = System.nanoTime();
        runnable.run();
        long curr = System.nanoTime();
        System.out.println(curr - prev + "纳秒");
    }

}
