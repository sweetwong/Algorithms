package leet_code;

class Item38_外观数列 {

  public static String countAndSay(int n) {
    if (n == 1) return "1";

    // 不存在重复子问题, 因为大问题只分成了一个小问题, 且每个问题都不一样, 因此不需要用动态规划解决重复子问题
    // 此处由于递归深度达到n, 因此空间复杂度为n
    String prevSay = countAndSay(n - 1);
    int prevLen = prevSay.length();

    StringBuilder sb = new StringBuilder();
    int i = 0;
    while (i < prevLen) {
      int count = 1, j = i + 1;
      while (j < prevLen && prevSay.charAt(i) == prevSay.charAt(j)) {
        j++;
        count++;
      }
      sb.append(count);
      sb.append(prevSay.charAt(i));

      i = j;
    }

    return sb.toString();
  }

}
