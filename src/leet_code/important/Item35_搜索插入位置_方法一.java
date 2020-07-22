package leet_code.important;

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
