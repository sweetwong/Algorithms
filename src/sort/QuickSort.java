package sort;

/**
 * 快速排序,不稳定,几乎最快的排序
 */
public class QuickSort {

  public static void sort(int[] nums) {
    quickSort(nums, 0, nums.length - 1);
  }

  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      // 先分区,然后返回基准
      int pi = partition(arr, low, high);
      // 左边快排
      quickSort(arr, low, pi - 1);
      // 右边快排
      quickSort(arr, pi + 1, high);
    }
  }

  private static int partition(int[] arr, int low, int high) {
    //选出最后一个值作为基准
    int pivot = arr[high];
    //i作为左指数, i的一边是指小于pivot的数, j作为右指数, j的一边是大于pivot的数
    int i = low - 1;
    for (int j = low; j < high; j++) {
      //如果arr[j]小于等于基准, 属于不正常情况, 交换i与j的位置
      if (arr[j] <= pivot) {
        i++;
        //交换i和j的位置
        swap(arr, i, j);
      }
    }
    swap(arr, i + 1, high);
    return i + 1;
  }

  private static void swap(int[] arr, int i, int j) {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }

}
