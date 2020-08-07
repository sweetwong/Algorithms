package leet_code.important;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 *
 * 示例 1：
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba" 也是一个有效答案。
 *
 * 示例 2：
 * 输入: "cbbd"
 * 输出: "bb"
 *
 * 最长回文子字符串
 */
class Item5_最长回文子串_扩散法 {

    public String longestPalindrome(String s) {
        if (s == null || s.isEmpty()) return "";

        // 由于要返回的是字符串, 所以记录了起始点和终点
        // 如果只用返回长度, 记录最大的长度会更高
        int begin = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            int len = Math.max(expand(s, i, i), expand(s, i, i + 1));
            if (len > end - begin + 1) {
                // 注意这里要适配两种情况, 分别是len为奇数和len为偶数, 可以带入特定的值求解
                // 分别是:
                // i = 1, len = 3 -> begin = 1 - (3 - 1) / 2 = 0, end = 1 + 3 / 2 = 2
                // i = 1, len = 4 -> begin = 1 - (4 - 1) / 2 = 0, end = 1 + 4 / 2 = 3
                begin = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(begin, end + 1);
    }

    // 关键, 此处返回的是长度len, 通过长度len求出左起始点和又起始点
    private int expand(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // 最后还会执行多一次l--,r++, 所以return r-l-1而不是return r-l+1
        return right - left - 1;
    }
}
