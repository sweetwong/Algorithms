package data_structure.graph.me.util;

import java.util.*;

public class TopologicalSort {

    public static <N> List<N> sort(DirectedGraph<N> graph) {
        // 可以输入graph，也可以输入adj，反正只需要一个adj足矣
        Map<N, Set<N>> adj = graph.adj;

        List<N> res = new ArrayList<>();

        Map<N, Boolean> visited = new HashMap<>();

        Set<N> nodes = adj.keySet();
        for (N node : nodes) {
            visited.put(node, false);
        }

        for (N node : nodes) {
            if (!visited.get(node)) {
                dfs(adj, visited, res, node);
            }
        }

        Collections.reverse(res);

        return res;
    }

    private static <N> void dfs(Map<N, Set<N>> adj, Map<N, Boolean> visited,
                                List<N> res, N currNode) {
        visited.put(currNode, true);
        Set<N> set = adj.get(currNode);
        for (N node : set) {
            if (!visited.get(node)) {
                dfs(adj, visited, res, node);
            }
        }
        res.add(currNode);
    }

}
