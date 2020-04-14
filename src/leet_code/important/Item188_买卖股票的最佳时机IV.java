package leet_code.important;

class Item188_买卖股票的最佳时机IV {

    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;

        if (k > prices.length / 2) return maxProfit(prices);

        int[][][] dp = new int[n][k + 1][2];

        // i代表剩余天数
        for (int i = 0; i < n; i++) {
            // j代表最大尝试交易次数
            for (int j = 1; j <= k; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[0];
                    continue;
                }
                // 状态转移方程
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }
        return dp[n - 1][k][0];
    }

    /**
     * 按照可以交易无限次来计算
     */
    private int maxProfit(int[] prices) {
        int maxProfit = 0;
        int currProfit = Integer.MIN_VALUE;
        int temp = 0;
        for (int price : prices) {
            maxProfit = Math.max(maxProfit, currProfit + price);
            currProfit = Math.max(currProfit, temp - price);
            temp = maxProfit;
        }
        return maxProfit;
    }

}
