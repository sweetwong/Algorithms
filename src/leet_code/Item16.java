package leet_code;

import java.util.Arrays;

class Item16 {

  public static void main(String[] args) {
    int res = threeSumClosest(new int[]{1, 1, 1, 0}, -100);
    System.out.println(res);
  }

  public static int threeSumClosest(int[] nums, int target) {
    int res = 0;
    int minDistance = Integer.MAX_VALUE;

    Arrays.sort(nums);

    for (int i = 0; i < nums.length - 2; i++) {
      int l = i + 1, r = nums.length - 1;

      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        int differ = sum - target;

        if (differ < 0) l++;
        else if (differ > 0) r--;
        else return sum;

        if (differ < 0) differ = -differ;
        if (differ < minDistance) {
          minDistance = differ;
          res = sum;
        }
      }
    }
    return res;
  }

}
