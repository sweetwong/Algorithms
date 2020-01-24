import sort.nlogn.QuickSort;
import util.TimeWatcher;
import util.array.ArrayUtils;

class Solution {

  public static void main(String[] args) {
    for (int i = 0; i < 5; i++) {
      int[] nums = ArrayUtils.createRandomArray(10000000);
      TimeWatcher.watch(() -> QuickSort.sort(nums));
      TimeWatcher.watch(() -> QuickSort.sort(nums));
      System.out.println();
    }
  }
}