import java.util.ArrayList;
import java.util.List;

import util.array.ArrayUtils;

class Solution {

  public static void main(String[] args) {
    Solution a = new Solution();
    System.out.println(a.combinationSum(new int[]{2, 3, 6, 7}, 7).toString());
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> res = new ArrayList<>();
    backtracking(candidates, target, res, new ArrayList<>(), 0, 0);
    return res;
  }

  public void backtracking(int[] candidates, int target, List<List<Integer>> res,
                           List<Integer> list, int sum, int start) {
    if (sum > target) return;

    if (sum == target) {
      res.add(new ArrayList<>(list));
    }

    for (int i = start; i < candidates.length; i++) {
      sum += candidates[i];
      list.add(candidates[i]);

      backtracking(candidates, target, res, list, sum, i);

      sum -= list.get(list.size() - 1);
      list.remove(list.size() - 1);
    }
  }

}