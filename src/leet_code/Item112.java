package leet_code;

import util.tree.TreeNode;

/**
 * Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up
 * all the values along the path equals the given sum.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given the below binary tree and sum = 22,
 *
 *       5
 *      / \
 *     4   8
 *    /   / \
 *   11  13  4
 *  /  \      \
 * 7    2      1
 * return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.
 */
class Item112 {

  /**
   * 树 -> 首先想到用递归的方法
   * 递归 -> 把大树的问题变成其子树的问题
   */
  public static boolean hasPathSum(TreeNode root, int sum) {
    if (root == null) return false;
    if (root != null && root.left == null && root.right == null) {
      return sum - root.val == 0;
    }
    return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
  }

}
