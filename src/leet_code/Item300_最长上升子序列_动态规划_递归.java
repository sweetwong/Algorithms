package leet_code;

import data_structure.array.ArrayUtils;
import data_structure.other.Time;

class Item300_最长上升子序列_动态规划_递归 {

    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, lengthOfLISFromStart(nums, dp, i));
        }
        return max;
    }

    public static int lengthOfLISFromStart(int[] nums, int[] dp, int start) {
        if (start == nums.length - 1) return 1;

        if (dp[start] != 0) {
            return dp[start];
        }

        int maxNext = 0;
        for (int i = nums.length - 1; i > start; i--) {
            if (nums[start] < nums[i]) {
                maxNext = Math.max(maxNext, lengthOfLISFromStart(nums, dp, i));
            }
        }

        dp[start] = maxNext + 1;

        return dp[start];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int[] nums1 = ArrayUtils.createRandomArray(30000);
            Time.watch(() -> Item300_最长上升子序列_动态规划_递归.lengthOfLIS(nums1));

            int[] nums2 = ArrayUtils.createRandomArray(30000);
            Time.watch(() -> Item300_最长上升子序列_动态规划_迭代.lengthOfLIS(nums2));

            System.out.println();
        }
    }

}
