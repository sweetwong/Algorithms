package leet_code;

import util.tree.TreeNode;

class Item230_二叉搜索树中第K小的元素 {

    private int i;
    private int k;
    private int res;

    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return res;
    }

    public void inorder(TreeNode root) {
        if (root != null) {
            inorder(root.left);
            if (++i == k) res = root.val;
            inorder(root.right);
        }
    }

}
