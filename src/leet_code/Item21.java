package leet_code;

import util.LinkedList;
import util.LinkedList.ListNode;

class Item21 {

  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    if (l1 == null) return l2;
    if (l2 == null) return l1;
    if (l1.val > l2.val) {
      l2.next = mergeTwoLists(l1, l2.next);
      return l2;
    } else {
      l1.next = mergeTwoLists(l1.next, l2);
      return l1;
    }
  }

  public static ListNode mergeTwoListsIte(ListNode l1, ListNode l2) {
    ListNode dummyHead = new ListNode(0);
    ListNode curr = dummyHead;
    while (l1 != null && l2 != null) {
      if (l1.val <= l2.val) {
        curr.next = l1;
        l1 = l1.next;
      } else {
        curr.next = l2;
        l2 = l2.next;
      }
      curr = curr.next;
    }

    curr.next = l1 == null ? l2 : l1;

    return dummyHead.next;
  }

  public static void main(String[] args) {
    ListNode l1 = LinkedList.createListNode(1, 4, 5, 7);
    ListNode l2 = LinkedList.createListNode(2, 8, 9);
    LinkedList.printListNode(mergeTwoListsIte(l1, l2));
  }

}
