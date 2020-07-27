package data_structure.other;

public class NumberUtils {

    /**
     * 打印出一个整型对应的二进制字符串
     */
    public static void printBinary(int num) {
        System.out.println(num);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            builder.append(num & 1);
            num = num >>> 1;
        }
        System.out.println(builder.reverse().toString());

        System.out.println();
    }

    public static void printBinary(byte b) {
        int num = (int) b;

        System.out.println(num);

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 32; i++) {
            builder.append(num & 1);
            num = num >>> 1;
        }
        builder.delete(8, 32);
        System.out.println(builder.reverse().toString());

        System.out.println();
    }


}
