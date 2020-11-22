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

        // 记录所有节点的入度
        int[] indegrees = new int[n];
        for (List<Integer> list : adj) {
            for (int v : list) {
                indegrees[v]++;
            }
        }

        // 第一次入队，只入队入度为0的节点
        // 如果0个入队，说明全是环形节点
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }

        int count = n;
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : adj.get(v)) {
                // 从v遍历到w，w的入度减一
                indegrees[w]--;
                // 减完之后如果入度为0，就入队
                if (indegrees[w] == 0) {
                    queue.offer(w);
                }
            }
            // 每poll一个节点说明遍历了一个节点
            count--;
        }

        return count != 0;
    }

    public static boolean hasCycleDFS(List<List<Integer>> adj) {
        int n = adj.size();

        boolean[] visited = new boolean[n];
        boolean[] recStack = new boolean[n];

        for (int v = 0; v < n; v++) {
            if (dfs(adj, visited, recStack, v)) {
                return true;
            }
        }

        return false;
    }

    private static boolean dfs(List<List<Integer>> adj, boolean[] visited, boolean[] recStack, int v) {
        // 遍历到已经记录在记录栈中的节点，说明重复了
        if (recStack[v]) {
            return true;
        }
        if (visited[v]) {
            return false;
        }

        visited[v] = true;
        recStack[v] = true;

        for (int w : adj.get(v)) {
            // 也可以在这里判断 visited
            if (dfs(adj, visited, recStack, w)) {
                return true;
            }
        }

        // 遍历完之后，从记录栈中移除
        recStack[v] = false;

        return false;
    }


    public static void main(String[] args) {
        List<List<Integer>> adj = Lists.newArrayList(new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        adj.get(0).add(1);
        adj.get(0).add(2);
        adj.get(1).add(2);
        adj.get(2).add(1);

        System.out.println(hasCycleDFS(adj));
    }

}
