package data_structure.graph.algorithm;

import com.google.common.collect.Lists;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Traversal {

    public static List<Integer> traversalDFS(List<List<Integer>> adj) {
        int n = adj.size();
        List<Integer> res = new ArrayList<>();
        boolean[] visited = new boolean[adj.size()];
        for (int i = 0; i < n; i++) {
            dfs(adj, visited, i);
        }
        return res;
    }

    private static void dfs(List<List<Integer>> adj, boolean[] visited, int v) {
        if (visited[v]) {
            return;
        }

        visited[v] = true;

        for (int w : adj.get(v)) {
            dfs(adj, visited, w);
        }
    }

    public static List<Integer> traversalBFS(List<List<Integer>> adj) {
        List<Integer> res = new ArrayList<>();
        Queue<Integer> queue = new ArrayDeque<>();
        return res;
    }


    public static void main(String[] args) {
        List<List<Integer>> adj = Lists.newArrayList(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
    }

}
