package leet_code.important;

import java.util.ArrayList;
import java.util.List;

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
class Item207_课程表_DFS {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] prerequisite : prerequisites) {
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        return !detectCycle(adj);
    }

    private static boolean detectCycle(List<List<Integer>> adj) {
        int n = adj.size();

        int[] visited = new int[n];

        for (int i = 0; i < n; i++) {
            if (dfs(adj, visited, i)) {
                return true;
            }
        }

        return false;
    }

    private static boolean dfs(List<List<Integer>> adj, int[] visited, int u) {
        if (visited[u] == -1) {
            return true;
        }

        if (visited[u] == 1) {
            return false;
        }

        visited[u] = 1;

        for (int v : adj.get(u)) {
            if (dfs(adj, visited, v)) {
                return true;
            }
        }

        visited[u] = -1;

        return false;
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
