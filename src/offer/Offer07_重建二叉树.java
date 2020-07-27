package offer;

import data_structure.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * todo 完成这道题，目前我还不理解
 */
public class Offer07_重建二叉树 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        int len = inorder.length;
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            indexMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, 0, len - 1, inorder, 0, len - 1, indexMap);
        return root;
    }

    private static TreeNode buildTree(int[] preorder, int preorderStart, int preorderEnd,
                                      int[] inorder, int inorderStart, int inorderEnd,
                                      Map<Integer, Integer> indexMap) {
        if (preorderStart > preorderEnd) {
            return null;
        }
        int rootVal = preorder[preorderStart];
        TreeNode root = new TreeNode(rootVal);
        if (preorderStart != preorderEnd) {
            int rootIndex = indexMap.get(rootVal);
            int leftNodes = rootIndex - inorderStart, rightNodes = inorderEnd - rootIndex;
            TreeNode leftSubtree = buildTree(preorder, preorderStart + 1, preorderStart + leftNodes,
                    inorder, inorderStart, rootIndex - 1, indexMap);
            TreeNode rightSubtree = buildTree(preorder, preorderEnd - rightNodes + 1, preorderEnd,
                    inorder, rootIndex + 1, inorderEnd, indexMap);
            root.left = leftSubtree;
            root.right = rightSubtree;
        }
        return root;
    }


}
