////package leet_code;
////
/////**
//// * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//// *
//// * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//// *
//// * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//// *
//// * 网格中的障碍物和空位置分别用 1 和 0 来表示。
//// *
//// * 说明：m 和 n 的值均不超过 100。
//// *
//// * 示例 1:
//// * 输入:
//// * [
//// *   [0,0,0],
//// *   [0,1,0],
//// *   [0,0,0]
//// * ]
//// * 输出: 2
//// * 解释:
//// * 3x3 网格的正中间有一个障碍物。
//// * 从左上角到右下角一共有 2 条不同的路径：
//// * 1. 向右 -> 向右 -> 向下 -> 向下
//// * 2. 向下 -> 向下 -> 向右 -> 向右
//// */
//public class Item63_不同路径II {
//
//    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
//        int m = obstacleGrid.length;
//        if (m == 0) return 0;
//        int n = obstacleGrid[0].length;
//        if (n == 0) return 0;
//
//        int[][] dp = new int[m + 1][n + 1];
//        for (int i = 1; i <= m; i++) {
//            if (obstacleGrid[i][1] == 1) {
//                for (int k = i; k <= m; k++) {
//                    dp[k][1] = -1;
//                }
//                break;
//            }
//            dp[i][1] = 1;
//        }
//        for (int j = 1; j <= n; j++) {
//            if (obstacleGrid[1][j] == 1) {
//                for (int k = j; k <= n; k++) {
//                    dp[1][] = -1;
//                }
//                break;
//            }
//
//            dp[1][j] = 1;
//        }
//
//        for (int i = 2; i <= m; i++) {
//            for (int j = 2; j <= n; j++) {
//                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
//            }
//        }
//
//        return dp[m][n];
//    }
//
//
//}
