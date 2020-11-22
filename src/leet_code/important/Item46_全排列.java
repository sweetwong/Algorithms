package leet_code.important;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
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

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(res, new ArrayDeque<>(), new boolean[nums.length], nums, 0);
        return res;
    }

    private static void backtrack(List<List<Integer>> res, Deque<Integer> path,
                                  boolean[] visited, int[] nums, int start) {
        if (start == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                path.addLast(nums[i]);

                backtrack(res, path, visited, nums, start + 1);

                path.removeLast();
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> res = permute(new int[]{1, 2, 3});
        System.out.println(res);
    }
}
