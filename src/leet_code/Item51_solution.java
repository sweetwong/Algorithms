package leet_code;

import java.util.ArrayList;
import java.util.List;

class Item51_solution {

  // 竖排被占登记，用于判断是否能够被竖排攻击
  int rows[]; //
  // 从左下到右上对角线, row + column = const
  int hills[];
  // 从左上到右下对角线", row - column = const
  int dales[];

  int n;
  // output
  List<List<String>> output = new ArrayList();
  // 皇后的位置
  int queens[];

  /**
   * 判断该位置是否会被攻击
   *
   * @param row
   * @param col
   * @return
   */
  public boolean isNotUnderAttack(int row, int col) {
    int res = rows[col] + hills[row - col + n - 1] + dales[row + col];
    return (res == 0) ? true : false;
  }

  /**
   * 将皇后放入该位置
   *
   * @param row
   * @param col
   */
  public void placeQueen(int row, int col) {
    queens[row] = col;   //将皇后位置放入
    rows[col] = 1;   //竖排攻击位置
    hills[row - col + n - 1] = 1;  // "从左下到右上对角线" 攻击位置
    dales[row + col] = 1;   //"从左上到右下对角线" 攻击位置
  }

  /**
   * 回溯皇后位置
   *
   * @param row
   * @param col
   */
  public void removeQueen(int row, int col) {
    queens[row] = 0;
    rows[col] = 0;
    hills[row - col + n - 1] = 0;
    dales[row + col] = 0;
  }

  /**
   * 将满足条件的皇后位置放入output中
   */
  public void addSolution() {
    List<String> solution = new ArrayList<String>();
    for (int i = 0; i < n; ++i) {
      int col = queens[i];
      StringBuilder sb = new StringBuilder();
      for (int j = 0; j < col; ++j) sb.append(".");
      sb.append("Q");
      for (int j = 0; j < n - col - 1; ++j) sb.append(".");
      solution.add(sb.toString());
    }
    output.add(solution);
  }

  public void backtrack(int row) {
    for (int col = 0; col < n; col++) {
      if (isNotUnderAttack(row, col)) {
        placeQueen(row, col);

        // 皇后数量是否满足，满足则输出
        if (row + 1 == n) addSolution();
          // 不满足则继续
        else backtrack(row + 1);

        // 回溯。
        removeQueen(row, col);
      }
    }
  }

  public List<List<String>> solveNQueens(int n) {
    this.n = n;
    rows = new int[n];
    hills = new int[2 * n - 1];
    dales = new int[2 * n - 1];
    queens = new int[n];

    backtrack(0);
    return output;
  }
}
