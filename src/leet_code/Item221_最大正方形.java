package leet_code;

/**
 * 在一个由 0 和 1 组成的二维矩阵内，找到只包含 1 的最大正方形，并返回其面积。
 *
 * 示例:
 *
 * 输入:
 *
 * 1 0 1 0 0
 * 1 0 1 1 1
 * 1 1 1 1 1
 * 1 0 0 1 0
 *
 * 输出: 4
 *
 * TODO 用动态规划完成这道题
 */
public class Item221_最大正方形 {

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) return 0;
        int n = matrix[0].length;
        if (n == 0) return 0;

        int maximalSquare = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    maximalSquare = Math.max(maximalSquare, spread(matrix, m, n, i, j));
                }
            }
        }
        return maximalSquare;
    }

    private static int spread(char[][] matrix, int m, int n, int beginI, int beginJ) {
        int count = 1;
        int endI = beginI;
        int endJ = beginJ;

        boolean stop = false;
        while (++endI < m && ++endJ < n) {
            if (stop) {
                break;
            }
            stop = false;
            for (int i = beginI; i <= endI; i++) {
                if (matrix[i][endJ] == '0') {
                    stop = true;
                    break;
                }
            }
            if (!stop) {
                for (int j = beginJ; j <= endJ; j++) {
                    if (matrix[endI][j] == '0') {
                        stop = true;
                        break;
                    }
                }
            }
            if (!stop) {
                count += endI - beginI + endJ - beginJ + 1;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'0','0','0','1'},
                {'1','1','0','1'},
                {'1','1','1','1'},
                {'0','1','1','1'},
                {'0','1','1','1'}
        };
        System.out.println(maximalSquare(matrix));
    }

}
