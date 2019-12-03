package sort;

/**
 * 插入排序, 稳定, O(n²)中最快的排序
 */
public class InsertionSort {

  public static void sort(int[] nums) {
    if (nums.length <= 1) return;

    // 从第二个数开始遍历
    for (int i = 1; i < nums.length; i++) {
      // 把当前的值保存下来
      int curr = nums[i];

      // 前指针指向前一个数
      int preIndex = i - 1;
      // 当指针处于有效范围, 且当前的值小于前指针所指的值(此处只能是>不能是>=, 否则就不稳定了)
      while (preIndex >= 0 && nums[preIndex] > curr) {
        // 指针所指的值前挪
        nums[preIndex + 1] = nums[preIndex];
        preIndex--;
      }
      // 当上述条件不再满足,存储当前的值
      // 有两种情况:
      // 1. 当前的值为最小的值, preIndex变成-1, nums[0] = curr
      // 2. 当前值不是最小的值, preIndex是中间值, nums[preIndex + 1] = curr
      nums[preIndex + 1] = curr;
    }
  }

}
