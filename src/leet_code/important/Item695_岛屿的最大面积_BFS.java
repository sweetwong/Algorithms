package leet_code.important;

import java.util.ArrayDeque;
import java.util.Queue;

class Item695_岛屿的最大面积_BFS {

    public static int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        // 此处有些情况需要判断, 可能会出现空指针异常
        int n = grid[0].length;

        int maxArea = 0;
        // 这是BFS常用的方法, 用这样来表示四个方向
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        // 这又是一个技巧, 此处有3个表示的方法:
        // 1. 利用id: 例如 int id = i * m + j, 但是用id需要对数值有限制的情况
        // 2. 利用Node: 用一个对象来包装i和j, 显然这是最低效的
        // 3. 利用int[]: 就是下面用的方法, 一般来说效率最高的是方法1, 如果无法用方法1就用这个方法
        Queue<int[]> queue = new ArrayDeque<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                queue.offer(new int[]{i, j});
                int currArea = 0;
                while (!queue.isEmpty()) {
                    // BFS最典型的是其层级, 有一些BFS需要用到level
                    for (int k = 0, size = queue.size(); k < size; k++) {
                        // 出队
                        int[] poll = queue.poll();
                        int currI = poll[0];
                        int currJ = poll[1];
                        // 这是一个出队后的判断点(这个判断点可以判断到第一次入队, 即queue.offer(new int[]{i, j});)
                        if (currI < 0 || currI >= m || currJ < 0 || currJ >= n || grid[currI][currJ] == 0) {
                            continue;
                        }
                        // 判断成功后的操作
                        currArea++;
                        grid[currI][currJ] = 0;
                        // 入队
                        for (int[] direction : directions) {
                            // 这里入队前可以有个判断点, 但是这里有个很明显的问题
                            // 就是我们第一个值入队时是没有判断的, 就是queue.offer(new int[]{i, j})这个操作
                            // 因此会导致后面有一些难以察觉的BUG
                            // 所以比较推荐, 统一在出队后判断, 这样子即使第一次入队的那个值, 也可以被判断到
                            queue.offer(new int[]{currI + direction[0], currJ + direction[1]});
                        }
                    }
                    // 此处level++
                }
                maxArea = Math.max(maxArea, currArea);
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1},
                {0, 0, 0, 1, 1}
        };

        System.out.println(maxAreaOfIsland(grid));
    }

}
