package sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

  public static void sort(int[] nums) {
    // i代表不需要被比较的数的量
    // 刚开始i=0,代表所有的数都要比较一遍
    // 之后i=1,代表只需要比较n-1个数
    for (int i = 0; i < nums.length; i++) {
      // j代表指针的位置
      for (int j = 0; j < nums.length - i - 1; j++) {
        if (nums[j] > nums[j + 1]) {
          int temp = nums[j];
          nums[j] = nums[j + 1];
          nums[j + 1] = temp;
        }
      }
    }
  }

}
