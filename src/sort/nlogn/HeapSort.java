package sort.nlogn;


import util.array.ArrayUtils;
import util.TimeWatcher;

/**
 * 堆排序, 时间复杂度O(nlogn), 空间复杂度O(1)(亮点), 不稳定, 原地算法
 *
 * 堆是一个近似完全二叉树的结构, 满足堆积的性质: 即子结点的键值或索引总是小于(或者大于)它的父节点
 */
public class HeapSort {

  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      int[] nums = ArrayUtils.createRandomArray(10000000);
      TimeWatcher.watch(() -> sort(nums));
      TimeWatcher.watch(() -> sort(nums));
      System.out.println();
    }
  }

  public static void sort(int[] nums) {
    int len = nums.length;

    // 构建大顶堆
    // 从最后一个非叶子结点开始, 构建一个大顶堆, 根据堆的性质: 即子结点的键值或索引总是小于(或者大于)它的父节点
    for (int i = len / 2 - 1; i >= 0; i--) {
      heapify(nums, i, len);
    }

    // 排序, 永远从根节点开始排
    for (int i = len - 1; i >= 0; i--) {
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
   * @param len 当前堆的大小
   * @param start 起始节点
   */
  public static void heapify(int[] nums, int start, int len) {
    int max = start;

    int left = 2 * start + 1;
    int right = 2 * start + 2;

    // 比较父节点和左子节点
    if (left < len && nums[left] > nums[max]) {
      max = left;
    }
    // 比较父节点和右子节点
    if (right < len && nums[right] > nums[max]) {
      max = right;
    }

    // 如果最大的, 不是父节点, 则交换父节点与最大的节点, 并在子节点的位置开始, 继续下沉, 确保堆的性质(所有的父节点都比其子节点大)
    if (max != start) {
      swap(nums, start, max);
      // 从交换的max节点开始, 递归堆积受影响的子树
      heapify(nums, max, len);
    }
  }

  public static void swap(int[] nums, int p, int q) {
    int temp = nums[p];
    nums[p] = nums[q];
    nums[q] = temp;
  }

}