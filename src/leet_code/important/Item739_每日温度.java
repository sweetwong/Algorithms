package leet_code.important;

import data_structure.array.Arrays;

import java.util.*;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * 解法:
 * 1. 暴力法
 * 2. 使用单调栈
 */
public class Item739_每日温度 {


    public static int[] dailyTemperatures(int[] T) {
        // 关键点: 这个栈自底向上是递减的
        // 就是说, 顶部的元素是最小的, 正是利用了这个性质
        Deque<Integer> stack = new ArrayDeque<>();
        int n = T.length;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
                int pop = stack.pop();
                res[pop] = i - pop;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = Arrays.createRandomArray(10, 30, 100, false);
        Arrays.print(temperatures);
        int[] res = dailyTemperatures(temperatures);
        Arrays.print(res);
    }


}
