package sort.nlogn;

/**
 * 快速排序, 时间复杂度O(nlogn), 最坏情况为O(n²), 空间复杂度O(logn), 不稳定, 最快的排序方法之一, 原地算法
 *
 * todo 请完成random pivot quick sort
 */
public class QuickSort {

  public static void sort(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
  }

  public static void quickSort(int[] nums, int low, int high) {
    if (low < high) {
      // 先分区,然后返回分区的索引
      int partition = partition(nums, low, high);
      // 左边快排
      quickSort(nums, low, partition - 1);
      // 右边快排
      quickSort(nums, partition + 1, high);
    }
  }

  private static int partition(int[] nums, int low, int high) {
    // 选出最后一个值作为基准
    int pivot = nums[high];
    // i是慢指针, i的一边是指小于pivot的数
    int i = low;
    // j是快指针, 从low遍历到high, 注意此处是j < high, 既不包括最后一个数
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
