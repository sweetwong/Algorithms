package sort.nlogn;


/**
 * 堆排序, 时间复杂度O(nlogn), 空间复杂度O(1)(亮点), 不稳定, 原地算法
 *
 * 堆是一个近似完全二叉树的结构, 满足堆积的性质: 即子结点的键值或索引总是小于(或者大于)它的父节点
 *
 * 注意: 这里的堆排序空间复杂度并不是O(1), 因为是Java且用了递归, 这就有递归栈的空间复杂度
 * 可以把heapify转成迭代, 就没有递归的空间复杂度了
 *
 * heapify本身可以进行尾递归优化(Java不行), 如果是C语言即使写成递归, 空间复杂度也是O(1)
 *
 * 注意堆的几个运算：
 * n / 2 - 1 : 最后一个非叶子节点（最后一个有子节点的节点）
 * i * 2 + 1 : i的左子节点
 * i * 2 + 2 : i的右子节点
 * (i - 1) / 2 : i的父节点
 */
public class HeapSort {

    public static void sort(int[] nums) {
        int n = nums.length;

        // 构建大顶堆(注意大顶堆的性质)
        // 从最后一个非叶子结点开始, 构建一个大顶堆, 根据堆的性质: 即子结点的键值或索引总是小于(或者大于)它的父节点
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(nums, i, n);
        }

        // 排序, 永远从根节点开始排
        for (int i = n - 1; i >= 0; i--) {
            // 将当前根移动到尾部
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }

    }

    /**
     * 堆化
     *
     * 从start点开始，一直到length为终点
     * 如果发现start不是最大的，则交换，并从子节点开始继续堆化
     *
     * 注意：此处的max，parent，left，right指的都是数组索引
     *
     * @param nums  输入的数组, 一直不变
     * @param n     当前堆的大小
     * @param parent 起始节点
     */
    private static void heapify(int[] nums, int parent, int n) {
        // 当 n == length，n / 2为数组中间偏右
        // 从最后一个非叶子节点开始计算
        while (parent <= n / 2 - 1) {
            // 指向左子树
            int child = 2 * parent + 1;
            // 判断左子树的合理性，找到左右子树更大的
            if (child < n - 1 && nums[child] < nums[child + 1]) child++;
            // 比较父节点和子节点，当父节点比较大时，终止堆化
            if (nums[parent] >= nums[child]) break;
            // 交换父子节点
            swap(nums, parent, child);
            // 向下推进
            parent = child;
        }

    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    /**
     * 堆化
     *
     * 从start点开始, 一直到length为终点
     * 如果发现start不是最大的, 则交换, 并从子节点开始继续堆化
     *
     * 注意: 此处的max, start, left, right指的都是数组索引
     *
     * @param nums  输入的数组, 一直不变
     * @param n     当前堆的大小
     * @param start 起始节点
     */
    private static void heapifyIte(int[] nums, int start, int n) {
        // 当前(current)节点的位置
        int curr = start;
        // left左孩子，left + 1右孩子
        int left = 2 * start + 1;

        for (; left < n; curr = left, left = 2 * left + 1) {
            // 选择左右孩子较大者
            if (left < n - 1 && nums[left] < nums[left + 1])
                left++;
            // 当前节点是最大的
            if (nums[curr] >= nums[left]) {
                break;
            }
            // 当前结点比左右孩子的较大者小
            else {
                // 交换
                swap(nums, curr, left);
            }
        }

    }

    /**
     * 堆化
     *
     * 从start点开始, 一直到length为终点
     * 如果发现start不是最大的, 则交换, 并从子节点开始继续堆化
     *
     * 注意: 此处的max, start, left, right指的都是数组索引
     *
     * @param nums  输入的数组, 一直不变
     * @param n     当前堆的大小
     * @param start 起始节点
     */
    private static void heapifyRecursive(int[] nums, int start, int n) {
        int max = start;

        int left = 2 * start + 1;
        int right = 2 * start + 2;

        if (left < n && nums[left] > nums[max]) max = left;
        if (right < n && nums[right] > nums[max]) max = right;

        if (max != start) {
            swap(nums, start, max);
            heapifyRecursive(nums, max, n);
        }
    }

}