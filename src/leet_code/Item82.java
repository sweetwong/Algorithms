package leet_code;

import util.linked_list.LinkedListUtils;
import util.linked_list.ListNode;

class Item82 {

  public static void main(String[] args) {
    ListNode head = LinkedListUtils.create(1, 2, 2);
    head = deleteDuplicatesIte(head);
    LinkedListUtils.print(head);
  }

  public static ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    // 如果当前数字重复
    if (head.val == head.next.val) {
      while (head.next != null && head.val == head.next.val) {
        head = head.next;
      }
      return deleteDuplicates(head.next);
    }
    // 如果当前数字不重复
    else {
      // 大问题化小问题(问题规模-1)
      head.next = deleteDuplicates(head.next);
      return head;
    }
  }

  public static ListNode deleteDuplicatesIte(ListNode head) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    ListNode prev = dummy;
    ListNode curr = head;

    while (curr != null) {
      // 如果当前数字重复
      if (curr.next != null && curr.val == curr.next.val) {

        // 删除当前数字
        int deleteVal = curr.val;
        while (curr != null && curr.val == deleteVal) {
          curr = curr.next;
        }

        // 如果链表尾部是重复的, 直接在prev接上
        if (curr == null) {
          prev.next = curr;
        }
      }
      // 如果当前数字没有重复
      else {
        // prev接上, prev进位到新得安全的位置
        prev.next = curr;
        prev = prev.next;

        // curr继续推进
        curr = curr.next;
      }
    }

    return dummy.next;
  }

}
