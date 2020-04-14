package sort.n2;

/**
 * 插入排序, 时间复杂度O(n²), 最好情况是O(n)(亮点), 空间复杂度O(1), 稳定, O(n²)中最快的排序
 *
 * 注意, 插入排序在数组相对有序时很快, 最快能达到线性的时间复杂度, 希尔排序就是利用了这个特点
 */
public class InsertionSort {

    public static void sort(int[] nums) {
//    // 此处长度0和1都成立
//    if (nums.length <= 1) return;

        // 从第二个数开始遍历
        for (int i = 1; i < nums.length; i++) {
            // 把当前的值保存下来
            int curr = nums[i];

            // 前指针指向前一个数
            int j = i - 1;
            // 当指针处于有效范围, 且当前的值小于前指针所指的值(此处只能是>不能是>=, 否则就不稳定了)
            // 记住这个条件
            while (j >= 0 && nums[j] > curr) {
                // 指针所指的值前挪
                nums[j + 1] = nums[j];
                j--;
            }
            // 当上述条件不再满足,存储当前的值
            // 有两种情况:
            // 1. 当前的值为最小的值, preIndex变成-1, nums[0] = curr
            // 2. 当前值不是最小的值, preIndex是中间值, nums[j + 1] = curr
            nums[j + 1] = curr;
        }
    }

}
