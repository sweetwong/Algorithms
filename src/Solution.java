import sort.nlogn.HeapSort;
import sort.nlogn.MergeSort;
import sort.nlogn.QuickSort;
import util.ArrayUtils;
import util.Time;

import java.util.Arrays;

class Solution {

  public static void main(String[] args) {

    for (int i = 0; i < 5; i++) {

      int[] nums1 = ArrayUtils.createRandomArrays(10000000);
      System.out.println("归并排序");
      Time.watch(() -> MergeSort.sort(nums1));

      int[] nums2 = ArrayUtils.createRandomArrays(10000000);
      System.out.println("快速排序");
      Time.watch(() -> QuickSort.sort(nums2));

      int[] nums3 = ArrayUtils.createRandomArrays(10000000);
      System.out.println("堆排序");
      Time.watch(() -> HeapSort.sort(nums3));

      int[] nums4 = ArrayUtils.createRandomArrays(10000000);
      System.out.println("系统排序");
      Time.watch(() -> Arrays.sort(nums4));

      System.out.println();
    }

  }
}