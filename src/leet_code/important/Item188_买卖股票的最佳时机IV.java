package leet_code.important;

class Item188_买卖股票的最佳时机IV {

    public static int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (n <= 1) return 0;

        if (k > prices.length / 2) return maxProfit(prices);

        int[][][] dp = new int[n][k + 1][2];

        // i代表第i+1天, 例如当i=0代表第一天, i=1代表第二天
        for (int i = 0; i < n; i++) {
            // j代表最大尝试交易次数
            // 当j为0时表示不能交易, 利润为0, 默认值本身就为0, 所以不用特意赋值
            // j必须从1开始, 因为需要用到dp[i - 1][j - 1][0]的数据
            for (int j = 1; j <= k; j++) {
                // 因为i=0依赖于i=-1的数据, 显然这是不合理的, 所以我们要处理i=0的基本情况
                if (i == 0) {
                    // 第一天不能卖
                    dp[0][j][0] = 0;
                    // 第一天就买入, 花掉了买入第一天需要的钱
                    dp[0][j][1] = -prices[0];
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
     * 按照可以交易无限次来计算(如果是要计算无限次还有种方法是找到所有递增的区间)
     */
    private static int maxProfit(int[] prices) {
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

    public static void main(String[] args) {
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(maxProfit(2, prices));
    }

}
