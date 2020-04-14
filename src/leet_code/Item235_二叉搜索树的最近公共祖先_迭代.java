package leet_code;

import util.tree.TreeNode;

// todo
class Item235_二叉搜索树的最近公共祖先_迭代 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode l, TreeNode r) {
        while (root != null) {
            if (l.val > root.val && r.val > root.val) root = root.right;
            else if (l.val < root.val && r.val < root.val) root = root.left;
            else return root;

        }
        return null;
    }


}
