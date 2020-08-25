package leet_code;

import java.util.Arrays;

/**
 * 找到下一个字典排列
 * 注意, 要知道什么是字典排列, 既 下一个 满足大于nums对应的数的 最小的 数
 */
class Item31_下一个排列 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void nextPermutation(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;

        int j = n - 1;
        while (j > 0 && nums[j - 1] >= nums[j]) {
            j--;
        }

        // 整个数组都是降序排序, 直接反转整个数组
        if (j == 0) {
            reverse(nums, 0, n - 1);
            return;
        }

        // 找到最小的, 大于nums[i]的树
        int i = j - 1;
        while (j < n && nums[i] < nums[j]) {
            j++;
        }

        swap(nums, i, j - 1);

        reverse(nums, i + 1, n - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

}
