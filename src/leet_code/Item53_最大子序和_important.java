package leet_code;

class Item53_最大子序和_important {

  public static void main(String[] args) {
    int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    maxSubArray(nums);
  }

  /**
   * 贪心法
   */
  public static int maxSubArray(int[] nums) {
    int len = nums.length;
    int currSum = nums[0], maxSum = nums[0];
    System.out.println("nums[0] = " + nums[0] + ", currSum = " + currSum + ", maxSum = " + maxSum);
    for (int i = 1; i < len; i++) {
      currSum = Math.max(nums[i], currSum + nums[i]);
      maxSum = Math.max(maxSum, currSum);
      System.out.println("nums[" + i + "] = " + nums[i] + ", currSum = " + currSum + ", maxSum = " + maxSum);
    }
    return maxSum;
  }


}
