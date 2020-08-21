package leet_code.important;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import data_structure.linked_list.LinkedListUtils;
import data_structure.linked_list.ListNode;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 *
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 *
 * 示例 1：
 * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
 * 输出：[1,1,2,3,4,4,5,6]
 * 解释：链表数组如下：
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * 将它们合并到一个有序链表中得到。
 * 1->1->2->3->4->4->5->6
 *
 * 示例 2：
 * 输入：lists = []
 * 输出：[]
 *
 * 示例 3：
 * 输入：lists = [[]]
 * 输出：[]
 *
 * 提示：
 * k == lists.length
 * 0 <= k <= 10^4
 * 0 <= lists[i].length <= 500
 * -10^4 <= lists[i][j] <= 10^4
 * lists[i] 按 升序 排列
 * lists[i].length 的总和不超过 10^4
 */
class Item23_合并K个排序链表_分治法 {

    /**
     * 关键: 将合并K个数组的问题 分解为 两组合并K/2个数组的问题
     */
    public ListNode mergeKLists(ListNode[] lists) {
        int len = lists.length;

        if (len == 0) return null;
        if (len == 1) return lists[0];

        int middle = len / 2;

        ListNode[] l1 = Arrays.copyOfRange(lists, 0, middle);
        ListNode[] l2 = Arrays.copyOfRange(lists, middle, len);

        return mergeTwoLists(mergeKLists(l1), mergeKLists(l2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    /**
     * 使用优先队列
     */
    public static ListNode mergeKListsPriorityQueue(ListNode[] lists) {
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
        ListNode l1 = LinkedListUtils.create(1, 4, 8, 10);
        ListNode l2 = LinkedListUtils.create(2, 9, 24);
        ListNode l3 = LinkedListUtils.create(3, 7);
        LinkedListUtils.print(mergeKListsPriorityQueue(new ListNode[]{l1, l2, l3}));
    }

}
