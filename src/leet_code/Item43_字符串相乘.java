package leet_code;

import java.util.Arrays;

class Item43_字符串相乘 {

    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";

        int len1 = num1.length();
        int len2 = num2.length();

        int[] nums = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                // 此处利用 c -'0'把char转成int, 比起Integer.parseInt(String.valueOf(c))效率更高
                int product = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int index = i + j + 1;

                // 这一步处理了sum>=10的情况
                int sum = nums[index] + product;
                nums[index] = sum % 10;
                nums[index - 1] += sum / 10;
            }
        }

        StringBuilder res = new StringBuilder();
        int start = 0;
        if (nums[start] == 0) start++;
        for (int i = start; i < nums.length; i++) {
            res.append(nums[i]);
        }
        return res.toString();
    }

}
