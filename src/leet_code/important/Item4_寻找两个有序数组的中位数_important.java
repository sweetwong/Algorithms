package leet_code.important;

/**
 * 二分法的代表题
 *
 * 且要很好的区分, 第k个数和其下标nums[k-1]
 */
class Item4_寻找两个有序数组的中位数_important {

  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int len = nums1.length + nums2.length;
    // 中间偏左下标: (len - 1) / 2, 因此第(中间偏左的数): (len + 1) / 2
    int left = (len + 1) / 2;
    // 中间偏左下标: len / 2,       因此第(中间偏右的数): (len + 2) / 2
    int right = (len + 2) / 2;
    return (findKth(nums1, 0, nums2, 0, left) + findKth(nums1, 0, nums2, 0, right)) / 2.0;
  }

  /**
   * 在两个数组中, 起点分别为i何j, 拿到合并后第k小的数
   *
   * 原理是不停舍弃掉最小的部分变成新的数组, 来减小k
   * 但是为了减少空间复杂度, 通过标注start, 来指示被舍弃后的新数组
   *
   * 注意: 第k个数对应, nums[k-1], 如第1个数为nums[0]
   *
   * 易错点: 注意此处哪些是指第k个数, 哪些是指第k个数的下标
   */
  public static int findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
    // 终止条件, nums1以start1为起点的数组为空数组
    if (start1 >= nums1.length) return nums2[start2 + k - 1];
    // 终止条件, nums2以start2为起点的数组为空数组
    if (start2 >= nums2.length) return nums1[start1 + k - 1];
    // 终止条件, 求第一个数(既nums[start])
    if (k == 1) return Math.min(nums1[start1], nums2[start2]);

    int midVal1 = (start1 + k / 2 - 1 < nums1.length) ? nums1[start1 + k / 2 - 1] : Integer.MAX_VALUE;
    int midVal2 = (start2 + k / 2 - 1 < nums2.length) ? nums2[start2 + k / 2 - 1] : Integer.MAX_VALUE;

    if (midVal1 < midVal2) {
      return findKth(nums1, start1 + k / 2, nums2, start2, k - k / 2);
    } else {
      return findKth(nums1, start1, nums2, start2 + k / 2, k - k / 2);
    }
  }

}
