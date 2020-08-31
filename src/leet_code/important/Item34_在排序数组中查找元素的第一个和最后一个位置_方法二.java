package leet_code.important;

import search.binary.BinarySearch;

import java.util.Arrays;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 *
 * 示例 2:
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class Item34_在排序数组中查找元素的第一个和最后一个位置_方法二 {

    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) {
            return new int[]{-1, -1};
        }

        return new int[]{searchLow(nums, target), searchHigh(nums, target)};
    }

    private static int searchLow(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + hi >>> 1;
            if (nums[mid] < target) {
                lo = mid + 1;
            }
            // 等于按照大于target处理
            else {
                hi = mid;
            }
        }
        if (nums[lo] == target) {
            return lo;
        }
        return -1;
    }

    private static int searchHigh(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + hi + 1 >>> 1;
            if (nums[mid] > target) {
                hi = mid - 1;
            }
            // 等于按照小于target处理
            else {
                lo = mid;
            }
        }
        if (nums[lo] == target) {
            return lo;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(searchLow(nums, 8));
        System.out.println(searchHigh(nums, 8));
    }

}
