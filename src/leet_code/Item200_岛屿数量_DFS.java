package leet_code;

class Item200_岛屿数量_DFS {

    private int height = 0;
    private int width = 0;

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;

        height = grid.length;
        width = grid[0].length;

        int count = 0;

        for (int row = 0; row < height; row++) {

            for (int col = 0; col < width; col++) {
                if (grid[row][col] == '1') {
                    dfs(grid, row, col);
                    count++;
                }
            }
        }

        return count;
    }

    private void dfs(char[][] grid, int row, int col) {

        if (row < 0 || col < 0 || row >= height || col >= width || grid[row][col] == '0') return;

        grid[row][col] = '0';

        dfs(grid, row - 1, col);
        dfs(grid, row + 1, col);
        dfs(grid, row, col - 1);
        dfs(grid, row, col + 1);
    }

}
