package LeetCode;

import java.util.ArrayList;
import java.util.List;

class Item39 {

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> lists = new ArrayList<>();
    if (candidates == null || candidates.length == 0 || target < 0) {
      return lists;
    }

    List<Integer> record = new ArrayList<>();
    process(0, candidates, target, record, lists);
    return lists;
  }

  private void process(int start, int[] candidates, int target, List<Integer> record, List<List<Integer>> res) {
    //递归的终止条件
    if (target < 0) {
      return;
    }
    if (target == 0) {
      res.add(new ArrayList<>(record));
    } else {
      for (int i = start; i < candidates.length; i++) {
        record.add(candidates[i]);
        //因为每个数字都可以使用无数次，所以递归还可以从当前元素开始
        process(i, candidates, target - candidates[i], record, res);
        record.remove(record.size() - 1);
      }
    }
  }





  public static void main(String[] args) {
    Item39 a = new Item39();
    print(a.combinationSum(new int[]{2, 3, 5}, 8));
  }


  private static void print(List<List<Integer>> res) {
    for (List<Integer> a : res) {
      System.out.print("[");
      for (int b : a) {
        System.out.print(b + " ");
      }
      System.out.print("]");
      System.out.println(" ");
    }
  }
}
