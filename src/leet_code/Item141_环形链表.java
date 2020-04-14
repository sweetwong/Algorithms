package leet_code;

import util.linked_list.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a linked list, determine if it has a cycle in it.
 *
 * To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in
 * the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.
 *
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 *
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * Explanation: There is a cycle in the linked list, where tail connects to the first node.
 *
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * Explanation: There is no cycle in the linked list.
 *
 * Follow up:
 * Can you solve it using O(1) (i.e. constant) memory?
 */
class Item141_环形链表 {

    /**
     * 方法一: 使用HashSet
     */
    public static boolean hasCycleSet(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head))
                return true;

            set.add(head);
            head = head.next;
        }
        return false;
    }


    /**
     * 方法二: 使用快慢指针
     */
    public static boolean hasCycleTwoPoint(ListNode head) {
        if (head == null || head.next == null) return false;

        ListNode slow = head, fast = head.next;
        while (slow != fast) {
            // 快指针到头, 说明不是循环链表
            if (fast == null || fast.next == null) return false;

            // 慢指针走一步
            slow = slow.next;
            // 快指针走两步
            fast = fast.next.next;
        }
        return true;
    }
}
