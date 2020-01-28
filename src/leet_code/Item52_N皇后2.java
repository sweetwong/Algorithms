package leet_code;

class Item52_N皇后2 {

  private int n;

  private int total = 0;

  private boolean[][] board;

  /**
   * 调用
   */
  public int totalNQueens(int n) {
    this.n = n;
    board = new boolean[n][n];
    backtracking(0);
    return total;
  }

  private void backtracking(int row) {
    // 终止条件, 在这里添加结果
    if (row == n) {
      total++;
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

}
