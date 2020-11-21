package leet_code;

/**
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 *
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 *
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 *
 * 如果不含有 “山脉” 则返回 0。
 *
 * 示例 1：
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 *
 * 示例 2：
 * 输入：[2,2,2]
 * 输出：0
 * 解释：不含 “山脉”。
 *
 * 提示：
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 */
public class Item845_数组中的最长山脉 {

    public static int longestMountain(int[] nums) {
        int len = nums.length;
        if (len < 3) return 0;

        int max = 0;
        for (int i = 1; i < len - 1; i++) {
            int code = spread(nums, len, i);
            if (code == 0) continue;
            int l = code / 10001;
            int r = code % 10001;
            max = Math.max(max, r - l + 1);
            i = r;
        }

        return max < 3 ? 0 : max;
    }

    private static int spread(int[] nums, int len, int mid) {
        int l = mid - 1;
        int r = mid + 1;
        if (nums[l] >= nums[l + 1] || nums[r] >= nums[r - 1]) return 0;
        while (l >= 0 && nums[l] < nums[l + 1]) {
            l--;
        }
        while (r < len && nums[r] < nums[r - 1]) {
            r++;
        }
        return (l + 1) * 10001 + (r - 1);
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 4, 3, 2, 1, 0};
        int max = longestMountain(nums);
        System.out.println(max);
    }

}
