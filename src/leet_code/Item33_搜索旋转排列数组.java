package leet_code;

class Item33_搜索旋转排列数组 {

  public static void main(String[] args) {
    int[] nums = {4, 5, 6, 7, 0, 1, 2};
    System.out.println(search(nums, 4));
  }

  /**
   * 在二分法的基础上加了拓展
   */
  public static int search(int[] nums, int target) {
    if (nums.length == 0) return -1;

    int lo = 0, hi = nums.length - 1;
    int last = nums[hi];

    while (lo <= hi) {
      int mid = lo + ((hi - lo) >>> 1);
      int val = nums[mid];
      boolean sameSide = (target > last && val > last) || (target <= last && val <= last);

      if (val < target) {
        if (sameSide) {
          lo = mid + 1;
        } else {
          hi = mid - 1;
        }
      } else if (val > target) {
        if (sameSide) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      } else {
        return mid;
      }
    }
    return -1;
  }

}
