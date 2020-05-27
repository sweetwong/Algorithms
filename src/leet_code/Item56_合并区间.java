package leet_code;

import util.array.ArrayUtils;

import java.util.Arrays;

class Item56_合并区间 {

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int mergeCount = 0;
        for (int i = 0; i < intervals.length - 1; i++) {
            // 检查是否应该合并
            if (intervals[i][1] >= intervals[i + 1][0] && intervals[i][0] <= intervals[i + 1][1]) {
                // 合并两个区间
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
        ArrayUtils.printMatrix(merge(intervals));
    }

}
