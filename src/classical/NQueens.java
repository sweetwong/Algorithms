package classical;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题
 */
class NQueens {

  private int n;

  private int[][] board;

  private List<List<String>> res = new ArrayList<>();

  public List<List<String>> solveNQueens(int n) {
    this.n = n;
    board = new int[n][n];
    backtracking(0);
    return res;
  }

  private void backtracking(int row) {
    for (int col = 0; col < n; col++) {

      if (isSafe(row, col)) {

        // 放置皇后
        board[row][col] = 1;

        if (row + 1 == n) {
          addSolution();
        } else {
          backtracking(row + 1);
        }

        // 移除皇后
        board[row][col] = 0;
      }
    }
  }


  /**
   * 此处通过记录对角线会更快
   * 不过这种通过向上遍历, 同时用3个变量来代表3个方向, 更容易理解
   */
  private boolean isSafe(int row, int col) {
    int left = col - 1, right = col + 1;
    for (int i = row - 1; i >= 0; i--) {
      if ((board[i][col] == 1) || (left >= 0 && board[i][left] == 1) || (right < n && board[i][right] == 1)) {
        return false;
      }
      left--;
      right++;
    }
    return true;
  }

  private void addSolution() {
    List<String> oneSolution = new ArrayList<>();
    for (int col = 0; col < n; col++) {
      StringBuilder sb = new StringBuilder();
      for (int row = 0; row < n; row++) {
        if (board[row][col] == 1)
          sb.append('Q');
        else
          sb.append('.');
      }
      oneSolution.add(sb.toString());
    }
    res.add(oneSolution);
  }

}