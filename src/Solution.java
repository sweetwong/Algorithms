import util.array.ArrayUtils;

class Solution {

  public static void main(String[] args) {
    Solution s = new Solution();
    System.out.println(s.rob(new int[]{2, 7, 9, 3, 1}));
  }

  public int rob(int[] nums) {
    int n = nums.length;
    Integer[] memo = new Integer[n + 1];
    return helper(nums, n, memo, 0);
  }

  public int helper(int[] nums, int n, Integer[] memo, int start) {
    if (start >= n) return 0;
    if (start == n - 1) return nums[n - 1];
    if (start == n - 2) return Math.max(nums[n - 2], nums[n - 1]);

    if (memo[start] != null) return memo[start];

    int res = Math.max(nums[start] + helper(nums, n, memo, start + 2),
      nums[start + 1] + helper(nums, n, memo, start + 3));

    memo[start] = res;

    return res;
  }

}