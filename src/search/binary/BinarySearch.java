package search.binary;

public class BinarySearch {

    /**
     * 二分查找, 迭代法, 空间复杂度为O(1)
     *
     * 注意: 二分法主要体现的是二分的思想, 具体实现有N种变种, 例如
     * 1. 由index二分变为value二分, 通常情况是index二分, 例如模板方法, 有些情况会用value二分, 例如力扣Item378
     * 2. 比较条件可以是任何情况, 不要被约束在模板的几种情况
     * 3. 最外层的循环有时候可能会是lo < hi
     * 4. 不一定是在循环中return mid, 有些二分法是查找值直接返回, 例如下面的模板; 有些二分法是为了找到边界, 此时需要遍历到底
     */
    public static int binarySearch(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;
        // 必须是<=, 不能是<
        // 如果是写成lo < hi, 当只剩最后两个数, lo指向左边的, hi指向右边的, 而target是右边的数, 会找不到结果, 例如[1, 2], target为2
        while (lo <= hi) {
            // 关键
            // 也可以写 mid = lo + (hi - lo) / 2
            // >>>是无符号右移, 高位都补零, 如果是负数会变成正数, 效率比>>高? 但是数组索引只能正数, >>>必须要加括号
            // mid取的是中间偏左!!!的数
            int mid = lo + ((hi - lo) >>> 1);
            if (nums[mid] < target) {
                lo = mid + 1;
            } else if (nums[mid] > target) {
                hi = mid - 1;
            } else {
                return mid;
            }
        }

        // 结束条件: lo > hi
        return -1;
    }

    /**
     * 二分查找, 递归法
     *
     * 当然只是列举下, 当然是不能使用的
     * 没必要增加无谓的空间复杂度
     */
    public static int binarySearch(int[] arr, int lo, int hi, int target) {
        if (lo <= hi) {
            int mid = lo + ((hi - lo) >>> 1);
            if (arr[mid] < target) {
                return binarySearch(arr, mid + 1, hi, target);
            } else if (arr[mid] > target) {
                return binarySearch(arr, lo, mid - 1, target);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{1, 2}, 2));
    }


}