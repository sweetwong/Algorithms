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
 * 示例 2:
 * 输入: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * 输出: 42
 */
class Item124_二叉树中的最大路径和_DFS {

    public static int maxPathSum(TreeNode root) {
        int[] maxPathSum = new int[1];
        maxPathSum[0] = Integer.MIN_VALUE;
        maxGain(root, maxPathSum);
        return maxPathSum[0];
    }

    /**
     * @return 返回从当前的node到下面节点，和的最大值
     */
    private static int maxGain(TreeNode node, int[] maxPathSum) {
        if (node == null) {
            return 0;
        }

        int leftGain = Math.max(0, maxGain(node.left, maxPathSum));
        int rightGain = Math.max(0, maxGain(node.right, maxPathSum));

        // 先遍历，再处理，属于后序遍历
        int currPathSum = node.val + leftGain + rightGain;
        maxPathSum[0] = Math.max(maxPathSum[0], currPathSum);

        return node.val + Math.max(leftGain, rightGain);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        maxPathSum(root);
    }

}
