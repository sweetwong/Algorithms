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
class Item46_全排列 {

    public List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        if (len == 0) {
            return res;
        }

        backtrack(res, nums, len, new ArrayList<>(), new boolean[len], 0);
        return res;
    }

    private void backtrack(List<List<Integer>> res, int[] nums, int len, List<Integer> path, boolean[] used, int depth) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 此处 i = 0
        for (int i = 0; i < len; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;

                backtrack(res, nums, len, path, used, depth + 1);
                // 注意：这里是状态重置，是从深层结点回到浅层结点的过程，代码在形式上和递归之前是对称的
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Item46_全排列().permute(nums));
    }
}
