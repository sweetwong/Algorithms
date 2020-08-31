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
 *
 * @see search.binary.BinarySearch
 */
public class Item35_搜索插入位置 {

    public static int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        int res = 0;

        while (lo <= hi) {
            int mid = lo + hi >>> 1;
            int midVal = nums[mid];
            if (midVal < target) {
                lo = mid + 1;
                res = mid;
            } else if (midVal > target) {
                hi = mid - 1;
            } else {
                res = mid;
                break;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        System.out.println(searchInsert(nums, 5));
    }

}
