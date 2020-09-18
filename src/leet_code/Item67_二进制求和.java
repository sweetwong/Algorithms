package leet_code;

/**
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 *
 * 输入为 非空 字符串且只包含数字 1 和 0。
 *
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 *
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 提示：
 * 每个字符串仅由字符 '0' 或 '1' 组成。
 * 1 <= a.length, b.length <= 10^4
 * 字符串如果不是 "0" ，就都不含前导零。
 */
class Item67_二进制求和 {

    public static String addBinary(String a, String b) {
        int nA = a.length(), nB = b.length();
        int i = nA - 1, j = nB - 1;

        StringBuilder builder = new StringBuilder();

        int carry = 0;
        while (i >= 0 || j >= 0) {
            int intI = i >= 0 ? a.charAt(i) - '0' : 0;
            int intJ = j >= 0 ? b.charAt(j) - '0' : 0;
            int sum = intI + intJ + carry;
            // 记住这个pop和carry的求法, 很经典, 很多类似的题目都会用到
            int pop = sum % 2;
            carry = sum / 2;
            builder.append(pop);
            i--;
            j--;
        }
        if (carry > 0) {
            builder.append(carry);
        }

        return builder.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "1111", b = "1111";
        String res = addBinary(a, b);
        System.out.println(res);
    }

}
