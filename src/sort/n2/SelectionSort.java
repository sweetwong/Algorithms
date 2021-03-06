package sort.n2;

/**
 * 选择排序, 时间复杂度O(n²), 空间复杂度O(1), 不稳定
 *
 * 比冒泡排序快差不多6倍, 因为选择排序不需要一直交换, 一共只用交换n-1次
 */
public class SelectionSort {

    public static void sort(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            // 选出最小的index
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            // 交换i和最小的index
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }
    }
}
