package sort;

import data_structure.array.Arrays;
import data_structure.other.Time;

public class SortTest {

    public static void test(Sortable sortable) {
        int length = 0;
        for (int i = 0; i < 8; i++) {
            System.out.println("length = " + length);
            int[] nums = Arrays.createRandomArray(length);
            Time.watch(() -> sortable.sort(nums));
            Arrays.checkSorted(nums);
            System.out.println();
            length *= 10;
            if (i == 0) length += 10;
        }
    }

    public static void test(Sortable sortable, int n) {
        int[] nums = Arrays.createRandomArray(n);
        Time.watch(() -> sortable.sort(nums));
        Arrays.checkSorted(nums);
    }


    public interface Sortable {
        void sort(int[] nums);
    }

}
