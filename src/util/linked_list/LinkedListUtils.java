package util.linked_list;

import sort.nlogn.QuickSort;
import util.array.ArrayUtils;

public class LinkedListUtils {

  public static void main(String[] args) {
    int[] nums = ArrayUtils.createRandomArray(10, 100, false);
    QuickSort.sort(nums);

    ListNode head = create(nums);
    print(head);

    ListNode rev = reverse(head);
    print(rev);
  }

  /**
   * @param nums 输入任意数字
   * @return 生成对应链表
   */
  public static ListNode create(int... nums) {
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
  public static void print(ListNode node) {
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
  public static ListNode reverse(ListNode root) {
    ListNode prev = null, curr = root;
    while (curr != null) {
      // 反转
      ListNode nextTemp = curr.next;
      curr.next = prev;

      // 向前推进
      prev = curr;
      curr = nextTemp;
    }
    return prev;
  }

}
