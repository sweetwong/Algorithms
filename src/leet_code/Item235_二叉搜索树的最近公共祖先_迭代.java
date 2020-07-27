package leet_code;

import data_structure.tree.TreeNode;

/**
 * @see Item236_二叉树的最近公共祖先
 *
 * TODO 学习
 */
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
