package classical;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * N皇后问题
 */
public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        // 因为每一行只能放一个皇后，所以可以这样表示棋盘皇后的位置
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        backtrack(res, n, queens, 0);
        return res;
    }

    private void backtrack(List<List<String>> res, int n, int[] queens, int row) {
        // 成功到达终点
        if (row == n) {
            addSolution(res, n, queens);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isValid(n, queens, row, col)) {
                queens[row] = col;
                backtrack(res, n, queens, row + 1);
                queens[row] = -1;
            }
        }
    }

    private boolean isValid(int n, int[] queens, int row, int col) {
        // 从 左上、上、右上 个方向扩散，看看有没有皇后冲突
        for (int i = row - 1, l = col - 1, r = col + 1; i >= 0; i--, l--, r++) {
            if (queens[i] == col
                    || l >= 0 && queens[i] == l
                    || r < n && queens[i] == r) {
                return false;
            }
        }
        return true;
    }

    private void addSolution(List<List<String>> res, int n, int[] queens) {
        List<String> oneSolution = new ArrayList<>();
        for (int row = 0; row < n; row++) {
            StringBuilder builder = new StringBuilder();
            for (int col = 0; col < n; col++) {
                builder.append(col == queens[row] ? 'Q' : '.');
            }
            oneSolution.add(builder.toString());
        }
        res.add(oneSolution);
    }

    public static void main(String[] args) {
        List<List<String>> res = new NQueens().solveNQueens(4);
        System.out.println(res);
    }

}