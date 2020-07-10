package leet_code;

import util.tree.TreeNode;
import util.tree.TreeUtils;

/**
 */
class Item110_平衡二叉树_自顶向下 {

    public static boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int diff = getDepth(root.left) - getDepth(root.right);
        return (diff <= 1 && diff >= -1) && isBalanced(root.left) && isBalanced(root.right);
    }

    private static int getDepth(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getDepth(node.left), getDepth(node.right)) + 1;
    }

}
