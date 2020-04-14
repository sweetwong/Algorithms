package leet_code;

import java.util.Arrays;

import util.array.ArrayUtils;

class Item322_零钱兑换_动态规划_自底向上 {

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;

        int[] dp = new int[amount + 1];

        for (int i = 1; i <= amount; i++) {
            int minCount = -1;
            for (int coin : coins) {
                int lastIndex = i - coin;
                if (lastIndex >= 0 && dp[lastIndex] != -1) {
                    if (minCount == -1) minCount = dp[lastIndex] + 1;
                    else minCount = Math.min(minCount, dp[lastIndex] + 1);
                }
            }
            dp[i] = minCount;
        }

        if (dp[amount] == 0) return -1;
        else return dp[amount];
    }

    public static void main(String[] args) {
        Item322_零钱兑换_动态规划_自底向上 a = new Item322_零钱兑换_动态规划_自底向上();
        System.out.println(a.coinChange(new int[]{2, 5, 10, 1}, 20));
    }

}
