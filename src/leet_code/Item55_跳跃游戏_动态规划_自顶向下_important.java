package leet_code;

class Item55_跳跃游戏_动态规划_自顶向下_important {

  public boolean canJump(int[] nums) {
    int n = nums.length;
    Boolean[] memo = new Boolean[n + 1];
    return canJumpFromPosition(nums, nums.length, memo, 0);
  }

  public boolean canJumpFromPosition(int[] nums, int n, Boolean[] memo, int start) {
    if (start >= n - 1) return true;
    if (nums[start] == 0) return false;

    if (memo[start] != null) {
      return memo[start];
    }

    for (int i = nums[start]; i >= 1; i--) {
      if (canJumpFromPosition(nums, n, memo, start + i)) {
        memo[start] = true;
        return true;
      }
    }

    memo[start] = false;
    return false;
  }

}
