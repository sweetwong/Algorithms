package leet_code;

import util.array.ArrayUtils;

class Item48_旋转图像 {

  public static void main(String[] args) {
    int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
    forward(matrix, 0, 0, 2, 3);
    ArrayUtils.printMatrix(matrix);
  }

  public void rotate(int[][] matrix) {
  }

  // todo
  public static void forward(int[][] matrix, int m, int n, int step, int len) {
    int right, bottom, left, top, nextM, nextN, currVal, nextVal;

    bottom = step - (len - n - 1);
    nextM = m + bottom;
    nextN = len - 1;
    currVal = matrix[m][n];
    nextVal = matrix[nextM][nextN];
    matrix[nextM][nextN] = currVal;
    m = nextM;
    n = nextN;

    left = step - (len - m - 1);
    nextM = len - 1;
    nextN = n - left;
    currVal = nextVal;
    nextVal = matrix[nextM][nextN];
    matrix[nextM][nextN] = currVal;
    m = nextM;
    n = nextN;

    top = step - (len - n - 1);
    nextM = m - top;
    nextN = 0;
    currVal = nextVal;
    nextVal = matrix[nextM][nextN];
    matrix[nextM][nextN] = currVal;
    m = nextM;
    n = nextN;

    right = step - (len - m - 1);
    nextM = 0;
    nextN = n + right;
    currVal = nextVal;
    nextVal = matrix[nextM][nextN];
    matrix[nextM][nextN] = currVal;
    m = nextM;
    n = nextN;
  }


}
