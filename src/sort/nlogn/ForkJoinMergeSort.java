package sort.nlogn;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinMergeSort {

    public static void sort(int[] nums) {
        new ForkJoinPool(Runtime.getRuntime().availableProcessors())
                .invoke(new FJMergeSortTask(nums));
    }

    static class FJMergeSortTask extends RecursiveAction {

        static final int THRESHOLD = 1 << 13;

        int[] nums;

        FJMergeSortTask(int[] nums) {
            this.nums = nums;
        }

        @Override
        protected void compute() {
            if (nums.length <= THRESHOLD) {
                mergeSort(nums);
                return;
            }
            int mid = nums.length / 2;
            int[] left = Arrays.copyOfRange(nums, 0, mid);
            int[] right = Arrays.copyOfRange(nums, mid, nums.length);
            invokeAll(new FJMergeSortTask(left),new FJMergeSortTask(right));
            merge(nums, left, right);
        }

        void mergeSort(int[] nums) {
            if (nums.length <= 1) return;
            int mid = nums.length / 2;
            int[] left = Arrays.copyOfRange(nums, 0, mid);
            int[] right = Arrays.copyOfRange(nums, mid, nums.length);
            mergeSort(left);
            mergeSort(right);
            merge(nums, left, right);
        }

        void merge(int[] nums, int[] left, int[] right) {
            for (int i = 0, l = 0, r = 0; i < nums.length; i++) {
                if (l >= left.length)
                    nums[i] = right[r++];
                else if (r >= right.length)
                    nums[i] = left[l++];
                else if (left[l] <= right[r])
                    nums[i] = left[l++];
                else
                    nums[i] = right[r++];
            }
        }
    }

}
