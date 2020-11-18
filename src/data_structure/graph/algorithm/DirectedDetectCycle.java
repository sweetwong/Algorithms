package data_structure.graph.algorithm;

import com.google.common.collect.Lists;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 有向图的环检测是基于BFS或者DFS，然后加入一些额外的检测
 */
public class DirectedDetectCycle {

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
            for (int v : adj.get(u)) {
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

        for (int v = 0; v < n; v++) {
            if (dfs(adj, visited, onStack, v)) {
                return true;
            }
        }

        return false;
    }

    private static boolean dfs(List<List<Integer>> adj, boolean[] visited, boolean[] onStack, int v) {
        if (onStack[v]) {
            return true;
        }

        if (visited[v]) {
            return false;
        }

        visited[v] = true;
        onStack[v] = true;

        for (int w : adj.get(v)) {
            if (dfs(adj, visited, onStack, w)) {
                return true;
            }
        }

        onStack[v] = false;

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
