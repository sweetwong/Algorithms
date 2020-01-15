import sort.nlogn.QuickSort;
import util.ArrayUtils;
import util.Time;

class Solution {

  public static void main(String[] args) {
    int[] nums = ArrayUtils.createRandomArrays(10000000);
    Time.watch(() -> QuickSort.sort(nums));
    Time.watch(() -> QuickSort.sort(nums));
  }

}