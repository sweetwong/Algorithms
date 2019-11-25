package leet_code;

class Item5 {
  public String longestPalindrome(String s) {
    if (s == null || s.isEmpty()) return "";

    int st = 0, en = 0;

    for (int i = 0; i < s.length(); i++) {
      int len1 = expand(s, i, i);
      int len2 = expand(s, i, i + 1);
      int len = Math.max(len1, len2);
      if (len > en - st + 1) {
        // 对于偶数, 因为i是中间偏左, 左右起始点必须这么求
        // 对于奇数, (len - 1) / 2和 len / 2的值是一样的, 因此根据偶数的要求决定
        st = i - (len - 1) / 2;
        en = i + len / 2;
      }
    }
    return s.substring(st, en + 1);
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
