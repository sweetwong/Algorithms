package leet_code;

class Item300_最长上升子序列_动态规划_迭代 {

    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;

        int ans = 1;
        // 代表从dp[i]开始的最长上升子序列, 例如从最后一个开始就是1;
        int[] dp = new int[n];
        dp[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--) {
            int maxNext = 0;
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    maxNext = Math.max(maxNext, dp[j]);
                }
            }
            dp[i] = maxNext + 1;
            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

}
