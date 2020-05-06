import sort.nlogn.QuickSort;
import util.array.ArrayUtils;
import util.other.Time;

class Solution {

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int[] nums = ArrayUtils.createRandomArray(20000000);
            Time.watch(() -> QuickSort.sort(nums));
        }
    }

}