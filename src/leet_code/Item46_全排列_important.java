package leet_code;

import java.util.ArrayList;
import java.util.List;

import static util.Utils.swap;

class Item46_全排列_important {

  public static void main(String[] args) {
    Item46_全排列_important a = new Item46_全排列_important();
    System.out.println(a.permute(new int[]{1, 2, 3}).toString());
  }

  public List<List<Integer>> permute(int[] nums) {
    // 结果
    List<List<Integer>> res = new ArrayList<>();

    // 开始回溯
    backtracking(nums.length, nums, res, 0);

    // 返回结果
    return res;
  }

  /**
   * 全排列的回溯是一维的, 相当于在一个 1 × n 的棋盘上放不同的棋
   *
   * N皇后的回溯是二维的, 是在 m × n 的棋盘上放棋
   */
  private void backtracking(int n, int[] nums, List<List<Integer>> res, int start) {
    // 只有当row达到n的时候才添加, 其他时候不添加+
    if (start == n) {
      List<Integer> oneSolution = new ArrayList<>();
      for (int num : nums) {
        oneSolution.add(num);
      }
      res.add(oneSolution);
      // 最后不用加return, 因为当row=n的时候, 下面的for循环无法开启
    }

    // 迭代的方向是从左到右(宽度), 递归的方向是从上到下(深度)
    // 迭代是选择不同的起点, 但是深度都是一样的
    // 递归是向下一个梯度前进

    // 其中start代表哪一行(深度), col代表哪一列(宽度)
    for (int i = start; i < n; i++) {
      // 尝试(放棋)
      swap(nums, start, i);
      // 递归(去下一层放棋)
      backtracking(n, nums, res, start + 1);
      // 回溯(反悔)
      swap(nums, start, i);
    }
  }

  public void swap(int[] nums, int i, int j) {
    int temp = nums[i];
    nums[i] = nums[j];
    nums[j] = temp;
  }


}
