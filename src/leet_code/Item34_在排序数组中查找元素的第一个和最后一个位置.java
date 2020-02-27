package leet_code;

import java.util.Arrays;

class Item34_在排序数组中查找元素的第一个和最后一个位置 {

  public int[] searchRange(int[] nums, int target) {
    int[] res = new int[2];
    res[0] = searchBound(nums, target, true);
    res[1] = searchBound(nums, target, false);
    return res;
  }

  public int searchBound(int[] nums, int target, boolean left) {
    int lo = 0;
    int hi = nums.length - 1;
    int res = -1;
    while (lo <= hi) {
      int mid = lo + ((hi - lo) >>> 1);
      int midVal = nums[mid];
      if (midVal < target) {
        lo = mid + 1;
      } else if (midVal > target) {
        hi = mid - 1;
      } else {
        res = mid;
        if (left) {
          hi = mid - 1;
        } else {
          lo = mid + 1;
        }
      }
    }
    return res;
  }

  public static void main(String[] args) {
    Item34_在排序数组中查找元素的第一个和最后一个位置 a = new Item34_在排序数组中查找元素的第一个和最后一个位置();
    System.out.println(Arrays.toString(a.searchRange(new int[]{2, 2}, 2)));
  }


}
