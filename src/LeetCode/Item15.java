package LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Item15 {

  public static void main(String[] args) {
    int[] nums = {0, -1, 1};
    print(threeSum(nums));
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    if (nums.length <= 2) return res;

    HashMap<Integer, Integer> map = new HashMap<>();

    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], i);
    }

    for (int i = 0; i < nums.length - 1; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        int target = -(nums[i] + nums[j]);
        if (map.containsKey(target)) {
          int value = map.get(target);

          if (target >= nums[i] && target >= nums[j] && value != i && value != j) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[i]);
            list.add(nums[j]);
            list.add(nums[value]);
            res.add(list);
          }
        }
      }
    }
    return res;
  }

  public static void print(List<List<Integer>> lists) {
    for (List<Integer> list : lists) {
      System.out.println("[" + list.get(0) + ", " + list.get(1) + ", " + list.get(2) + "]");
    }
  }

}
