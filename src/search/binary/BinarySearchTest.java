package search.binary;

import data_structure.array.ArrayUtils;

import java.util.concurrent.*;

public class BinarySearchTest {

    public static void test(IBinarySearch iBinarySearch) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Future<?> future = executor.submit(() -> {
            int[] nums1 = {10};
            if (iBinarySearch.search(nums1, 10) != 0) {
                System.out.println("error 1");
                return;
            }
            int[] nums2 = {10, 20};
            if (iBinarySearch.search(nums2, 10) != 0) {
                System.out.println("error 2");
                return;
            }
            if (iBinarySearch.search(nums2, 20) != 1) {
                System.out.println("error 3");
                return;
            }

            for (int i = 0; i < 10; i++) {
                int n = 1 + (int) (1000 * Math.random());
                int[] nums = ArrayUtils.createNotRepeatSortedRandomArray(1000);
                int randomIndex = (int) (n * Math.random());
                int target = nums[randomIndex];
                if (iBinarySearch.search(nums, target) != randomIndex) {
                    System.out.println("error");
                    return;
                }
            }

            System.out.println("right");
        });

        try {
            future.get(2, TimeUnit.SECONDS);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error 4");
        }
    }

    public interface IBinarySearch {
        int search(int[] nums, int target);
    }

    public static void main(String[] args) {
        BinarySearchTest.test(BinarySearch::binarySearchInsertLeft);
    }

}
