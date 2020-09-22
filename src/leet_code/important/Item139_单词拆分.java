package leet_code.important;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给定一个非空字符串 s 和一个包含非空单词的列表 wordDict，判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 *
 * 说明：
 * 拆分时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 *
 * 示例 1：
 * 输入: s = "leetcode", wordDict = ["leet", "code"]
 * 输出: true
 * 解释: 返回 true 因为 "leetcode" 可以被拆分成 "leet code"。
 *
 * 示例 2：
 * 输入: s = "applepenapple", wordDict = ["apple", "pen"]
 * 输出: true
 * 解释: 返回 true 因为 "applepenapple" 可以被拆分成 "apple pen apple"。
 *      注意你可以重复使用字典中的单词。
 *
 * 示例 3：
 * 输入: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出: false
 *
 * start: 14:05 end: 14:35
 */
public class Item139_单词拆分 {

    public static boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        return wordBreak(s, length, 0, new HashSet<>(wordDict), new boolean[length]);
    }

    private static boolean wordBreak(String s, int length, int start, Set<String> wordDictSet, boolean[] dp) {
        if (start == length) {
            return true;
        }
        if (dp[start]) {
            return false;
        }

        for (int i = start; i < length; i++) {
            if (wordDictSet.contains(s.substring(start, i + 1))) {
                if (wordBreak(s, length, i + 1, wordDictSet, dp)) {
                    return true;
                }
            }
        }
        dp[start] = true;

        return false;
    }

    public static void main(String[] args) {
        String s = "applepenapple";
        List<String> wordDict = Arrays.asList("app", "apple", "pen");
        System.out.println(wordBreak(s, wordDict));
    }

}
