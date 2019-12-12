package leet_code;

class Item33 {

  public static void main(String[] args) {
    int[] nums1 = {0, 1, 2, 3, 4};
    int[] nums2 = {4, 0, 1, 2, 3};
    int[] nums3 = {1, 2, 3, 4, 0};

    System.out.println(search(nums1, 15));
  }

  // [4,5,6,7,0,1,2]
  public static int search(int[] nums, int target) {
    int low = 0;
    int high = nums.length - 1;

    while (low <= high) {
      int mid = low + ((high - low) >>> 1);
      if (nums[mid] == target) return mid;

      // 反常情况
      if (nums[mid] > nums[mid + 1]) {
        if (target > nums[0]) {
        }
      }
      if (target < nums[mid]) {
        high = mid - 1;
      } else if (target > nums[mid]) {
        low = mid + 1;
      } else
        return mid;
    }
    return -1;
  }


}
