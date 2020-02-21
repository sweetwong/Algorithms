package search.binary;

public class BinarySearch {

  /**
   * 二分查找, 迭代法, 推荐使用, 空间复杂度为O(1)
   */
  public static int binarySearch(int[] arr, int target) {
    int lo = 0;
    int hi = arr.length - 1;
    // 必须是<=, 不能是<
    // 如果是<, 对于在[0,1]中寻找1, 会返回-1
    // 当low == hi, 是最后一个解
    while (lo <= hi) {
      // 关键
      // 也可以写 mid = lo + (hi - lo) / 2
      // >>>是无符号右移, 高位都补零, 如果是负数会变成正数, 效率比>>高? 但是数组索引只能正数, >>>必须要加括号
      // mid取的是中间偏左的数
      int mid = lo + ((hi - lo) >>> 1);
      if (arr[mid] < target) {
        lo = mid + 1;
      } else if (arr[mid] > target) {
        hi = mid - 1;
      } else {
        return mid;
      }
    }

    // 结束条件: lo > hi
    return -1;
  }

  /**
   * 二分查找, 递归法
   */
  public static int binarySearch(int[] arr, int lo, int hi, int target) {
    if (lo <= hi) {
      int mid = lo + ((hi - lo) >>> 1);
      if (arr[mid] < target) {
        return binarySearch(arr, mid + 1, hi, target);
      } else if (arr[mid] > target) {
        return binarySearch(arr, lo, mid - 1, target);
      } else {
        return mid;
      }
    }
    return -1;
  }


}