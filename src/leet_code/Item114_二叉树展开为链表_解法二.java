package leet_code;

import data_structure.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 给定一个二叉树，原地将它展开为一个单链表。
 *
 * 例如，给定二叉树
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 * 将其展开为：
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 */
public class Item114_二叉树展开为链表_解法二 {

    public static void flatten(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                curr = curr.right;
                continue;
            }

            TreeNode temp = curr.right;
            curr.right = curr.left;
            curr.left = null;

            TreeNode rightNode = curr;
            while (rightNode.right != null) {
                rightNode = rightNode.right;
            }
            rightNode.right = temp;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        flatten(root);
    }


}
