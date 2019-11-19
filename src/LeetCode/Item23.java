package LeetCode;

import java.util.Arrays;

import util.MyLinkedList;
import util.MyLinkedList.ListNode;

class Item23 {

  public static void main(String[] args) {
    ListNode l1 = MyLinkedList.createListNode(1, 4, 8, 10);
    ListNode l2 = MyLinkedList.createListNode(2, 9, 24);
    ListNode l3 = MyLinkedList.createListNode(3, 7);
    MyLinkedList.printListNode(new Item23().mergeKLists(new ListNode[]{l1, l2, l3}));
  }


  public ListNode mergeKLists(ListNode[] lists) {
    int n = lists.length;
    if (n == 0) return null;
    if (n == 1) return lists[0];
    if (n == 2) return mergeTwoLists(lists[0], lists[1]);

    int middle = n / 2;

    ListNode[] left = Arrays.copyOfRange(lists, 0, middle);
    ListNode[] right = Arrays.copyOfRange(lists, middle, n);

    return mergeTwoLists(mergeKLists(left), mergeKLists(right));
  }

  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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

}