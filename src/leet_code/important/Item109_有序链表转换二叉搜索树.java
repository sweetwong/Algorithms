package leet_code.important;

import data_structure.linked_list.ListNode;
import data_structure.tree.TreeNode;

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
public class Item109_有序链表转换二叉搜索树 {

    public static TreeNode sortedListToBST(ListNode head) {
        // 注意，high 取值是 length 对应的值而不是 length - 1 对应的值
        return buildTree(head, null);
    }

    private static TreeNode buildTree(ListNode low, ListNode high) {
        if (low == high) return null;

        ListNode middle = getMiddle(low, high);

        TreeNode root = new TreeNode(middle.val);
        root.left = buildTree(low, middle);
        root.right = buildTree(middle.next, high);

        return root;
    }

    private static ListNode getMiddle(ListNode low, ListNode high) {
        ListNode slow = low, fast = low;
        while (fast != high && fast.next != high) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }


}
