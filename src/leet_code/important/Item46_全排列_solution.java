package leet_code.important;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

class Item46_全排列_solution {

    public static void main(String[] args) {
        Item46_全排列_solution a = new Item46_全排列_solution();
        List<List<Integer>> permute = a.permute(new int[]{3, 2, 1});

        System.out.println(permute.toString());
    }

    public List<List<Integer>> permute(int[] nums) {
        // 输出结果
        List<List<Integer>> res = new LinkedList();

        // 将nums变成对应的装箱的列表
        List<Integer> numList = new ArrayList<Integer>();
        for (int num : nums) {
            numList.add(num);
        }

        // 初始化n
        int n = nums.length;

        // 开始回溯
        backtrack(n, numList, res, 0);

        // 返回结果
        return res;
    }

    public void backtrack(int n, List<Integer> nums, List<List<Integer>> res, int start) {
        // 终止条件, 同时在这里处理结果
        if (start == n)
            res.add(new ArrayList<Integer>(nums));

        for (int i = start; i < n; i++) {
            // 放置
            Collections.swap(nums, start, i);
            // 推进
            backtrack(n, nums, res, start + 1);
            // 回溯
            Collections.swap(nums, start, i);
        }
    }


}
