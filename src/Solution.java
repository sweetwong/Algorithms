import sort.MergeSort;
import sort.QuickSort;
import util.MyArray;
import util.TimeUtils;

import java.util.Arrays;

public class Solution {

  public static void main(String[] args) {
    int[] nums = MyArray.createRandomArrays(10000000);

    TimeUtils.watch(() -> MergeSort.sort(nums));
  }

}