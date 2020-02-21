package leet_code.important;

class Item53_最大子序和_贪心法_important {

  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(nums));
  }

  /**
   * 贪心法
   */
  public static int maxSubArray(int[] nums) {
    int len = nums.length;
    int currSum = nums[0], maxSum = nums[0];
    for (int i = 1; i < len; i++) {
      // 如果之前的数有用
      if (currSum > 0) currSum = nums[i] + currSum;
      // 之前的数没用, 从新的开始
      else currSum = nums[i];
      maxSum = Math.max(maxSum, currSum);
    }
    return maxSum;
  }


}
