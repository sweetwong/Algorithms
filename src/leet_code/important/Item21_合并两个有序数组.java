package leet_code.important;

import data_structure.linked_list.ListNode;

/**
 * @see sort.nlogn.MergeSort
 */
class Item21_合并两个有序数组 {

    /**
     * 这种方法:
     * 1. 通过迭代, 空间复杂度为常量级
     * 2. 没有生成新对象, 不需要用dummyHead
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        ListNode head;
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val <= l2.val) {
            head = l1;
            l1 = l1.next;
        } else {
            head = l2;
            l2 = l2.next;
        }

        ListNode curr = head;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }

        curr.next = l1 == null ? l2 : l1;

        return head;
    }

}
