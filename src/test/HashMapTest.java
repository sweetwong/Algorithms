package test;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.UUID;

/**
 * 用于测试哈希散射表的散射状态
 */
public class HashMapTest {

    public static void main(String[] args) throws Exception {
        HashMap<String, String> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(UUID.randomUUID().toString(), null);
        }

        Class<?> hashMapClass = HashMap.class;
        Field tableField = hashMapClass.getDeclaredField("table");
        tableField.setAccessible(true);
        Object[] table = (Object[]) tableField.get(map);

        Class<?> nodeClass = Class.forName("java.util.HashMap$Node");
        Field nextField = nodeClass.getDeclaredField("next");
        nextField.setAccessible(true);

        int[] binCounts = new int[table.length];
        int nonNullCount = 0;

        int maxBinCount = 0;
        for (int i = 0; i < table.length; i++) {
            Object node = table[i];
            if (node != null) {
                int binCount = 1;
                while ((node = nextField.get(node)) != null) {
                    binCount++;
                    maxBinCount = Math.max(maxBinCount, binCount);
                }
                binCounts[i] = binCount;
                nonNullCount++;
            }
        }

        System.out.println("maxBinCount: " + maxBinCount);
        System.out.println("table.length: " + table.length);
        System.out.println("nonNullCount: " + nonNullCount);
        System.out.println("binCounts: " + Arrays.toString(binCounts));
    }

}
