package leet_code.important;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Item34_在排序数组中查找元素的第一个和最后一个位置_方法一 {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{search(nums, target, true), search(nums, target, false)};
    }

    public int search(int[] nums, int target, boolean searchLow) {
        int lo = 0;
        int hi = nums.length - 1;
        int res = -1;
        while (lo <= hi) {
            int mid = lo + hi >>> 1;
            int midVal = nums[mid];
            if (midVal < target) {
                lo = mid + 1;
            } else if (midVal > target) {
                hi = mid - 1;
            } else {
                // 关键: 保存最后一次找到的结果res, 不要关注最后lo和hi停留的位置
                res = mid;
                if (searchLow) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Item34_在排序数组中查找元素的第一个和最后一个位置_方法一 a = new Item34_在排序数组中查找元素的第一个和最后一个位置_方法一();
        System.out.println(Arrays.toString(a.searchRange(new int[]{2, 2}, 2)));
    }


}
