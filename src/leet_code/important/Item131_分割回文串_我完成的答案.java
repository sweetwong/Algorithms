package leet_code.important;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 *
 * 返回 s 所有可能的分割方案。
 *
 * 示例:
 *
 * 输入: "aab"
 * 输出:
 * [
 *   ["aa","b"],
 *   ["a","a","b"]
 * ]
 *
 * start: 11:05 end: 11:35
 *
 */
public class Item131_分割回文串_我完成的答案 {

    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<Integer>> splits = new ArrayList<>();
        backtrack(s, s.length(), splits, new ArrayDeque<>());

        List<List<String>> res = new ArrayList<>();
        for (List<Integer> split : splits) {
            List<String> strs = new ArrayList<>();
            strs.add(s.substring(0, split.get(0) + 1));
            for (int i = 1; i < split.size(); i++) {
                strs.add(s.substring(split.get(i - 1) + 1, split.get(i) + 1));
            }
            res.add(strs);
        }

        return res;
    }

    private void backtrack(String s, int length, List<List<Integer>> splits, Deque<Integer> split) {
        if (!split.isEmpty() && (split.getLast() == length - 1)) {
            splits.add(new ArrayList<>(split));
            return;
        }

        int prev = split.isEmpty() ? -1 : split.getLast();
        for (int i = prev + 1; i < length; i++) {
            if (isPalindrome(s, prev + 1, i)) {
                split.addLast(i);
                backtrack(s, length, splits, split);
                split.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = new Item131_分割回文串_我完成的答案().partition("aab");
        System.out.println(res);
    }

}
