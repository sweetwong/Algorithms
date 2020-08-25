package data_structure.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class TopologicalSort {

    /**
     * 注意，digraph必须是一个有向无环图（DAG）
     */
    public static List<Integer> sort(Digraph digraph) {
        List<Integer> res = new ArrayList<>();

        int V = digraph.getV();
        List<List<Integer>> adj = digraph.getAdj();

        boolean[] visited = new boolean[V];
        Arrays.fill(visited, false);

        // 拓扑排序需要遍历所有节点
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(adj, i, visited, res);
            }
        }

        Collections.reverse(res);

        return res;
    }

    /**
     * @param adj 邻接表
     * @param v 当前的节点
     * @param visited 记录状态
     * @param res 结果
     */
    private static void dfs(List<List<Integer>> adj, int v,
                            boolean[] visited, List<Integer> res) {
        visited[v] = true;
        for (int i : adj.get(v)) {
            if (!visited[i]) {
                dfs(adj, i, visited, res);
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

        List<Integer> list = TopologicalSort.sort(g);
        System.out.println(list);
    }

}
