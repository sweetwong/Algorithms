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
   *
   * 利用三个变量, prev、curr、next
   * prev指向前一个数, curr指向当前的数, nextTemp指向后一个数(每次都会新生成, 用来暂存)
   *
   * 反转过程: 把next保存下来, curr接上prev
   * 向前推进: prev变成curr, curr变成next
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
