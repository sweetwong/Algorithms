package leet_code;

import util.linked_list.LinkedListUtils;
import util.linked_list.ListNode;

/**
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example 1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL
 *
 *
 * Example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
 *
 */
class Item61 {

  public static void main(String[] args) {
    ListNode head = LinkedListUtils.createListNode(1, 2, 3, 4, 5);
    head = rotateRight(head, 5);
    LinkedListUtils.printListNode(head);
  }

  public static ListNode rotateRight(ListNode head, int k) {
    int size = 0;
    ListNode curr = head;
    while (curr != null) {
      size++;
      curr = curr.next;
    }

    if (size == 0) return null;

    curr = head;

    // 向前走多少步
    int goAhead = size - k % size - 1;

    // 一直向前走, 直到走到断裂点, 记住断裂点前一个位置和后一个位置
    for (int i = 0; i < goAhead; i++) {
      curr = curr.next;
    }

    // 断掉前一个位置, 后一个位置作为新头部
    ListNode newHead = curr.next;
    curr.next = null;
    curr = newHead;

    if (curr == null) return head;

    while (curr.next != null) {
      curr = curr.next;
    }
    curr.next = head;

    return newHead;
  }
}
