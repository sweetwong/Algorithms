package leet_code.important;

import util.linked_list.LinkedListUtils;
import util.linked_list.ListNode;

/**
 * 反转链表
 */
class Item206_反转链表 {

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.create(1, 2, 3, 4, 5);
        LinkedListUtils.print(head);

        ListNode rev = reverseList1(head);
        LinkedListUtils.print(rev);
    }

    /**
     * 反转链表, 迭代法
     */
    public ListNode reverseList(ListNode head) {
        ListNode prev = null, curr = head;

        while (curr != null) {
            // 上面两步是反转的过程
            ListNode ahead = curr.next;
            curr.next = prev;

            // 下面两步是推进的过程
            prev = curr;
            curr = ahead;
        }

        // 因为最后会推进一步, prev变成最后一个, curr变成空的
        return prev;
    }

    /**
     * 反转链表, 递归法, 这个原理是和迭代法一样, 所以一般用迭代
     */
    public static ListNode reverseList1(ListNode head) {
        return helper(null, head);
    }

    public static ListNode helper(ListNode prev, ListNode curr) {
        if (curr == null) return prev;

        ListNode next = curr.next;
        curr.next = prev;
        return helper(curr, next);
    }

}
