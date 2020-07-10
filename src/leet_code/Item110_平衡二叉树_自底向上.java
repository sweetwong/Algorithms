package leet_code;

import util.tree.TreeNode;

/**
 */
class Item110_平衡二叉树_自底向上 {

    public static boolean isBalanced(TreeNode root) {
        return traversal(root) != -1;
    }

    private static int traversal(TreeNode node) {
        if(node==null) return 0;
        int left = traversal(node.left);
        int right = traversal(node.right);
        if (left == -1) return -1;
        if (right== -1) return -1;
        return Math.abs(left - right) <= 1 ? Math.max(left, right) + 1 : -1;
    }

}
