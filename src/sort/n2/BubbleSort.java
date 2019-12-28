package sort.n2;


/**
 * 冒泡排序, 时间复杂度O(n²), 空间复杂度O(1), 稳定
 */
public class BubbleSort {

  public static void sort(int[] nums) {
    // i代表不需要被比较的数的量
    // 刚开始i=0,代表所有的数都要比较一遍
    // 之后i=1,代表只需要比较n-1个数
    for (int i = 0; i < nums.length - 1; i++) {
      // j代表指针的位置
      for (int j = 0; j < nums.length - i - 1; j++) {
        // 此处必须是大于, 不然就不能保证稳定性
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
    }
  }

  public static <T extends Comparable<T>> void sort(T[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 0; j < arr.length - i - 1; j++) {
        if (arr[j].compareTo(arr[j + 1]) > 0) {
          T temp = arr[j];
          arr[j] = arr[j + 1];
          arr[j + 1] = temp;
        }
      }
    }

  }

}
