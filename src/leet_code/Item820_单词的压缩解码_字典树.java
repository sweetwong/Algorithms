package leet_code;

import data_structure.tree.Trie;

import java.util.Arrays;

/**
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 * 示例：
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *
 * 提示：
 * 1. 1 <= words.length <= 2000
 * 2. 1 <= words[i].length <= 7
 * 3. 每个单词都是小写字母 。
 */
public class Item820_单词的压缩解码_字典树 {

    public static int minimumLengthEncoding(String[] words) {
        int len = 0;
        Trie trie = new Trie();
        // 单词长度从大到小排序, 对于同长度的, 保持其原始顺序
        Arrays.sort(words, (s1, s2) -> s2.length() - s1.length());
        for (String word: words) {
            // 注意, 字典树是按照word从最后一个字符往第一个字符添加的
            len += trie.insert(word);
        }
        return len;
    }

    public static void main(String[] args) {
        String[] words = {"time", "time", "me", "dell", "el", "de"};
        System.out.println(minimumLengthEncoding(words));
    }

}


