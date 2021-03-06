package leet_code.important;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
class Item46_全排列_通过交换解决 {

    public List<List<Integer>> permute(int[] nums) {
        // 结果
        List<List<Integer>> res = new ArrayList<>();

        // 开始回溯
        backtrack(nums.length, nums, res, 0);

        // 返回结果
        return res;
    }

    private void backtrack(int n, int[] nums, List<List<Integer>> res, int depth) {
        // 只有当row达到n的时候才添加, 其他时候不添加+
        if (depth == n) {
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            res.add(list);
            // 最后不用加return, 因为当row=n的时候, 下面的for循环无法开启
        }

        // 迭代的方向是从左到右(宽度), 递归的方向是从上到下(深度)
        // 迭代是选择不同的起点, 但是深度都是一样的
        // 递归是向下一个梯度前进

        // 其中start代表哪一行(深度), col代表哪一列(宽度)
        for (int i = depth; i < n; i++) {
            // 尝试(放棋)
            swap(nums, depth, i);
            // 递归(去下一层放棋)
            backtrack(n, nums, res, depth + 1);
            // 回溯(反悔)
            swap(nums, depth, i);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Item46_全排列_通过交换解决 a = new Item46_全排列_通过交换解决();
        System.out.println(a.permute(new int[]{1, 2, 3}).toString());
    }


}
