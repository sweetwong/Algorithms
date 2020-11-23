package leet_code;

import data_structure.array.ArrayUtils;

import java.util.Arrays;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对 (h, k) 表示，其中 h 是这个人的身高，k 是应该排在这个人前面且身高大于或等于 h 的人数。
 * 例如：[5,2] 表示前面应该有 2 个身高大于等于 5 的人，而 [5,0] 表示前面不应该存在身高大于等于 5 的人。
 *
 * 编写一个算法，根据每个人的身高 h 重建这个队列，使之满足每个整数对 (h, k) 中对人数 k 的要求。
 *
 * 示例：
 * 输入：[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 * 输出：[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 *
 * 提示：
 * 总人数少于 1100 人。
 *
 * s:1051 e:1121
 */
public class Item406_根据身高重建队列 {

    // [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
    public static int[][] reconstructQueue(int[][] people) {

        // [[4,4], [5,0], [5,2], [6,1], [7,0], [7,1]]
        // 按身高排序正序；如果身高相同，前面的人数按倒数排序
        Arrays.sort(people, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            } else {
                return Integer.compare(b[1], a[1]);
            }
        });

        // 插入排序
        int len = people.length;
        for (int i = len - 2; i >= 0; i--) {
            int[] curr = people[i];
            int j = i + 1;
            int shouldMove = curr[1];
            while (j < len && shouldMove > 0) {
                people[j - 1] = people[j];
                shouldMove--;
                j++;
            }
            people[j - 1] = curr;
        }
        return people;

        // 输出
        // [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
    }

    public static void main(String[] args) {
        int[][] people = {{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}};
        people = reconstructQueue(people);
        ArrayUtils.print(people);
    }

}
