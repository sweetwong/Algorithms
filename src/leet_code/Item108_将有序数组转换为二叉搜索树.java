package leet_code;

import data_structure.tree.TreeNode;

/**
 * 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 * 给定有序数组: [-10,-3,0,5,9],
 *
 * 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Item108_将有序数组转换为二叉搜索树 {

    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;

        return createTree(nums, 0, nums.length - 1);
    }

    public TreeNode createTree(int[] nums, int lo, int hi) {
        if (lo > hi) return null;

        int mid = lo + ((hi - lo) >>> 1);
        TreeNode node = new TreeNode(nums[mid]);
        node.left = createTree(nums, lo, mid - 1);
        node.right = createTree(nums, mid + 1, hi);

        return node;
    }

}
