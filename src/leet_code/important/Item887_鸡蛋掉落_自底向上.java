package leet_code.important;

import data_structure.other.Time;

class Item887_鸡蛋掉落_自底向上 {

    public static int superEggDrop(int k, int n) {
        int[][] dp = new int[k + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            // 当只有一个鸡蛋时, 需要当前的楼层次额
            dp[1][i] = i;
        }
        // k从2开始算, k最小只会依赖到1
        for (int x = 2; x <= k; x++) {
            // n从1开始算, n最小会依赖到0(但是当n=0, 取默认值是对的, 所以不需要额外赋值)
            for (int y = 1; y <= n; y++) {
                // res最大为当前的楼层
                int res = y;
                for (int z = 1; z <= y; z++) {
                    // 这个非常重要, 状态转移方程建议带入具体的参数
                    res = Math.min(res, Math.max(dp[x][y - z], dp[x - 1][z - 1]) + 1);
                }
                dp[x][y] = res;
            }
        }
        return dp[k][n];
    }

    public static void main(String[] args) {
        Time.watch(() -> superEggDrop(3, 10));
    }

}
