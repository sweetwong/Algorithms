package leet_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Item46_全排列_important {

  public static void main(String[] args) {
    Item46_全排列_important a = new Item46_全排列_important();
    a.permute(new int[]{1, 2, 3});
  }

  private List<List<Integer>> res = new ArrayList();
  private int[] nums;
  private int n;

  public List<List<Integer>> permute(int[] nums) {
    // 初始化
    this.nums = nums;
    n = nums.length;

    // 开始回溯
    backtrack(0);

    // 返回结果
    return res;
  }

  private int times = 0;

  private void backtrack(int start) {
    // 终止条件, 同时在这里处理结果
    if (start == n) {
      addSolution();
      return;
    }

    for (int i = start; i < n; i++) {
      // 尝试
      swap(start, i);
      // 递归
      backtrack(start + 1);
      // 回溯
      swap(start, i);
    }
  }

  private void swap(int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }

  private void addSolution() {
    List<Integer> oneSolution = new ArrayList<>();
    for (int num : nums) {
      oneSolution.add(num);
    }
    res.add(oneSolution);
  }

}
