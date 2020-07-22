package leet_code;

/**
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 *
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 *
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class Item125_验证回文串 {

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }

        int len = s.length();
        char[] chars = s.toCharArray();

        int i = 0;
        int j = len - 1;

        while(i < j) {
            while (i < len && !Character.isLetter(chars[i]) && !Character.isDigit(chars[i])) {
                i++;
            }
            while (j >= 0 && !Character.isLetter(chars[j]) && !Character.isDigit(chars[j])) {
                j--;
            }
            if (i < j) {
                if (Character.toLowerCase(chars[i]) != Character.toLowerCase(chars[j])) {
                    return false;
                }
            }
            i++;
            j--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
    }

}

