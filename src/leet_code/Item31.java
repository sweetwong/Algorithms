package leet_code;

import java.util.Arrays;

/**
 * todo 找到下一个比当前数字刚好大的数
 */
class Item31 {

  public static void main(String[] args) {
    int[] nums = {2, 3, 1};
    nextPermutation(nums);
    System.out.println(Arrays.toString(nums));
  }

  public static void nextPermutation(int[] nums) {
    int len = nums.length;
    if (len <= 1) return;

    for (int i = len - 2; i >= 0; i--) {
      int minIndex = i + 1;
      for (int j = i + 1; j < len; j++) {
      }
      System.out.println(i + "  " + minIndex);
      if (nums[i] < nums[minIndex]) {
        swap(nums, i, minIndex);
        reverse(nums, i + 1, len - 1);
        return;
      }
    }
    reverse(nums, 0, len - 1);
  }

  public static void reverse(int[] nums, int l, int r) {
    while (l < r) {
      swap(nums, l, r);
      l++;
      r--;
    }
  }

  public static void swap(int[] nums, int p, int q) {
    int temp = nums[p];
    nums[p] = nums[q];
    nums[q] = temp;
  }

}
