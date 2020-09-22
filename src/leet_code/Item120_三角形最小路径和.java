package leet_code;

import data_structure.array.ArrayUtils;
import data_structure.string.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。
 *
 * 例如，给定三角形：
 *
 * [
 *   [2],
 *   [3,4],
 *   [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 *
 * start: 10:20 end: 10:50
 */
public class Item120_三角形最小路径和 {

    public static int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int lastLineLength = triangle.get(m - 1).size();
        int[] dp = new int[lastLineLength];
        int[] copy = new int[lastLineLength];
        dp[0] = triangle.get(0).get(0);
        for (int i = 1; i < m; i++) {
            List<Integer> curr = triangle.get(i);
            int n = curr.size();
            copy[0] = dp[0] + curr.get(0);
            for (int j = 1; j < n - 1; j++) {
                copy[j] = Math.min(dp[j - 1], dp[j]) + curr.get(j);
            }
            copy[n - 1] = dp[n - 2] + curr.get(n - 1);
            System.arraycopy(copy, 0, dp, 0, n);
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < lastLineLength; i++) {
            res = Math.min(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> triangle = Arrays.asList(
                Arrays.asList(2),
                Arrays.asList(3, 4),
                Arrays.asList(6, 5, 7),
                Arrays.asList(4, 1, 8, 3)
        );
        System.out.println(minimumTotal(triangle));
    }

}
