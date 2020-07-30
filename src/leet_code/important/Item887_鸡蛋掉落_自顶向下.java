package leet_code.important;

import data_structure.other.Time;

class Item887_鸡蛋掉落_自顶向下 {

    public static int superEggDrop(int k, int n) {
        return superEggDrop(k, n, new int[k + 1][n + 1]);
    }

    public static int superEggDrop(int k, int n, int[][] dp) {
        if (n == 0) return 0;
        if (k == 1) return n;

        if (dp[k][n] != 0) return dp[k][n];

        int res = n;
        // 大问题转小问题
        for (int i = 1; i <= n; i++) {
            res = Math.min(res,
                    // 考虑最坏情况, 所以是max
                    Math.max(
                            // 没摔碎, 鸡蛋不变, 从上面的楼层找
                            superEggDrop(k, n - i, dp),
                            // 摔碎了, 鸡蛋减1, 从下面的楼层找
                            superEggDrop(k - 1, i - 1, dp)
                    ) + 1);
        }
        dp[k][n] = res;

        return res;
    }

    public static void main(String[] args) {
        Time.watch(() -> System.out.println(superEggDrop(6, 5000)));
    }

}
