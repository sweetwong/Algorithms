package leet_code.important;

import util.linked_list.LinkedListUtils;
import util.linked_list.ListNode;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * 这一题是终极缝合怪, 用到了快慢指针, 反转, 归并多个操作
 */
public class Item143_重排链表 {

    public static void reorderList(ListNode head) {
        if (head == null) return;

        ListNode middle = findMiddle(head);
        ListNode rightHead = middle.next;
        middle.next = null;

        rightHead = reverse(rightHead);

        merge(head, rightHead);
    }

    private static ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head;
        // while (fast != null && fast.next != null) 这种情况是找到中间偏右的节点
        // while (fast.next != null && fast.next.next != null) 这种情况是找到中间偏左的节点
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;

            prev = curr;
            curr = next;
        }
        return prev;
    }

    private static ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (l1 != null && l2 != null) {
            curr.next = l1;
            l1 = l1.next;
            curr = curr.next;

            curr.next = l2;
            l2 = l2.next;
            curr = curr.next;
        }
        curr.next = l1 == null ? l2 : l1;
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.create(1, 2, 3, 4, 5);
        reorderList(head);
        LinkedListUtils.print(head);
    }


}
