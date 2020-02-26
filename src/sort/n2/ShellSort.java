package sort.n2;

/**
 * 希尔排序, 是一种插入排序的变种, 在插入排序的基础上进行了优化
 * 时间复杂度O(nlog²n), 最好O(nlog²n), 最坏也是O(nlog²n), 空间复杂度O(1), 不稳定, 原地算法
 *
 * 希尔排序是基于插入排序的以下两点性质而提出改进方法的:
 * 1. 插入排序在对几乎已经排好序的数据操作时，效率高，即可以达到线性排序的效率。
 * 2. 但插入排序一般来说是低效的，因为插入排序每次只能将数据移动一位。
 */
public class ShellSort {

  public static void sort(int[] nums) {
    int len = nums.length;
    for (int gap = len / 2; gap >= 1; gap /= 2) {
      // 注意: 这段代码和插入排序的核心代码几乎一样, 唯一不同的是插入排序的gap为1
      for (int i = gap; i < len; i++) {
        int curr = nums[i];
        int j = i - gap;
        while (j >= 0 && nums[j] > curr) {
          nums[j + gap] = nums[j];
          j -= gap;
        }
        nums[j + gap] = curr;
      }
    }
  }

}
