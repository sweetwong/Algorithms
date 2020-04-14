package leet_code;

import util.array.ArrayUtils;

class Item59_螺旋矩阵II {

    public static void main(String[] args) {
        int[][] matrix = generateMatrix(4);
        ArrayUtils.printMatrix(matrix);
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int maxNum = n * n;

        int num = 1, top = 0, bottom = n - 1, left = 0, right = n - 1;

        while (num <= maxNum) {

            for (int col = left; col <= right; col++) matrix[top][col] = num++;
            for (int row = top + 1; row <= bottom; row++) matrix[row][right] = num++;
            for (int col = right - 1; col >= left; col--) matrix[bottom][col] = num++;
            for (int row = bottom - 1; row >= top + 1; row--) matrix[row][left] = num++;

            top++;
            bottom--;
            left++;
            right--;
        }

        return matrix;
    }

}
