package leet_code;

import java.util.ArrayDeque;
import java.util.Queue;

class Item994_腐烂的橘子_BFS {

  public int orangesRotting(int[][] grid) {
    int m = grid.length;
    int n = grid[0].length;
    if (m == 1 && n == 1 && grid[0][0] == 0) return 0;

    Queue<Integer> queue = new ArrayDeque<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 2) queue.offer(i * 10 + j);
      }
    }

    int minute = 0;
    while (!queue.isEmpty()) {
      int levelLen = queue.size();
      for (int k = 0; k < levelLen; k++) {
        int id = queue.poll();
        int i = id / 10;
        int j = id % 10;

        if (i - 1 >= 0) rot(grid, queue, i - 1, j);
        if (j - 1 >= 0) rot(grid, queue, i, j - 1);
        if (i + 1 < m) rot(grid, queue, i + 1, j);
        if (j + 1 < n) rot(grid, queue, i, j + 1);
      }

      minute++;
    }

    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (grid[i][j] == 1) return -1;
      }
    }

    return minute - 1;
  }

  private void rot(int[][] grid, Queue<Integer> queue, int i, int j) {
    if (grid[i][j] == 1) {
      queue.offer(i * 10 + j);
      grid[i][j] = 2;
    }
  }

}
