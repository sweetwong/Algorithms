package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Item15_三数之和 {

  public static void main(String[] args) {
    int[] nums = {-4, -2, 1, -5, -4, -4, 4, -2, 0, 4, 0, -2, 3, 1, -5, 0};
    List<List<Integer>> res = threeSum(nums);
    System.out.println(res);
  }


  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    int n = nums.length;

    if (n < 3) return res;

    Arrays.sort(nums);
    if (nums[0] > 0) return res;

    for (int i = 0; i < n; i++) {
      if (i > 0 && nums[i] == nums[i - 1]) continue;
      int l = i + 1;
      int r = n - 1;
      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum < 0) l++;
        else if (sum > 0) r--;
        else {
          res.add(Arrays.asList(nums[i], nums[l], nums[r]));
          while (l + 1 < r && nums[l] == nums[l + 1]) l++;
          while (r - 1 > l && nums[r] == nums[r - 1]) r--;
          l++;
          r--;
        }
      }
    }

    return res;
  }

}
