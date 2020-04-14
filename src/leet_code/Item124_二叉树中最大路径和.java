package leet_code;

import util.tree.TreeNode;

class Item124_二叉树中最大路径和 {

    int maxSum = Integer.MIN_VALUE;

    public int maxGain(TreeNode node) {
        if (node == null) return 0;

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int parentGain = node.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, parentGain);

        // todo ???
        return node.val + Math.max(leftGain, rightGain);
    }

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

}
