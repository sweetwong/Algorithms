package sort.nplusk;

import data_structure.array.ArrayUtils;
import data_structure.other.Time;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/radix-sort/
 */
class RadixSort {

    public static void sort(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;

        // 找出最大的数, 用来确定最高的位数
        int max = Arrays.stream(nums).max().getAsInt();

        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(nums, n, exp);
        }
    }

    // A function to do counting sort of nums[] according to
    // the digit represented by exp.
    private static void countSort(int[] nums, int n, int exp) {
        // 输出的结果
        int output[] = new int[n];
        // 0到9共10个数
        int count[] = new int[10];

        // Store count of occurrences in count[]
        for (int i = 0; i < n; i++) {
            count[(nums[i] / exp) % 10]++;
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        // Build the output array
        for (int i = n - 1; i >= 0; i--) {
            output[count[(nums[i] / exp) % 10] - 1] = nums[i];
            count[(nums[i] / exp) % 10]--;
        }

        // Copy the output array to nums[], so that nums[] now
        // contains sorted numbers according to curent digit
        System.arraycopy(output, 0, nums, 0, n);
    }

    /*Driver function to check for above function*/
    public static void main(String[] args) {
        int[] nums = ArrayUtils.createRandomArray(100000, 10000, true);
        Time.watch(() -> sort(nums));
        ArrayUtils.checkSorted(nums);
    }
}
