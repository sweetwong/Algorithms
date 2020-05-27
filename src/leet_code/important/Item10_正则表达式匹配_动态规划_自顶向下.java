package leet_code.important;

/**
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