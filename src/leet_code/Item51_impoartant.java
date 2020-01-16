package leet_code;

import java.util.ArrayList;
import java.util.List;

class Item51_impoartant {

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
        board[row][col] = 1;

        if (row + 1 == n) {
          addSolution();
        } else {
          backtracking(row + 1);
        }

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
