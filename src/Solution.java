import util.tree.TreeNode;

class Solution {

    private TreeNode mCommonAncestor = null;
    private boolean mStopTraversal = false;

    private static final int CONTAINS_NONE = 0;
    private static final int CONTAINS_P = 1;
    private static final int CONTAINS_Q = 2;
    private static final int CONTAINS_P_AND_Q = 3;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traversal(root, p, q);
        return mCommonAncestor;
    }

    private int traversal(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null || mStopTraversal) {
            return CONTAINS_NONE;
        }

        int mid;
        if (node == p) {
            mid = CONTAINS_P;
        } else if (node == q) {
            mid = CONTAINS_Q;
        } else {
            mid = CONTAINS_NONE;
        }

        int res = mid + traversal(node.left, p, q) + traversal(node.right, p, q);

        if (res == CONTAINS_P_AND_Q) {
            mCommonAncestor = node;
            mStopTraversal = true;
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        System.out.println(new Solution().lowestCommonAncestor(root, root.left, root.left.right.right).val);
    }

}