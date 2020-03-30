package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Item40_组合总和II {

  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    Arrays.sort(candidates);
    List<List<Integer>> res = new ArrayList<>();
    backtracking(candidates, candidates.length, target, 0, res, new ArrayList<>());
    return res;
  }

  public void backtracking(int[] candidates, int n, int target, int start,
                           List<List<Integer>> res, List<Integer> list) {
    if (target < 0) return;

    if (target == 0) {
      if (!res.contains(list)) res.add(new ArrayList<>(list));
    }

    for (int i = start; i < n; i++) {
      list.add(candidates[i]);
      backtracking(candidates, n, target - candidates[i], i + 1, res, list);
      list.remove(list.size() - 1);
    }
  }

}
