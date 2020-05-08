package leet_code;

import java.util.Arrays;

class Item283_移动零 {

    /**
     * 参考快速排序的分区的思路
     */
    public static void moveZeroes1(int[] nums) {
        for (int i = 0, j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
        }
    }

    /**
     * 参考插入排序的思路
     */
    public static void moveZeroes2(int[] nums) {
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < n && nums[j] != 0) {
                    nums[j - 1] = nums[j];
                    j++;
                }
                nums[j - 1] = 0;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes1(nums);
        System.out.println(Arrays.toString(nums));
    }

}
