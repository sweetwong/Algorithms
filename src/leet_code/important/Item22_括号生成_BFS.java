package leet_code.important;

import util.other.Time;

import java.util.*;

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
