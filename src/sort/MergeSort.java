package sort;

import util.MyArray;
import util.MyLinkedList.ListNode;
import util.TimeUtils;

import java.util.Arrays;

/**
 * 归并排序
 */
class MergeSort {

  public static void main(String[] args) {
    int[] nums = MyArray.createRandomArrays(100000);

    TimeUtils.watch(() -> InsertionSort.sort(nums));
  }

  /**
   * 归并排序
   */
  public static int[] sort(int[] nums) {
    // 递归终止条件
    if (nums.length <= 1) return nums;

    // 获取中位数,并将数组切割为两部分
    int middle = nums.length / 2;
    int[] left = Arrays.copyOfRange(nums, 0, middle);
    int[] right = Arrays.copyOfRange(nums, middle, nums.length);

    // 归并左边的数组使其变成一个有序数组(将大问题变成小问题)
    // 归并右边的数组使其变成一个有序数组(将大问题变成小问题)
    // 合并两个有序数组
    return mergeTwoSortedArrays(sort(left), sort(right));
  }

  /**
   * 归并两个有序数组
   */
  public static int[] mergeTwoSortedArrays(int[] left, int[] right) {

    int[] res = new int[left.length + right.length];

    for (int i = 0, l = 0, r = 0; i < res.length; i++) {
      if (l >= left.length) {
        res[i] = right[r++];
      } else if (r >= right.length) {
        res[i] = left[l++];
      } else if (left[l] <= right[r]) { // 这句话必须这样写,左边<=右边,这样才能保持稳定性
        res[i] = left[l++];
      } else {
        res[i] = right[r++];
      }
    }
    return res;
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
