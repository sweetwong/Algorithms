package leet_code;

/**
 * 给定一个整数矩阵，找出最长递增路径的长度。
 *
 * 对于每个单元格，你可以往上，下，左，右四个方向移动。 你不能在对角线方向上移动或移动到边界外（即不允许环绕）。
 *
 * 示例 1:
 * 输入: nums =
 * [
 *   [9,9,4],
 *   [6,6,8],
 *   [2,1,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径为 [1, 2, 6, 9]。
 *
 * 示例 2:
 * 输入: nums =
 * [
 *   [3,4,5],
 *   [3,2,6],
 *   [2,2,1]
 * ]
 * 输出: 4
 * 解释: 最长递增路径是 [3, 4, 5, 6]。注意不允许在对角线方向上移动。
 *
 * s:1400 e:1430
 */
public class Item329_矩阵中的最长递增路径 {

    public static int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;

        int m = matrix.length;
        int n = matrix[0].length;

        // 代表从dp[i][j]出发的最长路径
        int[][] dp = new int[m][n];

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int longest = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                longest = Math.max(longest, dfs(matrix, dp, directions, m, n, i, j));
            }
        }

        return longest;
    }

    private static int dfs(int[][] matrix, int[][] dp, int[][] directions, int m, int n, int i, int j) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }

        int nextCountMax = 0;
        for (int[] direction : directions) {
            int nextI = i + direction[0];
            int nextJ = j + direction[1];
            // 下一个是合理的
            if (nextI >= 0 && nextI < m && nextJ >= 0 && nextJ < n
                    && matrix[nextI][nextJ] > matrix[i][j]) {
                int nextCount = dfs(matrix, dp, directions, m, n, nextI, nextJ);
                nextCountMax = Math.max(nextCountMax, nextCount);
            }
        }

        dp[i][j] = nextCountMax + 1;

        return dp[i][j];
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {9,9,4},
                {6,6,8},
                {2,1,1}
        };
        System.out.println(longestIncreasingPath(matrix));;
    }

}
