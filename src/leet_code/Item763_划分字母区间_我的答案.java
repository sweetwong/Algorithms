package leet_code;

import java.util.ArrayList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 * 示例：
 * 输入：S = "ababcbacadefegdehijhklij"
 * 输出：[9,7,8]
 *
 * 解释：
 * 划分结果为 "ababcbaca", "defegde", "hijhklij"。
 * 每个字母最多出现在一个片段中。
 * 像 "ababcbacadefegde", "hijhklij" 的划分是错误的，因为划分的片段数较少。
 *
 * 提示：
 * S的长度在[1, 500]之间。
 * S只包含小写字母 'a' 到 'z' 。
 */
public class Item763_划分字母区间_我的答案 {

    public static List<Integer> partitionLabels(String s) {
        List<Integer> partition = new ArrayList<>();
        int i = 0, j = 0;
        while (j < s.length()) {
            int farestLetter = findFarestLetter(s, i);
            if (farestLetter == -1 && i == j) {
                i++;
                j++;
                partition.add(i);
                continue;
            }
            if (farestLetter <= j) {
                i++;
                continue;
            }
            j = farestLetter;
        }
        List<Integer> res = new ArrayList<>();
        res.add(partition.get(0));
        for (int k = 1; k < partition.size(); k++) {
            res.add(partition.get(k) - partition.get(k - 1));
        }
        return res;
    }

    private static int findFarestLetter(String s, int start) {
        int farestLetter = -1;
        for (int i = start + 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(start)) {
                farestLetter = i;
            }
        }
        return farestLetter;
    }

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> res = partitionLabels(s);
        System.out.println(res);
    }

}
