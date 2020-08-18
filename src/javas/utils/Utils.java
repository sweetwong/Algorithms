package javas.utils;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

import java.util.UUID;

public class Utils {

    public static void printObjectSize(Object obj) {
        System.out.println(ObjectSizeCalculator.getObjectSize(obj));
    }

    public static String bigText(int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            builder.append(UUID.randomUUID().toString());
        }
        return builder.toString();
    }
}
