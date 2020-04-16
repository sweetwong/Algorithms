package leet_code.important;

import util.array.ArrayUtils;
import util.other.Time;

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
        // 这个相当于出栈后再做判断
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;
        int num = 1;
        // 这样就不用写4次, 因为有时候, 不止4个方向, 可能是n个方向(图)
        for (int[] direction : directions) {
            // 入栈前没有做任何判断, 直接入栈
            num += dfs(grid, directions, m, n, i + direction[0], j + direction[1]);
        }
        return num;
    }

}
