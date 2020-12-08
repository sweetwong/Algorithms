package leet_code.important;

import data_structure.tree.TreeNode;
import data_structure.tree.Trees;

import java.util.HashMap;
import java.util.Map;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Item105_从前序与中序遍历序列构造二叉树 {

    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        int len = preorder.length;
        // 这是一个数组和哈希表组合的技巧，数组的值作为key（值无重复这个信息很重要），索引作为value
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < len; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode root = buildTree(preorder, inorderMap, 0, len - 1, 0, len - 1);
        return root;
    }

    private static TreeNode buildTree(int[] preorder, Map<Integer, Integer> inorderMap,
                                      int preL, int preR, int inL, int inR) {
        if (preL > preR) {
            return null;
        }

        int preRoot = preorder[preL];
        int inRoot = inorderMap.get(preRoot);

        TreeNode root = new TreeNode(preRoot);

        int leftCount = inRoot - inL;

        root.left = buildTree(preorder, inorderMap,
                preL + 1, preL + leftCount,
                inL, inRoot - 1);

        root.right = buildTree(preorder, inorderMap,
                preL + leftCount + 1, preR,
                inRoot + 1, inR);

        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = buildTree(preorder, inorder);
        Trees.print(root);
    }

}
