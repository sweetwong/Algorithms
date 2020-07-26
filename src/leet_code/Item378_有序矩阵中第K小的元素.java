package leet_code;

/**
 * 给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。
 * 请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。
 *
 * 示例：
 *
 * matrix = [
 *    [ 1,  5,  9],
 *    [10, 11, 13],
 *    [12, 13, 15]
 * ],
 * k = 8,
 *
 * 返回 13。
 *  
 * 提示：
 * 你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。
 */
class Item378_有序矩阵中第K小的元素 {

    /**
     * 用二分法时, 注意区分数组索引和数值, 像此题, 我用middle表示数值, 如果是数组索引就用mid表示
     */
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[m - 1][n - 1];

        int res = 0;

        while (low <= high) {
            // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
            int middle = low + ((high - low) >>> 1);
            // 找到所有小于或等于mid的元素的个数
            int count = findNotBiggerThanMid(matrix, middle, m, n);

            if (count < k) {
                // 第k小的数在右半部分，且不包含mid
                low = middle + 1;
            } else {
                // 第k小的数在左半部分，可能包含mid
                res = middle;
                high = middle - 1;
            }

        }
        return res;
    }

    /**
     * 这个方法完美利用到了升序矩阵的特性
     *  {1,  5,  9}
     *  {10, 11, 13}
     *  {12, 13, 15}
     */
    private int findNotBiggerThanMid(int[][] matrix, int middle, int m, int n) {
        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=middle
        int i = m - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= middle) {
                // 第j列有i+1个元素<=middle
                count += i + 1;
                j++;
            } else {
                // 第j列目前的数大于mid，需要继续在当前列往上找
                i--;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        Item378_有序矩阵中第K小的元素 a = new Item378_有序矩阵中第K小的元素();
        System.out.println(a.kthSmallest(matrix, 8));
    }


}
