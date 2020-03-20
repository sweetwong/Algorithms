package leet_code;

// todo 优化这个深度优先搜索
class Item695_岛屿的最大面积_DFS {

  int maxArea = 0;
  int currArea = 0;

  int m;
  int n;

  public int maxAreaOfIsland(int[][] grid) {
    m = grid.length;
    n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        currArea = 0;
        dfs(grid, i, j);
      }
    }
    return maxArea;
  }

  public void dfs(int[][] grid, int i, int j) {
    if (i < 0 || i >= m || j < 0 || j >= n) return;

    if (grid[i][j] == 1) {
      grid[i][j] = 0;
      maxArea = Math.max(maxArea, ++currArea);
      dfs(grid, i - 1, j);
      dfs(grid, i + 1, j);
      dfs(grid, i, j - 1);
      dfs(grid, i, j + 1);
    }

  }

}
