package leet_code;

import data_structure.tree.TreeNode;
import data_structure.tree.TreeUtils;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个二叉树
 *
 * struct Node {
 *   int val;
 *   Node *left;
 *   Node *right;
 *   Node *next;
 * }
 * 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
 *
 * 初始状态下，所有 next 指针都被设置为 NULL。
 *
 * 进阶：
 *
 * 你只能使用常量级额外空间。
 * 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。
 *
 * 示例：
 *
 * 输入：root = [1,2,3,4,5,null,7]
 * 输出：[1,#,2,3,#,4,5,7,#]
 * 解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。
 *
 * 提示：
 *
 * 树中的节点数小于 6000
 * -100 <= node.val <= 100
 */
public class Item117_填充每个节点的下一个右侧节点指针II {

    public Node connect(Node root) {
        if (root == null) return root;

        Queue<Node> queue = new ArrayDeque();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelLen = queue.size();

            Node prev = queue.poll();
            if (prev.left != null) queue.offer(prev.left);
            if (prev.right != null) queue.offer(prev.right);

            for (int i = 1; i < levelLen; i++) {
                Node curr = queue.poll();
                prev.next = curr;
                prev = curr;

                if (curr.left != null) queue.offer(curr.left);
                if (curr.right != null) queue.offer(curr.right);
            }
        }

        return root;
    }

    private static class Node {
        Node left;
        Node right;
        Node next;
        int val;

        Node(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtils.arrayToCompleteBinaryTree(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15);
        TreeUtils.print(root);
    }

}
