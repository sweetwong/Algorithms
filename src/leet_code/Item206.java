package leet_code;

import util.linked_list.LinkedListUtils;
import util.linked_list.ListNode;

/**
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 *
 * Follow up:
 * A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
class Item206 {

  public static void main(String[] args) {
    ListNode head = LinkedListUtils.createListNode(1, 3, 5, 7, 9);
    head = reverseList(head);
    LinkedListUtils.printListNode(head);
  }

  /**
   * 反转链表, 递归法, 这个是正向递归
   */
  public static ListNode reverseList(ListNode head) {
    return helper(null, head);
  }

  public static ListNode helper(ListNode prev, ListNode curr) {
    if (curr == null) return prev;

    ListNode next = curr.next;
    curr.next = prev;
    return helper(curr, next);
  }

  /**
   * 反转链表, 迭代法
   */
  public ListNode reverseListIte(ListNode head) {
    ListNode prev = null, curr = head;
    while (curr != null) {
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

}
