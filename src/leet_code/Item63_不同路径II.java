package leet_code;

import data_structure.array.ArrayUtils;
import data_structure.string.StringUtils;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
 *
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
 *
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 *
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 *
 * 说明：m 和 n 的值均不超过 100。
 *
 * 示例 1:
 * 输入:
 * [
 *   [0,0,0],
 *   [0,1,0],
 *   [0,0,0]
 * ]
 *
 * 输出: 2
 *
 * 解释:
 * 3x3 网格的正中间有一个障碍物。
 * 从左上角到右下角一共有 2 条不同的路径：
 * 1. 向右 -> 向右 -> 向下 -> 向下
 * 2. 向下 -> 向下 -> 向右 -> 向右
 */
public class Item63_不同路径II {

    public static int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        if (n == 0) return 0;

        int dp[][] = new int[m][n];

        boolean hasObstacle = false;
        for (int i = 0; i < m; i++) {
            if (hasObstacle) {
                dp[i][0] = -1;
                continue;
            }
            if (grid[i][0] == 1) {
                hasObstacle = true;
                dp[i][0] = -1;
            } else {
                dp[i][0] = 1;
            }
        }

        hasObstacle = false;
        for (int j = 0; j < n; j++) {
            if (hasObstacle) {
                dp[0][j] = -1;
                continue;
            }
            if (grid[0][j] == 1) {
                hasObstacle = true;
                dp[0][j] = -1;
            } else {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = -1;
                    continue;
                }
                if (dp[i - 1][j] == -1 && dp[i][j - 1] == -1) {
                    dp[i][j] = -1;
                    continue;
                }
                if (dp[i - 1][j] == -1) {
                    dp[i][j] = dp[i][j - 1];
                    continue;
                }
                if (dp[i][j - 1] == -1) {
                    dp[i][j] = dp[i - 1][j];
                    continue;
                }
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1] == -1 ? 0 : dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int[][] grid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsWithObstacles(grid));
    }


}
