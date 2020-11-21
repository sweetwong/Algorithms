package leet_code;

/**
 * 纪念一下, 这是我纯自己写的dp, 居然击败了100%几乎最优
 */
class Item198_打家劫舍_自顶向下 {

    /**
     * 动态规划, 自顶向下
     */
    public static int rob(int[] nums) {
        Integer[] memo = new Integer[nums.length + 1];
        return rob(nums, 0, memo);
    }

    public static int rob(int[] nums, int start, Integer[] dp) {
        int len = nums.length;

        if (start >= len) return 0;
        if (start == len - 1) return nums[len - 1];
        if (start == len - 2) return Math.max(nums[len - 1], nums[len - 2]);

        if (dp[start] != null) return dp[start];

        int res = Math.max(nums[start] + rob(nums, start + 2, dp), nums[start + 1] + rob(nums, start + 3, dp));
        dp[start] = res;
        return res;
    }

}
