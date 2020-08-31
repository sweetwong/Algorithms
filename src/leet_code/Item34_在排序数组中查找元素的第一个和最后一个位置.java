package leet_code;

import java.util.Arrays;

public class Item34_在排序数组中查找元素的第一个和最后一个位置 {

    public int[] searchRange(int[] nums, int target) {
        return new int[]{search(nums, target, true), search(nums, target, false)};
    }

    public int search(int[] nums, int target, boolean searchLow) {
        int lo = 0;
        int hi = nums.length - 1;
        int res = -1;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >>> 1);
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
        Item34_在排序数组中查找元素的第一个和最后一个位置 a = new Item34_在排序数组中查找元素的第一个和最后一个位置();
        System.out.println(Arrays.toString(a.searchRange(new int[]{2, 2}, 2)));
    }


}
