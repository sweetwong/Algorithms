package leet_code;

class Item53_important {

  /**
   * 贪心法
   */
  public static int maxSubArray(int[] nums) {
    int len = nums.length;
    int currSum = nums[0], maxSum = nums[0];
    for (int i = 1; i < len; i++) {
      currSum = Math.max(nums[i], currSum + nums[i]);
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }


}
