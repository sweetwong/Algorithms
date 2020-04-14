package leet_code;

import util.tree.TreeNode;

// todo 这特么也太巧妙了吧？
class Item236_二叉树的最近公共祖先 {

    private TreeNode res = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traversal(root, p, q);
        return res;
    }

    private boolean traversal(TreeNode node, TreeNode p, TreeNode q) {

        // 终止条件
        if (node == null || res != null) return false;

        // 左边有p或q
        int left = traversal(node.left, p, q) ? 1 : 0;

        // 右边有p或q
        int right = traversal(node.right, p, q) ? 1 : 0;

        // 中间有p或q
        int mid = (node == p || node == q) ? 1 : 0;

        // 就是满足其中两个条件就行
        // 这个方法特别巧妙, 当我们需要多个条件且只要满足其中几个就可以用这个方法
        if (mid + left + right >= 2) res = node;

        // 左边或右边或中间有一个p或q
        return (mid + left + right > 0);
    }

}
