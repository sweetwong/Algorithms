package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.array.ArrayUtils;

class Item54_螺旋矩阵 {

  public static List<Integer> spiralOrder(int[][] matrix) {

    List<Integer> res = new ArrayList<>();

    int m = matrix.length;
    if (m == 0) return res;
    int n = matrix[0].length;
    if (n == 0) return res;

    int len = m * n;

    int i = 0, top = 0, bottom = m - 1, left = 0, right = n - 1;

    while (i < len) {

      for (int col = left; col <= right && i < len; col++) {
        res.add(matrix[top][col]);
        i++;
      }

      for (int row = top + 1; row <= bottom && i < len; row++) {
        res.add(matrix[row][right]);
        i++;
      }

      for (int col = right - 1; col >= left && i < len; col--) {
        res.add(matrix[bottom][col]);
        i++;
      }

      for (int row = bottom - 1; row >= top + 1 && i < len; row--) {
        res.add(matrix[row][left]);
        i++;
      }

      top++;
      bottom--;
      left++;
      right--;
    }

    return res;
  }

}
