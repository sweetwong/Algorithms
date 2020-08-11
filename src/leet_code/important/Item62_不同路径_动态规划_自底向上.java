package leet_code.important;

class Item62_不同路径_动态规划_自底向上 {

    public static int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;

        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
        }
        for (int j = 1; j <= n; j++) {
            dp[1][j] = 1;
        }

        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(Item62_不同路径_动态规划_自顶向下.uniquePaths(12, 23));
        System.out.println(Item62_不同路径_动态规划_自底向上.uniquePaths(12, 23));
    }

}
