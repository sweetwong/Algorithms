package leet_code;

class Item53 {

  public static void main(String[] args) {
    int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(nums));
  }

  public static int maxSubArray(int[] nums) {
    int len = nums.length;
    if (len == 0) return 0;

    int currSum = nums[0];
    int maxSum = nums[0];

    for (int i = 1; i < len; i++) {
      // 当新数大于0
      if (nums[i] > 0) {
        // 当之前的和小于等于0, 直接用新的数
        if (currSum <= 0) {
          currSum = nums[i];
        }
        // 当之前的和大于0, 用之前的和加新数
        else {
          currSum += nums[i];
        }
      }
      // 新数小于等于0
      else {
        // 当之前的和小于等于0, 直接用新的数
        if (currSum <= 0) {
          currSum = nums[i];
        }
        // 当之前的和大于0, 用之前的和加新数
        else {
          currSum += nums[i];
        }
      }
      maxSum = Math.max(currSum, maxSum);

    }
    return maxSum;
  }

}
