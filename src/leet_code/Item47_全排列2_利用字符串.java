package leet_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import classical.Factorial;
import util.TimeWatcher;
import util.array.ArrayUtils;

class Item47_全排列2_利用字符串 {

  public List<List<Integer>> permuteUnique(int[] nums) {
    int n = nums.length;

    Set<String> set = new TreeSet<>();

    backtracking(n, nums, set, 0);

    List<List<Integer>> res = new ArrayList<>();

    for (String str : set) {
      List<Integer> list = new ArrayList<>();
      String[] numStrings = str.split(",");
      for (int i = 0; i < numStrings.length; i++) {
        list.add(Integer.valueOf(numStrings[i]));
      }
      res.add(list);
    }

    // 返回结果
    return res;
  }

  private void backtracking(int n, int[] nums, Set<String> set, int start) {
    if (start == n) {
      StringBuilder sb = new StringBuilder();
      sb.append(nums[0]);
      for (int i = 1; i < n; i++) {
        sb.append(',');
        sb.append(nums[i]);
      }
      String str = sb.toString();
      if (!set.contains(str)) {
        set.add(str);
      }
      return;
    }

    for (int i = start; i < n; i++) {
      swap(nums, start, i);
      backtracking(n, nums, set, start + 1);
      swap(nums, start, i);
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
