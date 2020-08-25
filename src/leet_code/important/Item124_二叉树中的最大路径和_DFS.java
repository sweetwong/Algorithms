package leet_code.important;

import data_structure.tree.TreeNode;

/**
 * 给定一个非空二叉树，返回其最大路径和。
 *
 * 本题中，路径被定义为一条从树中任意节点出发，达到任意节点的序列。该路径至少包含一个节点，且不一定经过根节点。
 *
 * 示例 1:
 * 输入: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * 输出: 6
 *
 * 示例 2:
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 */
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
