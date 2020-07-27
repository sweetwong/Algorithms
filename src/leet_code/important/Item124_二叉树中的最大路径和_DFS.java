package leet_code.important;

import data_structure.tree.TreeNode;

class Item124_二叉树中的最大路径和_DFS {

    private int mMaxPathSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return mMaxPathSum;
    }

    /**
     * 返回node节点的最大权益
     *
     * 就是goDown的意思
     */
    private int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(0, maxGain(node.left));
        int rightGain = Math.max(0, maxGain(node.right));

        int currPathSum = node.val + leftGain + rightGain;
        mMaxPathSum = Math.max(mMaxPathSum, currPathSum);

        return node.val + Math.max(leftGain, rightGain);
    }

}
