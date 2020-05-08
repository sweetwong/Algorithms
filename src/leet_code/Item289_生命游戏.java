package leet_code;

import util.array.ArrayUtils;

class Item289_生命游戏 {


    public static void gameOfLife(int[][] board) {
        int m = board.length;
        if (m == 0) return;
        int n = board[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
        int DEATH = 0;
        int LIVE = 1;
        int DEATH_TO_DEATH = 2;
        int DEATH_TO_LIVE = 3;
        int LIVE_TO_DEATH = 4;
        int LIVE_TO_LIVE = 5;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int count = 0;
                for (int[] direction : directions) {
                    int newI = i + direction[0];
                    int newJ = j + direction[1];
                    if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                        if (board[newI][newJ] == LIVE || board[newI][newJ] == LIVE_TO_DEATH || board[newI][newJ] == LIVE_TO_LIVE) {
                            count++;
                        }
                    }
                }
                if (board[i][j] == LIVE) {
                    board[i][j] = count == 2 || count == 3 ? LIVE_TO_LIVE : LIVE_TO_DEATH;
                } else {
                    board[i][j] = count == 3 ? DEATH_TO_LIVE : DEATH_TO_DEATH;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] == DEATH_TO_LIVE || board[i][j] == LIVE_TO_LIVE ? LIVE : DEATH;
            }
        }
    }

    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(board);
    }
}
