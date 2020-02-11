package leet_code;

import util.tree.TreeNode;

class Item235_二叉搜索树的最近公共祖先_递归 {

  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode l, TreeNode r) {
    if (l.val > root.val && r.val > root.val) return lowestCommonAncestor(root.right, l, r);
    else if (l.val < root.val && r.val < root.val) return lowestCommonAncestor(root.left, l, r);
    else return root;
  }


}
