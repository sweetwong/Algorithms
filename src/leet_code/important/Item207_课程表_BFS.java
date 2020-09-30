package leet_code.important;

import data_structure.array.Arrays;
import data_structure.graph.Graphs;

import java.util.*;

/**
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 *
 * 示例 1:
 * 输入: 2, [[1,0]]
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 *
 * 示例 2:
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 *
 * 提示：
 * 1. 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 2. 你可以假定输入的先决条件中没有重复的边。
 * 3. 1 <= numCourses <= 10^5
 *
 * 答案：
 * https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
 *
 * 这一题用到了几个重要的概念：
 * 1. 边的数组 转 邻接表
 * 2. 入度
 * 3. BFS拓扑排序
 */
class Item207_课程表_BFS {

    // 注意prerequisites使用边的数组, 而不是邻接矩阵, 注意区分
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // 入度（表示当前节点的依赖）
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

        // Debug
        Graphs.print(adj);
        Arrays.print(indegrees);
        // Debug

        // 从此处开始BFS拓扑排序
        // 这是个起点队列, 只有当前的起点能够入队
        Queue<Integer> queue = new ArrayDeque<>();
        // 入度为0的节点入队, 入度为0说明它没有依赖, 可以是起点
        for (int i = 0; i < numCourses; i++) {
            if (indegrees[i] == 0) {
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int prev = queue.poll();
            // do something here
            // 因为在这里已经没有任何依赖了, 可以做为起点, 处理相对应的事件
            // 例如: 在启动优化中, 这里可以启动对应的Task
            System.out.println(prev);
            for (int curr : adj.get(prev)) {
                if (--indegrees[curr] == 0) {
                    queue.offer(curr);
                }
            }
            // 每一轮循环处理一个节点(一门课)
            numCourses--;
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
