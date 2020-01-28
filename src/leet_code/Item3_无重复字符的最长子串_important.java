package leet_code;

import java.util.HashSet;
import java.util.Set;

/**
 * Longest Substring Without Repeating Characters
 */
class Item3_无重复字符的最长子串_important {

  public static int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int res = 0, i = 0, j = 0;
    while (j < s.length()) {
      char curr = s.charAt(j);
      // 如果Set不包含，快指针进一步
      if (!set.contains(curr)) {
        set.add(curr);
        j++;
        res = Math.max(res, j - i);
      }
      // 如果Set包含，慢指针进一步
      else {
        set.remove(s.charAt(i));
        i++;
      }
    }
    return res;
  }

}