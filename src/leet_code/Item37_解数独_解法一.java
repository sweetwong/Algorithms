package leet_code;

import data_structure.array.ArrayUtils;

/**
 * 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 *
 * 一个数独。
 *
 * 答案被标成红色。
 *
 * Note:
 *
 * 给定的数独序列只包含数字 1-9 和字符 '.' 。
 * 你可以假设给定的数独只有唯一解。
 * 给定数独永远是 9x9 形式的。
 *
 * TODO 学会这道题
 */
public class Item37_解数独_解法一 {

    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) return;
        boolean[][] row = new boolean[9][9], col = new boolean[9][9], box = new boolean[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') continue;
                int num = board[i][j] - '1', k = (i / 3) * 3 + j / 3;
                row[i][num] = col[j][num] = box[k][num] = true;
            }
        }
        solveSudokuHelper(board, 0, row, col, box);
    }

    private boolean solveSudokuHelper(char[][] board, int n, boolean[][] row, boolean[][] col, boolean[][] box) {
        if (n == 81) return true;
        int i = n / 9, j = n % 9;
        if (board[i][j] != '.') return solveSudokuHelper(board, n + 1, row, col, box);

        int k = (i / 3) * 3 + j / 3;
        for (int num = 0; num < 9; num++) {
            if (row[i][num] || col[j][num] || box[k][num]) {
                continue;
            }
            board[i][j] = (char) (num + '1');
            row[i][num] = col[j][num] = box[k][num] = true;
            if (solveSudokuHelper(board, n + 1, row, col, box)) {
                return true;
            }
            row[i][num] = col[j][num] = box[k][num] = false;
        }
        board[i][j] = '.';
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Item37_解数独_解法一().solveSudoku(board);
        ArrayUtils.print(board);
    }

}
