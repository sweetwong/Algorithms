package leet_code.important;

import data_structure.other.Time;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 S、一个字符串 T 。
 * 请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 *
 * 示例：
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 *  
 * 提示：
 * 如果 S 中不存这样的子串，则返回空字符串 ""。
 * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
 */
public class Item76_最小覆盖字串 {

    public static String minWindow(String s, String t) {
        if (s == null || s.isEmpty()) return "";

        String minWindow = null;

        Map<Character, Integer> windowMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int i = 0, j = -1;
        while (j < s.length() || i < j) {
            if (check(windowMap, tMap)) {
                if (minWindow == null || j - i + 1 < minWindow.length()) {
                    minWindow = s.substring(i, j + 1);
                }

                Character charI = s.charAt(i);
                if (windowMap.containsKey(charI)) {
                    windowMap.put(charI, windowMap.get(charI) - 1);
                }
                i++;
            } else {
                if (j == s.length() - 1) {
                    return minWindow == null ? "" : minWindow;
                }
                j++;
                Character charJ = s.charAt(j);
                if (tMap.containsKey(charJ)) {
                    windowMap.put(charJ, windowMap.getOrDefault(charJ, 0) + 1);
                }
            }
        }

        return minWindow;
    }

    private static boolean check(Map<Character, Integer> windowMap, Map<Character, Integer> tMap) {
        for (Character c : tMap.keySet()) {
            if (windowMap.getOrDefault(c, 0) < tMap.getOrDefault(c, 0)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 10000000; i++) {
            sBuilder.append((char) ('A' + (int) (26 * Math.random())));
        }
        StringBuilder tBuilder = new StringBuilder();
        for (int i = 0; i < 1000000; i++) {
            tBuilder.append((char) ('A' + (int) (26 * Math.random())));
        }

        String s = sBuilder.toString();
        String t = tBuilder.toString();

        Time.watch(() -> minWindow(s, t));
    }


}
