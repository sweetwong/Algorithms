package leet_code;

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
public class Item820_单词的压缩解码_字典树 {

    // 定义字典树节点
    private static class TrieNode {
        TrieNode[] childrens = new TrieNode[26];
        int count = 0;
    }

    public static int minimumLengthEncoding(String[] words) {
        TrieNode root = new TrieNode();

        // 生成字典树
        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode curr = root;
            for (int j = word.length() - 1; j >= 0; j--) {
                curr = insert(curr, word.charAt(j));
            }
        }

        // 遍历字典树
        int[] ans = new int[1];
        traversal(root, 0, ans);
        return ans[0];
    }

    // 将字符c插入到字典树节点node中
    private static TrieNode insert(TrieNode node, char c) {
        if (node.childrens[c - 'a'] == null) {
            node.childrens[c - 'a'] = new TrieNode();
            node.count++;
        }
        return node.childrens[c - 'a'];
    }

    private static void traversal(TrieNode root, int depth, int[] ans) {
        if (root == null) {
            return;
        }
        // 说明是叶子节点
        if (root.count == 0) {
            // 因为每次要多加一个'#'号
            ans[0] += depth + 1;
            System.out.println("depth: " + depth);
            return;
        }

        for (TrieNode child : root.childrens) {
            traversal(child, depth + 1, ans);
        }
    }

    public static void main(String[] args) {
        String[] words = {"time", "me", "abe", "el", "bell"};
        System.out.println(minimumLengthEncoding(words));
    }

}




