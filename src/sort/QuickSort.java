package sort;

/**
 * 快速排序,不稳定,几乎最快的排序
 */
public class QuickSort {

  public static void sort(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
  }

  public static void quickSort(int[] nums, int low, int high) {
    if (low < high) {
      // 先分区,然后返回基准
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
   *
   * 21和5换
   * 5  17 21 7  16 6  15
   *
   * 17和7换
   * 5  7  21 17 16 6  15
   *
   * 21和6换
   * 5  7  6  17 16 21 15
   *
   * 基准15插入到中间
   * 5  7  6  15 16 21 17
   */
  private static int partition(int[] nums, int low, int high) {
    //选出最后一个值作为基准
    int pivot = nums[high];
    //left作为左指数, left的一边是指小于pivot的数
    int left = low - 1;
    // 遍历数组, 注意此处是i < high, 既不包括最后一个数
    for (int i = low; i < high; i++) {
      //如果nums[i]小于等于基准, 属于不正常情况, 交换i与j的位置
      if (nums[i] <= pivot) {
        left++;
        //交换i和j的位置
        swap(nums, left, i);
      }
    }
    swap(nums, left + 1, high);
    return left + 1;
  }

  private static void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
