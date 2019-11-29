package search.binary;

import util.Array;

import java.util.Arrays;

public class BinarySearch {

  public static void main(String[] args) {
    int[] arr = new int[]{0, 10, 20, 30, 40, 50, 60};
    System.out.println(binarySearch(arr, 50));
  }

  public static int binarySearch(int[] arr, int target) {
    int min = 0;
    int max = arr.length - 1;
    int mid;
    while (min <= max) {
      // 关键
      // 也可以写 mid = min + (max - min) / 2

      // >>>是无符号右移, 高位都补零, 如果是负数会变成正数, 效率比>>高? 但是数组索引只能正数
      mid = min + ((max - min) >>> 1);
      if (arr[mid] > target) {
        max = mid - 1;
      } else if (arr[mid] < target) {
        min = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

}