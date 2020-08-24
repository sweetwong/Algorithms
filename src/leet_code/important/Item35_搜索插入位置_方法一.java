package leet_code.important;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 示例 2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class Item35_搜索插入位置_方法一 {

    /**
     * 可以理解为, 从nums中找到target
     * 1. 如果找到了就返回target所在的索引
     * 2. 如果找不到, 就返回比target大的数的索引
     * 3. 如果没有比target大的数, 就返回默认值n
     */
    public static int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        // 当nums[mid] < target的时候, ans不会被赋值, 最后可能会返回默认值
        int ans = n;
        while (lo <= hi) {
            int mid = lo + ((hi - lo) >>> 1);
            if (nums[mid] >= target) {
                ans = mid;
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 7));
    }

}
