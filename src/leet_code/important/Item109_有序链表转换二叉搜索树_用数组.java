package leet_code.important;

import data_structure.linked_list.ListNode;
import data_structure.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
 *
 * 本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。
 *
 * 示例:
 *
 * 给定的有序链表： [-10, -3, 0, 5, 9],
 *
 * 一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：
 *
 *       0
 *      / \
 *    -3   9
 *    /   /
 *  -10  5
 */
public class Item109_有序链表转换二叉搜索树_用数组 {

    public static TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            list.add(curr.val);
        }
        TreeNode root = buildTree(list, 0, list.size() - 1);
        return root;
    }

    private static TreeNode buildTree(List<Integer> list, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int mid = lo + hi >>> 1;
        TreeNode root = new TreeNode(list.get(mid));
        root.left = buildTree(list, lo, mid - 1);
        root.right = buildTree(list, mid + 1, hi);
        return root;
    }

}
