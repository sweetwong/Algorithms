package leet_code.important;

import data_structure.tree.TreeNode;
import data_structure.tree.TreeUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 *
 * 返回如下的二叉树：
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 *  start:16.25 end:16.55
 *
 *  fixme
 */
public class Item106_从中序与后序遍历序列构造二叉树 {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int len = inorder.length;
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(inorder, postorder, inorderMap, 0, len - 1, 0, len - 1);
    }

    private TreeNode buildTree(int[] inorder, int[] postorder, Map<Integer, Integer> inorderMap,
                                      int postL, int postR, int inL, int inR) {
        if (postL > postR) {
            return null;
        }

        TreeNode root = new TreeNode(postorder[postR]);
        int inRoot = inorderMap.get(postorder[postR]);
        int leftCount = inRoot - inL;

        root.left = buildTree(inorder, postorder, inorderMap,
                postL, postL + leftCount - 1,
                inL, inRoot - 1
        );

        root.right = buildTree(inorder, postorder, inorderMap,
                postL + leftCount + 1, postR - 1,
                inRoot + 1, inR);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {9, 3, 15, 20, 7};
        int[] inorder = {9, 15, 7, 20, 3};
        TreeNode root = new Item106_从中序与后序遍历序列构造二叉树().buildTree(preorder, inorder);
        TreeUtils.print(root);
    }


}
