package leet_code;

class Item8_字符串转换整数atoi {


    private static boolean isNumber(char c) {
        return c >= 48 && c <= 57;
    }

    private static boolean isSigned(char c) {
        return c == '-' | c == '+';
    }


}
