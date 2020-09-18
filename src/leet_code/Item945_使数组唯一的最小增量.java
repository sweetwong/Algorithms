package leet_code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给定整数数组 A，每次 move 操作将会选择任意 A[i]，并将其递增 1。
 *
 * 返回使 A 中的每个值都是唯一的最少操作次数。
 *
 * 示例 1:
 * 输入：[1,2,2]
 * 输出：1
 * 解释：经过一次 move 操作，数组将变为 [1, 2, 3]。
 *
 * 示例 2:
 * 输入：[3,2,1,2,1,7]
 * 输出：6
 * 解释：经过 6 次 move 操作，数组将变为 [3, 4, 1, 2, 5, 7]。
 * 可以看出 5 次或 5 次以下的 move 操作是不能让数组的每个值唯一的。
 *
 * 提示：
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 */
public class Item945_使数组唯一的最小增量 {

    /**
     * 贪心法
     *
     * TODO 这个方法是很简单, 但是如何证明是正确的的呢？即局部最优解是整体最优解
     */
    public static int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                int diff = nums[i - 1] - nums[i] + 1;
                nums[i] += diff;
                count += diff;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 2, 1, 7};
        System.out.println(minIncrementForUnique(nums));
    }

}
