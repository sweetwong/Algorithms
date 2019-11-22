package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Item15 {

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    int len = nums.length;
    if (len < 3) return ans;
    Arrays.sort(nums); // 排序
    for (int i = 0; i < len; i++) {
      if (nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
      if (i > 0 && nums[i] == nums[i - 1]) continue; // 去重

      int l = i + 1;
      int r = len - 1;
      while (l < r) {
        int sum = nums[i] + nums[l] + nums[r];

        // 如果相等
        if (sum == 0) {
          ans.add(Arrays.asList(nums[i], nums[l], nums[r]));
          while (l < r && nums[l] == nums[l + 1]) l++; // 去重
          while (l < r && nums[r] == nums[r - 1]) r--; // 去重
          l++;
          r--;
        } else if (sum < 0) {
          l++;
        } else {
          r--;
        }

      }
    }
    return ans;
  }

}

