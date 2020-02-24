package sort.nlogn;


import util.Time;
import util.array.ArrayUtils;

/**
 * 堆排序, 时间复杂度O(nlogn), 空间复杂度O(1)(亮点), 不稳定, 原地算法
 *
 * 堆是一个近似完全二叉树的结构, 满足堆积的性质: 即子结点的键值或索引总是小于(或者大于)它的父节点
 *
 * 注意: 这里的堆排序空间复杂度并不是O(1), 因为是Java且用了递归, 这就有递归栈的空间复杂度
 * 可以把heapify转成迭代, 就没有递归的空间复杂度了
 *
 * heapify本身可以进行尾递归优化(Java不行), 如果是C语言即使写成递归, 空间复杂度也是O(1)
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
   * @param nums  输入的数组, 一直不变
   * @param n     当前堆的大小
   * @param start 起始节点
   */
  public static void heapify(int[] nums, int start, int n) {
    // n / 2是最后一排的第一个
    // 也相当于while(start <= n / 2 - 1)
    while (start < n / 2) {
      // 指向左子树
      int left = 2 * start + 1;
      // 比较左右子树, left指向大的
      if (left < n - 1 && nums[left] < nums[left + 1]) left++;
      // 拦截start为最大的情况
      if (nums[start] >= nums[left]) break;
      // 交换父子节点
      swap(nums, start, left);
      // 向下推进
      start = left;
    }

  }

  public static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }


  /**
   * 堆化
   *
   * 从start点开始, 一直到length为终点
   * 如果发现start不是最大的, 则交换, 并从子节点开始继续堆化
   *
   * 注意: 此处的max, start, left, right指的都是数组索引
   *
   * @param nums  输入的数组, 一直不变
   * @param n     当前堆的大小
   * @param start 起始节点
   */
  public static void heapifyIte(int[] nums, int start, int n) {
    // 当前(current)节点的位置
    int curr = start;
    // left左孩子，left + 1右孩子
    int left = 2 * start + 1;

    for (; left < n; curr = left, left = 2 * left + 1) {
      // 选择左右孩子较大者
      if (left < n - 1 && nums[left] < nums[left + 1])
        left++;
      // 当前节点是最大的
      if (nums[curr] >= nums[left]) {
        break;
      }
      // 当前结点比左右孩子的较大者小
      else {
        // 交换
        swap(nums, curr, left);
      }
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
   * @param nums  输入的数组, 一直不变
   * @param n     当前堆的大小
   * @param start 起始节点
   */
  public static void heapifyRecursive(int[] nums, int start, int n) {
    int max = start;

    int left = 2 * start + 1;
    int right = 2 * start + 2;

    if (left < n && nums[left] > nums[max]) max = left;
    if (right < n && nums[right] > nums[max]) max = right;

    if (max != start) {
      swap(nums, start, max);
      heapifyRecursive(nums, max, n);
    }
  }

  public static void main(String[] args) {
    Time.watch(() -> ArrayUtils.createRandomArray(10000000), HeapSort::sort, 5);
  }

}