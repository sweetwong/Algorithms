package leet_code;

import static leet_code.Item56_合并区间.merge;

class Item57_插入区间 {

    /**
     * 方法一, 利用Item56的合并区间
     */
    public static int[][] insert(int[][] intervals, int[] newInterval) {
        int[][] combination = new int[intervals.length + 1][2];
        System.arraycopy(intervals, 0, combination, 0, intervals.length);
        combination[combination.length - 1] = newInterval;
        return merge(combination);
    }

}
