package data_structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TopologicalSortDFS {

    /**
     * 注意，digraph必须是一个有向无环图（DAG）
     */
    public static List<Integer> sort(List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();

        int n = adj.size();

        boolean[] visited = new boolean[n];
        Arrays.fill(visited, false);

        // 拓扑排序需要遍历所有节点
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(adj, visited, res, i);
            }
        }

        Collections.reverse(res);

        return res;
    }

    private static void dfs(List<List<Integer>> adj, boolean[] visited,
                            List<Integer> res, int v) {
        visited[v] = true;
        for (int i : adj.get(v)) {
            if (!visited[i]) {
                dfs(adj, visited, res, i);
            }
        }
        res.add(v);
    }

    /**
     * https://visualgo.net/en/dfsbfs
     */
    public static void main(String[] args) {
        Digraph g = new Digraph(8);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(1, 3);
        g.addEdge(2, 3);
        g.addEdge(2, 5);
        g.addEdge(3, 4);
        g.addEdge(7, 6);

    }

}
