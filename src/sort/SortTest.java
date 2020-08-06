package sort;

import data_structure.array.ArrayUtils;
import data_structure.other.Time;

public class SortTest {

    public static void test(Sortable sortable) {
        int length = 10000;
        for (int i = 0; i < 6; i++) {
            System.out.println("length = " + length);
            int[] nums = ArrayUtils.createRandomArray(length);
            Time.watch(() -> sortable.sort(nums));
            ArrayUtils.checkSorted(nums);
            System.out.println();
            length = length * 10;
        }
    }

    public interface Sortable {
        void sort(int[] nums);
    }

}
