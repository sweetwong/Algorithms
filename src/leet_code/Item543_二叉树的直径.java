package leet_code;

import java.util.HashMap;
import java.util.Map;

import util.tree.TreeNode;

class Item543_二叉树的直径 {

  int ans = 0;

  public int diameterOfBinaryTree(TreeNode root) {
    depth(root);
    return ans;
  }

  private int depth(TreeNode node) {
    if (node == null) return 0;

    int left = depth(node.left);
    int right = depth(node.right);

    // 只用在深度遍历的基础上加上这个就行了
    ans = Math.max(ans, left + right);

    return Math.max(left, right) + 1;
  }

}
