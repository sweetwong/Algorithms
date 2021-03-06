package leet_code;

import data_structure.linked_list.LinkedLists;
import data_structure.linked_list.ListNode;

/**
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
 */
class Item203_移除链表元素 {

    public static void main(String[] args) {
        ListNode head = LinkedLists.create(1, 2, 2, 1);
        removeElements1(head, 2);
        LinkedLists.print(head);
    }

    /**
     * 利用dummyHead, 问题会简单很多
     */
    public static ListNode removeElements1(ListNode head, int val) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode curr = dummyHead;
        while (curr != null) {
            while (curr.next != null && curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return dummyHead.next;
    }


    /**
     * 不利用dummyHead, 问题会复杂很多
     */
    public static ListNode removeElements2(ListNode head, int val) {
        if (head == null) return null;

        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode curr = head;
        while (curr != null) {
            while (curr.next != null && curr.next.val == val) {
                curr.next = curr.next.next;
            }
            curr = curr.next;
        }
        return head;
    }

}
