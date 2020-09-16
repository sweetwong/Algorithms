package leet_code.important;

class Item695_岛屿的最大面积_DFS {

    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int maxArea = 0;
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, directions, m, n, i, j));
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int[][] directions, int m, int n, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        int num = 1;
        for (int[] direction : directions) {
            num += dfs(grid, directions, m, n, i + direction[0], j + direction[1]);
        }
        return num;
    }

}
