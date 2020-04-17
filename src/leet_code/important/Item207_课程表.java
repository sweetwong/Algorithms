package leet_code.important;

import util.array.ArrayUtils;
import util.graph.GraphUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * todo 完成这个拓扑排序
 */
class Item207_课程表 {

    // 注意prerequisites使用边的列表, 而不是邻接矩阵, 注意区分
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        // 预创邻接表
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        // 得到邻接表和入度
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adj.get(cp[1]).add(cp[0]);
        }
        GraphUtils.printAdjacencyList(adj);
        ArrayUtils.printArray(indegrees);

        // Get all the courses with the indegree of 0.
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }
        // BFS TopSort.
        while (!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for (int cur : adj.get(pre)) {
                if (--indegrees[cur] == 0) queue.add(cur);
            }
        }
        return numCourses == 0;
    }

    public static void main(String[] args) {
        int[][] prerequisites = {
                {1, 0},
                {3, 0},
                {2, 1},
                {5, 4},
                {5, 3}
        };
        System.out.println(canFinish(6, prerequisites));
    }

}
