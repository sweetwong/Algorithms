package search.binary;

/**
 * @see leet_code.important.Item4_寻找两个有序数组的中位数
 * @see leet_code.important.Item33_搜索旋转排列数组
 * @see leet_code.important.Item34_在排序数组中查找元素的第一个和最后一个位置_方法一
 * @see leet_code.important.Item34_在排序数组中查找元素的第一个和最后一个位置_方法二
 * @see leet_code.important.Item35_搜索插入位置
 * @see leet_code.important.Item240_搜索二维矩阵II
 * @see leet_code.Item287_寻找重复数
 * @see leet_code.Item300_最长上升子序列_二分查找
 * @see leet_code.Item378_有序矩阵中第K小的元素
 *
 * 写对二分查找不能靠模板，需要理解加练习 （附练习题，持续更新）
 * https://leetcode-cn.com/problems/search-insert-position/solution/te-bie-hao-yong-de-er-fen-cha-fa-fa-mo-ban-python-/
 */
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
            // 此处即使mid越界, 使用位运算依然正确
            int mid = lo + hi >>> 1;
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
     * 搜索插入的位置
     *
     * @param nums 一个排序数组
     * @param target 要插入的数
     * @return 应该插入的位置
     */
    public static int binarySearchInsertRight(int[] nums, int target) {
        // 需要处理 target > nums[nums.length - 1] 的情况

        // lo和hi的起始值也是可以变的，看边界情况
        int lo = 0;
        int hi = nums.length - 1;
        // 退出循环时，lo == hi，因此无需考虑返回lo还是hi
        // 不能是lo <= hi， 否则在else中进入死循环
        while (lo < hi) {
            // 这种情况中位数的取法也会变
            int mid = lo + hi >>> 1;
            // 这里是二分查找的核心，需要处理好边界问题
            int midVal = nums[mid];
            if (midVal < target) {
                lo = mid + 1;
            }
            // nums[mid] >= target 的情况
            // 此处需要斟酌等于是合并到左边还是右边
            else {
                hi = mid;
            }
        }
        return lo;
    }

    public static int binarySearchInsertLeft(int[] nums, int target) {
        // 需要处理 target < nums[0] 的情况

        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            int mid = lo + hi + 1 >>> 1;
            int midVal = nums[mid];
            if (midVal > target) {
                hi = mid - 1;
            } else {
                lo = mid;
            }
        }
        return lo;
    }


    /**
     * 二分查找, 递归法
     *
     * 当然只是列举下, 当然是不能使用的
     * 没必要增加无谓的空间复杂度
     */
    private static int binarySearch(int[] nums, int lo, int hi, int target) {
        if (lo <= hi) {
            int mid = lo + hi >>> 1;
            if (nums[mid] < target) {
                return binarySearch(nums, mid + 1, hi, target);
            } else if (nums[mid] > target) {
                return binarySearch(nums, lo, mid - 1, target);
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearchTest.test(BinarySearch::binarySearch);
        BinarySearchTest.test(BinarySearch::binarySearchInsertLeft);
        BinarySearchTest.test(BinarySearch::binarySearchInsertRight);
    }

}