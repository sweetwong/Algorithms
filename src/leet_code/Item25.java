package leet_code;

import util.linked_list.LinkedListUtils;
import util.linked_list.ListNode;

class Item25 {

  public static void main(String[] args) {
    ListNode head = LinkedListUtils.create(1, 2, 3, 4, 5);
    head = reverseKGroup(head, 3);
    LinkedListUtils.print(head);
  }

  public static ListNode reverseKGroup(ListNode head, int k) {
    if (head == null || head.next == null) return head;

    ListNode start = head, end = head;

    boolean needReverse = true;
    for (int i = 0; i < k - 1; i++) {
      if (end.next != null)
        end = end.next;
      else {
        needReverse = false;
        break;
      }
    }

    if (needReverse) {
      ListNode nextGroup = end.next;
      end.next = null;

      // 反转部分链表
      ListNode prev = null, curr = head;
      while (curr != null) {
        ListNode ahead = curr.next;
        curr.next = prev;

        prev = curr;
        curr = ahead;
      }
      // 把指针重新指向反转后的头和尾
      start = prev;
      end = head;

      end.next = reverseKGroup(nextGroup, k);
    }

    return start;
  }


}
