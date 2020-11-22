package leet_code;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 *
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 *
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 *
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 *
 * 示例：
 * 输入: words = ["time", "me", "bell"]
 * 输出: 10
 * 说明: S = "time#bell#" ， indexes = [0, 2, 5] 。
 *
 * 提示：
 * 1. 1 <= words.length <= 2000
 * 2. 1 <= words[i].length <= 7
 * 3. 每个单词都是小写字母。
 */
public class Item820_单词的压缩解码_字典树_哈希表 {

    // 定义字典树节点
    private static class TrieNode {
        TrieNode[] children;
        int count;

        public TrieNode() {
            // 字典树的优势（因为字母的数量是固定的，因此可以用字母作为数组下标）
            // 相当于Map<Character,TrieNode>
            children = new TrieNode[26];
            count = 0;
        }
    }

    public static int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();

        Map<TrieNode, Integer> map = new HashMap<>();

        // 生成字典树
        for (int i = 0; i < words.length; ++i) {
            TrieNode curr = root;
            for (int j = words[i].length() - 1; j >= 0; j--) {
                char c = words[i].charAt(j);
                if (curr.children[c - 'a'] == null) {
                    curr.children[c - 'a'] = new TrieNode();
                    curr.count++;
                }
                curr = curr.children[c - 'a'];
            }
            // curr已经走到最下面（虽然有可能不是叶子节点，因为后续还可能插入）
            // +1是因为'#'
            map.put(curr, words[i].length() + 1);
        }

        // 计算叶子节点对应的字符串长度之和
        int ans = 0;
        for (Map.Entry<TrieNode, Integer> entry : map.entrySet()) {
            if (entry.getKey().count == 0) {
                ans += entry.getValue();
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] words = {"time", "me", "abe", "el", "bell"};
        System.out.println(minimumLengthEncoding(words));
    }

}




