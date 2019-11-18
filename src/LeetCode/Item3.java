package LeetCode;

import java.util.HashSet;
import java.util.Set;

/**
 * 无重复字符的最长子串
 * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
 */
class Item3 {

  public static int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int res = 0, l = 0, r = 0;
    while (r < s.length()) {
      char curr = s.charAt(r);
      // 如果Set不包含，快指针进一步
      if (!set.contains(curr)) {
        set.add(curr);
        r++;
        res = Math.max(res, r - l);
      }
      // 如果Set包含，满指针进一步
      else {
        set.remove(s.charAt(l));
        l++;
      }
    }
    return res;
  }

}