package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import util.array.ArrayUtils;

class Item54_螺旋矩阵 {

  public static void main(String[] args) {
    int[][] matrix = {
      {1, 2},
      {4, 5},
    };
    System.out.println(spiralOrder(matrix).toString());
  }

  public static List<Integer> spiralOrder(int[][] matrix) {
    List<Integer> res = new ArrayList<>();
    if (matrix.length == 0 || matrix[0].length == 0) return res;
    helper(res, matrix, 0, 0, matrix.length, matrix[0].length);
    return res;
  }

  public static void helper(List<Integer> res, int[][] matrix, int rowStart, int colStart, int height, int width) {

    if (height == 0 || width == 0) return;

    if (height == 1) {
      for (int i = 0; i < width; i++) {
        res.add(matrix[rowStart][colStart + i]);
      }
      return;
    }

    if (width == 1) {
      for (int i = 0; i < height; i++) {
        res.add(matrix[rowStart + i][colStart]);
      }
      return;
    }

    int col = colStart, row = rowStart;

    // 右
    while (col < colStart + width) {
      res.add(matrix[row][col++]);
    }
    col--;
    row++;

    // 下
    while (row < rowStart + height) {
      res.add(matrix[row++][col]);
    }
    row--;
    col--;

    // 左
    while (col >= colStart) {
      res.add(matrix[row][col--]);
    }
    col++;
    row--;

    // 上
    while (row >= rowStart + 1) {
      res.add(matrix[row--][col]);
    }
    row++;

    helper(res, matrix, rowStart + 1, colStart + 1, height - 2, width - 2);
  }

}
