package leet_code;

/**
 * 纪念一下, 这是我纯自己写的dp, 居然击败了100%几乎最优
 */
class Item198_打家劫舍_动态规划 {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 9, 3, 1, 6};
        System.out.println(robIte(nums));
    }

    /**
     * 动态规划, 自顶向下
     */
    public static int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length + 1];
        return dp(nums, 0, memo);
    }

    public static int dp(int[] nums, int start, Integer[] memo) {
        int len = nums.length;

        if (start >= len) return 0;
        if (start == len - 1) return nums[len - 1];
        if (start == len - 2) return Math.max(nums[len - 1], nums[len - 2]);

        if (memo[start] != null) return memo[start];

        int res = Math.max(nums[start] + dp(nums, start + 2, memo), nums[start + 1] + dp(nums, start + 3, memo));
        memo[start] = res;
        return res;
    }


    /**
     * 动态规划, 自底向上
     */
    public static int robIte(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;

        int[] dp = new int[len];

        dp[0] = nums[0];
        if (len == 1) return dp[0];
        dp[1] = Math.max(nums[0], nums[1]);
        if (len == 2) return dp[1];
        dp[2] = Math.max(nums[0] + nums[2], nums[1]);
        if (len == 3) return dp[2];

        for (int i = 3; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[len - 1];
    }

}
