package leet_code;

import data_structure.linked_list.LinkedListUtils;
import data_structure.linked_list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个单链表 L：L0→L1→…→Ln-1→Ln ，
 * 将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 示例 1:
 * 给定链表 1->2->3->4, 重新排列为 1->4->2->3.
 *
 * 示例 2:
 * 给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 *
 * @see leet_code.important.Item143_重排链表
 */
public class Item143_重排链表_利用list {

    /**
     * 这种利用了额外的数据结构, 这是最差解法
     */
    public static void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        for (ListNode curr = head; curr != null; curr = curr.next) {
            list.add(curr);
        }

        int lo = 0, hi = list.size() - 1;
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (lo < hi) {
            curr.next = list.get(lo);
            curr = curr.next;
            curr.next = list.get(hi);
            curr = curr.next;
            lo++;
            hi--;
        }
        if (lo == hi) {
            curr.next = list.get(lo);
            curr = curr.next;
        }

        curr.next = null;
    }

    public static void main(String[] args) {
        ListNode head = LinkedListUtils.create(1, 2, 3, 4, 5);
        reorderList(head);
        LinkedListUtils.print(head);
    }

}
