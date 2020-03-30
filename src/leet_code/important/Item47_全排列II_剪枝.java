package leet_code.important;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Item47_全排列II_剪枝 {

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    backtracking(nums.length, nums, res, 0);
    return res;
  }

  private void backtracking(int n, int[] nums, List<List<Integer>> res, int row) {
    if (row == n) {
      List<Integer> list = new ArrayList<>();
      for (int num : nums) list.add(num);
      res.add(list);
      return;
    }

    // 利用set来剪枝(也可以通过遍历来实现)
    Set<Integer> set = new HashSet<>();

    for (int col = row; col < n; col++) {
      if (!set.contains(nums[col])) {
        set.add(nums[col]);
        swap(nums, row, col);
        backtracking(n, nums, res, row + 1);
        swap(nums, row, col);
      }
    }
  }

  private void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

}
