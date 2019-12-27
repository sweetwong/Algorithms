package leet_code;

/**
 *
 * Median of Two Sorted Arrays
 */
class Item4 {

  public static void main(String[] args) {
    System.out.print(findMedianSortedArrays1(new int[]{1, 2}, new int[]{3, 4}));
  }

  /**
   * 时间复杂度: O(n) = m+n
   */
  public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length + nums2.length;
    int[] nums = new int[n];
    for (int i = 0, l = 0, r = 0; i < n; i++) {
      if (l >= nums1.length) nums[i] = nums2[r++];
      else if (r >= nums2.length) nums[i] = nums1[l++];
      else if (nums1[l] > nums2[r]) nums[i] = nums2[r++];
      else nums[i] = nums1[l++];
    }
    if (n == 0) return 0;
    if (n == 1) return nums[0];
    if (n % 2 == 0) return ((double) nums[n / 2] + (double) nums[n / 2 - 1]) / 2;
    else return nums[n / 2];
  }

  public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {
    int n = nums1.length + nums2.length;
    int[] nums = new int[n];
    if (n == 0) return 0;
    if (n == 1) {
      if (nums1.length == 1) return nums1[0];
      if (nums2.length == 1) return nums2[0];
    }
    int middleIndex = n / 2;
    boolean isEven = n % 2 == 0;
    for (int i = 0, l = 0, r = 0; i < n; i++) {
      if (l >= nums1.length) nums[i] = nums2[r++];
      else if (r >= nums2.length) nums[i] = nums1[l++];
      else if (nums1[l] > nums2[r]) nums[i] = nums2[r++];
      else nums[i] = nums1[l++];
      if (i == middleIndex) {
        if (isEven) return ((double) nums[i - 1] + (double) nums[i]) / 2;
        else return nums[i];
      }
    }
    return 0;
  }

}
