package leet_code;

/**
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*'.
 *
 * '.' Matches any single character.
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 * Note:
 *
 * s could be empty and contains only lowercase letters a-z.
 * p could be empty and contains only lowercase letters a-z, and characters like . or *.
 *
 * Example 1:
 * Input:
 * s = "aa"
 * p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 *
 * Example 2:
 * Input:
 * s = "aa"
 * p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 *
 * Example 3:
 * Input:
 * s = "ab"
 * p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 *
 * Example 4:
 * Input:
 * s = "aab"
 * p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 *
 * Example 5:
 * Input:
 * s = "mississippi"
 * p = "mis*is*p*."
 * Output: false
 */
class Item10_dp {

  public static void main(String[] args) {
    String s = "mississippi";
    String p = "mis*is*p*.";
    isMatch(s, p);
  }

  public static boolean isMatch(String s, String p) {
    Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
    return helper(s, p, dp);
  }

  public static boolean helper(String s, String p, Boolean[][] dp) {
    int lenS = s.length();
    int lenP = p.length();

    if (dp[lenS][lenP] != null) {
      return dp[lenS][lenP];
    }

    // 当p的长度为0, 递归的终止条件
    if (lenP == 0) return lenS == 0;

    // 判断第一个字符是否匹配
    boolean firstMatch = (lenS != 0 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

    // 当p的长度为1, 这种情况不存在'*'问题
    if (lenP == 1) {
      return s.length() == 1 && firstMatch;
    }

    // p的长度为0和1都被拦截了, 下面的都是p长度大于1的情况

    boolean result;

    // 当p的长度大于1, 且第二字符为'*'
    if (p.charAt(1) == '*') {
      // 当第一个字符匹配, 大问题可以分为两种子问题, s进1 或者 p进2
      if (firstMatch) {
        result = isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
      }
      // 当第一个字符不匹配, 减小问题范围, 只能 p进2(忽略掉'*'和其前一个字符)
      else {
        result = isMatch(s, p.substring(2));
      }
    }
    // 当p的长度大于1, 且第二个字符不为'*', 问题规模缩小1
    else {
      result = firstMatch && isMatch(s.substring(1), p.substring(1));
    }

    dp[lenS][lenP] = result;

    return result;

  }


}