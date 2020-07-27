package data_structure.tree;

/**
 * @see leet_code.Item820_单词的压缩解码_字典树
 */
public class Trie {

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public int insert(String word) {
        TrieNode curr = root;
        boolean isNew = false;
        // 注意: 此处是从尾部开始
        for (int i = word.length() - 1; i >= 0; i--) {
            int c = word.charAt(i) - 'a';
            if (curr.children[c] == null) {
                isNew = true;
                curr.children[c] = new TrieNode();
            }
            curr = curr.children[c];
        }
        // 如果是新单词的话编码长度增加新单词的长度+1，否则不变。
        return isNew ? word.length() + 1 : 0;
    }

    public static class TrieNode {
        TrieNode[] children = new TrieNode[26];
    }

}
