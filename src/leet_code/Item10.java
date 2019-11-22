package leet_code;

class Item10 {

  /**
   *
   * s = "aab";
   * p = "c*a*b";
   * <p>
   * s = "mississippi"
   * p = "mis*is*p*."
   * <p>
   * 如果 p >= 2 且 p[1] == '*'
   * 可以把问题分解成两个子问题
   * <p>
   * 否则就看第一个是否匹配,并将问题缩小一个规模
   *
   */
  public static boolean isMatch(String s, String p) {
    // 递归的终止条件
    if (p.isEmpty()) return s.isEmpty();

    // 判断第一个字符是否匹配
    boolean firstMatch = (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.'));

    // 如果pattern的长度大于等于2且第二个为星
    if (p.length() >= 2 && p.charAt(1) == '*') {
      return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
    }
    // 如果pattern的长度为1或者大于等于2但是第二不为星
    else {
      return firstMatch && isMatch(s.substring(1), p.substring(1));
    }
  }

  public static void main(String[] args) {
    String s = "";
    String p = "a*";
    System.out.println(isMatch(s, p));
  }

}