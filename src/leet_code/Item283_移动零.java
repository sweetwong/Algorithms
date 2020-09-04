package leet_code;

import java.util.Arrays;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
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
