package leet_code.important;

class Item55_跳跃游戏_动态规划_自顶向下_important {

  public boolean canJump(int[] nums) {
    return canJump(nums, nums.length, new Boolean[nums.length + 1], 0);
  }

  public boolean canJump(int[] nums, int n, Boolean[] dp, int start) {
    if (start >= n - 1) return true;
    if (nums[start] == 0) return false;

    if (dp[start] != null) {
      return dp[start];
    }

    for (int i = nums[start]; i >= 1; i--) {
      if (canJump(nums, n, dp, start + i)) {
        dp[start] = true;
        return true;
      }
    }

    dp[start] = false;
    return false;
  }

}
