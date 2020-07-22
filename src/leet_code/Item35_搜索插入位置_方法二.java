package leet_code;

public class Item35_搜索插入位置_方法二 {

    public static int searchInsert(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + ((hi - lo) >>> 1);
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        // 重点：注意此处是返回lo还是hi
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {10, 30, 40, 60};
        System.out.println(searchInsert(nums, 31));
    }

}
