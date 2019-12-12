package search.binary;

import util.Array;
import util.Time;

import java.util.Arrays;

public class BinarySearch {

  /**
   * 二分查找, 迭代法, 推荐使用, 空间复杂度为O(1)
   */
  public static int binarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    int mid;
    // 必须是<=, 不能是<
    while (low <= high) {
      // 关键
      // 也可以写 mid = low + (high - low) / 2
      // >>>是无符号右移, 高位都补零, 如果是负数会变成正数, 效率比>>高? 但是数组索引只能正数
      mid = low + ((high - low) >>> 1);
      if (arr[mid] > target) {
        high = mid - 1;
      } else if (arr[mid] < target) {
        low = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  /**
   * 二分查找, 递归法
   */
  public static int binarySearch(int[] arr, int low, int high, int target) {
    if (low <= high) {
      int mid = low + ((high - low) >>> 1);
      if (arr[mid] > target) {
        return binarySearch(arr, low, mid - 1, target);
      } else if (arr[mid] < target) {
        return binarySearch(arr, mid + 1, high, target);
      } else {
        return mid;
      }
    }
    return -1;
  }


}