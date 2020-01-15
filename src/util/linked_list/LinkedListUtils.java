package util.linked_list;

import sort.nlogn.QuickSort;
import util.array.ArrayUtils;

public class LinkedListUtils {

  public static void main(String[] args) {
    int[] nums = ArrayUtils.createRandomArray(10, 100, false);
    QuickSort.sort(nums);

    ArrayUtils.printArray(nums);

    ListNode head = createListNode(nums);
    printListNode(head);
  }

  /**
   * @param nums 输入任意数字
   * @return 生成对应链表
   */
  public static ListNode createListNode(int... nums) {
    ListNode dummyHead = new ListNode(0);
    ListNode curr = dummyHead;
    for (int num : nums) {
      curr.next = new ListNode(num);
      curr = curr.next;
    }
    return dummyHead.next;
  }

  /**
   * 打印链表成如 1 -> 3 -> 5 的格式
   *
   * @param node 输入的链表
   */
  public static void printListNode(ListNode node) {
    if (node == null) {
      System.out.print("null");
    } else {
      System.out.print(node.val);
      node = node.next;
      while (node != null) {
        System.out.print(" -> " + node.val);
        node = node.next;
      }
    }
    System.out.println();
  }

  /**
   * 反转链表, 迭代法
   */
  public static ListNode reverseLinkedList(ListNode root) {
    ListNode prev = null, curr = root;
    // 一开始设为空而不是root.next, 可以包括root为空的情况
    while (curr != null) {
      // 在此处求ahead, 因为已经确定了curr不为空
      ListNode nextTemp = curr.next;
      curr.next = prev;
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

}
