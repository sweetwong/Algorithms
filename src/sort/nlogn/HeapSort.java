package sort.nlogn;


import util.array.ArrayUtils;
import util.TimeWatcher;

/**
 * 堆排序, 时间复杂度O(nlogn), 空间复杂度O(1)(亮点), 不稳定, 原地算法
 *
 * 堆是一个近似完全二叉树的结构, 满足堆积的性质: 即子结点的键值或索引总是小于(或者大于)它的父节点
 */
public class HeapSort {

  public static void sort(int[] nums) {
    int n = nums.length;

    // 构建大顶堆(注意大顶堆的性质)
    // 从最后一个非叶子结点开始, 构建一个大顶堆, 根据堆的性质: 即子结点的键值或索引总是小于(或者大于)它的父节点
    for (int i = n / 2 - 1; i >= 0; i--) {
      heapify(nums, i, n);
    }

    // 排序, 永远从根节点开始排
    for (int i = n - 1; i >= 0; i--) {
      // 将当前根移动到尾部
      swap(nums, 0, i);
      heapify(nums, 0, i);
    }

  }

  /**
   * 堆化
   *
   * 从start点开始, 一直到length为终点
   * 如果发现start不是最大的, 则交换, 并从子节点开始继续堆化
   *
   * 注意: 此处的max, start, left, right指的都是数组索引
   *
   * @param nums 输入的数组, 一直不变
   * @param n 当前堆的大小
   * @param start 起始节点
   */
  public static void heapify(int[] nums, int start, int n) {
    int max = start;

    int left = 2 * start + 1;
    int right = 2 * start + 2;

    if (left < n && nums[left] > nums[max]) max = left;
    if (right < n && nums[right] > nums[max]) max = right;

    if (max != start) {
      swap(nums, start, max);
      heapify(nums, max, n);
    }
  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      int[] nums = ArrayUtils.createRandomArray(10000000);
      TimeWatcher.watch(() -> sort(nums));
      TimeWatcher.watch(() -> sort(nums));
      System.out.println();
    }
  }

}