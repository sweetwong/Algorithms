package leet_code;

class Item378_有序矩阵中第K小的元素 {

  class Solution {

    public int kthSmallest(int[][] matrix, int k) {
      int m = matrix.length;
      int n = matrix[0].length;

      int loVal = matrix[0][0];
      int hiVal = matrix[m - 1][n - 1];
      while (loVal < hiVal) {
        // 每次循环都保证第K小的数在start~end之间，当start==end，第k小的数就是start
        int mid = (loVal + hiVal) / 2;
        // 找二维矩阵中<=mid的元素总个数
        int count = findNotBiggerThanMid(matrix, mid, m, n);
        if (count < k) {
          // 第k小的数在右半部分，且不包含mid
          loVal = mid + 1;
        } else {
          // 第k小的数在左半部分，可能包含mid
          hiVal = mid;
        }
      }
      return hiVal;
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

  }

}
