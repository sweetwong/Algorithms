package leet_code;

import util.linked_list.ListNode;

class Item19 {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;

    // 快指针, 比慢指针快n格
    ListNode fast = dummy;
    for (int i = 0; i < n + 1; i++) {
      fast = fast.next;
    }

    // 慢指针, 开始在dummy
    ListNode slow = dummy;

    // 快慢指针一起移动, 直到快指针为空
    while (fast != null) {
      slow = slow.next;
      fast = fast.next;
    }

    // 删除慢指针前面一个节点
    slow.next = slow.next.next;

    return dummy.next;
  }
}
