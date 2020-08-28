package data_structure.graph;

import com.google.common.collect.Lists;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class CycleDetect {

    public static boolean hasCycleBFS(List<List<Integer>> adj) {
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

        int count = n;
        while (!queue.isEmpty()) {
            int u = queue.poll();
            List<Integer> list = adj.get(u);
            for (int v : list) {
                if (--indegrees[v] == 0) {
                    queue.offer(v);
                }
            }
            count--;
        }

        return count != 0;
    }

    public static boolean hasCycleDFS(List<List<Integer>> adj) {
        int n = adj.size();

        boolean[] visited = new boolean[n];
        boolean[] onStack = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (dfs(adj, visited, onStack, i)) {
                return true;
            }
        }

        return false;
    }

    private static boolean dfs(List<List<Integer>> adj, boolean[] visited, boolean[] onStack, int u) {
        if (onStack[u]) {
            return true;
        }

        if (visited[u]) {
            return false;
        }

        visited[u] = true;
        onStack[u] = true;

        for (int v : adj.get(u)) {
            if (dfs(adj, visited, onStack, v)) {
                return true;
            }
        }

        onStack[u] = false;

        return false;
    }


    public static void main(String[] args) {
        List<List<Integer>> adj = Lists.newArrayList(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);

        System.out.println(hasCycleDFS(adj));
    }

}
