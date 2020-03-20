package leet_code;

import java.util.ArrayDeque;
import java.util.Queue;

// todo 完成这个广度优搜索
class Item695_岛屿的最大面积_BFS {

  int maxArea = 0;

  int m;
  int n;

  public int maxAreaOfIsland(int[][] grid) {
    m = grid.length;
    n = grid[0].length;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        bfs(grid, i, j);
      }
    }
    return maxArea;
  }

  public void bfs(int[][] grid, int i, int j) {
    int currArea = 0;
    Queue<Node> queue = new ArrayDeque<>();
    queue.offer(new Node(i, j));
    while (!queue.isEmpty()) {
      Node id = queue.poll();
      int x = id.x;
      int y = id.y;

      grid[x][y] = 0;
      maxArea = Math.max(maxArea, ++currArea);

      if (x - 1 >= 0 && grid[x - 1][y] == 1) queue.offer(new Node(x - 1, y));
      if (x + 1 < m && grid[x + 1][y] == 1) queue.offer(new Node(x + 1, y));
      if (y - 1 >= 0 && grid[x][y - 1] == 1) queue.offer(new Node(x, y - 1));
      if (y + 1 < n && grid[x][y + 1] == 1) queue.offer(new Node(x, y + 1));
    }
  }

  static class Node {
    int x;
    int y;

    Node(int x, int y) {
      this.x = x;
      this.y = y;
    }
  }
}
