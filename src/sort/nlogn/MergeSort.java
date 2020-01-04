package sort.nlogn;


import util.linked_list.ListNode;

import java.util.Arrays;

/**
 * 归并排序, 时间复杂度O(nlogn), 空间复杂度O(n), 稳定, 对象排序一般用MergeSort或者基于归并排序的TimSort, 不是原地算法
 */
public class MergeSort {


  public static void main(String[] args) {
    int[] arr = {0, 1, 2, -1};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  /**
   * 归并排序
   */
  public static void sort(int[] nums) {
    // 递归终止条件
    if (nums.length <= 1) return;

    // 获取中位数,并将数组切割为两部分, 这种写法如果是偶数middle将会是中间偏左的数
    int mid = nums.length / 2;

    // 把数组分成左右两个区间
    int[] left = Arrays.copyOfRange(nums, 0, mid);
    int[] right = Arrays.copyOfRange(nums, mid, nums.length);

    // 归并左边的数组使其变成一个有序数组(将大问题变成小问题)
    sort(left);
    // 归并右边的数组使其变成一个有序数组(将大问题变成小问题)
    sort(right);

    // 合并两个有序数组
    mergeTwoSortedArrays(nums, left, right);
  }

  /**
   * 归并两个有序数组
   */
  public static void mergeTwoSortedArrays(int[] nums, int[] left, int[] right) {
    for (int i = 0, l = 0, r = 0; i < nums.length; i++) {
      // 检查左边的数组是否越界
      if (l >= left.length)
        nums[i] = right[r++];
        // 检查右边的数组是否越界
      else if (r >= right.length)
        nums[i] = left[l++];
        // 这句话必须这样写, 左边<=右边, 这样才能保持稳定性
      else if (left[l] <= right[r])
        nums[i] = left[l++];
        // 最后一种情况, 既左边>右边
      else
        nums[i] = right[r++];
    }
  }

  /**
   * 对象的归并排序
   */
  public static <T extends Comparable<T>> void sort(T[] nums) {
    if (nums.length <= 1) return;
    int mid = nums.length / 2;
    T[] left = Arrays.copyOfRange(nums, 0, mid);
    T[] right = Arrays.copyOfRange(nums, mid, nums.length);
    sort(left);
    sort(right);
    mergeTwoSortedArrays(nums, left, right);
  }

  /**
   * 对象的归并排序
   */
  public static <T extends Comparable<T>> void mergeTwoSortedArrays(T[] nums, T[] left, T[] right) {
    for (int i = 0, l = 0, r = 0; i < nums.length; i++) {
      if (l >= left.length)
        nums[i] = right[r++];
      else if (r >= right.length)
        nums[i] = left[l++];
        // 这句话必须这样写, 左边<=右边, 这样才能保持稳定性
      else if (left[l].compareTo(right[r]) <= 0)
        nums[i] = left[l++];
      else
        nums[i] = right[r++];
    }
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

    // 终止条件
    if (n == 0) return null;
    if (n == 1) return lists[0];
    if (n == 2) return mergeTwoSortedLists(lists[0], lists[1]);

    int mid = n / 2;

    ListNode[] left = Arrays.copyOfRange(lists, 0, mid);
    ListNode[] right = Arrays.copyOfRange(lists, mid, n);

    return mergeTwoSortedLists(mergeKSortedLists(left), mergeKSortedLists(right));
  }


}
