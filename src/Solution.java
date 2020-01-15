import sort.nlogn.QuickSort;
import util.array.ArrayUtils;
import util.TimeWatcher;

class Solution {

  public static void main(String[] args) {
    int[] nums = ArrayUtils.createRandomArray(10000000);
    TimeWatcher.watch(() -> QuickSort.sort(nums));
    TimeWatcher.watch(() -> QuickSort.sort(nums));
  }

}