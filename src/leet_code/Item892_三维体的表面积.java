package leet_code;

/**
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 *
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 *
 * 请你返回最终形体的表面积。
 *
 * 示例 1：
 * 输入：[[2]]
 * 输出：10
 *
 * 示例 2：
 * 输入：[[1,2],[3,4]]
 * 输出：34
 *
 * 示例 3：
 * 输入：[[1,0],[0,2]]
 * 输出：16
 *
 * 示例 4：
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 *
 * 示例 5：
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 *  
 * 提示：
 *
 * 1 <= N <= 50
 * 0 <= grid[i][j] <= 50
 */
public class Item892_三维体的表面积 {

    public static int surfaceArea(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int height = grid[i][j];
                if (height != 0) {
                    count += height * 4 + 2;
                    for (int[] direction : directions) {
                        int newI = i + direction[0];
                        int newJ = j + direction[1];
                        if (newI >= 0 && newI < m && newJ >= 0 && newJ < n) {
                            count -= Math.min(height, grid[newI][newJ]);
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[][] grid = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        int res = surfaceArea(grid);
        System.out.println(res);
    }


}
