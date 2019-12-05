package leet_code;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import util.LinkedList;
import util.LinkedList.ListNode;

class Item23 {

  /**
   * 关键: 将合并K个数组的问题 分解为 两组合并K/2个数组的问题
   */
  public ListNode mergeKLists(ListNode[] lists) {
    int n = lists.length;

    if (n == 0) return null;
    if (n == 1) return lists[0];
    if (n == 2) return mergeTwoLists(lists[0], lists[1]);

    int middle = n / 2;

    ListNode[] l1 = Arrays.copyOfRange(lists, 0, middle);
    ListNode[] l2 = Arrays.copyOfRange(lists, middle, n);

    return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
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

  /**
   * 使用优先队列
   */
  public static ListNode mergeKLists2(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    if (lists.length == 1) return lists[0];

    PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
      @Override
      public int compare(ListNode o1, ListNode o2) {
        return o1.val - o2.val;
      }
    });

    for (ListNode list : lists) {
      if (list != null)
        pq.offer(list);
    }

    ListNode dummyHead = new ListNode(0);
    ListNode curr = dummyHead;
    while (!pq.isEmpty()) {
      ListNode node = pq.poll();
      curr.next = node;
      curr = curr.next;

      if (node.next != null)
        pq.offer(node.next);
    }

    return dummyHead.next;
  }

  public static void main(String[] args) {
    ListNode l1 = LinkedList.createListNode(1, 4, 8, 10);
    ListNode l2 = LinkedList.createListNode(2, 9, 24);
    ListNode l3 = LinkedList.createListNode(3, 7);
    LinkedList.printListNode(mergeKLists2(new ListNode[]{l1, l2, l3}));
  }

}
