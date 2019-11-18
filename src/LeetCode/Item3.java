package LeetCode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
class Item3 {

  public static int lengthOfLongestSubstring(String s) {
    Set<Character> set = new HashSet<>();
    int times = 0;
    int res = 0, l = 0, r = 0;
    while (r < s.length()) {
      times++;
      System.out.println("times: " + times + " ,l: " + l + ", r: " + r + ", res: " + res +
        ", char[l]: " + s.charAt(l) + ", char[r]: " + s.charAt(r));
      char curr = s.charAt(r);
      if (!set.contains(curr)) {
        set.add(curr);
        r++;
        res = Math.max(res, r - l);
      } else {
        set.remove(s.charAt(l));
        System.out.print("curr: " + curr + "\ns.charAt(l): " + s.charAt(l) + "\n\n");
        l++;
      }
    }
    return res;
  }

}