package leet_code.important;

import data_structure.other.Time;
import sort.nlogn.QuickSort;
import data_structure.array.ArrayUtils;
import data_structure.linked_list.LinkedListUtils;
import data_structure.linked_list.ListNode;

import java.util.Arrays;

/**
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 *
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 */
class Item148_排序链表 {

    public static void main(String[] args) {
        int[] nums = ArrayUtils.createRandomArray(10000000, 100, false);
        ListNode head = LinkedListUtils.create(nums);

        Time.watch(() -> sortList(head));
    }

    /**
     * 思路:
     * 1. 利用快慢指针找到链表中点, 把链表分成两个两边
     * 2. 分别对两个链表进行递归(大问题变小问题, 会一直分, 直到分成链表个数为1)为了得到两个有序链表
     * 3. 归并两个有序链表
     */
    public static ListNode sortList(ListNode head) {
        // 终止条件, 快指针到达最后一个节点 或者 快指针到达最后一个再超出一个位置
        if (head == null || head.next == null) return head;

        // 利用快慢指针, 慢指针既是中点, 奇数个(中间), 偶数个(中间偏左)
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 这个值必然有, 因为链表至少有两个, 此时rightHead就是第二个节点
        ListNode rightHead = slow.next;
        slow.next = null;

        return mergeTwoSortedLists(sortList(head), sortList(rightHead));
    }

    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
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
