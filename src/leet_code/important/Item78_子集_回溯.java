package leet_code.important;

import java.util.ArrayList;
import java.util.List;

class Item78_子集_回溯 {

  public static void main(String[] args) {
    Item78_子集_回溯 a = new Item78_子集_回溯();
    System.out.println(a.subsets(new int[]{1, 2, 3}));
  }

  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> res = new ArrayList<>();
    backtracking(nums, res, new ArrayList<Integer>(), 0);
    return res;
  }

  private void backtracking(int[] nums, List<List<Integer>> res, List<Integer> list, int i) {
    res.add(new ArrayList<>(list));

    for (int j = i; j < nums.length; j++) {
      list.add(nums[j]);
      // 注意此处传入的是j, 区分与全排列的传入start
      backtracking(nums, res, list, j + 1);
      list.remove(list.size() - 1);
    }
  }

}
