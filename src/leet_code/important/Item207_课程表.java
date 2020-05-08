package leet_code.important;

import util.array.ArrayUtils;
import util.graph.GraphUtils;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
 */
class Item207_课程表 {

    // 注意prerequisites使用边的列表, 而不是邻接矩阵, 注意区分
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度
        int[] indegrees = new int[numCourses];
        // 邻接表
        List<List<Integer>> adj = new ArrayList<>();
        // 预创空邻接表
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        // 得到邻接表和入度
        // 注意, 此题应该是cp[1]指向cp[0], 即只有学了cp[1]才能学cp[0]
        for (int[] cp : prerequisites) {
            indegrees[cp[0]]++;
            adj.get(cp[1]).add(cp[0]);
        }
        GraphUtils.printAdj(adj);
        ArrayUtils.printArray(indegrees);

        // 从此处开始BFS拓扑排序
        Queue<Integer> queue = new LinkedList<>();
        // 入度为0的节点入队
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) queue.add(i);
        }
        // todo 理解这个拓扑排序
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
