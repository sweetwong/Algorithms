package leet_code;

import java.util.Arrays;

class Item279_完全平方数_自底向上 {

    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = n;
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Item279_完全平方数_自底向上 a = new Item279_完全平方数_自底向上();
        System.out.println(a.numSquares(12));

    }

}
