package leet_code;

import util.linked_list.ListNode;

class Item142_环形链表II {

    public ListNode detectCycle(ListNode head) {
        ListNode meet = hasCycle(head);
        if (meet == null) return null;

        while (head != meet) {
            head = head.next;
            meet = meet.next;
        }

        return head;
    }

    public ListNode hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return slow;
            }
        }
        return null;
    }

}
