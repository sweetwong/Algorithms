package leet_code;

/**
 * TODO 我擦, 我感觉没问题呀, 为什么结果不对呢? 快找出到底哪里出问题了
 */
class Item300_最长上升子序列 {

  public int lengthOfLIS(int[] nums) {
    return lengthOfLIS(nums, new int[nums.length], 0);
  }

  public int lengthOfLIS(int[] nums, int[] dp, int start) {
    if (start == nums.length - 1) return 1;

    if (dp[start] != 0) return dp[start];

    int maxNext = 0;
    for (int i = nums.length - 1; i > start; i--) {
      if (nums[start] <= nums[i]) {
        maxNext = Math.max(maxNext, lengthOfLIS(nums, dp, i));
      }
    }

    dp[start] = maxNext + 1;

    return dp[start];
  }


}
