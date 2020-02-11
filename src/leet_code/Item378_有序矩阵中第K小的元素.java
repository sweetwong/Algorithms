package leet_code;

class Item378_有序矩阵中第K小的元素 {

  class Solution {

    // todo 这个是答案, 还要看下过程
    public int kthSmallest(int[][] matrix, int k) {
      int height = matrix.length;
      int width = matrix[0].length;
      int lo = matrix[0][0];
      int hi = matrix[height - 1][width - 1];
      while (lo < hi) {
        // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
        int mid = (lo + hi) / 2;
        // 找二维矩阵中<=mid的元素总个数
        int count = findNotBiggerThanMid(matrix, mid, height, width);
        if (count < k) {
          // 第k小的数在右半部分，且不包含mid
          lo = mid + 1;
        } else {
          // 第k小的数在左半部分，可能包含mid
          hi = mid;
        }
      }
      return hi;
    }

    private int findNotBiggerThanMid(int[][] matrix, int mid, int height, int width) {
      // 以列为单位找，找到每一列最后一个<=mid的数即知道每一列有多少个数<=mid
      int row = height - 1;
      int col = 0;
      int count = 0;
      while (row >= 0 && col < width) {
        if (matrix[row][col] <= mid) {
          // 第j列有i+1个元素<=mid
          count += row + 1;
          col++;
        } else {
          // 第j列目前的数大于mid，需要继续在当前列往上找
          row--;
        }
      }
      return count;
    }

  }

}
