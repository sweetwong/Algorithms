package leet_code;

import java.util.ArrayList;
import java.util.List;

class Item51_N皇后_important {

  public static void main(String[] args) {
    Item51_N皇后_important a = new Item51_N皇后_important();
    a.solveNQueens(4);
  }

  private int n;

  private int[][] board;

  private List<List<String>> res = new ArrayList<>();

  public List<List<String>> solveNQueens(int n) {
    this.n = n;
    board = new int[n][n];
    backtracking(0);
    return res;
  }

  private int times = 0;

  private void backtracking(int row) {
    // 终止条件
    if (row == n) {
      addSolution();
      return;
    }

    for (int col = 0; col < n; col++) {

      if (isSafe(row, col)) {

        // 放置皇后
        board[row][col] = 1;

        // 向前推进
        backtracking(row + 1);

        // 回溯
        board[row][col] = 0;
      }
    }

  }

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
        if (board[row][col] == 1) {
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
