package leet_code;

import data_structure.array.ArrayUtils;

class Item48_旋转图像 {

    public static void rotate(int[][] matrix) {
        int n = matrix.length;
        // 按层遍历
        for (int i = 0; i < n / 2; i++) {
            // 对于每层的操作
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                // 上 = 左
                matrix[i][j] = matrix[n - 1 - j][i];
                // 左 = 下
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j];
                // 下 = 右
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i];
                // 右 = 上
                matrix[j][n - 1 - i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}
        };
        rotate(matrix);
        ArrayUtils.print(matrix);
    }

}
