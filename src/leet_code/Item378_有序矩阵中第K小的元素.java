package leet_code;

class Item378_有序矩阵中第K小的元素 {

    // todo 这个还有点混淆, 抽时间康康
    public int kthSmallest(int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int low = matrix[0][0];
        int high = matrix[m - 1][n - 1];

        while (low < high) {
            // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
            int mid = low + ((high - low) >>> 1);
            // 找到所有小于或等于mid的元素的个数
            int count = findNotBiggerThanMid(matrix, mid, m, n);

            // todo
            System.out.println("low = " + low + ", high = " + high + ", mid = " + mid + ", count = " + count + ", k = " + k);

            if (count < k) {
                // 第k小的数在右半部分，且不包含mid
                low = mid + 1;
            } else {
                // 第k小的数在左半部分，可能包含mid
                high = mid;
            }

        }
        return high;
    }

    private int findNotBiggerThanMid(int[][] matrix, int mid, int m, int n) {
        // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
        int i = m - 1;
        int j = 0;
        int count = 0;
        while (i >= 0 && j < n) {
            if (matrix[i][j] <= mid) {
                // 第j列有i+1个元素<=mid
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
        System.out.println(a.kthSmallest(matrix, 6));
    }


}
