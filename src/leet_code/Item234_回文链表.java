package leet_code;

import data_structure.linked_list.ListNode;

/**
 * 请判断一个链表是否为回文链表。
 *
 * 示例 1:
 * 输入: 1->2
 * 输出: false
 *
 * 示例 2:
 * 输入: 1->2->2->1
 * 输出: true
 *
 * 示例 3:
 * 输入: 1->2->3->-2->1
 * 输出: true
 *
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class Item234_回文链表 {

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode left = head;
        ListNode right = slow.next;
        if (fast == null) { // 说明是奇数个
            prev.next = null;
        } else { // 说明是偶数个
            slow.next = null;
        }

        left = reverse(left);

        ListNode currLeft = left;
        ListNode currRight = right;
        while (currLeft != null && currRight != null) {
            if (currLeft.val != currRight.val) {
                return false;
            }
            currLeft = currLeft.next;
            currRight = currRight.next;
        }

        if (currLeft != null || currRight != null) {
            return false;
        }

        return true;
    }

    private ListNode reverse(ListNode head) {
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

}
