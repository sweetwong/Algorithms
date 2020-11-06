package leet_code;

import data_structure.array.ArrayUtils;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。
 *
 * 示例 1:
 * 输入: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * 输出: [[1,6],[8,10],[15,18]]
 * 解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
 *
 * 示例 2:
 * 输入: intervals = [[1,4],[4,5]]
 * 输出: [[1,5]]
 * 解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。
 * 注意：输入类型已于2019年4月15日更改。 请重置默认代码定义以获取新方法签名。
 *
 * 提示：
 * intervals[i][0] <= intervals[i][1]
 */
class Item56_合并区间 {

    public static int[][] merge(int[][] intervals) {
        java.util.Arrays.sort(intervals, (interval1, interval2) -> Integer.compare(interval1[0], interval2[0]));

        int mergeCount = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            // 检查是否应该合并
            if (intervals[i][1] >= intervals[i + 1][0]) {
                // 合并两个区间，使用原地算法
                intervals[i + 1][0] = Math.min(intervals[i][0], intervals[i + 1][0]);
                intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
                intervals[i] = null;
                mergeCount++;
            }
        }

        int[][] res = new int[intervals.length - mergeCount][2];
        int i = 0;
        for (int[] interval : intervals) {
            if (interval != null) {
                res[i++] = interval;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] intervals = {{2, 3}, {2, 2}, {3, 3}, {1, 3}, {5, 7}, {2, 2}, {4, 6}};
        ArrayUtils.print(merge(intervals));
    }

}
