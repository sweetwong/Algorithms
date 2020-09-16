package leet_code.important;

/**
 * 给定一个二维网格和一个单词，找出该单词是否存在于网格中。
 *
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 *
 * 示例:
 * board =
 * [
 *   ['A','B','C','E'],
 *   ['S','F','C','S'],
 *   ['A','D','E','E']
 * ]
 * 给定 word = "ABCCED", 返回 true
 * 给定 word = "SEE", 返回 true
 * 给定 word = "ABCB", 返回 false
 *
 * 提示：
 * board 和 word 中只包含大写和小写英文字母。
 * 1 <= board.length <= 200
 * 1 <= board[i].length <= 200
 * 1 <= word.length <= 10^3
 */
public class Item79_单词搜索 {

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, visited, directions, m, n, word, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, boolean[][] visited, int[][] directions, int m, int n, String word, int i, int j) {
        if (word.isEmpty() || (word.length() == 1 && board[i][j] == word.charAt(0))) {
            return true;
        }
        if (board[i][j] != word.charAt(0)) {
            return false;
        }

        visited[i][j] = true;

        for (int[] direction : directions) {
            int newI = i + direction[0];
            int newJ = j + direction[1];

            if (newI < 0 || newI >= m || newJ < 0 || newJ >= n || visited[newI][newJ]) {
                continue;
            }

            if (dfs(board, visited, directions, m, n, word.substring(1), i + direction[0], j + direction[1])) {
                return true;
            }
        }

        visited[i][j] = false;

        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A'}};
        boolean res = new Item79_单词搜索().exist(board, "A");
        System.out.println(res);
    }

}
