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
public class Item131_分割回文串_更好的答案 {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtracking(s, 0, s.length(), new ArrayDeque<>(), res);
        return res;
    }

    private void backtracking(String s, int start, int len, Deque<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {
            if (isPalindrome(s, start, i)) {
                path.addLast(s.substring(start, i + 1));
                backtracking(s, i + 1, len, path, res);
                path.removeLast();
            }
        }
    }

    private boolean isPalindrome(String str, int l, int r) {
        while (l < r) {
            if (str.charAt(l++) != str.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<List<String>> res = new Item131_分割回文串_更好的答案().partition("aab");
        System.out.println(res);
    }

}
