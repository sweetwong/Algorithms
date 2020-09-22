package leet_code.important;

class Item53_最大子序和_贪心法 {

    /**
     * 贪心法
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;
        for (int num: nums) {
            // 看是否需要保存之前的数，还是重新开始
            currSum = Math.max(currSum + num, num);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

}
