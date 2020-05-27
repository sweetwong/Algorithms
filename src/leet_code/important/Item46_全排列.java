package leet_code.important;

import java.util.ArrayList;
import java.util.List;

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
