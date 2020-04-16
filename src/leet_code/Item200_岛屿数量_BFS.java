package leet_code;

import java.util.ArrayDeque;
import java.util.Queue;

class Item200_岛屿数量_BFS {

    private static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    // todo
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int height = grid.length;
        int width = grid[0].length;
        int count = 0;

        for (int r = 0; r < height; ++r) {
            for (int c = 0; c < width; ++c) {
                if (grid[r][c] == '1') {
                    count++;
                    grid[r][c] = '0';
                    Queue<Node> neighbors = new ArrayDeque<>();
                    neighbors.offer(new Node(r, c));
                    while (!neighbors.isEmpty()) {
                        Node curr = neighbors.poll();
                        int row = curr.row;
                        int col = curr.col;
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.offer(new Node(row - 1, col));
                            grid[row - 1][col] = '0';
                        }
                        if (row + 1 < height && grid[row + 1][col] == '1') {
                            neighbors.offer(new Node(row + 1, col));
                            grid[row + 1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.offer(new Node(row, col - 1));
                            grid[row][col - 1] = '0';
                        }
                        if (col + 1 < width && grid[row][col + 1] == '1') {
                            neighbors.offer(new Node(row, col + 1));
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }

        return count;
    }

}
