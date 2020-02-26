package leet_code;

import java.util.Arrays;

class Item27_移除元素 {

  public static void main(String[] args) {
    int[] nums = {1};

    System.out.println(removeElement(nums, 1));
    System.out.println(Arrays.toString(nums));
  }

  public static int removeElement(int[] nums, int val) {
    int n = nums.length;

    int i = 0, j = n - 1;

    while (j >= 0 && i <= j) {

      while (j >= 0 && nums[j] == val) {
        if (nums[j] == 0) nums[j] = 1;
        else nums[j] = 0;
        j--;
      }

      if (nums[i] == val) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        if (nums[j] == val) {
          if (nums[j] == 0) nums[j] = 1;
          else nums[j] = 0;
        }
        j--;
      }

      i++;
    }

    return j + 1;
  }

}
