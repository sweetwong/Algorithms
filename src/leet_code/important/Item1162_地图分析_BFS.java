package leet_code.important;

import java.util.ArrayDeque;
import java.util.Queue;

class Item1162_地图分析_BFS {

  public int maxDistance(int[][] grid) {
    // BFS用这个记住
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    int n = grid.length;

    Queue<Integer> queue = new ArrayDeque<>();
    for (int r = 0; r < n; r++) {
      for (int c = 0; c < n; c++) {
        if (grid[r][c] == 1)
          queue.offer(r * n + c);
      }
    }

    // 拦截全部为0或者全部为1的情况
    int size = queue.size();
    if (size == 0 || size == n * n) return -1;

    int distance = 0;
    while (!queue.isEmpty()) {
      // 每次都搜完队列,作为一个层级
      for (int i = 0, currSize = queue.size(); i < currSize; i++) {
        int id = queue.poll();
        int currR = id / n;
        int currC = id % n;
        // 四个方向的搜索操作可以简化成这样,而不是一个个列出来
        for (int[] direction : directions) {
          int newR = currR + direction[0];
          int newC = currC + direction[1];
          // 在这里判断,只有符合操作的才入队
          if (newR >= 0 && newR < n && newC >= 0 && newC < n
            && grid[newR][newC] == 0) {
            // 在这个地方变成1,写在前面会报错
            grid[newR][newC] = 1;
            queue.offer(newR * n + newC);
          }
        }
      }
      distance++;
    }
    return distance - 1;
  }

}