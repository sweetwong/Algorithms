package leet_code.important;

class Item33_搜索旋转排列数组 {

  /**
   * 在二分法的基础上加了拓展
   */
  public static int search(int[] nums, int target) {
    if (nums.length == 0) return -1;

    int lo = 0, hi = nums.length - 1;
    int last = nums[hi];

    while (lo <= hi) {
      int mid = lo + ((hi - lo) >>> 1);
      int midVal = nums[mid];

      // 题目强调了, 没有重复项, 不然这个大于的判断有问题
      boolean sameSide = (target > last && midVal > last) || (target <= last && midVal <= last);

      if (midVal < target) {
        if (sameSide) {
          lo = mid + 1;
        }
        // 如果不在同一边, 则反过来
        else {
          hi = mid - 1;
        }
      } else if (midVal > target) {
        if (sameSide) {
          hi = mid - 1;
        }
        // 如果不在同一边, 则反过来
        else {
          lo = mid + 1;
        }
      } else {
        return mid;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {4, 5, 6, 7, -1, 0, 1, 2, 3};
    System.out.println(search(nums, 4));
  }

}
