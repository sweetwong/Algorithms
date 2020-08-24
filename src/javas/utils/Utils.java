package javas.utils;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.text.DecimalFormat;
import java.util.UUID;

public class Utils {

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

<<<<<<< HEAD
    public static void printStackStrace() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (int i = 2; i < stackTrace.length; i++) {
            System.out.println(stackTrace[i]);
        }
    }
=======
    public static String formatString(long data) {
        DecimalFormat df = new DecimalFormat("#,###");
        return df.format(data);
    }

>>>>>>> 4446c4a3cbb770947557a86f1564a7eb2d1dd74c
}
