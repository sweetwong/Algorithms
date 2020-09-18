package leet_code;

import data_structure.array.ArrayUtils;
import data_structure.other.Time;

/**
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 *
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 *
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 *
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class Item167_两数之和II_输入有序数组_二分查找 {

    public static int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        for (int i = 0; i < len - 1; i++) {
            int first = nums[i];
            if (first > target) {
                return null;
            }
            int lo = i + 1, hi = len - 1;
            int second = target - first;
            while (lo <= hi) {
                int mid = lo + hi >>> 1;
                if (nums[mid] < second) {
                    lo = mid + 1;
                } else if (nums[mid] > second) {
                    hi = mid - 1;
                } else {
                    return new int[]{i + 1, mid + 1};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtils.createRandomArray(100000000, 10000, false);
        Time.watch(() -> ArrayUtils.print(twoSum(nums, 1000000000)));
    }

}
