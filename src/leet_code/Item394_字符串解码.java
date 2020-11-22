package leet_code;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例 1：
 * 输入：s = "3[a]2[bc]"
 * 输出："aaabcbc"
 *
 * 示例 2：
 * 输入：s = "3[a2[c]]"
 * 输出："accaccacc"
 *
 * 示例 3：
 * 输入：s = "2[abc]3[cd]ef"
 * 输出："abcabccdcdcdef"
 *
 * 示例 4：
 * 输入：s = "abc3[cd]xyz"
 * 输出："abccdcdcdxyz"
 */
public class Item394_字符串解码 {

    public static String decodeString(String s) {
        if (s == null) return s;

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 当检测到']'时表示终点
            if (c != ']') {
                deque.addLast(c);
                continue;
            }

            // 取出字符串
            char prev = deque.removeLast();
            Deque<Character> lettersDeque = new ArrayDeque<>();
            while (prev != '[') {
                lettersDeque.addFirst(prev);
                prev = deque.removeLast();
            }

            // 取出数字
            Deque<Character> countDeque = new ArrayDeque<>();
            while (!deque.isEmpty()) {
                char peek = deque.peekLast();
                if (!Character.isDigit(peek)) {
                    break;
                }
                countDeque.addFirst(deque.removeLast());
            }
            int count = 0;
            for (char digit : countDeque) {
                count = count * 10 + (int) (digit - '0');
            }

            // 根据字符串和数字，重新计算出新的字符串，并添加到原来的队列中
            for (int j = 0; j < count; j++) {
                for (char c2 : lettersDeque) {
                    deque.addLast(c2);
                }
            }
        }

        StringBuilder builder = new StringBuilder();
        for (char c : deque) {
            builder.append(c);
        }

        return builder.toString();
    }

}
