package sort;

import util.MyLinkedList.ListNode;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {

  /**
   * 归并排序
   */
  public static void sort(int[] nums) {
    // 递归终止条件
    if (nums.length <= 1) return;

    // 获取中位数,并将数组切割为两部分
    int middle = nums.length / 2;

    // todo 此处可以优化,不用复制两个数组,而改用指针的形式
    int[] left = Arrays.copyOfRange(nums, 0, middle);
    int[] right = Arrays.copyOfRange(nums, middle, nums.length);

    // 归并左边的数组使其变成一个有序数组(将大问题变成小问题)
    // 归并右边的数组使其变成一个有序数组(将大问题变成小问题)
    // 合并两个有序数组
    sort(left);
    sort(right);

    mergeTwoSortedArrays(nums, left, right);
  }

  /**
   * 归并两个有序数组
   */
  public static void mergeTwoSortedArrays(int[] nums, int[] left, int[] right) {
    int[] temp = new int[left.length + right.length];
    for (int i = 0, l = 0, r = 0; i < temp.length; i++) {
      if (l >= left.length) {
        temp[i] = right[r++];
      } else if (r >= right.length) {
        temp[i] = left[l++];
      } else if (left[l] <= right[r]) { // 这句话必须这样写,左边<=右边,这样才能保持稳定性
        temp[i] = left[l++];
      } else {
        temp[i] = right[r++];
      }
    }
    System.arraycopy(temp, 0, nums, 0, nums.length);
  }

  /**
   * 归并两个有序链表
   */
  public static ListNode mergeTwoSortedLists(ListNode left, ListNode right) {
    if (left == null) return right;
    if (right == null) return left;
    if (left.val <= right.val) {
      left.next = mergeTwoSortedLists(left.next, right);
      return left;
    } else {
      right.next = mergeTwoSortedLists(left, right.next);
      return right;
    }
  }

  /**
   * 归并k个有序链表
   */
  public ListNode mergeKSortedLists(ListNode[] lists) {
    int n = lists.length;

    if (n == 0) return null;
    if (n == 1) return lists[0];
    if (n == 2) return mergeTwoSortedLists(lists[0], lists[1]);

    int middle = n / 2;

    ListNode[] left = Arrays.copyOfRange(lists, 0, middle);
    ListNode[] right = Arrays.copyOfRange(lists, middle, n);

    return mergeTwoSortedLists(mergeKSortedLists(left), mergeKSortedLists(right));
  }


}
