package leet_code;

import data_structure.tree.TreeNode;

/**
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 *
 * 例如，给出
 *
 * 前序遍历 preorder = [3,9,20,15,7]
 * 中序遍历 inorder = [9,3,15,20,7]
 * 返回如下的二叉树：
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * TODO 已经知道思路了, 完成这道题
 */
//public class Item105_从前序与中序遍历序列构造二叉树 {
//
//    private Map<TreeNode, Integer> mMap = new HashMap<>();
//
//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//        for (int i = 0; i < inorder.length; i++) {
//            mMap.put(inorder[i], i);
//        }
//        return create()
//    }
//
//    private TreeNode create(int[] preorder, int[] inorder, int preL, int preR) {
//        TreeNode root = new TreeNode(preorder[preL]);
//        int pivot = mMap.get(preorder[preL]);
//
//    }
//
//}
