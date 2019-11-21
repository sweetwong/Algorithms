import sort.QuickSort;
import util.MyArray;
import util.TimeUtils;

public class Solution {

  public static void main(String[] args) {
    int[] nums = MyArray.createRandomArrays(10000000);
    TimeUtils.watch(() -> QuickSort.sort(nums));
  }

}