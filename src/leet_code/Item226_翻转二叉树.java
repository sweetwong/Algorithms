package leet_code;

import data_structure.tree.TreeNode;

class Item226_翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;

            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }

}
