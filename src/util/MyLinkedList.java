package util;

public class MyLinkedList {

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
   * @param node 输入的链表
   *             打印链表成如 1 -> 3 -> 5 的格式
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
  }


  /**
   * 链表的节点类
   */
  public static class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
      val = x;
    }
  }

}
