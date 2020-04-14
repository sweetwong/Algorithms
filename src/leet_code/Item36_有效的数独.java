package leet_code;

import java.util.HashSet;

class Item36_有效的数独 {

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            if (!checkRowOrCol(board, i, true)
                    || !checkRowOrCol(board, i, false)) {
                return false;
            }
        }

        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                if (!checkGrid(board, i, j)) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean checkRowOrCol(char[][] board, int curr, boolean isRow) {
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            char c = isRow ? board[curr][i] : board[i][curr];
            if (c != '.') {
                if (set.contains(c)) {
                    return false;
                } else {
                    set.add(c);
                }
            }
        }
        return true;
    }

    public boolean checkGrid(char[][] board, int row, int col) {
        HashSet<Character> set = new HashSet<>();
        for (int i = row; i < row + 3; i++) {
            for (int j = col; j < col + 3; j++) {
                char c = board[i][j];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    } else {
                        set.add(c);
                    }
                }
            }
        }
        return true;
    }
}
