package sort.nlogn;

import data_structure.array.ArrayUtils;
import data_structure.other.Time;

/**
 * 快速排序, 时间复杂度O(nlogn), 最坏情况为O(n²), 通过取随机中枢可以将最坏情况优化到O(nlogn)
 * 空间复杂度O(logn), 递归栈的深度为logn, 不稳定, 最快的排序方法之一, 原地算法
 *
 * 算法思想: 快慢指针, 分治法, 原地算法
 */
public class QuickSort {

    /**
     * 模拟Arrays.sort()接口
     */
    public static void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int lo, int hi) {
        // 当lo == hi, quickSort(nums, lo, lo)没有任何意义
        // 因此终止条件是lo >= hi
        if (lo < hi) {
            // 先分区,然后返回分区的索引
            int p = partition(nums, lo, hi);
            // 左边快排
            quickSort(nums, lo, p - 1);
            // 右边快排
            quickSort(nums, p + 1, hi);
        }
    }

    /**
     * 快速排序的最坏时间复杂度为O(n²), 通过取随机数可以将最坏情况优化到O(nlogn)
     * 最坏情况什么时候会出现? 当选取边界为枢纽, 以下情况可能会导致最坏情况
     * 1. 数组已经按照正序排序
     * 2. 数组已经按照倒序排序
     * 3. 数组中所有的数都相等
     * 4. 或者有大量重复元素或者顺序相对较整齐(不够混乱), 也会降低其效率
     */
    private static int partition(int[] nums, int lo, int hi) {

        // 解决O(n²)问题的方案(不是完全解决, 是尽最大可能解决, 运气最差是还是O(n²))
        // 随机在数组中取一个数, 然后与最后一个数进行交换
        int random = lo + (int) ((hi - lo) * Math.random());
        swap(nums, random, hi);

        // 选出最后一个值作为基准, 实质上是之前取得随机数
        int pivot = nums[hi];

        // i是慢指针, i的一边是指小于pivot的数
        int i = lo;
        // j是快指针, 从lo遍历到hi, 注意此处是j < hi, 既不包括最后一个数
        for (int j = lo; j < hi; j++) {
            // 如果nums[j]小于基准, 分到左边的区
            // 如果nums[j]大于等于基准, 分到右边的区(保持原位即可)
            // 此处取 < 或者 <= 都可以, 不过取<可以减少运算次数
            if (nums[j] < pivot) {
                // 交换i和j的位置
                swap(nums, i, j);

                i++;
            }
        }
        swap(nums, i, hi);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 对象的快排, 来演示其不稳定性
     */
    public static <T extends Comparable<T>> void sort(T[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static <T extends Comparable<T>> void quickSort(T[] arr, int lo, int hi) {
        if (lo < hi) {
            int p = partition(arr, lo, hi);
            quickSort(arr, lo, p - 1);
            quickSort(arr, p + 1, hi);
        }
    }

    private static <T extends Comparable<T>> int partition(T[] arr, int lo, int hi) {
        int random = lo + (int) ((hi - lo) * Math.random());
        swap(arr, random, hi);
        T pivot = arr[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, hi);
        return i;
    }

    private static <T extends Comparable<T>> void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            int[] nums = ArrayUtils.createRandomArray(10000000);
            Time.watch(() -> sort(nums));
            Time.watch(() -> sort(nums));
            System.out.println();
        }
    }

}
