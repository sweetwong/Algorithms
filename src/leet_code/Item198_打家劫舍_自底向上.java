package leet_code;

/**
 * 纪念一下, 这是我纯自己写的dp, 居然击败了100%几乎最优
 */
class Item198_打家劫舍_自底向上 {

    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        // 表示从 0 开始，在 i 截止的最优解
        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[len - 1];
    }

}
