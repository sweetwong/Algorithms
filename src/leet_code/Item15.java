package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item15 {

  public static List<List<Integer>> threeSum(int[] nums) {
    int len = nums.length;
    List<List<Integer>> res = new ArrayList<>();

    if (len <= 2) return res;

    Arrays.sort(nums);

    for (int i = 0; i < len - 2; i++) {
      if (nums[i] > 0) return res;

      if (i != 0 && nums[i] == nums[i - 1]) continue;

      int l = i + 1, r = len - 1;

      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];
        if (sum == 0) {
          res.add(Arrays.asList(nums[i], nums[l], nums[r]));
          while (l < r && nums[l] == nums[l + 1]) l++;
          while (l < r && nums[r] == nums[r - 1]) r--;
          l++;
          r--;
        } else if (sum < 0) {
          l++;
        } else {
          r--;
        }
      }
    }
    return res;

  }


}

