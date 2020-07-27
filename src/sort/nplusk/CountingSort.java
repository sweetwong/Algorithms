package sort.nplusk;

import data_structure.array.ArrayUtils;
import data_structure.other.Time;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/counting-sort/
 *
 */
class CountingSort {

    public static void sort(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;

        int max = Arrays.stream(nums).max().getAsInt();
        int min = Arrays.stream(nums).min().getAsInt();
        int range = max - min + 1;
        int[] count = new int[range];
        int[] output = new int[n];
        for (int num : nums) {
            count[num - min]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            output[count[nums[i] - min] - 1] = nums[i];
            count[nums[i] - min]--;
        }

        System.arraycopy(output, 0, nums, 0, n);
    }

    public static void main(String[] args) {
        int[] nums = ArrayUtils.createRandomArray(100000000, 100000, false);
        Time.watch(() -> CountingSort.sort(nums));
        ArrayUtils.checkSorted(nums);
    }
}

