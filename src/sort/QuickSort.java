package sort;

import util.Array;

import java.util.Arrays;

/**
 * 快速排序, 不稳定, 最快的排序
 */
public class QuickSort {

  public static void sort(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
  }

  public static void quickSort(int[] nums, int low, int high) {
    if (low < high) {
      // 先分区,然后返回分区的索引
      int pi = partition(nums, low, high);
      // 左边快排
      quickSort(nums, low, pi - 1);
      // 右边快排
      quickSort(nums, pi + 1, high);
    }
  }

  /**
   * 选取最后一个数15作为基准
   * 21 17 5  7  16 6  15
   * <p>
   * 21和5换
   * 5  17 21 7  16 6  15
   * <p>
   * 17和7换
   * 5  7  21 17 16 6  15
   * <p>
   * 21和6换
   * 5  7  6  17 16 21 15
   * <p>
   * 基准15插入到中间
   * 5  7  6  15 16 21 17
   */
  private static int partition(int[] nums, int low, int high) {
    // 选出最后一个值作为基准
    int pivot = nums[high];
    // i作为左指数, i的一边是指小于pivot的数
    int i = low;
    // 遍历数组, 注意此处是j< high, 既不包括最后一个数
    for (int j = low; j < high; j++) {
      // 如果nums[j]小于等于基准, 属于不正常情况, 交换i与j的位置
      if (nums[j] <= pivot) {
        // 交换i和j的位置
        swap(nums, i, j);
        i++;
      }
    }
    swap(nums, i, high);
    return i;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }


  /**
   * 对象的快排, 来演示其不稳定性
   */
  public static <T extends Comparable<T>> void sort(T[] arr) {
    quickSort(arr, 0, arr.length - 1);
  }

  public static <T extends Comparable<T>> void quickSort(T[] arr, int low, int high) {
    if (low < high) {
      int pi = partition(arr, low, high);
      quickSort(arr, low, pi - 1);
      quickSort(arr, pi + 1, high);
    }
  }

  private static <T extends Comparable<T>> int partition(T[] arr, int low, int high) {
    T pivot = arr[high];
    int i = low;
    for (int j = low; j < high; j++) {
      if (arr[j].compareTo(pivot) <= 0) {
        swap(arr, i, j);
        i++;
      }
    }
    swap(arr, i, high);
    return i;
  }

  private static <T extends Comparable<T>> void swap(T[] nums, int i, int j) {
    T temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
