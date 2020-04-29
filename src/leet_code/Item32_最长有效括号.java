package leet_code;

import java.util.ArrayDeque;
import java.util.Deque;

class Item32_最长有效括号 {

    public int longestValidParentheses(String s) {
        int longest = 0;
        Deque<Character> stack = new ArrayDeque<>();
        int len = s.length();
        char[] chars = s.toCharArray();
        int i = 0;
        int curr = 0;
        while (i < len || !stack.isEmpty()) {
            if (i == len) {
                break;
            }
            // 当前为'('
            if (chars[i] == '(') {
                stack.push(chars[i]);
            }
            // 当前为')'且栈不为空
            else if (!stack.isEmpty()) {
                stack.pop();
                curr += 2;
                longest = Math.max(longest, curr);
            }
            // 当前为')'且栈为空
            else {
                curr = 0;
            }
            i++;
        }
        return longest;
    }

}
