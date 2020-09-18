package leet_code.important;

import data_structure.other.Time;

import java.util.*;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 *
 * 示例：
 * 输入：n = 3
 * 输出：[
 *        "((()))",
 *        "(()())",
 *        "(())()",
 *        "()(())",
 *        "()()()"
 *      ]
 */
class Item22_括号生成_BFS {

    static class Node {
        int open;
        int close;
        String s;

        Node(String s, int open, int close) {
            this.s = s;
            this.open = open;
            this.close = close;
        }
    }

    public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node("", n, n));
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int open = node.open;
            int close = node.close;
            String s = node.s;

            if (open == 0 && close == 0) {
                res.add(s);
                continue;
            }

            if (open > 0) {
                queue.offer(new Node(s + "(", open - 1, close));
            }
            if (open < close) {
                queue.offer(new Node(s + ")", open, close - 1));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int n = 14;
            System.out.print("DFS: ");
            Time.watch(() -> Item22_括号生成_DFS.generateParenthesis(n));
            System.out.print("BFS: ");
            Time.watch(() -> Item22_括号生成_BFS.generateParenthesis(n));
            System.out.println();
        }
    }

}
