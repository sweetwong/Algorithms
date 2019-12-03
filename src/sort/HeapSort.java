package sort;


import util.Array;


public class HeapSort {

  public static void sort(int[] nums) {
    // 从最后一个非叶子结点开始, 构建一个最大堆
    for (int i = nums.length / 2 - 1; i >= 0; i--) {
      heapify(nums, nums.length, i);
    }
    // 排序, 永远从根节点开始排
    for (int i = nums.length - 1; i >= 0; i--) {
      // 将当前根移动到尾部
      swap(nums, 0, i);
      heapify(nums, i, 0);
    }
  }

  /**
   * @param nums   输入的数组, 一直不变
   * @param length 当前堆的大小
   * @param i      起始节点
   */
  public static void heapify(int[] nums, int length, int i) {
    int max = i;
    // 左子根
    int l = 2 * i + 1;
    // 右子根
    int r = 2 * i + 2;
    if (l < length && nums[l] > nums[max])
      max = l;
    if (r < length && nums[r] > nums[max])
      max = r;
    if (max != i) {
      swap(nums, i, max);
      // 从交换的max节点开始, 递归堆积受影响的子树
      heapify(nums, length, max);
    }
  }

  public static void swap(int[] nums, int p, int q) {
    int temp = nums[p];
    nums[p] = nums[q];
    nums[q] = temp;
  }

}