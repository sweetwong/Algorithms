package leet_code.important;

/**
 * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 *
 * 说明:
 *
 * s 可能为空，且只包含从 a-z 的小写字母。
 * p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
 * 示例 1:
 *
 * 输入:
 * s = "aa"
 * p = "a"
 * 输出: false
 * 解释: "a" 无法匹配 "aa" 整个字符串。
 * 示例 2:
 *
 * 输入:
 * s = "aa"
 * p = "a*"
 * 输出: true
 * 解释: 因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
 *
 * 示例 3:
 * 输入:
 * s = "ab"
 * p = ".*"
 * 输出: true
 * 解释: ".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
 *
 * 示例 4:
 * 输入:
 * s = "aab"
 * p = "c*a*b"
 * 输出: true
 * 解释: 因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
 *
 * 示例 5:
 * 输入:
 * s = "mississippi"
 * p = "mis*is*p*."
 * 输出: false
 *
 * 解法:
 * 在普通递归的基础上, 添加了记忆表
 */
class Item10_正则表达式匹配_动态规划_自顶向下 {

    public static boolean isMatch(String s, String p) {
        return isMatch(s, p, new Boolean[s.length() + 1][p.length() + 1]);
    }

    public static boolean isMatch(String s, String p, Boolean[][] dp) {
        if (p.isEmpty()) return s.isEmpty();

        int sLen = s.length();
        int pLen = p.length();

        if (dp[sLen][pLen] != null) {
            return dp[sLen][pLen];
        }

        boolean firstMatch = !s.isEmpty() && (p.charAt(0) == '.' || s.charAt(0) == p.charAt(0));
        boolean secondStar = pLen >= 2 && p.charAt(1) == '*';

        boolean res;
        if (firstMatch) {
            if (secondStar) {
                res = isMatch(s.substring(1), p.substring(1), dp) || isMatch(s, p.substring(2), dp) || isMatch(s.substring(1), p, dp);
            } else {
                res = isMatch(s.substring(1), p.substring(1), dp);
            }
        } else {
            if (secondStar) {
                res = isMatch(s, p.substring(2), dp);
            } else {
                res = false;
            }
        }

        dp[sLen][pLen] = res;

        return res;
    }

    public static void main(String[] args) {
        String s = "mississippi";
        String p = "mis*is*p*.";
        System.out.println(isMatch(s, p));
    }

}