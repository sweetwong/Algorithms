package data_structure.graph.algorithm;

import java.util.*;

/**
 * 拓扑排序是基于BFS或者DFS，遍历的过程加入结果
 */
public class TopologicalSort {

    public static List<Integer> sortBFS(List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();

        int n = adj.size();

        int[] indegrees = new int[n];
        for (List<Integer> list : adj) {
            for (int v : list) {
                indegrees[v]++;
            }
        }

        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int v = queue.poll();
            res.add(v);
            for (int w : adj.get(v)) {
                if (--indegrees[w] == 0) {
                    queue.offer(w);
                }
            }
        }

        return res;
    }

    /**
     * 注意，digraph必须是一个有向无环图（DAG）
     */
    public static List<Integer> sortDFS(List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();

        int n = adj.size();

        boolean[] visited = new boolean[n];

        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                dfs(adj, visited, res, v);
            }
        }

        Collections.reverse(res);

        return res;
    }

    private static void dfs(List<List<Integer>> adj, boolean[] visited,
                            List<Integer> res, int v) {
        visited[v] = true;
        // 此处是前序
        // res.add(v);
        for (int w : adj.get(v)) {
            if (!visited[w]) {
                dfs(adj, visited, res, w);
            }
        }
        // 此处是后序
        res.add(v);
    }

    public static void main(String[] args) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            adj.add(new ArrayList<>());
        }
        adj.get(0).add(1);
        adj.get(1).add(2);
        adj.get(2).add(3);
        adj.get(4).add(5);
        adj.get(5).add(2);

        System.out.println(sortDFS(adj));
        System.out.println(sortBFS(adj));
    }

}
