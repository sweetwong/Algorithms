package leet_code;

import util.linked_list.LinkedListUtils;
import util.linked_list.ListNode;

class Item25_K个一组翻转链表 {

    public static ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy;
        ListNode prevGroup, nextGroup, currHead, currTail;

        while (curr != null) {
            prevGroup = curr;
            currHead = curr.next;

            boolean needReverse = true;
            for (int i = 0; i < k; i++) {
                curr = curr.next;
                if (curr == null) {
                    needReverse = false;
                    break;
                }
            }

            if (needReverse) {
                nextGroup = curr.next;
                curr.next = null;

                currTail = currHead;
                currHead = reverse(currHead);

                prevGroup.next = currHead;
                currTail.next = nextGroup;

                curr = currTail;
            }
        }

        return dummy.next;
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

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.create(1, 2, 3, 4, 5, 6);
        ListNode node = reverseKGroup(head, 3);
        LinkedListUtils.print(node);
    }


}
