import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.MyArray;
import util.TimeUtils;

public class Solution {

  public static void main(String[] args) {
    int[] nums = MyArray.createRandomArrays(3000);
    TimeUtils.watch(() -> System.out.println(threeSum(nums).size()));
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> col = new ArrayList<>();
    int n = nums.length;
    if (n <= 2) new ArrayList<>();
    Arrays.sort(nums);
    for (int a = 0; a < n - 2; a++) {
      if (nums[a] > 0) break;
      for (int b = a + 1; b < n - 1; b++) {
        for (int c = b + 1; c < n; c++) {
          if (nums[a] + nums[b] + nums[c] == 0 && !checkRepeat(col, nums[a], nums[b], nums[c])) {
            List<Integer> row = new ArrayList<>();
            row.add(nums[a]);
            row.add(nums[b]);
            row.add(nums[c]);
            col.add(row);
          }
        }
      }
    }
    return col;
  }

  public static boolean checkRepeat(List<List<Integer>> col, int first, int second, int third) {
    for (List<Integer> row : col) {
      if (row.get(0) == first && row.get(1) == second && row.get(2) == third) return true;
    }
    return false;
  }

}