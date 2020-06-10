package leet_code.important;

class Item5_最长回文子串_暴力法 {

    public static String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) {
            return s;
        }

        int maxI = 0;
        int maxJ = 0;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len - 1; i++) {
            for (int j = 1; j < len; j++) {
                if (isPalindrome(chars, i, j)) {
                    if (j - i > maxJ - maxI) {
                        maxI = i;
                        maxJ = j;
                    }
                }
            }
        }
        return s.substring(maxI, maxJ + 1);
    }

    private static boolean isPalindrome(char[] chars, int i, int j) {
        while (i < j) {
            if (chars[i] != chars[j]) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("bb"));
    }

}
