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
class Item10 {

  /**
   * 递归法, 优点: 好理解
   *        缺点: 重复计算子问题, 类似于斐波那契函数的递归计算, 效率很低
   *
   *        如何改善: 使用动态规划 dp
   */
  public boolean isMatch(String s, String p) {

    int len = p.length();

    // 当p的长度为0, 递归的终止条件
    if (len == 0) return s.isEmpty();

    // 判断第一个字符是否匹配
    boolean firstMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

    // 当p的长度为1, 这种情况不存在'*'问题
    if (len == 1) {
      return s.length() == 1 && firstMatch;
    }

    // p的长度为0和1都被拦截了, 下面的都是p长度大于1的情况

    // 当p的长度大于1, 且第二字符为'*'
    if (p.charAt(1) == '*') {
      // 当第一个字符匹配, 大问题可以分为两种子问题, s进1 或者 p进2
      if (firstMatch) {
        return isMatch(s.substring(1), p) || isMatch(s, p.substring(2));
      }
      // 当第一个字符不匹配, 减小问题范围, 只能 p进2(忽略掉'*'和其前一个字符)
      else {
        return isMatch(s, p.substring(2));
      }
    }
    // 当p的长度大于1, 且第二个字符不为'*', 问题规模缩小1
    else {
      return firstMatch && isMatch(s.substring(1), p.substring(1));
    }

  }

  public boolean isMatchDp(String s, String p) {
    return false;
  }


}