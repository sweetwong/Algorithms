package leet_code;

class Item53 {

  public static void main(String[] args) {
    int[] arr = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(maxSubArray(arr));
  }

  public static int maxSubArray(int[] nums) {
    int len = nums.length;
    if (len == 1) return nums[0];

    int max = Integer.MIN_VALUE;
    int sum = nums[0];
    int i = 0, j = 0;

    while (i < len - 1 && j < len - 1) {
      while (j < len - 2 && nums[j + 1] >= 0) {
        sum += nums[j + 1];
        j++;
      }
      max = Math.max(max, sum);
      while (i <= j && nums[i] <= 0) {
        sum -= nums[i];
        i++;
      }
      max = Math.max(max, sum);

      if (nums[j + 1] >= nums[i]) {
        sum += nums[j + 1];
        j++;
      } else {
        sum -= nums[i];
        i++;
      }
    }

    return max;
  }

}
