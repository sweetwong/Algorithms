package javas.utils;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.text.DecimalFormat;
import java.util.StringJoiner;
import java.util.UUID;

public class Utils {

    public static void print(Object... texts) {
        StringJoiner joiner = new StringJoiner(", ");
        for (Object text : texts) {
            joiner.add(String.valueOf(text));
        }
        System.out.println(joiner.toString());
    }

    public static void printObjectSize(Object obj) {
        System.out.println(formatString(ObjectSizeCalculator.getObjectSize(obj)));
    }

    public static String bigText(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(UUID.randomUUID().toString());
        }
        return builder.toString();
    }

    public static void printStackStrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 2; i < stackTrace.length; i++) {
            System.out.println(stackTrace[i]);
        }
    }

    public static String formatString(long data) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(data);
    }

}
