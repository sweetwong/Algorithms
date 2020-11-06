package sort.nlogn;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinQuickSort {

    public static void sort(int[] nums) {
        new ForkJoinPool(Runtime.getRuntime().availableProcessors())
                .invoke(new FJQuickSortTask(nums, 0, nums.length - 1));
    }

    static class FJQuickSortTask extends RecursiveAction {

        static final int INSERTION_SORT_THRESHOLD = 47;
        static final int QUICK_SORT_THRESHOLD = 1 << 13;

        int[] nums;
        int lo;
        int hi;

        FJQuickSortTask(int[] nums, int lo, int hi) {
            this.nums = nums;
            this.lo = lo;
            this.hi = hi;
        }

        @Override
        protected void compute() {
            if (hi - lo <= INSERTION_SORT_THRESHOLD) {
                insertionSort(nums, lo, hi);
                return;
            }

            if (hi - lo <= QUICK_SORT_THRESHOLD) {
                quickSort(nums, lo, hi);
                return;
            }

            int p = partition(nums, lo, hi);
            invokeAll(new FJQuickSortTask(nums, lo, p - 1),
                    new FJQuickSortTask(nums, p + 1, hi));
        }

        static void insertionSort(int[] nums, int lo, int hi) {
            for (int i = lo + 1; i <= hi; i++) {
                int curr = nums[i];
                int j;
                for (j = i - 1; j >= 0 && nums[j] > curr; j--) {
                    nums[j + 1] = nums[j];
                }
                nums[j + 1] = curr;
            }
        }

        void quickSort(int[] nums, int lo, int hi) {
            if (lo < hi) {
                int p = partition(nums, lo, hi);
                quickSort(nums, lo, p - 1);
                quickSort(nums, p + 1, hi);
            }
        }

        int partition(int[] nums, int lo, int hi) {
            int random = (int) (lo + (System.nanoTime() & (hi - lo)));
            swap(nums, random, hi);
            int pivot = nums[hi];
            int i = lo;
            for (int j = lo; j < hi; j++) {
                if (nums[j] < pivot) {
                    swap(nums, i, j);
                    i++;
                }
            }
            swap(nums, i, hi);
            return i;
        }

        void swap(int[] nums, int i, int j) {
            int tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
        }

    }

}
