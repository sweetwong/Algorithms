package leet_code.important;

import data_structure.array.Arrays;
import data_structure.other.Time;

/**
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 *
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * @see leet_code.important.Item739_每日温度
 */
public class Item739_每日温度_暴力法 {

    public static int[] dailyTemperatures(int[] T) {
        int n = T.length;
        int[] res = new int[n];
        for (int i = 0; i < n - 1; i++) {
            int curr = T[i], count = 1, j = i + 1;
            while (j < n) {
                if (T[j] > curr) {
                    res[i] = count;
                    break;
                }
                count++;
                j++;
            }
        }
        res[n - 1] = 0;
        return res;
    }

    public static void main(String[] args) {
        int[] temperatures = Arrays.createRandomArray(500000, 30, 100, false);
        // 暴力法的耗时很高
        Time.watch(() -> dailyTemperatures(temperatures));
    }


}
