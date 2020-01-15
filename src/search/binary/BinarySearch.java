package search.binary;

public class BinarySearch {

  public static void main(String[] args) {
    int[] arr = new int[]{0, 1};
    System.out.println(binarySearch(arr, 0));
  }

  /**
   * 二分查找, 迭代法, 推荐使用, 空间复杂度为O(1)
   */
  public static int binarySearch(int[] arr, int target) {
    int low = 0;
    int high = arr.length - 1;
    // 必须是<=, 不能是<
    // 如果是<, 对于在[0,1]中寻找1, 会返回-1
    while (low <= high) {
      // 关键
      // 也可以写 mid = low + (high - low) / 2
      // >>>是无符号右移, 高位都补零, 如果是负数会变成正数, 效率比>>高? 但是数组索引只能正数, >>>必须要加括号
      // mid取的是中间偏左的数
      int mid = low + ((high - low) >>> 1);
      if (arr[mid] < target) {
        low = mid + 1;
      } else if (arr[mid] > target) {
        high = mid - 1;
      } else {
        return mid;
      }
    }

    // 结束条件: low > high
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