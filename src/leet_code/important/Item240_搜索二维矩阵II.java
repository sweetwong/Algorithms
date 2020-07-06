package leet_code.important;

/**
 * todo 1. 理解这个方法（有点巧妙）
 * todo 2. 用其他算法实现
 */
class Item240_搜索二维矩阵II {

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;

        int m = matrix.length;
        int n = matrix[0].length;

        int i = m - 1;
        int j = 0;

        while (i >= 0 && j < n) {
            if (matrix[i][j] < target) {
                j++;
            } else if (matrix[i][j] > target) {
                i--;
            } else {
                return true;
            }
        }

        return false;
    }

}
