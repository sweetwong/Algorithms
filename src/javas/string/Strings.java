package javas.string;

public class Strings {

    public static String toHexString(int num, int range) {
        String hexString = Integer.toHexString(num);
        StringBuilder s = new StringBuilder();
        s.append("0X");
        for (int i = hexString.length(); i < range; i++) {
            s.append('0');
        }
        s.append(hexString.toUpperCase());
        return s.toString();
    }
}
