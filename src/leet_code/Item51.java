package leet_code;

import java.util.List;

class Item51 {

  public static List<List<String>> solveNQueens(int n) {
    char[][] board = new char[n][n];
    int i = 0, j = 0;
    while (j < n) {
      if (isValid(board, i, j)) {
        i++;
        j++;
        if (i == n) i = 0;
      } else {

      }
    }
    return null;
  }

  public static boolean isValid(char[][] board, int i, int j) {
    int len = board.length;
    int left = i - 1, middle = i, right = i + 1;
    for (int k = j - 1; k >= 0; k--) {
      if ((left >= 0 && board[left][k] == 'Q') ||
        (right < len && board[right][k] == 'Q') ||
        (board[middle][k] == 'Q'))
        return false;
      left--;
      right++;
    }
    return true;
  }

}
