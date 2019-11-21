package sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {

  public static void main(String[] args) {
    int[] arr = new int[]{2, 1, 8, 3, -1, 24, 12};
    sort(arr);
    System.out.println(Arrays.toString(arr));
  }

  public static void sort(int[] nums) {
    for (int i = 0; i < nums.length - 1; i++) {
      // 选出最小的index
      int minIndex = i;
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[j] < nums[minIndex]) {
          minIndex = j;
        }
      }
      // 交换i和最小的index
      int temp = nums[i];
      nums[i] = nums[minIndex];
      nums[minIndex] = temp;
    }
  }
}
