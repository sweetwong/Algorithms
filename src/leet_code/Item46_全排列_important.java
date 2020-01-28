package leet_code;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import util.Utils;

import static util.Utils.swap;

class Item46_全排列_important {

  public List<List<Integer>> permute(int[] nums) {
    // 结果
    List<List<Integer>> res = new ArrayList<>();

    // 开始回溯
    backtrack(nums.length, nums, res, 0);

    // 返回结果
    return res;
  }

  /**
   * 全排列的回溯是一维的, 相当于在一个 1 × n 的棋盘上放不同的棋
   *
   * N皇后的回溯是二维的, 是在 m × n 的棋盘上放棋
   */
  private void backtrack(int n, int[] nums, List<List<Integer>> res, int row) {
    // 当每一层的棋都放完了, 终止
    // 终止条件, 同时在这里处理结果
    if (row == n) {
      List<Integer> oneSolution = new ArrayList<>();
      for (int num : nums) {
        oneSolution.add(num);
      }
      res.add(oneSolution);
      return;
    }

    // 迭代的方向是从左到右(宽度), 递归的方向是从上到下(深度)
    // 迭代是选择不同的起点, 但是深度都是一样的
    // 递归是向下一个梯度前进

    // 其中start代表哪一行(深度), col代表哪一列(宽度)
    for (int col = row; col < n; col++) {
      // 尝试(放棋)
      swap(nums, row, col);
      // 递归(去下一层放棋)
      backtrack(n, nums, res, row + 1);
      // 回溯(反悔)
      swap(nums, row, col);
    }
  }

}
