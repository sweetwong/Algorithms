package leet_code.important;

import java.util.ArrayList;
import java.util.List;

class Item51_N皇后_important {

  private int n;

  private boolean[][] board;

  private List<List<String>> res = new ArrayList<>();

  /**
   * 调用
   */
  public List<List<String>> solveNQueens(int n) {
    this.n = n;
    board = new boolean[n][n];
    backtracking(0);
    return res;
  }

  private void backtracking(int row) {
    // 终止条件, 在这里添加结果
    if (row == n) {
      addSolution();
      return;
    }

    for (int col = 0; col < n; col++) {

      if (isSafe(row, col)) {

        // 放置皇后
        board[row][col] = true;

        // 向前推进
        backtracking(row + 1);

        // 回溯
        board[row][col] = false;
      }
    }

  }

  private boolean isSafe(int row, int col) {
    int left = col - 1, right = col + 1;
    for (int i = row - 1; i >= 0; i--) {
      if (board[i][col] || (left >= 0 && board[i][left]) || (right < n && board[i][right])) {
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
        if (board[row][col]) {
          sb.append('Q');
        } else {
          sb.append('.');
        }
      }
      oneSolution.add(sb.toString());
    }
    res.add(oneSolution);
  }

}
