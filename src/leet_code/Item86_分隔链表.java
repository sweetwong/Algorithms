package leet_code;

import data_structure.linked_list.LinkedLists;
import data_structure.linked_list.ListNode;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 *
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Item86_分隔链表 {

    public static ListNode partition(ListNode head, int x) {
        ListNode dummyLo = new ListNode(0);
        ListNode dummyHi = new ListNode(0);

        ListNode currLo = dummyLo;
        ListNode currHi = dummyHi;

        for (ListNode curr = head; curr != null; curr = curr.next) {
            if (curr.val < x) {
                currLo.next = curr;
                currLo = currLo.next;
            } else {
                currHi.next = curr;
                currHi = currHi.next;
            }
        }

        // 这一步很关键！！
        currHi.next = null;
        currLo.next = dummyHi.next;

        return dummyLo.next;
    }

    public static void main(String[] args) {
        ListNode head = LinkedLists.create(1, 4, 3, 2, 5, 2);
        ListNode partition = partition(head, 3);
    }

}
