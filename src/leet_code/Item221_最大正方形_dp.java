package leet_code;

import data_structure.array.Arrays;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 */
public class Item221_最大正方形_dp {

    public static int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int maxSide = 0;

        int m = matrix.length;
        int n = matrix[0].length;
        // 定义状态（状态表示的是什么？）
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // 状态转移方程（左、上、左上的最小值 +1）
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }

        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }


    public static void main(String[] args) {
        char[][] matrix = {
                {'0','0','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'},
                {'0','1','1','1'},
                {'0','1','1','1'}
        };
        System.out.println(maximalSquare(matrix));
    }

}
