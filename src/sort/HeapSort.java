package sort;


public class HeapSort {

  public static void sort(int[] nums) {
    int len = nums.length;
    // 建立大顶堆
    for (int i = len / 2 - 1; i >= 0; i--) {
      heapify(nums, len, i);
    }

    for (int i = len - 1; i >= 0; i--) {
      // 将当前根移动到尾部
      swap(nums, 0, i);
      heapify(nums, i, 0);
    }
  }

  public static void heapify(int[] nums, int n, int i) {
    int largest = i;
    // 左子根
    int l = 2 * i + 1;
    // 右子根
    int r = 2 * i + 2;

    if (l < n && nums[l] > nums[largest])
      largest = l;
    if (r < n && nums[r] > nums[largest])
      largest = r;

    if (largest != i) {
      swap(nums, i, largest);
      // 递归堆积受影响的子树
      heapify(nums, n, largest);
    }
  }

  public static void swap(int[] nums, int p, int q) {
    int t = nums[p];
    nums[p] = nums[q];
    nums[q] = t;
  }

}