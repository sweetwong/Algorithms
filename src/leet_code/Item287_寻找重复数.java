package leet_code;

/**
 * 给定一个包含 n + 1 个整数的数组 nums，其数字都在 1 到 n 之间（包括 1 和 n），可知至少存在一个重复的整数。假设只有一个重复的整数，找出这个重复的数。
 *
 * 示例 1:
 *
 * 输入: [1,3,4,2,2]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [3,1,3,4,2]
 * 输出: 3
 * 说明：
 *
 * 不能更改原数组（假设数组是只读的）。
 * 只能使用额外的 O(1) 的空间。
 * 时间复杂度小于 O(n2) 。
 * 数组中只有一个重复的数字，但它可能不止重复出现一次。
 *
 * TODO 理解这道题
 */
public class Item287_寻找重复数 {

    public static int findDuplicate(int[] nums) {
        int n = nums.length;
        int lo = 1;
        int hi = n - 1;
        while (lo < hi) {
            // 在 Java 里可以这么用，当 lo + hi 溢出的时候，无符号右移保证结果依然正确
            int mid = lo + hi >>> 1;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }
            // 根据抽屉原理，小于等于 4 的个数如果严格大于 4 个
            // 此时重复元素一定出现在 [1, 4] 区间里
            if (cnt > mid) {
                // 重复元素位于区间 [lo, mid]
                hi = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面
                // [mid + 1, hi]
                lo = mid + 1;
            }
        }
        return lo;
    }

    public static void main(String[] args) {
        int[] nums = {3, 1, 3, 4, 2};
        int res = findDuplicate(nums);
        System.out.println(res);
    }

}
